# 장바구니 프로젝트

## What you’ll need
- About 20 minutes
- A favorite text editor or IDE
- JDK 1.8 or later
- Mysql Ver 8.0.16 for Linux on x86_64
- Gradle 4+
- SpringBoot 2.1.4.RELEASE
- JPA
- Lombok 1.18.6
- VueJs
- Docker

## Module Guides
- api : Client RestAPI
- common : dataset format, jpa object connection,  exception
- vue : webclient

## Getting Started Guides
 - GitHub clone  
 	```git@github.com:jhtip/shop-project.git```
 - Docker Mysql running  
 	```docker run --name mysql-db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=style -d mysql```
 - DB Scheme create  
 
		CREATE TABLE `cart` (
		  `id` bigint(20) NOT NULL AUTO_INCREMENT,
		  `goods_id` bigint(20) DEFAULT NULL,
		  `options_id` bigint(20) DEFAULT NULL,
		  `opt_cnt` int(11) DEFAULT NULL,
		  PRIMARY KEY (`id`)
		);
			
		CREATE TABLE `goods` (
		  `id` bigint(20) NOT NULL AUTO_INCREMENT,
		  `name` varchar(255) DEFAULT NULL,
		  `price` bigint(20) DEFAULT NULL,
		  `provider` varchar(255) DEFAULT NULL,
		  PRIMARY KEY (`id`)
		);
			
		CREATE TABLE `options` (
		  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
		  `color` varchar(255) DEFAULT NULL,
		  `goods_id` bigint(20) DEFAULT NULL,
		  `id` varchar(255) DEFAULT NULL,
		  `size` varchar(255) DEFAULT NULL,
		  `stock` int(11) DEFAULT NULL,
		  PRIMARY KEY (`oid`)
		);
			
		CREATE TABLE `shipping` (
		  `id` bigint(20) NOT NULL AUTO_INCREMENT,
		  `can_bundle` bit(1) DEFAULT NULL,
		  `goods_id` bigint(20) DEFAULT NULL,
		  `method` varchar(255) DEFAULT NULL,
		  `price` bigint(20) DEFAULT NULL,
		  PRIMARY KEY (`id`)
		);

 - Application running  
 	-  api module : ShopApplication run
 	
 - node server running
    - cmd 실행 명령어  
        - ``` cd  workspace/shop-project/api/src/app ``` 
        - ``` npm install ```
        - ``` npm run serve ```  
    	
 - Test URL
 	- http://loclahost:8080


© 2019 Jaehyun Shim
