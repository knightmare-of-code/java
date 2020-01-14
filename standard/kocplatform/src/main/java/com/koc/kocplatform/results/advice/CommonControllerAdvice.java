package com.koc.kocplatform.results.advice;


import com.koc.kocplatform.results.result.constant.ResultCodeConstant;
import com.koc.kocplatform.results.result.vo.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonControllerAdvice{

    private static final Logger LOG = LoggerFactory.getLogger(CommonControllerAdvice.class);

    @Value("${info.app.name:''}")
    String serviceName;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestResponse handleException(Exception ex) {
        LOG.error("异常：", ex);
        LOG.error("服务：" + serviceName + " 抛出异常信息：" + ex.getLocalizedMessage());
        ex.printStackTrace();
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(ResultCodeConstant.RESULT_CODE_FALSE);
        restResponse.setMessage(ex.getLocalizedMessage());
        return restResponse;
    }

}
