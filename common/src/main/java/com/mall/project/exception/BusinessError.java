package com.mall.project.exception;

/**
 * Business 에러 메세지 정의
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
public enum BusinessError implements Err{

    NO_DATA("E000", "해당 정보를 가져올 수 없습니다.");

    private final String code;
    private final String message;

    BusinessError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
