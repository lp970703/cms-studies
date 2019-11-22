package com.briup.cms.util;

/**
 * @program: app01
 * @description: 消息类
 * @author: charles
 * @create: 2019-03-13 20:58
 * 通过这个就可以知道swagger的状态码等等一系列的东西复制粘贴的
 * 专门写这个工具类的作用就是为了controller这个类里面返回的信息，这是个模板
 **/

public class Message<T> {
    public Message() {
    }

    public Message(Integer status, String message, T data, Long time) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.time = time;
    }

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回的数据类
     */
    private T data;

    /**
     * 时间
     */
    private Long time;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
