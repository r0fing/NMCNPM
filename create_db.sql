-- tblItem
CREATE TABLE tblItem (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    itemName VARCHAR(255),
    itemDescription VARCHAR(255),
    PRIMARY KEY (id)
);

-- tblSubagence
CREATE TABLE tblSubagence (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    brandName VARCHAR(255),
    address VARCHAR(255),
    phoneNumber INT(10),
    PRIMARY KEY (id)
);

-- tblUser
CREATE TABLE tblUser (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    name VARCHAR(255),
    role VARCHAR(255),
    phone VARCHAR(255) UNIQUE,
    emailAddress VARCHAR(255) UNIQUE,
    tblInvoiceid INT(10),
    PRIMARY KEY (id)
);

-- tblInvoice
CREATE TABLE tblInvoice (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    dateIssue DATE,
    tblUserid INT(10) UNSIGNED,
    tblSubagenceid INT(10) UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (tblUserid) REFERENCES tblUser(id),
    FOREIGN KEY (tblSubagenceid) REFERENCES tblSubagence(id)
);

-- tblInvoiceItem
CREATE TABLE tblInvoiceItem (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    quantity INT(10),
    itemPrice FLOAT(10),
    tblInvoiceid INT(10) UNSIGNED,
    tblItemid INT(10) UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (tblInvoiceid) REFERENCES tblInvoice(id),
    FOREIGN KEY (tblItemid) REFERENCES tblItem(id)
);