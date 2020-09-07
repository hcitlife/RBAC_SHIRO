package com.hc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hc.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    @Select("SELECT distinct tb_role.`code`\n" +
            "FROM tb_admin INNER JOIN tb_admin_role\n" +
            "ON tb_admin.id = tb_admin_role.admin_id\n" +
            "INNER JOIN tb_role\n" +
            "ON tb_admin_role.role_id = tb_role.id\n" +
            "WHERE tb_admin.account = #{account}")
    Set<String> selectRolesByAccount(String account);

    @Select("SELECT DISTINCT tb_auth.`code`\n" +
            "FROM tb_admin INNER JOIN\ttb_admin_role\n" +
            "ON tb_admin.id = tb_admin_role.admin_id\n" +
            "INNER JOIN\ttb_role_auth\n" +
            "ON tb_admin_role.role_id = tb_role_auth.role_id\n" +
            "INNER JOIN tb_auth\n" +
            "ON \ttb_role_auth.auth_id = tb_auth.id\n" +
            "WHERE tb_admin.account = #{account} ")
    Set<String> selectAuthsByAccount(String account);
}