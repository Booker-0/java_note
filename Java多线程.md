# Java多线程

```sh
ps -ef | grep "SimpleJavaApp" | grep -v "grep"
ps //Process Status的缩写
top //动态显示进程信息
pstree 以树结构显示进程
命令参数：
a  显示所有进程
-a 显示同一终端下的所有程序
-A 显示所有进程
c  显示进程的真实名称
-N 反向选择
-e 等于“-A”
e  显示环境变量
f  显示程序间的关系
-H 显示树状结构
r  显示当前终端的进程
T  显示当前终端的所有程序
u  指定用户的所有进程
-au 显示较详细的资讯
-aux 显示所有包含其他使用者的行程 
-C<命令> 列出指定命令的状况
--lines<行数> 每页显示的行数
--width<字符数> 每页显示的字符数
--help 显示帮助信息
--version 显示版本显示
grep//是查找匹配行 -v 则是除该结果外
```

查看该Java程序



进程是程序向操作系统申请资源的基本单位

线程是进程中可独立执行的最小单位

任务　线程所要完成的计算

### 1.2 多线程编程简介



### 1.3 Java线程API简介

运行一个线程实际上就是让java虚拟机执行该线程的run方法,从而使相应线程的任务处理逻辑得以执行

start方法的作用就是启动相应的线程

启动一个线程的实质是请求Java虚拟机运行相应的线程,而这个线程具体何时能够运行是由线程调度器决定的．

Java中创建线程方式 两种

构造器Thread() 定义Thread类的子类，在该子类中覆盖run方法并在方法中实现线程任务处理逻辑

构造器Thread(Runnable target)

? 创建一个java.lang.Runnable接口的实例，并在该实例的run方法中实现任务处理逻辑,然后以该Runnable接口实例作为构造器的参数直接创建一个Thread类的实例

基于组合的技术?

Thread.currentThread表示当前代码段正在被哪个线程调用的相关信息



start方法也只能够被调用一次

Java虚拟机会为每个线程分配调用栈所需的内存空间．调用栈用于跟踪Java代码间的调用关系以及Java代码对本地代码的调用

执行线程 这个线程就相应地被称为这段代码

当前线程 任意一段代码都可以通过调用Thread.currentThread()来获取这段代码的执行线程

### 1.3.2 Runnable接口

Thread类所实现的任务处理逻辑是要么什么也不做要么直接执行target所引用的Runnable是咧所实现的任务处理逻辑

![1583039577405](/home/lyy/.config/Typora/typora-user-images/1583039577405.png)



### 1.3.3 线程属性

线程的属性包括线程的编号(ID),名称(Name),线程类别(Daemon)和优先级(Priority)



![1583040098435](/home/lyy/.config/Typora/typora-user-images/1583040098435.png)![1583040098559](/home/lyy/.config/Typora/typora-user-images/1583040098559.png)

除了编号其他属性都是可读写的属性,提供了相应的get和set方法



#### 守护线程和用户线程

用户线程会阻止Java虚拟机的正常停止,即一个Java虚拟机只有在其所有用户线程都运行结束的情况才能正常停止.而守护线程不会影响Java虚拟机的正常停止，所有通常用于执行一些重要性不少很高的任务.



### 1.5　线程的层次关系

一个线程是否是一个守护线程默认取决于其父线程：默认情况下父线程是守护线程，则子线程也是守护线程;父线程和子线程之间的生命周期也没有必然的联系.比如父线程运行结束后,子线程可以继续运行

Worker Thread



### 1.6 线程的生命周期状态

![1583087331446](/home/lyy/.config/Typora/typora-user-images/1583087331446.png)

![1583087470660](/home/lyy/.config/Typora/typora-user-images/1583087470660.png)



### 1.7 线程的监视

对线程进行监视的主要途径是获取并查看程序的线程转储.

![1583089492180](/home/lyy/.config/Typora/typora-user-images/1583089492180.png)



# Java多线程 基于kuangshen视频

![1584958217688](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584958217688.png)



#### 实现Runnable接口

![1584965624367](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584965624367.png)

```java
public class ThreadTest02 implements Runnable{
    @Override
    public void run(){
        for (int i=0;i<20;i++){
            System.out.println("*run:"+i);
        }
    }
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        ThreadTest02 t1 = new ThreadTest02();
        //创建线程对象，通过线程对象来开启我们的线程
        Thread thread = new Thread(t1);
        thread.start();
        for (int i=0;i<1000;i++){
            System.out.println("main:"+i);
        }
    }
}
```

通过接口可以实现多个线程只用到一个对象做参数？



#### 实现Callable接口

![1584968237987](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584968237987.png)

