package com.crm.testscripts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sampledata {
	
	public static void main(String[] args) throws IOException {
		List<String> csvdata = new ArrayList<String>();
		FileReader file = new FileReader("C:\\Users\\vkovida\\Desktop\\ContactDetails.csv");
		BufferedReader br = new BufferedReader(file);
		StringBuilder sb = new StringBuilder();
		String s= null;
		while((s = br.readLine())!=null){
			s=br.readLine();
			sb.append(s);
		}
		String sc = sb.toString();
		String[] arr = sc.split(",");
		
		csvdata = Arrays.asList(arr);
		System.out.println(csvdata);
		//System.out.println(csvdata);
		//return csvdata;
		
	}

}
