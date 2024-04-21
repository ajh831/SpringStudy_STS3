use springbasic;

select * from board;

SELECT *
  FROM board
  ORDER BY reg_date DESC, bno DESC
  LIMIT 10 OFFSET 0;

select a.* from (
	select row_number() over(order by bno desc) as num, bno
	from board
				) as a
where 1=1
and a.num between 131 and 140;

select a.* from (
	select row_number() over(order by bno desc) as num, bno
	from board
				) as a
where 1=1
and a.num between 1 and 10;