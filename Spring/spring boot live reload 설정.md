# spring boot live reload 설정



### gradle project

```xml
<!-- build.gradle -->

compile "org.springframework.boot:spring-boot-devtools"
```



### maven proejct

```xml
<!-- pom.xml -->

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>
```



### application properties

```xml
<!-- application.properties -->

spring.devtools.livereload.enabled=true

<!-- img, css, js 등-->
spring.web.resources.static-locations=file:src/main/resources/static/

<!-- tymeleaf 관련 설정은 아래와 같이 하라고 한다 -->
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=file:src/main/resources/templates/
```

참고한 사이트 : https://easybrother0103.tistory.com/62



### 인텔리제이 추가 설정

1. `⌘ + ,` (preferences)
2. Build, Execution, Deployment > Compiler
3. **Bulid project automatically**
3. **Allow auto-make to start even if developed application is running** 체크 (Intelli j 2021 이후)

![image](https://user-images.githubusercontent.com/52594760/151317302-185ac387-7f6e-4c35-91ee-f7eef9f9536f.png)

![image](https://user-images.githubusercontent.com/52594760/151324376-8f3c93d3-9153-4a01-a2e1-c1799391f2eb.png)