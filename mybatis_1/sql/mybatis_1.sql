/*
Navicat MySQL Data Transfer

Source Server         : Connection
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : mybatis_1

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-08-16 13:52:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `clazz_id` int(11) NOT NULL AUTO_INCREMENT,
  `clazz_name` varchar(32) DEFAULT NULL,
  `clazz_info` varchar(255) DEFAULT NULL,
  `clazz_buildtime` date DEFAULT NULL,
  PRIMARY KEY (`clazz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('151', '移动互联网151班', '弱小，不堪一击', '2015-09-09');
INSERT INTO `clazz` VALUES ('152', '移动互联网152班', '也是一个渣渣的班级', '2018-08-15');
INSERT INTO `clazz` VALUES ('153', '移动互联网153班', '有点强的班级', '2015-10-15');
INSERT INTO `clazz` VALUES ('154', '移动互联网154班', '王者一般的存在', '2018-08-18');

-- ----------------------------
-- Table structure for clazz_student
-- ----------------------------
DROP TABLE IF EXISTS `clazz_student`;
CREATE TABLE `clazz_student` (
  `c_id` int(32) NOT NULL,
  `s_id` int(32) NOT NULL,
  KEY `ref_stu_id` (`s_id`),
  KEY `ref_class_id` (`c_id`),
  CONSTRAINT `ref_class_id` FOREIGN KEY (`c_id`) REFERENCES `clazz` (`clazz_id`),
  CONSTRAINT `ref_stu_id` FOREIGN KEY (`s_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz_student
-- ----------------------------
INSERT INTO `clazz_student` VALUES ('151', '1');
INSERT INTO `clazz_student` VALUES ('151', '2');
INSERT INTO `clazz_student` VALUES ('152', '3');
INSERT INTO `clazz_student` VALUES ('153', '4');
INSERT INTO `clazz_student` VALUES ('154', '5');
INSERT INTO `clazz_student` VALUES ('154', '6');
INSERT INTO `clazz_student` VALUES ('154', '7');
INSERT INTO `clazz_student` VALUES ('153', '8');
INSERT INTO `clazz_student` VALUES ('152', '9');

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `age` bigint(2) DEFAULT NULL,
  `info` varchar(512) DEFAULT NULL,
  `status` int(2) NOT NULL DEFAULT '0',
  `sex` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('5', 'keven', '16', 'keven is bad', '0', 'w');
INSERT INTO `people` VALUES ('6', 'steven', '19', 'steven is bad', '1', 'w');
INSERT INTO `people` VALUES ('7', 'michael', '21', 'michael is smart', '1', 'w');
INSERT INTO `people` VALUES ('8', 'peter', '23', 'peter is good', '0', 'w');
INSERT INTO `people` VALUES ('9', 'llh', '16', 'llh is common', '1', 'w');
INSERT INTO `people` VALUES ('10', 'llh', '16', null, '0', 'w');
INSERT INTO `people` VALUES ('11', 'llh', '16', null, '1', 'w');
INSERT INTO `people` VALUES ('12', 'llh', '16', null, '0', 'w');
INSERT INTO `people` VALUES ('13', 'llh', '16', null, '1', 'm');
INSERT INTO `people` VALUES ('14', 'joyma', '99', 'joyma is clever', '0', 'm');
INSERT INTO `people` VALUES ('17', 'llh', '16', null, '0', 'm');
INSERT INTO `people` VALUES ('18', 'kkkitsch', '12', 'he is a boy', '0', 'm');
INSERT INTO `people` VALUES ('19', '刻奇', '32', '刻奇就是媚俗的意思', '1', 'm');
INSERT INTO `people` VALUES ('20', '媚俗', '23', '媚俗就是刻奇的意思', '0', 'm');
INSERT INTO `people` VALUES ('21', '林枷锁', '21', '她被困住了！', '1', 'm');
INSERT INTO `people` VALUES ('22', '张嘴', '22', '张开你的嘴巴', '0', 'm');
INSERT INTO `people` VALUES ('23', '开心', '23', '他很开心', '1', 'm');
INSERT INTO `people` VALUES ('24', '鼠目寸', '12', '鼠目寸光的家伙', '0', 'm');
INSERT INTO `people` VALUES ('25', '艾薇', '19', '艾薇儿开演唱会', '1', 'm');
INSERT INTO `people` VALUES ('26', '罗汉三', '63', '我罗汉三回来了！', '1', 'm');
INSERT INTO `people` VALUES ('27', 'kkkitsch', '12', null, '0', 'm');
INSERT INTO `people` VALUES ('28', 'kkkitsch', '12', null, '1', 'm');
INSERT INTO `people` VALUES ('29', '伊卡璐6', '19', '布宜诺斯艾利斯', '0', 'm');
INSERT INTO `people` VALUES ('30', 'kkkitsch', '12', null, '1', 'm');
INSERT INTO `people` VALUES ('31', 'kkkitsch', '12', null, '0', 'm');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(32) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(32) DEFAULT NULL,
  `student_age` varchar(16) DEFAULT NULL,
  `student_sex` varchar(2) DEFAULT NULL,
  `student_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'alice', '21', 'm', 'good person');
INSERT INTO `student` VALUES ('2', 'tom', '12', 'm', 'bad person');
INSERT INTO `student` VALUES ('3', 'jack', '22', 'w', 'little boy');
INSERT INTO `student` VALUES ('4', 'joyce', '23', 'w', 'little girl');
INSERT INTO `student` VALUES ('5', '汤姆克鲁斯', '33', 'm', '著名导演');
INSERT INTO `student` VALUES ('6', '马云', '45', 'm', '乡村教师代表');
INSERT INTO `student` VALUES ('7', '马化腾', '43', 'm', '有钱任性，没钱玩你妈逼');
INSERT INTO `student` VALUES ('8', '马卡龙', '6', 'w', '好吃的东西');
INSERT INTO `student` VALUES ('9', '马可波罗', '666', 'm', '中西文化使者');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `age` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'aaa', 'fjslfjsl', '1');
INSERT INTO `user` VALUES ('2', 'bbb', 'bbb', '2');
INSERT INTO `user` VALUES ('3', 'ccc', 'kkkitsch1996', '3');
INSERT INTO `user` VALUES ('4', 'ddd', 'ddd', '4');
INSERT INTO `user` VALUES ('5', '张三', 'lalal', '12');
INSERT INTO `user` VALUES ('6', '张三', 'lalal', '12');
INSERT INTO `user` VALUES ('7', '胡汉三', 'hhs', '21');
INSERT INTO `user` VALUES ('8', '张三', 'lalal', '12');
INSERT INTO `user` VALUES ('9', '张三', 'newpassword', '12');
INSERT INTO `user` VALUES ('10', '张三', 'lalal', '12');
