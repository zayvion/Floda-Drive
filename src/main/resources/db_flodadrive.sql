/*
 Navicat Premium Data Transfer

 Source Server         : Flodadrive
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 182.254.180.106:3306
 Source Schema         : db_flodadrive

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 03/09/2019 19:49:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_folder
-- ----------------------------
DROP TABLE IF EXISTS `tb_folder`;
CREATE TABLE `tb_folder` (
  `folder_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文件夹id',
  `folder_name` varchar(50) NOT NULL COMMENT '文件夹名',
  `folder_father` bigint(20) NOT NULL DEFAULT '0' COMMENT '上一级文件夹id，默认0',
  `folder_user` bigint(20) NOT NULL COMMENT '属于的用户id',
  `folder_createtime` datetime DEFAULT NULL COMMENT '创建的时间',
  `isDel` smallint(6) DEFAULT '0' COMMENT '是否删除 1为删除0没删除',
  PRIMARY KEY (`folder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10033 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_folder
-- ----------------------------
BEGIN;
INSERT INTO `tb_folder` VALUES (10000, '电影', 0, 15002, '2019-08-27 14:41:51', 0);
INSERT INTO `tb_folder` VALUES (10001, '我的资源', 0, 15002, '2019-08-26 16:34:03', 0);
INSERT INTO `tb_folder` VALUES (10002, '学习资料', 0, 15002, '2019-08-21 18:34:05', 0);
INSERT INTO `tb_folder` VALUES (10003, '素材', 0, 15002, '2019-08-28 09:40:41', 0);
INSERT INTO `tb_folder` VALUES (10004, '生化危机全集', 10000, 15002, '2019-08-29 09:03:30', 0);
INSERT INTO `tb_folder` VALUES (10005, '健身', 0, 15001, '2019-08-27 17:45:30', 0);
INSERT INTO `tb_folder` VALUES (10006, '代码', 0, 15001, '2019-08-27 15:09:32', 0);
INSERT INTO `tb_folder` VALUES (10007, '小视频', 0, 15001, '2019-08-30 10:49:06', 0);
INSERT INTO `tb_folder` VALUES (10009, '生化危机第二部', 10004, 15002, '2019-08-29 09:05:01', 0);
INSERT INTO `tb_folder` VALUES (10013, '速度与激情系列', 10000, 15002, '2019-08-28 17:12:47', 0);
INSERT INTO `tb_folder` VALUES (10014, '速度与激情第一部', 10013, 15002, '2019-08-28 17:13:14', 0);
INSERT INTO `tb_folder` VALUES (10015, 'ps素材', 10003, 15002, '2019-08-28 17:22:58', 0);
INSERT INTO `tb_folder` VALUES (10016, 'br素材', 10003, 15002, '2019-08-28 17:23:29', 0);
INSERT INTO `tb_folder` VALUES (10017, 'word文档', 10002, 15002, '2019-08-28 17:48:48', 0);
INSERT INTO `tb_folder` VALUES (10018, '我的图片', 0, 15001, '2019-08-29 11:35:57', 0);
INSERT INTO `tb_folder` VALUES (10019, '音乐', 0, 15002, '2019-08-30 15:10:17', 0);
INSERT INTO `tb_folder` VALUES (10020, '音乐收藏', 10019, 15002, '2019-08-30 09:24:23', 0);
INSERT INTO `tb_folder` VALUES (10021, '我的文件夹', 0, 15003, '2019-09-02 10:34:31', 1);
INSERT INTO `tb_folder` VALUES (10022, '项目文档', 10017, 15002, '2019-08-30 14:32:41', 0);
INSERT INTO `tb_folder` VALUES (10023, 'test', 10021, 15003, '2019-09-02 10:34:31', 1);
INSERT INTO `tb_folder` VALUES (10024, 'test1', 10023, 15003, '2019-09-02 10:34:31', 1);
INSERT INTO `tb_folder` VALUES (10025, '文件夹', 0, 15001, '2019-09-02 11:13:47', 1);
INSERT INTO `tb_folder` VALUES (10026, '我喜欢', 10019, 15002, '2019-09-02 14:28:03', 0);
INSERT INTO `tb_folder` VALUES (10027, '文件夹', 0, 15003, '2019-09-02 14:30:04', 0);
INSERT INTO `tb_folder` VALUES (10028, '我的文档', 0, 15004, '2019-09-02 14:36:00', 0);
INSERT INTO `tb_folder` VALUES (10029, '歌曲私藏', 0, 15004, '2019-09-02 14:36:42', 0);
INSERT INTO `tb_folder` VALUES (10030, 'pdf', 10028, 15004, '2019-09-02 14:36:52', 0);
INSERT INTO `tb_folder` VALUES (10031, '好片收藏', 0, 15004, '2019-09-02 14:37:24', 0);
INSERT INTO `tb_folder` VALUES (10032, '表情包', 0, 15004, '2019-09-02 14:40:56', 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_share
-- ----------------------------
DROP TABLE IF EXISTS `tb_share`;
CREATE TABLE `tb_share` (
  `share_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分享id',
  `share_user` bigint(255) NOT NULL COMMENT '分享用户',
  `share_comment` varchar(255) DEFAULT NULL COMMENT '分享文字内容',
  `share_title` varchar(100) DEFAULT NULL COMMENT '分享标题',
  `share_url` varchar(255) DEFAULT NULL COMMENT '分享的url',
  `share_date` datetime DEFAULT NULL COMMENT '分享日期',
  PRIMARY KEY (`share_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26027 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_share
-- ----------------------------
BEGIN;
INSERT INTO `tb_share` VALUES (26012, 15001, '2020届毕业生秋季校招网申信息汇总.xlsx', '2020届毕业生秋季校招网申信息汇总.xlsx', 'http://localhost:8080/share/view/26012', '2019-08-30 16:07:40');
INSERT INTO `tb_share` VALUES (26020, 15002, '20190726155711.jpg', '20190726155711.jpg', 'http://localhost:8080/share/view/26020', '2019-09-02 11:36:38');
INSERT INTO `tb_share` VALUES (26021, 15003, '1.jpg分享', '1.jpg等', 'http://localhost:8080/share/view/26021', '2019-09-02 11:37:30');
INSERT INTO `tb_share` VALUES (26024, 15003, '网络歌手 - 芒种（路飞版）.mp3', '网络歌手 - 芒种（路飞版）.mp3等', 'http://localhost:8080/share/view/26024', '2019-09-02 11:43:01');
INSERT INTO `tb_share` VALUES (26026, 15003, '图片分享', '分享图片', 'http://localhost:8080/share/view/26026', '2019-09-02 12:01:02');
COMMIT;

-- ----------------------------
-- Table structure for tb_share_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_share_item`;
CREATE TABLE `tb_share_item` (
  `share_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `share_id` bigint(20) NOT NULL COMMENT '分享id,与主表主键对应',
  `share_userfile_id` bigint(20) DEFAULT NULL COMMENT '用户文件id',
  PRIMARY KEY (`share_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_share_item
-- ----------------------------
BEGIN;
INSERT INTO `tb_share_item` VALUES (17, 26012, 81);
INSERT INTO `tb_share_item` VALUES (31, 26020, 31);
INSERT INTO `tb_share_item` VALUES (32, 26021, 87);
INSERT INTO `tb_share_item` VALUES (33, 26021, 88);
INSERT INTO `tb_share_item` VALUES (34, 26021, 89);
INSERT INTO `tb_share_item` VALUES (39, 26024, 104);
INSERT INTO `tb_share_item` VALUES (40, 26024, 107);
INSERT INTO `tb_share_item` VALUES (43, 26026, 88);
INSERT INTO `tb_share_item` VALUES (44, 26026, 89);
COMMIT;

-- ----------------------------
-- Table structure for tb_system_file
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_file`;
CREATE TABLE `tb_system_file` (
  `file_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `file_name` varchar(100) NOT NULL COMMENT '文件名',
  `file_url` varchar(255) NOT NULL COMMENT '文件地址',
  `upload_user` bigint(255) unsigned DEFAULT NULL COMMENT '上传用户',
  `file_type` char(2) DEFAULT '5' COMMENT '文件类型，1图片2音频3视频4文档5其他',
  `file_size` decimal(10,2) unsigned NOT NULL COMMENT '文件大小，单位kb',
  `file_md5` varchar(200) DEFAULT NULL COMMENT '文件md5',
  `upload_time` timestamp NULL DEFAULT NULL COMMENT '上传时间',
  `file_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_system_file
-- ----------------------------
BEGIN;
INSERT INTO `tb_system_file` VALUES (0, '1f234d87-0162-4.xlsx', 'http://image.lzllzl.cn/img/2019-08-27/1f234d87-0162-4.xlsx', 15001, '4', 13558.00, 'c203b02cf30415d7d0a03349a4bcd686', '2019-08-27 14:43:01', NULL);
INSERT INTO `tb_system_file` VALUES (13, '54c3bbae-0526-4.pdf', 'http://image.lzllzl.cn/img/2019-08-27/54c3bbae-0526-4.pdf', 15001, '4', 168928.00, '10852f710426e9245bc200f3e703d62d', '2019-08-27 14:44:30', NULL);
INSERT INTO `tb_system_file` VALUES (14, '97f7783a-0fa8-4.png', 'http://image.lzllzl.cn/img/2019-08-27/97f7783a-0fa8-4.png', 15001, '1', 3.00, '8d3680de57ce9c932a987b503cfb9119', '2019-08-27 14:49:52', NULL);
INSERT INTO `tb_system_file` VALUES (15, '9726861f-bb9d-4.xlsx', 'http://image.lzllzl.cn/img/2019-08-27/9726861f-bb9d-4.xlsx', 15001, '4', 633.00, 'c8e639bdfca807ed2959ffb9e4c4e4d8', '2019-08-27 15:25:03', NULL);
INSERT INTO `tb_system_file` VALUES (16, 'd927467d-c3af-4.jpg', 'http://image.lzllzl.cn/img/2019-08-27/d927467d-c3af-4.jpg', 15002, '1', 49.00, '55f0220b56e1baa5dea8b198e75a2408', '2019-08-27 16:41:13', NULL);
INSERT INTO `tb_system_file` VALUES (17, 'e09137c8-e688-4.java', 'http://image.lzllzl.cn/img/2019-08-27/e09137c8-e688-4.java', 15001, '5', 1.00, '52b3078e28dd5b14ee9c712e08129424', '2019-08-27 17:46:10', NULL);
INSERT INTO `tb_system_file` VALUES (22, 'c9d9e760-f215-4.mp4', 'http://image.lzllzl.cn/img/2019-08-28/c9d9e760-f215-4.mp4', 15000, '3', 10361.00, '64adc1e29ee378e8e3ee1946081d152c', '2019-08-28 13:29:36', NULL);
INSERT INTO `tb_system_file` VALUES (23, 'd707c65a-5208-4.txt', 'http://image.lzllzl.cn/img/2019-08-28/d707c65a-5208-4.txt', 15000, '4', 0.00, '2526dd91c99a755f44aef539202c57fd', '2019-08-28 13:59:52', NULL);
INSERT INTO `tb_system_file` VALUES (24, '5eb7d36d-11e7-4.docx', 'http://image.lzllzl.cn/img/2019-08-28/5eb7d36d-11e7-4.docx', 15001, '4', 254.00, '74e56edacf6acdd97275453b49eebc1a', '2019-08-28 14:02:43', NULL);
INSERT INTO `tb_system_file` VALUES (26, '59273c8d-9284-4.txt', 'http://image.lzllzl.cn/img/2019-08-28/59273c8d-9284-4.txt', 15001, '4', 0.00, '5bf5db91635c39b280f80651a55842b0', '2019-08-28 14:11:02', NULL);
INSERT INTO `tb_system_file` VALUES (28, '33b1df16-8af8-4.mp4', 'http://image.lzllzl.cn/img/2019-08-28/33b1df16-8af8-4.mp4', 15000, '3', 3413.00, 'e5917fbed65778257aa9932a5ad43e05', '2019-08-28 14:48:26', NULL);
INSERT INTO `tb_system_file` VALUES (29, '06c22d05-3054-4.jpg', 'http://image.lzllzl.cn/img/2019-08-28/06c22d05-3054-4.jpg', 15002, '1', 1279.00, 'cb50bd96f8c192743ff5198ffde0d8f7', '2019-08-28 17:41:26', NULL);
INSERT INTO `tb_system_file` VALUES (30, 'f6a90562-e50a-4.jpg', 'http://image.lzllzl.cn/img/2019-08-28/f6a90562-e50a-4.jpg', 15002, '1', 1279.00, 'cb50bd96f8c192743ff5198ffde0d8f7', '2019-08-28 17:41:26', NULL);
INSERT INTO `tb_system_file` VALUES (31, '24bc0fc1-0c68-4.jpg', 'http://image.lzllzl.cn/img/2019-08-28/24bc0fc1-0c68-4.jpg', 15002, '1', 49.00, '513b6e42cb1907bf87d763d8e7bccd3d', '2019-08-28 17:44:29', NULL);
INSERT INTO `tb_system_file` VALUES (32, 'b6589a9a-df43-4.x 【iframe 常规版】开发者文档.pdf', 'http://image.lzllzl.cn/img/2019-08-28/b6589a9a-df43-4.x 【iframe 常规版】开发者文档.pdf', 15002, '5', 539.00, '0e06e14a9bf4fe90ef0f6437d0a1e6f1', '2019-08-28 17:47:11', NULL);
INSERT INTO `tb_system_file` VALUES (33, 'b4ffcc57-581f-4.doc', 'http://image.lzllzl.cn/img/2019-08-28/b4ffcc57-581f-4.doc', 15002, '4', 79.00, 'c8174eccb6a353cfcfe58e7d38dac869', '2019-08-28 17:49:07', NULL);
INSERT INTO `tb_system_file` VALUES (34, 'c072d14a-dcf8-4.doc', 'http://image.lzllzl.cn/img/2019-08-28/c072d14a-dcf8-4.doc', 15002, '4', 634.00, 'b0662a2bcfabaa2a03fdb1d62a7f0b90', '2019-08-28 17:51:02', NULL);
INSERT INTO `tb_system_file` VALUES (35, '9a334549-cc25-4.jpg', 'http://image.lzllzl.cn/img/2019-08-28/9a334549-cc25-4.jpg', 15003, '1', 9.00, '85f867d48965d4eb717b31525ff0fa34', '2019-08-28 19:07:46', NULL);
INSERT INTO `tb_system_file` VALUES (36, 'e179fa99-8405-4.mp4', 'http://image.lzllzl.cn/img/2019-08-28/e179fa99-8405-4.mp4', 15003, '3', 11697.00, '53a0435700d1fe8dbfd3c9f91989d066', '2019-08-28 19:11:43', NULL);
INSERT INTO `tb_system_file` VALUES (37, 'fea05e58-a4fd-4.mp4', 'http://image.lzllzl.cn/img/2019-08-28/fea05e58-a4fd-4.mp4', 15003, '3', 13596.00, '9990d7617b26e99913bf3d349b1041aa', '2019-08-28 19:17:18', NULL);
INSERT INTO `tb_system_file` VALUES (38, '768a7983-011c-4.mp4', 'http://image.lzllzl.cn/img/2019-08-28/768a7983-011c-4.mp4', 15003, '3', 14067.00, '9b6167c186a0ebf229f7b86ac01ed852', '2019-08-28 19:22:38', NULL);
INSERT INTO `tb_system_file` VALUES (39, 'c09cefd1-c419-4.MP4', 'http://image.lzllzl.cn/img/2019-08-28/c09cefd1-c419-4.MP4', 15003, '3', 4496.00, 'b7111bed2acd955a342e01db7cc85151', '2019-08-28 19:26:49', NULL);
INSERT INTO `tb_system_file` VALUES (40, '8d461117-3867-4.mp4', 'http://image.lzllzl.cn/img/2019-08-28/8d461117-3867-4.mp4', 15003, '3', 3462.00, '822e02b1888672635cdca8e9521f53a4', '2019-08-28 19:32:39', NULL);
INSERT INTO `tb_system_file` VALUES (41, 'af6c9203-75ab-4.docx', 'http://image.lzllzl.cn/img/2019-08-28/af6c9203-75ab-4.docx', 15003, '4', 17.00, 'f2bb33409d9fe9b7426b9fcf0e5cf4e7', '2019-08-28 19:37:20', NULL);
INSERT INTO `tb_system_file` VALUES (42, '3994d578-3c8a-4.exe', 'http://image.lzllzl.cn/img/2019-08-29/3994d578-3c8a-4.exe', 15002, '5', 701.00, 'e68f1ea7abc8b228ee27eba443b5f97c', '2019-08-29 08:50:15', NULL);
INSERT INTO `tb_system_file` VALUES (43, '6397eeb7-5b90-4.pdf', 'http://image.lzllzl.cn/img/2019-08-29/6397eeb7-5b90-4.pdf', 15003, '4', 45.00, '074290fd336186ce017ee8e3c36ab838', '2019-08-29 09:04:43', NULL);
INSERT INTO `tb_system_file` VALUES (44, '2d3e001d-e5cf-4.jpg', 'http://image.lzllzl.cn/img/2019-08-29/2d3e001d-e5cf-4.jpg', 15002, '1', 132.00, '80b36a84c182e9031ead4236a591159c', '2019-08-29 09:08:32', NULL);
INSERT INTO `tb_system_file` VALUES (45, 'a71b86c8-11f2-4.jpg', 'http://image.lzllzl.cn/img/2019-08-29/a71b86c8-11f2-4.jpg', 15002, '1', 107.00, 'aa66308018babe39cb1c5d791de5015d', '2019-08-29 09:12:02', NULL);
INSERT INTO `tb_system_file` VALUES (46, '560e82e1-321a-4.mp3', 'http://image.lzllzl.cn/img/2019-08-29/560e82e1-321a-4.mp3', 15003, '2', 3786.00, 'e7d3a5ded300416d1a0e91bcfee59ded', '2019-08-29 09:17:11', NULL);
INSERT INTO `tb_system_file` VALUES (47, '55579edf-e20c-4.jpg', 'http://image.lzllzl.cn/img/2019-08-29/55579edf-e20c-4.jpg', 15002, '1', 138.00, '7ab9a0316d0bde60a8b8b22b00d1165f', '2019-08-29 09:27:20', NULL);
INSERT INTO `tb_system_file` VALUES (48, '424e180e-66bb-4.jpg', 'http://image.lzllzl.cn/img/2019-08-29/424e180e-66bb-4.jpg', 15002, '1', 39.00, 'a6dae4c1b3fadb65fa3bba031b165578', '2019-08-29 09:28:31', NULL);
INSERT INTO `tb_system_file` VALUES (49, '5968dedd-d05a-4.jpg', 'http://image.lzllzl.cn/img/2019-08-29/5968dedd-d05a-4.jpg', 15002, '1', 47.00, '172f6b93e17acaf1b7c50dcf3858913d', '2019-08-29 09:32:13', NULL);
INSERT INTO `tb_system_file` VALUES (50, '5893cd17-6e09-4.jpg', 'http://image.lzllzl.cn/img/2019-08-29/5893cd17-6e09-4.jpg', 15002, '1', 1888.00, 'b662f245090ee4c47ed5002adb5b981a', '2019-08-29 09:34:12', NULL);
INSERT INTO `tb_system_file` VALUES (51, 'cadbdb95-f7e6-4.doc', 'http://image.lzllzl.cn/img/2019-08-29/cadbdb95-f7e6-4.doc', 15002, '4', 1264.00, 'bfd0acc235cdd866ae5cf82e3a739e92', '2019-08-29 09:36:33', NULL);
INSERT INTO `tb_system_file` VALUES (52, '0b8bb1e7-e27b-4.docx', 'http://image.lzllzl.cn/img/2019-08-29/0b8bb1e7-e27b-4.docx', 15002, '4', 503.00, '35a0f39809e26132a0ac3385f0fd62b9', '2019-08-29 09:40:43', NULL);
INSERT INTO `tb_system_file` VALUES (53, '13249416-5c29-4.rar', 'http://image.lzllzl.cn/img/2019-08-29/13249416-5c29-4.rar', 15003, '5', 3772.00, '3b536549f1549ecfec8ef6b8d9ed5001', '2019-08-29 10:19:55', NULL);
INSERT INTO `tb_system_file` VALUES (54, 'a958b227-3a52-4.pptx', 'http://image.lzllzl.cn/img/2019-08-29/a958b227-3a52-4.pptx', 15003, '4', 430.00, 'd0e28edce9bd975d7be2b9fb1ea63385', '2019-08-29 10:59:10', NULL);
INSERT INTO `tb_system_file` VALUES (55, '6d3f1cd4-8254-4.jpg', 'http://image.lzllzl.cn/img/2019-08-29/6d3f1cd4-8254-4.jpg', 15002, '1', 4928.00, '5b27cec5788f60edc6fd2a13e8f4f7fb', '2019-08-29 11:31:22', NULL);
INSERT INTO `tb_system_file` VALUES (56, 'cc0d8363-2d09-4.jpg', 'http://image.lzllzl.cn/img/2019-08-29/cc0d8363-2d09-4.jpg', 15001, '1', 74.00, '1cda71787ac6f6ec646aa86ed3ac533f', '2019-08-29 11:36:16', NULL);
INSERT INTO `tb_system_file` VALUES (57, '8e57d896-e42d-4.png', 'http://image.lzllzl.cn/img/2019-08-29/8e57d896-e42d-4.png', 15001, '1', 176.00, '2c8f874cc8a65404ec1110923219fecd', '2019-08-29 11:36:28', NULL);
INSERT INTO `tb_system_file` VALUES (59, '55d421c3-39bf-4.docx', 'http://image.lzllzl.cn/img/2019-08-29/55d421c3-39bf-4.docx', 15001, '4', 219.00, '6097acef2c6e51d7e629b623e3d106ba', '2019-08-29 19:51:50', NULL);
INSERT INTO `tb_system_file` VALUES (60, '5c2eb0e3-d7f6-4.doc', 'http://image.lzllzl.cn/img/2019-08-30/5c2eb0e3-d7f6-4.doc', 15001, '4', 202.00, '7c3c465176ef391e74562cfa6396b1df', '2019-08-30 11:22:55', NULL);
INSERT INTO `tb_system_file` VALUES (61, 'fd7de333-6400-4.xlsx', 'http://image.lzllzl.cn/img/2019-08-30/fd7de333-6400-4.xlsx', 15001, '4', 1149.00, '6f90eff0ae09d4969e24b066565160ea', '2019-08-30 13:48:44', NULL);
INSERT INTO `tb_system_file` VALUES (62, '4c05d18d-fde5-4.mp3', 'http://image.lzllzl.cn/img/2019-08-30/4c05d18d-fde5-4.mp3', 15002, '2', 11410.00, 'ce4e81c5a3da5bdadccea433cdd64744', '2019-08-30 14:39:48', NULL);
INSERT INTO `tb_system_file` VALUES (63, '7bb457ae-3536-4.jpg', 'http://image.lzllzl.cn/img/2019-08-31/7bb457ae-3536-4.jpg', 15002, '1', 146.00, 'ff26167285ad5ded6ebd36e1f5ef8a69', '2019-08-31 09:23:06', NULL);
INSERT INTO `tb_system_file` VALUES (64, '9c4b092a-0e22-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/9c4b092a-0e22-4.jpg', 15003, '1', 14.00, '8cd351e32daa1201a75f45f496855ae2', '2019-09-02 10:35:27', NULL);
INSERT INTO `tb_system_file` VALUES (65, 'c44f0440-c078-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/c44f0440-c078-4.jpg', 15003, '1', 24.00, '40ec3a19367dcb3057e26359f701e71d', '2019-09-02 10:35:55', NULL);
INSERT INTO `tb_system_file` VALUES (66, 'efc1ca0b-5d69-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/efc1ca0b-5d69-4.jpg', 15003, '1', 5.00, '285e439d51abbe6b85ead78bfda543fb', '2019-09-02 10:36:01', NULL);
INSERT INTO `tb_system_file` VALUES (67, 'bb1705ae-3a8e-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/bb1705ae-3a8e-4.jpg', 15003, '1', 8.00, '0a315f6866958a46b821aa8d43a2162b', '2019-09-02 10:36:09', NULL);
INSERT INTO `tb_system_file` VALUES (68, '6208837f-02d5-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/6208837f-02d5-4.jpg', 15003, '1', 39.00, '9f14669a5371cfb225cbdd7a32204ba6', '2019-09-02 10:36:20', NULL);
INSERT INTO `tb_system_file` VALUES (69, '385d67dc-78df-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/385d67dc-78df-4.jpg', 15003, '1', 10.00, 'ce3d9064046365266431131f306514de', '2019-09-02 10:36:29', NULL);
INSERT INTO `tb_system_file` VALUES (70, 'd17ddc4d-da6d-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/d17ddc4d-da6d-4.jpg', 15003, '1', 25.00, 'fe44121b334378bf4affad4d5c4895bf', '2019-09-02 10:36:35', NULL);
INSERT INTO `tb_system_file` VALUES (71, '09ecea63-2a3b-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/09ecea63-2a3b-4.jpg', 15003, '1', 11.00, '6e893f3e8ac61a7fbc733541cfcc4a17', '2019-09-02 10:36:42', NULL);
INSERT INTO `tb_system_file` VALUES (72, '21347ef2-a9c2-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/21347ef2-a9c2-4.jpg', 15003, '1', 44.00, '5e57d8daa03a90d4a0996a975f1de0fc', '2019-09-02 10:36:49', NULL);
INSERT INTO `tb_system_file` VALUES (73, '10672063-3473-4.jpg', 'http://image.lzllzl.cn/img/2019-09-02/10672063-3473-4.jpg', 15003, '1', 42.00, '2846ac07728fc618c655ffaf7a19d083', '2019-09-02 10:36:56', NULL);
INSERT INTO `tb_system_file` VALUES (74, 'fb37ebb3-5922-4.mp4', 'http://image.lzllzl.cn/img/2019-09-02/fb37ebb3-5922-4.mp4', 15003, '3', 1015.00, '514ff4b151a69db8e5d22ea6187d1491', '2019-09-02 10:38:27', NULL);
INSERT INTO `tb_system_file` VALUES (75, 'd55f8923-cd96-4.docx', 'http://image.lzllzl.cn/img/2019-09-02/d55f8923-cd96-4.docx', 15003, '4', 48.00, 'ba0b92c6b4c92bfd98404b9c6b40d017', '2019-09-02 10:38:52', NULL);
INSERT INTO `tb_system_file` VALUES (76, 'ab4e84a6-561a-4.docx', 'http://image.lzllzl.cn/img/2019-09-02/ab4e84a6-561a-4.docx', 15003, '4', 259.00, 'bb13c6934fb79cd9af8a7eebee507ddd', '2019-09-02 10:39:19', NULL);
INSERT INTO `tb_system_file` VALUES (77, 'd3a758d8-f2d5-4.xltx', 'http://image.lzllzl.cn/img/2019-09-02/d3a758d8-f2d5-4.xltx', 15003, '5', 26.00, '33a008484b342dfb7e469b5031a84698', '2019-09-02 10:39:59', NULL);
INSERT INTO `tb_system_file` VALUES (78, 'd70bb63e-1c86-4.xlsx', 'http://image.lzllzl.cn/img/2019-09-02/d70bb63e-1c86-4.xlsx', 15003, '4', 39.00, '63a81d9462ac4a3d916fa6f3421ea104', '2019-09-02 10:41:21', NULL);
INSERT INTO `tb_system_file` VALUES (79, '22ba675f-74b7-4.mp3', 'http://image.lzllzl.cn/img/2019-09-02/22ba675f-74b7-4.mp3', 15003, '2', 507.00, '47b9e91fa9a4b80ecc7d750e8365340b', '2019-09-02 10:42:26', NULL);
INSERT INTO `tb_system_file` VALUES (80, '1fb7a492-630d-4.rar', 'http://image.lzllzl.cn/img/2019-09-02/1fb7a492-630d-4.rar', 15003, '5', 286.00, 'bffb188e1968b7aea965fdf4dc779c88', '2019-09-02 10:42:41', NULL);
INSERT INTO `tb_system_file` VALUES (81, '9af8b22c-f40f-4.zip', 'http://image.lzllzl.cn/img/2019-09-02/9af8b22c-f40f-4.zip', 15003, '5', 58.00, '4adb074f8ee2126ae6d14f7054053836', '2019-09-02 10:42:51', NULL);
INSERT INTO `tb_system_file` VALUES (82, 'd1098518-cbf7-4.xlsx', 'http://image.lzllzl.cn/img/2019-09-02/d1098518-cbf7-4.xlsx', 15003, '4', 30.00, '6a7b2c51e889b0ff3c666e9bd1f2f354', '2019-09-02 10:49:39', NULL);
INSERT INTO `tb_system_file` VALUES (83, 'd25a3b03-3498-4.properties', 'http://image.lzllzl.cn/img/2019-09-02/d25a3b03-3498-4.properties', 15001, '5', 0.00, 'ab201df09c2dfe4156ca10fc1e8f1ab4', '2019-09-02 11:13:10', NULL);
INSERT INTO `tb_system_file` VALUES (84, '4b1f0129-6667-4.yml', 'http://image.lzllzl.cn/img/2019-09-02/4b1f0129-6667-4.yml', 15001, '5', 0.00, 'a206d5f5b2895852a38b08b92390058c', '2019-09-02 11:13:25', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `user_password` varchar(32) NOT NULL COMMENT '密码',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `user_email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `user_level` char(2) NOT NULL DEFAULT '1' COMMENT '用户级别',
  `drive_size` bigint(20) unsigned DEFAULT '51200' COMMENT '网盘可用空间，单位kb',
  `user_sex` varchar(1) DEFAULT NULL COMMENT '性别F女M男',
  `user_nickname` varchar(30) DEFAULT NULL COMMENT '昵称',
  `user_imgurl` varchar(255) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES (15001, 'zayvion', 'ceec0192adc4ab59bf637efa03796467', '15873203497', '253596389@qq.com', '2', 51200, 'M', 'Zayvion', 'http://image.lzllzl.cn/img/2019-08-28/6c263111-1d14-4.jpg');
INSERT INTO `tb_user` VALUES (15002, 'dengchao', '1f2e07c7ddc3e7168cddefac515d1d5a', '18229735193', 'dc@drper.cn', '1', 51200, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (15003, 'zhangwenfeng', '573228ade97b47dbe0eec5e1371c400b', '18973648191', '953615108@qq.com', '1', 51200, 'M', 'NeeDaye', 'http://image.lzllzl.cn/img/2019-08-28/2a4fa464-b90c-4.png');
INSERT INTO `tb_user` VALUES (15004, 'zhanshi', '2579d2ae255377afd5cc7fd035e150c9', '17608428848', '253596389@qq.com', '1', 51200, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_user_file
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_file`;
CREATE TABLE `tb_user_file` (
  `userfile_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户文件ID',
  `user_sysfile_id` bigint(20) DEFAULT NULL COMMENT '对应系统文件表的id',
  `user_file_name` varchar(100) NOT NULL COMMENT '用户对应文件的名字',
  `belong_user` bigint(255) unsigned NOT NULL COMMENT '所属用户',
  `file_type` char(2) DEFAULT NULL COMMENT '文件类型，1图片2音频3视频4文档5其他',
  `file_size` decimal(10,2) DEFAULT NULL COMMENT '文件大小',
  `file_location` bigint(255) unsigned NOT NULL COMMENT '文件所属文件夹的位置',
  `upload_time` timestamp NULL DEFAULT NULL COMMENT '用户上传文件时间',
  `isDel` smallint(6) DEFAULT '0' COMMENT '是否删除,1为删除',
  PRIMARY KEY (`userfile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_file
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_file` VALUES (30, 29, '20190726155711.jpg', 15002, '1', 1279.00, 0, '2019-08-28 17:41:26', 1);
INSERT INTO `tb_user_file` VALUES (31, 30, '20190726155711.jpg', 15002, '1', 1279.00, 0, '2019-08-28 17:41:26', 1);
INSERT INTO `tb_user_file` VALUES (32, 31, '109951163943011786.jpg', 15002, '1', 49.00, 10015, '2019-08-28 17:44:29', 1);
INSERT INTO `tb_user_file` VALUES (33, 32, 'layuiAdmin std v1.x 【iframe 常规版】开发者文档.pdf', 15002, '5', 539.00, 10002, '2019-08-28 17:47:12', 0);
INSERT INTO `tb_user_file` VALUES (35, 35, '2018200282-邓超-实验三.doc', 15002, '4', 634.00, 10017, '2019-08-28 17:51:02', 1);
INSERT INTO `tb_user_file` VALUES (44, 42, 'JsonFormat.exe', 15002, '5', 701.00, 10001, '2019-08-29 08:50:15', 0);
INSERT INTO `tb_user_file` VALUES (46, 44, 'WIN_20190712_15_49_23_Pro.jpg', 15002, '1', 132.00, 10015, '2019-08-29 09:08:32', 1);
INSERT INTO `tb_user_file` VALUES (47, 45, 'WIN_20190612_20_09_06_Pro.jpg', 15002, '1', 107.00, 10003, '2019-08-29 09:12:02', 1);
INSERT INTO `tb_user_file` VALUES (49, 47, '微信图片_20190726172008.jpg', 15002, '1', 138.00, 10015, '2019-08-29 09:27:20', 0);
INSERT INTO `tb_user_file` VALUES (50, 48, 'smile.jpg', 15002, '1', 39.00, 10015, '2019-08-29 09:28:31', 1);
INSERT INTO `tb_user_file` VALUES (51, 49, '109951163943015626.jpg', 15002, '1', 47.00, 10015, '2019-08-29 09:32:13', 1);
INSERT INTO `tb_user_file` VALUES (52, 50, 'test.jpg', 15002, '1', 1888.00, 10015, '2019-08-29 09:34:13', 1);
INSERT INTO `tb_user_file` VALUES (53, 51, '2018200282 邓超 OA办公自动化系统概要设计说明书.doc', 15002, '4', 1264.00, 10017, '2019-08-29 09:36:33', 0);
INSERT INTO `tb_user_file` VALUES (54, 52, '2018200282-邓超-实验五 模块设计.docx', 15002, '4', 503.00, 10017, '2019-08-29 09:40:43', 0);
INSERT INTO `tb_user_file` VALUES (57, 55, '85d3bc014a90f60394f557af3412b31bb151ed67.jpg', 15002, '1', 4928.00, 0, '2019-08-29 11:31:22', 0);
INSERT INTO `tb_user_file` VALUES (62, 46, '林俊杰 - 对的时间点.mp3', 15002, '2', 3786.00, 10019, '2019-08-29 11:50:03', 1);
INSERT INTO `tb_user_file` VALUES (63, 15, '2020届毕业生秋季校招网申信息汇总(4).xlsx', 15002, '4', 633.00, 0, '2019-08-29 14:30:28', 0);
INSERT INTO `tb_user_file` VALUES (66, 40, '学习视频.mp4', 15002, '3', 3462.00, 10017, '2019-08-29 15:37:18', 1);
INSERT INTO `tb_user_file` VALUES (81, 61, '2020届毕业生秋季校招网申信息汇总.xlsx', 15001, '4', 1149.00, 0, '2019-08-30 13:48:45', 0);
INSERT INTO `tb_user_file` VALUES (82, 62, '阿冗 - 太多 (cover：陈冠蒲).mp3', 15002, '2', 11410.00, 10020, '2019-08-30 14:39:48', 0);
INSERT INTO `tb_user_file` VALUES (83, 63, '寸照.jpg', 15002, '1', 146.00, 10015, '2019-08-31 09:23:06', 1);
INSERT INTO `tb_user_file` VALUES (86, 57, '风景3.png', 15001, '1', 176.00, 0, '2019-08-31 11:38:40', 0);
INSERT INTO `tb_user_file` VALUES (87, 64, '1.jpg', 15003, '1', 14.00, 0, '2019-09-02 10:35:27', 1);
INSERT INTO `tb_user_file` VALUES (88, 65, '2.jpg', 15003, '1', 24.00, 0, '2019-09-02 10:35:55', 1);
INSERT INTO `tb_user_file` VALUES (89, 66, '3.jpg', 15003, '1', 5.00, 0, '2019-09-02 10:36:02', 0);
INSERT INTO `tb_user_file` VALUES (90, 67, '4.jpg', 15003, '1', 8.00, 0, '2019-09-02 10:36:09', 0);
INSERT INTO `tb_user_file` VALUES (91, 68, '5.jpg', 15003, '1', 39.00, 0, '2019-09-02 10:36:20', 0);
INSERT INTO `tb_user_file` VALUES (92, 69, '6.jpg', 15003, '1', 10.00, 0, '2019-09-02 10:36:29', 0);
INSERT INTO `tb_user_file` VALUES (93, 70, '7.jpg', 15003, '1', 25.00, 0, '2019-09-02 10:36:35', 0);
INSERT INTO `tb_user_file` VALUES (94, 71, '8.jpg', 15003, '1', 11.00, 0, '2019-09-02 10:36:42', 0);
INSERT INTO `tb_user_file` VALUES (95, 72, '9.jpg', 15003, '1', 44.00, 0, '2019-09-02 10:36:49', 0);
INSERT INTO `tb_user_file` VALUES (96, 73, '10.jpg', 15003, '1', 42.00, 0, '2019-09-02 10:36:56', 0);
INSERT INTO `tb_user_file` VALUES (97, 38, '好好学习.mp4', 15003, '3', 14067.00, 0, '2019-09-02 10:38:05', 0);
INSERT INTO `tb_user_file` VALUES (98, 74, '中秋祝福.mp4', 15003, '3', 1015.00, 0, '2019-09-02 10:38:27', 0);
INSERT INTO `tb_user_file` VALUES (99, 75, '会议议程.docx', 15003, '4', 48.00, 0, '2019-09-02 10:38:52', 0);
INSERT INTO `tb_user_file` VALUES (100, 76, '学校项目或报告套件.docx', 15003, '4', 259.00, 0, '2019-09-02 10:39:19', 0);
INSERT INTO `tb_user_file` VALUES (102, 78, '每月大学预算.xlsx', 15003, '4', 39.00, 0, '2019-09-02 10:41:21', 0);
INSERT INTO `tb_user_file` VALUES (103, 46, '林俊杰 - 对的时间点.mp3', 15003, '2', 3786.00, 0, '2019-09-02 10:42:04', 0);
INSERT INTO `tb_user_file` VALUES (104, 79, '网络歌手 - 芒种（路飞版）.mp3', 15003, '2', 507.00, 0, '2019-09-02 10:42:26', 0);
INSERT INTO `tb_user_file` VALUES (105, 80, 'docx.rar', 15003, '5', 286.00, 0, '2019-09-02 10:42:41', 0);
INSERT INTO `tb_user_file` VALUES (106, 81, 'excel.zip', 15003, '5', 58.00, 0, '2019-09-02 10:42:51', 0);
INSERT INTO `tb_user_file` VALUES (107, 82, '活动跟踪器.xlsx', 15003, '4', 30.00, 0, '2019-09-02 10:49:39', 0);
INSERT INTO `tb_user_file` VALUES (108, 83, 'jdbc.properties', 15001, '5', 0.00, 10006, '2019-09-02 11:13:10', 0);
INSERT INTO `tb_user_file` VALUES (109, 84, 'application-druid.yml', 15001, '5', 0.00, 10006, '2019-09-02 11:13:25', 0);
INSERT INTO `tb_user_file` VALUES (110, 35, '风景1.jpg', 15001, '1', 9.00, 10018, '2019-09-02 11:13:40', 0);
INSERT INTO `tb_user_file` VALUES (111, 48, 'smile.jpg', 15002, '1', 39.00, 0, '2019-09-02 11:48:43', 1);
INSERT INTO `tb_user_file` VALUES (112, 75, '会议议程.docx', 15004, '4', 48.00, 10028, '2019-09-02 14:36:11', 0);
INSERT INTO `tb_user_file` VALUES (113, 82, '活动跟踪器.xlsx', 15004, '4', 30.00, 10028, '2019-09-02 14:36:24', 0);
INSERT INTO `tb_user_file` VALUES (114, 64, '1.jpg', 15004, '1', 14.00, 0, '2019-09-02 14:36:33', 0);
INSERT INTO `tb_user_file` VALUES (115, 46, '林俊杰 - 对的时间点.mp3', 15004, '2', 3786.00, 10029, '2019-09-02 14:37:04', 0);
INSERT INTO `tb_user_file` VALUES (116, 38, '好好学习.mp4', 15004, '3', 14067.00, 10031, '2019-08-12 14:37:36', 0);
INSERT INTO `tb_user_file` VALUES (117, 65, '2.jpg', 15004, '1', 24.00, 10032, '2019-08-02 14:41:02', 0);
INSERT INTO `tb_user_file` VALUES (118, 66, '3.jpg', 15004, '1', 5.00, 10032, '2019-09-01 14:42:23', 0);
INSERT INTO `tb_user_file` VALUES (119, 67, '4.jpg', 15004, '1', 8.00, 10032, '2019-09-02 14:42:29', 0);
INSERT INTO `tb_user_file` VALUES (120, 68, '5.jpg', 15004, '1', 39.00, 10032, '2019-09-02 14:42:36', 0);
INSERT INTO `tb_user_file` VALUES (121, 69, '6.jpg', 15004, '1', 10.00, 10032, '2019-09-02 14:42:45', 0);
INSERT INTO `tb_user_file` VALUES (122, 80, 'docx.rar', 15004, '5', 286.00, 0, '2019-09-02 14:55:20', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
