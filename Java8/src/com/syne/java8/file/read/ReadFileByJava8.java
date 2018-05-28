package com.syne.java8.file.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileByJava8 {

	public static void main(String[] args) throws IOException {

		
		Path file = Paths.get("D:\\ThreadClient.java");
		
			try(Stream<String> lines = Files.lines(file).onClose(()->System.out.println("Finished reading the file")))
			{
					lines.forEach(System.out::println);
		
			}
	}
}
