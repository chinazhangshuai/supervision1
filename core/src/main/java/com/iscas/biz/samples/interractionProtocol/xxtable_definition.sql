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

 Date: 04/01/2021 17:13:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xxtable_definition
-- ----------------------------
DROP TABLE IF EXISTS `xxtable_definition`;
CREATE TABLE `xxtable_definition`  (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `tableIdentity` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表格业务名称，前后台会话标识',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表格标题描述',
  `tableName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应的数据库中的数据表名，用于删除、更新、插入',
  `sql` varchar(1023) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '过滤条件，如userName=‘张三’ AND userId = #{userId} AND sessionId = #{sessionId}',
  `checkbox` bit(1) NULL DEFAULT NULL,
  `backInfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `frontInfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表格下方注释，如：注：XXX',
  `viewType` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'muti/single //显示方式，multi多行，single 单行',
  `cellEditable` bit(1) NULL DEFAULT NULL COMMENT ' true/fasle 表格是否在单元格编辑',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of xxtable_definition
-- ----------------------------
INSERT INTO `xxtable_definition` VALUES (1, 'system_info', '主机在线情况详情', 'system_info', 'select * from system_info', b'0', '', '', '', b'0');
INSERT INTO `xxtable_definition` VALUES (2, 'weapon', NULL, 'weapon', 'select * from weapon', b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxtable_definition` VALUES (3, 'researchproject', NULL, 'researchproject', 'select\n * \nfrom researchproject', b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxtable_definition` VALUES (4, 'personprofile', NULL, 'personprofile', 'select * from personprofile', b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxtable_definition` VALUES (5, 'port', NULL, 'port', 'select * from port', b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxtable_definition` VALUES (6, 'primarymenu', NULL, NULL, 'select * from primarymenu', b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxtable_definition` VALUES (7, 'compostion', NULL, NULL, 'select * from composition', b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxtable_definition` VALUES (8, 'filemetadata', NULL, NULL, 'select * from filemetadata', b'0', NULL, NULL, NULL, b'0');
INSERT INTO `xxtable_definition` VALUES (9, 'port_message', NULL, NULL, 'select * from port_message', b'0', NULL, NULL, NULL, b'0');

SET FOREIGN_KEY_CHECKS = 1;
