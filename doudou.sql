/*
MySQL Backup
Source Server Version: 5.7.25
Source Database: doudou
Date: 2019/7/14 17:25:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `mobile`
-- ----------------------------
DROP TABLE IF EXISTS `mobile`;
CREATE TABLE `mobile` (
  `cardNumber` varchar(255) NOT NULL,
  `userName` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `passWord` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `PackageId` int(11) DEFAULT NULL,
  `consumAmount` double DEFAULT NULL,
  `money` double DEFAULT NULL,
  `realTalkTime` int(11) DEFAULT NULL,
  `realSMSCount` int(11) DEFAULT NULL,
  `realFlow` int(11) DEFAULT NULL,
  PRIMARY KEY (`cardNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `package`
-- ----------------------------
DROP TABLE IF EXISTS `package`;
CREATE TABLE `package` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `talkTime` int(11) DEFAULT NULL,
  `smsCount` int(11) DEFAULT NULL,
  `flow` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `xid` int(11) NOT NULL AUTO_INCREMENT,
  `card` varchar(255) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `talktime` int(11) DEFAULT NULL,
  `sms` int(11) DEFAULT NULL,
  `flow` int(11) DEFAULT NULL,
  `mess` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`xid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `mobile` VALUES ('13908513689','xtq123','123456','2','0','500','200','50','1024'), ('13913521360','a','123456','3','72','128','-37','-139','3043'), ('13960362442','admin','admin','2','0','500','200','50','1024'), ('13977674659','test1','123','2','0','100','200','50','1024');
INSERT INTO `package` VALUES ('1','话痨套餐','500','30','0','58'), ('2','超人套餐','200','50','1024','78'), ('3','网虫套餐','0','0','3072','68');
INSERT INTO `record` VALUES ('6','13913521360','27','0','24','0','群发了短信，消耗了24条短信','2019-07-12 23:45:42');
