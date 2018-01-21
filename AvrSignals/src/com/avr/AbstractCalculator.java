package com.avr;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AbstractCalculator {
	abstract  String readInput(String fileName) throws IOException;
	abstract  String handleInput(String str);
	void printResult(String str, String fileName) throws IOException {
		
		FileWriter fileWriter = new FileWriter(fileName);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print(str);
	    printWriter.close();
	    
	}
	void handleInput() {
		// TODO Auto-generated method stub
		
	}
}