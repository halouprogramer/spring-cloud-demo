
create database if not exists  student default charset utf8;
use student;
create table student(
  id varchar(32) not null primary key ,
  student_name varchar(32) not null comment '学生姓名',
  gender tinyint(2) not null default 0 comment '0-男 2-女',
  school_id varchar(32) not null default '' comment '学校id'
)Engine=InnoDB default charset utf8;


create table school(
  id varchar(32) not null primary key ,
  school_name varchar(32) not null comment '学校名称'
)Engine=InnoDB default charset utf8 comment '学校';



insert into school values('1','清华大学');
insert into school values('2','北京大学');
