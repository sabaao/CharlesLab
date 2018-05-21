# Install
Use brew install kafka is easy.
```shell
brew install kafka
```

# Start zk
```shell
zkServer start
```
# Modify Kafka config
Change dir to /usr/local/etc/kafka
```shell
cd /usr/local/etc/kafka
```

Add config to server.properties
```shell
#listeners = PLAINTEXT://your.host.name:9092
listeners=PLAINTEXT://localhost:9092
```

# Start Kafka
```shell
kafka-server-start.sh /usr/local/etc/kafka/server.properties
```

