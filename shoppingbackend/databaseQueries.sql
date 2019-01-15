CREATE TABLE category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

CREATE TABLE user_detail(
		id IDENTITY,
		first_name VARCHAR(50),
		last_name VARCHAR(50),
		role VARCHAR(50),
		enabled BOOLEAN,
		password VARCHAR(60),
		email VARCHAR(100),
		contact_number VARCHAR(15),
		CONSTRAINT pk_user_id PRIMARY KEY (id)
);

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Ravi Pratap', 'Kashyap', 'ADMIN', true, '$2b$10$y7vxsjquBLll2R3rpHKFOO68D7xN8IbCdreoquDyvGqUVZ99dtEB6', 'ravipratapkashyap@gmail.com', '8299456318');

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Rajat', 'Mishra', 'SUPPLIER', true, '123456', 'rajat@gmail.com', '8299456318');

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Charas', 'Charas', 'USER', true, '123456', 'charas@gmail.com', '8299456318');

CREATE TABLE product(
		id IDENTITY,
		code VARCHAR(50),
		name VARCHAR(50),
		brand VARCHAR(50),
		description VARCHAR(255),
		unit_price DECIMAL(10,2),
		quantity INT,
		is_active BOOLEAN,
		category_id INT,
		supplier_id INT,
		purchases INT DEFAULT 0,
		views INT DEFAULT 0,
		CONSTRAINT pk_product_id PRIMARY KEY (id),
		CONSTARINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
		CONSTARINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'i Phone 5s', 'apple', 'This is the one of the best phone available in the market !', '56,000.00', '5', true, '3', '2');

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'Samsung S7', 'Samsung', 'This is the one of the best phone available in the market !', '46,000.00', '4', true, '3', '3');

CREATE TABLE cart(
		
		id IDENTITY,
		user_id INT,
		grand_total DECIMAL(10,2),
		cart_lines INT,
		CONSTRAINT pk_cart_id PRIMARY KEY (id),
		foreign key (user_id) references user_detail(id)
);

CREATE TABLE ADDRESS (
		id IDENTITY,
		address_line_one VARCHAR(255),
		address_line_two VARCHAR(255),
		city VARCHAR(50),
		state VARCHAR(50),
		country VARCHAR(50),
		postal_code VARCHAR(10),
		shipping BOOLEAN,
		billing BOOLEAN,
		user_id INT,
		CONSTRAINT pk_address_id PRIMARY KEY (id),
		foreign key (user_id) references user_detail(id)
		);

CREATE TABLE cart_line (
		id IDENTITY,
		cart_id INT,
		total DECIMAL(10,2),
		product_id INT,
		product_count INT,
		buying_price DECIMAL(10,2),
		is_available BOOLEAN,
		CONSTRAINT pk_cart_lines_id PRIMARY KEY (id),
		foreign key (cart_id) references cart(id),
		foreign key (product_id) references product(id)
		);

// add foreign key constraint

ALTER TABLE PLANETICKETS
ADD FOREIGN KEY (TOURISTINFO_ID) 
REFERENCES TOURISTINFO(TOURISTINFO_ID)
