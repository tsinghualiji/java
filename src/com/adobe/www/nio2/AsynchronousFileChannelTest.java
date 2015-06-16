package com.adobe.www.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AsynchronousFileChannelTest{
	/*
	public static void main(String[] args) throws IOException, InterruptedException {
	Path path = Paths.get("/Users/liji/Documents/workspace/java/src/com/adobe/www/nio2/Test.scala");
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
	*/
	  public static void main(String args[]) throws Exception {
		    ExecutorService pool = new ScheduledThreadPoolExecutor(3);
		    AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
		        Paths.get("data.txt"), EnumSet.of(StandardOpenOption.READ),
		        pool);
		    CompletionHandler<Integer, ByteBuffer> handler = new CompletionHandler<Integer, ByteBuffer>() {
		      @Override
		      public synchronized void completed(Integer result, ByteBuffer attachment) {
		        for (int i = 0; i < attachment.limit(); i++) {
		          System.out.println((char) attachment.get(i));
		        }
		      }
		      @Override
		      public void failed(Throwable e, ByteBuffer attachment) {
		      }
		    };
		    final int bufferCount = 5;
		    ByteBuffer buffers[] = new ByteBuffer[bufferCount];
		    for (int i = 0; i < bufferCount; i++) {
		      buffers[i] = ByteBuffer.allocate(10);
		      fileChannel.read(buffers[i], i * 10, buffers[i], handler);
		    }
		    pool.awaitTermination(1, TimeUnit.SECONDS);
		    for (ByteBuffer byteBuffer : buffers) {
		      for (int i = 0; i < byteBuffer.limit(); i++) {
		        System.out.print((char) byteBuffer.get(i));
		      }
		    }
		  }
}