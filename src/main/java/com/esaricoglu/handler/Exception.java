package com.esaricoglu.handler;

import java.util.Date;

public class Exception<E> {

    private String hostName;

    private String path;

    private Date timestamp;

    private E message;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public E getMessage() {
        return message;
    }

    public void setMessage(E message) {
        this.message = message;
    }
}
