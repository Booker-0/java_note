# JavaWeb-J2EE

### 别人的建议

如果没有学历优势，转行吧，如果是web方向。不要坚持了。

web的初开已经炸了。上面的答案居然还推荐你ssh，ssm我他妈真的服气。

真的想转：

数据结构不要太差，链表二叉树排序递归简单算法能会就会。

常用的设计模式，单例，代理，工厂等。

javaweb的过滤器拦截器监听器，会话机制。servlet理解。jsp放弃。

基础的spring和springmvc。ioc，aop，spring事务机制，失效原因，七个传播行为。

持久层学会mybatis。学会mybatis的逆向工程插件使用。hibernate可以不用学了，学jpa就够了。

springboot 快速开发，技术选型谁还考虑用传统的ssm，ssh，除非维护老的系统你可能还会接触到

springcloud 注册中心 负载均衡 服务熔断 网关 分布式配置中心 服务远程调用

dubbo zookeeper机制原理

mq消息推送

nosql 的redis数据类型 集群 主从复制 缓存穿透 分布式锁 发布订阅 使用场景和限制。jedis和springdata系列选一个操作redis的技术。

数据库MySQL.Oracle，基础查询，存储过程，MySQL的锁，索引，引擎，基于慢SQL的优化，explain性能分析。再深点分库分表。

前端的三大框架学一个吧，推荐vue，基于你的时间，jquery这种直接操作dom的可以不学了。ajax交互得会。理解前端mvvm的思想。

js HTML CSS要会，要不然可以学学一些UI框架easyui（接近被淘汰）elementui之类的。

服务器至少得会tomcat，nginx也要了解。http协议和tcp/ip协议。

Linux常用命令。应用部署有时间就熟悉一下。经济允许买个阿里云腾讯云服务器玩玩。价格不贵。

你以为学会这些就够了，别急，有的企业招聘还要你：

多线程（JAVA最难的部分），JAVA内存模型，JVM。socket编程。

贸易战和互联网金融暴雷，这个行业对于学历没有优势的入行者来说就是断头台，不要送人头了和给培训班送钱了。初级开发已经人山人海了，换句话说，你已经错过了JAVAweb入场的最好时间了，最好的时候是15-16年。不是你的原因，历史进程如此。就像当初安卓和iOS行情遇冷的时候。JAVA依然是最火的后端语言，但是web现在的入场门槛已经将大部分人堵在门外了。有经验的中高开行情还挺好的。

真想入行最后建议：利用这一年，把上述的都学会了，大四找大中型企业实习转正，避开社招





作者：谢龙





