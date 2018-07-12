create table log (
  log_id int not null auto_increment comment '用户日志id',
  log_uuid varchar not null comment '日志uuid',
  user_id int not null comment '用户id',
  log_type int not null comment '日志类型',
  object_ids varchar not null comment '对象id',
  message varchar not null comment '日志内容',
  log_date timestamp not null default current_timestamp comment '日志日期',
  primary key (log_id),
  unique key (log_uuid),
  key (user_id)
) comment='日志'