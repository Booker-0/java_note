# JAVA

可以把一条语句写在多行上

object.method(parameters)//等价于函数调用

println输出换行　print输出不换行

在声明一个变量之后，必须用赋值语句对变量进行显式初始化

#### 常量

利用关键字final来指示常量，例如

final double CM_PER_INCH = 2.54

习惯上常量名使用全大写

可以使用关键字static final设置一个类常量

需要在main外面，同时是用于给一个类中的多个方法中使用

如果一个常量被声明为public，那么其他类的方法也可以使用这个常量｀



```java
>>>运算符将用0填充高位，>>运算符用符号位填充高位
```

```java
double y =Math.pow(x,a)
//x的a次幂
   import static java.lang.Math.*//从而不用写Math.
```

**子串**

```java
String greeting = "Hello"

String s = greeting.substring(0,3);

//不想复制的第一个位置
```

**拼接**　+

检测字符串是否相等 s.equals(t)

不能用==

**代码点与代码单元**

**构建字符串**

字符串构建器

```java
StringBuilder builder = new StringBuiler();
builder.append(ch);
builder.append(str);
String completedString =builder.toString();
```



#### 输入输出

```java
Scanner in = new Scanner(System.in);
String name =in.nextLine();//读取一行
String firstName = in.next();//读取一个单词
int age = in.nextInt();
```

读取密码用Console类

**格式化输出**

基本跟C语言一样

**文件输入与输出**

Scanner in = new Scanner(Paths.get("myfile.txt"));

#### 控制流程

不能在嵌套的两个块中声明同名的变量

带标签的break　只能跳出语句块不能进入语句块

**大数**

**数组**

```java
int[] a=new int[100];
```

for each循环

for (variable : collection) statement

想打印数组可以调用

```java
System.out.println(Arrays.toString(a));
```

数组直接赋值对应的是引用

要完全拷贝需要使用Arrays.copyOf(luckyNumbers,luckyNumbers.length);

分配在堆上

```java
public static void main(String[] args)
    //程序名不在args中
Math.random()将返回一个0到1之间的随机浮点数
int r =(int)(Math.random()*n);
```

## 对象与类

#### 类之间的关系

依赖　聚合　继承

对象变量和对象区别

Datee deadline//对象变量

局部变量不会自动地初始化为null,而必须通过调用new或将它们设置为null进行初始化

更改器方法　对实例域做出修改的方法

访问器方法　仅访问实例域而不进行修改的方法

### 用户自定义类

在一个源文件中，只能有一个公有类但可以有任意树木的非公有类

构造器

**多个源文件的使用**

![1582251415828](/home/lyy/.config/Typora/typora-user-images/1582251415828.png)

![1582251477979](/home/lyy/.config/Typora/typora-user-images/1582251477979.png)

![1582251558009](/home/lyy/.config/Typora/typora-user-images/1582251558009.png)

所有的方法都必须在类的内部定义

注意不要编写返回引用可变对象的访问器方法

![1582251924383](/home/lyy/.config/Typora/typora-user-images/1582251924383.png)

#### 4.3.9 final实例域

即必须要初始化这样的域

![1583078950833](/home/lyy/.config/Typora/typora-user-images/1583078950833.png)

#### 4.4 静态域与静态方法

**静态变量**

如果将域定义为static，每个类中只有一个这样的域，如果有1000个Employee类的对象，则有1000个实例域id，但只有一个静态域nextId

**静态常量**

虽然是public但是是final修饰,而且不用通过类的对象来方向可以直接用类名.常量来使用

public static final double PI

**静态方法**

静态方法是一种不能向对象实施操作的方法,不使用任何对象,没有隐式参数,不能使用this，不能访问实例域，但是可以访问静态域

![1582254845545](/home/lyy/.config/Typora/typora-user-images/1582254845545.png)

static属于类且不属于类对象的变量和函数

#### 4.3.7　基于类的访问权限

一个方法可以访问所属类的所有对象的私有数据



#### 4.3.8 私有方法



#### 方法参数

![1582255872143](/home/lyy/.config/Typora/typora-user-images/1582255872143.png)

![1582256145689](/home/lyy/.config/Typora/typora-user-images/1582256145689.png)

#### 重载

![1582256720644](/home/lyy/.config/Typora/typora-user-images/1582256720644.png)

