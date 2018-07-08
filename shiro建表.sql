/*
Navicat MySQL Data Transfer

Source Server         : shawemou
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : shawebaseshiro

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-08 17:36:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for modle
-- ----------------------------
DROP TABLE IF EXISTS `modle`;
CREATE TABLE `modle` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of modle
-- ----------------------------
INSERT INTO `modle` VALUES ('1', '做饭');
INSERT INTO `modle` VALUES ('2', '吃饭');
INSERT INTO `modle` VALUES ('3', '敲代码');
INSERT INTO `modle` VALUES ('4', '骑车');

-- ----------------------------
-- Table structure for modle_role
-- ----------------------------
DROP TABLE IF EXISTS `modle_role`;
CREATE TABLE `modle_role` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `modle_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of modle_role
-- ----------------------------
INSERT INTO `modle_role` VALUES ('1', '1', '1');
INSERT INTO `modle_role` VALUES ('2', '1', '4');
INSERT INTO `modle_role` VALUES ('3', '2', '1');
INSERT INTO `modle_role` VALUES ('4', '3', '2');
INSERT INTO `modle_role` VALUES ('5', '4', '3');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `name` varchar(32) DEFAULT NULL,
  `id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('女朋友', '1');
INSERT INTO `role` VALUES ('男朋友', '2');
INSERT INTO `role` VALUES ('女儿', '3');
INSERT INTO `role` VALUES ('员工', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'wangru', 'df30367c9a5ea44c499505e80f7a4bdc');
INSERT INTO `user` VALUES ('2', 'mouxiaofei', '07d7acef166d78bb35a0be6d34ff63d0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '3', '1');
INSERT INTO `user_role` VALUES ('3', '2', '2');
INSERT INTO `user_role` VALUES ('4', '4', '2');
