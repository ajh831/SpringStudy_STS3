select * from board;

DROP TABLE BOARD;

CREATE TABLE board (
  bno INT(11) NOT NULL AUTO_INCREMENT,	-- 게시글 번호
  title VARCHAR(255) NOT NULL, -- 게시글 제목
  content VARCHAR(255) NOT NULL, -- 게시글 내용
  writer VARCHAR(45) DEFAULT NULL, -- 게시글 작성자
  view_cnt INT(11) DEFAULT '0', -- 조회수
  comment_cnt INT(11) DEFAULT '0', -- 댓글 수
  reg_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 작성일
  up_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 수정일
  CONSTRAINT board PRIMARY KEY (bno)
);

SELECT * FROM BOARD ORDER BY bno DESC;

insert into board(title, content, writer, view_cnt, comment_cnt, reg_date, up_date)
values("title1", "content1", "asdf", 0, 0 ,now(), now());

-- board : bno, title, content, writer, view_cnt, comment_cnt, reg_date, up_date
-- insert select
insert into board(title, content, writer, view_cnt, comment_cnt, reg_date, up_date)
select title, content, writer, view_cnt, comment_cnt, reg_date, up_date from board;
-- 위에 계속하면 계속 삽입됨 -> 이렇게 데이터 넣고 페이징 테스트하면 됨

insert into board(title, content, writer, view_cnt, comment_cnt, reg_date, up_date)
values("title1", "content1", "writer1", 0, 0 ,now(), now());

select count(*) from board;

SELECT now();

insert into board(title, content, writer)
values("title1", "content1", "test");