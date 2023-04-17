-- alias : 별칭

select * from Customers;
select CustomerID, CustomerName from Customers;
select CustomerID as id, CustomerName as name from Customers;
-- as 생략 가능
select CustomerID id, CustomerName name from Customers;

select CustomerID id, CustomerName name from Customers order by CustomerID;
select CustomerID id, CustomerName name from Customers order by id;
select CustomerID id, CustomerName name from Customers order by 1;

select Country, COUNT(CustomerID) from Customers group by Country;
select Country c, COUNT(CustomerID) NumOfCustomer from Customers group by c;
select Country c, COUNT(CustomerID) NumOfCustomer from Customers group by Country;

-- group by, order by에서 별칭으로도 사용 가능, as 생략 가능
select Country c, COUNT(CustomerID) as NumOfCustomer from Customers group by c order by NumOfCustomer;
select Country c, COUNT(CustomerID) NumOfCustomer from Customers group by Country order by 2; 
select Country c, COUNT(CustomerID) NumOfCustomer from Customers group by Country order by COUNT(CustomerID); 

-- keyword 사용시 backtick
select Country as `FROM`, CustomerName from Customers; 
select `Country` as `FROM`, `CustomerName` from `Customers`;
