# MySql

## 1.了解数据库

#### 1.1.1　什么是数据库

**数据库** 保存有组织的数据的容器(通常是一个文件或一组文件)

**表**某种特定类型数据的结构化清单

**表名**　在相同数据库中不能两次使用相同的表名

**模式** 关于数据库和表的布局及特性的信息

**列** 表由列组成.表中的一个字段

**数据类型**　数据库中每个列都有相应的数据类型,所容许的数据的类型

**行**　表中的数据是按行存储的 又可以称为数据库记录

**主键** 一列,或一组列，其值能够唯一区分表中每个行

应该保证有一个主键

##### 表中的任何列都可以作为主键:

1.任意两行都不具有相同的主键值

2.每个行都必须具有一个主键值

##### 主键的最好习惯
 除MySQL强制实施的规则外,应该坚持的
几个普遍认可的最好习惯为:
1.不更新主键列中的值;
2.不重用主键列的值;
3.不在主键列中使用可能会更改的值。(例如,如果使用一个
名字作为主键以标识某个供应商,当该供应商合并和更改其
名字时,必须更改这个主键。)

## 2.MySQL

查了半天资料，终于了解到MariaDB代替了mysql数据库

因此用上述命令启动不起来，正确的方法如下

```shell
yum install mariadb -y //如果已安装可以省略

systemctl start mariadb.service //启动服务

systemctl enable mariadb.service //开机启动服务

mysql -u root -p //登录mysql


```

**mysql -u root -p的解释**

-u user -p password

连接数据库

```sql
mysql -uroot -p123456 --连接数据库

```

--是单行注释

;是语句结尾

```sql
show databases;
use 数据库名;--切换数据库
show tables;--查看所有的表
describe 表名l;--查看表
create database lyy;--创建数据库lyy
exit;--退出连接
```

数据库 xxx 语言 CRUD增删改查

DDL 定义

DML 操作

DQL 查询

DCL 控制

### 操作数据库

mysql关键字不区分大小写

创建数据库

```sql
CREATE DATABASE [IF NOT EXISTS] LYY
```

删除数据库

```sql
drop DATABASE IF EXISTS test
```

## 第4章 检索数据

#### 4.2 SELECT语句

```sql
 SELECT prod_name FROM products
```

上述语句利用 SELECT语句从 products表中检索一个名为prod_name的列 

许多SQL开发人员喜欢对所有SQL关键字使用大写，而对所有
列和表名使用小写 

#### 4.3 检索多个列

要想从一个表中检索多个列，使用相同的SELECT语句。唯一的不同
是必须在SELECT关键字后给出多个列名，列名之间必须以逗号分隔 

#### 4.4 检索所有列 

这可以通过在实际列名的位置使
用星号（*）通配符来达到，如下所示： 

#### 4.5 检索不同的行 

解决办法是使用DISTINCT关键字，顾名思义，此关键字指示MySQL
只返回不同的值 

```sql
select distinct vend_id
from products;
```

**不能部分使用DISTINCT** DISTINCT关键字应用于所有列而
不仅是前置它的列。如果给出SELECT DISTINCT vend_id,
prod_price，除非指定的两个列都不同，否则所有行都将被
检索出来 



#### 4.6 限制结果 

为了返回第一行或前几行，可使用LIMIT子句。 

```sql
select vend_id
from products
limit 1;
```

LIMIT 5, 5指示MySQL返回从行5开始的5行。第一个数为开始
位置，第二个数为要检索的行数。 

检索出来的第一行为行0而不是行1。因此， LIMIT 1, 1
将检索出第二行而不是第一行 

为得出下一个5行，可指定要检索的开始行和行数 

```sql
select prod_name
from products
limit 6,6;
```

所以， 带一个值的LIMIT总是从第一行开始，给出的数为返回的行数。
带两个值的LIMIT可以指定从行号为第一个值的位置开始。 

LIMIT 3, 4的含义是从行4开始的3
行还是从行3开始的4行？如前所述，它的意思是从行3开始的4
行，这容易把人搞糊涂。
由于这个原因， MySQL 5支持LIMIT的另一种替代语法。 LIMIT
4 OFFSET 3意为从行3开始取4行，就像LIMIT 3, 4一样。 

###4.7 使用完全限定的表名 

```sql
select products.prod_name
from sqllearn.products
```



## 第5章 排序检索数据

默认是升序排序

####  5.1 排序数据 

关系数据库设计理论认为，如果不明确规定排序顺序，则不应该假定检索出的数据的顺序有意义 

为了明确地排序用SELECT语句检索出的数据，可使用ORDER BY子句。
ORDER BY子句取一个或多个列的名字，据此对输出进行排序。请看下面
的例子 

```sql
select prod_name
from products
order by prod_name;
```

#### 5.2 按多个列排序 

```sql
select prod_id,prod_price,prod_name
from products
order by prod_price,prod_name
```

重要的是理解在按多个列排序时，排序完全按所规定的顺序进行 

#### 5.3 指定排序方向 

为了进行降序排序，必须指定DESC关键字。 

```sql
select prod_id,prod_price,prod_name
from products
order by prod_price ,prod_name DESC
```

DESC关键字只应用到直接位于其前面的列名 

与DESC相反的关键字是ASC（ASCENDING），在升序排序时可以指定它 

在字典（ dictionary）排序顺序中，A被视为与a相同，这是MySQL
（和大多数数据库管理系统）的默认行为。 

使用ORDER BY和LIMIT的组合，能够找出一个列中最高或最低的值。 

## 第6章 过滤数据 

####6.1 使用WHERE子句 

在SELECT语句中，数据根据WHERE子句中指定的搜索条件进行过滤。
WHERE子句在表名（FROM子句）之后给出，如下所示： 

```sql
select prod_name,prod_price
from products
where prod_price=2.50;
```

#### 6.2 WHERE子句操作符 

**表6-1 WHERE子句操作符**
操 作 符 说 明

```
= 等于
<> 不等于
!= 不等于
< 小于
<= 小于等于

> 大于
>= 大于等于
BETWEEN 在指定的两个值之间 


```

##### 6.2.2 不匹配检查 

```
select prod_name,vend_id,prod_price
from products
where vend_id <> 1001;
```

##### 6.2.3 范围值检查 

```
select prod_name,vend_id,prod_price
from products
where prod_price between 5 and 10
order by prod_price;
```

##### 6.2.4 空值检查 

```
select prod_name,vend_id,prod_price
from products
where prod_price is NULL;
```

由于表中没有这样的行，所以没有返回数据 



## 第7章 数据过滤

#### 7.1 组合WHERE子句 

为了进行更强的过滤控制， MySQL允许给出多个WHERE子句。这些子
句可以两种方式使用：以AND子句的方式或OR子句的方式使用。 

##### 7.1.1 AND操作符 



```
select prod_name,vend_id,prod_price
from products
where prod_price <=10 AND vend_id=1003;
```

##### 7.1.2 OR操作符 

**7.1.3 计算次序** 

原因在于计算的次序。 SQL（像多数语言一样）在处理OR操作符前，优先处理AND操作符。 

此问题的解决方法是使用圆括号明确地分组相应的操作符 

```
select prod_name,vend_id,prod_price
from products
where (vend_id=1002 or vend_id=1003) and prod_price>=10;
```

#### 7.2 IN操作符 

```
select prod_name,vend_id,prod_price
from products
where vend_id in (1002,1003);
```

#### 7.3 NOT操作符 

select prod_name,vend_id,prod_price
from products
where vend_id not in (1002,1003);



