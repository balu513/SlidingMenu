package com.afbb.balakrishna.playslipproj.core;

/**
 * Created by balakrishna on 22/7/15.
 */
public class Response {

    int code;
    String message;
    Object object;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
