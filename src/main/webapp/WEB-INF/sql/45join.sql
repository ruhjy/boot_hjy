select * from Products;
select * from Categories;
select * from Suppliers;
select * from Customers;
select * from Employees;
select * from Orders;
select * from OrderDetails;
select * from Shippers;

-- 외래키 제약사항 추가
desc Products;
alter table Products
add foreign key (CategoryID) references Categories(CategoryID);
alter table Products 
add foreign key (SupplierID) references Suppliers(SupplierID);

desc OrderDetails;
alter table OrderDetails
add foreign key (OrderID) references Orders(OrderID);
alter table OrderDetails
add foreign key (ProductID) references Products(ProductID);

desc Orders;
alter table Orders
add foreign key (CustomerID) references Customers(CustomerID);
alter table Orders
add foreign key (EmployeeID) references Employees(EmployeeID);
alter table Orders
add foreign key (ShipperID) references Shippers(ShipperID);

select * from Products where ProductID = 1;
select * from Categories where CategoryID = 1;

-- JOIN
select * from Products join Categories on
Products.ProductID = Categories.CategoryID where Products.ProductID = 1;