如果在编写一个类的时候没有提供构造器，则系统会提供一个无参数构造器

![1582301810149](/home/lyy/.config/Typora/typora-user-images/1582301810149.png)

可在参数名前面加a然后和类的成员参数名字一样如aName

**调用另外一个构造器**

```java
public Employee(double s)
{
    this("Employee #"+nextId,s);
    nextId++;
}
```

**初始化块**

只要构造类的对象，这些块就会被执行

```java
//返回一个0到10000的随机整数
static{
    Random generator = new Random();//构造一个新的随机数生成器
    nextId = generator.nextId(10000);
}
```

### 包

![1582306447286](/home/lyy/.config/Typora/typora-user-images/1582306447286.png)

Java编译器可以查看其他文件的内部

**包作用域**

![1582307250359](/home/lyy/.config/Typora/typora-user-images/1582307250359.png)

#### 类路径

![1582309123867](/home/lyy/.config/Typora/typora-user-images/1582309123867.png)



## 继承

![1582309850259](/home/lyy/.config/Typora/typora-user-images/1582309850259.png)

用super解决这个问题

```java
public double getSalary()
{
    double baseSalary = super.getSalary();
    return base+bonus;
}
```

super只是一个指示编译器调用超类方法的特殊关键字

```java
public Manager(String n,double s,int year,int month,int day)
{
    super(n,s,year,month,day);
    bonus=0;
}
/*
由于Manager类的构造器不能访问Employee类的私有域，所以必须利用Employee类的构造器来对这部分私有域进行初始化，我们可以通过super实现对超类构造器的调用，且子类构造器的第一句必须是这个
*/
```

多态 一个对象变量可以指示多种实际类型的现象

超类应用可以引用子类的应用

动态绑定:在运行时能够自动地选择调用哪个方法的现象.

超类的私有方法不可访问

方法表

在覆盖一个方法的时候，子类方法不能低于超类方法的可见性

**final类**：不允许扩展的类

final class Executive extends Manager

不允许覆盖的方法　public final String getName()

#### 对象的强制类型转换

Manager boss =(Manager) staff[0];

在暂时忽视对象的实际类型后，使用对象的全部功能

将一个超类的引用赋给一个子类变量,必须进行类型转换

instanceof运算符?

#### 抽象类

抽象类不能被实例化如new Person("Jack");

包含抽象方法的类本身必须被声明为抽象的

一般不包括具体方法，不过可以

但是可以定义一个抽象类的对象变量

```java
Person[] people = new Person[2];
```



**StringBuffer**

StringBuffer代表了一个字符序列可变的字符串，当一个StringBuffer被创建后，通过StringBuffer提供的append()、insert()、reverse()、setCharAt()、setLength()等方法可以改变这个字符串对象的字符序列。一旦通过StringBuffer生成了最终想要的字符串，就可以调用它的toString()方法将其转换为一个String对象。

**StringBuilder**

tringBuilder类也代表可变字符串对象。实际上，StringBuilder和StringBuffer基本相似，两个类的构造器和方法也基本相同。不同的是：**StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。**



构造器能初始化私有成员

private 仅对本类可见

public 对所有类可见

protected　对本包和所有子类可见

默认　对本包可见

### Object:所有类的超类

所有的数组类型，不管是对象数组还是基本类型的数组都扩展于Object类

Object obj=new Employee("Harry Hacker",35000);

Employee e=(Employee)obj;

#### 1.equals方法

##### getClass获取类名



在Object类中的equals方法用于检测一个对象是否等于另外一个对象,即这方法将判断两个对象是否具有相同的引用

String类型要用equals来比较，目的是为了防止为null的情况　两个都为null则返回true，若一个为null则返回false

a.equals(b)等价于Object.equals(a,b)

![1582490082409](/home/lyy/.config/Typora/typora-user-images/1582490082409.png)

#### 2.hashCode方法　没看

#### 3.toString方法

如果x是任意一个对象，并调用

System.out.println(x);

println方法会直接地调用x.toString(),并打印输出得到的字符串

Object类定义了toString方法，用来打印输出对象所属的类名和散列码

打印数组String s =Arrays.toString(luckyNumbers);

多维是Arrays.deepToString();

##### instanceof

