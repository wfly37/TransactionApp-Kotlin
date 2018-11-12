CREATE TABLE TRANSACTION (
  id INTEGER NOT NULL AUTO_INCREMENT,
  day varchar(100) NOT NULL,
  time varchar(100) NOT NULL,
  description varchar(100) NOT NULL,
  amount decimal(50,2) NOT NULL,
  type varchar(7) NOT NULL,
  primary key(id)
  );