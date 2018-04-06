You can use Postman get token first, url is http://localhost:8093/login

POST /login HTTP/1.1
Host: localhost:8093
Content-Type: application/json
{"username":"admin","password":"password"}

and you will get token from response's header
just like 
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTUyMzg2MTc5NX0.9faY7o57Nz2MJNZrFpbXI5rq9i906PI-JxRdRMV8gP8LtzlhLZKSc6vouZ6USBD0H9axjwb08wPuEwLj0RzDMA

And put token in request header, and query http://localhost:8093/users
GET /users HTTP/1.1
Host: localhost:8093
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTUyMzg2MjkyNX0.edUAbK33K1s3BcqyGB3N9dLJcRtgkFd8zosSDDXCZcc567znKqwoestrSdqMoVl6pFqmXgqmopY7Hj0dA0lMpQ

you will get users response.

Reference:
https://auth0.com/blog/securing-spring-boot-with-jwts/