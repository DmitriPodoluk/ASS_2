//Rotem Yehudai 208851204 Dimitri Podoluk 317059244

public class Queue {

	private int N;

	public Queue(int N) {
		this.N = N;
	}

	public synchronized void wait1() throws InterruptedException {
		while (this.N  <= 0) {
			try {
				wait();
			} catch (Exception e) {

			}

		}
		this.N --;

	}

	public synchronized void notify1() throws InterruptedException {
		this.N++;
		notifyAll();
	}

}
