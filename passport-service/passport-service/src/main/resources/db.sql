create table account (
  account_id int not null auto_increment comment '账号id',
  username varchar(50) not null comment '用户名',
  password varchar(128) not null comment '密码',
  register_date timestamp not null default current_timestamp comment '注册日期',
  primary key (account_id),
  unique key (username)
) comment '账号';