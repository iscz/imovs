package com.luuo.imovs.user.controller;

import com.google.common.collect.Maps;
import com.luuo.imovs.common.exception.ApiException;
import com.luuo.imovs.common.vo.ResponseResult;
import com.luuo.imovs.user.vo.requset.LoginVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Valid LoginVo loginVo) {
        HashMap<String, String> resultMap = Maps.newHashMap();
        resultMap.put("token", "");
        if (!loginVo.getPassword().equals("")) {
            throw new ApiException("xxxxxxxxxx");
        }
        return ResponseResult.success(resultMap);
    }
}
