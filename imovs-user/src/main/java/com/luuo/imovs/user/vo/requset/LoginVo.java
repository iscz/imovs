package com.luuo.imovs.user.vo.requset;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginVo {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}
