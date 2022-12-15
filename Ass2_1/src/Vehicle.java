import java.io.IOException;

//Rotem Yehudai 208851204 Dimitri Podoluk 317059244

public abstract class Vehicle extends Thread {
	int id;

	public Vehicle(int id) {
		this.id = id;
	}

	public abstract void run();

	public abstract String Name();

	public int getid() {
		return this.id;
	}

}