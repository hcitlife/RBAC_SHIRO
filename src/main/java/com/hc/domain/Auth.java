package com.hc.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 权限表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_auth")
public class Auth implements Serializable {
    private static final long serialVersionUID = -2708514522151879794L;
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限标题
     */
    @TableField(value = "name")
    private String name;

    /**
     * 权限关键字
     */
    @TableField(value = "code")
    private String code;

    /**
     * 权限所能访问的资源的路径
     */
    @TableField(value = "url")
    private String url;

    /**
     * 权限所对应的图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 排序值（默认是50）
     */
    @TableField(value = "level")
    private Integer level;

    /**
     * 是否展开：0关闭  1展开
     */
    @TableField(value = "is_open")
    private Boolean isOpen;

    /**
     * 备注信息
     */
    @TableField(value = "info")
    private String info;

    /**
     * 父权限ID，根节点的父权限为空
     */
    @TableField(value = "pid")
    private Integer pid;

    /**
     * 启用状态：0禁用  1启用
     */
    @TableField(value = "status")
    private Boolean status;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "updateTime")
    private LocalDateTime updateTime;
}