它的作用是判断其左边对象是否为其右边类的实例，返回boolean类型的数据。可以用来判断[继承](https://baike.baidu.com/item/继承/2261239)中的子类的实例是否为父类的实现。

boolean result =object instanceof class



### 泛型数组列表

在java中允许在运行时确定数组的大小

ArrayList是一个采用类型参数的泛型类

```java
ArrayList<Employee> staff = new ArrayList<>();
ArrayList<Employee> staff = new ArrayList<>(100);//传递初始容量
```

使用add方法可以将元素添加到数组列表中

ensureCapacity方法

size方法将返回数组列表中包含的实际元素

trimToSize方法　回收多余的存储空间，将大小调整为当前元素数量所需要的存储空间数目

#### 5.3.1　访问数组列表元素

staff.set(i,harry);//等价于a[i]= harry;只有add后才能进行get和set操作

Employee e = staff.get(i);

又扩展数组又能方便访问元素

```java
ArrayList<X> list=new ArrayList<>();
while(...)
{
    x = ...;
    list.add(x);
}
X[] a=new X[list.size()];
list.toArray(a);
```

在数组列表中增加新元素

```java
int n= staff.size()/2;
staff.add(n,e);//在n处加入元素e，n后的都要往后挪
//删去数组列表中的元素
Employee e = staff,remove(n);
```

可以用for each循环遍历数组列表

for (Employee e : staff)

 do something with e



### 5.4 对象包装器与自动装箱

数组列表的尖括号不允许是基本类型，所以像int这种要用Integer类来实现

alueOf() 方法用于返回给定参数的原生 Number 对象值，参数可以是原生数据类型, String等。

该方法是静态方法。该方法可以接收两个参数一个是字符串，一个是基数。

对象包装器需要用equals方法来比较



##### 将数字字符串转换成数值

int a = Integer.parseInt(s);

![1582756908751](/home/lyy/.config/Typora/typora-user-images/1582756908751.png)

**valueOf方法**

### 语法

该方法有以下几种语法格式：

```
static Integer valueOf(int i)
static Integer valueOf(String s)
static Integer valueOf(String s, int radix)
```

### 参数

- **i** -- Integer 对象的整数。
- **s** -- Integer 对象的字符串。
- **radix** --在解析字符串 s 时使用的进制数，用于指定使用的进制数。

### 返回值

- **Integer valueOf(int i)：**返回一个表示指定的 int 值的 Integer 实例。
- **Integer valueOf(String s):**返回保存指定的 String 的值的 Integer 对象。
- **Integer valueOf(String s, int radix):** 返回一个 Integer 对象，该对象中保存了用第二个参数提供的基数进行解析时从指定的 String 中提取的值。



### 可变参数方法



``` java
public static double max(double... values)
{
    double largest=Double.MIN_VALUE;
    for(double v:values)if(v>largest)largest=v;
    return v;
}
//可以像以下方法进行调用
double m = max(3,1,40.4,-5);

```

### 5.6　枚举类

public enum Size {SMALL,MEDIUM,LARGE,EXTRA_LARGE};

//定义枚举类型

直接使用"=="来比较值

Size.SMALL.toString()将返回字符串"SMALL"

逆方法SIize s= Enum.valesOf(Size.class,"SMALL");

将s设置成Size.SMALL

![1582762430215](/home/lyy/.config/Typora/typora-user-images/1582762430215.png)

![1582762449451](/home/lyy/.config/Typora/typora-user-images/1582762449451.png)

![1582763841488](/home/lyy/.config/Typora/typora-user-images/1582763841488.png)

### 5.7 反射



## 第六章　接口与内部类

#### 6.1 接口

接口不是类，而是对类的一组需求描述，这些类要遵从接口描述的统一格式进行定义

![1582768698192](/home/lyy/.config/Typora/typora-user-images/1582768698192.png)

为了让类实现一个接口，通常需要下面两个步骤

1.将类声明为实现给定的接口。

2.对接口中的所有方法进行定义

![1582768528417](/home/lyy/.config/Typora/typora-user-images/1582768528417.png)

public int compareTo(Object otheObject)

{

Employee other = (Employee) otherObject;

return Double.compare(salary,other.salary);

}

![1582769162652](/home/lyy/.config/Typora/typora-user-images/1582769162652.png)

不能构造接口的对象，却能声明接口的变量

Comparable x;

接口变量必须引用实现了接口的类对象：

x=new Employee(...);

可以使用instanceof检查一个对象是否实现了某个特定的接口

if(anObject instanceof Comparable){}

**接口也能扩展**

接口中的方法都被自动地设置为public，而域设置为public static final



### ![1582770947676](/home/lyy/.config/Typora/typora-user-images/1582770947676.png)

#### 6.1.2 接口与抽象类

java不允许多继承所以需要接口

### 对象克隆

![1582771249991](/home/lyy/.config/Typora/typora-user-images/1582771249991.png)

默认的克隆操作是浅拷贝，它并没有克隆包含在对象中的内部对象,而是引用

String是个类，所以clone操作也只是引用,但是是不允许改变的

需要重新定义clone方法来实现深拷贝

clone方法默认是protected修饰	

![1582771510677](/home/lyy/.config/Typora/typora-user-images/1582771510677.png)

没有实现Cloneable接口，就会产生一个已检验异常

即使clone的默认实现(浅拷贝)能够满足需求。也应该实现Cloneable接口,将clone重定义为public,并调用super.clone().

![1582773329186](/home/lyy/.config/Typora/typora-user-images/1582773329186.png)

### 6.3 接口与回调



### 6.4 内部类



## 第11章　异常,断言,日志和调试

### 11.1 处理错误

异常处理的任务就是将控制权从错误产生的地方转移给能够处理这种情况的错误处理器.

#### 11.1.1　异常分类

![1583117389946](/home/lyy/.config/Typora/typora-user-images/1583117389946.png)

异常对象都是派生于Throwable类的一个实例.

由程序错误导致的异常属于RuntimeException

而程序本身没有问题,但由于像I/O错误这类问题导致的异常属于其他异常



派生于RuntimeException的异常包含下面几种情况:

错误的类型转换

数组访问越界

访问空指针



不是派生于RntimeException的异常包括:

试图在文件尾部后面读取数据

试图打开一个不存在的文件

试图根据给定的字符串查找Class对象,而这个字符串表示的类并不存在



**未检查异常**

Error类或RuntimeException类的所有异常

**已检查异常** 所有其他的异常



#### 11.1.2　声明已检查异常

不需要声明Java的内部错误，即从Error继承的错误.

任何程序都具有抛出那些异常的潜能

也不应该声明从RuntimeException继承的那些未检查异常

一个方法必须声明所有可能抛出的已检查异常

通过在方法声明后throws 异常名来实现

#### 11.1.3 如何抛出异常

对于一个已经存在的异常类,将其抛出非常容易.在这种情况下:

找到一个合适的异常类

创建这个类的一个对象

将对象抛出

```java
String readData(Scanner in)throws EOFException
{
	...
	while(...)
	{
		if(!in.hasNext())
		{
			if(n<len)
				throw new EOFException();
		}
		...
	}
	return s;
}
```



#### 11.1.4　创建异常类

　在遇到任何标准异常类都没有能够充分地描述清楚的问题．

**做法:**定义一个派生于Exception的类，或者派生于Exception子类的类.

定义的类应该包含两个构造器,一个是默认的构造器;另一个是带有详细描述信息的构造器

然后再抛出这个异常类的对象

### 7.2 捕获异常

​	如果某个异常发生的时候没有在任何地方进行捕获,那程序就会终止执行,并在控制台上打印出异常信息．其中包括异常的类型和堆栈的内容.

​	**try语句块**

try

{

​	

}

catch(Exception e)

{

}　

如果在try语句块中的任何代码抛出了一个在catch子句中说明的异常类,那么

1. 程序将跳过try语句块的其余代码

2. 程序将执行catch子句中的处理器代码

   如果在try语句块中的代码没有抛出任何异常,那么程序将跳过catch子句.

   如果方法中的任何代码抛出了一个在catch子句中没有声明的异常类型.那么这个方法就会立刻退出

   通常是什么也不做

   应该捕获那些知道如何处理的异常,而将那些不知道怎么样处理的异常继续进行传递

   #### 7.2.2 捕获多个异常

   ```java
   try
   {
       
   }
   catch ()
   {
       
   }
   catch ()
   {
       
   }
   catch(FileNotFoundException｜UnknownHostException e)
   {
       
   }
   ```

   e.getMessage();//获得异常更多信息

   #### 7.2.3 再次抛出异常与异常链

   在catch子句中可以抛出一个异常,这样做的目的是改变异常的类型

   有时可能只想记录一个异常,再将它重新抛出,而不做任何改变

   ```java
   try
   {
       
   }
   catch (Exception e)
   {
       logger.log(level,message,e);
       throw e;
   }
   ```

   包装技术,可以让用户抛出子系统中的高级异常,而不会丢失原始异常的细节

   ```java
   try
   {
       access the database
   }
   catch (SQLException e)
   {
       Throwable se = new ServetException("database error");
       se.initCause(e);
       throw se;
   }
   
   class A{
       try{
           ...
       }catch(AException a){
           BException b = new BEexception()；
           b.initCause(a);
           throw b;
       }
   }
   ...
   class B{
       try{
           ...
       }catch(BException b){
           //什么导致了b呢？
           b.getCause()；//得到导致B异常的原始异常
       }
   }
   ```

   Throwable e = se.getCasue();就可以重新得到原始异常

   不是为了实现哪一句代码的。initCause()这个方法就是对异常来进行包装的，目的就是为了出了问题的时候能够追根究底。因为一个项目，越往底层，可能抛出的异常类型会用很多，如果你在上层想要处理这些异常，你就需要挨个的写很多catch语句块来捕捉异常，这样是很麻烦的。如果我们对底层抛出的异常捕获后，抛出一个新的统一的异常，会避免这个问题。但是直接抛出一个新的异常，会让最原始的异常信息丢失，这样不利于排查问题。举个例子，在底层会出现一个A异常，然后在中间代码层捕获A异常，对上层抛出一个B异常。如果在中间代码层不对A进行包装，在上层代码捕捉到B异常后就不知道为什么会导致B异常的发生，但是包装以后我们就可以用getCause()方法获得原始的A异常。这对追查BUG是很有利的。



#### 11.2.4 finally子句

​	Java中如何恰当地关闭一个文件

​	不管是否有异常被捕获,finally子句中的代码都被执行

```java
InputStream in = new FileInputStream(...);
try
{
    
}
catch(IOException e)
{
    show error message
}
finally
{
    in.close();
}
```

在上面这段代码中, 有下列 3 种情况会执行 finally 子句 :
1 ) 代码没有抛出异常 。 在这种情况下, 程序首先执行 try 语句块中的全部代码 , 然后执
行 finally 子句中的代码 t 随后, 继续执行 try 语句块之后的第一条语句 。 也就是说 , 执行标
注的 1 、 2 、 5 、 6 处 。
2 ) 抛出一个在 catch 子句中捕获的异常 。 在上面的示例中就是 IOException 异常 。 在这种
情况下, 程序将执行 try 语句块中的所有代码, 直到发生异常为止 。 此时, 将跳过 try 语句块中
的剩余代码, 转去执行与该异常匹配的 catch 子句中的代码 , 最后执行 finally 子句中的代码 。
如果 catch 子句没有抛出异常, 程序将执行 try 语句块之后的第一条语句 。 在这里 , 执行
标注 1 、 3 、 4 、 5 、 6 处的语句 。
如果 catch 子句抛出了一个异常 , 异常将被抛回这个方法的调用者 。 在这里 , 执行标注
1 、 3 、 5 处的语句 。
3 ) 代码抛出了一个异常, 但这个异常不是由 catch 子句捕获的 。 在这种情况下 , 程序将
执行 try 语句块中的所有语句, 直到有异常被抛出为止 。 此时, 将跳过 try 语句块中的剩余代
码, 然后执行 finally 子句中的语句, 并将异常抛给这个方法的调用者 。 在这里 , 执行标注 1 、
5 处的语句 。

