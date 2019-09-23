

package com.tfx0one.modules.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录表单
 *
 */
@Data
public class RequestSysLogin {

    @NotBlank(message="用户名不能为空")
    private String username;
    @NotBlank(message="密码不能为空")
    private String password;
    private String captcha;
    private String uuid;


}
