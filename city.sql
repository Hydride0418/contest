/*
 Navicat MySQL Data Transfer

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : city

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 17/01/2022 16:42:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `gender` int NOT NULL,
  `organization_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for allocation
-- ----------------------------
DROP TABLE IF EXISTS `allocation`;
CREATE TABLE `allocation` (
  `id` int NOT NULL,
  `work_id` int DEFAULT NULL,
  `expert_id` int DEFAULT NULL,
  `masks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `allo_fk_1` (`work_id`),
  KEY `allo_fk_2` (`expert_id`),
  CONSTRAINT `allo_fk_1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `allo_fk_2` FOREIGN KEY (`expert_id`) REFERENCES `expert` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cont_id` int DEFAULT NULL,
  `org_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `team_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `award_kf_1` (`cont_id`),
  KEY `award_kf_2` (`org_id`),
  KEY `award_kf_3` (`user_id`),
  KEY `award_kf_4` (`team_id`),
  CONSTRAINT `award_kf_1` FOREIGN KEY (`cont_id`) REFERENCES `contest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `award_kf_2` FOREIGN KEY (`org_id`) REFERENCES `organization` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `award_kf_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `award_kf_4` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for batch
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num` int DEFAULT NULL,
  `ques_id` int DEFAULT NULL,
  `track_id` int DEFAULT NULL,
  `rule_id` int DEFAULT NULL,
  `work_id` varchar(0) DEFAULT NULL,
  `expert_id` varchar(0) DEFAULT NULL,
  `work_expert` int DEFAULT NULL,
  `expert_work` int DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `aveg_mask` double NOT NULL,
  `max_mask` double NOT NULL,
  `match_task` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `batch_1` (`ques_id`) USING BTREE,
  KEY `batch_fk_2` (`track_id`),
  KEY `batch_fk_3` (`rule_id`),
  CONSTRAINT `batch_fk_1` FOREIGN KEY (`ques_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `batch_fk_2` FOREIGN KEY (`track_id`) REFERENCES `track` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `batch_fk_3` FOREIGN KEY (`rule_id`) REFERENCES `rule` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for contest
-- ----------------------------
DROP TABLE IF EXISTS `contest`;
CREATE TABLE `contest` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '????????????id',
  `name` varchar(255) DEFAULT NULL COMMENT '????????????',
  `time_limit` int DEFAULT NULL COMMENT '????????????????????????',
  `question_number` int DEFAULT NULL COMMENT '?????????',
  `archive_status` int DEFAULT NULL COMMENT '???????????? 0 ????????? 1 ?????????',
  `contest_id` int DEFAULT NULL COMMENT '????????????id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for expert
-- ----------------------------
DROP TABLE IF EXISTS `expert`;
CREATE TABLE `expert` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `gender` int NOT NULL,
  `organization_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for master_principal
-- ----------------------------
DROP TABLE IF EXISTS `master_principal`;
CREATE TABLE `master_principal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `organization_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for member_team
-- ----------------------------
DROP TABLE IF EXISTS `member_team`;
CREATE TABLE `member_team` (
  `id` int NOT NULL COMMENT '??????id',
  `team_id` int DEFAULT NULL COMMENT '????????????',
  `member_id` int DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`id`),
  KEY `member_team_ibfk_1` (`team_id`),
  KEY `member_team_ibfk_2` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int NOT NULL COMMENT '????????????id',
  `name` varchar(255) DEFAULT NULL COMMENT '??????????????????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for pre_contest
-- ----------------------------
DROP TABLE IF EXISTS `pre_contest`;
CREATE TABLE `pre_contest` (
  `id` int NOT NULL COMMENT '??????id',
  `name` varchar(255) DEFAULT NULL COMMENT '?????????',
  `time_limit` int DEFAULT NULL COMMENT '????????????????????????',
  `question_number` int unsigned DEFAULT NULL COMMENT '?????????',
  `archive_status` int DEFAULT NULL COMMENT '???????????? 0 ????????? 1 ??????',
  `contest_id` int DEFAULT NULL COMMENT '????????????id',
  PRIMARY KEY (`id`),
  KEY `pre_contest_ibfk_1` (`contest_id`),
  CONSTRAINT `ibfk_1` FOREIGN KEY (`id`) REFERENCES `contest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '??????id',
  `name` varchar(255) DEFAULT NULL COMMENT '????????????',
  `batch` varchar(255) DEFAULT NULL,
  `works` varchar(255) DEFAULT NULL,
  `track_id` int DEFAULT NULL,
  `teams` varchar(255) DEFAULT NULL,
  `batch_id` int DEFAULT NULL COMMENT '????????????id',
  PRIMARY KEY (`id`),
  KEY `question_fk1` (`track_id`),
  CONSTRAINT `question_fk1` FOREIGN KEY (`track_id`) REFERENCES `track` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title_colu` int DEFAULT NULL,
  `is_use_wei` double DEFAULT NULL,
  `is_valid` double DEFAULT NULL,
  `head_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '??????id',
  `name` varchar(255) DEFAULT NULL COMMENT '????????????',
  `question_id` int DEFAULT NULL COMMENT '????????????',
  `participat` varchar(255) DEFAULT NULL COMMENT '??????????????????',
  `team_leader` varchar(255) DEFAULT NULL COMMENT '????????????',
  `leader_school` varchar(255) DEFAULT NULL COMMENT '????????????',
  `leader_phone` varchar(255) DEFAULT NULL COMMENT '???????????????',
  `advisor` varchar(255) DEFAULT NULL COMMENT '????????????',
  `team_no_rematch` int DEFAULT NULL COMMENT '??????????????????',
  `is_rematch` int DEFAULT NULL COMMENT '0 ????????? 1 ??????',
  `submit_date` date DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`id`),
  KEY `team_fk_1` (`question_id`),
  CONSTRAINT `team_fk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for track
-- ----------------------------
DROP TABLE IF EXISTS `track`;
CREATE TABLE `track` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '????????????id',
  `name` varchar(255) DEFAULT NULL COMMENT '????????????',
  `time_limit` int DEFAULT NULL COMMENT '????????????????????????',
  `question_number` int DEFAULT NULL COMMENT '?????????',
  `archive_status` int DEFAULT NULL COMMENT '???????????? 0 ????????? 1 ?????????',
  `contest_id` int DEFAULT NULL COMMENT '????????????id',
  `pre_contest_id` int DEFAULT NULL COMMENT '????????????id',
  PRIMARY KEY (`id`),
  KEY `track_fk1` (`contest_id`),
  KEY `track_fk2` (`pre_contest_id`),
  CONSTRAINT `track_fk1` FOREIGN KEY (`contest_id`) REFERENCES `contest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `track_fk2` FOREIGN KEY (`pre_contest_id`) REFERENCES `pre_contest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '?????????',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '??????',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '????????????',
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '?????????',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '??????',
  `team_id` int DEFAULT NULL COMMENT '????????????id',
  `gender` int DEFAULT NULL COMMENT '?????? 0 ??? 1 ???',
  `birthday` date DEFAULT NULL COMMENT '??????',
  `school` varchar(255) DEFAULT NULL COMMENT '??????',
  PRIMARY KEY (`id`),
  KEY `user_ibfk_1` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user_log
-- ----------------------------
DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for user_team
-- ----------------------------
DROP TABLE IF EXISTS `user_team`;
CREATE TABLE `user_team` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL COMMENT '??????id',
  `team_id` int DEFAULT NULL COMMENT '??????id',
  PRIMARY KEY (`id`),
  KEY `fk1` (`user_id`),
  KEY `fk2` (`team_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `team_id` int DEFAULT NULL,
  `ques_id` int DEFAULT NULL,
  `rule_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `work_fk_1` (`user_id`),
  KEY `work_fk_2` (`team_id`),
  KEY `work_fk_3` (`ques_id`),
  KEY `work_fk_4` (`rule_id`),
  CONSTRAINT `work_fk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `work_fk_2` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `work_fk_3` FOREIGN KEY (`ques_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `work_fk_4` FOREIGN KEY (`rule_id`) REFERENCES `rule` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

SET FOREIGN_KEY_CHECKS = 1;
