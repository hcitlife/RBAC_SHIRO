package com.hc;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RbacShiroApplicationTests {

    //生成盐值，密码加密
    public static void main(String[] args) {
        String salt = RandomStringUtils.randomNumeric(8);
        Md5Hash md5Hash = new Md5Hash("1234", salt);//md5加密一次
        System.out.println(salt);
        System.out.println(md5Hash);
    }
    @Test
    void contextLoads() {
    }

}
