package com.adobe.www.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class WatherTest {

	public static void main(String[] args){
		
		Path this_dir = Paths.get("/Users/liji/Documents/workspace/java/src/com/adobe/www/nio2/");
		System.out.println("Now watching the current directory");
		try{
			WatchService watcher = this_dir.getFileSystem().newWatchService();
			this_dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
			WatchKey watchKey = watcher.take();
			List<WatchEvent<?>> events = watchKey.pollEvents();
			for (WatchEvent event: events){
				System.out.println("Someone just created the file '" + event.context().toString() + "'.");
			}
			System.out.println("Breaking the for loop");
		}catch(Exception e){
			System.out.println("Error:" + e.toString());
		}
	}
	
}
