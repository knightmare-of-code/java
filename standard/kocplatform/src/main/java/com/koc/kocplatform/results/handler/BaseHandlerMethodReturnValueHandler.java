package com.koc.kocplatform.results.handler;

import com.koc.kocplatform.results.annotation.RestResponse;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class BaseHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    private RequestResponseBodyMethodProcessor target;

    public BaseHandlerMethodReturnValueHandler(RequestResponseBodyMethodProcessor target) {
        this.target = target;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        RestController restController = methodParameter.getContainingClass().getAnnotation(RestController.class);
        RestResponse restResponse =  methodParameter.getMethodAnnotation(RestResponse.class);
        ResponseBody responseBody =  methodParameter.getMethodAnnotation(ResponseBody.class);
        return restResponse != null || responseBody != null || restController != null;
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        RestResponse apiResponse = methodParameter.getMethodAnnotation(RestResponse.class);
        if(apiResponse != null){
            com.koc.kocplatform.results.result.vo.RestResponse restResponse = new com.koc.kocplatform.results.result.vo.RestResponse<>();
            restResponse.setSuccess(apiResponse.code());
            restResponse.setMessage(apiResponse.successMsg());
            restResponse.setData(o);
            this.target.handleReturnValue(restResponse, methodParameter, modelAndViewContainer, nativeWebRequest);
        }else{
            this.target.handleReturnValue(o, methodParameter, modelAndViewContainer, nativeWebRequest);
        }

    }
}
