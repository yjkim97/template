/***********************************************************************************************
 * 
 * NAME: 		YuJin Kim
 * 
 * HOMEWORK: 	Group Project
 * 
 * CLASS: 		ICS 211
 * 
 * INSTRUCTOR: 	Scott Robertson
 * 
 * DATE: 		May 4, 2016
 * 
 * FILE:		Board.java
 * 	
 * DESCRIPTION:	This file contains the Board class for the Group Project. In this class,
 * 				the user can play minesweeper (selecting and flagging the grid), replay,
 * 				or choose to change the level.
 * 
 **********************************************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Board implements ActionListener {
	private int rows;
	private int columns;
	private int height = 600;
	private int width = 1100;  
	private JButton[][] buttons;
	private int[][] counts;  		//stores the number of surrounding mines of a button
	private int minecount;
	private int mine = 10; 			//can be any number, as long as its not 0-8
	private int lvl;
	private boolean over = false;
	private Long t;
	FileWriter fw;
	
	JFrame frame = new JFrame("Minesweeper");
	JButton replay = new JButton("Replay");
	JButton level = new JButton("Change Level");
	Container grid = new Container();
	Color defaultC = frame.getBackground(); 

	//For right-click tracking on grid buttons:
	MouseAdapter mouse = new MouseAdapter(){						
		public void mouseClicked(MouseEvent e){
			if(e.getButton() == 3 && over == false){						//when a button is right-clicked and the game was neither won nor lost 
				for(int x = 0; x < buttons.length; x++){
					for(int y = 0; y < buttons[0].length; y++){
						if(e.getSource() == buttons[x][y]){  				//finds the button that was clicked
							if(buttons[x][y].getText() == "F"){				//places a flag
								buttons[x][y].setText("");
								buttons[x][y].setEnabled(true);
								buttons[x][y].setBackground(defaultC);
							}else{											//removes a flag
								buttons[x][y].setText("F");
								buttons[x][y].setEnabled(false);
								buttons[x][y].setBackground(Color.yellow);
							}

						}
					}
				}
			}
		}
	};


	/********************************************************************************************************
	 * 
	 * Method:		Board
	 * 
	 * Description:	Constructor; creates a new frame that contains
	 * 
	 * @param		Rows: the number of rows the grid will have
	 * 				Columns: the number of columns the grid will have
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	public Board(int Rows, int Columns){
		rows = Rows;
		columns = Columns;
		buttons = new JButton[Rows][Columns];  	//creating 2D array of buttons
		counts = new int [Rows][Columns];  		//creating counter for buttons
	
		if(Rows == 10){			//Level 1: 10x10 grid with 9 mines
			lvl = 1;
			minecount = 9;
		}
		if(Rows == 15){			//Level 2: 15x15 grid with 50 mines
			lvl = 2;
			minecount = 50; 
		}
		if(Rows == 20){			//Level 3: 20x20 grid with 100 mines
			lvl = 3;
			minecount = 100;
		}
		frame.setSize(width, height);
		frame.setLayout(new BorderLayout()); 	 //sets what kind of layout(BorderLayout)
		frame.add(replay, BorderLayout.NORTH);  //sets the reset button on North
		frame.add(level, BorderLayout.WEST);
		placeMines();
		replay.addActionListener(this);
		level.addActionListener(this);
		grid.setLayout(new GridLayout(rows, columns));  //creates layout of grid

		//setting buttons for each grid block
		for(int i = 0; i < buttons.length; i++){
			for(int j = 0; j < buttons[0].length; j++){
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				buttons[i][j].addMouseListener(mouse);
				grid.add(buttons[i][j]);
			}
		}
		frame.add(grid, BorderLayout.CENTER);  //putting grid in the center

		frame.setVisible(true);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
	}

	/********************************************************************************************************
	 * 
	 * Method:		placeMines
	 * 
	 * Description:	 Creates an arraylist that holds all integers in the 2D array of buttons. Picks random 
	 *             integers from the array. Multiplies value by 100 and adds it by j, then divides by 100 and performs log
	 *             to insure no duplicate mines are made. Checks all directions for bombs and increases variable neighbors.
	 * 
	 * @param		None
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	//a little complicated process, but insures that there are no duplicate mines in same spaces
	public void placeMines(){
		t = new Long(System.currentTimeMillis());
		//creating an arraylist to keep track of all spaces
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < counts.length; i++){
			for(int j = 0; j < counts[0].length; j++){  		//use counts for first dimension, counts[0] for second dimension 
				list.add(i*100+j);  							//multiplying by 100 and adding by j allows division and modulus later. Easier to find random numbers
			}
		}
		//finding choosing which grid is a mine, then removing it from the arraylist
		counts = new int[rows][columns];  									//resetting counts 2D array just in case
		for(int x = 0; x < minecount; x++){  								//amount of mines you want. I think 1/6 of the maps as mines is ok
			int plant = (int)(Math.random() * list.size());  				//get a random number between 0 and 1, multiply it by (width X height) and truncate
			counts[list.get(plant)/100][list.get(plant) % 100] = mine;  	//Divides first dimension by 100 and modulus' the second dimension by 
			//100 to get usable number. Sets int equal to mine, which is any number
			list.remove(plant);  											//removes mine from arraylist
		}
		//checking neighbors
		for(int a = 0; a < counts.length; a++){
			for(int b = 0; b < counts[0].length; b++){
				if(counts[a][b] != mine){
					int neighbors = 0;
					if(a > 0 && b > 0 && counts[a-1][b-1] == mine){  //bottom left
						neighbors++;
					}
					if(b > 0 && counts[a][b-1] == mine){  //bottom
						neighbors++;
					}
					if(a < counts.length-1 && b < counts[0].length-1 && counts[a+1][b+1] == mine){  //top right
						neighbors++;
					}
					if(a > 0 && counts[a-1][b] == mine){  //left
						neighbors++;
					}
					if(a < counts.length-1 && counts[a+1][b] == mine){  //right
						neighbors++;
					}
					if(b < counts[0].length-1 && counts[a][b+1] == mine){  //top
						neighbors++;
					}
					if(a > 0 && b < counts[0].length-1 && counts[a-1][b+1] == mine){  //bottom right
						neighbors++;
					}
					if(a < counts.length-1 && b > 0 && counts[a+1][b-1] == mine){  //top left
						neighbors++;
					}
					counts[a][b] = neighbors;  //from this point on, the counts value for each button will be the amount of neighboring mines
				}
			}
		}
	}
	
	/********************************************************************************************************
	 * 
	 * Method:		actionPerformed
	 * 
	 * Description:	Activates when any button is clicked. Depending on the button, leads to a different outcome.
	 * 				- level: leads to the main menu so the user can reselect the level
	 * 				- replay: resets the grid to a new randomized game of the same level
	 * 				- a button on the grid: if the button is a mine, loses the game. If not, shows the number
	 * 					of mines surrounding that button
	 * 
	 * @param		e: a click on the level button, replay button, or a button on the grid
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {  //This is the if statements for what happens when a button is pressed
		if(e.getSource() == level){
			new MainMenu();  // goes back to the main menu if the level button is pressed
			frame.setVisible(false);  //removes the current board frame
		}else if(e.getSource() == replay){  
			over = false;
			for(int x = 0; x < buttons.length; x++){
				for(int y = 0; y < buttons[0].length; y++){  //going through the 2D array of buttons
					buttons[x][y].setText("");  //reset the text of mines from X to nothing
					buttons[x][y].setBackground(defaultC);  //set the background to the default color
					buttons[x][y].setEnabled(true);	 //enable the button
				}
			}
			placeMines();  //reset all mines, pretty much makes a new random board
		}else{
			for(int x = 0; x < buttons.length; x++){
				for(int y = 0; y < buttons[0].length; y++){
					if(e.getSource() == buttons[x][y]){  //if a button is pressed thats not replay or level, which leaves only the game buttons
						if(counts[x][y] == mine){  //uses the counts array to find which [x][y] is the mine
							buttons[x][y].setText("X");  //sets the text of the mines as X
							gameover();  //if clicked on mine, execute gameover();
						}else{
							zero(x,y);
							win();
						}
					}
				}
			}
		}
	}
	
	/********************************************************************************************************
	 * 
	 * Method:		gameover
	 * 
	 * Description:	Called when a mine is clicked. Reveals all the mines and counts of the grid buttons.
	 * 				Prompts the user to play again.
	 * 
	 * @param		None
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	public void gameover() {  
		for(int x = 0; x < buttons.length; x++){
			for(int y = 0; y < buttons[0].length; y++){  			//goes through every button
				if(buttons[x][y].isEnabled()){ 						//for the remaining unclicked buttons:
					if(counts[x][y] != mine){  							//IF NOT A MINE:
						buttons[x][y].setText(counts[x][y] + "");  			//shows the number
						buttons[x][y].setBackground(defaultC);				//sets the background to the default color
						buttons[x][y].setEnabled(false);  					//disables the button
					}else{												//IF A MINE:
						buttons[x][y].setText("X");  						//sets the text to X
						buttons[x][y].setBackground(Color.red);  			//sets the background to red
						buttons[x][y].setEnabled(false);  					//disables the button
					}
				}
			}
		}
		
		//Generates a prompt for playing again
		Long end = new Long(System.currentTimeMillis());  
		end = (end - t)/1000;
		int prompt = JOptionPane.showConfirmDialog(frame, "It took you " + end + " seconds to screw up. \n Play again?", "Aw, you lost :(", JOptionPane.OK_CANCEL_OPTION);
		if(prompt == 0){ 				//OK is pressed, sends back to the main menu
			new MainMenu();
			frame.setVisible(false);
		}
	}
	
	/********************************************************************************************************
	 * 
	 * Method:		zero
	 * 
	 * Description: If a button with a count of zero is clicked, recursively reveals the counts of
	 * 				all its surrounding buttons.
	 * 
	 * @param		xx: the horizontal position of the button on the grid
	 * 				yy: the vertical position of the button on the grid
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	private void zero(int xx, int yy){
		if(buttons[xx][yy].isEnabled()){
			buttons[xx][yy].setText(counts[xx][yy] + "");  		//print out the number of mines surrounding the revealed button
			buttons[xx][yy].setEnabled(false);					//disables the button

			if(counts[xx][yy]==0){
				if(xx-1 >= 0 && yy-1 >= 0){						//top left
					zero(xx-1, yy-1);
				}if(xx-1 >= 0){									//top
					zero(xx-1, yy);
				}if(xx-1 >= 0 && yy+1 <= rows-1){				//top right
					zero(xx-1, yy+1);
				}if(yy-1 >= 0){									//left
					zero(xx, yy-1);
				}if(yy+1 <= rows-1){							//right
					zero(xx, yy+1);
				}if(xx+1 <= columns-1 && yy-1 >= 0){			//bottom left
					zero(xx+1, yy-1);
				}if(xx+1 <= columns-1){							//bottom
					zero(xx+1, yy);
				}if(xx+1 <= columns-1 && yy+1 <= rows-1){		//bottom right
					zero(xx+1, yy+1);
				}
			}
		}
	}
	
	/********************************************************************************************************
	 * 
	 * Method:		win
	 * 
	 * Description:	Checks if the user has won the game. If so, records the winning time and
	 * 				prompts the user to play again.
	 * 
	 * @param		None
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	public void win(){
		boolean won = true;
		for(int x = 0; x < counts.length; x++){
			for(int y = 0; y < counts[0].length; y++){
				if(counts[x][y] != mine && buttons[x][y].isEnabled() == true){
					won = false;
				}
			}
		}
		if(won == true){
			over = true;
			Long end = new Long(System.currentTimeMillis());  
			end = (end - t)/1000;
			try { //records received score into file
				fw = new FileWriter("Scores.txt", true);							
				fw.write(lvl + " " + end + " ");
				fw.close();
			} catch (IOException e) {
				System.out.println("However, your score was not recorded.");
			}	
			for(int x = 0; x < buttons.length; x++){
				for(int y = 0; y < buttons[0].length; y++){
					if(buttons[x][y].isEnabled() == true || buttons[x][y].getText() == "F"){
						buttons[x][y].setText("*");
						buttons[x][y].setBackground(Color.green);
						buttons[x][y].setEnabled(false);
					}
				}
			}
			int prompt = JOptionPane.showConfirmDialog(frame, "Your victory took " + end + " seconds. \n Play again?", "Congrats, you won!", JOptionPane.OK_CANCEL_OPTION);
			if(prompt == 0){ 				//ok
				new MainMenu();
				frame.setVisible(false);
			}
		}
	}
}