package com.threads;

import java.util.Date;

public class BowlingStatistics implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(new Date()+" >>> Bowling Statistics");
		}
		
	}

}
