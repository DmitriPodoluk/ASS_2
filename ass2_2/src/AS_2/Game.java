//Rotem Yehudai 208851204 Dimitri Podoluk 317059244
package AS_2;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Game {
	 Type[][] gameBoard;
	 Type turn;
	 boolean finish=false;
	public Game() {
		
		gameBoard= new Type[3][3];
	    resetBoard();
	}
	
	public abstract void printBoard();

	public Type getTurn() {
		return turn;
	}
	
	public void resetBoard() {
		for (int i = 0; i < 3; i++) {
		  for (int j = 0; j < 3; j++) {
			  gameBoard[i][j] = Type.FREE;
			}
		}
		turn= Type.X;
	}
	
	
	public ArrayList<CellCoordinates> getFreeCells() {
		ArrayList<CellCoordinates> result = new ArrayList<CellCoordinates>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameBoard[i][j] == Type.FREE)
					result.add(new CellCoordinates(i, j));
			}
		}
		return result;
	}
	
	// check if board is full = no free cells
		public boolean isBoardFull() {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (gameBoard[i][j] == Type.FREE)
						return false;
				}
			}
			return true;
		}
		
		
		
		
		
		// set cell state in game board, and update player turn
		public void setCell(int row, int col, Type type) {
			if (row >= 0 && row < 3 && col >= 0 && col < 3) {
				if (gameBoard[row][col] == Type.FREE) {
					gameBoard[row][col] = type;
					if (type == Type.X)
						turn= Type.O;
					else
						turn= Type.X;
				 } 
				else
					throw new InvalidParameterException("tried to set occupied cell");
			    }
			   else {
				    throw new InvalidParameterException("invalid index");
			}
		}
		
		

		
		public boolean win(Type tp) {
			
			for(int i=0; i<3;i++) {
		       if ((gameBoard[i][0] == tp  && gameBoard[i][1] == tp && gameBoard[i][2] == tp)
			          || 
			       (gameBoard[0][i] == tp  && gameBoard[1][i] == tp && gameBoard[2][i] == tp)) {
		    	   setfinish(true);
		    	    return true;     
				}
			                
	 			 if ((gameBoard[0][0] ==tp && gameBoard[1][1] == tp && gameBoard[2][2] == tp)
			             ||   
			         (gameBoard[0][2] == tp && gameBoard[1][1] == tp &&gameBoard[2][0] == tp)) {
	 				setfinish(true);
	 			      return true;
			    }
			}	
			
	 				  return false;
			        
			            
			}

		public synchronized void setfinish(boolean finish)  {

			this.finish=finish;


	}
}



