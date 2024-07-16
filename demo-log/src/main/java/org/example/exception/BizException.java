package org.example.exception;

public class BizException extends RuntimeException {

    public BizException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        //return super.fillInStackTrace();
        return this;
    }
}
