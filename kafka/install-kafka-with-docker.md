# pull kafka image
```shell
docker pull wurstmeister/kafka
```

Use this command pull image first.

# Make docker-compose
```yml
version: '2'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"
  kafka:
    build: .
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 192.168.99.100
      KAFKA_CREATE_TOPICS: "test:1:1"
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
```
Topic test will have 1 partition and 1 replicas.

You can download from [here](https://github.com/sabaao/CharlesLab/blob/master/kafka/docker-compose/kafka-docker-compose.yml)

# start kafka
```shell
docker-compose -f kafka-docker-compose.yml up
```

# Reference
[https://hub.docker.com/r/wurstmeister/kafka/](https://hub.docker.com/r/wurstmeister/kafka/)
