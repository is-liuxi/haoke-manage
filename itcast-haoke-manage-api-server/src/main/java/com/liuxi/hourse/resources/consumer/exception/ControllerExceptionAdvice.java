package com.liuxi.hourse.resources.consumer.exception;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 4:36
 */
@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public String requestParameterError(HttpServletRequest request,
                                        MethodArgumentNotValidException exception) {

        return exception.getMessage();
    }
}
