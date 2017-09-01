import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	//Window Dimensions
	static final int SCREEN_WIDTH = 1250;
	static final int SCREEN_HEIGHT = 1000;
	
	//Screen Index
	static final int MAIN_MENU = 0;
	static final int STATISTICS = 1;
	static final int SONG_SELECT = 2;
	static final int END = 3;
	
	//Song Index
	static final int AMER = 0;
	static final int CANT = 1;
	static final int CHRIST = 2;
	static final int ELA = 3;
	static final int LGHT = 4;
	static final int ROSE = 5;
	static final int SUG = 6;
	static final int LFE = 7;
	
	protected static EZImage mainMenuB, songSelectB, randomSongB, statisticsB, replayB; 	//buttons
	protected static int screenIndex, songIndex; 											//indexes
	protected static boolean loading; 														//loading state
	protected static EZSound SMain = EZ.addSound("openingSong.wav");						//main menu song

	public static void main(String[] args) throws java.io.IOException {
		EZ.initialize(SCREEN_WIDTH, SCREEN_HEIGHT); //sets up EZ 
		loading = true;
		
		// Add sound files for buttons and end screen
		EZSound SMeow1 = EZ.addSound("meow.wav");
		EZSound SMeow2 = EZ.addSound("kitten.wav");
		EZSound SMeow3 = EZ.addSound("tomCat.wav");
		EZSound SEnd = EZ.addSound("EndMusic.wav");

		// create variables to track mouse location
		int clickX = 0;
		int clickY = 0;
		
		while (true) {
			clickX = EZInteraction.getXMouse();	//tracks mouse location
			clickY = EZInteraction.getYMouse();

			/* **BUTTON PRESSED** */
			if (EZInteraction.wasMouseLeftButtonPressed()) {
				loading = true; 	//will send code into loop to switch screen
				
					//Statistics Button pressed
				if (statisticsB.isPointInElement(clickX, clickY)) {
					SMeow1.play();
					SEnd.stop();
					EZ.removeAllEZElements();
					
					screenIndex = STATISTICS; 

					//Song Select button pressed
				} else if (songSelectB.isPointInElement(clickX, clickY)) {
					SMeow2.play();
					SEnd.stop();
					EZ.removeAllEZElements();
					
					screenIndex = SONG_SELECT;

					//Random Song button pressed
				} else if (randomSongB.isPointInElement(clickX, clickY)) {
					SMeow3.play();
					SMain.stop();
					SEnd.stop();
					EZ.removeAllEZElements();

					Random randomSong = new Random();			//generates random song index
					songIndex = randomSong.nextInt(8);

					if(songIndex == AMER){ 						//plays song depending on random song index chosen
						AmericasSuitehearts.main(args);
					}
					if(songIndex == CANT){
						CantHelp.main(args);
					}
					if(songIndex == CHRIST){
						ChristmasSong.main(args);
					}
					if(songIndex == ELA){
						ElasticHeart.main(args);
					}
					if(songIndex == LGHT){
						Light.main(args);
					}
					if(songIndex == ROSE){
						Rose.main(args);
					}
					if(songIndex == SUG){
						SugarSong.main(args); 
					} 
					if(songIndex == LFE){
						LifeBegins.main(args);
					}	
					
					//Main Menu button pressed
				} else if (mainMenuB.isPointInElement(clickX, clickY)) {
					SEnd.stop();
					EZ.removeAllEZElements();
					
					screenIndex = MAIN_MENU;

					//Replay button pressed
				} else if (replayB.isPointInElement(clickX, clickY)){
					SEnd.stop();
					EZ.removeAllEZElements();
					
					if(songIndex == AMER){						//plays song depending on current song index number
						AmericasSuitehearts.main(args);
					}
					if(songIndex == CANT){
						CantHelp.main(args);
					}
					if(songIndex == CHRIST){
						ChristmasSong.main(args);
					}
					if(songIndex == ELA){
						ElasticHeart.main(args);
					}
					if(songIndex == LGHT){
						Light.main(args);
					}
					if(songIndex == ROSE){
						Rose.main(args);
					}
					if(songIndex == SUG){
						SugarSong.main(args); 
					} 
					if(songIndex == LFE){
						LifeBegins.main(args);
					}
				}
			}
			
			if (loading == true) {
				/* ** LOAD A SCREEN ** */
				switch(screenIndex){
				case MAIN_MENU: //Main Menu Screen
					SMain.play();
					
					//Background and Title
					EZ.addImage("karaokeBackground.png", 625, 500);
					EZ.addImage("Welcome.png", 620, 150);
					EZ.addImage("Title.png", 625, 280);
					
					//Buttons
					statisticsB = EZ.addImage("statistics.png", 250, 775);
					statisticsB.scaleBy(0.90);
					songSelectB = EZ.addImage("songSelect.png", 600, 550);
					songSelectB.scaleBy(0.90);
					randomSongB = EZ.addImage("randomSong.png", 1030, 750);
					randomSongB.scaleBy(0.90);
					
					loading = false; //breaks out of loop
					break;

				case STATISTICS: //Statistics Screen
					//CALCULATIONS
					Scanner scoreReader = new Scanner(new File("Scores.txt")); 					//reads saved scores from file
					ArrayList<Integer> leaderboard = new ArrayList<Integer>();

					while (scoreReader.hasNextInt()) { 											//places all previous scores in ArrayList
						leaderboard.add(scoreReader.nextInt());
					}

					for (int i = 0; i < leaderboard.size(); i++) { 							//organizes scores from best to worst
						for (int j = 0; j <= (leaderboard.size() - 2); j++) {
							if (leaderboard.get(j) < leaderboard.get(j + 1)) {
								int tempInt = leaderboard.get(j);
								leaderboard.set(j, leaderboard.get(j + 1));
								leaderboard.set(j + 1, tempInt);
							}
						}
					}scoreReader.close();
					
					while (leaderboard.size() > 5) { 										//removes all scores except top 5
						leaderboard.remove(5);
					}

					//VISUAL
					//Background
					EZ.addImage("karaokeBackground.png", 625, 500);
					
					//Buttons
					mainMenuB = EZ.addImage("mainMenu.png", 110, 110);
					mainMenuB.scaleBy(0.4);
					songSelectB = EZ.addImage("songSelect.png", 400, 100);
					songSelectB.scaleBy(0.4);
					
					//Text
					int fontSize = 100;
					EZText TStats = EZ.addText(900, 100, "STATISTICS",
							Color.white, fontSize);
					TStats.setFont("retro_party.ttf");
					EZText TLeaderboard = EZ.addText(SCREEN_WIDTH / 2, 300,	"LEADERBOARD", Color.white, fontSize);
					TLeaderboard.setFont("Mad Groove Clean.ttf");
					EZText TTop5One = EZ.addText(SCREEN_WIDTH / 2, 475,
							"First Place....." + String.valueOf(leaderboard.get(0)), Color.white, fontSize);
					TTop5One.setFont("retro_party.ttf");
					EZText TTop5Two = EZ.addText(SCREEN_WIDTH / 2, 575,
							"Second Place....."	+ String.valueOf(leaderboard.get(1)), Color.white, fontSize);
					TTop5Two.setFont("retro_party.ttf");
					EZText TTop5Three = EZ.addText(SCREEN_WIDTH / 2, 675,
							"Third Place....." + String.valueOf(leaderboard.get(2)), Color.white, fontSize);
					TTop5Three.setFont("retro_party.ttf");
					EZText TTop5Four = EZ.addText(SCREEN_WIDTH / 2, 775,
							"Fourth Place....." + String.valueOf(leaderboard.get(3)), Color.white, fontSize);
					TTop5Four.setFont("retro_party.ttf");
					EZText TTop5Five = EZ.addText(SCREEN_WIDTH / 2, 875,
							"Fifth Place....." + String.valueOf(leaderboard.get(4)), Color.white, fontSize);
					TTop5Five.setFont("retro_party.ttf");
					
					loading = false; //breaks out of loop
					break;

				case SONG_SELECT: //Song Select Screen					
					SongSelect.main(args);	//sends to songSelect class
					
					loading = false; //breaks out of loop
					break;

				case END: //End Screen
					SEnd.loop();
					
					//CALCULATIONS
					Random randomScore = new Random();							//generates random score between 60 and 100
					int score = randomScore.nextInt((100 - 60) + 1) + 60;
					
					String compliment = null;
					if (score >= 60 && score < 70) {							//assigns a comment depending on score
						compliment = "You Stink!";
					} else if (score >= 70 && score < 80) {
						compliment = "You Rock!";
					} else if (score >= 80 && score < 90) {
						compliment = "Amazing!";
					} else if (score >= 90 && score < 100) {
						compliment = "Encore!";
					} else if (score == 100){
						compliment = "Perfect!";
					}
					
					FileWriter scoreRecord = new FileWriter("Scores.txt", true);		//records recieved score into file
					scoreRecord.write(score + " ");
					scoreRecord.close();					
					
					//VISUAL
					//Background
					EZ.addImage("Background.png", 500, 500);
					
					//Buttons
					mainMenuB = EZ.addImage("mainMenu.png", 100, 100);
					mainMenuB.scaleBy(0.4);
					randomSongB = EZ.addImage("randomSong.png", 850, 800);
					randomSongB.scaleBy(0.40);
					replayB = EZ.addImage("replay.png", 400, 800);
					replayB.scaleBy(0.40);
					songSelectB = EZ.addImage("songSelect.png", 625, 800);
					songSelectB.scaleBy(0.40);
					statisticsB = EZ.addImage("statistics.png", 1120, 90);
					statisticsB.scaleBy(0.40);

					//Text
					EZ.addText(625, 400, "YOUR SCORE IS " + score, Color.blue, 100);
					EZ.addText(625, 500, compliment, Color.blue, 100);
					
					loading = false; //breaks out of loop
					break;
				}
			}
			EZ.refreshScreen(); //visuals update
		}
	}
}