#### 11.2.5 带资源的try语句



## 第12章　泛型程序设计

泛型提供一个更好的解决方案:类型参数.ArrayList类有一个类型参数用来指示元素的类型

编译器因此能知道参数类型

### 12.2 定义简单泛型类

```
public class Pair<T>
{
    private T second;
    private T first;
    public Pair(){first=null;second=null;}
    public Pair(T first,T second){this.first=first;this.second=second;}
    public T getFirst(){return first;}
    public T getSecond(){return second;}
    public void setFirst(T newValue){first=newValue;}
    public void setSecond(T newValue){second=newValue;}
}
```

### 12.3　泛型方法

泛型方法可以定义在普通类中定义，也可以定义在泛型类中

带泛型参数

```java
class ArrayAlg
{
    //<T>指明这是泛型方法
    public static <T> T getMiddle(T...a)
    {
        return a[a.length/2];
    }
}
//调用
String middle = ArrayAlg.<String>getMiddle("John","Q.","public");

```

### 12.4 类型变量的限定



## 第13章　集合

#### 13.1.1 将集合的接口与实现分离

#### 13.1.2 Java类库中的集合接口与迭代器接口

```java
public interface Collection<E>
{
	boolean add(E element);//确实改变了则返回true，集合中不允许有重复的对象
	Iterator<E> iterator();
}
```

