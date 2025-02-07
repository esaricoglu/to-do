package com.esaricoglu.core;

public class RootEntity<T> {

    private boolean result;

    private String errorMessage;

    private T data;

    public RootEntity() {
    }

    public RootEntity(boolean result, String errorMessage, T data) {
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

    public static <T> RootEntity<T> fail(String errorMessage) {
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
