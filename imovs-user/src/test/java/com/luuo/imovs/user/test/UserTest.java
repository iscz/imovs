package com.luuo.imovs.user.test;

import com.luuo.imovs.user.ImovsUserApplicationTests;
import com.luuo.imovs.user.entity.AdminUser;
import com.luuo.imovs.user.mapper.AdminUserMapper;
import org.junit.Test;

import javax.annotation.Resource;

public class UserTest extends ImovsUserApplicationTests {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Test
    public void add() {
        AdminUser adminUser = new AdminUser();
        adminUser.setUserName("aaa");
        adminUser.setUserPhone("18501455555");
        adminUser.setUserPwd("aaaa");
        adminUserMapper.insert(adminUser);

    }
}
