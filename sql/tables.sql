CREATE TABLE contacts (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  name varchar(25) DEFAULT NULL,
  surname varchar(25) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE emails (
  email varchar(50) NOT NULL,
  id_contact bigint unsigned NOT NULL,
  PRIMARY KEY(email),
  FOREIGN KEY (id_contact) REFERENCES contacts(id) ON DELETE CASCADE
);

CREATE TABLE phones (
  phone varchar(50) NOT NULL,
  id_contact bigint unsigned NOT NULL,
  PRIMARY KEY(phone),
  FOREIGN KEY (id_contact) REFERENCES contacts(id) ON DELETE CASCADE
);