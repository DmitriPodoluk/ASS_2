import java.io.IOException;

//Rotem Yehudai 208851204 Dimitri Podoluk 317059244

public class MiniBus extends Vehicle {
	VehicleWasher v;

	public MiniBus(VehicleWasher v1, int id) {
		super(id);
		this.v = v1;

	}

	public void run() {

		try {
			Thread.sleep(2000);
			this.v.addWait(this);
			this.v.queue(this);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String Name() {
		// TODO Auto-generated method stub
		return "MiniBus";
	}
}