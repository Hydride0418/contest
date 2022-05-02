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

 Date: 02/05/2022 23:22:35
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
  `organization` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of administrator
-- ----------------------------
BEGIN;
INSERT INTO `administrator` VALUES (4, 'admin', 0, '北航', '12312312312', '123456@qq.com', '2021-01-19 00:00:00');
INSERT INTO `administrator` VALUES (5, '杨靖平', 0, '北航', '12312312312', '123456@qq.com', '2021-01-19 00:00:00');
INSERT INTO `administrator` VALUES (6, 'admin2', 0, '北航', '12312312312', '123456@qq.com', '2021-01-19 00:00:00');
INSERT INTO `administrator` VALUES (7, '1', 1, 'w', NULL, NULL, '2022-03-23 21:46:56');
INSERT INTO `administrator` VALUES (8, 'wefwe', 1, NULL, NULL, NULL, '2022-03-23 21:47:04');
INSERT INTO `administrator` VALUES (9, 'qw', 1, NULL, NULL, NULL, '2022-03-23 21:47:10');
INSERT INTO `administrator` VALUES (10, 'q', 1, NULL, NULL, NULL, '2022-03-23 21:47:17');
INSERT INTO `administrator` VALUES (11, 'Jingping Yang', 1, '北航', '13941140083', NULL, '2022-03-23 21:47:31');
COMMIT;

-- ----------------------------
-- Table structure for allocation
-- ----------------------------
DROP TABLE IF EXISTS `allocation`;
CREATE TABLE `allocation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `work_id` int DEFAULT NULL,
  `expert_id` int DEFAULT NULL,
  `masks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `advice` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `is_valid` int DEFAULT NULL,
  `batch_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `allo_fk_1` (`work_id`),
  KEY `allo_fk_2` (`expert_id`),
  KEY `allo_fk_3` (`batch_id`),
  CONSTRAINT `allo_fk_1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `allo_fk_2` FOREIGN KEY (`expert_id`) REFERENCES `expert` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `allo_fk_3` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of allocation
