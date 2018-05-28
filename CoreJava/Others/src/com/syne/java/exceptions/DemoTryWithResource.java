package com.syne.java.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class DemoTryWithResource
{
    
    public void writeUsingBufferWriter() throws IOException {
		System.out.println("1. Start writing contents to file - CustomBufferedWriter");		
		try (FileOutputStream fileStream = new FileOutputStream(new File("D:\\sampleFile.txt"));
				OutputStreamWriter writer = new OutputStreamWriter(fileStream);
				CustomBufferedWriter customBufferWriter = new CustomBufferedWriter(writer)) {
			customBufferWriter.write("Soccer");
			customBufferWriter.newLine();
			customBufferWriter.write("Tennis");			
		}
		System.out.println("3. Successfully written contents to file - CustomBufferedWriter");
	}
	
	public void readUsingBufferReader() throws IOException {
		System.out.println("\n4. Start Reading file using CustomBufferedReader");
		try (FileInputStream fileStream = new FileInputStream(new File("D:\\sampleFile.txt"));
				InputStreamReader reader = new InputStreamReader(fileStream);
				CustomBufferedReader customBufferedReader = new CustomBufferedReader(reader)) {
			String line;
			while ((line = customBufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}
		System.out.println("6. End Reading file using CustomBufferedReader");
	}
}

class CustomBufferedReader extends BufferedReader{

	public CustomBufferedReader(Reader reader) {
		super(reader);
		// TODO Auto-generated constructor stub
	}
	public void close() throws IOException{
		super.close();
		System.out.println("AutoCloseable: Closing BufferReader resource");
	}
}

class CustomBufferedWriter extends BufferedWriter{

	public CustomBufferedWriter(Writer out) {
		super(out);
		// TODO Auto-generated constructor stub
	}
	
	public void close() throws IOException{
		super.close();
		System.out.println("AutoCloseable: Closing CustomBufferedWriter resource");
	}
}