# Introduction Kafka


Kafka是一种分布式的，基于发布/订阅的消息系统。主要设计目标如下：

以时间复杂度为O(1)的方式提供消息持久化能力，即使对TB级以上数据也能保证常数时间的访问性能
高吞吐率。即使在非常廉价的商用机器上也能做到单机支持每秒100K条消息的传输
支持Kafka Server间的消息分区，及分布式消费，同时保证每个partition内的消息顺序传输
同时支持离线数据处理和实时数据处理

# Why need use message queue
- 解耦
- 冗余
- 扩展性
- 灵活性 & 峰值处理能力
- 可恢复性
- 送达保证
- 顺序保证
- 缓冲
- 理解数据流
- 异步通信

# Terminology
- Broker
    
    Kafka Cluster是由多台Kafka組成的，而每一台Kafka就是一個Broker.
- Topic
    
    每条发布到Kafka集群的消息都有一个类别，这个类别被称为topic。
- Partition
    
    parition是物理上的概念，每个topic包含一个或多个partition，创建topic时可指定parition数量。每个partition对应于一个文件夹，该文件夹下存储该partition的数据和索引文件
- Producer
    
    负责发布消息到Kafka broker
- Consumer
    
    消费消息。每个consumer属于一个特定的consumer group（可为每个consumer指定group name，若不指定group name则属于默认的group）。使用consumer high level API时，同一topic的一条消息只能被同一个consumer group内的一个consumer消费，但多个consumer group可同时消费这一消息。

# Kafka Architecture
![Kafka架構圖](https://github.com/sabaao/CharlesLab/blob/master/kafka/images/KafkaArchitecture.png)

Kafka通过Zookeeper管理集群配置，选举leader，以及在consumer group发生变化时进行rebalance。producer使用push模式将消息发布到broker，consumer使用pull模式从broker订阅并消费消息。 

# Kafka config
- path

    $KAFKA_HOME/config/server.properties
    
- num.partitions

	```properties
	# The default number of log partitions per topic. More partitions allow greater
	# parallelism for consumption, but this will also result in more files across
	# the brokers.
	num.partitions=3
	```
	每一条消息被发送到broker时，会根据paritition规则选择被存储到哪一个partition。如果partition规则设置的合理，所有消息可以均匀分布到不同的partition里，这样就实现了水平扩展。（如果一个topic对应一个文件，那这个文件所在的机器I/O将会成为这个topic的性能瓶颈，而partition解决了这个问题）。
	
- retention.hours

	```properties
	# The minimum age of a log file to be eligible for deletion
	log.retention.hours=168
	```
	log多久後會被刪掉
	
- default.replication.factor
	
	```properties
	default.replication.factor = 1
	```
	该 Replication与leader election配合提供了自动的failover机制。replication对Kafka的吞吐率是有一定影响的，但极大的增强了可用性。默认情况下，Kafka的replication数量为1。　　每个partition都有一个唯一的leader，所有的读写操作都在leader上完成，leader批量从leader上pull数据。一般情况下partition的数量大于等于broker的数量，并且所有partition的leader均匀分布在broker上。
# Kafka存活
包含两个条件，一是它必须维护与Zookeeper的session(这个通过Zookeeper的heartbeat机制来实现)。二是follower必须能够及时将leader的writing复制过来，不能“落后太多”。
leader会track“in sync”的node list。如果一个follower宕机，或者落后太多，leader将把它从”in sync” list中移除。这里所描述的“落后太多”指follower复制的消息落后于leader后的条数超过预定值，该值可在$KAFKA_HOME/config/server.properties中配置
	
  
# Reference
- [http://www.jasongj.com/2015/01/02/Kafka%E6%B7%B1%E5%BA%A6%E8%A7%A3%E6%9E%90/](http://www.jasongj.com/2015/01/02/Kafka%E6%B7%B1%E5%BA%A6%E8%A7%A3%E6%9E%90/)
- 