##第8章 用通配符进行过滤 

#### 8.1 LIKE操作符 

**通配符（wildcard）** 用来匹配值的一部分的特殊字符 

**搜索模式（search pattern）**① 由字面值、通配符或两者组合构
成的搜索条件 

为在搜索子句中使用通配符，必须使用LIKE操作符。 LIKE指示MySQL，
后跟的搜索模式利用通配符匹配而不是直接相等匹配进行比较 

##### 8.1.1 百分号（%）通配符 

```
select prod_name,vend_id,prod_price
from products
where prod_name like 'jet%';
```

在搜索串中， %表示任何字符出现任意次数。 

根据MySQL的配置方式，搜索可以是区分大小写的 

通配符可在搜索模式中任意位置使用，并且可以使用多个通配符。 

通配符也可以出现在搜索模式的中间，虽然这样做不太有用。下面
的例子找出以s起头以e结尾的所有产品 

```
select prod_name,vend_id,prod_price
from products
where prod_name like 's%e';
```

'%'也不能匹配用值NULL作为产品名的行 

##### 8.1.2 下划线（_）通配符 

另一个有用的通配符是下划线（_）。下划线的用途与%一样，但下划
线只匹配单个字符而不是多个字符。 

```
select prod_name,vend_id,prod_price
from products
where prod_name like '_ ton anvil';
```

就是'_ ton' select不到

把通配符置于搜索模式的开始处，搜索起来是最慢的。 

##第9章 用正则表达式进行搜索 

#### 9.1 正则表达式介绍 

#### 9.2 使用MySQL正则表达式 

##### 9.2.1 基本字符匹配 

```
select prod_name,vend_id,prod_price
from products
where prod_name regexp '1000';
```

```
select prod_name,vend_id,prod_price
from products
where prod_name regexp '.000';
```

MySQL中的正则表达式匹配（自版本3.23.4后）不区分大小写（即，大写和小写都匹配）。为区分大小写，可使用BINARY关键字，如WHERE prod_name REGEXP BINARY  'JetPack .000'。 

##### 9.2.2 进行OR匹配 

为搜索两个串之一（或者为这个串，或者为另一个串），使用|，如
下所示 

##### 9.2.3 匹配几个字符之一 

```
select prod_name,vend_id,prod_price
from products
where prod_name regexp '[123] ton';
```

除非把字符|括在一个集合中，否则它将应用于整个串 

字符集合也可以被否定，即，它们将匹配除指定字符外的任何东西。
为否定一个字符集，在集合的开始处放置一个^即可。因此，尽管[123]
匹配字符1、 2或3，但[^123]却匹配除这些字符外的任何东西。 

##### 9.2.4 匹配范围 

集合可用来定义要匹配的一个或多个字符。例如，下面的集合将匹
配数字0到9：[0-9]
为简化这种类型的集合，可使用-来定义一个范围。下面的式子功能
上等同于上述数字列表：
范围不限于完整的集合， [1-3]和[6-9]也是合法的范围。此外，范
围不一定只是数值的， [a-z]匹配任意字母字符。 

为了匹配特殊字符，必须用\\为前导。\\-表示查找-， \\.表示查找. 

就是所谓的转义 

为了匹配反斜杠（ \）字符本身，需要使用\\\。 

##### 9.2.6 匹配字符类 

存在找出你自己经常使用的数字、所有字母字符或所有数字字母字
符等的匹配。为更方便工作，可以使用预定义的字符集，称为字符类
（character class）。表9-2列出字符类以及它们的含义。 

![1583939393675](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583939393675.png)

##### 9.2.7 匹配多个实例 

你可能需要寻找所有的数，不管
数中包含多少数字，或者你可能想寻找一个单词并且还能够适应一个尾
随的s（如果存在），等等。
这可以用表9-3列出的正则表达式重复元字符来完成 

![1583939836918](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583939836918.png)

正则表达式\\([0-9] sticks?\\)需要解说一下。 \\(匹配)，
[0-9]匹配任意数字（这个例子中为1和5）， sticks?匹配stick
和sticks（s后的?使s可选，因为?匹配它前面的任何字符的0次或1次出
现）， \\)匹配)。没有?，匹配stick和sticks会非常困难 

```
select prod_name
from products
where prod_name regexp '[[:digit:]]{4}';
```

如前所述， [:digit:]匹配任意数字，因而它为数字的一个集
合。 {4}确切地要求它前面的字符（任意数字）出现4次，所以
[[:digit:]]{4}匹配连在一起的任意4位数字 

##### 9.2.8 定位符 

为了匹配特定位置的文本，需要使用表9-4列出的定位符。 

![1583940176489](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583940176489.png)

如果你想找出以一个数（包括以小数点开始的数）开始的所
有产品， 

```
select prod_name
from products
where prod_name regexp '^[0-9\\.]';
```

因此， ^[0-9\\.]只在.或任意数字为串中第
一个字符时才匹配它们。没有^， 则还要多检索出4个别的行（那
些中间有数字的行）。 

**^的双重用途**  ^有两种用法。在集合中（用[和]定义），用它
来否定该集合，否则，用来指串的开始处 

**使REGEXP起类似LIKE的作用** 本章前面说过， LIKE和REGEXP
的不同在于， **LIKE匹配整个串而REGEXP匹配子串**。利用定位
符，通过用^开始每个表达式，用$结束每个表达式，可以使
REGEXP的作用与LIKE一样。 

**简单的正则表达式测试** 可以在不使用数据库表的情况下用
SELECT来测试正则表达式。REGEXP检查总是返回0（没有匹配）
或1（匹配）。可以用带文字串的REGEXP来测试表达式，并试
验它们。相应的语法如下： 

```sql
select 'hello' regexp '[0-9]'；
```



##第10章 创建计算字段 

我们需要直接从数据库中检索出转换、计算或格式化过的数据；而不是
检索出数据，然后再在客户机应用程序或报告程序中重新格式化。 

计算字段是运行时在SELECT语句内创建的。 

字段（field） 基本上与列（ column） 的意思相同，经常互换使
用，不过数据库列一般称为列，而术语字段通常用在计算字段的
连接上 

