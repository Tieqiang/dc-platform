package com.dchealth.exception.framework;

import com.dchealth.exception.DcException;

/**
 * 资源为空异常
 */
public class NullResourceException extends DcException {
    public NullResourceException() {
        this("资源不能为空！");
    }

    public NullResourceException(String message) {
        super(message);
    }
}
