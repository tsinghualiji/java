##泛型
- 泛型的简单运用和意义
- 泛型的上限与下限
- 泛型和子类继承的限制
- 泛型类和泛型方法
- 泛型嵌套和泛型擦除

问题：使用TreeSet的时候,只能存放同一种数据类型,可惜存了不同的数据类型,依然没有报错,可是运行时出错

- 什么是泛型:
    1. java5开始出现的一种对Java语言类型的一种拓展,以支持创建可以按类型进行参数化的类可以把类型参数看作是使用参数类型时指定的类型占位符,就好比方法的形式参数是实际参数的占位符一样.泛型能保证大型应用程序的类型安全和良好的维护性;

- 使用泛型的优势:
    1. 类型安全,使编译器对泛型定义的类型做判断限制如保证TreeSet里的元素类型必须一致;消除强制类型的转换,如,使用Comparable比较时每次都需要类型强转

##泛型类

- 在类声明时通过一个标识符表示类中某个字段的类型或者某个方法的返回值或参数的类型，这样在类声明或实例化的时候只要指定自己需要的类型就行声明带泛型的类:

    class 类名<泛型类型1,泛型类型2……>{
        泛型类型  变量名；
        泛型类型  方法名(){}
        返回值类型 方法名(泛型类型 变量名){}
    }
    使用带泛型的类：
    类名<具体类> 对象名 = new 类名<具体类>();

- 泛型规范：
    类型参数规范：推荐使用规范-常见的泛型,泛型只保存在源文件中,class文件中不存在;也就是说在编译阶段就会丢失,基本数据类型不能作为泛型类型;
    K     键，比如映射的键  key的类型
    V    值，比如Map的值 value类型
    E    元素，比如Set<E>  Element表示元素,元素的类型
    T     泛型，Type的意思

- 声明多个泛型类型
    若一个类中多个字段需要不同的泛型声明，则在声明类的时候指定多个泛型类型即可
    public interface IDAO<PK, T> {
        PK add(T t);  
        void remove(PK id);  
        void update(PK id, T t);    
        T get(PK id);    
    }    

##泛型的上限与下限

- 设置泛型对象的上限使用extends,表示参数类型只能是该类型或该类型的子类
    1. 声明对象：类名<? extends 类> 对象名
    1. 定义类：类名<泛型标签 extends 类>{}

- 设置泛型对象的下限使用super,表示参数类型只能是该类型或该类型的父类
    1. 声明对象：类名<? super 类> 对象名称
    2. 定义类：类名<泛型标签 extends类>{}

    public static void  show(List<? extends Number> l){    
    }    
    public static void  show(List<? super String> l){    
    }    

##泛型和子类继承的限制

- 对象的多态性，我们可以
    1. 父类  对象 = new  子类();
- 但是在父类泛型类型和子泛型类型之间不存在这种关系：
    1. 类<Number> 对象 = new 类<Integer>();×

    Object obj = new Person();√    
    Person<Object> p = new Person<String>();×    

##泛型接口

- java5后，可以声明泛型接口，声明方式和声明泛型类是一样的。
    1. public interface IDAO<T>{}    
- 泛型接口子类有两种方式：
    1. 直接在子类后申明泛型；
    1. 在子类实现的接口中给出具体的泛型类型

    public class DaoImpl<T> implements IDAO<T>{}    
    public class DaoImpl implements IDAO<String> {}    

##泛型方法
- 方法中可定义泛型参数，形参的参数类型就是实参的类型。
- 格式：
    <泛型标签> 返回值类型 方法名([泛型标签 参数]...)

    public static <T> T show(T param){    
        return param;    
    }    

##泛型的嵌套

- 可以从一个类的泛型中指向另一个类的泛型

    public class Demo{
        public static void main(String[] args) {    
            Map<String,String> map = new HashMap<>();    
            map.put("1", "A");     
            map.put("2", "B");     
            map.put("3", "C");     
            map.put("4", "D");     
        Set<Map.Entry<String, String>>  set = map.entrySet();     
        Iterator<Map.Entry<String, String>> it = set.iterator();     
        while(it.hasNext()) {     
            Map.Entry<String, String> entry = it.next();     
    System.out.println(entry.getKey() +"-->" + entry.getValue());     
            }     
        }     
    }     
  
##泛型的擦除

- 在严格的泛型代码里，带泛型声明的类总应该带着类型参数。但是为了和老的Java代码保持一致，也允许在使用带泛型声明的类时不指定类型参数，若没有为这个泛型类指定类型参数则该类型参数被称做一个原始类型，默认是该声明参数时指定的最上限类型；
- 当把一个具有泛型信息的对象赋给另一个没有泛型信息的变量时，则所有在尖括号之间的类型信息都被扔掉。
比如List<String> 类型转换成List，则该List对集合元素的类型检查变成了变量的上限即Object。
    class Num<T extends Number>{    
        private T t;    
        public Num(T t) {    
            this.t = t;    
        }    
        。。。。getter/setter。。。。    
    }
    public class Demo {    
        public static void main(String[] args) {    
            Num<Integer> n = new Num<>(5);    
            Integer i = n.getT();    
            Num n2 = n;//会丢掉泛型信息    
            Number num = ();    
            //Integer i = n2.gn2.getTetT();    
        }    
    }    
        
    public class Demo {    
        public static void main(String[] args) {    
            List<Integer> li = new ArrayList<>();    
            li.add(1);    
            List<String> ls = null;    
            //ls = li;不能转换    
            List list = li;    
            ls = list;//不会报错,只有未经检查警告,此时list实际引用的是List<Integer>    
            System.out.println("-->" + ls.get(0));//企图当做String类型对象取出    
        }    
    }    
    
##泛型开发实例

- 泛型接口
    1. GenericDAO
        1. 包含一个常见的数据操作：增删改查
- 泛型接口实现类
    1. GenericDAOImpl
        1. 实现泛型接口里的所有抽象方法

    public interface IGenericDAO<T> { 
         T get(Serializable id); 
         T save(T newInstance); 
         void remove(Serializable id); 
         void update(T object); 
    } 
    public class GenericDAOImpl<T> implements IGenericDAO<T>{ 
         public T get(Serializable id) { 
             return null; 
         } 
         public T save(T newInstance) { 
             return null; 
         } 
         public void remove(Serializable id) { 
         }     
         public void update(T object) { 
         } 
         public List<T> query() { 
             return null; 
         } 
    }
