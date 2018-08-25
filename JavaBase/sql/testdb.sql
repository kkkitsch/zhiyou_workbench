/*
Navicat MySQL Data Transfer

Source Server         : Con
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-07-23 12:11:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(32) DEFAULT NULL,
  `customer_age` bigint(16) DEFAULT NULL,
  `customer_sex` char(2) DEFAULT NULL,
  `customer_mobile` varchar(32) DEFAULT NULL,
  `customer_address` varchar(64) DEFAULT NULL,
  `customer_level` bigint(16) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '塔坦', '999', 'm', '1111111', '塔坦星球', '10');
INSERT INTO `customer` VALUES ('2', '洛洛', '32', 'w', '', '塔坦星球', '7');
INSERT INTO `customer` VALUES ('3', '派大星', '45', 'm', '3333333', '', '7');
INSERT INTO `customer` VALUES ('4', '海绵宝宝', '23', 'm', '', '', '8');
INSERT INTO `customer` VALUES ('5', '哈塔', '43', 'm', '5555555', '塔坦星球', '8');
INSERT INTO `customer` VALUES ('6', '哈塔的女儿', '54', 'w', '6666666', '塔坦星球', '3');
INSERT INTO `customer` VALUES ('7', '哈塔塔', '22', 'm', '7777777', '塔坦星球', '5');
INSERT INTO `customer` VALUES ('8', '大哈塔', '112', 'w', '8888888', '塔坦星球', '7');
INSERT INTO `customer` VALUES ('9', '小哈塔', '2', 'm', '9999999', '塔坦星球', '2');
INSERT INTO `customer` VALUES ('10', '库巴巴', '999', 'm', null, '塔坦星球', '10');
INSERT INTO `customer` VALUES ('11', '库巴巴军团', '1', 'm', null, '塔坦星球', '1');
INSERT INTO `customer` VALUES ('12', '库巴巴军团', '1', 'm', null, '塔坦星球', '1');
INSERT INTO `customer` VALUES ('13', '库巴巴军团', '1', 'm', null, '塔坦星球', '1');
INSERT INTO `customer` VALUES ('14', '库巴巴军团', '1', 'm', null, '塔坦星球', '1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `order_name` varchar(32) DEFAULT NULL,
  `order_price` double(32,2) DEFAULT NULL,
  `order_num` bigint(16) DEFAULT '1',
  `order_cust_id` bigint(32) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `ocid` (`order_cust_id`),
  CONSTRAINT `ocid` FOREIGN KEY (`order_cust_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '苹果', '5.25', '2', '1');
INSERT INTO `order` VALUES ('2', '桔子', '2.00', '3', '1');
INSERT INTO `order` VALUES ('3', '砂糖橘', '7.23', '1', '1');
INSERT INTO `order` VALUES ('4', '火龙果', '3.56', '4', '2');
INSERT INTO `order` VALUES ('5', '栗子', '7.56', '1', '3');
INSERT INTO `order` VALUES ('6', '山楂', '8.54', '7', '3');
INSERT INTO `order` VALUES ('7', '甘蔗', '9.21', '8', '4');
INSERT INTO `order` VALUES ('8', '牛肉干', '21.10', '1', '5');
INSERT INTO `order` VALUES ('9', '奶糖', '65.40', '12', '5');
INSERT INTO `order` VALUES ('10', '沙琪玛', '2.21', '2', '5');
INSERT INTO `order` VALUES ('11', '酸奶', '32.32', '5', '5');

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `p_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(32) DEFAULT NULL,
  `p_age` bigint(2) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('1', 'tom', '1');
INSERT INTO `people` VALUES ('2', 'alice', '6');
INSERT INTO `people` VALUES ('3', 'joyce', '11');
INSERT INTO `people` VALUES ('4', 'kate', '12');
INSERT INTO `people` VALUES ('5', 'keven', '16');
INSERT INTO `people` VALUES ('6', 'steven', '19');
INSERT INTO `people` VALUES ('7', 'michael', '21');
INSERT INTO `people` VALUES ('8', 'peter', '23');
INSERT INTO `people` VALUES ('9', 'llh', '16');
INSERT INTO `people` VALUES ('10', 'llh', '16');
INSERT INTO `people` VALUES ('11', 'llh', '16');
INSERT INTO `people` VALUES ('12', 'llh', '16');
INSERT INTO `people` VALUES ('13', 'llh', '16');
INSERT INTO `people` VALUES ('14', 'joyma', '21');
INSERT INTO `people` VALUES ('17', 'llh', '16');
INSERT INTO `people` VALUES ('18', 'llh', '16');
INSERT INTO `people` VALUES ('21', 'llh', '16');
INSERT INTO `people` VALUES ('23', 'llh', '16');
INSERT INTO `people` VALUES ('24', 'llh', '16');
INSERT INTO `people` VALUES ('25', 'llh', '16');
INSERT INTO `people` VALUES ('26', 'llh', '16');
INSERT INTO `people` VALUES ('27', 'llh', '16');
INSERT INTO `people` VALUES ('28', 'llh', '16');
INSERT INTO `people` VALUES ('29', 'llh', '16');
INSERT INTO `people` VALUES ('30', 'llh', '16');
INSERT INTO `people` VALUES ('31', 'llh', '16');
INSERT INTO `people` VALUES ('32', 'llh', '16');
INSERT INTO `people` VALUES ('33', 'llh', '16');
INSERT INTO `people` VALUES ('34', 'llh', '16');
INSERT INTO `people` VALUES ('35', 'llh', '16');
INSERT INTO `people` VALUES ('36', 'llh', '16');
INSERT INTO `people` VALUES ('37', 'llh', '16');
INSERT INTO `people` VALUES ('38', 'llh', '16');
INSERT INTO `people` VALUES ('39', 'llh', '16');
