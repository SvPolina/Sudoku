
public class GameLogSudoku {
	public int[][] board=new int[9][9];
	       
//method for board clearing
	public void clearAll()
	{
		for(int i=0;i<9;i++){
	        for(int j=0;j<9;j++){
	        this.board[i][j]=0;    
	         }}	
	}
	
	public void clearceCell(int row, int col)
	{this.board[row][col]=0; 	         
	}	
	
	
//methods for checking if this number already exists in the row /column/block	
	public boolean check(int row, int col,int num)
	{
		if (checkRow(row,col, num)||checkCol(row,col, num)||checkBlock(row, col,num))
		{
			return true;
		}
		else  
		{this.board[row][col]=num;			
			return false;}		
	}
	
	
	private boolean checkRow(int row,int col, int num)
	{
		for	(int i=0; i<9;i++)
			{
				if (this.board[row][i]==num)	return true;
			}
		return false;
	}
	
	
	private boolean checkCol(int row,int col,int num){
		for	(int i=0; i<9;i++)
		{
			if (this.board[i][col]==num)	return true;
			}
		return false;
	}
	
	private boolean checkBlock(int row, int col,int num)
	{
		int rowB=row/3;
		int colB=col/3;
		rowB=rowB*3;
		colB=colB*3;
		for	(int i=0; i<3;i++)
			for	(int j=0; j<3;j++)
		{{ 
				if (this.board[rowB+i][colB+j]==num)	return true;
		}}
		return false; 		
	}

}
