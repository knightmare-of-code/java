package com.koc.kocplatform.results.annotation;

import com.koc.kocplatform.results.result.constant.ResultCodeConstant;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestResponse {

    String successMsg() default "";

    boolean code() default ResultCodeConstant.RESULT_CODE_TRUE;

}
