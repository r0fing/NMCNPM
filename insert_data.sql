INSERT INTO tblUser (username, password, name, role, phone, emailAddress) VALUES
('manager1', 'M123', 'Nguyen Xuan Kien', 'Manager', '0912345678', 'man1@gmail.com'),
('manager2', 'M234', 'Nguyen The Khiem', 'Manager', '0987654321', 'man2@gmail.com'),
('clerk1', 'C123', 'Dang Tuan Phong', 'Stock clerk', '0968688686', 'clerk1@gmail.com'),
('clerk2', 'C234', 'Le Tien Dat', 'Stock clerk', '0986866868', 'clerk2@gmail.com');

INSERT INTO tblSubagence (brandName, address, phoneNumber) VALUES
('A Store', '15 Lac Long Quan, Cau Giay, Ha Noi', 0912345987),
('B Supermarket', '779 Vinh Khanh, District 4, Ho Chi Minh', '0998761234'),
('C Store', '122b Ly Thai Tong, Lien Chieu, Da Nang', '0912387654'),
('D Mart', '336 Hai Ba Trung, District 1, Ho Chi Minh', '0912398765'),
('E Store', '89 Lac Long Quan, Cau Giay, Ha Noi', '0987125432');

INSERT INTO tblItem (itemName, itemDescription, itemPrice) VALUES
('Laptop', 'Portable computer', 15),
('Washing machine', 'Machine used to wash clothes', 20),
('Printer', 'Machine that produces physical copies of digital documents or images', 15),
('Wireless mouse', 'Computer mouse that operates without a physical cable', 2),
('Router WiFi', 'Device that provides a wireless internet connection', 3),
('Electric kettle', 'Kitchen appliance used to quickly boil water using electricity', 1),
('Blender', 'Kitchen appliance used to mix, puree, or emulsify food and liquid', 2);

INSERT INTO tblInvoice (dateIssue, tblUserid, tblSubagenceid) VALUES
('2025-01-18', 3, 4),
('2025-01-19', 4, 1),
('2025-01-20', 3, 1),
('2025-01-20', 3, 3),
('2025-01-21', 4, 4),
('2025-01-22', 3, 2),
('2025-01-22', 4, 3),
('2025-01-26', 4, 5),
('2025-01-27', 4, 5),
('2025-01-28', 3, 5);

INSERT INTO tblInvoiceItem (quantity, itemPrice, tblInvoiceid, tblItemid) VALUES
(10, 1, 1, 7),
(40, 2, 2, 4),
(6, 3, 2, 5),
(6, 10, 3, 1),
(1, 30, 3, 3),
(2, 20, 4, 2),
(1, 30, 5, 3),
(4, 10, 6, 1),
(1, 15, 6, 3),
(3, 10, 7, 1),
(3, 20, 7, 2),
(7, 15, 8, 1),
(7, 2, 8, 4),
(2, 3, 8, 5),
(5, 2, 9, 7),
(15, 1, 9, 6),
(5, 20, 10, 2);



