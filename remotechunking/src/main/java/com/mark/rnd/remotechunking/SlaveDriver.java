package com.mark.rnd.remotechunking;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SlaveDriver {

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext("slave-job.xml");
		System.in.read();
	}

}
