Word Ladder with authenticating user  
===
## 1. 实现spring security的四种方法 

### 1. 全部利用配置文件  
    不使用数据库，全部信息写在配置文件中，如拦截的URL及对应权限，指定用户名、密码和对应权限    
### 2. 数据库+配置文件  
    数据库存储用户和权限，硬编码配置URL和对应权限  
    根据spring security的默认实现代码设计数据库  
### 3. 自定义filter+数据库  
    插入自定义filter重新组织spring security的拦截器。将用户、角色、权限和资源均采用数据库存储，并且自定义过滤器，代替原有的FilterSecurityInterceptor过滤器，并分别实现AccessDecisionManager、InvocationSecurityMetadataSourceService和UserDetailsService。  
### 4. 修改spring security源码
    修改InvocationSecurityMetadataSourceService和UserDetailsService两个类。  
    前者是将配置文件或数据库中存储的资源(url)提取出来加工成为url和权限列表的Map供Security使用，后者提取用户名和权限组成一个完整的 (UserDetails)User对象，该对象可以提供用户的详细信息供AuthentationManager进行认证与授权使用。

本次时间有限，仅实现了基于内存的（全部利用配置文件）的spring security来实现用户认证。  

----

## 2. 使用项目  
### 1. 项目目录  
    -src
        -main
            -java.com.example.demo
                -config
                    SecurityConfig.java  
                -controller
                    AppController.java
                    MainController.java
                DemoApplication.java
                dictionary.txt
                WordLadder.java
            -resources
                -static
                -templates
                    -user
                        index.html
                    index.html
                    login.html
                application.properties
                logback.xml  
### 2. 使用项目  
    默认界面 & 主页
    http://localhost:8080/
    http://localhost:8080/index
![Image](https://github.com/199ChenNuo/wordladder3-user-authenticating/blob/master/src/main/resources/static/index.png)  

----

    登录界面
    http://localhost:8080/login
![Image](https://github.com/199ChenNuo/wordladder3-user-authenticating/blob/master/src/main/resources/static/login.png)  

----

    用户界面
    http://localhost:8080/user/index
![Image](https://github.com/199ChenNuo/wordladder3-user-authenticating/blob/master/src/main/resources/static/user-index.png)  

----

    获取wordladder
    http://localhost:8080/user/wordladder
    传参
    http://localhost:8080/user/wordladder?wd1=wordone&wd2=wordtwo
    例如
    http://localhost:8080/user/wordladder?wd1=hello&wd2=world  
![Image](https://github.com/199ChenNuo/wordladder3-user-authenticating/blob/master/src/main/resources/static/wordLadder.png)  


