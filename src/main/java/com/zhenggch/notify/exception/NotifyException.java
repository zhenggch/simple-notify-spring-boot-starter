package com.zhenggch.notify.exception;

/**
 * 统一通知组件异常
 */
public class NotifyException extends RuntimeException {

    public NotifyException(String message) {
        super(message);
    }

    public NotifyException(String message, Throwable cause) {
        super(message, cause);
    }
}