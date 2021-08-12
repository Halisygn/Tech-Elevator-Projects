

DROP TABLE IF EXISTS home;
DROP TABLE IF EXISTS address;
;

CREATE TABLE address (
   addressId serial,
   addressLine varchar(64) not null,
   city varchar(50) not null,
   state varchar(50) not null,
   zip int not null,
   
   CONSTRAINT pk_address PRIMARY KEY (addressId) 

);




CREATE TABLE home (
  homeId serial,
  mlsNumber varchar(15) not null,
  addressId int not null,
  numberOfBathrooms int,
  numberOfBedrooms int,
  price decimal(12,2) not null,
  shortDescription varchar(255) not null,

  
  CONSTRAINT pk_home PRIMARY KEY (homeId),
  CONSTRAINT fk_home_address FOREIGN KEY (addressId) references address (addressId)

);


-- SAMPLE DATA

--House 1
INSERT INTO address (addressId, addressLine, city, state, zip) VALUES (1, '123 Elm Street', 'Columbus', 'Ohio', 43323);
INSERT INTO home ( mlsNumber, addressId, numberOfBathrooms, numberOfBedrooms, price, shortDescription) values('MLS5123', 1, 4, 3, 30000.00,'Freddies Nightmare will come to your life in the classic home. Sweet dreams!');

-- UPDATING SEQUENCES SO THERE ARE NO CLASHES WHEN APP RUNS WITH EXISTING KEYS...
ALTER SEQUENCE address_addressid_seq RESTART WITH 100;
ALTER SEQUENCE home_homeid_seq RESTART WITH 100;
