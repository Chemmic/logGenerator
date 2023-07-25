package de.cjt.logshipper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ByteCounter {

	private File f;
	private Long bytes;
	
	public ByteCounter() {
		f = new File("logs/counter");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void updateCounter(Long bytes) {
		try {
			FileWriter fw = new FileWriter(f, false);
			fw.write("CurrentBytes:" + bytes);
			this.bytes = bytes;
			
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Long getCurrentBytes() {
		try {
			FileReader reader = new FileReader(f);
			BufferedReader r = new BufferedReader(reader);
			String current = r.readLine();
			reader.close();
			r.close();
		
			return Long.valueOf(current.replaceAll("CurrentBytes:",""));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
