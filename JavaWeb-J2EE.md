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