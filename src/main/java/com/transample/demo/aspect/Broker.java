package com.transample.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
@Aspect
public class Broker {

    @Before("execution(public * com.transample.demo.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        // 获取参数值以及名称
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 获取参数注解
        Annotation[][] annotations = method.getParameterAnnotations();
        // 获取参数类别
        Class<?>[] classes = method.getParameterTypes();

        for (int i = 0; i < annotations.length; i++) {
            Annotation[] paramAnnotation = annotations[i];
            System.out.println(paramNames[i]);
            for (int j = 0; j < paramAnnotation.length; j++) {
                if (paramAnnotation[j].annotationType().equals(PathVariable.class)) {
                    System.out.print("PathVariable ");
                } else if (paramAnnotation[j].annotationType().equals(RequestParam.class)) {
                    System.out.print("RequestParam ");
                } else if (paramAnnotation[j].annotationType().equals(RequestBody.class)) {
                    System.out.print("RequestBody ");
                }
            }
            System.out.println();
        }
    }

}
