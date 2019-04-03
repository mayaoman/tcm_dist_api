
INSERT INTO `tcmdb.tcm_role` (`id`,`name`) VALUES ('5e0caaeb-9504-4d7f-811e-7227d146520d','ROLE_ADMIN');
INSERT INTO `tcmdb.tcm_role` (`id`,`name`) VALUES ('7299841d-f7d0-4600-9b56-727a51c38209','ROLE_DOCTOR');
INSERT INTO `tcmdb.tcm_role` (`id`,`name`) VALUES ('90e13d02-fc17-4a56-8ddf-8848a60d2dd5','ROLE_SALES');

INSERT INTO `tcmdb.tcm_user_group` (`id`,`name`,`role_id`) VALUES ('31643f46-8538-4876-85d5-c1ceb39590b8','管理员组','5e0caaeb-9504-4d7f-811e-7227d146520d');
INSERT INTO `tcmdb.tcm_user_group` (`id`,`name`,`role_id`) VALUES ('5d289ad7-f7de-4c1e-ac4b-900e4133fa55','销售助理组','90e13d02-fc17-4a56-8ddf-8848a60d2dd5');
INSERT INTO `tcmdb.tcm_user_group` (`id`,`name`,`role_id`) VALUES ('7b147eed-2770-4347-99e6-b5321c9ce05c','患者组','54197a9c-0ec9-4f9e-b90f-cc49929295e2');
INSERT INTO `tcmdb.tcm_user_group` (`id`,`name`,`role_id`) VALUES ('efc28a88-e468-46d3-8674-447f1bc357f9','医生组','7299841d-f7d0-4600-9b56-727a51c38209');

INSERT INTO `tcmdb.tcm_user` (`id`,`cell_phone_num`,`email`,`head_img_url`,`password`,`sex`,`username`,`wx_nick_name`,`wx_open_id`,`user_group_id`) VALUES ('00',NULL,NULL,NULL,'admin',NULL,'admin',NULL,NULL,'31643f46-8538-4876-85d5-c1ceb39590b8');
