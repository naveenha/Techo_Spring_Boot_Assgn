insert into STUDENT(ID, FIRST_NAME, LAST_NAME, PHONE) values(100, 'John', 'Doe', 123456);
insert into STUDENT(ID, FIRST_NAME, LAST_NAME, PHONE) values(101, 'John2', 'Doe2', 123456);

insert into DEPARTMENT(NAME, LOCATION) values('Dept1', 'Bengaluru');
insert into DEPARTMENT(NAME, LOCATION) values('Dept2', 'Hyderabad');

insert into INSTRUCTOR(ID, FIRST_NAME, HEADED_BY, LAST_NAME, PHONE, DEPARTMENT_NAME) values(10000, 'Abdul', 'head1', 'Kalam', 1234, 'Dept1');
insert into INSTRUCTOR(ID, FIRST_NAME, HEADED_BY, LAST_NAME, PHONE, DEPARTMENT_NAME) values(10001, 'CV', 'head1', 'Raman', 1234, 'Dept1');
insert into INSTRUCTOR(ID, FIRST_NAME, HEADED_BY, LAST_NAME, PHONE, DEPARTMENT_NAME) values(10002, 'Homi', 'head2', 'Bhabha', 1234, 'Dept2');
insert into INSTRUCTOR(ID, FIRST_NAME, HEADED_BY, LAST_NAME, PHONE, DEPARTMENT_NAME) values(10003, 'Srinivasa', 'head2', 'Ramanujan', 1234, 'Dept2');

insert into COURSE(ID, DURATION, NAME, DEPARTMENT_NAME, INSTRUCTOR_ID) values(1000, 1, 'Core Java', 'Dept1', 10000);
insert into COURSE(ID, DURATION, NAME, DEPARTMENT_NAME, INSTRUCTOR_ID) values(1001, 2, 'Spring Boot', 'Dept2', 10000);
insert into COURSE(ID, DURATION, NAME, DEPARTMENT_NAME, INSTRUCTOR_ID) values(1002, 2, 'Microservices', 'Dept1', 10001);
insert into COURSE(ID, DURATION, NAME, DEPARTMENT_NAME, INSTRUCTOR_ID) values(1003, 1, 'Angular', 'Dept2', 10001);

insert into COURSE_STUDENT(STUDENT_ID, COURSE_ID) values(100, 1000);
insert into COURSE_STUDENT(STUDENT_ID, COURSE_ID) values(100, 1001);
insert into COURSE_STUDENT(STUDENT_ID, COURSE_ID) values(101, 1000);
insert into COURSE_STUDENT(STUDENT_ID, COURSE_ID) values(101, 1001);