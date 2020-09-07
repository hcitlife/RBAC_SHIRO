package com.hc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hc.domain.Admin;
import com.hc.mapper.AdminMapper;
import com.hc.service.AdminService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public boolean add(Admin admin) {
        String password = admin.getPassword();
        String salt = RandomStringUtils.randomNumeric(8);
        admin.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(password, salt);//md5加密一次,可以通过第3个参数指定多次加密
        admin.setPassword(md5Hash.toString());
        admin.setStatus(1);
        int res = adminMapper.insert(admin);
        return res == 1 ? true : false;
    }

    @Override
    public boolean update(Admin admin) {
        int res = adminMapper.updateById(admin);
        return res == 1 ? true : false;
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> adminList = adminMapper.selectList(null);
        return adminList;
    }

    @Override
    public Admin getById(Integer id) {
        Admin admin = adminMapper.selectById(id);
        return admin;
    }

    @Override
    public boolean deleteById(Integer id) {
        int res = adminMapper.deleteById(id);
        return res == 1 ? true : false;
    }

    @Override
    public Admin getByAccount(String username) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", username);

        List<Admin> adminList = adminMapper.selectList(queryWrapper);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public Set<String> getRolesByAccount(String account) {
        Set<String> roles = adminMapper.selectRolesByAccount(account);
        return roles;
    }

    @Override
    public Set<String> getAuthsByAccount(String account) {
        Set<String> auths = adminMapper.selectAuthsByAccount(account);
        return auths;
    }
}
