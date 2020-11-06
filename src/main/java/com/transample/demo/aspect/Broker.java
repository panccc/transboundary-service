package com.transample.demo.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.transample.demo.common.ResponseResult;
import com.transample.demo.constants.ServiceNetworkConstants;
import com.transample.demo.utils.ParamsUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
@Aspect
public class Broker {

    @Around("execution(public * com.transample.demo.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        // 获取http请求
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取参数值以及名称
        Object result = null;
        String methodName = joinPoint.getSignature().getName();

        System.out.println(request.getMethod()+":"+methodName);
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 获取参数注解
        Annotation[][] annotations = method.getParameterAnnotations();
        // 获取参数类别
        Class<?>[] classes = method.getParameterTypes();


        ParamsUtil paramsUtil = new ParamsUtil();
        JSONObject jsonObject = new JSONObject();

        for (int i = 0; i < annotations.length; i++) {
            Annotation[] paramAnnotation = annotations[i];
            System.out.println(paramNames[i]+":"+paramValues[i]);
            for (int j = 0; j < paramAnnotation.length; j++) {
                if (paramAnnotation[j].annotationType().equals(PathVariable.class)) {
                    System.out.println(paramAnnotation[j]);
                    paramsUtil.add(paramNames[i],paramValues[i]);
                    System.out.print("PathVariable ");
                } else if (paramAnnotation[j].annotationType().equals(RequestParam.class)) {
                    paramsUtil.add(paramNames[i],paramValues[i]);
                    System.out.print("RequestParam ");
                } else if (paramAnnotation[j].annotationType().equals(RequestBody.class)) {
                    System.out.print("RequestBody ");
                    JSONObject object = JSON.parseObject(JSON.toJSONString(paramValues[i]));
                    jsonObject.putAll(object);
                }
            }
            System.out.println();

        }

        Response res =null;
        String ans = null;
        try {
//            result = joinPoint.proceed();
            OkHttpClient httpClient =new OkHttpClient();
            String url = ServiceNetworkConstants.ADDRESS+ServiceNetworkConstants.INVOKEINTERFACE;
            MediaType mediaType= MediaType.parse("application/json; charset=utf-8");
            String interfaceId = "1515652101257-1515648412249-1604237392244";
            JSONObject invokeInterFace = new JSONObject();
            invokeInterFace.put("interfaceId",interfaceId);
            if(request.getMethod().equals("POST"))
            {
                invokeInterFace.put("requestBody",jsonObject.toJSONString());
            }else if(request.getMethod().equals("GET"))
            {
                invokeInterFace.put("params",paramsUtil.toJson());
            }
            System.out.println(invokeInterFace.toJSONString());
            okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(mediaType, invokeInterFace.toJSONString());
            res = httpClient.newCall(new Request.Builder().url(url).post(requestBody).build()).execute();
            ans = res.body().string();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ResponseEntity.ok(ResponseResult.ok(ans));
    }

}
