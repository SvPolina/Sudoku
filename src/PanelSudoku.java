
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class PanelSudoku extends JPanel{
	
	public final  JTextField[] Field    = new JTextField[81];	
	public final  JPanel[] myPanel=new JPanel[27];
	private final int[] backset={0,3,6,2,5,8,10,13,16,18,21,24,20,23,26};
	
	public final  JPanel panel=new JPanel();
	private final JButton[] buttons		= new JButton[2];
	private final JPanel buttonJPanel	= new JPanel();
	GameLogSudoku  game=new GameLogSudoku();

	
//constructor	
//organizes the panel representation	
public PanelSudoku()		
	{		
		for(int i=0; i<81;i++)
			{
			Field[i] = new JTextField(2);
			Field[i].addKeyListener(keyListener);
			}
		
		for(int i=0; i<27;i++)
		{myPanel[i] = new JPanel();}
		
		for(int i=0; i<27;i++)
		{
			if(checkSet(i)==true){myPanel[i].setBackground(new Color(22,33,44));}
			myPanel[i].add( Field[3*i]);
			myPanel[i].add( Field[3*i+1]);
			myPanel[i].add( Field[3*i+2]);		 
		}
		
		 this.buttons[0] = new JButton("set");
		 this.buttons[1] = new JButton("clear");		 
		 buttonJPanel.add(buttons[0]);	
		 buttonJPanel.add(buttons[1]);
		 
		
		JPanel texts=new JPanel(new GridLayout(9,3));
		for(int i=0; i<27;i++){texts.add(myPanel[i]);}				
		this.panel.add(texts,BorderLayout.NORTH);
		this.panel.add(buttonJPanel,BorderLayout.SOUTH);
	    
	    TextFieldHandler handler=new TextFieldHandler();
	    for (int i=0;i<81;i++)
	    	{
	    		Field[i].addActionListener(handler);	
	    	}
	    
	    SpecialButton SpecialB = new SpecialButton();
	    buttons[0].addActionListener(SpecialB);
	    buttons[1].addActionListener(SpecialB);
	    
	} 

// action listener for set button
private class TextFieldHandler implements ActionListener
{
	boolean g=true;
	@Override	
	public void actionPerformed(ActionEvent event)
	{
		for (int i=0;i<81;i++)
		 {			 
			 if(event.getSource()==Field[i])
			 {				 
				int row=i/9; 
				int col=i%9;
				String number=String.format("%s", event.getActionCommand());
				int num = Integer.parseInt(number);
				g=game.check(row, col, num);	
				
				if(g){
				JOptionPane.showMessageDialog(null, "Please insert another number \n This number is already in this \n row/column/block");
				Field[i].setText(null);
				g=game.check(row, col, num);				
				};	
				
			}
		}
	}
}



KeyListener keyListener = new KeyListener() 
{
   public void keyPressed(KeyEvent keyEvent) 
   { 
	   printIt("Pressed", keyEvent);  
   } 		
     
    
   
    public void keyReleased(KeyEvent keyEvent)
    { 
    	printIt("Released", keyEvent); 
    }
    
    
    public void keyTyped(KeyEvent keyEvent) 
    { 
    	printIt("Typed ", keyEvent); 
    }
   
    
    private void printIt(String title, KeyEvent keyEvent)
    {
    int numf;
    if(keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE)
         { 
    		for (int i=0;i<81;i++)
    			{ if(keyEvent.getSource()==Field[i])
    				{ numf=i;
    				int rowl=i/9; 
    				int coll=i%9;
    				game.clearceCell(rowl, coll);    			 
    				}
    			} 
         }   
    }    
 
 };

//action listener for clear button
private class SpecialButton implements ActionListener
{
@Override	
	public void actionPerformed(ActionEvent event){
	String label=event.getActionCommand();
	 if (label.equals("clear"))
	 {		
	 for (int i=0;i<81;i++){			 
	 Field[i].setText(null);
	 Field[i].setEditable(true); }
	 game.clearAll();
	 buttons[0].setEnabled(true);	
	 }
	 
	 if (label.equals("set"))
	 {
		 for(int i=0;i<9;i++){
				for	(int j=0;j<9;j++){
					if (game.board[i][j]!=0){
						 Field[i*9+j].setEditable(false);
						 Field[i*9+j].setForeground(new Color(222,33,144));
					}
				}}	
		 buttons[0].setEnabled(false);
	 }
			
}}
	

//check method for 	
	private boolean checkSet(int i)
	{
		 for(int k=0;k<backset.length;k++){
		 if (backset[k]==i){return true;}
			 			 }
		 return false;									
	}
		
}


