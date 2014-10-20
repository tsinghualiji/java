##流

- 数据流是一串连续不断的数据的集合,就像水管里的水流,在水管的一端一点一点地供水,而在水管的另一端看到的是一股连续不断的水流
- 数据写入程序可以使一段一段地向数据流管道中写入数据,这些数据段会按先后顺序形成一个长的数据流.

##流的分类
  按不同角度分类：
- 按流动方向的不同可以分为输入流和输出流；
- 按处理数据的单位不同分为字节流和字符流；
- 按功能的不同可分为节点流和处理流；
	1. 节点流：直接操作目标设备，例如：磁盘或一块内存区域。
	1. 处理流：通过操作节点流,从而间接完成输入或输出功能的流。处理流是的存在是建立在一个已经存在的输入流或输出流的基础之上的。
- 所有流都继承于以下四种抽象流类型的某一种：

|流|字节流|字符流|
|------|-----|-----|
|输入流|InputStream|Reader|
|输出流|OutputStream|Writer|

##字节流和字符流的区别：

 - 字节流和字符流在使用上的代码结构都是非常类似的，但是其内部本身也是有区别的，因为在进行字符流操作的时候会使用到缓冲区，而字节流操作的时候是不会使用到缓冲区的
 - 在输出的时候，OutputStream类即使最后没有关闭内容也可以输出。但是如果是Writer的话，则如果不关闭，最后一条内容是无法输出的，因为所有的内容都是保存在了缓冲区之中，每当调用了close()方法就意味着清空缓冲区了。那么可以证明字符流确实使用了缓冲区：
 	1. 字节流：程序 → 文件
	1. 字符流：程序 → 缓冲区 → 文件
 - 如果现在字符流即使不关闭也可以完成输出的话，则必须强制性清空缓冲区
 - 方法：public void flush() throws IOException
 - 两者相比，肯定使用字节流更加的方便，而且在程序中像图片、MP3等都是采用字节的方式的保存，那么肯定字节流会比字符流使用的更广泛。
 - 但是需要说明的是，如果要是想操作中文的话，字符流肯定是最好使的。

