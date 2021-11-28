package com.example.blog.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.blog.web.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        RequestLog rl = new RequestLog(ip,url);
        logger.info(">> {}", rl);
    }

    @After("log()")
    public void doAfter() {
        //logger.info(">> After");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturning(Object result) {
        logger.info(">> Return: {} ", result);
    }

    private class RequestLog {
        private String ip;
        private String url;

        @Override
        public String toString() {
            return "RequestLog{" +
                    "ip='" + ip + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        public RequestLog(String ip, String url) {
            this.ip = ip;
            this.url = url;
        }
    }

}