```java
package com.lyy.demo01;import org.apache.commons.io.FileUtils;import java.io.File;import java.io.IOException;import java.net.URL;import java.util.concurrent.*;//线程可以返回值，可以抛出异常public class 

TestThread01_1 implements Callable<Boolean> {    private String url;    private String name;    public TestThread01_1(String name, String url) {        this.name = name;        this.url = url;    }    @Override    public Boolean call(){        WebDowanloader webDowanloader = new WebDowanloader();        webDowanloader.downloader(url,name);        System.out.println("下载的文件名为:"+name);        return true;    }    public static void main(String[] args) throws ExecutionException, InterruptedException {        TestThread01_1 t1 = new TestThread01_1("1.jpg", "http://pic3.zhimg.com/v2-f271c95882a85a77d5c9cbe3743bb16a_1200x500.jpg");        TestThread01_1 t2 = new TestThread01_1("2.jpg", "http://pic3.zhimg.com/v2-f271c95882a85a77d5c9cbe3743bb16a_1200x500.jpg");        TestThread01_1 t3 = new TestThread01_1("3.jpg", "http://pic3.zhimg.com/v2-f271c95882a85a77d5c9cbe3743bb16a_1200x500.jpg");//创建执行服务        ExecutorService ser= Executors.newFixedThreadPool(3);//通过服务提交执行  
Future<Boolean> result1 = (Future<Boolean>) ser.submit(t1);        Future<Boolean> result2 = (Future<Boolean>) ser.submit(t2);        Future<Boolean> result3 = (Future<Boolean>) ser.submit(t3);        //获取call方法运行完的返回值结果        
boolean r1 = result1.get();        boolean r2 = result2.get();        boolean r3 = result3.get();        //关闭服务       
ser.shutdownNow();    }    class WebDowanloader{        public void downloader(String url,String name){            try {                FileUtils.copyURLToFile(new URL(url),new File(name));            } catch (IOException e) {                e.printStackTrace();                System.out.println("IO exception，downloader method error");            }        }}}
```



#### 静态代理模式

静态代理模式总结:真实对象和代理对象都要实现同一个接口

代理对象要代理真实角色



new Thread().start()；就是实现的代理模式



### 线程的状态

![1584970514242](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584970514242.png)

![1584970579589](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584970579589.png)

![1584970723620](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584970723620.png)

#### 线程停止



![1584970854141](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584970854141.png)





false后run()中内容就直接跳到结尾了

1.建议线程正常停止---->利用次数，不建议死循环

2.建议使用标志位---->设置一个标志位

```java
package com.lyy.state;

public class TestStop implements Runnable{
 int i=0;
    //设置一个标志位
    private boolean flag=true;
    public void run(){
    int i=0;
    while (flag){
        System.out.println("run Thread"+i++);
    }
    }
//2.设置一个公开的方法停止线程,转换标志位
public void stop(){
        this.flag = false;
}

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if (i == 800) {
                testStop.stop();
                System.out.println("thread stop");
            }
        }
        }
    }


```



#### 线程休眠

多用于模拟网络延时和实现倒计时

![1584972587514](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584972587514.png)

```
Date startTime = new Date(System.currentTimeMillis());
new SimpleDateFormat(“HH:mm:ss”).format(startTime);
```

```java
package com.lyy.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep {
    public static void main(String[] args) {
        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

```



#### 线程礼让yield

![1584974329494](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584974329494.png)

![1584974636161](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584974636161.png)



#### join 线程强制执行

![1584974773412](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584974773412.png)

![1584975883856](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584975883856.png)



#### 观测线程状态

![1584976081626](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584976081626.png)

记得更新while循环中的变量

![1584977085777](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584977085777.png)

线程处于TERMINATED状态后就不能再次start();了

![1584977313282](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584977313282.png)



#### 守护线程

#### 线程同步

![1584978074849](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584978074849.png)



建议

必看书《Java并发编程实战》，良心之作，薄薄的一本。阅读容易，比《java编程思想》这样好读太多，一句废话都没有！

volatile语义

CAS的工作原理和思想

readwritelock的实现（最后都是AQS）

Threadlocal，工作中非常有用的东西

ReentrantLock和Condition的使用，强烈推荐阅读 ArrayBlockingQueue 源码，非常好读。

线程之间等待的，countdownlatch,CyclicBarrier，Semaphore，这些面试老问，实际上用的到不多，一般用线程池就可以实现等待所有完成。

JUC包里面的类都建议看一看。重点看看CoucurrentHashmap，用和问的都比较多，而且改动也大。

线程池的使用，上面这些你学习了之后，你会发现使用是很简单的东西。