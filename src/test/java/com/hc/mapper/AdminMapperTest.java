package com.hc.mapper;

import com.hc.domain.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

//@RunWith(SpringRunner.class) //这个可以省略(建议省略)
@SpringBootTest
public class AdminMapperTest {

    @Resource
    private AdminMapper adminMapper;

    @Test
    public void fun(){
        System.out.println(adminMapper);
        List<Admin> admins = adminMapper.selectList(null);
        admins.forEach(System.out::println);
    }

    @Test
    void findRolesByAccount() {
        Set<String> roles = adminMapper.selectRolesByAccount("admin");
        roles.forEach(System.out::println);
    }

    @Test
    void findAuthsByAccount() {
        Set<String> auths = adminMapper.selectAuthsByAccount("admin");
        auths.forEach(System.out::println);
    }
}