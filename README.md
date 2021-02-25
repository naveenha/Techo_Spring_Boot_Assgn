1. Have enabled jwt authentication, Please post a request to   http://localhost:8080/authenticate    to get the jwt token:
	Method: POST
	request body: 
	{
	  "username": "user",
	  "password": "password"
	}

1.1 We get jwt token: 			eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjE0NzI0MjE2LCJpYXQiOjE2MTQxMTk0MTZ9.cOQ1o6bZmRn02eNcJRKfs9tNX7kFYmc903UrRikle1FRgWvJcXC7tJdWFRaeUUR1HAaDd152N1AYDbJ0iAERqA

1.2 Add jwt token under Authorization header:
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjE0NzI0MjE2LCJpYXQiOjE2MTQxMTk0MTZ9.cOQ1o6bZmRn02eNcJRKfs9tNX7kFYmc903UrRikle1FRgWvJcXC7tJdWFRaeUUR1HAaDd152N1AYDbJ0iAERqA

2. Now, All the requests can be executed.

I have added a query in data.sql to insert some data into all the tables during application startup.

•	Handled response status codes: For creation: 201, For deletion: 204(No Content)

CRUD operations:
GET all:
http://localhost:8080/courses
http://localhost:8080/students
http://localhost:8080/departments
http://localhost:8080/instructors

Get single item:
http://localhost:8080/courses/1000
http://localhost:8080/students/100
http://localhost:8080/departments/Dept1
http://localhost:8080/instructors/10000

Create New Item: POST
http://localhost:8080/courses
http://localhost:8080/students
http://localhost:8080/departments
http://localhost:8080/instructors

Update new item: PUT
http://localhost:8080/courses
http://localhost:8080/students
http://localhost:8080/departments
http://localhost:8080/instructors

Update new item: DELETE
http://localhost:8080/courses/1000
http://localhost:8080/students/100
http://localhost:8080/departments/Dept1
http://localhost:8080/instructors/10000


• to get the list of course for a particular student id: http://localhost:8080/listOfCoursesByStudentId/100
• to get the list of students for a particular instructor id:     http://localhost:8080/listOfStudentsByInstructorId/10000
• to get the total course duration for a particular student id: http://localhost:8080/totalCourseDurationForStudentId/100
