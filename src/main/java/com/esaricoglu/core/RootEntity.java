package com.esaricoglu.core;

public class RootEntity<T> {

    private boolean result;

    private T errorMessage;

    private T data;

    public RootEntity() {
    }

    public RootEntity(boolean result, T errorMessage, T data) {
        this.result = result;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public static <T> RootEntity<T> ok(T data) {
        RootEntity<T> rootEntity = new RootEntity<>();

        rootEntity.result = true;
        rootEntity.errorMessage = null;
        rootEntity.data = data;

        return rootEntity;
    }

    public static <T> RootEntity<T> fail(T errorMessage) {
        RootEntity<T> rootEntity = new RootEntity<>();

        rootEntity.result = false;
        rootEntity.errorMessage = errorMessage;
        rootEntity.data = null;

        return rootEntity;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public T getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(T errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
