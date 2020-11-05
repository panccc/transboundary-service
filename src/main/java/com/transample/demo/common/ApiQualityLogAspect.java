package com.transample.demo.common;/*
 * @Author: panc
 * @Date:2020/10/13 11:28*/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.transample.demo.annotation.ApiQualityLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.UUID;

/**
 * aop获取传参跟返回值 -- 支持方法维度切换
 */
@Aspect
@Component
@Slf4j
public class ApiQualityLogAspect {
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * 定义切点
     */
    @Pointcut(value = "@annotation(com.transample.demo.annotation.ApiQualityLog)")
    public void log() {

    }

    /**
     * 使用环绕通知打印日志
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        ApiQualityLog apiQualityLog = this.getMethodLog(joinPoint);
        if(apiQualityLog == null){
            Object result = joinPoint.proceed();
            return result;
        }
        UUID uuid=UUID.randomUUID();
        //拼接调用方法前的日志
        if(apiQualityLog.needPrintArgs()){
            buildBeforeLog(apiQualityLog,joinPoint,uuid);
        }
//        开始执行时间
        long startTime = System.currentTimeMillis();
        //开始执行方法
        Object result = joinPoint.proceed();
        long time = System.currentTimeMillis()-startTime;
        //拼接调用方法后的日志
        if(apiQualityLog.needReturnT()){
            buildAfterLog(apiQualityLog,result,joinPoint,time,uuid);
        }
        return result;
    }

    /**
     * 获取是否有这个注解
     * @param joinPoint
     * @return
     */
    private ApiQualityLog getMethodLog(ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        Annotation[] annotations = method.getAnnotations();
        ApiQualityLog alog = null;
        if (annotations != null && annotations.length > 0) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof ApiQualityLog) {
                    alog = (ApiQualityLog) annotation;
                }
            }
        }
        return alog;
    }

    /***
     * 构造调用方法结束后的日志
     * @param alog
     * @param result
     * @return
     */
    private String buildAfterLog(ApiQualityLog alog, Object result, ProceedingJoinPoint joinPoint,long time,UUID uuid) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String methodCompleteName = joinPoint.getSignature().getDeclaringTypeName() +"#"+method.getName();
        StringBuilder sb = new StringBuilder();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        if (alog != null) {
            String methodDesc = StringUtils.isBlank(alog.methodDesc())? methodCompleteName:alog.methodDesc();
            String returnDesc = alog.returnDesc();
            result = result == null ? "无返回值" : result;
            ResponseResult responseEntity = (ResponseResult)((ResponseEntity)result).getBody();
            String str= JSON.toJSONString(responseEntity.getIndexes());
            System.out.println(str);
            log.info( "{\"requestId\":\"{}\",\"methodDesc\":\"{}\",\"requestIp\":\"{}\",\"requestUri\":\"{}\",\"result\":{},\"indexes\":{},\"execTime\":\"{}\"}",
                    uuid,
                    alog.methodDesc(),
                    request.getRemoteAddr(),
                    request.getRequestURI(),
                    JSON.toJSONString(responseEntity),
                    str,
                    time);
        }
        return sb.toString();
    }

    /**
     * 构造调用方法前的日志
     * @param alog
     * @param joinPoint
     * @return
     */
    private String buildBeforeLog(ApiQualityLog alog, ProceedingJoinPoint joinPoint,UUID uuid) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        StringBuilder sb = new StringBuilder();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        if (alog != null) {
            Parameter[] parameters = method.getParameters();
            String[] paramNames = buildParamNames(parameters);
            String[] paramDescS = alog.paramsDesc().length > 0 ? alog.paramsDesc() : paramNames;
            String target = targetClass.getName() + "#" + method.getName();
            String params = JSONObject.toJSONStringWithDateFormat(joinPoint.getArgs(), dateFormat, SerializerFeature.WriteMapNullValue);

            log.info("{\"requestId\":\"{}\",\"methodDesc\":\"{}\",\"requestIp\":\"{}\",\"requestUri\":\"{}\",\"target\":\"{}\",\"params\":{}}",
                    uuid,
                    alog.methodDesc(),
                    request.getRemoteAddr(),
                    request.getRequestURI(),
                    target,
                    params);

        }

        return sb.toString();
    }

    private String[] buildParamNames(Parameter[] parameters) {
        String[] parmers = new String[parameters.length];
        if(parameters.length > 0){
            for (int i = 0 ; i<parameters.length ; i++){
                parmers[i] = parameters[i].getName();
            }
        }
        return parmers;
    }

}
