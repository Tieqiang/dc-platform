package com.dchealth.exception.validate;

import com.dchealth.exception.BHException;

/**
 * 校验异常
 */
public class ValidateException extends BHException {
    public ValidateException() {
        this("参数校验异常！");
    }

    public ValidateException(String message) {
        super(message);
    }
}
