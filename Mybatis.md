# Mybatis

maven仓库

```xml
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.4</version>
</dependency>

```

### 1.2 持久化

数据持久化

​	持久化就是将程序的数据在持久状态和瞬时状态转化的过程

### 1.3 持久层

Dao层,Service层，Controller层

完成持久化工作的代码块

层界限十分明显



### 2.第一个Mybatis程序

思路:搭建环境->导入Mybatis->编写代码->测试

0.maven配置

1.工具类 2.写mybatis_config.xml

3.写实体类 4.写接口类 5.写mapper.xml

6.写test

`&需要转义用&amp;`

实体类

Dao类

```java
package com.lyy.dao;

import com.lyy.pojo.User;

import java.util.List;

//操作数据库的实体
public interface UserDao {
    List<User> getUserList();
}

```

接口实现类

Mapper只需要记得resultMap和resultType

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace绑定一个对应的Mapper接口-->
<!--相当于实现了接口-->
<!--省去了连接sql的步骤-->
<mapper namespace="com.lyy.dao.UserDao">
<!--   id对应接口中的方法名字-->
<!--    resultType是返回查询结果的类型-->
    <select id="getUserList" resultType="com.lyy.pojo.User">
<!--执行后返回List<User>-->
    select * from mybatis.user
    </select>
<!--    <select id="selectBlog" resultType="Blog">-->
<!--    select * from Blog where id = #{id}-->
<!--  </select>-->
</mapper>
```

### 测试

junit测试 在绿色的test下面建立同名的包

注意 mybatis-config.xml的配置不要写错

如下

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- 核心配置文件-->

<configuration>
    <environments default="development">
        <environment id="development">
<!--            事务管理-->
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=utf8"/>
                <property name="username" value="root"/>
                <property name="password" value="liyuyang"/>
            </dataSource>
        </environment>
    </environments>
<!--    Maapper,xml都需要，接口需要在下面注册-->
    <mappers>
        <mapper resource="com/lyy/dao/UserMapper.xml"/>
    </mappers>
</configuration>
```

两个典型错误 

1.mapper没注册

解决方法

在pom.xml中没配置

```xml
<build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                 <filtering>true</filtering>
            </resource>
        </resources>
    </build>
```

### 作用域（Scope）和生命周期

理解我们之前讨论过的不同作用域和生命周期类别是至关重要的，因为错误的使用会导致非常严重的并发问题。

------

**提示** **对象生命周期和依赖注入框架**

依赖注入框架可以创建线程安全的、基于事务的 SqlSession 和映射器，并将它们直接注入到你的 bean 中，因此可以直接忽略它们的生命周期。 如果对如何通过依赖注入框架使用 MyBatis 感兴趣，可以研究一下 MyBatis-Spring 或 MyBatis-Guice 两个子项目。

------

#### SqlSessionFactoryBuilder

这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。 因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域（也就是局部方法变量）。 你可以重用 SqlSessionFactoryBuilder 来创建多个 SqlSessionFactory 实例，但最好还是不要一直保留着它，以保证所有的 XML 解析资源可以被释放给更重要的事情。

#### SqlSessionFactory

SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。 使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏习惯”。因此 SqlSessionFactory 的最佳作用域是应用作用域。 有很多方法可以做到，最简单的就是使用单例模式或者静态单例模式。

#### SqlSession

每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。 绝对不能将 SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。 也绝不能将 SqlSession 实例的引用放在任何类型的托管作用域中，比如 Servlet 框架中的 HttpSession。 如果你现在正在使用一种 Web 框架，考虑将 SqlSession 放在一个和 HTTP 请求相似的作用域中。 换句话说，每次收到 HTTP 请求，就可以打开一个 SqlSession，返回一个响应后，就关闭它。 这个关闭操作很重要，为了确保每次都能执行关闭操作，你应该把这个关闭操作放到 finally 块中。 下面的示例就是一个确保 SqlSession 关闭的标准模式：

```
try (SqlSession session = sqlSessionFactory.openSession()) {
  // 你的应用逻辑代码
}
```

在所有代码中都遵循这种使用模式，可以保证所有数据库资源都能被正确地关闭。

#### 映射器实例

