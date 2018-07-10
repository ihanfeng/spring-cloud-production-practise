CREATE TABLE `log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户日志id',
  `log_uuid` varchar(36) NOT NULL COMMENT '日志uuid',
  `client_id` varchar(20) NOT NULL COMMENT '客户端id',
  `client_version` varchar(10) NOT NULL COMMENT '客户端版本号',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `log_type` int(11) NOT NULL COMMENT '日志类型',
  `object_ids` varchar(1000) NOT NULL COMMENT '对象id',
  `message` varchar(4000) NOT NULL COMMENT '日志内容',
  `log_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '日志日期',
  PRIMARY KEY (`log_id`),
  UNIQUE KEY (`log_uuid`),
  KEY (`user_id`)
) COMMENT='日志'