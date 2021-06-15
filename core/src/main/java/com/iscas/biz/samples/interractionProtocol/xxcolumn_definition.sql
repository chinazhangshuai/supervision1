/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.100.15
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : 192.168.100.15:3306
 Source Schema         : jk

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 04/01/2021 17:13:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xxcolumn_definition
-- ----------------------------
DROP TABLE IF EXISTS `xxcolumn_definition`;
CREATE TABLE `xxcolumn_definition`  (
  `id` int(11) NOT NULL COMMENT '自增唯一id',
  `tableIdentity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表名',
  `field` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列名',
  `header` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列显示中文名称',
  `sequence` int(11) NULL DEFAULT NULL COMMENT '序号',
  `editable` bit(1) NOT NULL DEFAULT b'0' COMMENT '修改时是否允许编辑',
  `sortable` int(2) NOT NULL DEFAULT 1 COMMENT '1为可排序，0为不可排序',
  `type` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列类型，用于前台展示（String,Integer,Float,Double,Date）',
  `search` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否提供检索',
  `searchType` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'like/exat  like模糊，默认exat全匹配',
  `link` bit(1) NOT NULL DEFAULT b'0',
  `addable` bit(1) NOT NULL DEFAULT b'0' COMMENT '新增时是否需要添加',
  `hidden` int(2) NULL DEFAULT 0 COMMENT '是否在表格中隐藏，新增、编辑时应该不隐藏',
  `refTable` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联表',
  `refColumn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联列',
  `refValue` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定comobox值，通过半角逗号分隔',
  `required` bit(1) NULL DEFAULT b'0' COMMENT '是否必填',
  `reg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正则校验规则',
  `minLength` int(11) NULL DEFAULT NULL COMMENT '最小长度',
  `maxLength` int(11) NULL DEFAULT NULL COMMENT '最大长度',
  `distinct` bit(1) NULL DEFAULT b'0' COMMENT '是否不允许重复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '表描述信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xxcolumn_definition
-- ----------------------------
INSERT INTO `xxcolumn_definition` VALUES (803, 'port', 'country', '国别', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (802, 'port', 'name', '港口名称', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (801, 'port', 'id', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (712, 'personprofile', 'status', '申请状态', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (711, 'personprofile', 'ApplicationTime', '申请时间', NULL, b'0', 1, 'text', b'1', 'range', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (709, 'personprofile', 'tel', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (710, 'personprofile', 'email', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (707, 'personprofile', 'company', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (708, 'personprofile', 'role', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (705, 'personprofile', 'brief', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (706, 'personprofile', 'achievement', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (703, 'personprofile', 'sex', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (704, 'personprofile', 'age', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (701, 'personprofile', 'id', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (702, 'personprofile', 'name', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (503, 'weapon', 'id', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (504, 'weapon', 'weapon_name', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (505, 'weapon', 'unit', '研发单位', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (506, 'weapon', 'dev_time', '研制时间', NULL, b'0', 1, 'datetime', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (507, 'weapon', 'type', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (508, 'weapon', 'bounce', '弹劲', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (509, 'weapon', 'bullet_length', '弹长', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (510, 'weapon', 'max_speed', '最大速度', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (511, 'weapon', 'brief', '简介', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (512, 'weapon', 'feature', '结构特点', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (513, 'researchproject', 'project_name', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (601, 'researchproject', 'project_id', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (602, 'researchproject', 'subject', '所属专题', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (603, 'researchproject', 'topic', '所属课题', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (604, 'researchproject', 'back_model', '背景型号', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (605, 'researchproject', 'project_leader', '项目负责人', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (606, 'researchproject', 'undertaking_unit', '承担单位 ', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (805, 'port', 'lat', '纬度', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (804, 'port', 'lon', '经度', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (806, 'port', 'depth', '水深', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (807, 'port', 'handlingCapacity', '吞吐量', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (607, 'researchproject', 'type', '类别', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (902, 'port_message', 'port_name', '港口名', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (901, 'port_message', 'picture', '图片地址', NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (903, 'port_message', 'id', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (904, 'port_message', 'country', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxcolumn_definition` VALUES (905, 'port_message', 'time', NULL, NULL, b'0', 1, 'text', b'1', 'like', b'0', b'0', 0, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');

SET FOREIGN_KEY_CHECKS = 1;
