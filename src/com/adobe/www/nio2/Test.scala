import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;

public class AsynchronousFileChannelTest{
	public static void main(String[] args) throws IOException, InterruptedException {
	Path path = Paths.get("Test.Scala");
	AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path);
	final ByteBuffer buffer = ByteBuffer.allocate(100);
	asynchronousFileChannel.read(buffer, 0, "attachment information",
	  new CompletionHandler<Integer, Object>() {
	    @Override
	    public void completed(Integer readCount, Object attachment) {
	    System.out.println(attachment);
	    System.out.println(new String(buffer.array()));
	    }
	    @Override
	    public void failed(Throwable exc, Object attachment) {
	    System.out.println("Error:" + exc);
	    }
	  });
	System.out.println("continue doing other things");
	Thread.sleep(1000);
	}
}