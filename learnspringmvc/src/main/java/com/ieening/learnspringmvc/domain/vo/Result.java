package com.ieening.learnspringmvc.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA 2021.
 *
 * @Author: Mr Qin
 * @Date: 2023/11/30/10:50
 * @Description: 统一返回对象R
 */
@Data
public class Result<T> implements Serializable {
    // 返回码
    private Integer code;

    // 返回说明
    private String msg;

    // 返回数据
    private T data;

    /**
     * 自定义响应码与提示信息构造器
     * 
     * @param code 响应码
     * @param msg  提示消息
     */
    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 自定义响应码与提示信息、数据返回构造器
     * 
     * @param code 响应码
     * @param msg  提示消息
     * @param data 返回数据
     */
    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功构造器 无返回数据
     * 
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }

    /**
     * 成功构造器 有返回数据
     * 
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 失败构造器 无返回数据
     * 
     * @param <T>
     * @return
     */
    public static <T> Result<T> error() {
        return new Result<>(ResultCodeEnum.NotFound.getCode(), ResultCodeEnum.NotFound.getMsg());
    }

    /**
     * 失败构造器 自定义构造信息 无返回数据
     * 
     * @param msg 提示信息
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg) {
        return new Result<>(ResultCodeEnum.NotFound.getCode(), msg);
    }

    /**
     * 失败构造器 有返回数据
     * 
     * @param data 返回数据
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(T data) {
        return new Result<>(ResultCodeEnum.NotFound.getCode(), ResultCodeEnum.NotFound.getMsg(), data);
    }
}
