package com.mall.project.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Setter
@Getter
public class BusinessException extends RuntimeException {
    private Err err;
    public BusinessException(Err err) {
        this.err = err;
    }
}