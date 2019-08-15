package com.ecommerce.spring.cloud.microservice.server.utils;

/**
 * @ClassName ReturnData
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/15 16:32
 * @Version 1.0
 **/
public class ReturnData {
    private StatusCode statusCode;
    private String message;
    private String description;

    public ReturnData(StatusCode statusCode, String message, String description) {
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
