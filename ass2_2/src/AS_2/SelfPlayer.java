package AS_2;
//Rotem Yehudai 208851204 Dimitri Podoluk 317059244

import java.util.ArrayList;
import java.util.Random;



public class SelfPlayer implements Runnable {

	private Type tp;
    SelfGame ticTacToe = new SelfGame();
	Random rand = new Random();
	ArrayList<CellCoordinates> result;
	
	public SelfPlayer (Type tp, SelfGame ticTacToe) {
		this.ticTacToe = ticTacToe;
		this.tp=tp;
	}

	@Override
	public void run() {
		while (!ticTacToe.full()) {
			
			if (tp == ticTacToe.turn && !ticTacToe.win( Type.O)) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (ticTacToe) {
					if(ticTacToe.win( Type.O))
						break;
					
					if (!ticTacToe.isBoardFull() && !ticTacToe.win( Type.O)) {
						result = ticTacToe.getFreeCells();
						int size = result.size();
						int i = rand.nextInt(size);
						int row=result.get(i).getRow();
						int col=result.get(i).getCol();
						ticTacToe.setcellim(row,col, tp);
						if(ticTacToe.finish==true)
							break;
						
					}
					if(ticTacToe.winn(tp) ) {
						ticTacToe.printBoard();
						System.out.println(tp +" is win");
						break;
						
					}
				
					if (ticTacToe.full()  ) {
						ticTacToe.printBoard();
						System.out.println("board is full");
						break;
					}
					
					else
					   ticTacToe.printff();
					

				

				}
			}
			if (tp == ticTacToe.turn && !ticTacToe.win( Type.X)) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (ticTacToe) {
					if(ticTacToe.win( Type.X))
						break;
					
					if (!ticTacToe.isBoardFull() ) {
						result = ticTacToe.getFreeCells();
						int size = result.size() ;
						
							int i = rand.nextInt(size);
							int row=result.get(i).getRow();
							int col=result.get(i).getCol();
							ticTacToe.setcellim(row,col, tp);
							if(ticTacToe.finish==true)
								break;	
									
					}
				
					if(ticTacToe.winn(tp) ) {
						   ticTacToe.printBoard();
							System.out.println(tp +" is win");
 					break;
						}

						if (ticTacToe.full() ) {
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