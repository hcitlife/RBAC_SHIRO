package com.hc.service.impl;

import com.hc.domain.Admin;
import com.hc.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
class AdminServiceImplTest {

    @Resource
    private AdminService adminService;

    @Test
    public void add(){
        Admin admin = new Admin();
        admin.setAccount("342444444444444444444444rffffffffffffffffffffffffffcxxxxxxxxxxxxxxxxxx1");
        admin.setPassword("fdsfads");
        adminService.add(admin);
    }

    @Test
    void selectAll() {
        List<Admin> adminList = adminService.getAll();
        adminList.forEach(System.out::println);
    }

    @Test
    void deleteById() {
        boolean res = adminService.deleteById(54);
        System.out.println(res);
    }
}