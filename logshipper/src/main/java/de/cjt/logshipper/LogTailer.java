package de.cjt.logshipper;

import java.io.File;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import de.cjt.controller.LoggingController;

@Component
public class LogTailer {
	Logger logger = LoggerFactory.getLogger(LoggingController.class);

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    
	    TailerListener tl = new TailerListener() {
			
			@Override
			public void init(Tailer tailer) {
				// TODO Auto-generated method stub
				System.out.println("Tailer initialized");
				
			}
			
			@Override
			public void handle(Exception ex) {
				// TODO Auto-generated method stub
				System.out.println("Error occured");
			}
			
			@Override
			public void handle(String line) {
				// TODO Auto-generated method stub
				System.out.println("Input in file: " + line);
			}
			
			@Override
			public void fileRotated() {
				// TODO Auto-generated method stub
				System.out.println("File rotated");
			}
			
			@Override
			public void fileNotFound() {
				// TODO Auto-generated method stub
				System.out.println("File not found");
				
			}
		};
		//Tailer t = new Tailer(new File("C:/Matteo/Workspaces/Logshipper/logshipper/logs/rolling.log"), tl);
	//	Tailer t = new Tailer(new File("C:/Matteo/Workspaces/Logshipper/logshipper/logs/rolling.log"), tl, 1l, true, false);
	//	t.run();
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Thread.sleep(1000);
				        logger.trace("A TRACE Message");
				        logger.debug("A DEBUG Message");
				        logger.info("An INFO Message");
				        logger.warn("A WARN Message");
				        logger.error("An ERROR Message");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		t.start();
	}
	
}
