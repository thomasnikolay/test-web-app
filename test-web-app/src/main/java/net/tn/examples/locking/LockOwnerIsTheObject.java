package net.tn.examples.locking;

public class LockOwnerIsTheObject {

	static StringBuilder b = new StringBuilder();

	synchronized void writeToString() {
		for (int i = 97; i <= 122; i++) {
			b.append((char) i);
		}
	}

	synchronized void print() {
		
		char[] charArray = b.toString().toCharArray();
		for (char c : charArray) {
			System.out.print(c);
		}		
		System.out.println();
		b = new StringBuilder();
	}

	public static void main(String[] args) {

		final LockOwnerIsTheObject t = new LockOwnerIsTheObject();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {				
				@Override
				public void run() {					
					t.writeToString();
					t.print();					
				}
			}).start();
				
			
			
		}
	}

}