映射器是一些绑定映射语句的接口。映射器接口的实例是从 SqlSession 中获得的。虽然从技术层面上来讲，任何映射器实例的最大作用域与请求它们的 SqlSession 相同。但方法作用域才是映射器实例的最合适的作用域。 也就是说，映射器实例应该在调用它们的方法中被获取，使用完毕之后即可丢弃。 映射器实例并不需要被显式地关闭。尽管在整个请求作用域保留映射器实例不会有什么问题，但是你很快会发现，在这个作用域上管理太多像 SqlSession 的资源会让你忙不过来。 因此，最好将映射器放在方法作用域内。就像下面的例子一样：

```
try (SqlSession session = sqlSessionFactory.openSession()) {
  BlogMapper mapper = session.getMapper(BlogMapper.class);
  // 你的应用逻辑代码
}
```

### 3 CRUD实现

注意点:增删改需要提交事务

注意xml中int参数和User参数的名，int类型可以参数名不同

resources中mybatis-config.xml中要写  就是绑定mapper需要些路径

```xml
<mappers>   
<mapper resource="com/lyy/dao/UserMapper.xml"/>
</mappers>
```

其他地方引用包名用.

#### Map和模糊查询拓展

通过map做xml中的参数可以避免把参数名都赋值

即取map中的key 

连接了数据库才写mybatis.user而不是user，否则写user

CRUD和select都适合

![1584716466858](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584716466858.png)



模糊查询

![1584717774905](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584717774905.png)

加上%%在xml中防止sql注入

```xml
    <select id="getUserLike" resultType="com.lyy.pojo.User">
        <!--执行后返回List<User>-->
        select * from mybatis.user where name like #{value};
    </select>
```

```java
List<User> userLike = mapper.getUserLike("%l%");
```

### 

### 4.配置解析

1. #### 核心配置文件

mybatis-config.xml

![1584718233938](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584718233938.png)

红框重点了解



#### 环境配置

**尽管可以配置多个环境，但每个 SqlSessionFactory 实例只能选择一种环境。**

**事务管理器（transactionManager）**

在 MyBatis 中有两种类型的事务管理器（也就是 type[JDBC|MANAGED]"）：

JDBC – 这个配置直接使用了 JDBC 的提交和回滚设施，它依赖从数据源获得的连接来管理事务作用域。

**提示** 如果你正在使用 Spring + MyBatis，则没有必要配置事务管理器，因为 Spring 模块会使用自带的管理器来覆盖前面的配置。

**数据源（dataSource）**

dataSource 元素使用标准的 JDBC 数据源接口来配置 JDBC 连接对象的资源。

连接数据库 dbcp c3p0 druid

**UNPOOLED**– 这个数据源的实现会每次请求时打开和关闭连接。

UNPOOLED 类型的数据源仅仅需要配置以下 5 种属性：

- `driver` – 这是 JDBC 驱动的 Java 类全限定名（并不是 JDBC 驱动中可能包含的数据源类）。
- `url` – 这是数据库的 JDBC URL 地址。
- `username` – 登录数据库的用户名。
- `password` – 登录数据库的密码。
- `defaultTransactionIsolationLevel` – 默认的连接事务隔离级别。
- `defaultNetworkTimeout` – 等待数据库操作完成的默认网络超时时间（单位：毫秒）。

作为可选项，你也可以传递属性给数据库驱动。只需在属性名加上“driver.”前缀即可，例如：

- `driver.encoding=UTF8`

**POOLED**– 这种数据源的实现利用“池”的概念将 JDBC 连接对象组织起来，避免了创建新的连接实例时所必需的初始化和认证时间。 这种处理方式很流行，能使并发 Web 应用快速响应请求。

