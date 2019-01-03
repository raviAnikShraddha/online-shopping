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
		password VARCHAR(50),
		email VARCHAR(100),
		contact_number VARCHAR(15),
		CONSTRAINT pk_user_id PRIMARY KEY (id)
);

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Ravi Pratap', 'Kashyap', 'ADMIN', true, 'rpkash123', 'ravipratapkashyap@gmail.com', '8299456318');

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Rajat', 'Mishra', 'SUPPLIER', true, '12345', 'rajat@gmail.com', '8299456318');

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Charas', 'Charas', 'SUPPLIER', true, '12345', 'charas@gmail.com', '8299456318');

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

