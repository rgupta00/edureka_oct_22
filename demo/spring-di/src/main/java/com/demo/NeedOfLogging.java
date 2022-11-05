package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeedOfLogging {

	private static Logger logger=LoggerFactory.getLogger(NeedOfLogging.class);
	
	public static void main(String[] args) {
		
	//	System.out.println("code is working till line no 7...."); painful
		logger.info("this is sample logging");
		try {
			String data= "123A";
			int val=Integer.parseInt(data);
			System.out.println(val);
		}catch(Exception e) {
			logger.error("cant parse to int");
		}
		
	}
}
