create table TableA (
	Num1 int
);
create table TableB (
	Num2 int
);
desc TableA;
desc TableB;

insert into TableA (Num1) values (1), (2), (3), (4), (5);
insert into TableB (Num2) values (3), (4), (5), (6), (7);

select * from TableA; -- 1, 2, 3, 4, 5
select * from TableB; -- 3, 4, 5, 6, 7

select * from TableA join TableB; -- cartesian product

select * from TableA a join TableB b
on a.Num1 = b.Num2; -- inner join

select * from TableA a left join TableB b
on a.Num1 = b.Num2; -- left join 

select * from TableA a right join TableB b
on a.Num1 = b.Num2; -- right join