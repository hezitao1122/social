package com.zeryts.c2c.common.core.enums;

/**
 * @description: 返回结果的封装
 * @title: ResultCode
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 16:04
 */
public enum ResultCode {

    SUC(200,"suc"),
    NOTFOUNT(404,"not found"),

    ERROR(500,"error");


    private Integer key;

    private String value;

    ResultCode(Integer key , String value){
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
