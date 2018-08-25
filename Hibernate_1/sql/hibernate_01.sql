/*
Navicat MySQL Data Transfer

Source Server         : Hibernate
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : hibernate_01

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-08-07 22:03:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_level` varchar(255) DEFAULT NULL,
  `cust_linkman` varchar(255) DEFAULT NULL,
  `cust_phone` varchar(255) DEFAULT NULL,
  `cust_mobile` varchar(255) DEFAULT NULL,
  `cust_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('17', 'kkkitsch', '2', '张某某', '23346574', '18539407269', '周口沈丘县');
INSERT INTO `customer` VALUES ('18', 'joyce', '1', '王某某', '24654657', '12379319370', '大冯营');
INSERT INTO `customer` VALUES ('24', '胡铁花', '5', '孙某', '64342342', '18747246792', '呼市幸福村');
INSERT INTO `customer` VALUES ('25', 'steven', '6', '赵某', '24353642', '13780348204', '郑州华山路');
INSERT INTO `customer` VALUES ('26', 'Judy', '4', '李某', '31232442', '18539407269', '新疆哈密');
INSERT INTO `customer` VALUES ('38', 'alice', '1', '胡汉三', '25245643', '16638118294', '郑州中原路');
INSERT INTO `customer` VALUES ('39', 'alice', '1', '胡汉三', '55342411', '16638118294', '郑州中原路');
INSERT INTO `customer` VALUES ('40', 'alice', '1', '胡汉三', '19960806', '16638118294', '郑州中原路');
INSERT INTO `customer` VALUES ('41', 'matty', '3', 'juddy', '19960806', '16638118294', '地方镇');
INSERT INTO `customer` VALUES ('43', '派大星', '3', 'juddy', '19960806', '16638118294', '海底世界');
INSERT INTO `customer` VALUES ('44', '塔坦', '3', 'juddy', '19960806', '16638118294', '荆棘星球');
INSERT INTO `customer` VALUES ('53', 'matty', '3', 'juddy', '19960806', '16638118294', '地方镇');
INSERT INTO `customer` VALUES ('54', '派大星', '3', 'juddy', '19960806', '16638118294', '海底世界');
INSERT INTO `customer` VALUES ('55', 'matty', '3', 'juddy', '19960806', '16638118294', '地方镇');
INSERT INTO `customer` VALUES ('59', '派大星', '3', 'juddy', '19960806', '16638118294', '海底世界');
INSERT INTO `customer` VALUES ('60', '派大星', '3', 'juddy', '19960806', '16638118294', '海底世界');

-- ----------------------------
-- Table structure for linkman
-- ----------------------------
DROP TABLE IF EXISTS `linkman`;
CREATE TABLE `linkman` (
  `lkm_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `lkm_name` varchar(32) DEFAULT NULL,
  `lkm_cust_id` bigint(32) DEFAULT NULL,
  `lkm_gender` varchar(2) DEFAULT NULL,
  `lkm_phone` varchar(32) DEFAULT NULL,
  `lkm_mobile` varchar(32) DEFAULT NULL,
  `lkm_email` varchar(32) DEFAULT NULL,
  `lkm_qq` varchar(32) DEFAULT NULL,
  `lkm_position` varchar(255) DEFAULT NULL,
  `lkm_memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lkm_id`),
  KEY `fff` (`lkm_cust_id`),
  CONSTRAINT `fff` FOREIGN KEY (`lkm_cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linkman
-- ----------------------------
INSERT INTO `linkman` VALUES ('1', 'juddy', '26', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '堪培拉', null);
INSERT INTO `linkman` VALUES ('7', 'tom', '18', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '堪培拉', null);
INSERT INTO `linkman` VALUES ('19', 'steven', '18', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '哥本哈根', 'this is a memo');
INSERT INTO `linkman` VALUES ('20', 'mice', '18', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '哥本哈根', 'this is a memo');
INSERT INTO `linkman` VALUES ('21', 'michael', '18', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '苏州', 'this is a memo');
INSERT INTO `linkman` VALUES ('22', 'maria', '17', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '哥本哈根', 'this is a memo');
INSERT INTO `linkman` VALUES ('23', 'jane', '17', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '爱丁堡', 'this is a memo');
INSERT INTO `linkman` VALUES ('24', 'kangkang', '17', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '普罗旺斯', 'this is a memo');
INSERT INTO `linkman` VALUES ('25', 'lanlan', '17', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '爱丁堡', 'this is a memo');
INSERT INTO `linkman` VALUES ('26', 'lihua', '17', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '苏州', 'this is a memo');
INSERT INTO `linkman` VALUES ('27', 'kkk', '24', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '墨尔本', 'this is a memo');
INSERT INTO `linkman` VALUES ('28', 'kitsch', '24', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '墨尔本', 'this is a memo');
INSERT INTO `linkman` VALUES ('29', 'joyce', '24', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '香格里拉', 'this is a memo');
INSERT INTO `linkman` VALUES ('30', 'maven', '25', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '香格里拉', 'this is a memo');
INSERT INTO `linkman` VALUES ('31', 'lulu', '26', 'M', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '香格里拉', 'this is a memo');
INSERT INTO `linkman` VALUES ('32', 'nan', '41', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '布宜诺斯艾利斯', 'this is a memo');
INSERT INTO `linkman` VALUES ('33', 'kate', '41', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '密西西比州', 'this is a memo');
INSERT INTO `linkman` VALUES ('34', '海星', '43', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '珊瑚礁', 'this is a memo');
INSERT INTO `linkman` VALUES ('35', '不星', '43', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '不知道星球', 'this is a memo');
INSERT INTO `linkman` VALUES ('36', '洛洛洛', '44', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '荆棘星球', 'this is a memo');
INSERT INTO `linkman` VALUES ('37', '剪纸', '44', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '荆棘星球', 'this is a memo');
INSERT INTO `linkman` VALUES ('52', 'smisy', '53', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '布宜诺斯艾利斯', 'this is a memo');
INSERT INTO `linkman` VALUES ('53', 'kate', '53', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '密西西比州', 'this is a memo');
INSERT INTO `linkman` VALUES ('56', 'smisy', '55', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '布宜诺斯艾利斯', 'this is a memo');
INSERT INTO `linkman` VALUES ('57', 'kate', '55', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '密西西比州', 'this is a memo');
INSERT INTO `linkman` VALUES ('64', '不星', '59', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '不知道星球', 'this is a memo');
INSERT INTO `linkman` VALUES ('65', '海星', '59', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '珊瑚礁', 'this is a memo');
INSERT INTO `linkman` VALUES ('66', '不星', '60', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '不知道星球', 'this is a memo');
INSERT INTO `linkman` VALUES ('67', '海星', '60', 'F', '77988678', '13791273921', '1281053497@qq.com', '1280153497', '珊瑚礁', 'this is a memo');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL,
  `role_memo` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('61', '演员', '其实，我是一个演员');
INSERT INTO `role` VALUES ('62', '歌手', '其实，我是一个演员');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  `user_state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('65', '陈冠希', '111111', '1');
INSERT INTO `user` VALUES ('66', '张柏芝', '666666', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('65', '61');
INSERT INTO `user_role` VALUES ('65', '62');
INSERT INTO `user_role` VALUES ('66', '61');
