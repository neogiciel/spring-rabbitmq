CREATE DATABASE message;
USE message;

drop table if exists MESSAGE;

create table MESSAGE ( 
  IDMESSAGE 	bigint (6) not null AUTO_INCREMENT,
  MESSAGE     varchar (250), 
  primary key (IDMESSAGE)
);

INSERT INTO MESSAGE (MESSAGE) VALUES ('Premier Message');