- `poolMaximumActiveConnections` – 在任意时间可存在的活动（正在使用）连接数量，默认值：10
- `poolMaximumIdleConnections` – 任意时间可能存在的空闲连接数。
- `poolMaximumCheckoutTime` – 在被强制返回之前，池中连接被检出（checked out）时间，默认值：20000 毫秒（即 20 秒）
- `poolTimeToWait` – 这是一个底层设置，如果获取连接花费了相当长的时间，连接池会打印状态日志并重新尝试获取一个连接（避免在误配置的情况下一直失败且不打印日志），默认值：20000 毫秒（即 20 秒）。
- `poolMaximumLocalBadConnectionTolerance` – 这是一个关于坏连接容忍度的底层设置， 作用于每一个尝试从缓存池获取连接的线程。 如果这个线程获取到的是一个坏的连接，那么这个数据源允许这个线程尝试重新获取一个新的连接，但是这个重新尝试的次数不应该超过 `poolMaximumIdleConnections` 与 `poolMaximumLocalBadConnectionTolerance` 之和。 默认值：3（新增于 3.4.5）
- `poolPingQuery` – 发送到数据库的侦测查询，用来检验连接是否正常工作并准备接受请求。默认是“NO PING QUERY SET”，这会导致多数数据库驱动出错时返回恰当的错误消息。
- `poolPingEnabled` – 是否启用侦测查询。若开启，需要设置 `poolPingQuery` 属性为一个可执行的 SQL 语句（最好是一个速度非常快的 SQL 语句），默认值：false。
- `poolPingConnectionsNotUsedFor` – 配置 poolPingQuery 的频率。可以被设置为和数据库连接超时时间一样，来避免不必要的侦测，默认值：0（即所有连接每一时刻都被侦测 — 当然仅当 poolPingEnabled 为 true 时适用）。

**JNDI** – 这个数据源实现是为了能在如 EJB 或应用服务器这类容器中使用，容器可以集中或在外部配置数据源，然后放置一个 JNDI 上下文的数据源引用。这种数据源配置只需要两个属性：

#### 属性

注意xml有属性顺序要求

这些属性可以在外部进行配置，并可以进行动态替换。你既可以在典型的 Java 属性文件中配置这些属性，也可以在 properties 元素的子元素中设置。例如：

```
<properties resource="org/mybatis/example/config.properties">
  <property name="username" value="dev_user"/>
  <property name="password" value="F2Fa3!33TYyg"/>
</properties>
```

设置好的属性可以在整个配置文件中用来替换需要动态配置的属性值。比如:

```
<dataSource type="POOLED">
  <property name="driver" value="${driver}"/>
  <property name="url" value="${url}"/>
  <property name="username" value="${username}"/>
  <property name="password" value="${password}"/>
</dataSource>
```

同名属性优先级是外部文件的高

![1584764080303](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584764080303.png)

#### 类型别名

类型别名可为 Java 类型设置一个缩写名字。 它仅用于 XML 配置，意在降低冗余的全限定类名书写。例如：

当这样配置时，`Blog` 可以用在任何使用 `domain.blog.Blog` 的地方。

```xml
<typeAliases>    
    <typeAlias type="com.lyy.pojo.User" alias="User"/></typeAliases>
```

扫描实体类的包，它的默认别名就为这个类的类名，首字母小写

也可以指定一个包名，MyBatis 会在包名下面搜索需要的 Java Bean，比如：

```xml
<typeAliases>
  <package name="domain.blog"/>
</typeAliases>
```

每一个在包 `domain.blog` 中的 Java Bean，在没有注解的情况下，会使用 Bean 的首字母小写的非限定类名来作为它的别名。 比如 `domain.blog.Author` 的别名为 `author`；若有注解，则别名为其注解值。见下面的例子：

```java
@Alias("author")
public class Author {
    ...
}
```



第一种可以自定义别名，第二种只有使用默认的小写形式

第二种也可以通过在实体类上使用注解@Alias来实现别名

![1584769031564](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584769031564.png)

这种方式起别名后就不能用原来的user了



下面是一些为常见的 Java 类型内建的类型别名。它们都是不区分大小写的，注意，为了应对原始类型的命名重复，采取了特殊的命名风格。

| 别名     | 映射的类型 |
| :------- | :--------- |
| _byte    | byte       |
| _long    | long       |
| _short   | short      |
| _int     | int        |
| _integer | int        |
| _double  | double     |
| _float   | float      |
| _boolean | boolean    |
| string   | String     |

基本类型需要在名前面加_



#### 设置

| 设置名             | 描述                                                         | 有效值        | 默认值 |
| :----------------- | :----------------------------------------------------------- | :------------ | :----- |
| lazyLoadingEnabled | 延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置 `fetchType` 属性来覆盖该项的开关状态。 | true \| false | false  |
| cacheEnabled       | 全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。     | true \| false | true   |

| mapUnderscoreToCamelCase | 是否开启驼峰命名自动映射，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn。 | true \| false                                                | False  |
| ------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ |
| logImpl                  | 指定 MyBatis 所用日志的具体实现，未指定时将自动查找。        | SLF4J \| LOG4J \| LOG4J2 \| JDK_LOGGING \| COMMONS_LOGGING \| STDOUT_LOGGING \| NO_LOGGING | 未设置 |

