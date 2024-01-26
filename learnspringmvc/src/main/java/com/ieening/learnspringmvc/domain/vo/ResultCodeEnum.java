package com.ieening.learnspringmvc.domain.vo;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "操作成功"),
    BadRequest(400, "无效的请求"),
    NotFound(404, "资源未找到"),
    Forbidden(403, "客户端没有访问权限"),
    MethodNotAllowed(405, "目标资源不支持"),
    InternalServerError(500, "服务器未知错误");

    private final Integer code;
    private final String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
