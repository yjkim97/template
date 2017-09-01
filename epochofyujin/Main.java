import java.awt.Color;
//*******************COPY PASTE 4 ON 5-9**************************
import java.util.ArrayList;

public class Main {

	static EZSound BGM;
	static private int first = 1;
	static private int level3first = 1;
	static private boolean KilledEvil;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EZ.initialize(1024, 768);
		/*IntroScreen();
		IntroStory();
		Workout();
		GateStory();
		GatePuzzle();
		GatePuzzle2();
		GatePuzzle3();
		Level1Intro();
		Level1();
		Level1b();
		Level1c();
		Level2Intro();
		Level2();
		Level2b();
		Level2c();
		Level3Intro();
		Level3();*/
		FinalBossIntro();
		FinalBoss();
		if(KilledEvil == true){
			Outro1();
		}else{
			Outro2();
		}
		
	}
	public static void IntroScreen(){     //Finished
		Color c = new Color(0, 50, 100);
		Color white = new Color(255, 255, 255);
		EZSound IntroMus = EZ.addSound("IntroMus.wav");
		int clickX = 0;
		int clickY = 0;
		
		EZImage BG = EZ.addImage("BlueCity.png", 512, 350);
		
		int txt1xpos = 0;
		EZText txt1 = EZ.addText(txt1xpos, (768/2)-75, "EPOCH", c);
		txt1.setFontSize(60);
		txt1.setFont("8-BIT WONDER.TTF");
		txt1.hide();
		
		int txt2xpos = 0;
		EZText txt2 = EZ.addText(txt2xpos, 768/2, "OF", c);
		txt2.setFontSize(60);
		txt2.setFont("8-BIT WONDER.TTF");
		txt2.hide();
				
		int txt3xpos = 0;
		EZText txt3 = EZ.addText(txt3xpos, (768/2)+75, "YUJIN", c);
		txt3.setFontSize(60);
		txt3.setFont("8-BIT WONDER.TTF");
		txt3.hide();
		
		
		while(txt1xpos != 512){
			txt1.show();
			txt1.translateTo(txt1xpos, (768/2)-75);
			txt1xpos = txt1xpos + 16;
			EZ.refreshScreen();
		}
		try {
		    Thread.sleep(200);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		while(txt2xpos != 512){
			txt2.show();
			txt2.translateTo(txt2xpos, (768/2));
			txt2xpos = txt2xpos + 16;
			EZ.refreshScreen();
		}
		try {
		    Thread.sleep(200);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		while(txt3xpos != 512){
			txt3.show();
			txt3.translateTo(txt3xpos,  (768/2)+75);
			txt3xpos = txt3xpos + 16;
			EZ.refreshScreen();
		}
		IntroMus.loop();
		
		int txt4xpos = 512;
		EZText txt4 = EZ.addText(512, (768/2)+170, "PRESS TO START", white);
		txt4.setFontSize(30);
		txt4.setFont("8-BIT WONDER.TTF");
		
		boolean right = true;
		while(!EZInteraction.wasMouseLeftButtonPressed() || !EZInteraction.isKeyDown(' ')){
			if(EZInteraction.wasMouseLeftButtonPressed() || EZInteraction.isKeyDown(' ')){
				break;
			}
			txt4.translateTo(txt4xpos, (768/2)+170);
			if(txt4xpos > 511 && right == true && txt4xpos < 520){
				txt4xpos = txt4xpos + 1;
				if(EZInteraction.wasMouseLeftButtonPressed() || EZInteraction.isKeyDown(' ')){
					break;
				}
			}
			if(txt4xpos == 520){
				right = false; 
				txt4xpos = txt4xpos - 1;
				if(EZInteraction.wasMouseLeftButtonPressed() || EZInteraction.isKeyDown(' ')){
					break;
				}
			}
			if(txt4xpos < 520 && right == false && txt4xpos > 500){
				txt4xpos = txt4xpos - 1;
				if(EZInteraction.wasMouseLeftButtonPressed() || EZInteraction.isKeyDown(' ')){
					break;
				}
			}
			if(txt4xpos > 500 && right == true && txt4xpos < 520){
				txt4xpos = txt4xpos + 1;
				if(EZInteraction.wasMouseLeftButtonPressed() || EZInteraction.isKeyDown(' ')){
					break;
				}
			}
			if(txt4xpos == 500){
				right = true;
				txt4xpos = txt4xpos + 1;
				if(EZInteraction.wasMouseLeftButtonPressed() || EZInteraction.isKeyDown(' ')){
					break;
				}
			}
			
			EZ.refreshScreen();
		}
		IntroMus.stop();
		EZ.removeAllEZElements();
		
	}
	public static void IntroStory(){     //Finished
		int click = 0;
		Color red = new Color (255, 0 ,0);
		
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		EZ.removeAllEZElements();
		
		EZText cont = EZ.addText(900, 750, "click to continue", red);
		cont.setFont("8-BIT WONDER.TTF");
		
		EZText txt1 = EZ.addText(512, 684, "There once was a man named YuJin", red);
		txt1.setFont("8-BIT WONDER.TTF");
		txt1.setFontSize(30);
		
		EZImage YJ = EZ.addImage("YuJin1.png", 512, 384);

		EZSound mus = EZ.addSound("Hotel1.wav");
		mus.loop();
		
		while(true){	
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
				if(click == 1){
					EZ.removeAllEZElements();
					EZText cont1 = EZ.addText(900, 750, "click to continue", red);
					cont1.setFont("8-BIT WONDER.TTF");
					EZText txt2 = EZ.addText(512, 684, "He was deeply in love with Kara", red);
					txt2.setFont("8-BIT WONDER.TTF");
					txt2.setFontSize(30);
					
					EZImage Heart = EZ.addImage("Heart.png", 512, 200);
					Heart.scaleBy(.6);
					EZImage YJ1 = EZ.addImage("YuJin1.png", 312, 384);
					EZImage Kara = EZ.addImage("Kara1.png", 712, 384);
					Kara.scaleBy(.6);
				}
				if(click == 2){
					EZ.removeAllEZElements();
					EZText cont1 = EZ.addText(900, 750, "click to continue", red);
					cont1.setFont("8-BIT WONDER.TTF");
					EZText txt3 = EZ.addText(512, 684, "One day they were about to have fun fun time", red);
					txt3.setFont("8-BIT WONDER.TTF");
					txt3.setFontSize(25);
					
					EZImage YJ1 = EZ.addImage("YuJin1.png", 650, 300);
					YJ1.rotateBy(55);
					EZImage Kara = EZ.addImage("Kara1.png", 712, 484);
					Kara.scaleBy(.6);
					Kara.rotateBy(75);
					EZImage Heart1 = EZ.addImage("Heart.png", 212, 400);
					Heart1.scaleBy(.6);
					Heart1.rotateBy(20);
					EZImage Heart2 = EZ.addImage("Heart.png", 112, 250);
					Heart2.scaleBy(.3);
					Heart2.rotateBy(350);
					EZImage Heart3 = EZ.addImage("Heart.png", 412, 200);
					Heart3.scaleBy(.4);
				}
				if(click == 3){
					EZ.removeAllEZElements();
					EZText cont1 = EZ.addText(900, 750, "click to continue", red);
					cont1.setFont("8-BIT WONDER.TTF");
					EZText txt4 = EZ.addText(512, 684, "When all of a sudden an evil man appears", red);
					txt4.setFont("8-BIT WONDER.TTF");
					txt4.setFontSize(27);
					
					EZImage YJ1 = EZ.addImage("YuJin1.png", 650, 300);
					YJ1.rotateBy(55);
					EZImage Kara = EZ.addImage("Kara1.png", 712, 484);
					Kara.scaleBy(.6);
					Kara.rotateBy(75);
					EZImage Evil1 = EZ.addImage("Evil1.png", 312, 350);
				}
				if(click == 4){
					EZ.removeAllEZElements();
					EZText cont1 = EZ.addText(900, 750, "click to continue", red);
					cont1.setFont("8-BIT WONDER.TTF");
					EZText txt5 = EZ.addText(512, 684, "He cockblocks YuJin and kidnaps Kara", red);
					txt5.setFont("8-BIT WONDER.TTF");
					txt5.setFontSize(27);
					
					EZImage YJ1 = EZ.addImage("YuJin2.png", 650, 350);
					EZImage Kara = EZ.addImage("Kara1.png", 12, 350);
					Kara.scaleBy(.6);
					EZImage Evil1 = EZ.addImage("Evil1.png", 212, 350);
				}
				if(click == 5){
					EZ.removeAllEZElements();
					EZText cont1 = EZ.addText(900, 750, "click to continue", red);
					cont1.setFont("8-BIT WONDER.TTF");
					EZText txt6 = EZ.addText(512, 684, "He locks her up in a far away dungeon", red);
					txt6.setFont("8-BIT WONDER.TTF");
					txt6.setFontSize(27);
					
					EZImage Kara = EZ.addImage("Kara1.png", 670, 250);
					Kara.scaleBy(.3);
					EZImage Evil1 = EZ.addImage("Evil1.png", 770, 250);
					Evil1.scaleBy(.6);
					EZImage Tower = EZ.addImage("Tower.png", 900, 200);
				}
				if(click == 6){
					EZ.removeAllEZElements();
					EZText cont1 = EZ.addText(900, 750, "click to continue", red);
					cont1.setFont("8-BIT WONDER.TTF");
					EZText txt7 = EZ.addText(512, 684, "Now YuJin must go and save Kara", red);
					txt7.setFont("8-BIT WONDER.TTF");
					txt7.setFontSize(30);
					
					EZImage YJ1 = EZ.addImage("YuJin1.png", 512, 384);
				}
				if(click == 7){
					EZ.removeAllEZElements();
					EZText cont1 = EZ.addText(900, 750, "click to continue", red);
					cont1.setFont("8-BIT WONDER.TTF");
					EZText txt8 = EZ.addText(512, 684, "But first YuJin must get buff", red);
					txt8.setFont("8-BIT WONDER.TTF");
					txt8.setFontSize(30);
					
					EZImage YJ1 = EZ.addImage("YuJin3.png", 512, 384);
					
				}
				if(click == 8){
					EZ.removeAllEZElements();
					mus.stop();
					break;
				}
			}
			EZ.refreshScreen();
		}
	}
	public static void Workout(){     //Finished
		Color blue = new Color(255, 0, 0);

		EZSound GT = EZ.addSound("GuileTheme.wav");
		GT.loop();
		
		EZText load = EZ.addText(512, 384, "Loading", blue);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		
		EZText cont = EZ.addText(880, 420, "click to cont", blue);
		cont.setFontSize(10);
		cont.setFont("8-BIT WONDER.TTF");
		
		EZText Instruct = EZ.addText(512, 384, "Click to make YuJin do push ups", blue);
		Instruct.setFontSize(30);
		Instruct.setFont("8-BIT WONDER.TTF");
		
		
		int click = 0;
		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
			//	String cl = String.valueOf(click);
				if(click == 1){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "0", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 2){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "0", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 3){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "1", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 4){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "1", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 5){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "2", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 6){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "2", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 7){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "3", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 8){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "3", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 9){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "4", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 10){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "4", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 11){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "5", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 12){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "5", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 13){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "6", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 14){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "6", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 15){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "7", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 16){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "7", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 17){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "8", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 18){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "8", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 19){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "9", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 20){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "9", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 21){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "10", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 22){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "10", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 23){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "11", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 24){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "11", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 25){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "12", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 26){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "12", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 27){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "13", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 28){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "13", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 29){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "14", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 30){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "14", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 31){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "15", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 32){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "15", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 33){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "16", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 34){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "17", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 35){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "17", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 36){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "18", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 37){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "18", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 38){
					EZ.removeAllEZElements();
					EZImage PU2 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "19", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 39){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "19", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 40){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp2.png", 500, 428);
					EZText txt = EZ.addText(700, 200, "20", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 41){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("PushUp1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "20", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 42){
					EZ.removeAllEZElements();
					EZText GJ = EZ.addText(512, 384, "Good Job", blue);
					GJ.setFontSize(50);
					GJ.setFont("8-BIT WONDER.TTF");
					
					try {
					    Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					
					EZText cont2 = EZ.addText(880, 420, "click to cont", blue);
					cont.setFontSize(10);
					cont.setFont("8-BIT WONDER.TTF");
					break;
				}
			}
			EZ.refreshScreen();
		}

		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
				if(click == 43){
					EZ.removeAllEZElements();
					EZText cont3 = EZ.addText(880, 420, "click to cont", blue);
					cont3.setFontSize(10);
					cont3.setFont("8-BIT WONDER.TTF");
					
					EZText Instruct2 = EZ.addText(512, 384, "Click to make YuJin do hip thrusts", blue);
					Instruct2.setFontSize(30);
					Instruct2.setFont("8-BIT WONDER.TTF");
				}
				if(click == 44){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "0", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 45){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "1", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 46){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "1", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 47){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "2", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 48){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "2", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 49){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "3", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 50){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "3", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 51){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "4", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 52){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "4", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 53){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "5", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 54){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "5", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 55){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "6", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 56){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "6", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 57){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "7", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 58){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "7", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 59){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "8", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 60){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "8", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 61){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "9", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 62){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "9", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 63){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "10", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 64){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "10", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 65){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "11", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 66){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "11", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 67){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "12", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 68){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "12", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 69){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "13", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 70){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "13", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 71){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "14", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 72){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "14", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 73){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "15", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 74){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "15", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 75){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "16", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 76){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "16", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 77){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "17", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 78){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "17", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 79){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "18", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 80){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "18", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 81){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "19", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 82){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "19", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 83){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("HipThrust2.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "20", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 84){
					EZ.removeAllEZElements();
					EZText GJ = EZ.addText(512, 384, "Almost there", blue);
					GJ.setFontSize(50);
					GJ.setFont("8-BIT WONDER.TTF");
					
					try {
					    Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					
					EZText cont2 = EZ.addText(880, 420, "click to cont", blue);
					cont.setFontSize(10);
					cont.setFont("8-BIT WONDER.TTF");
					break;
				}
			}
			EZ.refreshScreen();
		}
		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
				if(click == 85){
					EZ.removeAllEZElements();
					EZText cont3 = EZ.addText(880, 420, "click to cont", blue);
					cont3.setFontSize(10);
					cont3.setFont("8-BIT WONDER.TTF");
					
					EZText Instruct2 = EZ.addText(512, 384, "Click to make YuJin do squats", blue);
					Instruct2.setFontSize(30);
					Instruct2.setFont("8-BIT WONDER.TTF");
				}
				if(click == 86){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "0", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 87){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "0", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 88){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "1", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 89){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "1", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 90){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "2", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 91){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "2", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 92){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "3", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 93){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "3", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 94){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "4", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 95){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "4", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 96){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "5", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 97){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "5", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 98){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "6", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 99){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "6", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 100){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "7", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 101){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "7", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 102){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "8", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 103){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "8", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 104){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "9", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 105){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "9", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 106){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "10", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 107){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "10", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 108){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "11", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 109){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "11", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 110){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "12", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 111){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "12", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 112){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "13", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 113){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "13", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 114){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "14", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 115){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "14", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 116){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "15", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 117){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "15", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 118){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "16", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 119){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "16", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 120){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "17", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 121){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "17", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 122){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "18", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 123){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "18", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 124){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "19", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 125){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat2.png", 512, 450);
					EZText txt = EZ.addText(700, 200, "19", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 126){
					EZ.removeAllEZElements();
					EZImage PU1 = EZ.addImage("Squat1.png", 512, 384);
					EZText txt = EZ.addText(700, 200, "20", blue);
					txt.setFontSize(50);
					txt.setFont("8-BIT WONDER.TTF");
				}
				if(click == 127){
					EZ.removeAllEZElements();
					EZText GJ = EZ.addText(512, 384, "YuJin is finally buff", blue);
					GJ.setFontSize(50);
					GJ.setFont("8-BIT WONDER.TTF");
					
					try {
					    Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					
					EZText cont2 = EZ.addText(880, 420, "click to cont", blue);
					cont.setFontSize(10);
					cont.setFont("8-BIT WONDER.TTF");
					break;
				}
			}
			EZ.refreshScreen();
		}
		EZ.removeAllEZElements();
		int x = -100;
		int y = 384;
		EZImage GN = EZ.addImage("GigaNigga2.png", x, y);
		while(true){
			x = x+2;
			GN.translateTo(x, y);
			if(x == 1300){
				break;
			}
			EZ.refreshScreen();
		}
		EZ.removeAllEZElements();
		GT.stop();
	}
	public static void GateStory(){     //Finished
		Color red = new Color(255, 0, 0);
		
		EZSound CoH = EZ.addSound("CoH.wav");
		CoH.loop();
		BGM = CoH;
		
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();

		EZText cont = EZ.addText(900, 750, "click to continue", red);
		cont.setFont("8-BIT WONDER.TTF");
		
		EZText txt1 = EZ.addText(512, 684, "Now its time for YuJin to find Kara", red);
		txt1.setFont("8-BIT WONDER.TTF");
		txt1.setFontSize(30);
		
		EZImage GN1 = EZ.addImage("GigaNigga2.png", 512, 300);
		GN1.scaleBy(.7);

		int click = 0;
		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
				if(click == 1){
					EZ.removeAllEZElements();
					EZText txt2 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "YuJin goes to the tower", red, 30);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZImage GN = EZ.addImage("GigaNigga2.png", 200, 300);
					GN.scaleBy(.7);
					EZImage Tower = EZ.addImage("Tower.png", 900, 200);
				}
				if(click == 2){
					EZ.removeAllEZElements();
					EZText txt2 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "But gets greeted by a gate guard", red, 30);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZImage GN = EZ.addImage("GigaNigga2.png", 200, 300);
					GN.scaleBy(.7);
					EZImage Tower = EZ.addImage("Tower.png", 900, 200);
					EZImage GG = EZ.addImage("GateGuard.png", 700, 200);
					GG.scaleBy(.6);
				}
				if(click == 3){
					EZ.removeAllEZElements();
					EZText txt2 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Solve these three puzzles to pass", red, 30);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZImage GG = EZ.addImage("GateGuard.png", 400, 300);
					GG.scaleBy(.8);
					EZImage ques = EZ.addImage("QuestionMark.png", 700, 100);
					ques.scaleBy(.5);
				}
				if(click == 4){
					EZ.removeAllEZElements();
					EZText txt2 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Or never see Kara again bwahahahaha", red, 30);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZImage GG = EZ.addImage("GateGuard.png", 300, 300);
					GG.scaleBy(.8);
					EZImage Kara = EZ.addImage("Kara1.png", 700, 300);
					Kara.scaleBy(.7);
				}
				if(click == 5){
					EZ.removeAllEZElements();
					break;
				}
			}
			EZ.refreshScreen();
		}
	}
	public static void GatePuzzle(){     //Finished
		Color red = new Color(255, 0, 0);
		
		//EZSound mus = EZ.addSound("TSFH.wav");
		//mus.loop();
		
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		EZText instruction = EZ.addText(512, 100, "Input the mmddyy you met Kara", red, 30);
		
		EZImage sq1 = EZ.addImage("Square.png", 80, 600);
		sq1.scaleBy(.5);
		EZImage sq2 = EZ.addImage("Square.png", 250, 600);
		sq2.scaleBy(.5);
		EZImage sq3 = EZ.addImage("Square.png", 420, 600);
		sq3.scaleBy(.5);
		EZImage sq4 = EZ.addImage("Square.png", 590, 600);
		sq4.scaleBy(.5);
		EZImage sq5 = EZ.addImage("Square.png", 760, 600);
		sq5.scaleBy(.5);
		EZImage sq6 = EZ.addImage("Square.png", 930, 600);
		sq6.scaleBy(.5);
		
		EZImage one = EZ.addImage("one.png", 50, 350);
		EZImage two = EZ.addImage("two.png", 150, 350);
		EZImage three = EZ.addImage("three.png", 250, 350);
		EZImage four = EZ.addImage("four.png", 350, 350);
		EZImage five = EZ.addImage("five.png", 450, 350);
		EZImage six = EZ.addImage("six.png", 550, 350);
		EZImage seven = EZ.addImage("seven.png", 650, 350);
		EZImage eight = EZ.addImage("eight.png", 750, 350);
		EZImage nine = EZ.addImage("nine.png", 850, 350);
		EZImage zero = EZ.addImage("zero.png", 950, 350);
		
		ImageArray array1 = new ImageArray(7, "one.png");
		ImageArray array2 = new ImageArray(7, "two.png");
		ImageArray array3 = new ImageArray(7, "three.png");
		ImageArray array4 = new ImageArray(7, "four.png");
		ImageArray array5 = new ImageArray(7, "five.png");
		ImageArray array6 = new ImageArray(7, "six.png");
		ImageArray array7 = new ImageArray(7, "seven.png");
		ImageArray array8 = new ImageArray(7, "eight.png");
		ImageArray array9 = new ImageArray(7, "nine.png");
		ImageArray array0 = new ImageArray(7, "zero.png");
		
		int onecount = -1;
		int twocount = -1;
		int threecount = -1;
		int fourcount = -1;
		int fivecount = -1;
		int sixcount = -1;
		int sevencount = -1;
		int eightcount = -1;
		int ninecount = -1;
		int zerocount = -1;
		
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		int index4 = 0;
		int index5 = 0;
		int index6 = 0;
		
		EZ.refreshScreen();
		int clickX = 0;
		int clickY = 0;
		while(true){

			
			if(index1 == 1 && index2 == 1 && index3 == 1 && index4 == 1 && index5 == 1 && index6 == 1){
				System.out.println("break");
				break;
			}
			clickX = EZInteraction.getXMouse();
			clickY = EZInteraction.getYMouse();
			if(EZInteraction.wasMouseLeftButtonPressed()){
				//one
				if(one.isPointInElement(clickX, clickY)){
					onecount++;
					array1.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array1.images[onecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 80, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 250, 600);
							//one.translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
							
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 420, 600);
							//one.translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 590, 600);
							//one.translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 760, 600);
							//one.translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 930, 600);
							//one.translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else{
							array1.removeImage(array1.images[onecount]);
							onecount--;
						}
					}
					
					//System.out.println(index1 + " " + index3 +" " + index4 + " " + index5);
				}
				//two
				if(two.isPointInElement(clickX, clickY)){
					twocount++;
					array2.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array2.images[twocount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else{
							array2.removeImage(array2.images[twocount]);
							twocount--;
						}
					}
				}
				//three
				if(three.isPointInElement(clickX, clickY)){
					threecount++;
					array3.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array3.images[threecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}
						else{
							array3.removeImage(array3.images[threecount]);
							threecount--;
						}
					}
				}
				//four
				if(four.isPointInElement(clickX, clickY)){
					fourcount++;
					array4.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array4.images[fourcount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}
						else{
							array4.removeImage(array4.images[fourcount]);
							fourcount--;
						}
					}
				}
				//five
				if(five.isPointInElement(clickX, clickY)){
					fivecount++;
					array5.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array5.images[fivecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}
						else{
							array5.removeImage(array5.images[fivecount]);
							fivecount--;
						}
					}
				}
				//six
				if(six.isPointInElement(clickX, clickY)){
					sixcount++;
					array6.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array6.images[sixcount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}
						else{
							array6.removeImage(array6.images[sixcount]);
							sixcount--;
						}
					}
				}
				//seven
				if(seven.isPointInElement(clickX, clickY)){
					sevencount++;
					array7.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array7.images[sevencount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}
						}
						else{
							array7.removeImage(array7.images[sevencount]);
							sevencount--;
						}
					}
				}
				//eight
				if(eight.isPointInElement(clickX, clickY)){
					eightcount++;
					array8.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array8.images[eightcount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}
						}
						else{
							array8.removeImage(array8.images[eightcount]);
							eightcount--;
						}
					}
				}
				//nine
				if(nine.isPointInElement(clickX, clickY)){
					ninecount++;
					array9.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array9.images[ninecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}
						}
						else{
							array9.removeImage(array9.images[ninecount]);
							ninecount--;
						}
					}
				}
				//zero
				if(zero.isPointInElement(clickX, clickY)){
					zerocount++;
					array0.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array0.images[zerocount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}
						}
						else{
							array0.removeImage(array0.images[zerocount]);
							zerocount--;
						}
					}
				}
				System.out.println(index1 + " " + index2 + " " + index3 + " " + index4 + " " + index5 + " " + index6);
			}
			if(!(zerocount == -1)){
				for(int i = 0; i <= zerocount; i++){
					if(array0.images[i].isPointInElement(250, 600)){
						index2 = 1;
						break;
					}
					else{
						index2 = 0;
					}
				}
			}else{
				index2 = 0;
			}
			for(int i = 0; i <= onecount; i++){
				if(array1.images[i].isPointInElement(80, 600)){
					index1 = 1;
					break;
				}
				else{
					index1 = 0;
				}
			}
			for(int i = 0; i <= onecount; i++){
				if(array1.images[i].isPointInElement(420, 600)){
					index3 = 1;
					break;
				}else{
					index3 = 0;
				}
			}
			for(int i = 0; i <= onecount; i++){
				if(array1.images[i].isPointInElement(590, 600)){
					index4 = 1;
					break;
				}
				else{
					index4 = 0;
				}
			}
			for(int i = 0; i <= onecount; i++){
				if(array1.images[i].isPointInElement(760, 600)){
					index5 = 1;
					break;
				}
				else{
					index5 = 0;
				}
			}
			if(!(sixcount == -1)){
				for(int i = 0; i <= sixcount; i++){
					if(array6.images[i].isPointInElement(930, 600)){
						index6 = 1;
						break;
					}
					else{
						index6 = 0;
					}
				}
			}
			else{
				index6 = 0;
			}
			EZ.refreshScreen();
		}
		EZ.removeAllEZElements();
	}
	public static void GatePuzzle2(){     //Finished
		
		Color red = new Color(255, 0, 0);
		
		//EZSound mus = EZ.addSound("TSFH.wav");
		//mus.loop();
		
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		EZText instruction = EZ.addText(512, 100, "Input the mmddyy that you and Kara kissed", red, 25);
		
		EZImage sq1 = EZ.addImage("Square.png", 80, 600);
		sq1.scaleBy(.5);
		EZImage sq2 = EZ.addImage("Square.png", 250, 600);
		sq2.scaleBy(.5);
		EZImage sq3 = EZ.addImage("Square.png", 420, 600);
		sq3.scaleBy(.5);
		EZImage sq4 = EZ.addImage("Square.png", 590, 600);
		sq4.scaleBy(.5);
		EZImage sq5 = EZ.addImage("Square.png", 760, 600);
		sq5.scaleBy(.5);
		EZImage sq6 = EZ.addImage("Square.png", 930, 600);
		sq6.scaleBy(.5);
		
		EZImage one = EZ.addImage("one.png", 50, 350);
		EZImage two = EZ.addImage("two.png", 150, 350);
		EZImage three = EZ.addImage("three.png", 250, 350);
		EZImage four = EZ.addImage("four.png", 350, 350);
		EZImage five = EZ.addImage("five.png", 450, 350);
		EZImage six = EZ.addImage("six.png", 550, 350);
		EZImage seven = EZ.addImage("seven.png", 650, 350);
		EZImage eight = EZ.addImage("eight.png", 750, 350);
		EZImage nine = EZ.addImage("nine.png", 850, 350);
		EZImage zero = EZ.addImage("zero.png", 950, 350);
		
		ImageArray array1 = new ImageArray(7, "one.png");
		ImageArray array2 = new ImageArray(7, "two.png");
		ImageArray array3 = new ImageArray(7, "three.png");
		ImageArray array4 = new ImageArray(7, "four.png");
		ImageArray array5 = new ImageArray(7, "five.png");
		ImageArray array6 = new ImageArray(7, "six.png");
		ImageArray array7 = new ImageArray(7, "seven.png");
		ImageArray array8 = new ImageArray(7, "eight.png");
		ImageArray array9 = new ImageArray(7, "nine.png");
		ImageArray array0 = new ImageArray(7, "zero.png");
		
		int onecount = -1;
		int twocount = -1;
		int threecount = -1;
		int fourcount = -1;
		int fivecount = -1;
		int sixcount = -1;
		int sevencount = -1;
		int eightcount = -1;
		int ninecount = -1;
		int zerocount = -1;
		
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		int index4 = 0;
		int index5 = 0;
		int index6 = 0;
		
		EZ.refreshScreen();
		int clickX = 0;
		int clickY = 0;
		while(true){
			if(index1 == 1 && index2 == 1 && index3 == 1 && index4 == 1 && index5 == 1 && index6 == 1){
				System.out.println("break");
				break;
			}
			clickX = EZInteraction.getXMouse();
			clickY = EZInteraction.getYMouse();
			if(EZInteraction.wasMouseLeftButtonPressed()){
				//one
				if(one.isPointInElement(clickX, clickY)){
					onecount++;
					array1.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array1.images[onecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 80, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 250, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 420, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 590, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 760, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 930, 600);
							for(int i = 0; i < 6; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else{
							array1.removeImage(array1.images[onecount]);
							onecount--;
						}
					}
				}
				//two
				if(two.isPointInElement(clickX, clickY)){
					twocount++;
					array2.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array2.images[twocount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else{
							array2.removeImage(array2.images[twocount]);
							twocount--;
						}
					}
				}
				//three
				if(three.isPointInElement(clickX, clickY)){
					threecount++;
					array3.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array3.images[threecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}
						else{
							array3.removeImage(array3.images[threecount]);
							threecount--;
						}
					}
				}
				//four
				if(four.isPointInElement(clickX, clickY)){
					fourcount++;
					array4.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array4.images[fourcount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}
						else{
							array4.removeImage(array4.images[fourcount]);
							fourcount--;
						}
					}
				}
				//five
				if(five.isPointInElement(clickX, clickY)){
					fivecount++;
					array5.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array5.images[fivecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}
						else{
							array5.removeImage(array5.images[fivecount]);
							fivecount--;
						}
					}
				}
				//six
				if(six.isPointInElement(clickX, clickY)){
					sixcount++;
					array6.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array6.images[sixcount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}
						else{
							array6.removeImage(array6.images[sixcount]);
							sixcount--;
						}
					}
				}
				//seven
				if(seven.isPointInElement(clickX, clickY)){
					sevencount++;
					array7.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array7.images[sevencount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}
						}
						else{
							array7.removeImage(array7.images[sevencount]);
							sevencount--;
						}
					}
				}
				//eight
				if(eight.isPointInElement(clickX, clickY)){
					eightcount++;
					array8.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array8.images[eightcount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}
						}
						else{
							array8.removeImage(array8.images[eightcount]);
							eightcount--;
						}
					}
				}
				//nine
				if(nine.isPointInElement(clickX, clickY)){
					ninecount++;
					array9.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array9.images[ninecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}
						}
						else{
							array9.removeImage(array9.images[ninecount]);
							ninecount--;
						}
					}
				}
				//zero
				if(zero.isPointInElement(clickX, clickY)){
					zerocount++;
					array0.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array0.images[zerocount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(80, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(80, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(80, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(80, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(80, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(80, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(80, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(80, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(80, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(80, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(80, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(250, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(250, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(250, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(250, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(250, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(250, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(250, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(250, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(250, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(250, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(250, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(420, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(420, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(420, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(420, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(420, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(420, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(420, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(420, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(420, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(420, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(420, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(590, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(590, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(590, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(590, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(590, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(590, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(590, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(590, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(590, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(590, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(590, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}

						}
						else if(sq5.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(760, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(760, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(760, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(760, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(760, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(760, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(760, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(760, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(760, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(760, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(760, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}

						}
						else if(sq6.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(930, 600);
							for(int i = 0; i < 6; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(930, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(930, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(930, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(930, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(930, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(930, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(930, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(930, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(930, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(930, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}
						}
						else{
							array0.removeImage(array0.images[zerocount]);
							zerocount--;
						}
					}
				}
				System.out.println(index1 + " " + index2 + " " + index3 + " " + index4 + " " + index5 + " " + index6);
			}
			for(int i = 0; i <= onecount; i++){
				if(array1.images[i].isPointInElement(420, 600)){
					index3 = 1;
					break;
				}else{
					index3 = 0;
				}
			}
			for(int i = 0; i <= onecount; i++){
				if(array1.images[i].isPointInElement(760, 600)){
					index5 = 1;
					break;
				}else{
					index5 = 0;
				}
			}
			if(!(zerocount == -1)){
				for(int i = 0; i <= zerocount; i++){
					if(array0.images[i].isPointInElement(80, 600)){
						index1 = 1;
						break;
					}else{
						index1 = 0;
					}
				}
			}else{
				index1 = 0;
			}
			if(!(fivecount == -1)){
				for(int i = 0; i <= fivecount; i++){
					if(array5.images[i].isPointInElement(250, 600)){
						index2 = 1;
						break;
					}else{
						index2 = 0;
					}
				}
			}else{
				index2 = 0;
			}
			if(!(fourcount == -1)){
				for(int i = 0; i <= fourcount; i++){
					if(array4.images[i].isPointInElement(590, 600)){
						index4 = 1;
						break;
					}else{
						index4 = 0;
					}
				}
			}else{
				index4 = 0;
			}
			if(!(sixcount == -1)){
				for(int i = 0; i <= sixcount; i++){
					if(array6.images[i].isPointInElement(930, 600)){
						index6 = 1;
						break;
					}else{
						index6 = 0;
					}
				}
			}else{
				index6 = 0;
			}
			EZ.refreshScreen();
		}
		EZ.removeAllEZElements();
	}
	public static void GatePuzzle3(){     //Finished

		Color red = new Color(255, 0, 0);
		
		//EZSound mus = EZ.addSound("TSFH.wav");
		//mus.loop();
		
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		EZText instruction = EZ.addText(512, 100, "Input the code that you used to Breakout", red, 25);
		
		EZImage sq1 = EZ.addImage("Square.png", 205, 600);
		sq1.scaleBy(.5);
		EZImage sq2 = EZ.addImage("Square.png", 410, 600);
		sq2.scaleBy(.5);
		EZImage sq3 = EZ.addImage("Square.png", 615, 600);
		sq3.scaleBy(.5);
		EZImage sq4 = EZ.addImage("Square.png", 820, 600);
		sq4.scaleBy(.5);
		
		EZImage one = EZ.addImage("one.png", 50, 350);
		EZImage two = EZ.addImage("two.png", 150, 350);
		EZImage three = EZ.addImage("three.png", 250, 350);
		EZImage four = EZ.addImage("four.png", 350, 350);
		EZImage five = EZ.addImage("five.png", 450, 350);
		EZImage six = EZ.addImage("six.png", 550, 350);
		EZImage seven = EZ.addImage("seven.png", 650, 350);
		EZImage eight = EZ.addImage("eight.png", 750, 350);
		EZImage nine = EZ.addImage("nine.png", 850, 350);
		EZImage zero = EZ.addImage("zero.png", 950, 350);
		
		ImageArray array1 = new ImageArray(5, "one.png");
		ImageArray array2 = new ImageArray(5, "two.png");
		ImageArray array3 = new ImageArray(5, "three.png");
		ImageArray array4 = new ImageArray(5, "four.png");
		ImageArray array5 = new ImageArray(5, "five.png");
		ImageArray array6 = new ImageArray(5, "six.png");
		ImageArray array7 = new ImageArray(5, "seven.png");
		ImageArray array8 = new ImageArray(5, "eight.png");
		ImageArray array9 = new ImageArray(5, "nine.png");
		ImageArray array0 = new ImageArray(5, "zero.png");
		
		int onecount = -1;
		int twocount = -1;
		int threecount = -1;
		int fourcount = -1;
		int fivecount = -1;
		int sixcount = -1;
		int sevencount = -1;
		int eightcount = -1;
		int ninecount = -1;
		int zerocount = -1;
		
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		int index4 = 0;
		
		EZ.refreshScreen();
		int clickX = 0;
		int clickY = 0;
		while(true){
			if(index1 == 1 && index2 == 1 && index3 == 1 && index4 == 1){
				break;
			}
			clickX = EZInteraction.getXMouse();
			clickY = EZInteraction.getYMouse();
			if(EZInteraction.wasMouseLeftButtonPressed()){
				//one
				if(one.isPointInElement(clickX, clickY)){
					onecount++;
					array1.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array1.images[onecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 205, 600);
							for(int i = 0; i < 4; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 410, 600);
							for(int i = 0; i < 4; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 615, 600);
							for(int i = 0; i < 4; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array1.move(array1.images[onecount], 820, 600);
							for(int i = 0; i < 4; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							
							}
							for(int i = 0; i < onecount; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[onecount]);
										onecount--;
									}
								}
							}
						}else{
							array1.removeImage(array1.images[onecount]);
							onecount--;
						}
					}
				}
				//two
				if(two.isPointInElement(clickX, clickY)){
					twocount++;
					array2.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array2.images[twocount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(205, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(410, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(615, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array2.images[twocount].translateTo(820, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < twocount; i++){
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[twocount]);
										twocount--;
									}
								}
							}
						}else{
							array2.removeImage(array2.images[twocount]);
							twocount--;
						}
					}
				}
				//three
				if(three.isPointInElement(clickX, clickY)){
					threecount++;
					array3.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array3.images[threecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(205, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(410, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(615, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array3.images[threecount].translateTo(820, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < threecount; i++){
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[threecount]);
										threecount--;
									}
								}
							}

						}else{
							array3.removeImage(array3.images[threecount]);
							threecount--;
						}
					}
				}
				//four
				if(four.isPointInElement(clickX, clickY)){
					fourcount++;
					array4.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array4.images[fourcount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(205, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(410, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(615, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array4.images[fourcount].translateTo(820, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fourcount; i++){
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[fourcount]);
										fourcount--;
									}
								}
							}

						}else{
							array4.removeImage(array4.images[fourcount]);
							fourcount--;
						}
					}
				}
				//five
				if(five.isPointInElement(clickX, clickY)){
					fivecount++;
					array5.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array5.images[fivecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(205, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(410, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(615, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array5.images[fivecount].translateTo(820, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < fivecount; i++){
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[fivecount]);
										fivecount--;
									}
								}
							}

						}else{
							array5.removeImage(array5.images[fivecount]);
							fivecount--;
						}
					}
				}
				//six
				if(six.isPointInElement(clickX, clickY)){
					sixcount++;
					array6.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array6.images[sixcount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(205, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(410, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(615, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array6.images[sixcount].translateTo(820, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sixcount; i++){
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[sixcount]);
										sixcount--;
									}
								}
							}

						}else{
							array6.removeImage(array6.images[sixcount]);
							sixcount--;
						}
					}
				}
				//seven
				if(seven.isPointInElement(clickX, clickY)){
					sevencount++;
					array7.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array7.images[sevencount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(205, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(410, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(615, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array7.images[sevencount].translateTo(820, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < sevencount; i++){
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[sevencount]);
										sevencount--;
									}
								}
							}

						}else{
							array7.removeImage(array7.images[sevencount]);
							sevencount--;
						}
					}
				}
				//eight
				if(eight.isPointInElement(clickX, clickY)){
					eightcount++;
					array8.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array8.images[eightcount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(205, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(410, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(615, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array8.images[eightcount].translateTo(820, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < eightcount; i++){
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[eightcount]);
										eightcount--;
									}
								}
							}

						}else{
							array8.removeImage(array8.images[eightcount]);
							eightcount--;
						}
					}
				}
				//nine
				if(nine.isPointInElement(clickX, clickY)){
					ninecount++;
					array9.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array9.images[ninecount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(205, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(410, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(615, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array9.images[ninecount].translateTo(820, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[i]);
										zerocount--;
									}
								}
							}
							for(int i = 0; i < ninecount; i++){
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[ninecount]);
										ninecount--;
									}
								}
							}

						}else{
							array9.removeImage(array9.images[ninecount]);
							ninecount--;
						}
					}
				}
				//zero
				if(zero.isPointInElement(clickX, clickY)){
					zerocount++;
					array0.addImage(clickX, clickY);
					while(!EZInteraction.wasMouseLeftButtonReleased()){
						clickX = EZInteraction.getXMouse();
						clickY = EZInteraction.getYMouse();
						array0.images[zerocount].translateTo(clickX, clickY);
						EZ.refreshScreen();
					}
					if(EZInteraction.wasMouseLeftButtonReleased()){
						if(sq1.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(205, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(205, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(205, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(205, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(205, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(205, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(205, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(205, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(205, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(205, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(205, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}
						}
						else if(sq2.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(410, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(410, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(410, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(410, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(410, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(410, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(410, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(410, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(410, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(410, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(410, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}
						}
						else if(sq3.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(615, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(615, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(615, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(615, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(615, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(615, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(615, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(615, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(615, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(615, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(615, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}

						}
						else if(sq4.isPointInElement(clickX, clickY)){
							array0.images[zerocount].translateTo(820, 600);
							for(int i = 0; i < 4; i++){
								if(array1.containsElement(array1.images[i])){
									if(array1.images[i].isPointInElement(820, 600)){
										array1.removeImage(array1.images[i]);
										onecount--;
									}
								}
								if(array2.containsElement(array2.images[i])){
									if(array2.images[i].isPointInElement(820, 600)){
										array2.removeImage(array2.images[i]);
										twocount--;
									}
								}
								if(array3.containsElement(array3.images[i])){
									if(array3.images[i].isPointInElement(820, 600)){
										array3.removeImage(array3.images[i]);
										threecount--;
									}
								}
								if(array4.containsElement(array4.images[i])){
									if(array4.images[i].isPointInElement(820, 600)){
										array4.removeImage(array4.images[i]);
										fourcount--;
									}
								}
								if(array5.containsElement(array5.images[i])){
									if(array5.images[i].isPointInElement(820, 600)){
										array5.removeImage(array5.images[i]);
										fivecount--;
									}
								}
								if(array6.containsElement(array6.images[i])){
									if(array6.images[i].isPointInElement(820, 600)){
										array6.removeImage(array6.images[i]);
										sixcount--;
									}
								}
								if(array7.containsElement(array7.images[i])){
									if(array7.images[i].isPointInElement(820, 600)){
										array7.removeImage(array7.images[i]);
										sevencount--;
									}
								}
								if(array8.containsElement(array8.images[i])){
									if(array8.images[i].isPointInElement(820, 600)){
										array8.removeImage(array8.images[i]);
										eightcount--;
									}
								}
								if(array9.containsElement(array9.images[i])){
									if(array9.images[i].isPointInElement(820, 600)){
										array9.removeImage(array9.images[i]);
										ninecount--;
									}
								}
							}
							for(int i = 0; i < zerocount; i++){
								if(array0.containsElement(array0.images[i])){
									if(array0.images[i].isPointInElement(820, 600)){
										array0.removeImage(array0.images[zerocount]);
										zerocount--;
									}
								}
							}

						}else{
							array0.removeImage(array0.images[zerocount]);
							zerocount--;
						}
					}
				}
				System.out.println(index1 + " " + index2 + " " + index3 + " " + index4);
			}
			for(int i = 0; i <= sevencount; i++){
				if(array7.images[i].isPointInElement(205, 600)){
					index1 = 1;
					break;
				}else{
					index1 = 0;
				}
			}
			for(int i = 0; i <= sevencount; i++){
				if(array7.images[i].isPointInElement(410, 600)){
					index2 = 1;
					break;
				}else{
					index2 = 0;
				}
			}
			if(!(fourcount == -1)){
				for(int i = 0; i <= fourcount; i++){
					if(array4.images[i].isPointInElement(820, 600)){
						index4 = 1;
						break;
					}else{
						index4 = 0;
					}
				}
			}else{
				index4 = 0;
			}
			if(!(threecount == -1)){
				for(int i = 0; i <= threecount; i++){
					if(array3.images[i].isPointInElement(615, 600)){
						index3 = 1;
						break;
					}else{
						index3 = 0;
					}
				}
			}else{
				index3 = 0;
			}
			EZ.refreshScreen();
		}
		EZ.removeAllEZElements();
		BGM.stop();
	}
	public static void Level1Intro(){     //Finished
		Color red = new Color(255, 0, 0);
		
		EZSound BG = EZ.addSound("KerningCity.wav");
		BG.loop();
		
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		
		EZImage GG = EZ.addImage("GateGuard.png", 480, 300);
		
		EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
		EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "You have proven your worth", red, 30);
		
		int click = 0;
		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
				if(click == 1){
					EZ.removeAllEZElements();
					EZImage Kara = EZ.addImage("Kara1.png", 512, 300);
					Kara.scaleBy(.6);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Now go and save Kara", red, 30);
				}
				if(click == 2){
					EZ.removeAllEZElements();
					EZImage Gg = EZ.addImage("GateGuard.png", 480, 300);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "But be warned", red, 30);
				}
				if(click == 3){
					EZ.removeAllEZElements();
					EZImage Gg = EZ.addImage("GateGuard.png", 312, 1500);
					Gg.scaleBy(5);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "The road ahead will not be easy", red, 30);
				}
				if(click == 4){
					EZ.removeAllEZElements();
					EZImage YJ = EZ.addImage("GigaNigga2.png", 400, 500);
					YJ.scaleBy(.3);
					EZImage TR = EZ.addImage("Tower.png", 600, 300);
					TR.scaleBy(2);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "YuJin enters the tower", red, 30);
				}
				if(click == 5){
					EZ.removeAllEZElements();
					EZImage Door = EZ.addImage("Level1.jpg", 512, 300);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "And enters the first level", red, 30);
				}
				if(click == 6){
					EZ.removeAllEZElements();
					EZImage CT = EZ.addImage("CT.png", 200, 300);
					CT.rotateBy(30);
					EZImage MF = EZ.addImage("MF.png", 512, 300);
					MF.rotateBy(340);
					EZImage Zayn = EZ.addImage("Zayn.png", 900, 300);
					EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Oh no its Karas hunnie bois", red, 30);
				}
				if(click == 7){
					BG.stop();
					EZ.removeAllEZElements();
					break;
				}
			}
			EZ.refreshScreen();
		}
	}
	public static void Level1(){     //Finished
		Color red = new Color(255, 0, 0);
		Color white = new Color(255, 255, 255);
		
		EZSound BG = EZ.addSound("CWK.wav");
		BGM = BG;
		BGM.loop();
		
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		
		EZText cont = EZ.addText("8-BIT WONDER.TTF", 850, 420, "click to continue", red, 10);
		EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 384, "Click to squish her hunnie bois", red, 30);
		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				EZ.removeAllEZElements();
				EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 384, "Round One", red, 30);
				try {
				    Thread.sleep(1500);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				EZ.removeAllEZElements();
				break;
			}
			EZ.refreshScreen();
		}
		
		EZ.setBackgroundColor(new Color(0,0,100));
		ArrayList<AutoBug> bugs = new ArrayList<AutoBug>();
		  
		for (int i=0; i<7; i++){
			bugs.add(new AutoBug("Zayn.png","splat.png", 500,500, 1024, 768, 4));
		}
		  
		int clickX = 0;
		int clickY = 0;
		boolean clicked = false;
		 
		EZSound sound = EZ.addSound("squish.wav");
		while(true) {
			int ded = 1;
			clicked = false;
			if (EZInteraction.wasMouseLeftButtonReleased()) {
				clickX = EZInteraction.getXMouse();
				clickY = EZInteraction.getYMouse();
				clicked = true;
			}
			for (int i=0; i < 7; i++) {
				bugs.get(i).go();
				if (clicked && bugs.get(i).isInside(clickX, clickY)) {
					if(bugs.get(i).alive() == true){
						bugs.get(i).squish();
						sound.play();
					}
				}
			}
			for(int i = 0; i < 7; i++){
				if(bugs.get(i).alive() == true){
					ded = 0;
				}
			}
			if(ded == 1){
				EZ.removeAllEZElements();
				EZ.setBackgroundColor(white);
				break;
			}
		    EZ.refreshScreen();
		}
		EZ.refreshScreen();
	}
	public static void Level1b(){     //Finished
		Color red = new Color(255, 0, 0);
		Color white = new Color(255, 255, 255);
		
		EZText load = EZ.addText(512, 384, "Round Two", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(1500);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		EZ.removeAllEZElements();
		EZ.refreshScreen();
		
		
		EZ.setBackgroundColor(new Color(0,0,100));
		ArrayList<AutoBug> bugs = new ArrayList<AutoBug>();
		  
		for (int i=0; i<10; i++){
			bugs.add(new AutoBug("CT.png","splat.png", 500,500, 1024, 768, 5));
		}
		  
		int clickX = 0;
		int clickY = 0;
		boolean clicked = false;
		 
		EZSound sound = EZ.addSound("squish.wav");
		while(true) {
			int ded = 1;
			clicked = false;
			if (EZInteraction.wasMouseLeftButtonPressed()) {
				clickX = EZInteraction.getXMouse();
				clickY = EZInteraction.getYMouse();
				clicked = true;
			}
			for (int i=0; i < 10; i++) {
				bugs.get(i).go();
				if (clicked && bugs.get(i).isInside(clickX, clickY)) {
					if(bugs.get(i).alive() == true){
						bugs.get(i).squish();
						sound.play();
					}
				}
			}
			for(int i = 0; i < 10; i++){
				if(bugs.get(i).alive() == true){
					ded = 0;
				}
			}
			if(ded == 1){
				EZ.removeAllEZElements();
				EZ.setBackgroundColor(white);
				break;
			}
		    EZ.refreshScreen();
		}
		EZ.refreshScreen();
	}
	public static void Level1c(){     //Finished NEEDS BGM
		Color red = new Color(255, 0, 0);
		Color white = new Color(255, 255, 255);
		
		EZText load = EZ.addText(512, 384, "Final Round", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(1500);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		EZ.removeAllEZElements();
		EZ.refreshScreen();
		
		
		EZ.setBackgroundColor(new Color(0,0,100));
		ArrayList<AutoBug> bugs = new ArrayList<AutoBug>();
		  
		for (int i=0; i<20; i++){
			bugs.add(new AutoBug("MF.png","splat.png", 500,500, 1024, 768, 5));
		}
		  
		int clickX = 0;
		int clickY = 0;
		boolean clicked = false;
		 
		EZSound sound = EZ.addSound("squish.wav");
		while(true) {
			int ded = 1;
			clicked = false;
			if (EZInteraction.wasMouseLeftButtonPressed()) {
				clickX = EZInteraction.getXMouse();
				clickY = EZInteraction.getYMouse();
				clicked = true;
			}
			for (int i=0; i < 20; i++) {
				bugs.get(i).go();
				if (clicked && bugs.get(i).isInside(clickX, clickY)) {
					if(bugs.get(i).alive() == true){
						bugs.get(i).squish();
						sound.play();
					}
				}
			}
			for(int i = 0; i < 20; i++){
				if(bugs.get(i).alive() == true){
					ded = 0;
				}
			}
			if(ded == 1){
				EZ.removeAllEZElements();
				EZ.setBackgroundColor(white);
				break;
			}
		    EZ.refreshScreen();
		}
		EZ.refreshScreen();
		BGM.stop();
	}
	public static void Level2Intro(){     //Finished
		Color red = new Color(255, 0, 0);
		
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		EZSound BG = EZ.addSound("TSFH.wav");
		BGM = BG;
		BGM.loop();
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		
		int click = 0;
		
		EZImage YJ = EZ.addImage("GigaNigga2.png", 300, 300);
		YJ.scaleBy(.7);
		EZImage MF = EZ.addImage("MF.png", 800, 300);
		MF.scaleBy(.5);
		EZImage CT = EZ.addImage("CT.png", 700, 300);
		CT.scaleBy(.5);
		CT.rotateBy(330);
		EZImage Zayn = EZ.addImage("Zayn.png", 900, 300);
		Zayn.scaleBy(.5);
		Zayn.rotateBy(30);
		
		EZText txt2 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "YuJin kicked everyones ass", red, 30);
		EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
		
		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
				if(click == 1){
					EZ.removeAllEZElements();
					EZ.addImage("Level2.png", 512, 300);
					EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "He moves up the tower to level 2", red, 30);
					EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
				}
				if(click == 2){
					EZ.removeAllEZElements();
					EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 384, "Oh no", red, 60);
					EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
				}
				if(click == 3){
					EZ.removeAllEZElements();
					EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Its YuJins fan girls", red, 30);
					EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
					
					EZImage IU = EZ.addImage("IU1.png", 312, 384);
					EZImage EW = EZ.addImage("EW.png", 512, 384);
					EZImage SJ = EZ.addImage("SJ1.png", 712, 384);
				}
				if(click == 4){
					EZ.removeAllEZElements();
					break;
				}
			}
			EZ.refreshScreen();
		}
	}
	public static void Level2(){     //Finished
		EZ.refreshScreen();
		Color red = new Color(255, 0, 0);

		
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		
		if(first == 1){
			EZText instr = EZ.addText(512, 300, "Use WASD to bring YuJin to the other side", red, 20);
			EZText instr1 = EZ.addText(512, 400, "Do Not touch his fangirls or Kara will get mad", red, 20);
			instr.setFont("8-BIT WONDER.TTF");
			instr1.setFont("8-BIT WONDER.TTF");
			try {
			    Thread.sleep(5000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		EZ.removeAllEZElements();
		int CHICKEN_WINS = 1;
		int CHICKEN_DIES = 2;
		int CHICKEN_RUNNING = 0;
		
		int chickenState = CHICKEN_RUNNING;
		
		EZ.addImage("road.jpg", 512, 384);
		Chicken myChicken = new Chicken("YJHead1.png", 50, 384);
		Obstacle truck[] = new Obstacle[20];

		for (int i = 0; i < 10; i++){
			truck[i] = new Obstacle("EW1.png", 1024, 768);
		}
		EZSound chickenSound = EZ.addSound("Die.wav");
		
		while (chickenState == CHICKEN_RUNNING) {

			// Steer the Chicken
			myChicken.ControlIt();

			// Check to see if Chicken has hit a truck.
			for (int i = 0; i < 10; i++) {
				
				// Move the truck.
				truck[i].move();
				
				// Check to see if the chicken is touching the truck.
				if ((truck[i].isInside(myChicken.getX() - 30,
						myChicken.getY() - 60))
						|| (truck[i].isInside(myChicken.getX() + 30,
								myChicken.getY() - 60))
						|| (truck[i].isInside(myChicken.getX() - 30,
								myChicken.getY() + 60))
						|| (truck[i].isInside(myChicken.getX() + 30,
								myChicken.getY() + 60))) {
					chickenState = CHICKEN_DIES;
					chickenSound.play();
				}

			}
			if (myChicken.getX() > 1024) {
				break;
			}
			EZ.refreshScreen();
		}
		if (chickenState == CHICKEN_DIES) {
			first = 0;
			EZ.addImage("splat.png", myChicken.getX(), myChicken.getY());
			myChicken.hide();
			Color c = new Color(0, 10, 150);
			int fontsize = 50;
			EZText text = EZ.addText(512, 300, "You are dead", c, fontsize);
			EZText cont = EZ.addText(512, 350, "click to retry", c, 10);
			cont.setFont("8-BIT WONDER.TTF");
			text.setFont("8-BIT WONDER.TTF");
			while(true){
				if(EZInteraction.wasMouseLeftButtonPressed()){
					System.out.println("left click");
					EZ.removeAllEZElements();
					Level2();
					System.out.println("Break");
					break;
				}
				EZ.refreshScreen();
			}
		}
		first = 1;
		EZ.removeAllEZElements();
		EZ.refreshScreen();
	}
	public static void Level2b(){     //Finished
		EZ.refreshScreen();
		Color red = new Color(255, 0, 0);

		
		EZText load = EZ.addText(512, 384, "Round 2", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(1500);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		
		int CHICKEN_WINS = 1;
		int CHICKEN_DIES = 2;
		int CHICKEN_RUNNING = 0;
		
		int chickenState = CHICKEN_RUNNING;
		
		// Draw the road.
		EZ.addImage("road.jpg", 512, 384);

		// Make a Chicken
		Chicken myChicken = new Chicken("YJHead1.png", 50, 384);

		// Make 10 trucks
		Obstacle truck[] = new Obstacle[20];

		for (int i = 0; i < 20; i++){
			truck[i] = new Obstacle("IU2.png", 1024, 768);
		}

		// Load sound effects
		EZSound chickenSound = EZ.addSound("Die.wav");
		
		// This is the main game loop.
		while (chickenState == CHICKEN_RUNNING) {

			// Steer the Chicken
			myChicken.ControlIt();

			// Check to see if Chicken has hit a truck.
			for (int i = 0; i < 20; i++) {
				
				// Move the truck.
				truck[i].move();
				
				// Check to see if the chicken is touching the truck.
				if ((truck[i].isInside(myChicken.getX() - 30,
						myChicken.getY() - 60))
						|| (truck[i].isInside(myChicken.getX() + 30,
								myChicken.getY() - 60))
						|| (truck[i].isInside(myChicken.getX() - 30,
								myChicken.getY() + 60))
						|| (truck[i].isInside(myChicken.getX() + 30,
								myChicken.getY() + 60))) {
					chickenState = CHICKEN_DIES;
					chickenSound.play();
				}

			}
			if (myChicken.getX() > 1024) {
				break;
			}
			EZ.refreshScreen();
		}
		if (chickenState == CHICKEN_DIES) {
			EZ.addImage("splat.png", myChicken.getX(), myChicken.getY());
			myChicken.hide();
			Color c = new Color(0, 10, 150);
			int fontsize = 50;
			EZText text = EZ.addText(512, 300, "You are dead", c, fontsize);
			EZText cont = EZ.addText(512, 350, "click to retry", c, 10);
			cont.setFont("8-BIT WONDER.TTF");
			text.setFont("8-BIT WONDER.TTF");
			while(true){
				if(EZInteraction.wasMouseLeftButtonPressed()){
					System.out.println("left click");
					EZ.removeAllEZElements();
					Level2b();
					System.out.println("Break");
					break;
				}
				EZ.refreshScreen();
			}
		}
		EZ.removeAllEZElements();
		EZ.refreshScreen();
	}
	public static void Level2c(){     //Finished
		EZ.refreshScreen();
		Color red = new Color(255, 0, 0);

		
		EZText load = EZ.addText(512, 384, "Round 3", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(1500);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		
		int CHICKEN_WINS = 1;
		int CHICKEN_DIES = 2;
		int CHICKEN_RUNNING = 0;
		
		int chickenState = CHICKEN_RUNNING;
		
		// Draw the road.
		EZ.addImage("road.jpg", 512, 384);

		// Make a Chicken
		Chicken myChicken = new Chicken("YJHead1.png", 50, 384);

		// Make 10 trucks
		Obstacle truck[] = new Obstacle[25];

		for (int i = 0; i < 25; i++){
			truck[i] = new Obstacle("SJ.png", 1024, 768);
		}
		

		// Load sound effects
		EZSound chickenSound = EZ.addSound("Die.wav");
		
		// This is the main game loop.
		while (chickenState == CHICKEN_RUNNING) {

			// Steer the Chicken
			myChicken.ControlIt();

			// Check to see if Chicken has hit a truck.
			if(first < 4){
				for (int i = 0; i < 25; i++) {
					
					// Move the truck.
					truck[i].move();
					
					// Check to see if the chicken is touching the truck.
					if ((truck[i].isInside(myChicken.getX() - 30,
							myChicken.getY() - 60))
							|| (truck[i].isInside(myChicken.getX() + 30,
									myChicken.getY() - 60))
							|| (truck[i].isInside(myChicken.getX() - 30,
									myChicken.getY() + 60))
							|| (truck[i].isInside(myChicken.getX() + 30,
									myChicken.getY() + 60))) {
						chickenState = CHICKEN_DIES;
						chickenSound.play();
					}
				}
			}else{
				for (int i = 0; i < 15; i++) {
					
					// Move the truck.
					truck[i].move();
					
					// Check to see if the chicken is touching the truck.
					if ((truck[i].isInside(myChicken.getX() - 30,
							myChicken.getY() - 60))
							|| (truck[i].isInside(myChicken.getX() + 30,
									myChicken.getY() - 60))
							|| (truck[i].isInside(myChicken.getX() - 30,
									myChicken.getY() + 60))
							|| (truck[i].isInside(myChicken.getX() + 30,
									myChicken.getY() + 60))) {
						chickenState = CHICKEN_DIES;
						chickenSound.play();
					}
				}
			}
			if (myChicken.getX() > 1024) {
				break;
			}
			EZ.refreshScreen();
		}
		if (chickenState == CHICKEN_DIES) {
			EZ.addImage("splat.png", myChicken.getX(), myChicken.getY());
			myChicken.hide();
			first++;
			Color c = new Color(0, 10, 150);
			int fontsize = 50;
			EZText text = EZ.addText(512, 300, "You are dead", c, fontsize);
			EZText cont = EZ.addText(512, 350, "click to retry", c, 10);
			cont.setFont("8-BIT WONDER.TTF");
			text.setFont("8-BIT WONDER.TTF");
			while(true){
				if(EZInteraction.wasMouseLeftButtonPressed()){
					System.out.println("left click");
					EZ.removeAllEZElements();
					Level2c();
					System.out.println("Break");
					break;
				}
				EZ.refreshScreen();
			}
		}
		EZ.removeAllEZElements();
		EZ.refreshScreen();
		BGM.stop();
	}
	public static void Level3Intro(){
		Color red = new Color(255, 0, 0);

		EZSound FFBB = EZ.addSound("FFBB.wav");
		BGM = FFBB;
		BGM.loop();
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		
		EZText txt2 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "YuJin was able to avoid all the girls", red, 30);
		EZText cont1 = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
		EZImage YJ = EZ.addImage("GigaNigga2.png", 812, 384);
		YJ.scaleBy(.6);
		EZImage EW = EZ.addImage("EW.png", 200, 384);
		EZImage SJ = EZ.addImage("SJ1.png", 300, 384);
		EZImage IU = EZ.addImage("IU1.png", 400, 384);
		
		int click = 0;
		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
				if(click == 1){
					EZ.removeAllEZElements();
					EZImage Stair = EZ.addImage("Spiral.jpg", 512, 244);
					EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "He now moves on to the next level", red, 30);
					EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
				}
				if(click == 2){
					EZ.removeAllEZElements();
					EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 384, "OH NO", red, 20);
					EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
				}
				if(click == 3){
					EZ.removeAllEZElements();
					EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 384, "OH NO", red, 40);
					EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
				}
				if(click == 4){
					EZ.removeAllEZElements();
					EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 384, "OH NO", red, 90);
					EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
				}
				if(click == 5){
					EZ.removeAllEZElements();
					try {
					    Thread.sleep(500);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					EZImage Parents = EZ.addImage("Parents.png", 512, 300);
					EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Its Karas parents", red, 30);
					EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
				}
				if(click == 6){
					EZ.removeAllEZElements();
					break;
				}
			}
			EZ.refreshScreen();
		}
	}
	public static void Level3(){
		Color red = new Color(255, 0, 0);
		Color blue = new Color(0, 0, 255);
		if(level3first == 1){
			EZText load = EZ.addText(512, 384, "Loading", red);
			load.setFont("8-BIT WONDER.TTF");
			load.setFontSize(40);
			try {
			    Thread.sleep(2000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			load.hide();
		}
		else{
			EZText load = EZ.addText(512, 384, "Try again loser", red);
			load.setFont("8-BIT WONDER.TTF");
			load.setFontSize(40);
			try {
			    Thread.sleep(2000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			load.hide();
		}
		boolean won = true;
		
		EZImage Parents = EZ.addImage("Parents.png", 512, 300);
		EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "So I heard you liked our daughter", red, 30);
		EZText ans1 = null;
		EZText ans2 = null;
		EZText ans3 = null;
		EZText ans4 = null;
		
		int click = 0;
		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
				if(click == 1){
					EZ.removeEZElement(txt1);
					txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Youll have to answer some questions first", red, 25);
				}
				if(click == 2){
					EZ.removeEZElement(txt1);
					txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 654, "What do you say if Kara says she feels fat", red, 20);
					ans1 = EZ.addText("8-BIT WONDER.TTF", 135, 700, "Agree with her", blue, 20);
					ans2 = EZ.addText("8-BIT WONDER.TTF", 270, 750, "Measure her belly to confirm", blue, 20);
					ans3 = EZ.addText("8-BIT WONDER.TTF", 750, 700, "Pretend to bounce off of her", blue, 20);
					ans4 = EZ.addText("8-BIT WONDER.TTF", 800, 750, "Tell her that she is not", blue, 20);
					break;
				}
			}
			EZ.refreshScreen();
		}
		while(true){
			int clickX = EZInteraction.getXMouse();
			int clickY = EZInteraction.getYMouse();
			if(EZInteraction.wasMouseLeftButtonPressed()){
				if(ans1.isPointInElement(clickX, clickY) || ans2.isPointInElement(clickX, clickY) || ans3.isPointInElement(clickX, clickY) || ans4.isPointInElement(clickX, clickY)){
					click++;
					if(click == 3){
						if(ans4.isPointInElement(clickX, clickY)){
							EZ.removeEZElement(txt1);
							EZ.removeEZElement(ans1);
							EZ.removeEZElement(ans2);
							EZ.removeEZElement(ans3);
							EZ.removeEZElement(ans4);
							
							txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 654, "If Kara and her mom were dying who would you save", red, 20);
							ans1 = EZ.addText("8-BIT WONDER.TTF", 135, 700, "Kara of course", blue, 20);
							ans3 = EZ.addText("8-BIT WONDER.TTF", 265, 750, "Karas mom has got it going on", blue, 20);
							ans2 = EZ.addText("8-BIT WONDER.TTF", 810, 750, "Save both or die trying", blue, 20);
							ans4 = EZ.addText("8-BIT WONDER.TTF", 730, 700, "Walk away because I cant decide", blue, 20);
						}
						else if(ans1.isPointInElement(clickX, clickY) || ans2.isPointInElement(clickX, clickY) || ans3.isPointInElement(clickX, clickY)){
							won = false;
							level3first = 0;
							break;
						}
					}
					if(click == 4){
						if(ans1.isPointInElement(clickX, clickY)){
							EZ.removeEZElement(txt1);
							EZ.removeEZElement(ans1);
							EZ.removeEZElement(ans2);
							EZ.removeEZElement(ans3);
							EZ.removeEZElement(ans4);
							
							txt1 = EZ.addText("8-BIT WONDER.TTF", 512, 654, "What do you do if Kara makes you miss a steam sale", red, 20);
							ans1 = EZ.addText("8-BIT WONDER.TTF", 177, 700, "Break up with her", blue, 20);
							ans3 = EZ.addText("8-BIT WONDER.TTF", 100, 750, "Turn emo", blue, 20);
							ans2 = EZ.addText("8-BIT WONDER.TTF", 710, 750, "Feel really sad and hold a grudge", blue, 20);
							ans4 = EZ.addText("8-BIT WONDER.TTF", 820, 700, "Get over it like a man", blue, 20);
						}
						else if(ans4.isPointInElement(clickX, clickY) || ans2.isPointInElement(clickX, clickY) || ans3.isPointInElement(clickX, clickY)){
							won = false;
							level3first = 0;
							break;
						}
					}
					if(click == 5){
						if(ans2.isPointInElement(clickX, clickY)){
							break;
						}
						else if(ans4.isPointInElement(clickX, clickY) || ans1.isPointInElement(clickX, clickY) || ans3.isPointInElement(clickX, clickY)){
							won = false;
							level3first = 0;
							break;
						}
					}
				}
			}
			EZ.refreshScreen();
		}
		if(won == false){
			EZ.removeAllEZElements();
			Level3();
		}
		else{
			BGM.stop();
			EZ.removeAllEZElements();
		}
	}
	public static void FinalBossIntro(){
		Color red = new Color(255, 0, 0);
		EZSound IRIS = EZ.addSound("IRISOST.wav");
		BGM = IRIS;
		BGM.loop();
		EZText load = EZ.addText(512, 384, "Loading", red);
		load.setFont("8-BIT WONDER.TTF");
		load.setFontSize(40);
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		load.hide();
		
		EZImage Parents = EZ.addImage("Parents.png", 512, 300);
		EZText txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "You have passed our test", red, 30);
		EZText cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
		EZImage Kara = null;
		EZImage YJ = null;
		
		int click = 0;
		while(true){
			if(EZInteraction.wasMouseLeftButtonPressed()){
				click++;
				if(click == 1){
					EZ.removeEZElement(txt);
					txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Now go and save Kara before its too late", red, 25);
				}
				if(click == 2){
					EZ.removeEZElement(Parents);
					EZ.removeEZElement(txt);
					Parents = EZ.addImage("Rooftop.jpg", 512, 200);
					txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "YuJin walks up to the final level", red, 30);
				}
				if(click == 3){
					EZ.removeEZElement(Parents);
					EZ.removeEZElement(txt);
					Parents = EZ.addImage("Evil1.png", 312, 340);
					txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Bwahahaha so you finally made it", red, 30);
					Kara = EZ.addImage("Kara1.png", 120, 340);
					YJ = EZ.addImage("GigaNiggaLeft.png", 700, 340);
					Kara.scaleBy(.5);
					YJ.scaleBy(.5);
				}
				if(click == 4){
					EZ.removeAllEZElements();
					Parents = EZ.addImage("Evil1.png", 512, 340);
					txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "But youll never be able to fight me", red, 30);
					cont = EZ.addText("8-BIT WONDER.TTF", 900, 750, "click to continue", red, 10);
				}
				if(click == 5){
					EZ.removeEZElement(txt);
					txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Because Im actually", red, 30);
					Parents.scaleBy(2);
				}
				if(click == 6){
					EZ.removeEZElement(Parents);
					EZ.removeEZElement(txt);
					YJ = EZ.addImage("GigaNigga2.png", 512, 364);
					YJ.scaleBy(.7);
					txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Your evil clone", red, 40);
				}
				if(click == 7){
					EZ.removeEZElement(txt);
					YJ.translateTo(200, 364);
					Kara = EZ.addImage("Kara1.png", 512, 364);
					Kara.scaleBy(.5);
					Parents = EZ.addImage("GigaNiggaLeft.png", 800, 364);
					Parents.scaleBy(.7);
					txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "Kara is confused", red, 30);
				}
				if(click == 8){
					EZ.removeEZElement(txt);
					EZ.removeEZElement(YJ);
					EZ.removeEZElement(Parents);
					Kara.scaleBy(2);
					txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "But she must make a decision", red, 30);
				}
				if(click == 9){
					EZ.removeEZElement(txt);
					Kara.translateTo(400, 364);
					EZImage gun = EZ.addImage("Gun.png", 600, 400);
					txt = EZ.addText("8-BIT WONDER.TTF", 512, 684, "She pulls out a gun and shoots one person", red, 25);
				}
				if(click == 10){
					EZ.removeAllEZElements();
					break;
				}
			}
			EZ.refreshScreen();
		}
	}
	public static void FinalBoss(){
		EZSound GunShot = EZ.addSound("GunShot.wav");
		EZImage YJ1 = EZ.addImage("GigaNigga2.png", 200, 360);
		EZImage YJ2 = EZ.addImage("GigaNiggaLeft.png", 800, 360);
		EZImage ArmRight = EZ.addImage("Shoot.png", 512, 534);
		EZImage ArmLeft = EZ.addImage("ShootLeft.png", 512, 534);
		ArmRight.hide();
		ArmLeft.hide();
		
		while(true){
			int clickX = EZInteraction.getXMouse();
			int clickY = EZInteraction.getYMouse();
			if(clickX < 512){
				ArmRight.show();
				ArmLeft.hide();
				if(EZInteraction.wasMouseLeftButtonPressed()){
					EZ.removeAllEZElements();
					EZ.setBackgroundColor(new Color(0, 0, 0));
					BGM.stop();
					GunShot.play();
					KilledEvil = false;
					EZ.refreshScreen();
					break;
				}
			}else{
				ArmLeft.show();
				ArmRight.hide();
				if(EZInteraction.wasMouseLeftButtonPressed()){
					EZ.removeAllEZElements();
					EZ.setBackgroundColor(new Color(0, 0, 0));
					BGM.stop();
					GunShot.play();
					KilledEvil = true;
					EZ.refreshScreen();
					break;
				}
			}
			EZ.refreshScreen();
		}
	}
	public static void Outro1(){
		
		Color c = new Color(0, 50, 100);
		Color white = new Color(255, 255, 255);
		EZSound OutroMus = EZ.addSound("FFCCROF.wav");
		try {
		    Thread.sleep(5000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		int clickX = 0;
		int clickY = 800;
		OutroMus.play();
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		EZImage BG = EZ.addImage("BlueCity.png", 512, 350);
		
		EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "The real YuJin was shot by Kara", c, 30);
		EZText txt2 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Kara was then forced to live with his evil clone", c, 20);
		EZText txt3 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "The end", c, 30);
		EZText txt4 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Thanks for playing", c, 30);
		EZText txt5 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Epoch of YuJin", c, 30);
		EZText txt6 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Code by YuJin", c, 30);
		EZText txt7 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Music selected by YuJin", c, 30);
		EZText txt8 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Designed and engineered by YuJin", c, 30);
		EZText txt9 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Bug finding and editing by YuJin", c, 30);
		EZText txt10 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Blackbox Testing by Sam Kuwamura and Kevin Rivera", c, 20);
		EZText txt11 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Some codes stolen from Jason Leigh", c, 30);
		EZText txt12 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Thought of by YuJin", c, 30);
		EZText txt13 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Inspired by Kara", c, 30);
		
		EZImage img1 = EZ.addImage("Kara1.png", 512, 1300);
		EZImage img2 = EZ.addImage("YuJin1.png", 512, 1300);
		EZImage img3 = EZ.addImage("GigaNigga2.png", 512, 1300);
		EZImage img4 = EZ.addImage("Evil1.png", 512, 1000);
		EZImage img5 = EZ.addImage("Us.jpg", 512, 1300);
		
		while(true){
			txt1.translateTo(512, clickY);
			clickY--;
			if(txt1.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt2.translateTo(512, clickY);
			clickY = clickY - 2;
			if(txt2.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt3.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt3.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt4.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt4.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt5.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt5.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			img1.translateTo(512, clickY);
			clickY = clickY - 3;
			if(img1.isPointInElement(512, -700)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt6.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt6.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt7.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt7.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt8.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt8.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			img2.translateTo(512, clickY);
			clickY = clickY - 3;
			if(img2.isPointInElement(512, -500)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			img3.translateTo(512, clickY);
			clickY = clickY - 1;
			if(img3.isPointInElement(512, -900)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt9.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt9.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt10.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt10.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt11.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt11.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt12.translateTo(512, clickY);
			clickY = clickY - 4;
			if(txt12.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt13.translateTo(512, clickY);
			clickY = clickY - 4;
			if(txt13.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			img5.translateTo(512, clickY);
			clickY = clickY - 1;
			if(img5.isPointInElement(512, 164)){
				break;
			}
			EZ.refreshScreen();
		}
	}
	public static void Outro2(){
		Color c = new Color(0, 50, 100);
		Color white = new Color(255, 255, 255);
		EZSound OutroMus = EZ.addSound("FFCCROF.wav");
		try {
		    Thread.sleep(5000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		int clickX = 0;
		int clickY = 800;
		OutroMus.play();
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		EZImage BG = EZ.addImage("BlueCity.png", 512, 350);
		
		EZText txt1 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Kara was able to shoot the clone", c, 30);
		EZText txt2 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "YuJin lived hapily ever after with his love", c, 20);
		EZText txt3 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "The end", c, 30);
		EZText txt4 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Thanks for playing", c, 30);
		EZText txt5 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Epoch of YuJin", c, 30);
		EZText txt6 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Code by YuJin", c, 30);
		EZText txt7 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Music selected by YuJin", c, 30);
		EZText txt8 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Designed and engineered by YuJin", c, 30);
		EZText txt9 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Bug finding and editing by YuJin", c, 30);
		EZText txt10 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Blackbox Testing by Sam Kuwamura and Kevin Rivera", c, 20);
		EZText txt11 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Some codes stolen from Jason Leigh", c, 30);
		EZText txt12 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Thought of by YuJin", c, 30);
		EZText txt13 = EZ.addText("8-BIT WONDER.TTF", 512, clickY, "Inspired by Kara", c, 30);
		
		EZImage img1 = EZ.addImage("Kara1.png", 512, 1300);
		EZImage img2 = EZ.addImage("YuJin1.png", 512, 1300);
		EZImage img3 = EZ.addImage("GigaNigga2.png", 512, 1300);
		EZImage img4 = EZ.addImage("Evil1.png", 512, 1000);
		EZImage img5 = EZ.addImage("Us.jpg", 512, 1300);
		
		while(true){
			txt1.translateTo(512, clickY);
			clickY--;
			if(txt1.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt2.translateTo(512, clickY);
			clickY = clickY - 2;
			if(txt2.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt3.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt3.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt4.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt4.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt5.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt5.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			img1.translateTo(512, clickY);
			clickY = clickY - 3;
			if(img1.isPointInElement(512, -700)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt6.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt6.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt7.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt7.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt8.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt8.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			img2.translateTo(512, clickY);
			clickY = clickY - 3;
			if(img2.isPointInElement(512, -500)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			img3.translateTo(512, clickY);
			clickY = clickY - 1;
			if(img3.isPointInElement(512, -900)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt9.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt9.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt10.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt10.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt11.translateTo(512, clickY);
			clickY = clickY - 3;
			if(txt11.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt12.translateTo(512, clickY);
			clickY = clickY - 4;
			if(txt12.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			txt13.translateTo(512, clickY);
			clickY = clickY - 4;
			if(txt13.isPointInElement(512, -70)){
				break;
			}
			EZ.refreshScreen();
		}
		clickY = 800;
		while(true){
			img5.translateTo(512, clickY);
			clickY = clickY - 1;
			if(img5.isPointInElement(512, 164)){
				break;
			}
			EZ.refreshScreen();
		}
	}
}

