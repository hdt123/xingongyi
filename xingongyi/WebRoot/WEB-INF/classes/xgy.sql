/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : xgy

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-01-20 21:50:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for parise
-- ----------------------------
DROP TABLE IF EXISTS `parise`;
CREATE TABLE `parise` (
  `praiseId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  `praiseDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`praiseId`),
  KEY `FOREIGN_KEY_USER` (`userId`),
  KEY `FOREIGN_KEY_PROJECT` (`projectId`),
  CONSTRAINT `FOREIGN_KEY_PROJECT` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`),
  CONSTRAINT `FOREIGN_KEY_USER` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parise
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `projectId` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) DEFAULT NULL,
  `projectDesc` varchar(255) DEFAULT NULL,
  `pariseNum` int(11) DEFAULT NULL,
  `projectNum` int(11) NOT NULL,
  `needNum` int(11) NOT NULL,
  `shareNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '123', '1', '23', '1', '123', '12');
INSERT INTO `project` VALUES ('2', '456', '2', '2', '123', '1456', '123');
INSERT INTO `project` VALUES ('3', '1', '2', '6', '789', '78945', '123');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(255) NOT NULL,
  `openId` varchar(255) NOT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `headImageUrl` varchar(255) DEFAULT NULL,
  `goodNum` int(11) DEFAULT NULL,
  `shareNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '456', '0', '123', '456', null, null);
INSERT INTO `user` VALUES ('2', 'å¼ ä¸', '123', '0', 'ä¸­å½', '123456', '123', '0');
INSERT INTO `user` VALUES ('3', '123', '123', '0', '中国', '123456省市', '0', null);
