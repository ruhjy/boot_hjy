-- LIKE 
select * from Customers;
select * from Customers where CustomerName like 'a%';
select * from Customers where CustomerName like '%a';
select * from Customers where CustomerName like '%or%';
select * from Customers where CustomerName like '_r%';
select * from Customers where CustomerName like 'a_%_%';
select * from Customers where CustomerName like 'a%o';
select CustomerID, CustomerName, Address from Customers where CustomerName like '%or%';

-- 고객명(CustomerName), 계약명(ContactName) 에 'or'이 포함된 고객들 조회
select * from Customers 
where CustomerName like '%or%' or ContactName like '%or%';

select CustomerID, CustomerName, ContactName, Address from Customers where CustomerName like '%or%';