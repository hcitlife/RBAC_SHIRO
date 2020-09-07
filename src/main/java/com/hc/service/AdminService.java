package com.hc.service;

import com.hc.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

public interface AdminService extends IService<Admin> {

    boolean add(Admin admin);

    boolean update(Admin admin);

    List<Admin> getAll();

    Admin getById(Integer id);

    boolean deleteById(Integer id);

    Admin getByAccount(String username);

    Set<String> getRolesByAccount(String account);

    Set<String> getAuthsByAccount(String account);
}
