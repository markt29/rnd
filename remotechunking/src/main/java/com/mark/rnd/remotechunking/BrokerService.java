package com.mark.rnd.remotechunking;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BrokerService {

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext("broker.xml");
		System.in.read();
	}

}
