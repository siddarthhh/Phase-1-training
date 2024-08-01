create database rms
use rms
--Create Tables
CREATE TABLE Users (
    UserID INT IDENTITY(1,1) PRIMARY KEY,
    Username VARCHAR(50) UNIQUE NOT NULL,
    PasswordHash VARBINARY(255) NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Phone VARCHAR(20),
    Role VARCHAR(20) CHECK (Role IN ('Admin', 'Manager', 'Staff', 'Customer')) NOT NULL
);

CREATE TABLE MenuItems (
    MenuItemID INT IDENTITY(1,1) PRIMARY KEY,
    ItemName VARCHAR(100) NOT NULL,
    Description VARCHAR(255),
    Price DECIMAL(10, 2) NOT NULL,
    Available BIT NOT NULL
);

CREATE TABLE RestaurantTables (
    TableID INT IDENTITY(1,1) PRIMARY KEY,
    TableNumber VARCHAR(10) UNIQUE NOT NULL,
    Capacity INT NOT NULL,
    LocationDescription VARCHAR(255),
    Status VARCHAR(20) CHECK (Status IN ('Available', 'Occupied', 'Reserved')) NOT NULL
);

CREATE TABLE Orders (
    OrderID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT NOT NULL,
    OrderDate DATETIME NOT NULL,
    TotalAmount DECIMAL(10, 2) NOT NULL,
    TableID INT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (TableID) REFERENCES RestaurantTables(TableID)
);

CREATE TABLE OrderDetails (
    OrderDetailID INT IDENTITY(1,1) PRIMARY KEY,
    OrderID INT NOT NULL,
    MenuItemID INT NOT NULL,
    Quantity INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (MenuItemID) REFERENCES MenuItems(MenuItemID)
);

CREATE TABLE Reservations (
    ReservationID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT NOT NULL,
    TableID INT NOT NULL,
    ReservationDateTime DATETIME NOT NULL,
    NumberOfGuests INT NOT NULL,
    Status VARCHAR(20) CHECK (Status IN ('Pending', 'Confirmed', 'Cancelled')) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (TableID) REFERENCES RestaurantTables(TableID)
);
--INSERT RECORDS
INSERT INTO Users (Username, PasswordHash, FirstName, LastName, Email, Phone, Role)
VALUES 
('siddarth', CONVERT(VARBINARY(255), 'password1'), 'Siddarth', 'Sharma', 'siddarth@example.com', '9876543210', 'Admin'),
('aisha', CONVERT(VARBINARY(255), 'password2'), 'Aisha', 'Khan', 'aisha@example.com', '9876543211', 'Manager'),
('rahul', CONVERT(VARBINARY(255), 'password3'), 'Rahul', 'Singh', 'rahul@example.com', '9876543212', 'Staff'),
('ananya', CONVERT(VARBINARY(255), 'password4'), 'Ananya', 'Verma', 'ananya@example.com', '9876543213', 'Customer'),
('karthik', CONVERT(VARBINARY(255), 'password5'), 'Karthik', 'Nair', 'karthik@example.com', '9876543214', 'Customer');

INSERT INTO MenuItems (ItemName, Description, Price, Available)
VALUES 
('Paneer Butter Masala', 'Paneer cooked in rich buttery tomato gravy', 250.00, 1),
('Chicken Biryani', 'Spiced chicken and rice cooked together', 300.00, 1),
('Masala Dosa', 'Crispy rice crepe filled with spicy potato', 150.00, 1),
('Gulab Jamun', 'Fried dough balls soaked in sweet syrup', 100.00, 1),
('Butter Naan', 'Soft and fluffy bread with butter', 50.00, 1);
INSERT INTO RestaurantTables (TableNumber, Capacity, LocationDescription, Status)
VALUES 
('T1', 4, 'Near window', 'Available'),
('T2', 6, 'Center', 'Available'),
('T3', 2, 'Corner', 'Reserved'),
('T4', 4, 'Near entrance', 'Occupied'),
('T5', 4, 'Patio', 'Available');

INSERT INTO Orders (UserID, OrderDate, TotalAmount, TableID)
VALUES 
(4, '2023-07-30 12:30:00', 400.00, 1),
(4, '2023-07-30 13:30:00', 450.00, 2),
(4, '2023-07-30 14:30:00', 300.00, 3),
(4, '2023-07-30 15:30:00', 250.00, 4),
(4, '2023-07-30 16:30:00', 500.00, 5),
(4, '2023-07-30 17:30:00', 600.00, 1),
(4, '2023-07-30 18:30:00', 700.00, 2);

INSERT INTO OrderDetails (OrderID, MenuItemID, Quantity, Price)
VALUES 
(1, 1, 2, 500.00),
(1, 2, 1, 300.00),
(2, 3, 3, 450.00),
(3, 4, 3, 300.00),
(4, 5, 5, 250.00),
(5, 1, 2, 500.00),
(6, 2, 1, 600.00),
(7, 3, 3, 700.00);

INSERT INTO Reservations (UserID, TableID, ReservationDateTime, NumberOfGuests, Status)
VALUES 
(4, 3, '2023-08-15 19:00:00', 4, 'Pending'),
(4, 1, '2023-08-16 19:00:00', 2, 'Confirmed'),
(5, 2, '2023-08-17 19:00:00', 3, 'Pending'),
(5, 4, '2023-08-18 19:00:00', 5, 'Confirmed');


--Retrieve All Records from a Table
SELECT * FROM Users;


--Filter Records Based on a Condition
SELECT * FROM Orders WHERE OrderDate > '2023-01-01';


--Join Two Tables
SELECT Users.FirstName, Users.LastName, Orders.OrderID, RestaurantTables.TableNumber
FROM Users
INNER JOIN Orders ON Users.UserID = Orders.UserID
INNER JOIN RestaurantTables ON Orders.TableID = RestaurantTables.TableID;


--Aggregate Data Using Group By
SELECT UserID, COUNT(OrderID) AS TotalOrders
FROM Orders
GROUP BY UserID;

--Filter Groups Using HAVING
SELECT UserID, COUNT(OrderID) AS TotalOrders
FROM Orders
GROUP BY UserID
HAVING COUNT(OrderID) > 5;


--Order Results Using ORDER BY
SELECT * FROM MenuItems
ORDER BY Price DESC;


--Retrieve Data with a Subquery
SELECT FirstName, LastName
FROM Users
WHERE UserID IN (
    SELECT UserID
    FROM Orders
    GROUP BY UserID
    HAVING SUM(TotalAmount) > 1000
);

--Use CASE Statements
SELECT OrderID, 
       OrderDate, 
       TotalAmount,
       CASE 
           WHEN TotalAmount > 1000 THEN 'High'
           WHEN TotalAmount BETWEEN 500 AND 1000 THEN 'Medium'
           ELSE 'Low'
       END AS OrderCategory
FROM Orders;


--Create a Reservation
INSERT INTO Reservations (UserID, TableID, ReservationDateTime, NumberOfGuests, Status)
VALUES (1, 5, '2023-08-15 19:00:00', 4, 'Pending');


--Check Reservations for a Specific Date and Time
SELECT * FROM Reservations
WHERE ReservationDateTime = '2023-08-15 19:00:00';

--Update Reservation Status
UPDATE Reservations
SET Status = 'Confirmed'
WHERE ReservationID = 1;


--Update Table Status
UPDATE RestaurantTables
SET Status = 'Occupied'
WHERE TableID = 5;

