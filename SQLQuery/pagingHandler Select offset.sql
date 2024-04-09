use springbasic;

select * from board;

SELECT *
  FROM board
  ORDER BY reg_date DESC, bno DESC
  LIMIT 10 OFFSET 0;
