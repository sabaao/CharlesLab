You need start two redis-sentinel at local,
and you can set sentinel infomation in application.yml.
Default setting is 127.0.0.1:26379,127.0.0.1:26380

Input url http://localhost:8095/set , system will set value to redis,
and input url http://localhost:8095/getvalue, you will get value from redis.

Reference:
https://www.cnblogs.com/EasonJim/p/7805665.html
