-- LIKE 
select * from Customers;
select * from Customers where CustomerName like 'a%';
select * from Customers where CustomerName like '%a';
select * from Customers where CustomerName like '%or%';
select * from Customers where CustomerName like '_r%';
select * from Customers where CustomerName like 'a_%_%';
select * from Customers where CustomerName like 'a_%';
select * from Customers where CustomerName like 'a%o';
select * from Customers where CustomerName like 'c%o';