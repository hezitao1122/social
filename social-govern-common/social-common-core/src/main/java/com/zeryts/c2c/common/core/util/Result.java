package com.zeryts.c2c.common.core.util;

import com.zeryts.c2c.common.core.enums.ResultCode;

/**
 * @description: 返回封装报文的工具类
 * @title: Result
 * @projectName: c2c-social-govern
 * @author: zeryts
 * @date: 2020/11/29 16:01
 */
public class Result<T> {

    private int code = 200;


    private String msg;
    private T data;

    public Result(){
        this.code = ResultCode.SUC.getKey();
        this.msg = ResultCode.SUC.getValue();
    }
    public Result(T t){
        this.code = ResultCode.SUC.getKey();
        this.msg = ResultCode.SUC.getValue();
        this.data = t;
    }

    public Result suc(){
        this.code = ResultCode.SUC.getKey();
        this.msg = ResultCode.SUC.getValue();
        return this;
    }
    public Result setData(T data){
        this.data = data;
        return this;
    }

    public Result<T> err(ResultCode resultCode){
        this.code  = resultCode.getKey();
        this.msg = resultCode.getValue();
        return this;
    }



}
