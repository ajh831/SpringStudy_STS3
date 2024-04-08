select * from board order by bno desc;

set @rown:=0;

select a.* from (
	select row_number() over(order by bno desc) as num,
		   bno
	from board) as a
where 1=1
and a.num <= 10;

select a.* from (
	select row_number() over(order by bno desc) as num,
		   bno
	from board) as a
where 1=1
and a.num between 11 and 20;