1.迭代器

Iterator接口包含了3个方法:

public interface Iterator<E>

{

​	E next();

​	boolean hasNext();

​	void remove();

}

删除元素

Iterator接口的remove方法将会删除上次调用next方法时返回的元素

```java
//删除字符串集合中第一个元素
Iterator<String> it=c.iterator();
it.next();
it.remove();
```

迭代器可以认为在两个元素之间

![1582921868038](/home/lyy/.config/Typora/typora-user-images/1582921868038.png)

### 13.2 具体的集合

链表

listIterator迭代器

相比Iterator迭代器增加了add方法

add方法在迭代器位置之前添加一个新对象

是迭代器操作set方法用一个新元素取代调用next或previous方法返回的上一个元素

如果迭代器发现它的集合被另一个迭代器修改了，或是被该集合自身的方法修改了，就会抛出一个异常

通过集合设置跟踪改写操作的次数。每个迭代器都维护一个独立的计数值。在每个迭代器方法的开始处检查自己改写操作的计数值是否与集合的改写操作计数值一致来检测**并发修改**问题

**告之当前位置的索引**

迭代器方法:nextIndex和previousIndex

list.listIterator(n)将返回一个迭代器,这个迭代器指向索引为n的元素前面的位置.也就是说,调用next与调用;ost.get(n)会产生同一个元素

