//Rotem Yehudai 208851204 Dimitri Podoluk 317059244
package AS_2;

public class SelfGame extends Game {
	 
	
	public SelfGame() {
		
	}
	public synchronized boolean full() {
		notify();
		return isBoardFull();
	}
	public synchronized void setcellim(int row, int col, Type type) {
		setCell(row, col, type);
		notify();
		
	}
	public synchronized void printff() {
		printBoard();
		try {
			wait();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public synchronized boolean winn(Type tp) {
		
			notify();
			return win(tp);


		
	}
	

	public  void printBoard(){
		
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				if (this.gameBoard[i][j] == Type.FREE) {
					System.out.print("?");
				} else if (gameBoard[i][j] == Type.X) {
					System.out.print("X");
				} else if (gameBoard[i][j] == Type.O) {
					System.out.print("O");
				} else {
					System.out.print(gameBoard[i][j]);
				}
				System.out.print(" | ");
			}
			System.out.println();
			System.out.println("-------------");	
	}
}

	

}