因为数据库中oracle的厂商的默认处理是会把所有字段转换成大写，为了区别单词需要在单词间加_，如last_name

jdk7中就引入_，如1000000可写成1_000_000;



#### 其他配置

#####映射器（mappers）

既然 MyBatis 的行为已经由上述元素配置完了，我们现在就要来定义 SQL 映射语句了。 但首先，我们需要告诉 MyBatis 到哪里去找到这些语句。 在自动查找资源方面，Java 并没有提供一个很好的解决方案，所以最好的办法是直接告诉 MyBatis 到哪里去找映射文件。 你可以使用相对于类路径（main/java）的资源引用，或完全限定资源定位符（包括 `file:///` 形式的 URL），或类名和包名等

```xml
<!-- 使用相对于类路径的资源引用 -->
<mappers>
  <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
  <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
  <mapper resource="org/mybatis/builder/PostMapper.xml"/>
</mappers>
<!-- 使用完全限定资源定位符（URL） -->
<!-- 使用的少-->
<mappers>
  <mapper url="file:///var/mappers/AuthorMapper.xml"/>
  <mapper url="file:///var/mappers/BlogMapper.xml"/>
  <mapper url="file:///var/mappers/PostMapper.xml"/>
</mappers>
<!-- 使用映射器接口实现类的完全限定类名 -->
<mappers>
  <mapper class="org.mybatis.builder.AuthorMapper"/>
  <mapper class="org.mybatis.builder.BlogMapper"/>
  <mapper class="org.mybatis.builder.PostMapper"/>
</mappers>
<!-- 将包内的映射器接口实现全部注册为映射器 -->
<mappers>
  <package name="org.mybatis.builder"/>
</mappers>
```

  <mapper class="org.mybatis.builder.AuthorMapper"/>

使用这两个方式要求接口和他的Mapper配置文件必须同名且在同一包下

#### 推荐插件:mybatisplus

### 再提生命周期和作用域



![1584771855489](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584771855489.png)

#### sqlsessionfactory

可以想象成数据库连接池，作用于应用的运行期间，要一直存在

使用单例模式

#### sqlsession

 连接到连接池的一个请求

SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域

![1584772356360](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584772356360.png)



### 5 解决属性名和字段名不一致的问题

如本来是String pwd,然后定义成Sting password，在进行sql操作时候就找不到pwd

解决方法

#### 第一种取别名

```sql
select id,name,pwd as password from mybatis,user where id = #{id};
```



#### 第二种方法 resultMap结果集映射

![1584783709700](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584783709700.png)

`resultMap` 元素是 MyBatis 中最重要最强大的元素。它可以让你从 90% 的 JDBC `ResultSets` 数据提取代码中解放出来，并在一些情形下允许你进行一些 JDBC 不支持的操作。实际上，在为一些比如连接的复杂语句编写映射代码的时候，一份 `resultMap` 能够代替实现同等功能的数千行代码。ResultMap 的设计思想是，对简单的语句做到零配置，对于复杂一点的语句，只需要描述语句之间的关系就行了。

显式使用外部的 `resultMap` 会怎样，这也是解决列名不匹配的另外一种方式。

```xml
<resultMap id="userResultMap" type="User">
  <id property="id" column="user_id" />
  <result property="username" column="user_name"/>
  <result property="password" column="hashed_password"/>
</resultMap>
```



然后在引用它的语句中设置 `resultMap` 属性就行了（注意我们去掉了 `resultType` 属性）。比如:

```xml
<select id="selectUsers" resultMap="userResultMap">
  select user_id, user_name, hashed_password
  from some_table
  where id = #{id}
</select>
```



### 6 日志

#### 6.1 日志工厂

需要掌握LOG4J和SEDOUT_LOGGING

| logImpl | 指定 MyBatis 所用日志的具体实现，未指定时将自动查找。 | SLF4J \| LOG4J \| LOG4J2 \| JDK_LOGGING \| COMMONS_LOGGING \| STDOUT_LOGGING \| NO_LOGGING | 未设置 |
| ------- | ----------------------------------------------------- | ------------------------------------------------------------ | ------ |
|         |                                                       |                                                              |        |

