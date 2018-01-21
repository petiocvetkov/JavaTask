package com.avr;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testHandling {
	@Test
	void test() {
		String input = "[\n" + 
				"{\n" + 
				"\"stationName\":\"MySSID\",\n" + 
				"\"power\":-10\n" + 
				"},\n" + 
				"{\n" + 
				"\"stationName\":\"Appolica\",\n" + 
				"\"power\":-15\n" + 
				"},\n" + 
				"{\n" + 
				"\"stationName\":\"MySSID\",\n" + 
				"\"power\":-1\n" + 
				"},\n" + 
				"{\n" + 
				"\"stationName\":\"Appolica\",\n" + 
				"\"power\":-5\n" + 
				"},\n" + 
				"{\"stationName\":\"Appolica\",\n" + 
				"\"power\":-50\n" + 
				"}\n" + 
				"]\n" + 
				"";
		String res = "[\n" + 
				"    {\n" + 
				"        \"stationName\": \"MySSID\",\n" + 
				"        \"avaragePower\": -5.5\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"stationName\": \"Appolica\",\n" + 
				"        \"avaragePower\": -23.333333333333332\n" + 
				"    }\n" + 
				"]";
		Main myclass = new Main();
		String result = myclass.handleInput(input);
		assertEquals(res,result);		
	}

}
