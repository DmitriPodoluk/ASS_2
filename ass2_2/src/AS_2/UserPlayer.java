//Rotem Yehudai 208851204 Dimitri Podoluk 317059244
package AS_2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserPlayer implements Runnable {
	
	Scanner input = new Scanner(System.in) ;
	private Type tp;
    UserGame ticTacToe = new UserGame();
	Random rand = new Random();
	ArrayList<CellCoordinates> result;
	
	public UserPlayer (Type tp, UserGame ticTacToe) {
		this.ticTacToe = ticTacToe;
		this.tp=tp;
	}

	@Override
	public void run() {
	
   while ( !ticTacToe.full()) {
			
			if (tp == ticTacToe.turn &&this.tp == Type.X &&!ticTacToe.win( Type.O) ) {
			
				synchronized (ticTacToe) {
					if(ticTacToe.win( Type.O))
						break;
				
					if (!ticTacToe.isBoardFull() && !ticTacToe.win( Type.O)) {
						    result = ticTacToe.getFreeCells();
						    int size = result.size();
							int i = rand.nextInt(size);
							int row=result.get(i).getRow();
							int col=result.get(i).getCol();
							ticTacToe.setcellim(row,col, this.tp);
					if(!ticTacToe.winn(tp) && !ticTacToe.full())
							ticTacToe.printff();
							if(ticTacToe.win( Type.O))
								break;
					}
					if (ticTacToe.winn(tp)) {
						ticTacToe.printBoard();
						System.out.println(Type.X+ " is Win ");
			        	break;
					}
			
					if ( ticTacToe.full() ) {
						ticTacToe.printBoard();
						System.out.println("board is full");
						break;
					}

					

				}
			}
			if (tp == ticTacToe.turn && tp== Type.O && !ticTacToe.win( Type.X) ) {
				
				synchronized (ticTacToe) {
					if(ticTacToe.win( Type.X))
						break;
					
					if (!ticTacToe.isBoardFull() && !ticTacToe.win( Type.X) ) {
						
						
						if(ticTacToe.round==0)
							ticTacToe.printBoard();
						  
						    result = ticTacToe.getFreeCells();
					     	System.out.println("Enter cell number :");
							int choice=input.nextInt();
							int row=result.get(choice-1).getRow();
							int col=result.get(choice-1).getCol();
							ticTacToe.setcellim(row,col,tp);
						
							if(ticTacToe.win( Type.X))
								break;
							
					
					}
					if (ticTacToe.winn(tp)) {
						ticTacToe.printBoard();
						System.out.println(Type.O+ " is Win ");

						break;
					
					}
	
					if (ticTacToe.full()) {
						ticTacToe.printBoard();
						System.out.println("board is full");
						break;
					}
					else
						ticTacToe.printff();
				}
			}
			
		}
}
			
			
	
		
}
