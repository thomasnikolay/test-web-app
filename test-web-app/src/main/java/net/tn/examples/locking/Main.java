package net.tn.examples.locking;


public class Main {

	public static void main(String[] args) {

//		for (int i = 0; i < 2; i++) {
//			new Thread(new Runnable() {
//
//				@Override
//				public void run() {
//					Utils.writeToConsole();
//
//				}
//			}).start();
//
//		}
				
				
		for (int i = 0; i < 50; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					
					Utils.writeToConsoleSync();

				}
			}).start();
		}
		
	}

}