```xml
<settings>    <setting name="logImpl" value="STDOUT_LOGGING"/></settings>
```

![1584786156360](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584786156360.png)

#### 6.2 Log4j

1.maven中导入

2.log4j.properties

```properties
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码  
log4j.rootLogger=DEBUG,console,file

#控制台输出的相关设置
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=【%c】-%m%n

#文件输出的相关设置
log4j.appender.file = org.apache.log4j.RollingFileAppender
log4j.appender.file.File=./log/kuang.log
log4j.appender.file.MaxFileSize=10mb
log4j.appender.file.sThreshold=DEBUG
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=【%p】【%d{yy-MM-dd}】【%c】%m%n

#日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
```

3.配置log4j为日志的实现

```xml
    <settings>
         <setting name="logImpl" value="LOG4J"/>   
</settings>
```

4.Log4j的使用 直接测试刚才的实现



直接使用

```
static Logger logger = Logger.getLogger(UserMapperTest.class);
```

对应的包为import org.apache.log4j.Logger;

用Logger.debug()来代替Sout的输出debug

4.日志级别

info debug error



### 7.分页

#### 7.1 使用Limit分页

```sql
select * from user limit startindex,size
select * from user limit size --从0行开始
```

类和集合做parameter时候需要一个写一样的属性名

基础类型不用

#### RowBounds分页



### 8.使用注解开发

#### 面向接口编程

接口从更深层次来看接口应有两类

第一类是对一个个体的抽象，它可对应为一个抽象体（抽象类）

第二类是对一个个体某一方面的抽象，即形成一个抽象面（interface)



具体参考官网

语句

```java
@Select("select * from user")
List<User> getUsers();
```

需要绑定接口

```xml
    <mappers>
        <!--        <mapper resource="com/lyy/dao/UserMapper.xml"/>-->        
        <mapper class="com.lyy.dao.UserMapper"/>    </mappers>
```

然后写测试

```java
@Testpublic void selectUsers(){    
    SqlSession sqlSession = MybatisUtils.getSqlSession();    UserMapper mapper = sqlSession.getMapper(UserMapper.class);    List<User> users = mapper.getUsers();    
    for (User user:users    ) {        System.out.println(user);    }  
    sqlSession.close();}
```

通过debug 打断点的方式可以查看配置生效的情况



效果可以简化配置

本质:反射机制实现

底层:动态代理



#### Mybatis执行流程刨析

![1584931905300](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584931905300.png)

![1584931997502](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584931997502.png)



#### 注解增删改查



可以设置事务自动提交只需要写

```java
sqlSessionFactory.openSession();
```

```java
//多个参数时候需要在参数名前加@Param("id"),id为参数名
//且sql中参数名是与接口中@Param("id2")一致
@Select("select *from user where id=#{id2}")    
User getUserByID(@Param("id2") int id);
```



##### Insert

注解中参数需要和实体类中属性一致

```java
@Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd})")
int addUser(User user);
```



##### Update

```java
@Update("update user set name=#{name}")
int updateUser1(User user);
```



##### delete

```java
@Delete("delete from user where id = #{uid}")
int deleteUser1(@Param("uid") int id);
```



![1584933971314](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584933971314.png)



#### ${}和#{}的区别

参考：https://www.cnblogs.com/liaowenhui/p/12217959.html

1）#{}是预编译处理，$ {}是字符串替换。

）mybatis在处理#{}时，会将sql中的#{}替换为?号，调用PreparedStatement的set方法来赋值；mybatis在处理 $ { } 时，就是把 ${ } 替换成变量的值。

3）使用 #{} 可以有效的防止SQL注入，提高系统安全性。

要理解记忆这个题目,我觉得要抓住两点：

（1）$ 符号一般用来当作占位符，常使用Linux脚本的同学应该对此有更深的体会吧。既然是占位符，当然就是被用来替换的。知道了这点就能很容易区分$和#，从而不容易记错了。

（2）预编译的机制。预编译是提前对SQL语句进行预编译，而其后注入的参数将不会再进行SQL编译。我们知道，SQL注入是发生在编译的过程中，因为恶意注入了某些特殊字符，最后被编译成了恶意的执行操作。而预编译机制则可以很好的防止SQL注入。在某些特殊场合下只能用`${}，不能用#{}。例如：在使用排序时ORDER BY ${id}`，如果使用#{id}，则会被解析成ORDER BY “id”,这显然是一种错误的写法。

