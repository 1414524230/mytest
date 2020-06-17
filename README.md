# mytest
私人仓库
redis 集中管理session(常用)
优点：redis为内存数据库，读写效率高，并可在集群环境下做高可用
一 加入依赖

<!-- redis 依赖 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<!-- session redis 共享 -->
<dependency>
     <groupId>org.springframework.session</groupId>
     <artifactId>spring-session-data-redis</artifactId>
</dependency>


二 配置redis


三 启动类加入 @EnableRedisHttpSession
