-- ----------------------------
-- 增加同步记录表
-- ----------------------------
  create table Sync(
	userId nvarchar(20) not null,
	token nvarchar(50) not null,
	createDate datetime not null,
    primary key (userId)
  );