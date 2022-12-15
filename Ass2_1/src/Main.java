//Rotem Yehudai 208851204 Dimitri Podoluk 317059244

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Washers:");
		int N = sc.nextInt();
		System.out.println("Cars To Wash:");
		int M = sc.nextInt();
		System.out.println("Average Time Between Arrived Cars:");
		float AverageC = sc.nextFloat();
		System.out.println("Average Time for Wash Car:");
		float AverageW = sc.nextFloat();

		ArrayList<Vehicle> Vehicle = new ArrayList<Vehicle>();
		VehicleWasher Washer = new VehicleWasher(N, M, AverageC, AverageW);

		int num = 0;
		for (int i = 0; i < M; i++) {
			num = (int) ((Math.random() * 4));
			switch (num) {
			case 0:
				Vehicle car = new Car(Washer, i);
				Vehicle.add(car);

				break;
			case 1:
				Vehicle truck = new Truck(Washer, i);
				Vehicle.add(truck);
				break;
			case 2:
				Vehicle MiniBus = new MiniBus(Washer, i);
				Vehicle.add(MiniBus);
				break;
			case 3:
				Vehicle SUV = new SUV(Washer, i);
				Vehicle.add(SUV);

				break;
			default:
				break;

			}

		}

		for (int i = 0; i < M; i++) {
			Vehicle.get(i).start();
		}

	}

}
