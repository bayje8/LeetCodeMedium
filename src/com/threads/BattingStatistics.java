package com.threads;

import java.util.Date;

public class BattingStatistics extends Thread {
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(new Date()+" >>> Batting Statistics");
		}
	}
}
