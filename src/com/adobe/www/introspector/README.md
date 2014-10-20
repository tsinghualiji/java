##Java内省机制

1).内省(Introspector)是Java 语言对Bean类属性、事件的一种缺省处理方法。例如类 A 中有属性 name, 那我们可以通过 getName,setName 来得到其值或者设置新的值。通过 getName/setName 来访问 name 属性，这就是默认的规则。 

   Java 中提供了一套 API 用来访问某个属性的 getter/setter 方法，通过这些 API 可以使你不需要了解这个规则（但你最好还是要搞清楚），这些 API 存放于包 java.beans 中。

2).直接通过属性的描述器java.beans.PropertyDescriptor类，来访问属性的getter/setter 方法;

    public class Point {     
        private Integer x;     
        private Integer y;     
            
        public Point(Integer x, Integer y) {     
            super();     
            this.x = x;     
            this.y = y;     
        }     
            
       public Integer getX() {     
           return x;     
       }        
       public void setX(Integer x) {     
           this.x = x;     
       }     
           
       public Integer getY() {     
           return y;     
       }      
       public void setY(Integer y) {     
           this.y = y;     
       }     
      }     
       
       import java.beans.PropertyDescriptor;     
       import java.lang.reflect.Method;     
           
       public class Reflect {     
           
       public static void main(String[] args) throws Exception {     
           Point point = new Point(2, 5);     
           String proName = "x";     
           
           getProperty(point, proName);     
           setProperty(point, proName);     
       }     
           
       private static void setProperty(Point point, String proName) throws Exception {     
           PropertyDescriptor proDescriptor = new PropertyDescriptor(proName, Point.class);     
           Method methodSetX = proDescriptor.getWriteMethod();     
           methodSetX.invoke(point, 8);     
           System.out.println(point.getX());// 8     
       }     
           
       private static void getProperty(Point point, String proName) throws Exception {     
           PropertyDescriptor proDescriptor = new PropertyDescriptor(proName, Point.class);     
           Method methodGetX = proDescriptor.getReadMethod();     
           Object objx = methodGetX.invoke(point);     
           System.out.println(objx);// 2     
       }     
      }      

3).通过类 Introspector 来获取某个对象的 BeanInfo 信息，然后通过 BeanInfo 来获取属性的描述器（ PropertyDescriptor ），通过这个属性描述器就可以获取某个属性对应的 getter/setter 方法，然后我们就可以通过反射机制来调用这些方法。

相关代码：
把2中的getProperty()修改成如下形式：

    private static void getProperty(Point point, String proName) throws Exception {     
          BeanInfo beanInfo = Introspector.getBeanInfo(point.getClass());     
          PropertyDescriptor[] proDescriptors = beanInfo.getPropertyDescriptors();     
          for(PropertyDescriptor prop: proDescriptors){     
            if(prop.getName().equals(proName)){     
              Method methodGetx = prop.getReadMethod();     
              System.out.println(methodGetx.invoke(point));//8     
              break;     
            }     
         }     
     }   

4).我们又通常把javabean的实例对象称之为值对象 （Value Object）,因为这些bean中通常只有一些信息字段和存储方法，没有功能性方法。一个JavaBean类可以不当JavaBean用，而当成普通类 用。JavaBean实际就是一种规范，当一个类满足这个规范，这个类就能被其它特定的类调用。一个类被当作javaBean使用时，JavaBean的 属性是根据方法名推断出来的，它根本看不到java类内部的成员变量(javabean的成员变量通常都是私有private的)。

5).除了反射用到的类需要引入外，内省需要引入的类如下所示，它们都属于java.beans包中的类，自己写程序的时候也不能忘了引入相应的包或者类。

    import java.beans.BeanInfo;
    import java.beans.IntrospectionException;
    import java.beans.Introspector;
    import java.beans.PropertyDescriptor;

6).下面讲解一些开源的工具类Beanutils,需要额外下载的，commons-beanutils.jar，要使用它还必须导入commons-logging.jar包，不然会出异常；
相关代码一：

    public static void main(String[] args) throws Exception {     
        Point point = new Point(2, 5);     
        String proName = "x";     
        BeanUtils.setProperty(point, proName, "8");     
        System.out.println(point.getX());// 8     
        System.out.println(BeanUtils.getProperty(point, proName));// 8     
        System.out.println(BeanUtils.getProperty(point, proName).getClass().getName());// java.lang.String     
        
        BeanUtils.setProperty(point, proName, 8);     
       System.out.println(BeanUtils.getProperty(point, proName).getClass().getName());// java.lang.String     
   }     
   //我们看到虽然属性x的类型是Integer，但是我们设置的时候无论是Integer还是String，BeanUtils的内部都是当成String来处理的。  

相关代码二：
BeanUtils支持javabean属性的级联操作；

    public static void main(String[] args) throws Exception {     
        Point point = new Point(2, 5);//在point中加一个属性 private Date birth = new Date();并产生setter/getter方法     
        String proName = "birth";     
        Date date= new Date();     
        date.setTime(10000);     
        BeanUtils.setProperty(point, proName, date);     
        System.out.println(BeanUtils.getProperty(point, proName));     
             
        BeanUtils.setProperty(point, "birth.time", 10000);     
        System.out.println(BeanUtils.getProperty(point, "birth.time"));//10000     
    }

//之所以可以 BeanUtils.setProperty(point, "birth.time", 10000);这样写，那是因为Date类中有getTime()和setTime()方法，即Date类中相当于有time这个属性。   

相关代码三：
BeanUtils和PropertyUtils对比：

    public static void main(String[] args) throws Exception {     
        Point point = new Point(2, 5);     
        String proName = "x";     
        BeanUtils.setProperty(point, proName, "8");     
        System.out.println(BeanUtils.getProperty(point, proName));//8     
        System.out.println(BeanUtils.getProperty(point, proName).getClass().getName());//java.lang.String     
             
    // PropertyUtils.setProperty(point, proName, "8");//exception:argument type mismatch     
        PropertyUtils.setProperty(point, proName, 8);     
        System.out.println(PropertyUtils.getProperty(point, proName));//8     
        System.out.println(PropertyUtils.getProperty(point, proName).getClass().getName());//java.lang.Integer     
    }     
//BeanUtils它以字符串的形式对javabean进行转换，而PropertyUtils是以原本的类型对javabean进行操作。如果类型不对，就会有argument type mismatch异常。  

6).理解了相应的原理，那些现成的工具用起来就会更舒服，如Beanutils与 PropertyUtils工具。这两个工具设置属性的时候一个主要区别是PropertyUtils.getPropety方法获得的属性值的类型为该 属性本来的类型，而BeanUtils.getProperty则是将该属性的值转换成字符串后才返回。

##总结

Web 开发框架 Struts 中的 FormBean 就是通过内省机制来将表单中的数据映射到类的属性上，因此要求 FormBean 的每个属性要有 getter/setter 方法。但也并不总是这样，什么意思呢？就是说对一个 Bean 类来讲，我可以没有属性，但是只要有 getter/setter 方法中的其中一个，那么 Java 的内省机制就会认为存在一个属性，比如类中有方法 setMobile ，那么就认为存在一个 mobile 的属性。

将 Java 的反射以及内省应用到程序设计中去可以大大的提供程序的智能化和可扩展性。有很多项目都是采取这两种技术来实现其核心功能，例如我们前面提到的 Struts ，还有用于处理 XML 文件的 Digester 项目，其实应该说几乎所有的项目都或多或少的采用这两种技术。在实际应用过程中二者要相互结合方能发挥真正的智能化以及高度可扩展性。