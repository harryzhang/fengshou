package com.kder.business.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kder.business.common.result.Result;

@ControllerAdvice
public class KderGlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
	@ResponseBody
    public Result<?> handleCustomerException(BusinessException ex) {
        return Result.failureResult(ex.getMessage());
    }

	
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<?> handleAllException(Exception ex) {
    	return Result.failureResult(ex.getMessage());
    }
}
