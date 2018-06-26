package com.kder.business.common.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kder.business.common.result.Result;

@ControllerAdvice
public class KderGlobalExceptionHandler {

	private Logger logger = Logger.getLogger(KderGlobalExceptionHandler.class);
	
    @ExceptionHandler(BusinessException.class)
	@ResponseBody
    public Result<?> handleCustomerException(BusinessException ex) {
    	logger.error(ex);
    	System.out.println("global BusinessException");
        return Result.failureResult(ex.getMessage());
    }

	
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<?> handleAllException(Exception ex) {
    	logger.error(ex);
    	System.out.println("global exception:");
    	return Result.failureResult(ex.getMessage());
    }
}
