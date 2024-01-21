package com.ieening.learnspringmvc.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> Result<?> success(T data) {
        return new Result<T>(200, "success", data);
    }

    public static <T> Result<?> success() {
        return new Result<T>(200, "success", null);
    }

}
