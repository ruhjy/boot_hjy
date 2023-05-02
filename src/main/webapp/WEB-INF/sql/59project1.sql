use Board;
select count(*) from Board;
select * from Board order by id desc;

insert into Board (title, body, writer)
select title, body, writer from Board;