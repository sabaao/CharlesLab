You can try spring valid annotation
http://localhost:8080/customer
method type : POST
request body:
{
	"name":"charles",
	"age":17
}

Then you will receive error, because age less than 18.

http://localhost:8080/customer
method type : POST
request body:
{
	"name":"charles",
	"age":20
}

Then you will receive Customer json.