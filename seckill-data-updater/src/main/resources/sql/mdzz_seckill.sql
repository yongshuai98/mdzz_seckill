/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : mdzz_seckill

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 21/03/2020 17:13:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`
(
    `id`                 int NOT NULL AUTO_INCREMENT,
    `order_total_fee`    bigint   DEFAULT NULL,
    `order_actual_fee`   bigint   DEFAULT NULL,
    `user_id`            int      DEFAULT NULL,
    `order_status`       tinyint  DEFAULT NULL,
    `order_create_time`  datetime DEFAULT NULL,
    `order_pay_time`     datetime DEFAULT NULL,
    `order_consign_time` datetime DEFAULT NULL,
    `order_end_time`     datetime DEFAULT NULL,
    `order_close_time`   datetime DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_detail`;
CREATE TABLE `tb_order_detail`
(
    `id`               int NOT NULL AUTO_INCREMENT,
    `order_id`         int          DEFAULT NULL,
    `prod_id`          int          DEFAULT NULL,
    `buy_num`          int          DEFAULT NULL,
    `buy_price`        bigint       DEFAULT NULL,
    `prod_name`        varchar(100) DEFAULT NULL,
    `prod_option_name` varchar(100) DEFAULT NULL,
    `prod_cover`       varchar(255) DEFAULT NULL,
    `create_time`      datetime     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_policy
-- ----------------------------
DROP TABLE IF EXISTS `tb_policy`;
CREATE TABLE `tb_policy`
(
    `id`                int NOT NULL AUTO_INCREMENT,
    `prod_id`           int      DEFAULT NULL,
    `policy_quantity`   int      DEFAULT NULL,
    `policy_begin_time` datetime DEFAULT NULL,
    `policy_end_time`   datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_prod
-- ----------------------------
DROP TABLE IF EXISTS `tb_prod`;
CREATE TABLE `tb_prod`
(
    `id`         int NOT NULL AUTO_INCREMENT,
    `prod_name`  varchar(100) DEFAULT NULL,
    `prod_cover` varchar(255) DEFAULT NULL,
    `prod_price` bigint       DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 20
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_prod
-- ----------------------------
BEGIN;
INSERT INTO `tb_prod`
VALUES (1, 'Wi-Fi放大器', 'Wi-Fi放大器.jpg', 10);
INSERT INTO `tb_prod`
VALUES (2, 'wiha螺丝刀', 'wiha螺丝刀.jpg', 10);
INSERT INTO `tb_prod`
VALUES (3, '净水器滤芯', '净水器滤芯.jpg', 10);
INSERT INTO `tb_prod`
VALUES (4, '婴儿理发器', '婴儿理发器.jpg', 10);
INSERT INTO `tb_prod`
VALUES (5, '小爱音箱play', '小爱音箱play.jpg', 10);
INSERT INTO `tb_prod`
VALUES (6, '小米净水器', '小米净水器.jpg', 10);
INSERT INTO `tb_prod`
VALUES (7, '小米拉杆箱', '小米拉杆箱.jpg', 10);
INSERT INTO `tb_prod`
VALUES (8, '扫地机器人', '扫地机器人.jpg', 10);
INSERT INTO `tb_prod`
VALUES (9, '智能摄像头', '智能摄像头.jpg', 10);
INSERT INTO `tb_prod`
VALUES (10, '棘轮螺丝刀', '棘轮螺丝刀.jpg', 10);
INSERT INTO `tb_prod`
VALUES (11, '烟灶套装', '烟灶套装.jpg', 10);
INSERT INTO `tb_prod`
VALUES (12, '破壁料理机', '破壁料理机.jpg', 10);
INSERT INTO `tb_prod`
VALUES (13, '米家小饭煲', '米家小饭煲.jpg', 10);
INSERT INTO `tb_prod`
VALUES (14, '米家电烤箱', '米家电烤箱.jpg', 10);
INSERT INTO `tb_prod`
VALUES (15, '米家电磁炉', '米家电磁炉.jpg', 10);
INSERT INTO `tb_prod`
VALUES (16, '米家驱蚊器', '米家驱蚊器.jpg', 10);
INSERT INTO `tb_prod`
VALUES (17, '红米K20Pro', '红米K20Pro.jpg', 10);
INSERT INTO `tb_prod`
VALUES (18, '胶带座套装', '胶带座套装.jpg', 10);
INSERT INTO `tb_prod`
VALUES (19, '蓝牙头戴耳机', '蓝牙头戴耳机.jpg', 10);
COMMIT;

-- ----------------------------
-- Table structure for tb_prod_img
-- ----------------------------
DROP TABLE IF EXISTS `tb_prod_img`;
CREATE TABLE `tb_prod_img`
(
    `id`              int NOT NULL AUTO_INCREMENT,
    `prod_id`         int          DEFAULT NULL,
    `prod_img_order`  tinyint      DEFAULT NULL,
    `prod_img_source` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_prod_option
-- ----------------------------
DROP TABLE IF EXISTS `tb_prod_option`;
CREATE TABLE `tb_prod_option`
(
    `id`               int NOT NULL AUTO_INCREMENT,
    `prod_id`          int          DEFAULT NULL,
    `prod_option_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_stock
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock`;
CREATE TABLE `tb_stock`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `prod_option_id` int          DEFAULT NULL,
    `stock_quantity` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_stock_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock_history`;
CREATE TABLE `tb_stock_history`
(
    `id`                int NOT NULL AUTO_INCREMENT,
    `stock_id`          int DEFAULT NULL,
    `stock_history_in`  int DEFAULT NULL,
    `stock_history_out` int DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `username` varchar(11)                                                   DEFAULT NULL,
    `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '请设置昵称',
    `password` varchar(255)                                                  DEFAULT NULL,
    `head`     varchar(255)                                                  DEFAULT NULL,
    `role`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '买家',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user`
VALUES (1, '15659756100', '请设置昵称', '$2a$10$CZ22W.y7tWiiksEsPVHeZOdi92kWgkCb59KUw.zwMLsHCR5b.AaBS', NULL, '买家');
COMMIT;

-- ----------------------------
-- Table structure for tb_user_addr
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_addr`;
CREATE TABLE `tb_user_addr`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `user_id`        int          DEFAULT NULL,
    `receiver_name`  varchar(10)  DEFAULT NULL,
    `receiver_phone` varchar(11)  DEFAULT NULL,
    `province`       varchar(10)  DEFAULT NULL,
    `city`           varchar(10)  DEFAULT NULL,
    `county`         varchar(10)  DEFAULT NULL,
    `town`           varchar(10)  DEFAULT NULL,
    `detail`         varchar(255) DEFAULT NULL,
    `is_default`     tinyint      DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
