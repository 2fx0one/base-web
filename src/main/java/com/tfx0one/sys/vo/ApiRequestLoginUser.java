package com.tfx0one.sys.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
 * @Auth 2fx0one
 * 24/1/2019 22:10
 */
@ApiModel("登录信息")
@Data
public class ApiRequestLoginUser {
    @ApiModelProperty(value = "用户名", required = true, position = 1) //required = false 前台显示为可选 optional
    private String username;

    @ApiModelProperty(value = "密码", required = true, position = 2)
    private String password;
}
