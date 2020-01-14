package com.koc.kocplatform.results.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:
 * Description:
 * Author: yuxiaoyu
 * Date: 2019/4/3
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message, Class<?> clazz) {
        super(message);
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message);
    }

    public BusinessException(String message, Throwable cause, Class<?> clazz) {
        super(message, cause);
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message);
    }

}
