//Rotem Yehudai 208851204 Dimitri Podoluk 317059244

//https://github.com/DmitriPodoluk/ASS_2
package AS_2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		System.out.println(" Insert 1 for self game , and   Insert 2 for user game :");
		int num=input.nextInt();
		
		
		switch(num) {
		case 1 :
			SelfGame selfGame = new SelfGame();
			SelfPlayer tp1=new SelfPlayer(Type.X,selfGame);
			SelfPlayer tp2=new SelfPlayer(Type.O,selfGame);
			Thread tx1=new Thread(tp1);
			Thread tx2=new Thread(tp2);
						
			tx1.start();
			tx2.start();
			break;
		case 2:
			UserGame userGame = new UserGame();
			UserPlayer tp3=new UserPlayer(Type.X,userGame);
			UserPlayer tp4=new UserPlayer(Type.O,userGame);
			Thread tx3=new Thread(tp3);
			Thread tx4=new Thread(tp4);
						
			tx3.start();
			tx4.start();
		break;
		default ://If something is different from one of the elections.
			   System.out.println("Wrong choice...");
		}

		
	}


}
