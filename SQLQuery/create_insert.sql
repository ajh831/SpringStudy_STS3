use springbasic;

show tables;

CREATE TABLE registerTB (
  idx INT(11) NOT NULL AUTO_INCREMENT,
  id VARCHAR(8) NOT NULL UNIQUE,
  pwd VARCHAR(12) NOT NULL,
  name VARCHAR(10) NOT NULL,
  birth DATE,
  address  VARCHAR(255),
  CONSTRAINT testTable_PK PRIMARY KEY(id)
);

CREATE TABLE registerTB (
  idx INT(11) NOT NULL AUTO_INCREMENT,
  id VARCHAR(8) NOT NULL,
  pwd VARCHAR(12) NOT NULL,
  name VARCHAR(10) NOT NULL,
  birth DATE,
  address VARCHAR(255),
  PRIMARY KEY (id),
  UNIQUE KEY idx (idx)
);

show tables;

INSERT INTO REGISTERTB(ID, PWD, NAME) VALUES ('ASD2', 'AFDFS', 'DDD');

SELECT * FROM REGISTERTB;

SELECT COUNT(*) FROM REGISTERTB;

DROP TABLE REGISTERTB;

COMMIT;

CREATE TABLE registerTB (
  id VARCHAR(8),
  pwd VARCHAR(12) NOT NULL,
  name VARCHAR(10) NOT NULL,
  birth DATE NOT NULL,
  address VARCHAR(255),
  reg_date Date,
  CONSTRAINT testTable_PK PRIMARY KEY (id)
);

select * from registerTB;

CREATE TABLE tb (
	bno INT(11)
);

select * from tb;

insert into tb values (1),(2),(3);

select * from tb
where 1=1
&& bno >= 2
&& bno <= 3;

-- board : bno, title, content, writer, view_cnt, comment_cnt, reg_date, up_date
-- insert select
insert into board(title, content, writer, view_cnt, comment_cnt, reg_date, up_date)
select title, content, writer, view_cnt, comment_cnt, reg_date, up_date from board;
-- 위에 계속하면 계속 삽입됨 -> 이렇게 데이터 넣고 페이징 테스트하면 됨

-- insert into board(title, content, writer, view_cnt, comment_cnt, reg_date, up_date)
-- values("title1", "content1", "writer1", 0, 0 ,now(), now());

show variables like 'c%';

INSERT INTO REGISTERTB() VALUES('asdf', '1234', '홍길동', '1999-01-01', '서울특별시 강남구 테헤란로', now());

INSERT INTO REGISTERTB() VALUES('test', '1234', '테스트', '1999-01-01', '경기도', now());