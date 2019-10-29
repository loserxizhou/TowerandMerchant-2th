/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : tam

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-10-01 21:45:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_base
-- ----------------------------
DROP TABLE IF EXISTS `t_base`;
CREATE TABLE `t_base` (
  `base_uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_level` int(11) DEFAULT NULL,
  `exp` int(11) DEFAULT NULL,
  `diamond` int(11) DEFAULT NULL,
  `gold` int(11) DEFAULT NULL,
  `iron` int(11) DEFAULT NULL,
  `wheat` int(11) DEFAULT NULL,
  `wood` int(11) DEFAULT NULL,
  `stone` int(11) DEFAULT NULL,
  PRIMARY KEY (`base_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base
-- ----------------------------
INSERT INTO `t_base` VALUES ('1', 'aaa', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_base_dynamic_building
-- ----------------------------
DROP TABLE IF EXISTS `t_base_dynamic_building`;
CREATE TABLE `t_base_dynamic_building` (
  `base_dyn_building_uuid` varchar(255) NOT NULL,
  `base_uuid` varchar(255) DEFAULT NULL,
  `dyn_building_uuid` varchar(255) DEFAULT NULL,
  `base_dyn_building_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`base_dyn_building_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_dynamic_building
-- ----------------------------

-- ----------------------------
-- Table structure for t_base_fixed_building
-- ----------------------------
DROP TABLE IF EXISTS `t_base_fixed_building`;
CREATE TABLE `t_base_fixed_building` (
  `base_fixed_building_uuid` varchar(255) NOT NULL,
  `base_uuid` varchar(255) DEFAULT NULL,
  `fixed_building_uuid` varchar(255) DEFAULT NULL,
  `base_fixed_building_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`base_fixed_building_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_fixed_building
-- ----------------------------

-- ----------------------------
-- Table structure for t_dynamic_building
-- ----------------------------
DROP TABLE IF EXISTS `t_dynamic_building`;
CREATE TABLE `t_dynamic_building` (
  `dyn_building_uuid` varchar(255) NOT NULL,
  `dyn_building_sid` bigint(20) DEFAULT NULL,
  `dyn_building_level` int(11) DEFAULT NULL,
  `dyn_building_uptime` datetime DEFAULT NULL,
  `dyn_resource_type` varchar(255) DEFAULT NULL,
  `dyn_last_gain_time` datetime DEFAULT NULL,
  PRIMARY KEY (`dyn_building_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dynamic_building
-- ----------------------------

-- ----------------------------
-- Table structure for t_fixed_building
-- ----------------------------
DROP TABLE IF EXISTS `t_fixed_building`;
CREATE TABLE `t_fixed_building` (
  `fixed_building_uuid` varchar(255) NOT NULL,
  `fixed_building_sid` bigint(20) DEFAULT NULL,
  `fixed_building_level` int(11) DEFAULT NULL,
  `fixed_building_uptime` datetime DEFAULT NULL,
  PRIMARY KEY (`fixed_building_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fixed_building
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `admin` tinyint(4) DEFAULT NULL,
  `root` tinyint(4) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_base
-- ----------------------------
DROP TABLE IF EXISTS `t_user_base`;
CREATE TABLE `t_user_base` (
  `user_base_uuid` varchar(255) NOT NULL,
  `user_uuid` varchar(255) DEFAULT NULL,
  `base_uuid` varchar(255) DEFAULT NULL,
  `user_base_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_base_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_base
-- ----------------------------
