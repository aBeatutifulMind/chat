create table chatmessage(
id int(10) unsigned not null auto_increment primary key,
message varchar(4000) not null,
username varchar(100) not null,
msgtime datetime not null,
colorselected varchar(45) not null
);