List接口 get和set方法不适用于链表

![1582940294592](/home/lyy/.config/Typora/typora-user-images/1582940294592.png)

![1582940304388](/home/lyy/.config/Typora/typora-user-images/1582940304388.png)

![1582940322419](/home/lyy/.config/Typora/typora-user-images/1582940322419.png)

ArrayList方法不是同步的



#### 13.2.3 散列集

​	能快速查找元素的数据结构

**散列码**:散列表为每个对象计算一个整数

散列码是由对象的实例域产生的一个整数

String类的hashCode方法产生的

注意自己实现的hashCode1方法应该与equals方法兼容，即a.equal(b)为true,a与b必须具有相同的散列码

在java中,散列表用链表数组实现，每个列表被称为桶

set是没有重复元素的元素集合.

只有不关心集合中元素的顺序时才应该使用HashSet

HashSet的add方法首先会在集中查找要添加的对象,如果不存在，才将这个对象添加进去

contain方法快速查找是否	某元素已经出现在集中



#### 13.2.4 树集

树集是一个有序集合.可以以任意顺序将元素插入到集合中。每个值将自动第按照排序后的顺序呈现

通过红黑树实现

#### 13.2.5　对象的比较



#### 13.2.8　映射表

Hashmap

散列映射表对键进行散列，树映射表用键的整体顺序对元素进行排序，并将其组织成搜索树

```java
Map<String,Employee> staff = new Hashmap<>();
Employee harry = new Employee("Harry Hacker");
staff.put("987-98-9996",harry);
```

put将返回这个键参数存储的上一个值

每当往映射表中添加对象时，必须同时提供一个键。

要想检索一个对象，必须提供一个键

```java
String s ="987-98-9996"
e=staff.get(s);//gets harry
```

![1583007254466](/home/lyy/.config/Typora/typora-user-images/1583007254466.png)

Map.Entry 是Map中的一个接口，他的用途是表示一个映射项



## 第14章　多线程



子类中实现覆盖？接口实例化？

子类中使用super.方法来调用



## 组合模式



## 反射

我们可以利用反射机制来获得类似动态语言的特性

![1583670066572](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583670066572.png)

反射机制允许程序在执行期借助于Reflection API来取得任何类的内部信息,

并能直接操作任意对象的内部属性及方法

![1583672232087](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583672232087.png)

优点:可以实现动态创建对象和编译,体现出很大的灵活性