**Mabatis中模糊查询防止sql注入**

Mysql:

select * from user where name like concat('%', #{name}, '%')   



select * from ${tableName} where name = #{name}

在这个例子中，如果表名为

 user; delete user; --

则动态解析之后 sql 如下：

select * from user; delete user; -- where name = ?;

#### mybatis sql 动态解析

mybatis 在调用 connection 进行 sql 预编译之前，会对sql语句进行动态解析，动态解析主要包含如下的功能：

占位符的处理

动态sql的处理

参数类型校验



### Lombok的使用

##### Lombok实现原理  

自从Java 6起，javac就支持“JSR 269 Pluggable Annotation Processing API”规范，只要程序实现了该API，就能在javac运行的时候得到调用。

Lombok就是一个实现了"JSR 269 API"的程序。在使用javac的过程中，它产生作用的具体流程如下：

------

\1. javac对源代码进行分析，生成一棵抽象语法树(AST)

\2. javac编译过程中调用实现了JSR 269的Lombok程序

\3. 此时Lombok就对第一步骤得到的AST进行处理，找到Lombok注解所在类对应的语法树       (AST)，然后修改该语法树(AST)，增加Lombok注解定义的相应树节点

\4. javac使用修改后的抽象语法树(AST)生成字节码文件



看情况是否使用

##### 步骤

- IDEA中：File→Settings→Plugins→搜索Lombok
- 引入Lombok的maven依赖。
- 在实体类上加注解即可

```
@Getter@Setter
@FieldNameConstants
@ToString
@EqualsAndHashCode
@AllArgsConstructor(所有参数构造)
@NoArgsConstructor(无参构造)
@Data(相当于添加了@Getter@Setter@ToString@NoArgsConstructor(无参构造))
```

```
@AllArgsConstructor(所有参数构造)
@Data(相当于添加了@Getter@Setter@ToString@NoArgsConstructor(无参构造))
```



### 10.多对一的处理

#### 环境搭建

```java
public class Student {    
    private int id;    
    private String name;    //学生需要关联一个老师    //所以不用private int tid;    //组合：新的类由现有对象所组成。        
    private Teacher teacher;}
```

判断包能不能展开来解决路径问题



#### 按照查询嵌套处理

```xml
<!--
思路：
    1、查询所有的学生信息
    2、根据查询出来的学生的id的tid，寻找对应的老师！ -子查询

-->

<select id="getStudent" resultMap="StudentTeacher">
select * from student
</select>

<resultMap id="StudentTeacher" type="Student">
    <!--复杂的属性，我们需要单独处理  对象：association  集合：collection-->
    <association property="teacher" column="tid" javaType="com.rui.pojo.Teacher" select="getTeacher"/>
</resultMap>

<select id="getTeacher" resultType="Teacher">
    select * from teacher where id = #{id}
</select>
```

teacher会自动匹配 就是推断

#### 按照结果嵌套处理

```xml
<!--按照结果嵌套处理-->
<select id="getStudent2" resultMap="StudentTeacher2">
    select s.id sid,s.name sname,t.name tname,t.id tid
    from student s,teacher t
    where s.tid=t.id;
</select>

<resultMap id="StudentTeacher2" type="com.rui.pojo.Student">
    <result property="id" column="sid"/>
    <result property="name" column="sname"/>
    <association property="teacher" javaType="com.rui.pojo.Teacher">
        <result property="id" column="tid"></result>
        <result property="name" column="tname"></result>
    </association>

</resultMap>
```

类似联表查询

### 12、动态SQL

**什么是动态SQL：动态SQL就是指根据不同的条件生成不同的SQL语句**



### 13、缓存

为什么使用缓存?

减少和数据库的交互次数，减少系统开销,提高系统效率

特点:读写分离，主从复制？memcache



什么样的数据能使用缓存？

经常查询并且不经常改变的数据



#### 13.2 Mybatis缓存

MyBatis中默认定义了两级缓存:一级缓存和二级缓存

默认情况下，只有一级缓存开启

SqlSession级别的缓存,也称为本地缓存

二级缓存需要手动开启和配置,他是基于namespace级别的缓存

为了提高扩展性,MyBatis定义了缓存接口Cache，我们可以通过实现Cache接口来自定义二级缓存

