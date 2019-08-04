package com.mall.project.exception;

import com.mall.project.domain.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * json 요청의 경우 경우 RestController로 제한하여 에러처리
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class ApiExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public ResponseEntity<Object> handleBusinessException(BusinessException e) {
        log.error("{}", e.getErr());
        Err err = e.getErr();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, err.code(), err.message());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
