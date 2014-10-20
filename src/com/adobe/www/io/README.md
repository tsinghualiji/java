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
