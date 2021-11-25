### Spring Data JPA Intro project

* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* Active profiles: local，remote
* Version: MySQL:8.0.27
* DB configuration: 
  * Encoding: UTF-8, utf8mb4_unicode_ci
* Instances:
  * External port for docker mysql: 3308
  

#### Note: 
* Liquibase's advantage over Flyway:
  * No need for vendor specific setup since Liquibase use abstraction instead of sql script.
  * Flyway Maven plugin needs to set up specific datasource parameters, while liquibase don't.

### [UUID Generation](https://github.com/frzhen/sdjpa-intro-liquibase/blob/main/UUID.md)