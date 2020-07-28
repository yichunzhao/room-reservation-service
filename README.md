# Client side load balancing with Ribbon


## Add Dependencies

Register service in Eureka, meaning while enable the ribbon to consume the services via the client load balancing.

```
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
		</dependency>
```


## Enable Service and Load-Balancing

![image](https://user-images.githubusercontent.com/17804600/88607303-2f3a5f00-d07f-11ea-8acb-a4ae827da615.png)



