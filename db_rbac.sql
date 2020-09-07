/*
 Navicat Premium Data Transfer

 Source Server         : MyLocal8.0
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : db_rbac

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 07/09/2020 09:17:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `account` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(88) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `img` varchar(160) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `qq` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ',
  `tel` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `level` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '排序',
  `info` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `salt` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '随机的盐值',
  `status` tinyint(4) UNSIGNED NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (1, 'admin', 'fa02cc4048a1a1d505c0c55c39613e14', '梁云亮', 1, 'lyl.png', '369950806', '13264494458', 'hcitlife@hotmail.com', 3, '密码明文1234', '21406322', 1, '2020-05-20 12:47:56', '2020-09-06 11:37:54');
INSERT INTO `tb_admin` VALUES (2, 'zhangsan', '5e8844e6f905d6b6c41f386573817f77', '张三', 1, 'cpp.png', '1234567', '13523449142', '369950806@qq.com', 6, '密码明文1234', '96807805', 1, '2020-05-12 18:19:56', '2020-09-06 11:37:51');
INSERT INTO `tb_admin` VALUES (3, 'lisi', 'a3c6423700a455bff1fa5a392e36f0da', '李四', 0, 'lyl.png', '7654321', '13264494458', 'lianghecai52171314@126.com', 1, '密码明文1234', '67471170', 1, '2020-05-14 18:31:33', '2020-09-06 11:37:50');
INSERT INTO `tb_admin` VALUES (4, 'wanger', '518e4ed6782c5ca4f1cc91606fd8c9a6', '王二', 0, 'dotnet.png', '13572468', '13523449142', 'hcitlife@gmail.com', 15, '密码明文1234', '71240702', 1, '2020-05-16 18:31:54', '2020-09-06 11:37:48');
INSERT INTO `tb_admin` VALUES (5, 'mazi', '1234', '麻子', 1, 'ios.png', '97531', '12345678910', 'mazi@126.com', 43, '密码明文1234', NULL, 0, '2020-05-18 18:32:13', '2020-09-06 11:37:47');
INSERT INTO `tb_admin` VALUES (6, 'qianwu', '1234', '钱五', 1, 'java.png', NULL, NULL, NULL, 23, NULL, NULL, 1, NULL, '2020-09-06 17:28:05');
INSERT INTO `tb_admin` VALUES (7, 'zhaoliu', '1234', '赵六', 1, 'test.png', NULL, NULL, NULL, 16, NULL, NULL, 0, NULL, '2020-09-06 17:28:06');
INSERT INTO `tb_admin` VALUES (8, 'xiaoming', '1234', '小明', 0, 'web.png', NULL, NULL, NULL, 32, NULL, NULL, 1, NULL, '2020-09-06 17:28:10');
INSERT INTO `tb_admin` VALUES (9, 'yangwei', '1234', '杨伟', 0, 'cpp.png', NULL, NULL, 'yangwei@qq.com', 63, NULL, NULL, 1, '2020-05-03 13:51:01', '2020-09-06 17:28:12');
INSERT INTO `tb_admin` VALUES (11, 'madehua', '1234', '马德华', 0, 'web.png', NULL, NULL, 'madehua@163.com', 29, NULL, NULL, 0, '2020-05-03 15:41:57', '2020-09-06 17:28:15');
INSERT INTO `tb_admin` VALUES (12, 'guofucheng', '郭富城', '郭富城', 1, 'lyl.png', NULL, NULL, 'lianghecai52171314@126.com', 41, NULL, NULL, 0, '2020-05-06 17:19:14', '2020-09-06 17:29:09');
INSERT INTO `tb_admin` VALUES (56, '3244', '74b01eda5e97fc5197737a1055d39fb4', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, '56533307', 1, NULL, '2020-09-06 17:28:17');
INSERT INTO `tb_admin` VALUES (57, '32443', 'bce0ca551f38cde4ad7b218949fa9b7e', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, '03021520', 1, NULL, '2020-09-06 17:28:20');

-- ----------------------------
-- Table structure for tb_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_role`;
CREATE TABLE `tb_admin_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `admin_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '用户编号',
  `role_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '角色编号',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`admin_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_vi_0900_ai_ci COMMENT = '用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_admin_role
-- ----------------------------
INSERT INTO `tb_admin_role` VALUES (1, 1, 1, NULL, '2020-09-06 17:50:45');
INSERT INTO `tb_admin_role` VALUES (2, 1, 2, NULL, '2020-09-06 09:24:15');
INSERT INTO `tb_admin_role` VALUES (3, 1, 3, NULL, '2020-09-06 09:24:20');
INSERT INTO `tb_admin_role` VALUES (4, 2, 2, NULL, '2020-09-06 17:58:18');
INSERT INTO `tb_admin_role` VALUES (5, 2, 3, NULL, '2020-09-06 17:58:20');
INSERT INTO `tb_admin_role` VALUES (6, 3, 3, NULL, '2020-09-06 09:24:29');
INSERT INTO `tb_admin_role` VALUES (7, 4, 3, NULL, '2020-09-06 17:57:31');
INSERT INTO `tb_admin_role` VALUES (8, 4, 4, NULL, '2020-09-06 18:04:32');
INSERT INTO `tb_admin_role` VALUES (9, 5, 2, NULL, '2020-09-06 17:57:39');

-- ----------------------------
-- Table structure for tb_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_auth`;
CREATE TABLE `tb_auth`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标题',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限关键字',
  `url` varchar(74) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限所能访问的资源的路径',
  `icon` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限所对应的图标',
  `level` tinyint(4) UNSIGNED NULL DEFAULT 50 COMMENT '排序值（默认是50）',
  `is_open` bit(1) NULL DEFAULT NULL COMMENT '是否展开：0关闭  1展开',
  `info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `pid` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '父权限ID，根节点的父权限为空',
  `status` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '启用状态：0禁用  1启用',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_41`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_auth
-- ----------------------------
INSERT INTO `tb_auth` VALUES (1, '用户管理', 'admin', NULL, 'glyphicon glyphicon-th-list', NULL, NULL, NULL, NULL, NULL, NULL, '2020-09-06 15:31:15');
INSERT INTO `tb_auth` VALUES (2, '新增用户', 'admin:add', '/admin/add', 'Hui-iconfont menu_dropdown-arrow', NULL, NULL, NULL, 1, NULL, NULL, '2020-09-06 15:49:58');
INSERT INTO `tb_auth` VALUES (3, '修改用户', 'admin:update', '/admin/update/*', 'Hui-iconfont', NULL, NULL, NULL, 1, NULL, NULL, '2020-09-06 15:32:11');
INSERT INTO `tb_auth` VALUES (4, '用户ID查询', 'admin:select/id', '/admin/id/*', 'Hui-iconfont', NULL, NULL, NULL, 1, NULL, NULL, '2020-09-06 15:32:05');
INSERT INTO `tb_auth` VALUES (31, '用户列表查询', 'admin:list', '/admin/all', NULL, 50, NULL, NULL, 1, NULL, NULL, '2020-09-06 15:56:54');
INSERT INTO `tb_auth` VALUES (32, '仓库管理', 'storage', NULL, NULL, 50, NULL, NULL, NULL, NULL, NULL, '2020-09-06 09:15:38');
INSERT INTO `tb_auth` VALUES (33, '仓库列表查询', 'storage:list', '/storage/all', NULL, 50, NULL, NULL, 32, NULL, NULL, '2020-09-06 15:56:59');
INSERT INTO `tb_auth` VALUES (34, '仓库ID查询', 'storage:select:id', '/storage/*', NULL, 50, NULL, NULL, 32, NULL, NULL, '2020-09-06 09:18:20');
INSERT INTO `tb_auth` VALUES (35, '增加仓库', 'storage:add', '/storage/add', NULL, 50, NULL, NULL, 32, NULL, NULL, '2020-09-06 09:18:23');
INSERT INTO `tb_auth` VALUES (36, '修改仓库', 'storage:update', '/storage/update/*', NULL, 50, NULL, NULL, 32, NULL, NULL, '2020-09-06 09:18:47');
INSERT INTO `tb_auth` VALUES (37, '删除仓库', 'storage:delete', '/storage/delete/*', NULL, 50, NULL, NULL, 32, NULL, NULL, '2020-09-06 09:18:52');
INSERT INTO `tb_auth` VALUES (38, '删除用户', 'admin:delete', '/admin/dalete/*', NULL, 50, NULL, NULL, 1, NULL, NULL, '2020-09-06 15:31:51');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(28) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色关键字',
  `level` tinyint(4) UNSIGNED NULL DEFAULT 50 COMMENT '排序值（默认是50）',
  `info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `status` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '启用状态：0禁用  1启用',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, '超级管理员', 'role:system', 50, '整个系统的所有权限', 1, '2020-08-04 08:58:20', '2020-09-06 15:23:41');
INSERT INTO `tb_role` VALUES (2, '用户管理员', 'role:user', 50, '对所有用户CRU', 1, '2020-08-20 08:59:05', '2020-09-06 15:23:46');
INSERT INTO `tb_role` VALUES (3, '仓库管理员', 'role:storage', 50, '对所有仓库CRUD', 1, '2020-08-11 09:09:19', '2020-09-06 15:23:53');

-- ----------------------------
-- Table structure for tb_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_auth`;
CREATE TABLE `tb_role_auth`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '角色编号',
  `auth_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '权限编号',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT ' 更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_33`(`auth_id`) USING BTREE,
  INDEX `FK_Reference_34`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_role_auth
-- ----------------------------
INSERT INTO `tb_role_auth` VALUES (1, 1, 1, NULL, '2020-09-06 09:27:30');
INSERT INTO `tb_role_auth` VALUES (2, 1, 2, NULL, '2020-09-06 09:27:35');
INSERT INTO `tb_role_auth` VALUES (3, 1, 3, NULL, '2020-09-06 09:27:42');
INSERT INTO `tb_role_auth` VALUES (4, 1, 4, NULL, '2020-09-06 09:27:49');
INSERT INTO `tb_role_auth` VALUES (5, 1, 31, NULL, '2020-09-06 18:05:32');
INSERT INTO `tb_role_auth` VALUES (6, 1, 32, NULL, '2020-09-06 09:28:03');
INSERT INTO `tb_role_auth` VALUES (7, 1, 33, NULL, '2020-09-06 09:28:09');
INSERT INTO `tb_role_auth` VALUES (8, 1, 34, NULL, '2020-09-06 09:28:15');
INSERT INTO `tb_role_auth` VALUES (9, 1, 35, NULL, '2020-09-06 09:28:20');
INSERT INTO `tb_role_auth` VALUES (10, 1, 36, NULL, '2020-09-06 09:28:25');
INSERT INTO `tb_role_auth` VALUES (11, 1, 37, NULL, '2020-09-06 09:28:32');
INSERT INTO `tb_role_auth` VALUES (12, 2, 1, NULL, '2020-09-06 09:30:01');
INSERT INTO `tb_role_auth` VALUES (13, 2, 2, NULL, '2020-09-06 09:30:04');
INSERT INTO `tb_role_auth` VALUES (14, 2, 3, NULL, '2020-09-06 09:30:07');
INSERT INTO `tb_role_auth` VALUES (15, 2, 4, NULL, '2020-09-06 09:30:11');
INSERT INTO `tb_role_auth` VALUES (16, 2, 31, NULL, '2020-09-06 18:05:39');
INSERT INTO `tb_role_auth` VALUES (17, 3, 32, NULL, '2020-09-06 09:33:56');
INSERT INTO `tb_role_auth` VALUES (18, 3, 33, NULL, '2020-09-06 09:34:04');
INSERT INTO `tb_role_auth` VALUES (19, 3, 34, NULL, '2020-09-06 09:34:23');
INSERT INTO `tb_role_auth` VALUES (20, 3, 36, NULL, '2020-09-06 09:34:32');

-- ----------------------------
-- Table structure for tb_storage
-- ----------------------------
DROP TABLE IF EXISTS `tb_storage`;
CREATE TABLE `tb_storage`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_storage
-- ----------------------------
INSERT INTO `tb_storage` VALUES (1, '机房');
INSERT INTO `tb_storage` VALUES (2, '原材料');
INSERT INTO `tb_storage` VALUES (3, '半成品');
INSERT INTO `tb_storage` VALUES (4, '成品');
INSERT INTO `tb_storage` VALUES (5, 'aa');

SET FOREIGN_KEY_CHECKS = 1;
