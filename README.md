## QiDianFiction

### 技术栈：

后端框架：Spring Boot  
数据库：MySQL  
ORM框架：MyBatis  
验证：Spring Validation  
安全性：JWT（JSON Web Tokens）  
线程安全存储：ThreadLocal  

### 功能特性：
用户管理：实现用户注册、登录、更新。  
文章管理：允许用户创建、列表查询、id查询、更新和删除文章。   
文章分类：支持新增、更新、分页查询和id查询文章分类。

### 关键特性说明：
验证机制：使用Spring Validation进行参数校验。
（1）自定义校验注解：对于Article类的state属性，有已发布|草稿 两种状态，需要提供自定义注解@State，提供自定义校验数据规则的类StateValidation。    
（2）分组校验：在Category类中，我定义了Add,Update两个接口，在需要分组校验的属性上面通过group来指定，在CategoryController校验时，对@Validated注解的赋值。  

令牌管理： 使用JWT进行用户认证， 
（1）运用JwtUtil工具类，调用API生成和校验令牌
（2）LoginInterceptor类：在preHandle方法中，从请求头中获取JWT，如果JWT有效，用户的请求会被允许继续执行；否则，用户会收到一个401未授权的响应。  
（3）WebConfig类：在addInterceptors方法中，指定了不需要拦截的路径（/user/login和/user/register）。

线程安全：使用ThreadLocal进行线程安全的数据存储。
