package com.alcor.tobacco.exception;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.response.BaseResponse;
import com.alcor.tobacco.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author guchun
 * @description 全局异常处理类
 * @date 2022/4/29 17:51
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e) {
        log.error("businessException: " + e.getMessage(), e);
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return ResultUtils.error(ResCodeEnum.SYSTEM_ERROR, e.getMessage(), "");
    }

}