##Java 7 新特性： 自动关闭资源的try语句
    public static void afterjava7(String srcPath, String destPath){
        try (
        	InputStream is = new FileInputStream(srcPath);
            OutputStream os = new FileOutputStream(destPath);
            ) {
                byte[] bys = new byte[1024];
                int len = 0;
                while ((len = is.read(bys)) != -1) {
                    os.write(bys, 0, len);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("搞定");
    }

##内存操作流-字节

- 之前的文件操作流是以文件的输入输出为主的，当输出的位置变成了内存，那么就称为内存操作流。此时得使用内存流完成内存的输入和输出操作。

- 如果程序运行过程中要产生一些临时文件，可采用虚拟文件方式实现；

- 直接操作磁盘的文件很耗性能,使用内存流可以提升性能;jdk里提供了内存流可实现类似于内存虚拟文件的功能。
	1. ByteArrayInputStream：将内容写到内存中
	1. ByteArrayOutputStream：将内存中的数据写出

- ByteArrayInputStream：构造方法：
	1. public ByteArrayInputStream(byte[] buf):全部内容
	1. public ByteArrayInputStream(byte[] buf,int offset,int length)：指定范围的内容

- ByteArrayOutputStream:

##内存操作流-字符

- CharArrayReader 
- CharArrayWriter
	1. 此类实现一个可用作 Writer 的字符缓冲区。缓冲区会随向流中写入数据而自动增长。可使用 toCharArray() 和 toString() 获取数据

##打印流

- 思考：如果现在要想完成一个字符串或者是boolean型或者是字符型的数据输出使用OutputStream是否方便？
- 肯定是不方便的，因为OutputStream中只能操作字节数据，所以其他的数据类型很难操作，那么在Java的IO包中为了解决这种问题增加了两种类：PrintStream、PrintWriter。
- 打印流有非常好的打印功能，可以打印任何的数据类型。如，整数，小树，字符串等。
- 观察PrintStream类的构造：
	1. public PrintStream(File file) throws FileNotFoundException
	1. public PrintStream(OutputStream out)
		1. 虽然PrintStream是OutputStream的子类，但是在实例化的时候依然需要一个OutputStream的对象。
- PrintWriter和PrintStream都属于输出流，分别针对字符和字节
- PrintWriter和PrintStream重载的print()和println()用于多种数据类型的输出
	1. print()里的参数不能为空；println()可以
- PrintWriter和PrintStream输出操作不抛出异常
- PrintStream调用println方法有自动flush功能

##格式化输出

- Java5后，PrintStream类多了printf()方法用于格式化输出操作。但是格式化输出的时候必须指定输出数据的类型

|字符|描述|
|----|----|
|%s|表示内容是字符串|
|%d|表示内容是整数|
|%f|表示内容是小数|
|%c|表示内容是字符|
	当然你也可以全部使用“%s”来表示所有的数据类型

##管道流

- 又称为线程通讯流，主要作用是可以进行两个线程之间的通讯
	1. PipedOutputStream：管道输出流
	1. PipedInputStream：管道输入流

- PipedOutputStream中有方法:
	1. void connect(PipedInputStream pis) throws IOException:用于连接管道

- PipedInputStream中有方法:
	1. void connect(PipedOutputStream pos) throws IOException:用于连接管道

##处理流

	1. 节点流： 可以从或向特定的地方读写数据。用于直接操作目标设备所对应的流类。节点流类所对应的IO源或目标称为流节点

- 处理流：

	1. 对已存在的流的连接和封装，通过封装流的功能调用实现数据读写。处理流的构造方法总会带一个其他流对象作参数，一个流对象经过其他流的多次包装，称为流的链接。
	1. 当使用处理流的时候，在关闭输入/输出资源时。只需要关闭上层流即可。因为当关闭上层流的时候系统会默认去关闭被处理的节点流。

##缓冲流

- 缓冲流要“套接”在相应的节点流之上，对读写的数据提供了缓冲的功能，提高了读写效率，同时增加了一些新的方法
- 四种缓冲流
	1. BufferedReader(Reader in)
	1. BufferedReader(Reader in,int sz)//sz表示自定义缓冲区大小
	1. BufferedWriter(Writer out)
	1. BufferedWriter(Writer out,int sz)
	1. BufferedInputStream(InputStream in)
	1. BufferedInputStream(InputStream in,int sz)
	1. BufferedOutputStream(OutputStream out)
	1. BufferedOutputStream(OutputStream out,int sz)
- BufferedReader提供readLine方法用于读取一行字符串
- BufferedWriter提供了newLine方法用于写入一个行分隔符。等价于//.writer("\r\n");
- 对于输出的缓冲流，写出的数据会先在内存中缓冲，使用flush方法将会使内存中的数据立刻写出

##转换流

- 字节流---> 字符流
	1. InputStreamReader 字节输入流-->字符输入流
	1. OutputStreamWriter 字节输出流-->字符输出流

- InputStreamReader 需要和InputStream“套接”；

- OutputStreamWriter 需要和OutputStream“套接”

- 转换流在构造时可以指定其编码集合
	1. InputStreamReader in  = new InputStreamReader(Sytem.in,"ISO8859_1");

- 为了达到最高效率，可要考虑在 BufferedReader 内包装 InputStreamReader。例如： 
	1. BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));

##数据操作流

- 和平台无关的数据操作流：
- DataInputStream和DataOutputStream分别继承于InputStream和OutputStream，属于处理流，需要分别“套接”在InputStream 和OutputStream类型的节点流上。
- DataInputStream 和DataOutputStream提供了可以存储Java原始类型数据(如int,boolean等)的方法。
- 构造方法：
	1. DataInputStream(InputStream in)
	1. DataOutputStream(OutputStream out);

##合并流

- SequenceInputStream：
- 将两个文件的内容合并成一个文件
- 该类提供的方法：
	1. SequenceInputStream(InputStream s1, InputStream s2) ：根据两个字节输入流对象来创建合并流对象

##System

- Java的标准输入输出，分别通过System.in和System.out表示，默认情况下，他们分别表示键盘和屏幕。也就是说键盘输入，屏幕显示输出。
- System类里面有三个重定向标准输入/输出的方法：
	1. static void setErr(PrintStream err)：重定向“标准”错误输出流”
	1. static void setIn(InputStream in)：重定向“标准"输入流”
	1. static void setOut(PrintStream out)：重定向“标准”输出流”

##字符编码

