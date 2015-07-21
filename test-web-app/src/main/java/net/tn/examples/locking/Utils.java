package net.tn.examples.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Utils {
	private static StringBuffer sb;
	private static ReentrantReadWriteLock lockMother = new ReentrantReadWriteLock();
	private static Lock writeLock = lockMother.writeLock();
	private static Lock readLock = lockMother.readLock();
	
	public static void writeToConsole(){
		
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		writeLock.lock();
		sb = new StringBuffer();
		for(int i=97; i<122;i++){
			
			sb.append((char)i);
		}
		writeLock.unlock();
		
		StringBuffer output = new StringBuffer();
		readLock.lock();
		char[] charArray = sb.toString().toCharArray();
		
		for (char c : charArray) {
			output.append(c);
		}
		readLock.unlock();
		
		System.out.println(output);
		System.out.println();
		
		
	}
	
	public static void writeToConsoleSync(){
		
		writeToConsole();
		
	}

}
