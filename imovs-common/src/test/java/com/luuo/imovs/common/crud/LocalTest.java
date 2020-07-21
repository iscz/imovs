package com.luuo.imovs.common.crud;

import org.junit.Test;

public class LocalTest {

    @Test
    public void getProjectPath() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
    }
}
