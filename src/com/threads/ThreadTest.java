package com.threads;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest test = new ThreadTest();
		test.testThread();
	}

	void testThread() {
		new BattingStatistics().start();
		// Bowling statistics implements the Runnable
		BowlingStatistics bowlingStatistics = new BowlingStatistics();
		new Thread(bowlingStatistics).start();
	}
}
