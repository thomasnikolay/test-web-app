package net.tn.examples.threaddaemon;

public class TestDaemon extends Thread {

	public TestDaemon() {
		super();
		setDaemon(true);
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			System.out.println("Lauf, Thread, lauf");
		}
	}

	public static void main(String[] args) {
		
		new TestDaemon().start();

	}

}
