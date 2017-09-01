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
 * FILE:		MainMenu.java
 * 	
 * DESCRIPTION:	This file contains the Main Menu class for the Group Project. In this class,
 * 				the user can pick a level or choose to view the high scores.
 * 
 **********************************************************************************************/

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu implements ActionListener {
	JFrame frame = new JFrame("Minesweeper");
	JButton level1 = new JButton("Level 1"); 
	JButton level2 = new JButton("Level 2");
	JButton level3 = new JButton("Level 3");
	JButton highscore = new JButton("High Score");
	
	/********************************************************************************************************
	 * 
	 * Method:		MainMenu
	 * 
	 * Description:	Constructor; creates a new frame that has four buttons, one each to lead to 
	 * 				a Level 1 game, a Level 2 game, a Level 3 game, or the high score leaderboard.
	 * 
	 * @param		None
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	public MainMenu(){
		frame.setSize(1000, 600);
		frame.setLayout(new GridLayout());
		frame.add(level1, BorderLayout.WEST);
		frame.add(level2, BorderLayout.CENTER);
		frame.add(level3, BorderLayout.EAST);
		frame.add(highscore, BorderLayout.SOUTH);
		level1.addActionListener(this);
		level2.addActionListener(this);
		level3.addActionListener(this);
		highscore.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/********************************************************************************************************
	 * 
	 * Method:		actionPerformed
	 * 
	 * Description:	Activates when any button is clicked. Depending on the button, leads to a different frame.
	 * 				- level1: leads to a Level 1 game (10x10 grid with 9 mines)
	 *				- level2: leads to a Level 2 game (15x15 grid with 50 mines)
	 * 				- level3: leads to a Level 3 game (20x20 grid with 100 mines)
	 * 				- highscore: leads to the high score leaderboard
	 * 
	 * @param		e: a click on the level1 button, level2 button, level3 button, or highscore button
	 * 
	 * @return		None
	 * 
	 ********************************************************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == level1){		//Level One
			new Board(10,10);
			frame.setVisible(false);	
		}
		if(e.getSource() == level2){		//Level Two
			new Board(15,15);
			frame.setVisible(false);
		}
		if(e.getSource() == level3){		//Level Three
			new Board(20,20);
			frame.setVisible(false);
		}
		if(e.getSource() == highscore){		//High Score Leaderboard
			new HighScore();
			frame.setVisible(false);
		}
	}
}