-- ----------------------------
BEGIN;
COMMIT;

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
-- Records of award
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for batch
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num` int DEFAULT NULL,
  `track_id` int DEFAULT NULL,
  `rule_id` int DEFAULT NULL,
  `work_expert` int DEFAULT NULL,
  `expert_work` int DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `is_aveg` int NOT NULL,
  `is_max` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `batch_fk_2` (`track_id`),
  KEY `batch_fk_3` (`rule_id`),
  CONSTRAINT `batch_fk_1` FOREIGN KEY (`track_id`) REFERENCES `track` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `batch_fk_2` FOREIGN KEY (`rule_id`) REFERENCES `rule` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of batch
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for blockuser
-- ----------------------------
DROP TABLE IF EXISTS `blockuser`;
CREATE TABLE `blockuser` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Score` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of blockuser
-- ----------------------------
BEGIN;
INSERT INTO `blockuser` VALUES (1, NULL, 'yjp');
INSERT INTO `blockuser` VALUES (2, NULL, 'dxh');
INSERT INTO `blockuser` VALUES (3, NULL, 'lc');
INSERT INTO `blockuser` VALUES (4, NULL, 'liyuzhuo');
INSERT INTO `blockuser` VALUES (5, 0, NULL);
INSERT INTO `blockuser` VALUES (6, 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for blockwork
-- ----------------------------
DROP TABLE IF EXISTS `blockwork`;
CREATE TABLE `blockwork` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Hash` varchar(255) DEFAULT NULL,
  `Uploader` int DEFAULT NULL,
  `Time` varchar(255) DEFAULT NULL,
  `Cost` int DEFAULT NULL,
  `GetScore` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of blockwork
-- ----------------------------
BEGIN;
INSERT INTO `blockwork` VALUES (1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `blockwork` VALUES (2, '/Users/bytedance/IdeaProjects/contest1/works/11.txt', 32, '2022', 0, 0);
INSERT INTO `blockwork` VALUES (30, '/Users/bytedance/IdeaProjects/contest1/works/12.txt', 34, '2022-05-02 23:06:22', 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for contest
-- ----------------------------
DROP TABLE IF EXISTS `contest`;
CREATE TABLE `contest` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键赛事id',
  `name` varchar(255) DEFAULT NULL COMMENT '赛事名称',
  `time_limit` int DEFAULT NULL COMMENT '时间限制数（天）',
  `question_number` int DEFAULT NULL COMMENT '问题数',
  `archive_status` int DEFAULT NULL COMMENT '归档状态 0 未归档 1 已归档',
  `contest_id` int DEFAULT NULL COMMENT '所属赛事id',
  `image` varchar(255) DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `apply_start` date DEFAULT NULL,
  `apply_end` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of contest
-- ----------------------------
BEGIN;
INSERT INTO `contest` VALUES (3, '北航AI五子棋大赛', 2, 2, 2, 1234, NULL, '北航AI五子棋大赛', '2022-04-02', '2022-04-04', '2022-04-02', '2022-04-03');
INSERT INTO `contest` VALUES (4, '北航AI围棋大赛', 2, 3, 2, 1234, NULL, '北航AI围棋大赛', '2022-03-31', '2022-04-29', '2022-03-31', '2022-04-20');
INSERT INTO `contest` VALUES (5, '北航AI象棋大赛', 2, 2, 2, 1234, NULL, '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', '2022-04-01', '2022-05-03', '2022-04-05', '2022-04-11');
INSERT INTO `contest` VALUES (6, '北航AI国际象棋大赛', 2, 2, 1, 1234, NULL, '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', '2022-03-31', '2022-04-05', '2022-03-31', '2022-04-03');
INSERT INTO `contest` VALUES (7, '研究生创新大赛', 2, 2, 1, 1234, '/Users/bytedance/IdeaProjects/contest1/images/5.jpg', '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', '2022-04-07', '2022-04-29', '2022-04-12', '2022-04-26');
INSERT INTO `contest` VALUES (8, '智慧城市设计大赛', 2, 2, 1, 1234, '/Users/bytedance/IdeaProjects/contest1/images/5.jpg', '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (9, '北京航空航天大学程序设计大赛', 2, 2, 1, 1234, '/Users/bytedance/IdeaProjects/contest1/images/5.jpg', '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (10, '北京航空航天大学人工智能大赛', 2, 2, 1, 1234, '/Users/bytedance/IdeaProjects/contest1/images/5.jpg', '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (11, '北京航空航天大学算法大赛', 2, 2, 1, 1234, '/Users/bytedance/IdeaProjects/contest1/images/5.jpg', '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (12, 'kkkkkk', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (13, 'kkkkkk', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (14, 'kkkkkk', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (15, 'er', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (16, 's', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (17, 'sdfghj', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `contest` VALUES (18, 's', NULL, NULL, NULL, NULL, NULL, NULL, '2022-04-13', '2022-04-11', '2022-04-07', '2022-04-16');
INSERT INTO `contest` VALUES (19, 's', NULL, NULL, NULL, NULL, NULL, NULL, '2022-04-13', '2022-04-11', '2022-04-07', '2022-04-16');
INSERT INTO `contest` VALUES (20, 'erer', NULL, NULL, NULL, NULL, NULL, NULL, '2022-04-05', '2022-04-11', '2022-04-19', '2022-04-20');
INSERT INTO `contest` VALUES (21, 'erer', NULL, NULL, NULL, NULL, NULL, 'this is the content of the contest', '2022-04-04', '2022-04-10', '2022-04-18', '2022-04-19');
COMMIT;

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
  `remarks` varchar(255) DEFAULT NULL,
  `contest_id` int DEFAULT NULL,
  `major_name` varchar(255) DEFAULT NULL,
  `research_direction` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk` (`contest_id`),
  CONSTRAINT `fk` FOREIGN KEY (`contest_id`) REFERENCES `contest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of expert
-- ----------------------------
BEGIN;
INSERT INTO `expert` VALUES (25, 'dxh', 1, '北航', '12312312312', '123456@qq.com', '2021-01-19 00:00:00', '好', NULL, NULL, NULL, 'root');
INSERT INTO `expert` VALUES (26, 'yjp', 1, '北航', '12312312312', '123456@qq.com', '2021-01-19 00:00:00', '好', NULL, NULL, NULL, 'root');
INSERT INTO `expert` VALUES (27, 'lichao', 1, '北航', '12312312312', '123456@qq.com', '2021-01-19 00:00:00', '好', NULL, NULL, NULL, 'root');
COMMIT;

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
-- Records of master_principal
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for member_team
-- ----------------------------
DROP TABLE IF EXISTS `member_team`;
CREATE TABLE `member_team` (
  `id` int NOT NULL COMMENT '主键id',
  `team_id` int DEFAULT NULL COMMENT '队伍编号',
  `member_id` int DEFAULT NULL COMMENT '队员编号',
  PRIMARY KEY (`id`),
  KEY `member_team_ibfk_1` (`team_id`),
  KEY `member_team_ibfk_2` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of member_team
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int NOT NULL COMMENT '参赛机构id',
  `name` varchar(255) DEFAULT NULL COMMENT '参赛机构名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of organization
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pre_contest
-- ----------------------------
DROP TABLE IF EXISTS `pre_contest`;
CREATE TABLE `pre_contest` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '分赛id',
  `name` varchar(255) DEFAULT NULL COMMENT '分赛名',
  `time_limit` int DEFAULT NULL COMMENT '时间限制数（天）',
  `question_number` int unsigned DEFAULT NULL COMMENT '赛题数',
  `archive_status` int DEFAULT NULL COMMENT '归档状态 0 未归档 1 归档',
  `contest_id` int DEFAULT NULL COMMENT '所属赛事id',
  PRIMARY KEY (`id`),
  KEY `pre_contest_ibfk_1` (`contest_id`),
  CONSTRAINT `fk_1` FOREIGN KEY (`contest_id`) REFERENCES `contest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of pre_contest
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '赛题id',
  `name` varchar(255) DEFAULT NULL COMMENT '赛题名称',
  `track_id` int DEFAULT NULL,
  `batch_id` int DEFAULT NULL COMMENT '对应批次id',
  `contest_id` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `question_fk1` (`track_id`),
  CONSTRAINT `question_fk1` FOREIGN KEY (`track_id`) REFERENCES `track` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of question
-- ----------------------------
BEGIN;
INSERT INTO `question` VALUES (4, '题1', NULL, NULL, NULL, NULL);
INSERT INTO `question` VALUES (5, '题2', NULL, NULL, NULL, NULL);
INSERT INTO `question` VALUES (6, '题3', NULL, NULL, NULL, NULL);
INSERT INTO `question` VALUES (7, 'fghjk', NULL, NULL, 3, 'tryui');
COMMIT;

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title_colu` int DEFAULT NULL,
  `is_use_wei` int DEFAULT NULL,
  `is_valid` int DEFAULT NULL,
  `head_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of rule
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '队伍id',
  `name` varchar(255) DEFAULT NULL COMMENT '队伍名称',
  `question_id` int DEFAULT NULL COMMENT '选题编号',
  `participat` varchar(255) DEFAULT NULL COMMENT '参赛状态？？',
  `team_leader` varchar(255) DEFAULT NULL COMMENT '队长名字',
  `leader_school` varchar(255) DEFAULT NULL COMMENT '队长学校',
  `leader_phone` varchar(255) DEFAULT NULL COMMENT '队长手机号',
  `advisor` varchar(255) DEFAULT NULL COMMENT '指导教师',
  `team_no_rematch` int DEFAULT NULL COMMENT '队伍决赛编号',
  `is_rematch` int DEFAULT NULL COMMENT '0 未晋级 1 晋级',
  `submit_date` date DEFAULT NULL COMMENT '提交时间',
  `work_paht` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `team_fk_1` (`question_id`),
  CONSTRAINT `team_fk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of team
-- ----------------------------
BEGIN;
INSERT INTO `team` VALUES (7, '啊对对对', NULL, 'failed', 'Sam', '北京大学', '123232323', 'Weam', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (12, '你说的对对对', 4, 'failed', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (13, '你说的对', 4, 'failed', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (14, '你说的对对', 4, 'failed', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (15, '你说的对对', 4, 'failed', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (16, '你说的对对', 4, 'failed', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (17, '你说的对对', 4, 'failed', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (18, '你说的对对', 4, 'failed', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (19, '你说的对对', 4, 'ok', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (22, '你说的对对', 4, 'ok', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (29, 'test', 4, 'ok', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (30, 'test52', 4, 'ok', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (31, 'test53', 4, 'ok', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (32, 'test54', 4, 'ok', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (33, 'test33', 4, 'ok', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
INSERT INTO `team` VALUES (34, 'test34', 4, 'ok', 'yjp', '北京航空航天大学', '789678789', 'Seo', NULL, 1, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for track
-- ----------------------------
DROP TABLE IF EXISTS `track`;
CREATE TABLE `track` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键赛事id',
  `name` varchar(255) DEFAULT NULL COMMENT '赛事名称',
  `time_limit` int DEFAULT NULL COMMENT '时间限制数（天）',
  `question_number` int DEFAULT NULL COMMENT '问题数',
  `archive_status` int DEFAULT NULL COMMENT '归档状态 0 未归档 1 已归档',
  `contest_id` int DEFAULT NULL COMMENT '所属赛事id',
  `pre_contest_id` int DEFAULT NULL COMMENT '所属分赛id',
  PRIMARY KEY (`id`),
  KEY `track_fk1` (`contest_id`),
  KEY `track_fk2` (`pre_contest_id`),
  CONSTRAINT `track_fk1` FOREIGN KEY (`contest_id`) REFERENCES `contest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `track_fk_2` FOREIGN KEY (`pre_contest_id`) REFERENCES `pre_contest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of track
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `team_id` int DEFAULT NULL COMMENT '所属队伍id',
  `gender` int DEFAULT NULL COMMENT '性别 0 女 1 男',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `school` varchar(255) DEFAULT NULL COMMENT '学校',
  `role` int DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`),
  KEY `user_ibfk_1` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (5, '杨靖平', 'root', 'wewe@qq.com', '12312312312', 'rrdd', 1, 1, NULL, '北京航空航天大学', 0);
