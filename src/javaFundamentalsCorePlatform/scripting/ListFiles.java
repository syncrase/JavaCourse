#!/usr/bin/java	--source 11

package javaFundamentalsCorePlatform.scripting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {

	/**
	* "C:\Program Files\Java\jdk-11.0.1\bin\java" --source 11 listfiles .
	* in order to execute directly the file
	* chmod +x listfiles
	* ./listfiles .
	**/
	public static void main(String[] args) throws IOException {
		Files.walk(Paths.get(args[0])).forEach(System.out::println);
	}
}
