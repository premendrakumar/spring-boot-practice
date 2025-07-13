CREATE TABLE customer (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(45) NOT NULL,
  pwd VARCHAR(300) NOT NULL,
  role VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('user1@example.com', '{noop}user1', 'read');
INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('admin@example.com', '{noop}admin', 'admin');