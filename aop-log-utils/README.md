
# Aop Log Utils
# 使用對象
* Spring Boot
# 使用說明
1. 在pom中加入dependency
```xml
<dependency>
	<groupId>com.cathay.holdings</groupId>
	<artifactId>aop-log-utils</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

2. 在引用的spring boot的application.yml(或application.xml)中加入設定檔
```yaml
aop-log-utils:
  scan:
    names: com.cathay.holdings,com.cathay.bank
```
代表需要掃描的packages及classes，使用逗號區隔

3. 若有使用@ComponentScan，需要將「com.ch.myr.util.aop」加入
```java
@ComponentScan({"com.ch.myr.util.aop"})
```
4. 記錄的json格式如下
```json
{
   "className":"com.cathay.holdings.controllers.HelloController",
   "methodName":"hello",
   "inputArgs":["charles"],
   "outputArgs":"Hello charles",
   "startTime":1525320321501,
   "endTime":1525320321504,
   "duration":3,
   "exceptionMessage":null
}
```
屬性說明

| Name | 說明 |
|---|---|---|
|className   | 記錄到的class name  |
|methodName   |記錄到的method name   |
|inputArgs|method輸入的參數|
|outputArgs|method輸出的參數|
|startTime|開始時間|
|endTime|結束時間|
|duration|執行了幾毫秒|
|ExceptionMessage|錯誤訊息|


# API
支援以API的方式動態新增要掃描的package及class
1. 取得靜態packages
http://{service_host}:{service_port}/aop/static/list
Method type: GET
Response
```json
[
    "com.cathay.holdings"
]
```

2. 取得動態packages
http://{service_host}:{service_port}/aop/dynamic/list
Method type : GET
Response
```json
[
    "com.cathay.bank"
]
```
3. 新增動態packages
http://{service_host}:{service_port}/aop/dynamic/list
Method type : POST
Request Body
```json
["com.cathay.bank"]
```
Response
```json
true
```
4. 刪除動態packages
http://{service_host}:{service_port}/aop/dynamic/list
Method type : DELETE
Request Body
```json
["com.cathay.bank"]
```
Response
```json
true
```
# 限制

1. 僅適用於Spring boot
2. 必須在class level增加以下其中一種annotation才會被掃描到
    @RestController, @Repository, @Component, @Service
3. 目前掃描的細度僅能到class, 尚不支援到指定的method name