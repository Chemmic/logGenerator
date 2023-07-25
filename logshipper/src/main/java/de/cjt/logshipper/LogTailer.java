package de.cjt.logshipper;

import java.io.File;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LogTailer {

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
		Tailer t = new Tailer(new File("C:/Matteo/Workspaces/Logshipper/logshipper/logs/rolling.log"), tl, 1l, true, false);
		t.run();
	}
	
}
