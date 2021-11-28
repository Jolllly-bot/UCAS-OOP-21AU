package com.example.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView ExceptionHandler(HttpServletRequest request, Exception exc) throws Exception {
        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(),exc);

        if (AnnotationUtils.findAnnotation(exc.getClass(), ResponseStatus.class) != null) {
            throw exc;
        }

        ModelAndView mnv = new ModelAndView();
        mnv.addObject("url",request.getRequestURL());
        mnv.addObject("exception",exc);
        mnv.addObject("message", exc.getMessage());
        mnv.setViewName("error/error");
        return mnv;
    }
}
