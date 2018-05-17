Please package jar first, you can use command「mvn package」
and run it, check it is success by url, http://localhost:8080

And build it as a docker file by maven command 「mvn dockerfile:build」

run it as docker command, 「run -p 8080:8080 sabaao/spring-boot-with-docker」

and check it by url.