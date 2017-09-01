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
 * FILE:		HighScore.java
 * 	
 * DESCRIPTION:	This file contains the HighScore class for the Group Project. In this class,
 * 				the previous top scores are displayed in a table. The user can choose to return
 * 				to the main menu.
 * 
 **********************************************************************************************/

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class HighScore implements ActionListener{
	private int height = 600;
	private int width = 1100;
	JFrame frame = new JFrame("Minesweeper");
	JButton mainmenu = new JButton("Back to Main Menu");

	/********************************************************************************************************
	 * 
	 * Method:		HighScore
	 * 
	 * Description:	Constructor; creates a new frame in which a table of the best previous scores are displayed.
	 * 				The table is organized by level and best time.
	 * 				Includes a button that when clicked will return the user to the main menu.
	 * 
	 * @param		None
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	public HighScore(){
		frame.setSize(width, height);									//frame l
		frame.setLayout(new BorderLayout()); 
		frame.add(mainmenu, BorderLayout.SOUTH);
		mainmenu.addActionListener(this);

		try{
			Scanner scanner = new Scanner(new File("Scores.txt"));		//places all previous scores into an ArrayList depending on
			ArrayList<Integer> statsL1 = new ArrayList<Integer>();		//the level at which it was scored
			ArrayList<Integer> statsL2 = new ArrayList<Integer>();		//i.e. scores achieved at level 3 are placed in statsL3
			ArrayList<Integer> statsL3 = new ArrayList<Integer>();

			while(scanner.hasNextInt()){
				switch(scanner.nextInt()){
				case 1:
					statsL1.add(scanner.nextInt());
					break;
				case 2:
					statsL2.add(scanner.nextInt());
					break;
				case 3:
					statsL3.add(scanner.nextInt());
					break;
				}
			}scanner.close();

			//LEVEL ONE
			for(int i=0; i<statsL1.size(); i++) {						//organizes Level 1 scores from best to worst
				for(int j=0; j<=(statsL1.size()-2); j++){
					if(statsL1.get(j)>statsL1.get(j+1)){
						int tempInt = statsL1.get(j);
						statsL1.set(j, statsL1.get(j+1));
						statsL1.set(j+1, tempInt);
					}
				}
			}						

			while(statsL1.size()>10){									//places best 10 scores in a String array
				statsL1.remove(10);											
			}
			String[] L1 = new String[10];
			for(int i=0; i<10; i++){
				if(i>=statsL1.size()){
					L1[i] = "";
				}else{
					L1[i] = String.valueOf(statsL1.get(i));
				}
			}

			//L2
			for(int i=0; i<statsL2.size(); i++) {						//organizes Level 2 scores from best to worst
				for(int j=0; j<=(statsL2.size()-2); j++){
					if(statsL2.get(j)>statsL2.get(j+1)){
						int tempInt = statsL2.get(j);
						statsL2.set(j, statsL2.get(j+1));
						statsL2.set(j+1, tempInt);
					}
				}
			}						

			while(statsL2.size()>10){									//places best 10 scores in a String array
				statsL2.remove(10);
			}
			String[] L2 = new String[10];
			for(int i=0; i<10; i++){
				if(i>=statsL2.size()){
					L2[i] = "";
				}else{
					L2[i] = String.valueOf(statsL2.get(i));
				}
			}

			//L3
			for(int i=0; i<statsL3.size(); i++) {						//organizes Level 3 scores from best to worst
				for(int j=0; j<=(statsL3.size()-2); j++){
					if(statsL3.get(j)>statsL3.get(j+1)){
						int tempInt = statsL3.get(j);
						statsL3.set(j, statsL3.get(j+1));
						statsL3.set(j+1, tempInt);
					}
				}
			}						

			while(statsL3.size()>10){									//places best 10 scores in a String array
				statsL3.remove(10);
			}
			String[] L3 = new String[10];
			for(int i=0; i<10; i++){
				if(i>=statsL3.size()){
					L3[i] = "";
				}else{
					L3[i] = String.valueOf(statsL3.get(i));
				}
			}

			//creates a table at the top of the frame, based on the string arrays of best scores
			String[] colnames = {"Rank", "Level 1 (seconds)", "Level 2 (seconds)", "Level 3 (seconds)"};
			Object[][] data = {
					{1, L1[0], L2[0], L3[0]}, {2, L1[1], L2[1], L3[1]}, {3, L1[2], L2[2], L3[2]}, {4, L1[3], L2[3], L3[3]}, {5, L1[4], L2[4], L3[4]}, 
					{6, L1[5], L2[5], L3[5]}, {7, L1[6], L2[6], L3[6]}, {8, L1[7], L2[7], L3[7]}, {9, L1[8], L2[8], L3[8]}, {10, L1[9], L2[9], L3[9]}
			};

			JTable leaderboard = new JTable(data, colnames);
			frame.add(leaderboard.getTableHeader(), BorderLayout.PAGE_START);
			frame.add(leaderboard, BorderLayout.CENTER);

		}catch(FileNotFoundException f){		//in case Scores.txt does not yet exist (no high scores yet made)
			JTextArea message = new JTextArea("The previous scores could not be loaded. \n Try setting some high scores first!");
			frame.add(message, BorderLayout.CENTER);
		}

		frame.setVisible(true);									
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	
	}
	
	/********************************************************************************************************
	 * 
	 * Method:		actionPerformed
	 * 
	 * Description:	Activates when the main menu button is clicked. Returns the user to the main menu.
	 * 
	 * @param		e: a click on the main menu button
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainmenu){	
			new MainMenu();
			frame.setVisible(false);
		}
	}
}