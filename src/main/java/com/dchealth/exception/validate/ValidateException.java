package com.dchealth.exception.validate;

import com.dchealth.exception.DcException;

/**
 * 校验异常
 */
public class ValidateException extends DcException {
    public ValidateException() {
        this("参数校验异常！");
    }

    public ValidateException(String message) {
        super(message);
    }
}
