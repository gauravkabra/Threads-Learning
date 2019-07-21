import java.util.Scanner;

/**
 * 
 */

/**
 * @author gakabra
 *
 */

class Processor extends Thread {

	// Volatile - Prevent thread caching variable when they are not changed 
	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Hello Thread");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void shutdown() {
		running = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press return to stop..");
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
		
	}

}
