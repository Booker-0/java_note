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