- 常见的编码ISO8859-1,utf-8,Unicode,GBK,GB2312,GB18030;
- ISO8859-1又称Latin-1或“西欧语言”,属于单字节编码,最多只能表示0~255,英文系统中使用,不支持中文;
- gbk/gb2312/gb18030:中国的国际编码，专用来表示汉字,双字节编码,GBK表示中文简体和繁体,
- gb2312表示简体,GBK兼容gb2312。gb18030是GBK编码的增强版;
- unicode：java使用的此编码，也是最标准的一种编码,使用十六进制表示编码，但是不兼容ISO8859-1。
- UTF-8：由于unicode不支持lantin-1,且易占用更多空间，对于英文字母也需要两个字节编码，这样不便于传输和存储，此时UTF码就应运而生，它可表示所有语言文字。不过UTF是不定长编码，每个字符的长度从1-6字节不等，一般网页中使用该编码。
- 字符串的编码:String --- > byte[]
- 字符串的解码:byte[] --- > String
- 乱码的产生:解码和编码不一致

##乱码

- 编码:String --- > byte[]
- 解码:byte[] --- > String
- 乱码:解码和编码不一致
程序中一定要处理好编码，否则会出现乱码。比如本机默认编码是GBK而在程序中使用了ISO8859-1编码，则会出现乱码。
查看系统默认编码
	public class Demo {
		public static void main(String[] args) {
			Properties p = System.getProperties();
			//p.list(System.out);
		System.out.println(System.getProperty("file.encoding"));
		}
	}

##对象序列化

- 就是把对象变成二进制的数据流的一种方式，其目的可以方便的实现对象的传输或存储。
- 若一个类的对象需要被序列化，其类就必须实现java.io.Serializable接口。

##对象的序列化和反序列化

- 若对对象输入输出，得使用对象操作流
	1. ObjectInputStream：对象输入流
	1. ObjectOutputStream：对象输出流
- 使用对象操作流输出序列化对象过程：
	1. 我们称为对象序列化，若不希望某个属性被序列化则用transient修饰属性
	1. 若类中的自动式静态的,则不能被序列化;
	1. 若类中某引用类型字段的类没有实现 Serializable,该字段也是不能序列化的;
- 使用对象操作流输入序列化对象过程：
	1. 我们称为对象的反序列化
- 在对象序列化和反序列化时需考虑JDK版本问题，我们一般注入serialVersionUID 常量，当反序列化时，JVM会把传过来的字节流中的serialVersionUID 与本地对应类的serialVersionUID 相比较，若一致则可以反序列化，否则，抛出异常

##对象操作流

- ObjectOutputStream
	1. 用于输出对象
	1. 常用方法
		1. ObjectOutputStream(OutputStream out)  创建写入指定 OutputStream 的 ObjectOutputStream对象。
		1. void writeObject(Object obj) 输出对象。 

- ObjectInputStream
	1. 把被序列化的对象给反序列化回来
	1. 常用方法
		1. ObjectInputStream(InputStream in)
		1. Object readObject()  读取对象。 

##压缩流

- 我们经常使用WinRAR或WinZIP压缩文件，压缩后方便传输
- Java中我们提供了专门的压缩流来将文件或文件夹压缩成jar,zip,gzip等格式。
- 压缩流的操作类都处于java.uti.zip中
- 在java中要实现zip的压缩需要使用包中的ZipFile,ZipOutputStream,ZipInputStream,ZipEntry类。
- jar和文件格式的压缩输入，输出流
	1. jar压缩输出流：JarOutputStream
	1. jar压缩输入流：JarInputStream
	1. jar文件：JARFile
	1. jar实体：JarEntry
- gzip用于unix系统的文件压缩，Linux中经常使用到*.gz就是gzip格式。
	1. GZIP压缩输出流：GZIPOutputStream
	1. GZIP压缩输入流：GZIPInputStream

- ZipEntry & ZipOutputStream

	1. ZipEntry用于表示 ZIP 文件条目,也就是压缩文件中的每一个子文件。
		1. ZipEntry(String name)使用指定ZipEntry名称创建新的 ZipEntry对象。
		1. boolean isDirectory()判断该ZipEntry是不是目录。 
		1. ZipOutputStream用于完成一个文件或文件夹的压缩。
	1. ZipOutputStream(OutputStream out) 创建新的 ZIP 输出流
		1. void putNextEntry(ZipEntry e) 设置ZipEntry对象
		1. void setComment(String comment)  设置 ZIP 文件注释
