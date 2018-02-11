
import java.awt.*;
import javax.swing.*;

//The logics behind the panel is as follows:
//1.Board preparation:
//-the user chooses with what numbers his board will be initialized.
//-after inserting each number the player should press enter to validate the number.
//-when the player finished preparing the board he should press "set".
//2.The game stage
//-similar as at the preparation stage, the user should validate each number by pressing 'enter'
//-the user can delete previously inserted numbers at this stage ( if he thinks there is a change in the numbers he inserted should be made)
//-(but not the numbers that were inserted during the preparation stage)
//-in this version the user doesn't receive any notice when he finishes filling in grid 
//-if he doesn't receive a notice on the last digit, that means he finished.....)

public class PlayGameSudoku {
	
	public static void main (String[] args)
	{	
		PanelSudoku panel= new PanelSudoku();		
		JFrame window = new JFrame("Sudoku");	    
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setSize(400,400);	   
	    window.setVisible(true);
	    window.add(panel.panel);
	    
     }
}