更新：我新开通了知乎专栏 [Not A Nerd? - 知乎专栏](https://zhuanlan.zhihu.com/notageek)
现在互联网上资源丰富，Java 学习并不难。贴个 Java 服务端入门和进阶指南，是给我们组新人入门用的，包括了学习目标、需要掌握的技能和参考资料，并规划了学习阶段和时间，希望帮助到题主。前言

- 尽量用 google 查找技术资料。
- 有问题在 stackoverflow 找找，大部分都已经有人回答。
- 多看官方的技术文档。
- ibm developerworkers 的文章质量整体上有保障。
- 平时花一些时间在 github 上阅读优秀项目源码。

入门（1-2 个月）

1. 目标：参与简单的项目开发。
2. 技能：
   - 掌握 Java。经典的《Java 核心技术：卷1 基础知识》(或者《Java 编程思想》)必看，跳过其中的图形和 applet 章节。习惯查阅 Java API Doc。为了保证代码的质量，《Effective Java》、《Clean Code》和《重构》也需要至少通读一遍。
   - 熟悉 Linux 开发环境和 bash shell。Linux 是我们的开发和部署环境，你最好尽快熟练它。Linux 的基本使用可以通过《鸟哥的Linux私房菜：基础学习篇（第三版）》学习，开发 bash shell 脚本可以参考《Linux Shell脚本攻略》。
   - 掌握开发工具
     - 熟练使用一种 IDE。Intellij IDEA或者 Eclipse 都可以，推荐使用前者。至少熟悉常用的快捷键，会 debug(包括远程 debug)项目。
     - 熟悉一种编辑器。比如 Vim/Emacs/Sublime Text，至少学会搜索/替换/代码补全。
   - 掌握 JDK 以外的常用类库和工具包。JDK 原生 API 在很多场景下使用并不方便。你需要掌握社区贡献的优秀类库和工具包，比如 apache commons、google guava 等，具体可以翻阅 [服务端技术选型 ](https://link.zhihu.com/?target=http%3A//xielong.me/2015/04/17/%E6%9C%8D%E5%8A%A1%E7%AB%AF%E6%8A%80%E6%9C%AF%E9%80%89%E5%9E%8B/)的Utility 篇。
   - 掌握 Web 开发框架。我们使用 Spring(或Rose) + Ibatis(或Jade) 开发 web 服务，你需要熟练掌握它们。
   - 学习代码规范。我们大致上遵循 oracle 的 Java 语言编码规范，你可以先阅读并熟悉它。Code Formatting 文件在 git@xxx/coding-standard.git，在编写代码之前，请把它导入到 IDE 中。另外，确认 IDE 已经安装 Findbugs 和 CheckStyle 插件。
   - 熟悉开发流程。我们的开发流程大致如下：功能开发->单元测试->功能测试->Code Review->集成测试->发布。确保你熟悉其中的每个环节。
   - 其他。需要熟练使用版本控制工具 Git（阅读：《Git 权威指南》），以及项目构建工具 Maven（阅读：《Maven 实战》）。另外，在这个阶段可以尝试 TDD 开发。

进阶（2-6 个月）

- 目标：独立负责某个服务端项目。
- 技能：
  - 掌握 web 开发最佳实践，掌握 Restful API 设计，理解 Spring 原理。推荐阅读《Spring揭秘》。掌握项目分层、子模块划分。推荐阅读：《J2EE 核心模式》。
  - 掌握 web 架构设计。包括 Http 反向代理，数据缓存，负载均衡，水平扩展和垂直扩展。推荐阅读：《分布式 Java 应用：基础与实践》。
  - 掌握关系型数据库。包括设计 MySQL 表结构，根据业务特点分表分库，基于执行计划的 SQL 分析优化，以及数据库容量规划。推荐阅读：《MySQL 必知必会》、《高性能 MySQL》。
  - 了解 NoSQL。我们大规模使用 Hadoop、HBase、Hive，同时部分项目使用 Redis、Storm。你需要学会这些工具最基本的使用。
  - 学习 web 安全知识。了解 web 前端安全问题。设计安全 web 服务，包括加解密、防伪造、防重放攻击等。
  - 掌握 Http (推荐阅读：《图解Http》、《http权威指南》)、Thrift 等协议。
  - 掌握服务容量规划，性能调优，可靠性保证，以及故障处理。学习容量规划和性能调优知识，梳理业务监控点，熟练使用我们的监控报警系统。推荐阅读：《深入理解 Java 虚拟机》。
  - 其他。设计模式：从项目中学习，有时间可以看看《深入浅出设计模式》、《JDK 里的设计模式》。学习Java Socket 编程与多线程知识，可以看看《Java 并发编程实战》，并翻翻并发编程网的文章。

深入（6 个月-）

- 目标：分布式系统和中间件开发。
- 构建知识体系：《大型网站系统与 Java 中间件实践》、《大型网站技术架构：核心原理与案例分析》。
- 原理与设计：《大规模存储式系统》、《UNIX 网络编程 卷1:套接字联网 API》、《How Tomcat Works》。
- 学习开源项目：Apache Thrift、Zipkin、Netty、Rose、Jade、淘宝 RPC 系统 Dubbo 等。分析项目中的设计思路。比如，同样是RPC框架，Finagle 和 Dubbo 有什么异同。
- 其他。根据参与的项目加深学习吧。比如，如果需要写 DSL，可以读一下《领域特定语言》，对 Redis 感兴趣推荐读一下：《Redis 设计与实现》。有两本书，无论做什么项目，都推荐读：《Unix 编程艺术》、《UNIX 环境高级编程(第3版)》。

## Tomcat

参考博客:<https://www.cnblogs.com/jingmoxukong/p/8258837.html?utm_source=gold_browser_extension>

Tomcat是由Apache开发的一个Servlet容器

解压tar.gz文件用tar -zxf

```shell
USER       PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
```

用ps aux | grep tomcat可以查看是否启动成功

### 弯路

启动后发现jre的路径不对,然后到setclasspath.sh里增加

export JRE_HOME=/home/lyy/extension/lyy/java/jdk-11.0.5

就能正常启动了

### Tomcat 重要目录



- **/bin** - Tomcat 脚本存放目录（如启动、关闭脚本）。 `*.sh` 文件用于 Unix 系统； `*.bat` 文件用于 Windows 系统。
- **/conf** - Tomcat 配置文件目录。
- **/logs** - Tomcat 默认日志目录。
- **/webapps** - webapp 运行的目录。

### web 工程发布目录结构



一般 web 项目路径结构

```
|-- webapp                         # 站点根目录
    |-- META-INF                   # META-INF 目录
    |   `-- MANIFEST.MF            # 配置清单文件
    |-- WEB-INF                    # WEB-INF 目录
    |   |-- classes                # class文件目录
    |   |   |-- *.class            # 程序需要的 class 文件
    |   |   `-- *.xml              # 程序需要的 xml 文件
    |   |-- lib                    # 库文件夹
    |   |   `-- *.jar              # 程序需要的 jar 包
    |   `-- web.xml                # Web应用程序的部署描述文件
    |-- <userdir>                  # 自定义的目录
    |-- <userfiles>                # 自定义的资源文件
```

`webapp`：工程发布文件夹。其实每个 war 包都可以视为 webapp 的压缩包。

`META-INF`：META-INF 目录用于存放工程自身相关的一些信息，元文件信息，通常由开发工具，环境自动生成。

`WEB-INF`：Java web应用的安全目录。所谓安全就是客户端无法访问，只有服务端可以访问的目录。

`/WEB-INF/classes`：存放程序所需要的所有 Java class 文件。

`/WEB-INF/lib`：存放程序所需要的所有 jar 文件。

`/WEB-INF/web.xml`：web 应用的部署配置文件。它是工程中最重要的配置文件，它描述了 servlet 和组成应用的其它组件，以及应用初始化参数、安全管理约束等。

### 配置

参考官网介绍

[http://tomcat.apache.org/tomcat-8.5-doc/config/index.html

###　启动

### 部署方式

这种方式要求本地必须安装 Tomcat 。

将打包好的 war 包放在 Tomcat 安装目录下的 `webapps` 目录下，然后在 bin 目录下执行 `startup.bat` 或 `startup.sh` ，Tomcat 会自动解压 `webapps` 目录下的 war 包。

成功后，可以访问 <http://localhost:8080/xxx> （xxx 是 war 包文件名）。

> **注意**
>
> 以上步骤是最简单的示例。步骤中的 war 包解压路径、启动端口以及一些更多的功能都可以修改配置文件来定制 （主要是 `server.xml` 或 `context.xml` 文件）。

#### IDE 插件



常见 Java IDE 一般都有对 Tomcat 的支持。

以 Intellij IDEA 为例，提供了 **Tomcat and TomEE Integration** 插件（一般默认会安装）。



**使用步骤**

先点击run

- 点击 Run/Debug Configurations > New Tomcat Server > local ，打开 Tomcat 配置页面。
- 点击 Confiure... 按钮，设置 Tomcat 安装路径。
- 点击 Deployment 标签页，设置要启动的应用。
- 设置启动应用的端口、JVM 参数、启动浏览器等。
- 成功后，可以访问 <http://localhost:8080/（当然，你也可以在> url 中设置上下文名称）。

![tomcat-intellij-run-config.png](https://upload-images.jianshu.io/upload_images/3101171-80dd31daff8424ad.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



## Serlvet

### Servlet的作用

Servlet的最大作用是能够处理浏览器带来的HTTP请求,并返回一个响应给浏览器,从而实现浏览器和服务器的交互

### JAVAWEB目录结构



![img](https://mmbiz.qpic.cn/mmbiz_png/2BGWl1qPxib2FPYiazSBurrVsbt1mkHFfDJAWW9gicAUZKZhAjhVjvsayD6GAuabYyHmyf5s6wDs87plhePMFMjfw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)



### 第一个demo

参考博客:<https://www.cnblogs.com/jianyungsun/p/6526301.html>

参考博客:<https://www.imooc.com/article/2025>

### Servlet生命周期方法

在你的应用加载并使用一个Servlet时，从初始化到销毁这个Servlet期间会发生一系列的事件.这个期间就叫生命周期

Servlet生命周期的三个核心方法分别是`init()` , `service()` 和 `destroy()`。每个Servlet都会实现这些方法，并且在特定的运行时间调用它们。



### 使用@WebServlet注解来开发Servlet

#### 引入概念注解

Java 注解（Annotation）又称 Java 标注，是 JDK5.0 引入的一种注释机制。

##### 内置的注解



Java 定义了一套注解，共有 7 个，3 个在 java.lang 中，剩下 4 个在 java.lang.annotation 中。

**作用在代码的注解是**

- @Override - 检查该方法是否是重写方法。如果发现其父类，或者是引用的接口中并没有该方法时，会报编译错误。
- @Deprecated - 标记过时方法。如果使用该方法，会报编译警告。
- @SuppressWarnings - 指示编译器去忽略注解中声明的警告。

作用在其他注解的注解(或者说 元注解)是:

- @Retention - 标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问。
- @Documented - 标记这些注解是否包含在用户文档中。
- @Target - 标记这个注解应该是哪种 Java 成员。
- @Inherited - 标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)

从 Java 7 开始，额外添加了 3 个注解:

- @SafeVarargs - Java 7 开始支持，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告。
- @FunctionalInterface - Java 8 开始支持，标识一个匿名函数或函数式接口。
- @Repeatable - Java 8 开始支持，标识某注解可以在同一个声明上使用多次。



使用 `@WebServlet` 注解并且不需要在`web.xml`里为Servlet注册任何信息。**容器会自动注册你的Servlet到运行环境，并且像往常一样处理它。**
如

```java
@WebServlet(name="MyFirstServlet",urlPatterns={"/MyFirstServlet"})
```



### 编写动态的Servlet响应内容

```
Servlet能动态显示网页内容。这些内容可以从服务器本身、另外一个网站、或者许多其他网络可以访问的资源里获取。Servlet不是静态网页，它们是动态的。可以说这是它们最大的优势。
```



### 处理Servlet请求和响应

Servlet可以轻松创建一个基于请求和响应生命周期的web应用。它们能够提供HTTP响应并且可以使用同一段代码来处理业务逻辑。处理业务逻辑的能力使Servlet比标准的HTML代码更强大。

现实世界里的应用，一个HTML网页表单包含了要发送给Servlet的参数。Servlet会以某种方式来处理这些参数并且 返回一个客户端能够识别的响应。在对象是HttpServlet的情况下，客户端是web浏览器，响应是web页面。`<form>`的 action属性指定了使用哪个Servlet来处理表单里的参数值。

为了获取请求参数，需要调用 HttpServletRequest 对象的 `getParameter()`方法，并且传递你要获取的输入参数的id给该方法。
`String value1 = req.getParameter("param1");`
`String value1 = req.getParameter("param2");`

为了发送内容给客户端，你需要使用从 HttpServletResponse 里获取的 PrintWriter 对象。任何写到这个对象的内容都会被写进outputstream里，并会把内容发送回给客户端。

### 监听Servlet容器事件

可以在应用里注册一个监听器来显示应用什么时候开启或者关闭.因此,通过监听这些事件,Servlet可以在一些事件发生时执行相应的动作

为了创建一个基于容器事件执行动作的监听器，你必须创建一个实现 `ServletContextListener` 接口的类。这个类必须实现的方法有 `contextInitialized()` 和 `contextDestroyed()`。这两个方法都需要 `ServletContextEvent` 作为参数，并且在每次初始化或者关闭Servlet容器时都会被自动调用。

为了在容器注册监听器，你可以使用下面其中一个方法：

1) 利用 `@WebListener` 注解。
2) 在`web.xml`应用部署文件里注册监听器。
3) 使用 ServletContext 里定义的 `addListener()` 方法

请注意，ServletContextListener 不是Servlet API里唯一的监听器。这里还有一些其他的监听器，比如

```
javax.servlet.ServletRequestListener
javax.servlet.ServletRequestAttrbiteListener
javax.servlet.ServletContextListener
javax.servlet.ServletContextAttributeListener
javax.servlet.HttpSessionListener
javax.servlet.HttpSessionAttributeListener
```

### 传递Servlet初始化参数

Servlet同样可以接受初始化参数,并在处理第一个请求前使用它们来构建配置参数

在web,xml设置完后就可以调用getServletConfig.getInitiaizationParameter()并传递参数名给该方法来使用参数就像下面展示的代码一样：

`<web-app>`
    `<servlet>`
        `<servlet-name>SimpleServlet</servlet-name>`
        `<servlet-class>com.howtodoinjava.servlets.SimpleServlet</servlet-class>`

        <!-- Serv
    let init param -->
        <init-param>
            <param-name>name</param-name>
            <param-value>value</param-value>
        </init-param>
    
    </servlet>

`</web-app>`

```
String value = getServletConfig().getInitParameter("name");
```

### 为特定的URL请求添加Servlet过滤器

Web过滤器在给定的URL被访问时对请求进行预处理并调用相应的功能是很有用的.相比于直接调用给定URL请求的Servlet,包含相同URL模式的过滤器filter会在Servlet调用前被调用.

过滤器必须要实现`javax.servlet.Filter`接口。这个接口包含了`init()`，`descriptor()`和`doFilter()`这些方法。`init()`和`destroy()`方法会被容器调用。 `doFilter()`方法用来在过滤器类里实现逻辑任务。如果你想把过滤器组成过滤链（chain filter）或者存在多匹配给定URL模式的个过滤器，它们就会根据`web.xml`里的配置顺序被调用。

为了在web.xml里配置过滤器，需要使用<filter>和<filter-mapping> XML元素以及相关的子元素标签。

``<filter>`
`<filter-name>LoggingFilter</filter-name>`
`<filter-class>LoggingFilter</filter-class>`
`</filter>`
`<filter-mapping>`
`<filter-name>LogingFilter</filter-name>`
`<url-pattern>/*</url-pattern>`
`</filter-mapping>`

如果你要使用注解来为特定的servlet配置过滤器，可以使用@WebFilter注解

### 使用Servlet下载二进制文件

几个主要头的作用

（1）Content-Type的作用

该实体头的作用是让服务器告诉浏览器它发送的数据属于什么文件类型。

例如：当Content-Type 的值设置为text/html和text/plain时,前者会让浏览器把接收到的实体内容以HTML格式解析,后者会让浏览器以普通文本解析.

（2）Content-Disposition 的作用

当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。

在讲解这个内容时,张老师同时讲出了解决中文文件名乱码的解决方法,平常想的是使用getBytes() , 实际上应使用email的附件名编码方法对文件名进行编码,但IE不支持这种作法(其它浏览器支持) , 使用javax.mail.internet.*包的MimeUtility.encodeWord("中文.txt")的方法进行编码。

为了下载一个文件，Servlet必须提供一个和下载文件类型匹配的响应类型。同样，必须在响应头里指出该响应包含附件

通过调用 `ServletContext.getResourceAsStream()` 方法并传递文件路径给该方法，你可以获取要下载的文件（文件保存在文件系统）的引用。这个方法会返回一个输入流（InputStream）对 象，我们可以用这个对象来读取文件内容。当读取文件时，我们创建一个字节缓存区（byte buffer）从文件里获取数据块。最后的工作就是读取文件内容并且把它们复制到输出流。我们使用while循环来完成文件的读取，这个循环直到读取了文 件的所有内容才会跳出循环。我们使用循环来读进数据块并把它写进输出流。把所有数据写进输出流后，ServletOutputStream 对象的flush方法就会被调用并且清空内容和释放资源。



## 过滤器

![img](https://mmbiz.qpic.cn/mmbiz_png/2BGWl1qPxib0jZYGcibxjnjskR3epWiapBqjt13uraMblDDOYFpiaibHfKBEiblPvCMgG6yMZ69dQdu0GcnruC7QU6Pw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

过滤器可以做：**过滤一些敏感的字符串【规定不能出现敏感字符串】、避免中文乱码【规定Web资源都使用UTF-8编码】、权限验证【规定只有带Session或Cookie的浏览器，才能访问web资源】等等**

### 过滤器API

只要Java类实现了Filter接口就可以称为过滤器

```java
public interface Filter {
    public void init(FilterConfig var1) throws ServletException;
    public void doFilter(ServletRequest var1,ServletResponse var2,FilterChain var3)
    public void destroy();
    public boolean isLoggable(LogRecord record)；
}
```

FilterChain是一个接口

在java中就使用了链式结构.把所有的过滤器都放在FilterChain里边

### filter部署

#### 第一种方式：在web.xml文件中配置

#### filter

**<filter>用于注册过滤器**

```
<filter>
         <filter-name>FilterDemo1</filter-name>
         <filter-class>FilterDemo1</filter-class>
         <init-param>
         <param-name>word_file</param-name> 
         <param-value>/WEB-INF/word.txt</param-value>
         </init-param>
</filter>
```

`<filter-name>`用于**为过滤器指定一个名字**，该元素的内容不能为空。
`<filter-class>`元素用于指定过滤器的**完整的限定类名**。
`<init-param>`元素用于为过滤器指定初始化参数，它的子元素指定参数的名字，`<param-value>`指定参数的值。在过滤器中，可以**使用FilterConfig接口对象来访问初始化参数**。

#### filter-mapping

`<filter-mapping>`元素用于**设置一个Filter 所负责拦截的资源**。

一个Filter拦截的资源可**通过两种方式来指定：Servlet 名称和资源访问的请求路径**

```
<filter-mapping>
    <filter-name>FilterDemo1</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

`<filter-name>`子元素用于设置filter的注册名称。**该值必须是在元素中声明过的过滤器的名字**
**<url-pattern>设置 filter 所拦截的请求路径(过滤器关联的URL样式)**
**<servlet-name>指定过滤器所拦截的Servlet名称**。
`<dispatcher>`指定过滤器所拦截的资源被 Servlet 容器调用的方式，可以是**REQUEST,INCLUDE,FORWARD和ERROR之一，默认REQUEST**。用户可以设置多个`<dispatcher>` 子元素**用来指定 Filter 对资源的多种调用方式进行拦截。**

#### dispatcher

子元素可以设置的值及其意义：

- REQUEST：**当用户直接访问页面时，Web容器将会调用过滤器**。如果目标资源是通过RequestDispatcher的include()或forward()方法访问时，那么该过滤器就不会被调用。
- INCLUDE：如果目标资源**是通过RequestDispatcher的include()方法访问时，那么该过滤器将被调用**。除此之外，该过滤器不会被调用。
- FORWARD：如果目标资源是通过**RequestDispatcher的forward()方法访问时，那么该过滤器将被调用**，除此之外，该过滤器不会被调用。
- ERROR：如果目标资源是**通过声明式异常处理机制调用时，那么该过滤器将被调用**。除此之外，过滤器不会被调用。

#### 第二种方式:通过注解配置

`WebFilter(filterName = "FilterDemo1",urlPatterns="/*")`

上面配置是`"*/*"`,所有的Web资源都需要途径过滤器

如果想要部分的Web资源进行过滤器过滤则需要指定Web资源的名称即可

### 过滤器的执行顺序

FilterChain中的doFilter()方法决定着是否放行下一个过滤器执行(如果没有过滤器了,就执行目标资源)

那么，多个过滤器谁前谁后呢？这还与我们前面的配置有关

- 注解配置：按照类名字符串比较，值小的先执行

- - Eg：AFilterDemo 优先于 BFilterDemo



- web.xml配置：`<filter-mapping>`中谁在上面，谁优先执行



### 过滤器练习问题解决

1,网络上代码复制报illegal character 200B

复制到typora就能看到异常处，删除即可

２一个或多个筛选器启动失败。完整的详细信息将在相应的容器日志文件中找到

参考博客:<https://blog.csdn.net/devnn/article/details/104373310>



setAttribute这个方法，在JSP内置对象session和request都有这个方法，这个方法作用就是保存数据，然后还可以用getAttribute方法来取出。
比如现在又个User对象，User curruser = new User("zhangsan", 20, "男");
1，request.setAttribute(“curruser”, curruser)这个方法是将curruser这个对象保存在request作用域中，然后在转发进入的页面就可以获取到你的值，如果你会一些框架的话，那些框架标签也可以获取到，比如struts标签，还有jstl。如果这你都不会的话，那么你可以在jsp页面编写java小脚本来获取:<% User myuser = (User)request.getAttribute("curruser")%>,在jsp页面显示值:<%=myuser.getName()%>。
2，session.setAttribute("curruser", curruser)。这个方法和上面唯一的区别就是作用域，就是在你整个程序启动的时候，如果在session中保存了数据，那么在你这个无论你在哪个页面，在什么时候都可以获取到这个值，全局的，只要你的这个程序是启动的。session默认的过期时间是30分钟，过期无效，可以去修改这个值。





## Maven

参考博客:<https://www.cnblogs.com/hzg110/p/6936101.html>

依赖代码查询网站<https://mvnrepository.com/>

### maven是什么

maven是一款服务于java平台的自动化构建工具

构建:把动态的Web工程经过编译得到的编译结果部署到服务器上的整个过程

建的各个环节

　　[1] 清理clean：将以前编译得到的旧文件class字节码文件删除

　　[2] 编译compile：将java源程序编译成class字节码文件

　　[3] 测试test：自动测试，自动调用junit程序

　　[4] 报告report：测试程序执行的结果

　　[5] 打包package：动态Web工程打War包，java工程打jar包

　　[6] 安装install：Maven特定的概念-----将打包得到的文件复制到“仓库”中的指定位置

　　[7] 部署deploy：将动态Web工程生成的war包复制到Servlet容器下，使其可以运行

idea路径备份:/home/lyy/下载/idea-IU-191.7479.19/plugins/maven/lib/maven3/

补充:**ename**

命令用字符串替换的方式批量改变文件名。

语法 
rename(参数) 
参数 
原字符串：将文件名需要替换的字符串； 
目标字符串：将文件名中含有的原字符替换成目标字符串； 
文件：指定要改变文件名的文件列表。 
实例 
将main1.c重命名为main.c

rename main1.c main.c main1.c 
rename**支持通配符**

? 可替代单个字符 
\* 可替代多个字符 

### **常用maven命令**

　　[1] mvn clean：清理 

　　[2] mvn compile：编译主程序

　　[3] mvn test-compile：编译测试程序

　　[4] mvn test：执行测试 

　　[5] mvn package：打包

　　[6] mvn install：安装

　　执行maven命令必须进入到pom.xml的目录中进行执行

错误:[ maven：不再支持源选项 5。请使用 6 或更高版本。](https://www.cnblogs.com/huiy/p/11751858.html)



解决办法：maven报错：不再支持源选项 5。请使用 6 或更高版本。

在pom.xml中添加maven的配置

[![image](https://img2018.cnblogs.com/blog/913181/201910/913181-20191028140251470-54869573.png)](https://img2018.cnblogs.com/blog/913181/201910/913181-20191028140251020-1289073643.png)

<maven.compiler.source>11</maven.compiler.source>
<maven.compiler.target>11</maven.compiler.target>



依赖的包的仓库的默认位置/home/lyy/.m2/repository

**mvn compile** 生成target文件夹

**mvn test-compile** 生成target/test-classes文件夹

**mvn package** 在test文件夹中生成打包好的jar包

**mvn clean**，发现整个target文件夹都没了

### 仓库和坐标

**pom.xml**:Project Objext Model 项目对象模型.它是maven的核心配置文件,所有的构建的配置都在这里设置

**坐标 **

使用下面的三个向量在仓库中唯一的定位一个maven工程

![img](https://images2015.cnblogs.com/blog/31127/201706/31127-20170604084722211-90234747.png)

![img](https://images2015.cnblogs.com/blog/31127/201706/31127-20170604014732196-1454027414.png)

　maven坐标和仓库对应的映射关系：[groupId]\[artifactId]\[version]\[artifactId]-[version].jar

　　　　去本地仓库看一下此目录：org\springframework\spring-core\4.3.4.RELEASE\spring-core-4.3.4.RELEASE.jar

### 依赖

**maven解析依赖信息时会到本地仓库中取查找被依赖的jar包**

　　　　1、对于本地仓库中没有的会去中央仓库去查找maven坐标来获取jar包，获取到jar之后会下载到本地仓库

　　　　2、对于中央仓库也找不到依赖的jar包的时候，就会编译失败了

**如果依赖的是自己或者团队开发的maven工程，需要先使用install命令把被依赖的maven工程的jar包导入到本地仓库中**

举例：现在我再创建第二个maven工程HelloFriend，其中用到了第一个Hello工程里类的sayHello(String name)方法我们在给HelloFriend项目使用 mvn compile命令进行编译的时候，会提示缺少依赖Hello的jar包。怎么办呢？到第一个maven工程中执行 mvn install后，你再去看一下本地仓库，你会发现有了Hello项目的jar包一旦本地仓库有了依赖的maven工程的jar包后，你再到HelloFriend项目中使用 mvn compile命令的时候，可以成功编译

**依赖范围**

＜scope>compile</scope>

​        1.compile，默认值，适用于所有阶段（开发、测试、部署、运行），本jar会一直存在所有阶段。 

　　2、provided，只在开发、测试阶段使用，目的是不让Servlet容器和你本地仓库的jar包冲突 。如servlet.jar。 

　　3、runtime，只在运行时使用，如JDBC驱动，适用运行和测试阶段。 

　　4、test，只在测试时使用，用于编译和运行测试代码。不会随项目发布。 

　　5、system，类似provided，需要显式提供包含依赖的jar，Maven不会在Repository中查找它。



### 生命周期

不管你要执行生命周期的哪一个阶段,maven都是从这个生命周期的开始来执行

**插件：**每个阶段都有插件（plugin），看上面标红的。**插件的职责就是执行它对应的命令。**



### maven工程的依赖高级特性

**依赖的传递性**

　　**![img](https://images2015.cnblogs.com/blog/31127/201706/31127-20170604192629649-1312146036.png)**

　　WebMavenDemo项目依赖JavaMavenService1       JavaMavenService1项目依赖JavaMavenService2

　　pom.xml文件配置好依赖关系后，必须首先mvn install后，依赖的jar包才能使用。

　　　　1、WebMavenDemo的pom.xml文件想能编译通过，JavaMavenService1必须mvn install

　　　　2、JavaMavenService的pom.xml文件想能编译通过，JavaMavenService2必须mvn install

　　**传递性：**

　　　　![img](https://images2015.cnblogs.com/blog/31127/201706/31127-20170604194112477-353162303.png)

　　　　在Eclipse中，为JavaMavenService2中增加了一个spring-core.jar包后，会惊喜的发现依赖的两个项目都自动的增加了这个jar包

　　　　这就是依赖的传递性。

　　　　注意：非compile范围的依赖是不能传递的。

　　**② 依赖版本的原则：**

　　　　**1、路径最短者优先原则**

​              **![img](https://images2015.cnblogs.com/blog/31127/201706/31127-20170604195507696-1972000848.png)**

　　　　　　Service2的log4j的版本是1.2.7版本，Service1排除了此包的依赖，自己加了一个Log4j的1.2.9的版本，那么WebMavenDemo项目遵守路径最短优先原则，Log4j的版本和Sercive1的版本一致。

　　　　**2、路径相同先声明优先原则**

　　　　**![img](https://images2015.cnblogs.com/blog/31127/201706/31127-20170604200125383-1768845842.png)**

　　　　　　这种场景依赖关系发生了变化，WebMavenDemo项目依赖Sercive1和Service2，它俩是同一个路径，那么谁在WebMavenDemo的pom.xml中先声明的依赖就用谁的版本。



### build配置

？这里没看懂

<https://www.zhihu.com/question/300830746>

### 补充:idea使用技巧

**删除当前行**

```text
ctrl + y

```

**全局查找文本**

```text
ctrl + shift + F
```

**显示类之间的关系**

```text
ctrl + alt + u
```

**在当前光标在的这样一行的下一行添加一行, 并自动添加括号, 标点符号等**

```text
ctrl + shfit +enter
```

**选中当前单词(非常好用)**

```text
ctrl + w
```

**运行当前类**

```text
ctrl + shift + F10
```

**从多项目中启动一个 正常模式**

```text
alt + shfit + F10
```

**快速的查看选中类, 选中方法的定义**

> 有的时候我们不想进入方法内部, 或者进入类的内部查看细节, 想要在外面就探查清楚, 就可以使用此种方法

```java
ctrl + shift + i
```

**Ctrl+鼠标滚轴修改字体大小**

alt+enter红色灯泡

psvm sout缩写

**ALT+Insert键**

generate快捷键

## Spring

#### 下载

maven 依赖

```java
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.4.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>jdbc</artifactId>
    <version>5.2.4.RELEASE</version>
</dependency>

```

### IOC理论推导

参考博客:<https://www.cnblogs.com/hellokuangshen/p/11249253.html>

组合?设计模式?Setter?注入?

#### 接口的意义

面向接口而不是面向实现 这是一个重要的面向对象设计原则所有实现接口的类都可以实例化接口的引用变量 ，然后通过接口统一调用接口方法，jvm会自动识别是那种实现类，然后调用具体实现类的接口方法

控制反转,系统的耦合性大大降低

控制反转是一种通过描述(XML或注解)并通过第三方去生产或获取特定对象的方式,在Spring中实现控制反转的IOC容器,其实现方法是依赖注入

### 3.HelloSpring



<https://docs.spring.io/spring/docs/5.2.4.RELEASE/spring-framework-reference/>

#### .2.2。实例化容器

提供给`ApplicationContext`构造函数的位置路径是资源字符串，这些资源字符串使容器可以从各种外部资源（例如本地文件系统，Java等）加载配置元数据`CLASSPATH`。



```java
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");//CPX代替 <property ref="mysqlImpl"/>引用Spring容器中创建好的对象
```

bean = 对象 等于new了一个对象

id="变量名" class=new 的对象

property 相当于给对象中的属性设置一个值

控制:传统应用程序的对象是由程序本身控制创建的,使用Spring后，对象是由Spring来创建的

普通属性value,类对象用ref



### IOC创建方式

1.使用无参构造创建对象

2.使用有参构造创建对象

beans.xml中bean就帮忙new了一个对象，无论是否getBean

在配置文件加载的时候，容器中管理的对象就已经初始化了



### Spring配置

**alias别名**标签

<alias>

```java
    <alias name="User4" alias="aliasTest"/>
```

功能:给id取别名

**bean**

id bean的唯一标识符m也就是相当于对象名

class: bean对象所对应的全限定名:包名+类型

name:别名,且可取多个

```xml
<bean id="user1" class="com.lyy.pojo.User" name="user2 u2,u3;u4">
</bean>
```

**import**

内容相同则会合并

将多个配置文件，导入合并为一个

```xml
<import resource="beans.xml"/>
```

### DI依赖注入

#### 基于Setter方式注入

构造器注入

set方式注入

​	依赖:bean对象的创建依赖于容器

​	注入:bean对象中的所有属性,由容器来注入

Properties类

##### 前言

> Java中的Properties类属于配置文件，以键值对的方式存储，可以看做是属性集。
> Properties类（Java.util.Properties）继承Hashtable（Java.util.Hashtable）

##### 主要方法

- getProperty ( String key)：用指定的键在此属性列表中搜索属性。也就是通过参数 key ，得到 key 所对应的 value。
- load ( InputStream inStream)：从输入流中读取属性列表（键和值）。通过对指定的文件（比如test.properties 文件）进行装载来获取该文件中的所有键值对。以供 getProperty ( String key) 来搜索。
- setProperty ( String key, String value)：他通过调用父类的put方法来设置键值对。
- store ( OutputStream out, String comments)：将此 Properties 表中的属性列表（键和值）写入输出流。与 load 方法相反，该方法将键值对写入到指定的文件中去。
- clear ()：清除所有装载的键值对。该方法由父类中提供。
- Enumeration<?> propertyNames()：返回Properties中的key值。



中间无内容就用自闭合

```xml
<null></null>
<null/>
```

#### c命名和p命名空间注入

**p空间**

```xml
beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean name="john-classic" class="com.example.Person">
        <property name="name" value="John Doe"/>
        <property name="spouse" ref="jane"/>
    </bean>

    <bean name="john-modern"
        class="com.example.Person"
        p:name="John Doe"
        p:spouse-ref="jane"/>

    <bean name="jane" class="com.example.Person">
        <property name="name" value="Jane Doe"/>
    </bean>
</beans>
```

此示例不仅包括使用p-namespace的属性值，还使用特殊格式声明属性引用。第一个bean定义用于`<property name="spouse" ref="jane"/>`创建从bean `john`到bean 的引用 `jane`，而第二个bean定义`p:spouse-ref="jane"`用作属性来执行完全相同的操作。在这种情况下，`spouse`属性名称是，而该`-ref`部分表示这不是一个直接值，而是对另一个bean的引用。

p空间实际上等同于property



#### c-namespace 依赖注入

```xml
与具有p-namespace的XML Shortcut相似，在Spring 3.1中引入的c-namespace允许使用内联属性来配置构造函数参数，而不是嵌套constructor-arg元素。

以下示例使用c:名称空间执行与 基于构造函数的依赖注入相同的操作：

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:c="http://www.springframework.org/schema/c"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="beanTwo" class="x.y.ThingTwo"/>
    <bean id="beanThree" class="x.y.ThingThree"/>

    <!-- traditional declaration with optional argument names -->
    <bean id="beanOne" class="x.y.ThingOne">
        <constructor-arg name="thingTwo" ref="beanTwo"/>
        <constructor-arg name="thingThree" ref="beanThree"/>
        <constructor-arg name="email" value="something@somewhere.com"/>
    </bean>

    <!-- c-namespace declaration with argument names -->
    <bean id="beanOne" class="x.y.ThingOne" c:thingTwo-ref="beanTwo"
        c:thingThree-ref="beanThree" c:email="something@somewhere.com"/>

</beans>
```

注意:需要在xml中写依赖如

 `xmlns:c="http://www.springframework.org/schema/c"`

c-namespace类的有参构造

###　问题

解决idea application context not configured for this file的问题


spring配置文件中时常会出现这个提示，翻译过来大概意思就是没有配置该文件到项目中

于是进入到file-Project Structure中查看

可以很明显的看到下面有个感叹号，大概意思是下面的文件没有匹配

知道原因就很好解决问题了，只需要加到项目中去就可以了



### Bean的作用域

| Scope                                                        | Description                                                  |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [singleton](https://docs.spring.io/spring/docs/5.2.4.RELEASE/spring-framework-reference/core.html#beans-factory-scopes-singleton) | (Default) Scopes a single bean definition to a single object instance for each Spring IoC container. |
| [prototype](https://docs.spring.io/spring/docs/5.2.4.RELEASE/spring-framework-reference/core.html#beans-factory-scopes-prototype) | Scopes a single bean definition to any number of object instances. |
| [request](https://docs.spring.io/spring/docs/5.2.4.RELEASE/spring-framework-reference/core.html#beans-factory-scopes-request) | Scopes a single bean definition to the lifecycle of a single HTTP request. That is, each HTTP request has its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web-aware Spring `ApplicationContext`. |
| [session](https://docs.spring.io/spring/docs/5.2.4.RELEASE/spring-framework-reference/core.html#beans-factory-scopes-session) | Scopes a single bean definition to the lifecycle of an HTTP `Session`. Only valid in the context of a web-aware Spring `ApplicationContext`. |
| [application](https://docs.spring.io/spring/docs/5.2.4.RELEASE/spring-framework-reference/core.html#beans-factory-scopes-application) | Scopes a single bean definition to the lifecycle of a `ServletContext`. Only valid in the context of a web-aware Spring `ApplicationContext`. |
| [websocket](https://docs.spring.io/spring/docs/5.2.4.RELEASE/spring-framework-reference/web.html#websocket-stomp-websocket-scope) | Scopes a single bean definition to the lifecycle of a `WebSocket`. Only valid in the context of a web-aware Spring `ApplicationContext`. |

#### 1.singleton scope(单例模式)

默认模式

```xml
<bean id="UserOne" class="com.lyy.pojo1.UserOne" p:name="lyy" p:age="18" scope="singleton"/>
```

**2.prototype scope(原型模式)**

每次从容器中get时,都会产生一个新对象

```xml
<bean id="UserOne" class="com.lyy.pojo1.UserOne" p:name="lyy" p:age="18" scope="prototype"/>
```



### Bean的自动装配

在Spring中有三种装配的方式

在xml中配置

在java中配置

实现隐式的自动装配

##### byName自动装配

byName会自动在容器上下文中查找,和自己对象set方法中this的值对应的bean id,要保证id唯一

```xml
<bean id="cat" class="com.lyy.pojo1.Cat"/>
<bean id="dog" class="com.lyy.pojo1.Dog"/>
    <bean id="man" class="com.lyy.pojo1.Man" autowire="byName">
        <property name="name" value="lyy"/>
    </bean>
```



##### byType自动装配

byName会自动在容器上下文中查找,和自己对象属性类型相同的bean 

要去bean id的类型全局唯一,就是bean的class唯一

```xml
<class="com.lyy.pojo1.Cat"/>
<class="com.lyy.pojo1.Dog"/>
    <bean id="man" class="com.lyy.pojo1.Man" autowire="byType">
        <property name="name" value="lyy"/>
    </bean>
```



###　使用注解实现自动装配

要使用注解须知:

1.导入约束 context约束

2.配置注解的支持  <context:annotation-config/>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```

**@Autowired**

在属性名上使用

注解是不需要set方法的

加了`@Nullable`注解后即使为空也不会报错

`@Qualifier`

@Autowired配合@Qualifier(value="id名")能实现指定bean中id的自动装配，以防止冲突，通常在无法通过一个注解[@Autowired]完成的时候

**＠Resource**

java原生　类似@Autowired按照

＠Resource(value)

#### 小结

@Resource和@Autowired的区别

1.都是用来自动装配的,都可以放在属性字段上

2.@Autowired通过byType的方式来实现

3.@Resource默认通过byName的方式实现，如果找不到名字，则通过byType实现



### Spring注解开发

#### 1.bean

在Spring4之后,要使用注解开发,必须保证aop的包的导入

使用注解需要导入context约束,增加注解的支持

#### 2.属性如何注入

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```



```xml
<!--指定要扫描的包,这个包下的注释就会生效-->
<context:component-scan base:package="com.kuang.pojo"/>
```



#### 3.衍生的注解

```java
@Component
public class User {
    @Value("lyy")
    public String name;
}
```

//**@Value**还可以写在set方法上

**@Component**的衍生注解,我们在web开发中,会按照mvc三层架构分层

dao **@Repository**

service **@Service**

controller **@Controller**

功能　等价的

＠Scope("singleton")//在类名上,单例模式

＠Scope("prototype")//

#### ４.自动装配置



#### 5.作用域



#### 6.小结

注解一般用来实现属性的注入



### 使用JavaConfig实现配置



###　10 代理模式

代理模式的分类:

静态代理

动态代理

#### 10.1 静态代理

角色分析:

抽象角色:一般会使用接口或者抽象类来解决

真实角色:被代理的角色

代理角色:代理真实角色,代理真实角色后，会对其进行一些附属操作

客户:访问代理对象的人

**代码步骤:**

1.接口

2.真实角色

3.代理角色

4.客户端访问代理角色

代理模式的好处:

可以使真实角色的操作更加纯粹,不用去关注一些公共的业务

公共也就交给代理角色 实现了业务的分工

公共业务发生扩展的时候，方便集中管理

耦合性降低了

缺点:

一个真实角色就会产生一个代理角色,代码量会翻倍

#### 10.2　静态代理加深理解

不要改动原有的业务代码

#### 10.3动态代理

底层实现就是反射



### Spring复习

bean标签就相当于创建了一个对象(new Hello())

```xml
<bean id="UserServiceImpl" class="com.kuang.service.UserServiceImpl">
    <!--
        ref：引用Spring容器中已经创建好的对象
        value：具体的值，基本数据类型
        -->
    <property name="userDao" ref="mysqlImpl"></property>
</bean>
```

bean中id就是对象名 class就是对象类型

会利用实体类中的set方法去进行注入

配置成功在spring中会有提示



```xml
<constructor-arg index="0" value=""/>1.下标赋值

<constructor-arg type="java.lang.String" value="" />2.类型赋值。

<constructor-arg name="name" value="" />3.参数名赋值
```

在配置文件加载的时候，容器中管理的对象就已经初始化了

别名是给bean的id取的



各种类型的属性如何在bean中设置

```xml
    <!--p命名空间注入，可以直接注入属性的值：property-->
    <bean id="user" class="com.kuang.pojo.User" p:name="憨批" p:age="18"/>

    <!--c命名空间注入，通过构造器注入：construct-args-->
    <bean id="user2" class="com.kuang.pojo.User" c:age="18" c:name="憨批"/>
```

构造器注入和property区别？

注意点：p和c命名空间不能直接使用，需要导入xml约束！

```xml
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c"
```



bean的作用域

1.代理模式 scope=singleton  同一个对象

2.原型模式 scope=prototype 复制



注解(适用简单情况)

导入约束

配置注解的支持 `<context:annot-config/>`在beans.xml中 (注解驱动的支持)

@Autowired

```java
//如果显式定义了Autowired的required属性为false，说明这个对象可以为null，否则不允许为空
    @Autowired(required = false)
    private Dog dog;
    @Autowired
    private Cat cat;
```

通过扫描来指定要生效注解的包

```xl
<context:component-scan base-package="com.lyy.pojo"/>
```

@Component等价于

```xml
<bean id="user" class="com.lyy.pojo.User"/>
```

```
@Component
public class User{
	public String name ="lyy"；
}
```

```java
@Component
public class User{
    @Value("lyy")
    //类似 <property name="name" value="lyy"/>
	public String name；
}
```

在set方法上面@Value也能用



执行顺序不同：@Autowired通过byType的方式实现，@Resource默认通过byName的方式实现。

如果@Autowired自动装配的环境比较复杂，自动装配无法通过一个注解@Autowired完成的时候，我们可以使用@Qualifier(value="xxx")去配置@Autowired的使用，指定一个唯一的bean对象注入！

衍生的注解

@Component有几个衍生注解，我们在web开发中，会按照mvc三层架构分层！

- dao【@Repository】
- service【@Service】
- controller【@Controller】

这四个注解功能都是一样的，都是代表将某个类注册到Spring中，装配



@Scope 作用域

如@Scope(“singleton”)



### 10 代理模式

####  10.2 动态代理

分为两大类:基于接口的动态代理,基于类的动态代理

基于接口 JDK动态代理

需要了解的两个类Proxy 代理 InvocationHandler 调用处理程序

底层实现就是反射

Proxy用于生成动态代理实例

InvocationHandler 调用处理程序处理并且返回结果

好处:

一个动态代理类可以代理多个类，只要是实现了同一个接口即可

代理的是一个业务



## 11、 AOP

### 11.1 什么是AOP

AOP（Aspect Oriented Programming）意为：面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生泛型，利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的频率。

![image-20200106085441897](D:/software/javaStudy/Spring狂神说/image-20200106085441897.png)

### 11.2 AOP在Spring中的作用

==提供声明式事务；允许用户自定义切面==

- 横切关注点：跨越应用程序多个模块的方法或功能。即是，与我们业务逻辑无关的，但是我们需要关注的部分，就是横切关注点，如日志、安全、缓存、事务等等……
- 切面（ASPECT）：横切关注点被模块化的特殊对象，即是一个类。
- 通知（Advice）：切面必须要完成的工作，即是类中的一个方法。
- 目标（Target）：被通知对象。
- 代理（Proxy）：向目标对象应用通知之后创建的对象。
- 切入点（PointCut）：切面通知执行的“地点”的定义。
- 连接点（jointPoint）：与切入点匹配的执行点。

![image-20200106090325307](D:/software/javaStudy/Spring狂神说/image-20200106090325307.png)

SpringAOP中，通过Advice定义横切逻辑，Spring中支持5种类型的Advice：

![image-20200106090428369](D:/software/javaStudy/Spring狂神说/image-20200106090428369.png)

即AOP在不改变原有代码的情况下，去增加新的功能。

### 11.3 使用Spring实现AOP

【重点】使用AOP织入，需要导入一个依赖包。

```xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.5</version>
</dependency>
```

还需要导入aop的约束

代理基于接口

##### *execution*表达式



获得签名signature就是类的信息？

cglib代理基于类

## 12、 整合Mybatis

步骤：

1. 导入相关jar包
   - junit
   - Mybatis
   - mysql数据库
   - spring相关的
   - aop织入
   - mybatis-spring【new知识点】
2. 编写配置文件
3. 测试



好处，spring-dao.xml中内容固定，不用每次都写测试类中的内容

之所以要多一个实现类 就是因为Mybatis的对象spring不能自动创建

### 12.2 Mybatis-Spring

1. 编写数据源配置
2. sqlSessionFactory
3. sqlSessionTemplate
4. 需要给接口加实现类
5. 将自己写的实现类，注入到Spring中
6. 测试



sqlSessionTemplate是线程安全的，所以可以代替sqlSession



#### 实现的第二种方法





## Spring MVC

#### 回顾MVC架构

##### 什么是mvc

pojp类是Plain OrdinaryJava Object的缩写

可以当作简单的Java对象

实际就是普通JavaBeans

MVC是模型(Model),视图(View),控制器(Controller)的简写，是一种软件设计规范

vo也是实体类不过是细分了拆掉了一些不必要的东西

#### tomcat

https://www.cnblogs.com/Knowledge-has-no-limit/p/7240585.html

依赖里记得添加lib，否则可能会404

#### 复习servlet

先写个类继承servlet，再在web.xml中配置servlet

用户可见页面放在web下面,用户不可见放在web-inf下面



void getSession()方法相当于得到一个session对象，而void setAttribute()和String Attribute分别是对属性赋值和得到属性值的方法。



写完servlet记得去web.xml注册



POJO DO是data object的缩写 是数据对象的意思，一般和数据库中的表相对应

如果使用mybatis开发，则不需要注解修饰，只需要简单的Java对象就可以。

DAO 是data access object的缩写，是数据访问对象的意思

如果使用mybatis开发，一般放在mapper包中，同样是接口形式，接口使用@Select, @Update, @Insert, @Delete等注解修饰，在注解中手写SQL完成增删改查等常用操作。

DTO 是data transfe object的缩写，意思是数据传输对象，会放在dto包

用在service层，service层一般会调用dao中定义的方法获取DO对象

完成业务逻辑后，如果需要返回对象时，会把对象组合或者转化为DTO对象向外传输。转化过程一般使用spring提供的BeanUtils类的copyproperties方法把DO对象的属性复制到DTO对象里。

VO是view objexct的缩写，意思是视图对象，用于展示数据给用户，用在controller层，是controller向外传输的对象controller中一般会调用service层中类的方法获取DTO对象，然后转化为VO对象返回给调用端。



Java视图 就是将集合类对象中的数据重新映射到一个数据集合中



通过调度来管理多个servlet，转发,处理请求



##### 错误

Intellij idea 报错：Error : java 不支持发行版本5

maven报错：不再支持源选项 5。请使用 6 或更高版本。

tomcat中文乱码

6、在 tomcat / conf 目录下，设置 logging.properties ，增加参数  java.util.logging.ConsoleHandler.encoding = GBK，重启后终于可以了，总算松了口气。

https://www.cnblogs.com/shej123/p/10312806.html

project structure中的artifact中在web-inf中添加lib并且导入所有包来解决404

新问题:注意复制文档的内容可能会遗漏-，要注意复制问题

### springmvc原理

组件扫描完成后开始执行bean的实例化



一般会去配一个站点 在Tomcat里



真正只需要去做Spring mvc中的调用业务和如何进行视图解析就是路径如何拼接

第一步:确定有依赖maven和artifacts的WEB-INF中的lib

web.xml配置dispatcherservlet

springmvc-servlet.xml配置mappinghandler和视图解析器

上面两个基本不改动

然后在controller里写controller



model和modelViewer的区别



改了配置文件就得重新发布tomcat,改了前端则无所谓





#### requestMapping

一般只会在方法名上写



#### RestFul 风格

RestFul风格就是一个资源定位及资源操作的风格。基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存等机制

**传统方式操作资源**：通过不同的参数来实现不同的效果

**使用Restful操作资源:**

可以通过不同的请求方式来实现不同的资源

如

```java
//    http://localhost:8080/springmvc03_war_exploded/add1/2/3
    @RequestMapping("/add1/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable int b, Model model){
        int result=a+b;
        model.addAttribute("msg","结果是"+result);
        return "hello";
    }
```

类型不对则会报400错误



**使用method属性指定请求类型**

用于约束请求的类型，可以收窄请求范围。指定请求谓词的类型如GET, POST, HEAD, OPTIONS, PUT,PATCH, DELETE, TRACE等 

`@RequestMapping(value = "/add1/{a}/{b}",method = RequestMethod.GET)`

不写的话默认是get

@GetMapping是一个组合注释相当于

```java
@RequestMapping(method = RequestMethod.GET)
```



#### 重定向和转发

视图解析器的目的是为了实现跳转，实际上也可以通过HttpServletRequest去实现

使用springmvc去写则要去写全限定名（相对于web文件夹）

加了视图解析器的情况下默认是转发

需要重定向则写return "redirect:/index.jsp";即可（写了拼接就会拼接）



#### 数据处理

提交的域名称域处理方法的参数名不一致

提交数据 : http://localhost:8080/hello?username=lyy

```java
RequestMapping("/hello")
public String hello(@RequestParam("username") String name){
System.out.println(name);
return "hello";
}
```

##### 提交的是一个对象

要求提交的表单域和对象的属性名一致，参数使用对象即可

1. 实体类

   ```java
   public class User {
   private int id;
   private String name;
   private int age;
   //构造
   //get/set
   //tostring()
   }
   ```

   

2. 提交数据 : http://localhost:8080/mvc04/user?name=kuangshen&id=1&age=15

3. 处理方法  

```java
public String user(User user){
    System.out.println(user);
    return "hello";
}
```

后台输出 : User { id=1, name='kuangshen', age=15 } 

说明：如果使用对象的话，前端传递的参数名和对象名必须一致，否则就是nu l；？



##### 数据显示到前端

第一种:通过ModelAndView

第二种:通过ModelMap

Modelmap model

model.addAttribute("name",name);

第三种：通过Model



和第二种区别？

```
Model 只有寥寥几个方法只适合用于储存数据，简化了新手对于Model对象的操作和理解；
ModelMap 继承了 LinkedMap ，除了实现了自身的一些方法，同样的继承 LinkedMap 的方法和特性

```



##### 乱码问题

以前乱码问题通过过滤器解决 , 而SpringMVC给我们提供了一个过滤器 , 可以在web.xml中配置 .
修改了xml文件需要重启服务器 

```xml
<filter>
<filter-name>encoding</filter-name>
<filterclass>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
<init-param>
<param-name>encoding</param-name>
<param-value>utf-8</param-value>
</init-param>
</filter>
<filter-mapping>
<filter-name>encoding</filter-name>
<url-pattern>/*</url-pattern>
</filter-mapping>
```

但是我们发现 , 有些极端情况下.这个过滤器对get的支持不好 .
处理方法 :

修改tomcat配置文件 ： 设置编码！ 

```xml
<Connector URIEncoding="utf-8" port="8080" protocol="HTTP/1.1"
connectionTimeout="20000"
redirectPort="8443" />

```



### Json

//produces:指定响应体返回类型和编码
@RequestMapping(value = "/json1",produces =
"application/json;charset=utf-8") 

解决乱码问题

上一种方法比较麻烦，如果项目中有许多请求则每一个都要添加，可以通过Spring配置统一指定，这样
就不用每次都去处理了！
我们可以在springmvc的配置文件上添加一段消息StringHttpMessageConverter转换配置！ 

加在springmvc-servlet.xml

```xml
    <mvc:annotation-driven>
        <mvc:message-converters register-defaults="true">
            <bean
                    class="org.springframework.http.converter.StringHttpMessageConverter">
                <constructor-arg value="UTF-8"/>
            </bean>
            <bean
                    class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                <property name="objectMapper">
                    <bean
                            class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                        <property name="failOnEmptyBeans" value="false"/>
                    </bean>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
```



#### 输出时间对象

```java
@RequestMapping("/json3")
public String json3() throws JsonProcessingException {
ObjectMapper mapper = new ObjectMapper();
//创建时间一个对象，java.util.Date
Date date = new Date();
//将我们的对象解析成为json格式
String str = mapper.writeValueAsString(date);
return str;
}
```

默认日期格式会变成一个数字，是1970年1月1日到当前日期的毫秒数！
Jackson 默认是会把时间转成timestamps形式 



```java
@RequestMapping("/json4")
public String json4() throws JsonProcessingException {
ObjectMapper mapper = new ObjectMapper();
//不使用时间戳的方式
mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//自定义日期格式对象
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//指定日期格式
mapper.setDateFormat(sdf);
Date date = new Date();
String str = mapper.writeValueAsString(date);
return str;
}
```



#### 返回json字符串统一解决

在类上直接使用@RestController,这样，里面所有的方法都只会返回json字符串了



### ssm整合学习

#### 1.整合mybatis

comment 可添加字段和数据库的注释	

查看已有表的所有字段的注释呢？

show full columns from test

```xml
像刚才的 JavaBean，User 是放在 cn.com.mybatis.pojo 包里的，包里可能也会存在其他多个 JavaBean，这时候一个一个配置别名就会很麻烦，这时候就需要批量定义别名，批量指定很简单，只要指定包名即可，之后程序会为包下的所有类都自动加上别名，其定义别名的规范就是对应包装类的类名首字母变为小写，其示例代码如下：

<typeAliases>
    <package name="cn.com.mybatis.pojo"/>
</typeAliases>
```

pojo中的类的属性的名和mysql中字段一致可智能提醒

步骤:



pojo实体类

BookMapper.class是写接口类

BookMapper.xml是写实现类？

@Select代替简单的xml中sql语句？

然后绑定到mybatis-config.xml中

service层去调用dao层，就是实现aop，组合dao层

在service层注入mapper

@Param作用 在方法参数的前面写上@Param("参数名")表示给参数命名，名称就是括号中的内容



public Student select(@Param("aaaa") String name,@Param("bbbb")int class_id);

　　给入参 String name 命名为aaaa，然后sql语句....where  s_name= #{aaaa} 中就可以根据aaaa得到参数值了。

```xml
public List<student> selectuser(@Param(value = "page")int pn ,@Param(value = "st")student student);

<select id="selectuser" resultType="com.user.entity.student">
    SELECT * FROM student
    where sname like concat(concat("%",#{st.sname}),"%")
    LIMIT #{page} ,5
</select>
```

注意#{}中的名和对象中属性名一致就可以不用写st.sname，而是写sname即可



@Autowired

就是自动装配，其作用是代替Java代码里面的getter/setter与bean属性中的property.

@Autowired(required=false)



@Qualifier用法

@Autowired就是写在属性上实现getterh和setter

在Controller中需要注入service那么我的这个server有两个实现类要如何区分？

下面上铺垫图

![一个业务接口](https://img-blog.csdn.net/20180607160315730?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NTY3MDA1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

请忽略我的红线
![第一个实现类](https://img-blog.csdn.net/20180607160405182?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NTY3MDA1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![第二个实现类](https://img-blog.csdn.net/20180607160421650?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NTY3MDA1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

\##在Controller中使用 @Autowired注入时

![autowired注入资源](https://img-blog.csdn.net/20180607160709653?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NTY3MDA1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
**Qualifier的意思是合格者，通过这个标示，表明了哪个实现类才是我们所需要的，添加@Qualifier注解，需要注意的是@Qualifier的参数名称为我们之前定义@Service注解的名称之一。**

#### 2.整合spring层

使用@Resource注入时

![@resource注入](https://img-blog.csdn.net/20180607161307722?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NTY3MDA1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
使用@resource注入时比较简单了注解自带了“name”的val就是@Service注解的名称之一。



##### 流程思考：

return可以把model带过来？

业务层都是在前端页面发数据后才处理？

重定向toAddBook就是调到toAddBook对应的业务层

该业务层return "addBook"就经过解析器解析跳转到addBook.jsp

```html
    <form action="${pageContext.request.contextPath}/book/addBook"
          method="post">
```

然后通过响应再调用业务层addBook处理，最后redirect:/book/allBooks返回adllBooks页面





## SpringBoot

还是得先学springmvc

核心：自动装配原理

约定大于配置

微服务间可以通过http或rpc来进行通信

/ 只匹配所有的请求，不会去匹配jsp页面

/* 匹配所有的请求，包括jsp页面



可以写多个controller从而复用网页资源，只用改动参数

#### 第一个SpringBoot

问题1：要挂梯子，不然创建会网络超时

问题2：最好别用最新的springboot，否则阿里云源没有

只会扫描主程序入口同级的包



@RestController

　json字符串：如果某个类设计初衷就是返回json字符串，那么该类就可以使用`@Controller + @ResponseBody`，还可以使`@RestCotroller`简化书写

　从上面的源码中可以清晰的看到`@RestController = @Controller + @ResponseBody`

pom.xml中配置

springboot的其他组件可以不写版本号，因为会继承父依赖



#### springboot自动装配

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

spring-boot-starter-xxx就是spring-boot的场景启动器

如spring-boot-starter-web 帮我们导入了web模块正常运行所依赖的组件

所有的自动配置类都在META-INF/spring.factories：所有的自动配置类都在这里了

问题:这么多自动配置为什么有一些没有生效，需要导入对应的start才有用

核心注解@ConditionalOnXXX:如果这个里面的条件都满足，才会生效

![1585569935004](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1585569935004.png)

![1585570275578](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1585570275578.png)

#### run方法执行分析

SpringApplication类作用

1.推断应用的类型是普通的项目还是Web项目（普通项目运行完直接结束，二Web项目不是）

2.查找并加载所有可用初始化器，设置到Initializers属性中

3.找出所有的应用程序监听器，设置到listeners属性中

4.推断并设置main方法的定义类，找到运行的主类

![img](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7L1vFQMnaRIJSmeZ58T2eZicjafiawQLp9u8wc4ic1Mjy6OyfibzfjVofeL5pnS1NSFKVjlIg6neI9ySg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

关于SpringBoot，谈谈你的理解

1.自动装配 

2.run方法



#### yaml语法

https://mp.weixin.qq.com/s?__biz=Mzg2NTAzMTExNg==&mid=2247483744&idx=1&sn=b4ec762e71b2ddf9403c035635299206&scene=19#wechat_redirect

基础语法：

空格不能省略（即k: v）中间有空格

以缩进来控制层级关系，只要是左边对齐的一列数据都是同一个层级的

属性和值的大小写都是敏感的

```yaml
#普通的key-value
name: qinjiang
#对象
student:
	name: qinjiang
	age: 3
#行内写法
student: {name:qinjiang,age:3}

#数组
pets:
 - cat
 - dog
 - pig
 
 pets: [cat,dog,pig]
```



yaml可以直接给实体类赋值

在属性上写@Value("旺财")

private String name;

https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/html/configuration-metadata.html#configuration-metadata-annotation-processor

可查看@ConfigurationProperties

在application.yaml里写对象赋值

然后在实体类上写@ConfigurationProperties(prefix = "person")

记得还要些@Component

然后在测试类的属性上写@Autowired即可完成赋值

mybatis的配置也可以用yaml来配置



#### 加载指定的配置文件

**@PropertySource ：**加载指定的配置文件；

**@configurationProperties**：默认从全局配置文件中获取值；

1、我们去在resources目录下新建一个**person.properties**文件

```
name=kuangshen
```

2、然后在我们的代码中指定加载person.properties文件



```java
@PropertySource(value = "classpath:person.properties")
@Component //注册bean
public class Person {

    @Value("${name}")
    private String name;

    ......  
}
```

3、再次输出测试一下：指定配置文件绑定成功！

##### 配置文件占位符

配置文件还可以编写占位符生成随机数

```yaml

person:
    name: qinjiang${random.uuid} # 随机uuid
    age: ${random.int}  # 随机int
    happy: false
    birth: 2000/01/01
    maps: {k1: v1,k2: v2}
    lists:
      - code
      - girl
      - music
    dog:
      name: ${person.hello:other}_旺财
      age: 1
```

还可以这样写@Value

```java

@Component //注册bean
@PropertySource(value = "classpath:user.properties")
public class User {
    //直接使用@value
    @Value("${user1.name}") //从配置文件中取值
    private String name;
    @Value("#{9*2}")  // #{SPEL} Spring表达式
    private int age;
    @Value("男")  // 字面量
    private String sex;
}
```

##### 对比小结

![img](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtjyIb9NEaYlz0tCWSiboOYjMibiaov73iaTsiaWEPoArDcAB1Ooibx9uR5JxtacIuicHblEtUI9SrySX2A/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

1、@ConfigurationProperties只需要写一次即可 ， @Value则需要每个字段都添加

2、松散绑定：这个什么意思呢? 比如我的yml中写的last-name，这个和lastName是一样的， - 后面跟着的字母默认是大写的。这就是松散绑定。可以测试一下

即在yaml中last-name和class中lastName是一样的

3、JSR303数据校验 ， 这个就是我们可以在字段是增加一层过滤器验证 ， 可以保证数据的合法性

4、复杂类型封装，yml中可以封装对象 ， 使用value就不支持



只需要一个值一般用@Value，其他情况用@ConfigurationProperties多



#### JSR303校验

Springboot中可以用@validated来校验数据，如果数据异常则会统一抛出异常，方便异常中心统一处理。我们这里来写个注解让我们的name只能支持Email格式；

```java

@Component //注册bean
@ConfigurationProperties(prefix = "person")
@Validated  //数据校验
public class Person {

    @Email(message="邮箱格式错误") //name必须是邮箱格式
    private String name;
}
```

运行结果 ：default message [不是一个合法的电子邮件地址];

![img](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7IPEXZtUAUBhnSZvUmrPzbDYdR5f05BDysj0YVJMxadN0psDJKzXe7zyTrL9wFpTEHoiba0MsM11Fw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

**使用数据校验，可以保证数据的正确性；**

```java

@NotNull(message="名字不能为空")
private String userName;
@Max(value=120,message="年龄最大不能查过120")
private int age;
@Email(message="邮箱格式错误")
private String email;

空检查
@Null       验证对象是否为null
@NotNull    验证对象是否不为null, 无法查检长度为0的字符串
@NotBlank   检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
@NotEmpty   检查约束元素是否为NULL或者是EMPTY.
    
Booelan检查
@AssertTrue     验证 Boolean 对象是否为 true  
@AssertFalse    验证 Boolean 对象是否为 false  
    
长度检查
@Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内  
@Length(min=, max=) string is between min and max included.

日期检查
@Past       验证 Date 和 Calendar 对象是否在当前时间之前  
@Future     验证 Date 和 Calendar 对象是否在当前时间之后  
@Pattern    验证 String 对象是否符合正则表达式的规则

.......等等
除此以外，我们还可以自定义一些数据校验规则
```

#### 多环境切换

![1585586380098](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1585586380098.png)

classpath指java或者resources

这个顺序就是优先级顺序

**SpringBoot会从这四个位置全部加载主配置文件；互补配置；**

**例如：**

application-test.properties 代表测试环境配置

application-dev.properties 代表开发环境配置

但是Springboot并不会直接启动这些配置文件，它**默认使用application.properties主配置文件**；

我们需要通过一个配置来选择需要激活的环境：

```properties
#application.properties中写
spring.profiles.active = dev
#即可切换到application-dev.properties这个配置
```

和properties配置文件中一样，但是使用yml去实现不需要创建多个配置文件

```yaml
server:
  port: 8081
#选择要激活那个环境块
spring:
  profiles:
    active: prod

---
server:
  port: 8083
spring:
  profiles: dev #配置环境的名称


---

server:
  port: 8084
spring:
  profiles: prod  #配置环境的名称
```

分割线分割多个环境？



#### 自动配置原理再理解

**我们可以通过启用 debug=true属性；来让控制台打印自动配置报告，这样我们就可以很方便的知道哪些自动配置类生效；**



```properties
#开启springboot的调试类
debug=true
```

**Positive matches:（自动配置类启用的：正匹配）**

**Negative matches:（没有启动，没有匹配成功的自动配置类：负匹配）**

**Unconditional classes: （没有条件的类）**

![image-20200331111805842](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200331111805842.png)

### SpringBoot Web开发