INSERT INTO `user` VALUES (6, 'yjp', 'root', 'wewe@qq.com', '12312312312', 'rrdd', 1, 1, NULL, '北京航空航天大学', 0);
INSERT INTO `user` VALUES (7, 'yjpp', 'root', 'wewe@qq.com', '12312312312', 'rrdd', 1, 1, NULL, '北京航空航天大学', 0);
INSERT INTO `user` VALUES (8, 'yjpp', 'root', 'wewe@qq.com', '12312312312', 'rrdd', 1, 1, NULL, '北京航空航天大学', 0);
INSERT INTO `user` VALUES (9, 'root', 'root', 'wewe@qq.com', '12312312312', 'rrdd', 1, 1, NULL, '北京航空航天大学', 255);
INSERT INTO `user` VALUES (10, 'root', 'root', 'wewe@qq.com', '12312312312', 'rrdd', 1, 1, NULL, '北京航空航天大学', NULL);
INSERT INTO `user` VALUES (11, 'name', '123', '', '', 'asd', NULL, NULL, NULL, '', NULL);
INSERT INTO `user` VALUES (12, '', '123', '', '', '', NULL, NULL, NULL, '', NULL);
INSERT INTO `user` VALUES (13, '', '123', '', '', '', NULL, NULL, NULL, '', NULL);
INSERT INTO `user` VALUES (14, 'name', '123', '', '', 'name', NULL, NULL, NULL, '', NULL);
INSERT INTO `user` VALUES (15, 'name', '123', '23', '13', 'name', NULL, NULL, NULL, '', NULL);
INSERT INTO `user` VALUES (16, 'name', '123', '23', '13', 'name', NULL, 1, NULL, '', NULL);
INSERT INTO `user` VALUES (17, 'name', '123', '23', '13', 'name', NULL, 1, NULL, '', NULL);
INSERT INTO `user` VALUES (18, 'name', '123', '23', '13', 'name', NULL, 1, NULL, 'BUAA', NULL);
INSERT INTO `user` VALUES (19, '', '123', '23', '13', 'name', NULL, 1, NULL, 'BUAA', NULL);
INSERT INTO `user` VALUES (20, '', '13', '23', '13', 'name', NULL, 1, NULL, 'BUAA', NULL);
INSERT INTO `user` VALUES (21, 'uname', '123455', 'emali', '124', 'name', NULL, 2, NULL, 'BUAA', NULL);
INSERT INTO `user` VALUES (22, '', '123', '', '', '', NULL, NULL, NULL, '', NULL);
INSERT INTO `user` VALUES (23, 'yjp1', '123456', '20356335t', '23322', '杨靖平', NULL, 1, NULL, 'BUAA', NULL);
COMMIT;

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
-- Records of user_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_team
-- ----------------------------
DROP TABLE IF EXISTS `user_team`;
CREATE TABLE `user_team` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `team_id` int DEFAULT NULL COMMENT '队伍id',
  PRIMARY KEY (`id`),
  KEY `fk1` (`user_id`),
  KEY `fk2` (`team_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_team
-- ----------------------------
BEGIN;
COMMIT;

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
  `work_status` int DEFAULT NULL,
  `reviewed_num` int DEFAULT NULL,
  `content` blob,
  `likes` int DEFAULT NULL,
  `authors` varchar(255) DEFAULT NULL,
  `contest_name` varchar(255) DEFAULT NULL,
  `work_path` varchar(255) DEFAULT NULL,
  `block_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `work_fk_1` (`user_id`),
  KEY `work_fk_2` (`team_id`),
  KEY `work_fk_3` (`ques_id`),
  KEY `work_fk_4` (`rule_id`),
  CONSTRAINT `work_fk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `work_fk_2` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `work_fk_3` FOREIGN KEY (`ques_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `work_fk_4` FOREIGN KEY (`rule_id`) REFERENCES `rule` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of work
-- ----------------------------
BEGIN;
INSERT INTO `work` VALUES (10, '基于强化学习的80天环游地球', NULL, 14, NULL, NULL, NULL, 0, NULL, NULL, 'yjp', NULL, '/Users/bytedance/IdeaProjects/contest1/works/10.txt', NULL);
INSERT INTO `work` VALUES (11, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, '/Users/bytedance/IdeaProjects/contest1/works/11.txt', NULL);
INSERT INTO `work` VALUES (12, '基于强化学习的80天环游地球', NULL, 15, NULL, NULL, 2, 0, NULL, NULL, 'yjp', NULL, '/Users/bytedance/IdeaProjects/contest1/works/12.txt', NULL);
INSERT INTO `work` VALUES (13, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, '/Users/bytedance/IdeaProjects/contest1/works/13.txt', NULL);
INSERT INTO `work` VALUES (18, '基于强化学习的80天环游地球', NULL, 17, NULL, NULL, 1, 0, NULL, NULL, 'yjp1', NULL, '/Users/bytedance/IdeaProjects/contest1/works/18.txt', NULL);
INSERT INTO `work` VALUES (19, '基于强化学习的80天环游地球', NULL, 18, NULL, NULL, 1, 0, NULL, NULL, '杨靖平1', NULL, '/Users/bytedance/IdeaProjects/contest1/works/19.txt', NULL);
INSERT INTO `work` VALUES (20, '基于深度学习的路况时空预测', NULL, 22, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `work` VALUES (21, '基于深度学习的蚊子杀手', NULL, 22, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `work` VALUES (24, '基于深度学习的今晚吃什么', NULL, 19, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `work` VALUES (25, '基于深度学习的人工智障', NULL, 29, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `work` VALUES (26, '基于深度学习的人工智障', NULL, 30, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `work` VALUES (27, '基于深度学习的小爱同学', NULL, 31, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `work` VALUES (28, '基于深度学习的天猫精灵', NULL, 32, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `work` VALUES (29, '基于深度学习的小度小度', NULL, 32, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `work` VALUES (30, '基于深度学习的抖音小助手', NULL, 34, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
