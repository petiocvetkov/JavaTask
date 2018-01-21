package com.avr;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Main extends AbstractCalculator{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Main main = new Main();
		String res = null;
		System.out.println();
		try {
			res = main.readInput(args[1]);
			res = main.handleInput(res);
			main.printResult(res,args[3] );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	String readInput(String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String res = null;
		InputStream is;
		try {
			is = new FileInputStream(fileName);
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));
	        
			String line = buf.readLine();
			StringBuilder sb = new StringBuilder();
			        
			while(line != null){
			   sb.append(line).append("\n");
			   line = buf.readLine();
			}
		    //System.out.println( sb.toString() );
			is.close();
			res = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;

	
	}

	@Override
	String handleInput(String str) {
		// TODO Auto-generated method stub
		String name = "stationName";
		String pwr = "power";
		String key = null;
	    String result = null;
		int value;
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		HashMap<String, Integer> times = new HashMap<String, Integer>();
		try {
			JSONArray json = new JSONArray(str);

			for(int i = 0; i < json.length();i++) {
				key = (String) json.getJSONObject(i).get(name);
				value = (int) json.getJSONObject(i).get(pwr);
				if(hash.containsKey(key)) {
					hash.put(key ,hash.get(key)+value );
					times.put(key, times.get(key) + 1);
				}else 
				{
					hash.put(key ,  value);
					times.put(key, 1);
				}
			}
			
			JSONArray res = new JSONArray();
			JSONObject obj = new JSONObject();
			for ( String k : hash.keySet() ) {
				obj.put(name,k);
				obj.put("avaragePower", (double) hash.get(k)/times.get(k));
				res.put(new JSONObject(obj.toString()));
			}
			result = res.toString(4);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

} 
