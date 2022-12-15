
//Rotem Yehudai 208851204 Dimitri Podoluk 317059244

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class VehicleWasher {

	int N;
	int M;
	int counter;
	int sum;
	int SuvAverage;
	int TruckAverage;
	int miniBusAverage;
	int carAverage;
	double g1;
	double g2;
	ArrayList<Vehicle> Wait = new ArrayList<Vehicle>();
	ArrayList<Vehicle> Wash = new ArrayList<Vehicle>();

	ArrayList<Car> carWashed = new ArrayList<Car>();
	ArrayList<Truck> truckWashed = new ArrayList<Truck>();
	ArrayList<MiniBus> miniBusWashed = new ArrayList<MiniBus>();
	ArrayList<SUV> SUVWashed = new ArrayList<SUV>();
	Queue q;
	VehicleLogger VehicleLogger;
	Object o = new Object();
	Object o1 = new Object();

	public VehicleWasher(int N1, int M1, double gama1, double gama2) throws IOException {
		this.N = N1;
		this.M = M1;
		this.g1 = gama1;
		this.g2 = gama2;
		this.sum = 0;
		this.counter = M1;
		this.carAverage = 0;
		this.miniBusAverage = 0;
		this.TruckAverage = 0;
		this.SuvAverage = 0;
		q = new Queue(this.N);
		Wait = new ArrayList();
		Wash = new ArrayList(this.M);
		VehicleLogger = new VehicleLogger((this.M * 5));
	}

	public void queue(Vehicle t) throws IllegalMonitorStateException, InterruptedException {

		q.wait1();
		removeWait(t);
		addWash(t);
		Wash(t);

	}

	public synchronized void addWait(Vehicle t) throws InterruptedException {
		double u = Math.random() * 1;

		int nextTime2 = (int) ((-(Math.log(u)) / g1) * 1000);

		String str = "#" + t.getId() + " " + t.Name() + " enter to waitings \n" + "#" + t.getId() + " finish time : "
				+ nextTime2 + "\n" + "----------------------------------------------\n";

		Thread.sleep(nextTime2);
		Wait.add(t);
		System.out.println();
		System.out.print(str);

		VehicleLogger.write(str);

	}

	public synchronized void removeWait(Vehicle t) throws InterruptedException {
		Wait.remove(t);
	}

	public synchronized void addWash(Vehicle t) throws InterruptedException {
		Wash.add(t);
		String str = "------------------------------------------------ \n" + "#" + t.getId() + " " + t.Name()
				+ "  enter to washing \n";
		System.out.print(str);
		VehicleLogger.write(str);
	}

	public synchronized void removeWash(Vehicle t) throws InterruptedException {
		String str = "#" + t.getId() + " " + t.Name() + " !!!!!!finished Washing!!!!!!\n"
				+ "------------------------------------------------ \n";
		System.out.print(str);
		VehicleLogger.write(str);
		Wash.remove(t);

	}

	public void Wash(Vehicle t) throws IllegalMonitorStateException, InterruptedException {
		double u = Math.random() * 1;
		int nextTime1 = (int) ((-(Math.log(u)) / g2) * 1000);
		String str = "#" + t.getId() + " " + t.Name() + " wash time: " + nextTime1 + "\n"
				+ "------------------------------------ \n";
		System.out.print(str);
		VehicleLogger.write(str);
		Thread.sleep(nextTime1);
		removeWash(t);
		addToList(t, nextTime1);
		q.notify1();
	}

	public synchronized void addToList(Vehicle t, int time) {

		if (t.getClass().getTypeName().toString().equals("Car")) {
			System.out.println("#" + t.getId() + " " + t.Name() + "  added succesfully to car list ");
			VehicleLogger.write("#" + t.getId() + " " + t.Name() + "  added succesfully to car list \n");

			this.carAverage += time;
			this.counter--;
			carWashed.add((Car) t);
		}
		if (t.getClass().getTypeName().toString().equals("Truck")) {
			System.out.println("#" + t.getId() + " " + t.Name() + "  added succesfully to truck list ");
			VehicleLogger.write("#" + t.getId() + " " + t.Name() + "  added succesfully to truck list \n");

			this.TruckAverage += time;
			this.counter--;
			truckWashed.add((Truck) t);
		}
		if (t.getClass().getTypeName().toString().equals("MiniBus")) {
			System.out.println("#" + t.getId() + " " + t.Name() + "  added succesfully to MiniBus list ");
			VehicleLogger.write("#" + t.getId() + " " + t.Name() + "  added succesfully to MiniBus list \n");

			this.miniBusAverage += time;
			this.counter--;
			miniBusWashed.add((MiniBus) t);
		}
		if (t.getClass().getTypeName().toString().equals("SUV")) {
			System.out.println("#" + t.getId() + " " + t.Name() + "  added succesfully to SUV list");
			VehicleLogger.write("#" + t.getId() + " " + t.Name() + "  added succesfully to SUV list \n");

			this.SuvAverage += time;
			this.counter--;
			SUVWashed.add((SUV) t);

		}

		if (this.counter == 0) {
			System.out.println();
			finish();

		}

	}

	public void finish() {

		System.out.println();

		if (carWashed.size() > 0) {
			System.out.println("car average wash time(seconds): " + this.carAverage / carWashed.size());
			VehicleLogger.write("car average wash time(seconds): " + this.carAverage / carWashed.size() + "\n");

		} else {
			System.out.println(" there were no cars  to wash ");
			VehicleLogger.write(" there were no cars  to wash \n");

		}
		if (truckWashed.size() > 0) {
			System.out.println("truck average wash time(seconds): " + this.TruckAverage / truckWashed.size());
			VehicleLogger.write("truck average wash time(seconds): " + this.TruckAverage / truckWashed.size() + "\n");

		} else {
			System.out.println(" there were no trucks  to wash ");
			VehicleLogger.write(" there were no cars  to wash \n");
		}
		if (miniBusWashed.size() > 0) {
			VehicleLogger
					.write("mini bus average wash time(seconds): " + this.miniBusAverage / miniBusWashed.size() + "\n");
			System.out.println("mini bus average wash time(seconds): " + this.miniBusAverage / miniBusWashed.size());
		} else {
			System.out.println(" there were no mini bus  to wash ");
			VehicleLogger.write(" there were no cars  to wash \n");
		}
		if (SUVWashed.size() > 0) {
			System.out.println("suv average wash time (seconds): " + this.SuvAverage / SUVWashed.size());
			VehicleLogger.write("suv average wash time (seconds): " + this.SuvAverage / SUVWashed.size() + "\n");

		} else {
			VehicleLogger.write(" there were no cars  to wash \n");
			System.out.println(" there were no suv  to wash ");
		}
		System.out.println();

		System.out.println(" !!!end of program!!!! ");
		VehicleLogger.write("!!!end of program!!!!");

	}

}