(靠，忘记保存了）



## 第13章 分组数据

#### 13.2 创建分组 

分组允许把数据分为多个逻辑组，以便能对每个组进行聚集计算。 

```
select vend_id ,count(*) as num_prods
from products
group by vend_id;
```

GROUP BY子句可以包含任意数目的列。这使得能对分组进行嵌套，
为数据分组提供更细致的控制 

GROUP BY子句中列出的每个列都必须是检索列或有效的表达式
（但不能是聚集函数）。如果在SELECT中使用表达式，则必须在
GROUP BY子句中指定相同的表达式。不能使用别名 

GROUP BY子句必须出现在WHERE子句之后， ORDER BY子句之前 

使用ROLLUP 使用WITH ROLLUP关键字，可以得到每个分组以
及每个分组汇总级别（针对每个分组）的值，如下所示： 

```
select vend_id,count(*) as num_prods
from products
group by vend_id with rollup;
```

![1583981899681](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583981899681.png)

MySQL还允许过滤分组，规定包括哪些分组，排除哪些分组 

唯一的差别是WHERE过滤行，而HAVING过滤分组 

HAVING支持所有WHERE操作符  

```
select vend_id,count(*) as num_prods
from products
group by vend_id with rollup
having count(*) >2;
```

这里WHERE子句不起作用，因为过滤是基于分组聚集值而不是特定行值的。 

```
select vend_id,count(*) as num_prods
from products
where prod_price >= 10
group by vend_id
having count(*) >= 2;
```

#### 13.4 分组和排序 

having后能用别名

```
select order_num,sum(quantity*item_price)as ordertotal
from orderitems
group by order_num
having ordertotal >=50
order by ordertotal;
```

在这个例子中， GROUP BY子句用来按订单号（order_num列）
分组数据，以便SUM(*)函数能够返回总计订单价格，即是每个订单号的sum。 HAVING子
句过滤数据，使得只返回总计订单价格大于等于50的订单。最后， 用ORDER
BY子句排序输出 

#### 13.5 SELECT子句顺序 

![1584151077656](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584151077656.png)

## 第14章 使用子查询 

SQL还允许创建子查询（ subquery） ，即嵌套在其他查询中的查询。 

#### 14.2 利用子查询进行过滤 

把

```
select order_num
from orderitems
where prod_id="TNT2";
--和
select cust_id
from orders
where order_num in (20005,20007);
--组合成
select cust_name,cust_id
from customers
where cust_id in (select cust_id
                from orders
                where order_num in (select order_num
                                    from orderitems
                                    where prod_id="TNT2"));
```

格式化SQL 包含子查询的SELECT语句难以阅读和调试，特别是它们较为复杂时更是如此。如上所示把子查询分解为多行并且适当地进行缩进，能极大地简化子查询的使用 

#### 14.3 作为计算字段使用子查询 

可使用SELECT COUNT(*)对表中的行进行计数 ,并且通过提供一条WHERE子句来过滤某个特定的客户ID， 

```
select count(*) as orders
from orders
where cust_id=10001;
```

**相关子查询（correlated subquery）** 涉及外部查询的子查询 

## 第15章 联结表

#### 15.1 联结 

**外键（foreign key）** 外键为某个表中的一列，它包含另一个表的主键值，定义了两个表之间的关系。 

简单地说，联结是一种机制，用来在一条SELECT语句中关联表，因此称之为联结。使用特殊的语法，可以联结多个表返回一组输出，联结在运行时关联表中正确的行 

#### 15.2 创建联结

联结例子 

```
select vend_name,prod_name,prod_price
from vendors,products
where vendors.vend_id = products.vend_id
order by vend_name,prod_name;
```

##### 15.2.1 WHERE子句的重要性 

没有WHERE子句，第一个表中的每个行将与第二个表中的每个行配对，而不管它们逻辑上是否可以配在一起。 

**笛卡儿积（cartesian product）** 由没有联结条件的表关系返回的结果为笛卡儿积。检索出的行的数目将是第一个表中的行数乘以第二个表中的行数 

**叉联结** 有时我们会听到返回称为叉联结（ cross join）的笛卡儿积的联结类型 

##### 15.2.2 内部联结 

目前为止所用的联结称为等值联结（equijoin），它基于两个表之间的
相等测试。这种联结也称为内部联结 

```
select vend_name,prod_name,prod_price
from vendors inner join products
on vendors.vend_id = products.vend_id
order by vend_name,prod_name;
```

##### 15.2.3 联结多个表 

有时候可以用联结表的操作代替子查询

```
select cust_name,cust_contact
from customers,orders,orderitems
where customers.cust_id=orders.cust_id
and orders.order_num=orderitems.order_num
and orderitems.prod_id='TNT2';
```



## 第16章 创建高级联结

#### 16.1 使用表别名 

别名除了用于列名和计算字段外， SQL还允许给表名起别名。这样做
有两个主要理由：
 缩短SQL语句；
 允许在单条SELECT语句中多次使用相同的表。 

![1584162522701](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584162522701.png)

但是，表别名不仅能用于WHERE子句，它还可以用于SELECT的列表、 ORDER BY子句
以及语句的其他部分。应该注意，表别名只在查询执行中使用。与列别名不一样，表别名
不返回到客户机。 

#### 16.2 使用不同类型的联结 

##### 16.2.1 自联结

如前所述，使用表别名的主要原因之一是能在单条SELECT语句中不止一次引用相同的表。下面举一个例子。 

表别名解决了二义性

自己反推的情况

```
select p1.prod_id,p1.prod_name
from products as p1,products as p2
where p1.vend_id=p2.vend_id
and p2.prod_id='DTNTR';
```

但有时候处理联结远比处理子查询快得多 

##### 16.2.2 自然联结 

自然联结排除多次出现，使每个列只返回一次。
怎样完成这项工作呢？答案是，系统不完成这项工作，由你自己完
成它。自然联结是这样一种联结，其中你只能选择那些唯一的列。这一
般是通过对表使用通配符（SELECT *），对所有其他表的列使用明确的子
集来完成的。 

![1584164454712](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584164454712.png)

##### 16.2.3 外部联结 

在上述例子中，联结包含了那些在相关表中没有关联行的行。这种类型的联结称为外部联结 

为了检索所有客户，包括那些没有订单的客户，可如下进行 

```
select customers.cust_id,orders.order_num
from customers left outer join orders
on customers.cust_id = orders.cust_id; 
```

与内部联结关联两个表中的行不同的是，外部联结还包括没
有关联行的行。在使用OUTER JOIN语法时，必须使用RIGHT或LEFT关键字
指定包括其所有行的表（RIGHT指出的是OUTER JOIN右边的表，而LEFT
指出的是OUTER JOIN左边的表） 

#### 16.3 使用带聚集函数的联结 

```
select customers.cust_name,customers.cust_id,count(orders.order_num) as num_od
from customers left outer join orders
on customers.cust_id = orders.cust_id
group by customers.cust_id;
```

应该总是提供联结条件，否则会得出笛卡儿积 

但应该在一起测试它们前，分别测试每个联结。这将使故障排除更为简单。 



## 第17章 组合查询

MySQL也允许执行多个查询（多条SELECT语句），并将结果作为单个
查询结果集返回。这些组合查询通常称为并（ union） 或复合查询
（compound query） 

有两种基本情况，其中需要使用组合查询：
 在单个查询中从不同的表返回类似结构的数据；
 对单个表执行多个查询，按单个查询返回数据。 

#### 17.2 创建组合查询 

利用union，可给出多条select语句，将它们的结果组合成单个结果集。

##### 17.2.1 使用UNION 

```
select vend_id,prod_id,prod_price
from products
where prod_price <= 5
union
select vend_id,prod_id,prod_price
from products
where vend_id in (1001,1002);
```

这条语句由前面的两条SELECT语句组成，语句中用UNION关键
字分隔。 UNION指示MySQL执行两条SELECT语句，并把输出组
合成单个查询结果集。 

##### 17.2.2 UNION规则 

UNION中的每个查询必须包含相同的列、表达式或聚集函数 

列数据类型必须兼容：类型不必完全相同，但必须是DBMS可以隐含地转换的类型 

##### 17.2.3 包含或取消重复的行 

UNION从查询结果集中自动去除了重复的行 

事实上，如果想返回所有匹配行，可使用UNION ALL而不是UNION 

##### 17.2.4 对组合查询结果排序 

在用UNION组合查询时，只能使用一条ORDER BY子句，它必须出现在最后一条SELECT语句之后。 



## 第18章 全文本搜索

现在InnoDB已经支持全文本搜索了

#### 18.2 使用全文本搜索 

##### 18.2.1 启用全文本搜索支持 

一般在创建表时启用全文本搜索 

```
create table productnotes
(
	note_id int      not null auto_increment,
    prod_id char(10) not null,
    note_date datetime not null,
    note_text text null,
    primary key(note_id),
    fulltext(note_text)
    
)engine=myisam;
```

为了进行全文本搜索，MySQL根据子句FULLTEXT(note_text)的指示对它进行索引。这里的
FULLTEXT索引单个列，如果需要也可以指定多个列 

在定义之后， MySQL自动维护该索引。在增加、更新或删除行时，索引随之自动更新 

##### 18.2.2 进行全文本搜索 

在索引之后，使用两个函数Match()和Against()执行全文本搜索，其中Match()指定被搜索的列， Against()指定要使用的搜索表达式。 

文本搜索的一个重要部分就是对结果排序。具有较高等级的行先返回（因为这些行很
可能是你真正想要的行） 

```
select note_text
from productnotes
where match(note_text) against('rabbit');
```

Match()和Against()用来建立一个计算列（别名为rank），此列包含全文本搜索计算出的等级
值。等级由MySQL根据行中词的数目、唯一词的数目、整个索引中词的
总数以及包含该词的行的数目计算出来。 

##### 18.2.3 使用查询扩展 

查询扩展用来设法放宽所返回的全文本搜索结果的范围

例子:只有一个注释包含词anvils，但你还想找出可能与你的搜索有关的所有其他行，即使它们不包含词 anvils 

![1584171708375](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584171708375.png)

##### 18.2.4 布尔文本搜索 

以布尔方式，可以提供关于如下内容的细节 :

![1584171874691](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584171874691.png)

使用了关键字IN BOOLEAN MODE，但实际上没有指定布尔操作符，
因此，其结果与没有指定布尔方式的结果相同。 

`-rope*`明确地指示MySQL排除包含rope*（任何以rope开始的词，包括
ropes）的行，这就是为什么上一个例子中的第一行被排除的原因 

![1584172164580](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584172164580.png)

+相当于and

```
select note_text
from productnotes
where match(note_text) against('rabbit bait' in boolean mode);
```

没有指定操作符，这个搜索匹配包含rabbit和bait中的至少一个词的行 

##### 18.2.5 全文本搜索的使用说明 

在索引全文本数据时，短词被忽略且从索引中排除。短词定义为
那些具有3个或3个以下字符的词（如果需要，这个数目可以更改）。 

许多词出现的频率很高，搜索它们没有用处（返回太多的结果）。
因此， MySQL规定了一条50%规则，如果一个词出现在50%以上
的行中，则将它作为一个非用词忽略。 50%规则不用于IN BOOLEAN
MODE 

如果表中的行数少于3行，则全文本搜索不返回结果 

忽略词中的单引号。例如， don't索引为dont 



## 插入数据

插入可以用几种方式使用：
 插入完整的行；
 插入行的一部分；
 插入多行；
 插入某些查询的结果 

#### 19.2 插入完整的行 

基本的INSERT语法,它要求制定表名和被插入到新行中的值

存储到每个表列中的
数据在VALUES子句中给出，对每个列必须提供一个值。如果某
个列没有值（如上面的cust_contact和cust_email列），应该使用NULL
值（假定表允许对该列指定空值）。各个列必须以它们在表定义中出现的
次序填充。第一列cust_id也为NULL。这是因为每次插入一个新行时，该
列由MySQL自动增量。你不想给出一个值（这是MySQL的工作），又不
能省略此列（如前所述，必须给出每个列），所以指定一个NULL值 

编写INSERT语句的更安全（不过更烦琐）的方法如下 

    insert into customers(cust_name,
    cust_contact,
    cust_email,
    cust_address,
    cust_city,
    cust_state,
    cust_zip,
    cust_country)
    VALUES('Pep E. LaPew',
    NULL,
    NULL,
    '100 Main Street',
    'Los Angeles',
    'CA',
    '90046',
    'USA');
如果不提供列名，则必须给每个表列提供一个值。如果提供列名，则必须对每个列出的列给出一个值。 

如果数据检索是最重要的（通常是这样），则你可以通过在
INSERT和INTO之间添加关键字LOW_PRIORITY，指示MySQL
降低INSERT语句的优先级，如下所示： 

`INSERT LOW_PRIORITY INTO`

#### 19.3 插入多个行 

可以使用多条INSERT语句，甚至一次提交它们，每条语句用一个分号结束;

或者，只要每条INSERT语句中的列名（和次序）相同，可以如下组合各语句： 

```
 INSERT INTO customers(cust_name,
    cust_address,
    cust_city,
    cust_state,
    cust_zip,
    cust_country)
    VALUES('Pep E. LaPew',
    '100 Main Street',
    'Los Angeles',
    'CA',
    '90046',
    'USA'),
    (
		'M. Martin',
        '42 galaxy Way',
        'New York',
        'NY',
        '112113',
        'USA'
    );
```

#### 19.4 插入检索出的数据 

![1584177810692](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584177810692.png)

SELECT语句从custnew检索出要插入的值，而不是列出它们。  SELECT中列出的每个列对应于customers表名后所跟的列表中的每个列。这条语句将插入多少行有赖于custnew表中有多少行。 

INSERT SELECT中SELECT语句可包含WHERE子句以过滤插入的数据。 



## 第20章 更新和删除数据

为了更新（修改）表中的数据，可使用UPDATE语句。可采用两种方式使用UPDATE：
 更新表中特定行；
 更新表中所有行 

UPDATE语句非常容易使用，甚至可以说是太容易使用了。基本的
UPDATE语句由3部分组成，分别是： 

 要更新的表；
 列名和它们的新值； 

 确定要更新行的过滤条件。 

**不要省略WHERE子句** 

因为稍不注意，就会更新表中所有行 

    update customers
    set cust_email = 'elemer@fudd.com'
    where cust_id = 10005;
UPDATE语句总是以要更新的表的名字开始。在此例子中，要更新的
表的名字为customers。 SET命令用来将新值赋给被更新的列。 

没有WHERE子句， MySQL将会用这个电子邮件地址更新customers表中所有行.

**更新多个列**

    update customers
    set cust_email = 'elemer@fudd.com',
    	cust_name = 'the fudds'
    where cust_id = 10005;
在更新多个列时，只需要使用单个SET命令 

**在UPDATE语句中使用子查询**  UPDATE语句中可以使用子查
询，使得能用SELECT语句检索出的数据更新列数据。 

**IGNORE关键字**  

为即使是发生错误，也继续进行更新，可使用IGNORE关键字，如下所示：
UPDATE IGNORE customers… 

为了删除某个列的值，可设置它为NULL（假如表定义允许NULL值）。 

#### 20.2 删除数据 

为了从一个表中删除（去掉）数据，使用DELETE语句。可以两种方
式使用DELETE：
 从表中删除特定的行；
 从表中删除所有行

    delete from customers
    where cust_id = 10007;
为了删除指定的列，请使用UPDATE语句。 

**更快的删除** 

如果想从表中删除所有行,不要使用delete.可使用TRUNCATE TABLEY语句

#### 20.3 更新和删除的指导原则 

除非确实打算更新和删除每一行，否则绝对不要使用不带WHERE子句的UPDATE或DELETE语句 

保证每个表都有主键 

在对UPDATE或DELETE语句使用WHERE子句前，应该先用SELECT进行测试，保证它过滤的是正确的记录，以防编写的WHERE子句不正确。 

### 第21章 创建和操纵表

#### 21.1 创建表 

##### 21.1.1 表创建基础

为利用CREATE TABLE创建表，必须给出下列信息：
 新表的名字，在关键字CREATE TABLE之后给出；
 表列的名字和定义，用逗号分隔。 

![1584183625144](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584183625144.png)

名紧跟在CREATE TABLE关键字后面实际的表定义（所有列）括在圆括号之中。各列之间用逗
号分隔。这个表由9列组成。每列的定义以列名（它在表中必须是唯一的）
开始，后跟列的数据类型

表的主键可以在创建表时用PRIMARY KEY关键字指定。 

处理现有的表 在创建新表时，指定的表名必须不存在，否则将出错 

##### 21.1.2 使用NULL值 

NULL 允许NULL值的列也允许在插入行时不给出该列的值。

NOT NULL 不允许NULL值的列不接受该列没有值的行，换句话说，在插入或更新行时，该列必须有值 

如果试图插入没有值的列，将返回错误，且插入失败 

注意区别NULL和空串

##### 21.1.3 主键再介绍 

主键用以下的类似的语句定义:

PRIMARY KEY (vend_id)

为创建由多个列组成的主键，应该以逗号分隔的列表给出各列名，如下所示 

##### 21.1.4 使用AUTO_INCREMENT 

每个表只允许一个AUTO_INCREMENT列，而且它必须被索引(如,通过使它成为主键)

AUTO_INCREMENT告诉MySQL，本列每当增加一行时自动增量

用last_insert_id()函数获得上次insert的行的设置了AUTO_INCREMENT值 

select last_insert_id();

##### 21.1.5 指定默认值 

默认值用CREATE TABLE语句的列定义中的DEFAULT关键字指定。 

##### DECIMAL(20,2)  总共能存20位数字，末尾2位是小数（小数点不算在长度内）

```
create TABLE orderitems1
(
	order_num int not null,
    order_item int not null,
    prod_id char(10) not null,
    quantity int not null default 1,
    item_price decimal(8,2) not null,
    primary key (order_num,order_item)
    )engine=InnoDB;
```

#### 21.1.6 引擎类型 


 InnoDB是一个可靠的事务处理引擎（参见第26章），它不支持全文
本搜索；
 MEMORY在功能等同于MyISAM， 但由于数据存储在内存（不是磁盘）
中，速度很快（特别适合于临时表）；
 MyISAM是一个性能极高的引擎，它支持全文本搜索（参见第18章），
但不支持事务处理。 

使用一个引擎的表不能引用具有使用不同引擎的表的外键 

##### 如果[公共关键字](https://baike.baidu.com/item/公共关键字)在一个关系中是[主关键字](https://baike.baidu.com/item/主关键字/1239455)，那么这个公共关键字被称为另一个关系的外键。

#### 21.2 更新表 

为更新表定义，可使用ALTER TABLE语句 

为了使用ALTER TABLE更改表结构，必须给出下面的信息：
 在ALTER TABLE之后给出要更改的表名（该表必须存在，否则将
出错）；
 所做更改的列表 

下面的例子给表添加一个列

```
ALTER TABLE vendors
add vend_phone char(20);
```

删除一个列

```
alter table vendors
drop column vend_phone;
```

ALTER TABLE的一种常见用途是定义外键 

![1584190362722](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584190362722.png)

**小心使用ALTER TABLE 使用ALTER TABLE要极为小心**，应该
在进行改动前做一个完整的备份（模式和数据的备份）。 

#### 21.3 删除表 

删除表(删除整个表而不是其内容)非常简单,使用DROP TABLE语句即可

`DROP TABLE customers2;`

#### 21.4 重命名表 

使用RENAME TABLE语句可以重命名一个表 

```sql
RENAME TABLE customers2 to customers;
```

## 第22章 使用视图

视图是虚拟的表.与包含数据的表不一样，视图只包含使用时动态检索数据的查询。

作为视图，它不包含表中应该有的任何列或数据，它包含的是一个SQL查询 

##### 22.1.1 为什么使用视图 

下面是视图的一些常见应用。
 重用SQL语句。
 简化复杂的SQL操作。在编写查询后，可以方便地重用它而不必知道它的基本查询细节。
 使用表的组成部分而不是整个表。
 保护数据。可以给用户授予表的特定部分的访问权限而不是整个表的访问权限。
 更改数据格式和表示。视图可返回与底层表的表示和格式不同的数据 .

视图本身不包含数据，因此它们返回的数据是从其他表中检索出来的。
在添加或更改这些表中的数据时，视图将返回改变过的数据。 

##### 22.1.2 视图的规则和限制 

与表一样，视图必须唯一命名 

视图不能索引，也不能有关联的触发器或默认值。 

视图可以和表一起使用。例如，编写一条联结表和视图的SELECT语句。 

ORDER BY可以用在视图中，但如果从该视图检索数据SELECT中也
含有ORDER BY，那么该视图中的ORDER BY将被覆盖 

#### 22.2 使用视图 

 视图用CREATE VIEW语句来创建。
 使用SHOW CREATE VIEW viewname；来查看创建视图的语句。
 用DROP删除视图，其语法为DROP VIEW viewname;。
 更新视图时，可以先用DROP再用CREATE，也可以直接用CREATE OR
REPLACE VIEW。如果要更新的视图不存在，则第2条更新语句会创
建一个视图；如果要更新的视图存在，则第2条更新语句会替换原
有视图。 

##### 22.2.1 利用视图简化复杂的联结 

```
create view productcustomers as 
select cust_name,cust_contact,prod_id
from customers,orders,orderitems
where customers.cust_id = orders.cust_id
and orderitems.order_num = orders.order_num;
```

这条语句创建一个名为productcustomers的视图， 它联结三个表，以返回已订购了任意产品的所有客户的列表。 

```
select cust_name,cust_contact
from productcustomers
where prod_id = 'TNT2';
```

这条语句通过WHERE子句从视图中检索特定数据。在MySQL处理此查询时，它将指定的WHERE子句添加到视图查询中的已有WHERE子句中，以便正确过滤数据。 

展视图的范围不仅使得它能被重用，而且甚至更有用。这样做不需要创建和维护多个类似
视图。 

##### 22.2.2 用视图重新格式化检索出的数据 

![1584236058075](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584236058075.png)

##### 22.2.3 用视图过滤不想要的数据 

```
create view customeremaillist as
select cust_id,cust_name,cust_email
from customers
where cust_email is not null;
```

它过滤没有电子邮件地址的客户 

##### 22.2.4 使用视图与计算字段 

![1584236558602](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584236558602.png)

##### 22.2.5 更新视图 

如果你对视图增加或删除行，实际上是对其基表增加或删除行 

如果视图定义中有以下操作，则不能进行视图的更新：
 分组（使用GROUP BY和HAVING）；
 联结；
 子查询；
 并；
 聚集函数（Min()、 Count()、 Sum()等）； 

 DISTINCT；
 导出（计算）列。 



## 使用存储过程

#### 23.1 存储过程 

存储过程简单来说，就是为以后的使用而保存
的一条或多条MySQL语句的集合。可将其视为批文件，虽然它们的作用
不仅限于批处理。 

#### 23.2 为什么要使用存储过程 

通过把处理封装在容易使用的单元中，简化复杂的操作（正如前面例子所述）。 

使用存储过程有3个主要的好处，即简单、安全、高性能。 

不能编写存储过程？你依然可以使用  

#### 23.3 使用存储过程 

##### 23.3.1 执行存储过程 

MySQL称存储过程的执行为调用，因此MySQL执行存储过程的语句
为CALL。 CALL接受存储过程的名字以及需要传递给它的任意参数 

```
call productpricing(@pricelow,@pricehigh,@priceaverage);
```

其中，执行名为productpricing的存储过程，它计算并返回产品的最低、最高和平均价格 

##### 23.3.2 创建存储过程 



       create procedure productpricing()
       select avg(prod_price) as priceaverage
       from products;
如果存储过程接受参数，它们将在()中列举出来。此存储过程没有参数，但后跟的()仍然需要。 

BEGIN和END语句用来限定存储过程体  不知道为什么报错？



[[MySQL\]使用Begin...End语句的一个坑](https://www.cnblogs.com/oDoraemon/p/5881885.html)

写一个触发器，执行单条语句是OK的。

想执行多条语句，尝试在代码中加入BEGIN END。但一加BEGIN END就报错， 错误信息也很诡异，只说某一行出错了，不符合Mysql的语句规范，提示信息就个''。

查了文档，并没有发现BEGIN END有什么特别要注意的地方。

反复查找，参考了这里：http://bbs.csdn.net/topics/390542425 13楼的回复。

说是没有定义查询界定符导致，导致编译器将;识别为全部语句的结束，导致BEGIN 匹配不到END，于是报错。

解决方案是，在语句前面增加 DELIMITER // (无分号)也就是需要定义分界符。

```
DELIMITER 
create procedure productpricing1()
begin
	select avg(prod_price) as priceaverage
	from products;
end;
```

如何使用？

`call productpricing1()`

因为存储过程实际上是一种函数，所以存储过程名后需要有()符号（即使不传递参数也需要） 

##### 23.3.3 删除存储过程 

drop procedure if exists productpricing1;

##### 23.3.4 使用参数 

```
create procedure productpricing1(
out p1 decimal(8,2),
out ph decimal(8,2),
out pa decimal(8,2)
)
begin
 select min(prod_price)
 into p1
 from products;
 select max(prod_price)
 into ph
 from products;
 select avg(prod_price)
 into pa
 from products;
end;
```

关键字OUT指出相应的参数用来从存储过程传出一个值（返回给调用者）。 MySQL支持IN（传递给存储过程）、 OUT（从存储过程传出，如这里所用）和INOUT（对存储过程传入和传出）类型的参数。 

如前所见，它们是一系列SELECT语句，用来检索值，然后保存到相应的变量（通过指定INTO关键字） 

```
call productpricing1(@pricelow,
						@pricemax,@priceavg);
```

在调用时，这条语句并不显示任何数据。它返回以后可以显示（或
在其他处理中使用）的变量。
为了显示检索出的产品平均价格，可如下进行： 

```
select @pricelow,@pricemax,@priceavg;
```

这次使用IN和OUT参数。 ordertotal接受订单号并返回该订单的合计 

```
create procedure ordertotal(
	IN onumber int,
    out ototal decimal(8,2)
)
	select sum(item_price*quantity)
    from orderitems
    where order_num = onumber
    into ototal;
```

`call ordertotal(20005,@total);`

`select @total;`

##### 23.3.5 建立智能存储过程 

```
DELIMITER 
create procedure ordertotal1(
	in onumber int,
    in taxable boolean,
    out ototal decimal(8,2)
) comment 'obtain order total,optionally adding tax'
begin
declare total decimal(8,2);
declare taxrate int default 6;

select sum(item_price*quantity)
from orderitems
where order_num = onumber
into total;

if taxable then
select total+(total/100*taxrate) into total;
end if;

select total into ototal;
end;
```

在存储过程体中，用DECLARE语句定义了两个局部变量。 DECLARE要求指定
变量名和数据类型，它也支持可选的默认值（这个例子中的taxrate的默
认被设置为6%）。  

```
call ordertotal1(20005,0,@total);
select @total;
```

**IF语句** 这个例子给出了MySQL的IF语句的基本用法。 IF语
句还支持ELSEIF和ELSE子句（前者还使用THEN子句，后者不
使用）。 

##### 23.3.6 检查存储过程 

```
show create procedure ordertotal1;
```

为了获得包括何时、由谁创建等详细信息的存储过程列表， 使用SHOW
PROCEDURE STATUS 

## 第24章 使用游标

有时，需要在检索出来的行中前进或后退一行或多行。这就是使用
游标的原因 

MySQL游标只能用于存储过程（和函数）。 

游标（cursor） 是一个存储在MySQL服务器上的数据库查询，
它不是一条SELECT语句，而是被该语句检索出来的结果集。在存储了游
标之后，应用程序可以根据需要滚动或浏览其中的数据 

#### 24.2 使用游标 

使用游标涉及几个明确的步骤。 

 在能够使用游标前，必须声明（定义）它。这个过程实际上没有
检索数据，它只是定义要使用的SELECT语句。
 一旦声明后，必须打开游标以供使用。这个过程用前面定义的
SELECT语句把数据实际检索出来。
 对于填有数据的游标，根据需要取出（检索）各行。
 在结束游标使用时，必须关闭游标。 

##### 24.2.1 创建游标 

没错，会报错
因为我们要添加定界符
**DELIMITER ////DELIMITER ;**

```
DELIMITER //
create procedure processorders()
begin
declare ordernumbers cursor 
for
select order_num from orders;
end
// DELIMITER ;
```

储过程处理完成后，游标就消失（因为它局限于存储过程）。
在定义游标之后，可以打开它。 

##### 24.2.2 打开和关闭游标 

![1584290150631](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584290150631.png)

![1584290169522](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584290169522.png)

```
DELIMITER //
create procedure processorders1()
begin
declare ordernumbers cursor 
for
select order_num from orders;

open ordernumbers;
close ordernumbers;
end
// DELIMITER ;
```

这个存储过程声明、打开和关闭一个游标。但对检索出的数据
什么也没做。 

**隐含关闭** 如果你不明确关闭游标， MySQL将会在到达END语
句时自动关闭它。 

##### 24.2.3 使用游标数据 

在一个游标被打开后，可以使用FETCH语句分别访问它的每一行。
FETCH指定检索什么数据（所需的列），检索出来的数据存储在什么地方。
它还向前移动游标中的内部行指针，使下一条FETCH语句检索下一行（不
重复读取同一行）。 

DECLARE语句的次序 DECLARE语句的发布存在特定的次序。
用DECLARE语句定义的局部变量必须在定义任意游标或句柄
之前定义，而句柄必须在游标之后定义。不遵守此顺序将产
生错误消息。

获取单行 

```
DELIMITER //
create procedure processorders2()
begin
declare o int;
declare ordernumbers cursor 
for
select order_num from orders;

open ordernumbers;
fetch ordernumbers into o;
close ordernumbers;
end
// DELIMITER ;
```

```
create procedure processorders3()
begin
	declare done boolean default 0;
    declare o int;
    

​```
declare ordernumbers cursor
for 
select order_num from orders;
declare continue handler for sqlstate '02000' set done =1;
open ordernumbers;
repeat
fetch ordernumbers into o;
until done end repeat;
close ordernumbers;
​```

end
// DELIMITER ;
```

这个例子中的FETCH是在REPEAT内，因此它反复执行直到done为真（由UNTIL
done END REPEAT;规定）。为使它起作用，用一个DEFAULT 0（假，不结
束）定义变量done。 

declare continue handler for sqlstate '02000' set done =1;

这条语句定义了一个CONTINUE HANDLER，它是在条件出现时被执行
的代码。这里， 它指出当SQLSTATE '02000'出现时， SET done=1。SQLSTATE
'02000'是一个未找到条件， 当REPEAT由于没有更多的行供循环而不能继
续时，出现这个条件 

###### MySQL的错误代码 关于MySQL 5使用的MySQL错误代码列

表，请参阅http://dev.mysql.com/doc/mysql/en/error-handling.html 

**重复或循环？** 除这里使用的REPEAT语句外， MySQL还支持
循环语句，它可用来重复执行代码，直到使用LEAVE语句手动
退出为止。通常REPEAT语句的语法使它更适合于对游标进行循
环 

实际处理

```
DELIMITER //
 create procedure processorders5()
begin
     declare done boolean default 0;    
     declare o int;    
     declare t decimal(8,2);    



​```
 declare ordernumbers cursor    for   select order_num from orders;    
​```



​```
 declare continue handler for sqlstate '02000'  set done = 1;    
     
 create table if not exists ordertotals    
        (order_num int,total decimal(8,2));        
​```

​```
  open ordernumbers;     
​```

​```
  REPEAT      
        FETCH ordernumbers into o;           
        call ordertotal(o,1,t);           
        insert into ordertotals(order_num,total) values(o,t);      
​```

​      

​```
  until done end REPEAT; 
​```

​    

​```
  close ordernumbers;     
​```

end;
// DELIMITER ;

call processorders5();
select * from ordertotals
```



## 第25章 使用触发器

这确切地说就是触发器。 触发器是MySQL响应以下任意语句而
自动执行的一条MySQL语句 

DELETE,UPDATE,INSERT

#### 25.2 创建触发器 

在创建触发器时，需要给出4条信息：
 唯一的触发器名；
 触发器关联的表；
 触发器应该响应的活动（DELETE、 INSERT或UPDATE）；
 触发器何时执行（处理之前或之后）。 

现在最好是在数据库范围内使用唯一的触发器名。 

仅支持表 只有表才支持触发器，视图不支持（临时表也不支持）

```
create trigger newproduct after insert on products
for each row select 'product added' into @arg;
```

**执行问题** 

执行的时候会报ERROR 1415 (0A000): Not allowed to return a result set from a trigger的错误。MySQL5早期版本是支持的，现在的新版本已经不支持这种写法。触发器不允许出现SELECT *的形式，因为这会返回一个结果集，而这是不允许的，所以会报出这种错。

触发器中可以使用SELECT  INTO的形式来进行查询，将结果放进一个变量，然后查询该变量
触发器按每个表每个事件每次地定义 

因此，每个表最多支持6个触发器（每条INSERT、 UPDATE和DELETE的之前和之后） 

如果你需要一个对INSERT和UPDATE操作执行的触发器，则应该定义
两个触发器 

**触发器失败** 如果BEFORE触发器失败，则MySQL将不执行请
求的操作。此外，如果BEFORE触发器或语句本身失败， MySQL
将不执行AFTER触发器（如果有的话）。 

#### 25.3 删除触发器 

```
drop trigger newproduct;
```

#### 25.4 使用触发器 

##### 25.4.1 INSERT触发器 

在INSERT触发器代码内，可引用一个名为NEW的虚拟表，访问被插入的行； 

对于AUTO_INCREMENT列， NEW在INSERT执行之前包含0，在INSERT
执行之后包含新的自动生成值。 

```
create trigger neworder after insert on orders
for each row select new.order_num into @arg1;

insert into orders(order_date,cust_id)
values(now(),10001);
select @arg1;
```

此触发器必须按照AFTER INSERT执行，因为在BEFORE
INSERT语句执行之前，新order_num还没有生成。 

##### 25.4.2 DELETE触发器 

 在DELETE触发器代码内，你可以引用一个名为OLD的虚拟表，访
问被删除的行； 

OLD中的值全都是只读的，不能更新 

![1584326174891](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584326174891.png)

##### 25.4.3 UPDATE触发器 

在UPDATE触发器代码中，你可以引用一个名为OLD的虚拟表访问
以前（UPDATE语句前）的值，引用一个名为NEW的虚拟表访问新
更新的值 

在BEFORE UPDATE触发器中， NEW中的值可能也被更新（允许更改
将要用于UPDATE语句中的值）； 

OLD中的值全都是只读的，不能更新。 

![1584326530093](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584326530093.png)

##### 25.4.4 关于触发器的进一步介绍 

应该用触发器来保证数据的一致性（大小写、格式等） 

触发器的一种非常有意义的使用是创建审计跟踪。使用触发器，
把更改（如果需要，甚至还有之前和之后的状态）记录到另一个
表非常容易。 



## 第26章 管理事务处理

**本章介绍什么是事务处理以及如何利用COMMIT和ROLLBACK语句来管**
**理事务处理。**



事务处理是一种机制，用来管理必须成批执行的MySQL操作，以保证数据库不包含不完整的操作结果。利用事务处理，可以保证一组操作不会中途停止，它们或者作为整体执行，或者完全不执行（除非明确指示）。如果没有错误发
生，整组语句提交给（写到）数据库表。如果发生错误，则进行回退（撤
销）以恢复数据库到某个已知且安全的状态 



在使用事务和事务处理时，有几个关键词汇反复出现。下面是关于
事务处理需要知道的几个术语： 

 事务（transaction）指一组SQL语句；
 回退（rollback）指撤销指定SQL语句的过程；
 提交（commit）指将未存储的SQL语句结果写入数据库表；
 保留点（savepoint）指事务处理中设置的临时占位符（placeholder），你可以对它发布回退（与回退整个事务处理不同） 



#### 26.2 控制事务处理 

管理事务处理的关键在于将SQL语句组分解为逻辑块，并明确规定数
据何时应该回退，何时不应该回退 

mysql使用下面的语句来标识事务的开始

`start transaction`

##### 26.2.1 使用ROLLBACK 

```
select * from ordertotals;
start transaction;
delete from ordertotals;
select * from ordertotals;
rollback;
select * from ordertotals;
```

这时用一条ROLLBACK语句回退START TRANSACTION之后的所有语句，最后一条SELECT语句显示该表不为空。 

显然， ROLLBACK只能在一个事务处理内使用（在执行一条START
TRANSACTION命令之后）。 

##### 26.2.2 使用COMMIT

一般的mysql语句都是直接针对数据库表执行和编写的,这就是所谓的隐含提交，即提交操作是自动进行的。

但是，在事务处理块中，提交不会隐含地进行 

start transaction;
delete from orderitems where order_num=20007;
delete from orders where order_num = 20007;
commit;

在这个例子中，从系统中完全删除订单20010。因为涉及更新
两个数据库表orders和orderItems，所以使用事务处理块来
保证订单不被部分删除。最后的COMMIT语句仅在不出错时写出更改。如
果第一条DELETE起作用，但第二条失败，则DELETE不会提交（实际上，
它是被自动撤销的）。 



##### 26.2.3 使用保留点 

为了支持回退部分事务处理，必须能在事务处理块中合适的位置放
置占位符。这样，如果需要回退，可以回退到某个占位符。 

这些占位符称为保留点。 

创建占位符

```sql
savepoint delete1;
rollback to delete1;
```

**释放保留点** 保留点在事务处理完成（执行一条ROLLBACK或
COMMIT）后自动释放。自MySQL 5以来，也可以用RELEASE
SAVEPOINT明确地释放保留点。

##### 26.2.4 更改默认的提交行为 

为指示MySQL不自动提交更改，需要使用以下语句 

set autocommit=0;

## 第30章 改善性能

使用EXPLAIN语句让MySQL解释它将如何执行一条SELECT语句。 

决不要检索比需求还要多的数据。换言之，不要用SELECT *（除
非你真正需要每个列）。 

你的SELECT语句中有一系列复杂的OR条件吗？通过使用多条
SELECT语句和连接它们的UNION语句，你能看到极大的性能改
进。 

索引改善数据检索的性能，但损害数据插入、删除和更新的性能。
如果你有一些表，它们收集数据且不经常被搜索，则在有必要之
前不要索引它们。（索引可根据需要添加和删除。） 

LIKE很慢。一般来说，最好是使用FULLTEXT而不是LIKE 



## 补充 （基于java狂神版）

##事务

**事务原则:**ACID原则，原子性，一致性，隔离性，持久性

原子性（Atomicity）
原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。
一致性（Consistency）
事务前后数据的完整性必须保持一致。
隔离性（Isolation）
事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。
持久性（Durability）
持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有任何影响脏读：

**脏读:**指一个事务读取了另外一个事务未提交的数据。

**不可重复读：**

在一个事务内读取表中的某一行数据，多次读取结果不同。（这个不一定是错误，只是某些场合不对）

**虚读(幻读)**

是指在一个事务内读取到了别的事务插入的数据，导致前后读取不一致。



提交事务后就被持久化了

```sql
create database shop character set utf8 collate utf8_general_ci;
use shop;

create table account1 (
	id int(3) not null auto_increment,
    name varchar(30) not null,
    money decimal(9,2) not null,
    primary key (id)
)engine = innodb default charset = utf8;

select * from account1;

use shop;

insert into account1(
name,
money)
value('A',20000.00),
('B',10000.00);

set autocommit = 0;
start transaction;
update account1 set money =money-500 where name ='A';
update account1 set money = money +500 where name='B';
commit;
rollback;
set autocommit = 1;
```

###索引

### 规范数据库设计

数据库里面用下划线命名

中间表？

设计数据库的步骤:

收集信息，分析需求

标识实体

标识实体之间的关系

### 数据库的三大范式

**第一范式（1NF）：要求数据库表的每一列都是不可分割的原子数据项。**

**第二范式（2NF）：在1NF的基础上，非码属性必须完全依赖于候选码（在1NF基础上消除非主属性对主码的部分函数依赖）**

**第二范式需要确保数据库表中的每一列都和主键相关，而不能只与主键的某一部分相关（主要针对联合主键而言）。**

**第三范式（3NF）：在2NF基础上，任何非主属性不依赖于其它非主属性（在2NF基础上消除传递依赖）**

**第三范式需要确保数据表中的每一列数据都和主键直接相关，而不能间接相关。**

![1584346672819](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1584346672819.png)

**规范性和性能的问题**

关联查询的表不得超过三张表

故意给某些表增加一些冗余的字段



### JDBC

#### 数据库驱动

1.加载驱动

2.用户信息和url

3.连接成功，返回数据库对象

4.创建执行SQL的对象

5.执行SQL的对象去执行SQL

6.释放连接

#### 异常

总体概括就是两个异常：

1. Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.

原因：加载类'com.mysql.jdbc.Driver' 已经过时了。新的驱动类是“com.mysql.cj.jdbc.Driver”。驱动程序通过SPI自动注册，而手动加载类通常是不必要的。、

解决方法：1. 使用8.0.13版本的驱动 2.将驱动 com.mysql.jdbc.Driver  改为  com.mysql.cj.jdbc.Driver

jdbc.driver=com.mysql.cj.jdbc.Driver
2. The server time zone value '???ú±ê×??±??' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support. 

原因：服务器时区值“？？？？±××？±？无法识别或代表一个以上的时区。如果希望利用时区支持，则必须配置服务器或JDBC驱动程序（通过serverTimezone配置属性）以使用更具体的时区值。

解决方案：jdbc.url 加上   characterEcoding=utf-8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true

```java
package com.lyy.jdbcTest;

import java.sql.*;

public class jdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/jdbcstudy?characterEcoding=utf-8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username="root";
        String password = "liyuyang";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
        }
        resultSet.close();

        statement.close();
        connection.close();


    }
}

```

```
String url = "jdbc:mysql://localhost:3306/jdbcstudy?characterEcoding=utf-8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
```

```
Connection connection = DriverManager.getConnection(url, username, password);
//connection 代表数据库
//从而数据库设置自动提交
//事务提交
//事务返回
```

```
//Statement 执行sql的对象
 Statement statement = connection.createStatement();
ResultSet resultSet =statement.executeQuery(sql);//执行select
statement.execute();//执行任何sql
statement.executeUpdate();//insert update delete 且返回操作的行数
statement.executeBatch();
```

```
 ResultSet 查询的结果集 封装了所有的查询结果
   ResultSet resultSet = statement.executeQuery(sql);
        resultSet.getObject();
        resultSet.getString();
        resultSet.beforeFirst();//移动到最前面
        resultSet.afterLast();//移动到最后面
        resultSet.next();//移动到下一个
        resultSet.previous();
        resultSet.absolute(row)//移动到指定行
```

记得释放资源



statement对象用于向数据库发送SQL语句

### 提取工具类

老是报错..

记得db.properties不要加;就是分号

### PreparedStatement对象

PreparedStatementk可以防止SQL注入，效率更好

把传递进来的参数当作字符，都会用引号包起来

insert

```java
package com.lyy.lesson3;import com.lyy.lesson2.JdbcUtils;import java.util.*;import java.sql.Connection;import java.sql.Date;import java.sql.PreparedStatement;import java.sql.SQLException;public class insertTest {    public static void main(String[] args) {        Connection conn = null;        PreparedStatement st = null;        try {            conn=JdbcUtils.getConnection();            //使用?占位符代替参数            String sql ="insert into users(id,name,password,email,birthday)values(?,?,?,?,?)";            st= conn.prepareStatement(sql);//需要一个预编译sql，不执行            //手动给参数赋值            st.setInt(1,7);            st.setString(2,"newlyy");            st.setString(3,"123456");            st.setString(4,"318@sina.com");            st.setDate(5,new java.sql.Date(new java.util.Date().getTime()));            int i = st.executeUpdate();            if(i>0){                System.out.println("插入成功");            }        } catch (SQLException e) {            e.printStackTrace();        }finally {            JdbcUtils.release(conn,st,null);        }    }}
```

delete

```java
package com.lyy.lesson3;

import com.lyy.lesson2.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn= JdbcUtils.getConnection();
            //使用?占位符代替参数
            String sql ="delete from users where id =?";
            st= conn.prepareStatement(sql);//需要一个预编译sql，不执行
            //手动给参数赋值
            st.setInt(1,7);

            int i = st.executeUpdate();
            if(i>0){
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}

```

update

```java
package com.lyy.lesson3;

import com.lyy.lesson2.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateTest {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn= JdbcUtils.getConnection();
            //使用?占位符代替参数
            String sql ="update users set password = ? where id=?;";
            st= conn.prepareStatement(sql);//需要一个预编译sql，不执行
            //手动给参数赋值
            st.setInt(2,6);
            st.setString(1,"12345");
            int i = st.executeUpdate();
            if(i>0){
                System.out.println("更改成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}

```

### 使用IDEA连接数据库

IDEA连接mysql又报错！Server returns invalid timezone. Go to 'Advanced' tab and set 'serverTimezone' prope

2，继续输入 show variables like'%time_zone';    （注意不要漏掉后面的分号），回车，如图：

![img](https://img-blog.csdnimg.cn/20191009103216457.png)

显示 SYSTEM 就是没有设置时区啦。

3，现在我们来设置时区。

输入set global time_zone = '+8:00';  注意不要漏掉后面的分号），回车，如图：

![img](https://img-blog.csdnimg.cn/20191009103329355.png)



在schema里面可以选择数据库