缺点:对性能有影响.使用反射基本上是一种解释操作，但是这类操作总是慢于直接执行相同操作

一个类在内存中只有一个class对象

一个类被加载后,类的整个结构都会被封装在Class对象中

类的整个结构包括某个类的属性,方法和构造器

一个Class对象对应的是一个加载到JVM中的一个class文件

### Class常用的方法

![1583675452332](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583675452332.png)

### 获取Class类的实例

```java
Class clazz = Person.class;
Class clazz = person.getClass();
Class clazz = Class.forName("demo01,Student");
```

![1583676017951](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583676017951.png)

### 所有类型的Class对象

![1583677331181](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583677331181.png)

只要元素类型与维度一样,就是同一个Class

### 类加载内存分析

![1583677653091](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583677653091.png)

![1583678194659](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583678194659.png)

![1583678355946](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583678355946.png)

静态代码快和静态变量的执行先后顺序取决于代码编写的顺序

example解释

1.加载到内存,会产生一个类对应Class对象

2.链接 链接结束后m=0

3.初始化

<clinit>(){

​	System.out.println("");

m=300;

m=100;

} 

m=100;//合并了

### 分析类的初始化

#### 什么时候会发生类的初始化

![1583679281062](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583679281062.png)

触发主动引用的不同情况只会初始化一次

上述操作在初始化阶段才实现

### 类加载器的作用

![1583680454193](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583680454193.png)

![1583680618113](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583680618113.png)

```java
 System.out.println(System.getProperty("java.class.path"));
```

如何获得系统类加载器可以加载的路径

**双亲委派机制**

用于检测安全性，保证自己写的类不和根类重复



### 创建运行时类的对象

```java
package com.lyy.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.lyy.reflection.User");
        User user = new User();
        c1=user.getClass();
        System.out.println(c1.getName());//获得包名加类名
        System.out.println(c1.getSimpleName());//获得类名
        //获得类的属性
        //Field[] fields = c1.getFields();//不能获得私有变量,需要getDeclaredFields
        Field[] fields = c1.getDeclaredFields();//获得全部属性
        for (Field field : fields
             ) {
            System.out.println(field);
        }
        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
        //获得类的方法
        Method[] methods = c1.getMethods();//获得本类和父类的所有public方法
        for (Method method:methods
             ) {
            System.out.println(method);
        }
        System.out.println("");
        methods = c1.getDeclaredMethods();//本类的所有方法
        for (Method method:methods
        ) {
            System.out.println(method);

        }
        //获得指定方法
        Method getName = c1.getMethod("getName");
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);
        //获得构造器
    }

}
`
```

### 动态创建对象执行

![1583721260511](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583721260511.png)

**Java9 Class类 newInstance 过时**

```
Class.forName("类的全限定名").newInstance();
1
```

被替换为

```java
Class.forName("类的全限定名").getDeclaredConstructor().newInstance();
```

```java
package com.lyy.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.lyy.reflection.User");
        User user = (User) c1.newInstance();//不推荐使用？
        System.out.println(user);
        //推荐方式

        //通过反射获取一个方法
        User user1 =(User)c1.getDeclaredConstructor(String.class,int.class,int.class).newInstance("lyy",2017,18);
        System.out.println(user1);
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user1,"newlyy");//("对象,方法的值)
        System.out.println(user1);

        System.out.println("");
        Field name=c1.getDeclaredField("name");
        //不能直接操作私有属性，需要关闭安全检测
        name.setAccessible(true);//设置是否可以访问直接set是没用权限的,true为可访问
        name.set(user1,"newlyy1");
        System.out.println(user1);
    }


}

```

![1583722698474](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583722698474.png)

![1583722780585](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583722780585.png)

### 性能对比分析

```java
获取运行时间
long startTime = System.currentTimeMills();
long endTime = System.currentTimeMills();
System.out.println(endTime-startTime+"ms");
```

![1583723201844](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583723201844.png)

结论:频繁执行的反射代码建议关闭安全性检查

### 反射操作泛型

![1583724947185](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583724947185.png)

### 反射操作注解

![1583725541553](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1583725541553.png)

### 什么是注解



### 内置注解



### 元注解



### 自定义注解



## IDEA

ctrl alt u可生成class的uml图

event log调出？点击左下角可以调出

upd快捷打出update

### IDEA操作事务

