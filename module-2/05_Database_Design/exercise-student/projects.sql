
DROP TABLE IF EXISTS employee_project;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;


CREATE TABLE department
(
    departmentId serial,
    name varchar(32) NOT NULL,
    CONSTRAINT pk_department PRIMARY KEY (departmentId) 

);

CREATE TABLE employee
(
    employeeId serial,
    jobTitle varchar(32) NOT NULL,
    last_name varchar(16) NOT NULL,
    first_name varchar(16) NOT NULL,
    gender varchar(10),
    dob date,
    dateOfHire date NOT NULL,
    departmentId int NOT NULL,
    
    CONSTRAINT pk_employee PRIMARY KEY (employeeId),
    CONSTRAINT fk_employee_department FOREIGN KEY (departmentId) REFERENCES department (departmentId)
    
);

CREATE TABLE project
(
    projectNumber serial,
    name varchar(32) NOT NULL,
    startDate date NOT NULL,
    
    CONSTRAINT pk_project PRIMARY KEY (projectNumber) 

);

CREATE TABLE employee_project
(
    employeeId int NOT NULL,
    projectNumber int NOT NULL,
    
    CONSTRAINT pk_employee_project PRIMARY KEY (employeeId, projectnumber),
    CONSTRAINT fk_employee_project_employee FOREIGN KEY (employeeId) REFERENCES employee (employeeId),
    CONSTRAINT fk_employee_project_project FOREIGN KEY (projectNumber) REFERENCES project (projectNumber)

);

INSERT INTO department(name) VALUES ('Engineering');
INSERT INTO department(name) VALUES ('Sales');
INSERT INTO department(name) VALUES ('Marketing');

INSERT INTO employee(jobTitle, last_name, first_name, gender, dob, dateOfHire, departmentId) 
VALUES ('Software Engineer', 'Johnson', 'Aleks', 'Male', '1988/03/13', '2019/04/20',1);
INSERT INTO employee(jobTitle, last_name, first_name, gender, dob, dateOfHire, departmentId) 
VALUES ('Brand manager', 'Gilbert', 'Noel', 'Male', '1987/05/23', '2020/08/03',3);
INSERT INTO employee(jobTitle, last_name, first_name, gender, dob, dateOfHire, departmentId) 
VALUES ('Content writer', 'Watson', 'Elena', 'Female', '1979/01/07', '2016/11/28',3);
INSERT INTO employee(jobTitle, last_name, first_name, gender, dob, dateOfHire, departmentId) 
VALUES ('Data Engineer', 'Pitt', 'Nickole', 'Female', '1982/11/01', '2015/09/22',1);
INSERT INTO employee(jobTitle, last_name, first_name, gender, dob, dateOfHire, departmentId) 
VALUES ('Sales Representative', 'Gilbert', 'Jack', 'Male', '1977/05/13', '2021/03/03',2);
INSERT INTO employee(jobTitle, last_name, first_name, gender, dob, dateOfHire, departmentId) 
VALUES ('Sales Manager', 'Robert', 'Dianna', 'Female', '1983/01/09', '2016/09/24',2);
INSERT INTO employee(jobTitle, last_name, first_name, gender, dob, dateOfHire, departmentId) 
VALUES ('Civil Engineer', 'Smith', 'Jennifer', 'Female', '1992/01/01', '2014/09/12',1);
INSERT INTO employee(jobTitle, last_name, first_name, gender, dob, dateOfHire, departmentId) 
VALUES ('Salesperson', 'Jones', 'David', 'Male', '1989/04/29', '2018/12/10',2);

INSERT INTO project(name, startDate) VALUES('creating website', '2019/12/20');
INSERT INTO project(name, startDate) VALUES('releasing new product', '2021/04/23');
INSERT INTO project(name, startDate) VALUES('building new building', '2018/04/10');
INSERT INTO project(name, startDate) VALUES('creating a new tool', '2019/10/04');

INSERT INTO employee_project(employeeId,projectNumber) VALUES(1, 2);
INSERT INTO employee_project(employeeId,projectNumber) VALUES(2, 4);
INSERT INTO employee_project(employeeId,projectNumber) VALUES(3, 2);
INSERT INTO employee_project(employeeId,projectNumber) VALUES(4, 3);
INSERT INTO employee_project(employeeId,projectNumber) VALUES(5, 1);
INSERT INTO employee_project(employeeId,projectNumber) VALUES(6, 4);
INSERT INTO employee_project(employeeId,projectNumber) VALUES(7, 3);
INSERT INTO employee_project(employeeId,projectNumber) VALUES(8, 1);

