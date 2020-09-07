package com.hc.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 角色表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_role")
public class Role implements Serializable {
    private static final long serialVersionUID = 2673946936156182892L;
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 角色关键字
     */
    @TableField(value = "code")
    private String code;

    /**
     * 排序值（默认是50）
     */
    @TableField(value = "level")
    private Integer level;

    /**
     * 备注信息
     */
    @TableField(value = "info")
    private String info;

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

    ///////////////////
    @TableField(exist = false)
    private List<Auth> authList;
}