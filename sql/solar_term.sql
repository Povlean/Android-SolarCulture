/*
 Navicat MySQL Data Transfer

 Source Server         : spring
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : solar_term

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 15/04/2023 23:32:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_solar
-- ----------------------------
DROP TABLE IF EXISTS `tbl_solar`;
CREATE TABLE `tbl_solar`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标识id',
  `solar_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '节气名字',
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '农历时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时节描述',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片路径',
  `food` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '食物\r\n',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_solar
-- ----------------------------
INSERT INTO `tbl_solar` VALUES (1, '立春', '公历2月3-5日交节', '立春是干支历寅月的起始', '1', '萝卜、姜、葱、油饼');
INSERT INTO `tbl_solar` VALUES (2, '立夏', '公历5月05 - 07日交节', '立夏是干支历巳月的起始', '2', '立夏蛋');
INSERT INTO `tbl_solar` VALUES (3, 'demo', '八月初', NULL, NULL, '康师傅');
INSERT INTO `tbl_solar` VALUES (4, 'demoJson', 'demoDate', 'demoDes', 'demoUrl', 'demoFood');
INSERT INTO `tbl_solar` VALUES (5, 'demoAndroid02', 'demoDate', 'demoDes', 'demoUrl', 'demoFood');
INSERT INTO `tbl_solar` VALUES (6, 'demoAndroid', 'demoDate', 'demoDes', 'demoUrl', 'demoFood');

-- ----------------------------
-- Table structure for tbl_solaritem
-- ----------------------------
DROP TABLE IF EXISTS `tbl_solaritem`;
CREATE TABLE `tbl_solaritem`  (
  `solarname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `solarimg` int NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_solaritem
-- ----------------------------
INSERT INTO `tbl_solaritem` VALUES ('冬至吃饺子', 0, '冬至吃饺子 纪念医圣. 各地在冬至时有不同的风俗，北方地区有冬至宰羊、吃饺子、吃馄饨的习俗，南方地区在这一天则有吃冬至米团、冬至长线面的习惯，而苏北人在冬至时吃大葱炒豆腐。. 冬至吃饺子还有说是不忘\" 医圣 \" 张仲景 \" 祛寒娇耳汤 ');
INSERT INTO `tbl_solaritem` VALUES ('nihao', 0, 'I love you');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `born_season` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出生季节',
  `food_favor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '喜欢的食物',
  `age` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (2, 'demo01', 'e10adc3949ba59abbe56e057f20f883e', 'autumn', 'pock', 23);
INSERT INTO `tbl_user` VALUES (3, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'winter', 'xixi', 40);
INSERT INTO `tbl_user` VALUES (6, 'admin1', 'e10adc3949ba59abbe56e057f20f883e', 'autumn', 'dumpling', 21);
INSERT INTO `tbl_user` VALUES (7, 'king', 'b2086154f101464aab3328ba7e060deb', NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES (8, 'android', 'e10adc3949ba59abbe56e057f20f883e', 'winter', 'icecream', 2);
INSERT INTO `tbl_user` VALUES (9, 'admin2', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES (10, 'demo04', 'e10adc3949ba59abbe56e057f20f883e', 'winter', 'sweet', 79);
INSERT INTO `tbl_user` VALUES (11, 'povl', 'e10adc3949ba59abbe56e057f20f883e', 'winter', 'nut', 12);
INSERT INTO `tbl_user` VALUES (12, 'Povlean', 'e10adc3949ba59abbe56e057f20f883e', '暂未填写', 'nut', 31);
INSERT INTO `tbl_user` VALUES (13, 'xurui', 'e10adc3949ba59abbe56e057f20f883e', 'winter', 'luosifen', 23);

SET FOREIGN_KEY_CHECKS = 1;
