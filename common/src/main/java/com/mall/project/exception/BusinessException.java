package com.mall.project.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BusinessException extends RuntimeException {
    private Err err;

    public BusinessException(Err err) {
        this.err = err;
    }
}