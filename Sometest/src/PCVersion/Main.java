package PCVersion;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class Main {
 
	
	  static JFrame firstframe=new JFrame("颜团子的征途");
	  static JPanel toppanel=(JPanel)(firstframe.getContentPane());
	  static JPanel mainpanel=new JPanel();
	  static JPanel flowerpanel=new JPanel();
	  
	 static ImageIcon main=new ImageIcon("PCchoosebackground.jpg");
	 static ImageIcon background=new ImageIcon("PCgamebackground.jpg");
	static ImageIcon flower1=new ImageIcon("f01.png");
	static ImageIcon flower2=new ImageIcon("f02.gif");
	static ImageIcon flower3=new ImageIcon("f03.gif");
	static ImageIcon flower4=new ImageIcon("f04.gif");
	static ImageIcon flower5=new ImageIcon("f05.gif");
	static ImageIcon flower6=new ImageIcon("f06.gif");
	static ImageIcon pass1=new ImageIcon("PClevel1.jpg");
	static ImageIcon pass2=new ImageIcon("PClevel2.jpg");
	static ImageIcon pass3=new ImageIcon("PClevel3.jpg");
	static ImageIcon pass4=new ImageIcon("PClevel4.jpg");
	static ImageIcon pass5=new ImageIcon("PClevel5.jpg");
	static ImageIcon pass6=new ImageIcon("PClevel6.jpg");
	static ImageIcon lose=new ImageIcon("PCfail.jpg");
	static ImageIcon dead=new ImageIcon("PCdead.png");
    static ImageIcon newgameIcon=new ImageIcon("newgame.png");
    static ImageIcon newgamerollover=new ImageIcon("newgamerollover.png");
    static ImageIcon continuegameIcon=new ImageIcon("continuegame.png");
    static ImageIcon continuegamerollover=new ImageIcon("continuegamerollover.png");
    static ImageIcon exitgameIcon=new ImageIcon("exit.png");
    static ImageIcon exitgamerollover=new ImageIcon("exitrollover.png");
    static ImageIcon standardVersion=new ImageIcon("PCstandard.jpg");
    static ImageIcon classicVersion=new ImageIcon("PCclassic.jpg");
    static ImageIcon standardBU=new ImageIcon("exchange.png");
    static ImageIcon standardBUrollover=new ImageIcon("exchangerollover.png");
    static ImageIcon classicBU=new ImageIcon("oneclick.png");
    static ImageIcon classicBUrollover=new ImageIcon("oneclickrollover.png");
    static ImageIcon startgame=new ImageIcon("startgame.gif");
    static ImageIcon exitBU=new ImageIcon("exitButton.png");
    static ImageIcon exitBUrollover=new ImageIcon("exitButtonrollover.png");
    static ImageIcon againBU=new ImageIcon("again.png");
    static ImageIcon againBUrollover=new ImageIcon("againrollover.png");
    
	
	static JLabel mainlabel=new JLabel(main);
	static JLabel backg=new JLabel(background);
	static JLabel flowerlabel1=new JLabel(flower1);
	static JLabel flowerlabel2=new JLabel(flower2);
	static JLabel flowerlabel3=new JLabel(flower3);
	static JLabel flowerlabel4=new JLabel(flower4);
	static JLabel flowerlabel5=new JLabel(flower5);
	static JLabel flowerlabel6=new JLabel(flower6);
	static JLabel Pass1=new JLabel(pass1);
	static JLabel Pass2=new JLabel(pass2);
	static JLabel Pass3=new JLabel(pass3);
	static JLabel Pass4=new JLabel(pass4);
	static JLabel Pass5=new JLabel(pass5);
	static JLabel Pass6=new JLabel(pass6);
	static JLabel Lose=new JLabel(lose);
	static JLabel Dead=new JLabel(dead);
	static JLabel Standard=new JLabel(standardVersion);
	static JLabel Classic=new JLabel(classicVersion);
	
	static JButton exit=new JButton();
	
	static int height=main.getIconHeight();
    static int width=main.getIconWidth();
    static int height2;
    static int width2;
    static int choice;
	static int stages=1;
	static int steps;
	static int targets;
	static int scores;
	
	static String returnmessage;
	static JTextField stage=new JTextField();
	static JTextField step=new JTextField();
	static JTextField score=new JTextField();
	static JTextField target=new JTextField();
///////////////////////////////////write and read file
public static void writeMode(String content){
	 
try{  
      File write=new File("Version.txt");
      FileWriter writer=new FileWriter(write);
      writer.write(content);
      writer.close();
  }catch(IOException ex){
      ex.printStackTrace();
}
}

public static String readMode(){
String result="";
try{
    File myFile=new File("Version.txt");
    FileReader fileReader=new FileReader(myFile);

    BufferedReader reader=new BufferedReader(fileReader);

    String line=null;
while((line=reader.readLine())!=null){
    result=line;
}
    reader.close();
}catch(Exception ex){
    ex.printStackTrace();
} 
   return result;

}
public static void writeStages(String content){
  try{
	
    File write2=new File("Data.txt");
    FileWriter writer=new FileWriter(write2);
    writer.write(content);
    writer.close();
}catch(IOException ex){
    ex.printStackTrace();
}
}

public static String readStages(){
     String result="";
  try{
     File myFile=new File("Data.txt");
     FileReader fileReader=new FileReader(myFile);

     BufferedReader reader=new BufferedReader(fileReader);

     String line=null;
while((line=reader.readLine())!=null){
     result=line;
}
     reader.close();
}catch(Exception ex){
     ex.printStackTrace();
}
     return result;

}

static void playMusic(){
	Runnable music=new Runnable(){
		public void run(){
	
	try{
		File backMusic=new File("backmusic.wav");
		URI musicURI=backMusic.toURI();
		URL musicURL=musicURI.toURL();
	
		AudioClip backMusicPlayer=Applet.newAudioClip(musicURL);
		backMusicPlayer.play();
		backMusicPlayer.loop();  
	
	}catch(Exception ex){
		ex.printStackTrace();
		System.out.println("chucuo");
	}
	}
};
 new Thread(music).start();
}
//////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
////////////////////////////////////main function
///////////////////////////////////////////////////////////////
public static void main(String[] args){
	
	  firstframe.setTitle("颜团子的征途");
      firstframe.setBounds(40, 40, width, height);
      toppanel.setOpaque(false);
      mainlabel.setBounds(0,0,width,height);
      BackMusic backMU=new BackMusic();
      backMU.setDaemon(true);
      backMU.start();
     
     
      formercomic(firstframe);
  
   
   
          
   
}
	////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////main function
///////////////////////////////////////////////////////////formercomic
//////////////////////////////////////////////////////////////
static void formercomic(JFrame frame0){
Runnable runnable = new Runnable() {

@Override
public void run() {

ImageIcon image0=new ImageIcon("PCstarting.jpg");
ImageIcon image1=new ImageIcon("PCcomic1.jpg"); 
ImageIcon image2=new ImageIcon("PCcomic2.jpg");
ImageIcon image3=new ImageIcon("PCcomic3.jpg"); 
ImageIcon image4=new ImageIcon("PCcomic4.jpg");
ImageIcon image5=new ImageIcon("PCcomic5.jpg"); 

int height=frame0.getHeight();
int width=frame0.getWidth();
JLabel label0=new JLabel(image0);
JLabel label1=new JLabel(image1);
JLabel label2=new JLabel(image2);
JLabel label3=new JLabel(image3);
JLabel label4=new JLabel(image4);
JLabel label5=new JLabel(image5);
//It is strange that we use "/" rather than "\" to tell the path
label0.setBounds(0, 0,width,height);
label1.setBounds(0, 0,width,height);
label2.setBounds(0, 0,width,height);
label3.setBounds(0, 0,width,height);
label4.setBounds(0, 0,width,height);
label5.setBounds(0, 0,width,height);
frame0.setBounds(40, 40, width, height);

JPanel panel0=(JPanel)frame0.getContentPane();
panel0.setOpaque(false);
//if you want to put something on the content pane(the top panel/surface)
SwingUtilities.invokeLater(new Runnable() {

@Override
public void run() {
frame0.getLayeredPane().add(label0,new Integer(Integer.MIN_VALUE));
frame0.setVisible(true);
}

});


try{
Thread.sleep(3000);
}catch(InterruptedException e){
e.printStackTrace();
}
SwingUtilities.invokeLater(new Runnable() {

@Override
public void run() {
frame0.getLayeredPane().remove(label0);
frame0.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
frame0.setVisible(true);
}

});
try{
Thread.sleep(3000);
}catch(InterruptedException e){
e.printStackTrace();
}
SwingUtilities.invokeLater(new Runnable() {

@Override
public void run() {
frame0.getLayeredPane().remove(label1);
frame0.getLayeredPane().add(label2,new Integer(Integer.MIN_VALUE));
frame0.setVisible(true);
}

});

try{
Thread.sleep(3000);
}catch(InterruptedException e){
e.printStackTrace();
}
SwingUtilities.invokeLater(new Runnable() {

@Override
public void run() {
frame0.getLayeredPane().remove(label2);
frame0.getLayeredPane().add(label3,new Integer(Integer.MIN_VALUE));
frame0.setVisible(true);
}

});

try{
Thread.sleep(3000);
}catch(InterruptedException e){
e.printStackTrace();
}
SwingUtilities.invokeLater(new Runnable() {

@Override
public void run() {
frame0.getLayeredPane().remove(label3);
frame0.getLayeredPane().add(label4,new Integer(Integer.MIN_VALUE));
frame0.setVisible(true);

}

});
try{
Thread.sleep(3000);
}catch(InterruptedException e){
e.printStackTrace();
}
SwingUtilities.invokeLater(new Runnable() {

@Override
public void run() {
frame0.getLayeredPane().remove(label4);
frame0.getLayeredPane().add(label5,new Integer(Integer.MIN_VALUE));
frame0.setVisible(true);
}

});

try{
Thread.sleep(3000);
}catch(InterruptedException e){
e.printStackTrace();
}
SwingUtilities.invokeLater(new Runnable() {

@Override
public void run() {
frame0.getLayeredPane().remove(label5);
frame0.setVisible(true);
}

});
try{
Thread.sleep(100);
initial();
}catch(InterruptedException e){
e.printStackTrace();
} 
//////////////////Amazing!

}

};
new Thread(runnable).start();

}
 	public static void initial(){
 		  firstframe.setBounds(40, 40, width, height);
 		 mainlabel.setBounds(0,0,width,height);

    	 //if you want to put something on the content pane(the top panel/surface)
    	 firstframe.getLayeredPane().add(mainlabel,new Integer(Integer.MIN_VALUE));
    	 firstframe.setVisible(true);
    	 JButton newgameBU=new JButton();
    	 newgameBU.setIcon(newgameIcon);
    	 newgameBU.setRolloverIcon(newgamerollover);
    	 newgameBU.setOpaque(false);  
         newgameBU.setContentAreaFilled(false);  
         newgameBU.setMargin(new Insets(0, 0, 0, 0));  
         newgameBU.setFocusPainted(false);  
         newgameBU.setBorderPainted(false);  
         newgameBU.setBorder(null);  
    	 newgameBU.addActionListener(
    			 new ActionListener(){
    				 public void actionPerformed(ActionEvent ex){
    					 newGame();
    				 }
    			 }
    			 );
    	JButton continuegameBU=new JButton();
   	 continuegameBU.setIcon(continuegameIcon);
   	continuegameBU.setRolloverIcon(continuegamerollover);
   	continuegameBU.setOpaque(false);  
    continuegameBU.setContentAreaFilled(false);  
    continuegameBU.setMargin(new Insets(0, 0, 0, 0));  
    continuegameBU.setFocusPainted(false);  
    continuegameBU.setBorderPainted(false);  
    continuegameBU.setBorder(null);  
   	 continuegameBU.addActionListener(
    			 new ActionListener(){
    				 public void actionPerformed(ActionEvent ex){
    					File myFile=new File("Data.txt");
    					if(myFile.exists()){
    						stages=Integer.parseInt(readStages());
    						choice=Integer.parseInt(readMode());
    						continueGame();
    						
    					}
    					
    				 }
    			 }
    			 );
   	 JButton exitgameBU=new JButton();
   	 exitgameBU.setIcon(exitgameIcon);
   	 exitgameBU.setRolloverIcon(exitgamerollover);
   	 exitgameBU.setOpaque(false);  
     exitgameBU.setContentAreaFilled(false);  
     exitgameBU.setMargin(new Insets(0, 0, 0, 0));  
     exitgameBU.setFocusPainted(false);  
     exitgameBU.setBorderPainted(false);  
     exitgameBU.setBorder(null);  
   	 exitgameBU.addActionListener(
    			 new ActionListener(){
    				 public void actionPerformed(ActionEvent ex){
    					System.exit(0);
    					
    				 }
    			 }
    			 );
   	 
   	 mainlabel.setLayout(null);
   	 mainlabel.add(newgameBU);
   	mainlabel.add(continuegameBU);
   	mainlabel.add(exitgameBU);
   	
	    width2=(newgameIcon.getIconWidth()*3)/2;
	   	height2=(newgameIcon.getIconHeight())*2;
	   	newgameBU.setBounds(670, 300, width2, height2);
	   	continuegameBU.setBounds(670, 550, width2, height2);
	   	exitgameBU.setBounds(670,800,width2, height2);
	  
  
      firstframe.setVisible(true);
  
		
	} 
	////////////////////////////////////////////////initail gui
	////////////////////////////////////////////
	///////////////////////////////////////////
	public static void newGame(){
		  mainlabel.removeAll();
		  firstframe.getLayeredPane().remove(mainlabel);
		  JPanel panel0=(JPanel)firstframe.getContentPane();
	       panel0.setOpaque(false);
		  stages=1;
		  ////////////////////////////////////the first boundar
		  firstframe.getLayeredPane().add(mainlabel,new Integer(Integer.MIN_VALUE));
		  mainlabel.setVisible(true);
		  firstframe.setVisible(true);
		 
		  JButton standard=new JButton();
	    	 JButton classic=new JButton();
	    	 standard.setIcon(standardBU);
	    	 standard.setRolloverIcon(standardBUrollover);
	    	 standard.setOpaque(false);  
	    	 standard.setContentAreaFilled(false);  
	    	 standard.setMargin(new Insets(0, 0, 0, 0));  
	    	 standard.setFocusPainted(false);  
	    	 standard.setBorderPainted(false);  
	    	 standard.setBorder(null);  
	    	 classic.setIcon(classicBU);
	    	 classic.setRolloverIcon(classicBUrollover);
	    	 classic.setOpaque(false);  
	    	 classic.setContentAreaFilled(false);  
	    	 classic.setMargin(new Insets(0, 0, 0, 0));  
	    	 classic.setFocusPainted(false);  
	    	 classic.setBorderPainted(false);  
	    	 classic.setBorder(null);  
	    	 standard.addActionListener(
	    			 new ActionListener(){
	    				 public void actionPerformed(ActionEvent ex){
	    					 Runnable run8=new Runnable(){
	    						 public void run(){
	    				    	choice=0;
	    					 mainlabel.removeAll();
	    					 SwingUtilities.invokeLater(new Runnable() {

	    						 @Override
	    						 public void run() {
	    						firstframe.getLayeredPane().remove(mainlabel);
	   	    			  		firstframe.setBounds(40, 40, width, height);
	   	    			  		 Standard.setBounds(0,0,width,height);
	   	    			  		 firstframe.getLayeredPane().add(Standard);
	   	    			  		 
	    						 }

	    						 });
	    			  		
	    				 }
	    				 
	    				 };
	    				 new Thread(run8).start();
	    			 }});
	    	 classic.addActionListener(
	    			 new ActionListener(){
	    				 public void actionPerformed(ActionEvent ex){
	    					 Runnable run8=new Runnable(){
	    						 public void run(){
	    					choice=1;
	    					 mainlabel.removeAll();
	    					 SwingUtilities.invokeLater(new Runnable() {

	    						 @Override
	    						 public void run() {
	    						firstframe.getLayeredPane().remove(mainlabel);
	   	    			  		 firstframe.setBounds(40, 40, width, height);
	   	    			  		 Classic.setBounds(0,0,width,height);
	   	    			  		 firstframe.getLayeredPane().add(Classic);
	    						 }

	    						 });
	    			  		
	    				 }
	    				 
	    				 };
	    				 new Thread(run8).start();
	    				 }});
	    	 mainlabel.setLayout(null);
	    	 mainlabel.add(standard);
	    	 mainlabel.add(classic);
	    	 standard.setBounds(670, 400, width2+100, height2+50);
	    	 classic.setBounds(670, 600, width2+100, height2+50);
		  //choice==0 means "Standard"   choice==1 means "Classic"
	    	 JButton startGame1=new JButton();
	    	 startGame1.setOpaque(false);
	    	 Standard.add(startGame1);
			  //////////////////////////////////////////
			  startGame1.setIcon(startgame);
			  startGame1.setOpaque(false);  
		      startGame1.setContentAreaFilled(false);  
		      startGame1.setMargin(new Insets(0, 0, 0, 0));  
		      startGame1.setFocusPainted(false);  
		      startGame1.setBorderPainted(false);  
		      startGame1.setBorder(null);  
			  startGame1.setBounds(1600,900,startgame.getIconWidth(),startgame.getIconHeight());
			  startGame1.addActionListener(
					  new ActionListener(){
						  public void actionPerformed(ActionEvent ex){
							  Runnable run9=new Runnable(){
		    						 public void run(){
		    				    	
		    			  		 SwingUtilities.invokeLater(new Runnable() {

		    						 @Override
		    						 public void run() {
		    							 firstframe.getLayeredPane().remove(Standard);
		   	    			  		  firstframe.setBounds(40, 40, width, height);
		   	    			  		 mainlabel.setBounds(0,0,width,height);
		   	    			  	     firstframe.getLayeredPane().add(mainlabel);
		   	    			  
		    						 }

		    						 });
		    			  		 try{
		    			  			 Thread.sleep(10);
		    			  			 continueGame();
		    			  		 }catch(InterruptedException e){
		    			  			 e.printStackTrace();
		    			  		 }
		    					
		    				 }
		    				 
		    				 };
		    				 new Thread(run9).start();
						  }
					  }
					  );
			  JButton startGame2=new JButton();
			  startGame2.setOpaque(false);
			  Classic.add(startGame2);
			  //////////////////////////////////////////
			  startGame2.setIcon(startgame);
			  startGame2.setOpaque(false);  
		      startGame2.setContentAreaFilled(false);  
		      startGame2.setMargin(new Insets(0, 0, 0, 0));  
		      startGame2.setFocusPainted(false);  
		      startGame2.setBorderPainted(false);  
		      startGame2.setBorder(null);  
		      startGame2.setBounds(1600,900,startgame.getIconWidth(),startgame.getIconHeight());
			  startGame2.addActionListener(
					  new ActionListener(){
						  public void actionPerformed(ActionEvent ex){
							  Runnable run10=new Runnable(){
		    						 public void run(){
		    				    	
		    			  		 SwingUtilities.invokeLater(new Runnable() {

		    						 @Override
		    						 public void run() {
		    							 firstframe.getLayeredPane().remove(Classic);
		   	    			  		  firstframe.setBounds(40, 40, width, height);
		   	    			  		 mainlabel.setBounds(0,0,width,height);
		   	    			  		 firstframe.getLayeredPane().add(mainlabel);
		   	    			  
		    						 }

		    						 });
		    			  		 try{
		    			  			 Thread.sleep(10);
		    			  			 continueGame();
		    			  		 }catch(InterruptedException e){
		    			  			 e.printStackTrace();
		    			  		 }
		    					
		    				 }
		    				 
		    				 };
		    				 new Thread(run10).start();
						  }
					  }
					  );
	    
	}
     public static void continueGame(){
    	 SwingUtilities.invokeLater(new Runnable() {

			 @Override
			 public void run() {
				     mainlabel.removeAll();
			  		 firstframe.getLayeredPane().remove(mainlabel);
			  		 firstframe.setBounds(40, 40, width, height);
			     	 backg.setBounds(0,0,width,height);
			     	 firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
		      
			 }

			 });
    	 
    	 
  	    
  		 mainpanel.removeAll();
  	  	  
   	    toppanel.setOpaque(false);
   	    mainpanel.setOpaque(false);
   	    toppanel.add(mainpanel);
   	    //we will add other components on the mainpanel
     	
      	  
      	  mainpanel.setLayout(null);
      	  
   	 
     	  flowerpanel.setOpaque(false);
      
      	  
      	  JPanel panel1=new JPanel();
      	  panel1.setLayout(new GridLayout(4,1));
         
      	  Font fon=new Font("方正喵呜体",1,60);
  		  stage.setFont(fon);
  		  stage.setText("Stages:"+String.valueOf(stages));
  		  stage.setOpaque(false);
  		  stage.setBorder(null);
  		 
  		  step.setFont(fon);
  		  step.setText("Steps:"+String.valueOf(steps));
  		  step.setBorder(null);
  		  step.setOpaque(false);
  		  
  		  score.setFont(fon);
  		  score.setText("Scores:"+String.valueOf(scores));
  		  score.setBorder(null);
  		  score.setOpaque(false);
  		
  		  target.setFont(fon);
  		  target.setText("Targets:"+String.valueOf(targets));
  		  target.setOpaque(false);
  		  target.setBorder(null);
  		  panel1.add(stage);
  		  panel1.add(target);
  		  panel1.add(step);
  		  panel1.add(score);
  		  panel1.setOpaque(false);
  		
  		  JPanel panel2=new JPanel();
  		  panel2.setOpaque(false);
  		  
  		  exit.setIcon(exitBU);
  		  exit.setRolloverIcon(exitBUrollover);
  		  exit.setOpaque(false);  
  		  exit.setContentAreaFilled(false);  
  		  exit.setMargin(new Insets(0, 0, 0, 0));  
  		  exit.setFocusPainted(false);  
  		  exit.setBorderPainted(false);  
  		  exit.setBorder(null);  
  		 
  		  mainpanel.add(panel1);
  		  mainpanel.add(panel2);
  		  mainpanel.add(flowerpanel);
  		  mainpanel.add(exit);
  		  panel1.setBounds(1200, 100, width/2, height/3+100);
 		  flowerpanel.setBounds(800,20+height/2,width/2,height/2);
 		  panel2.setBounds(50, 100, width/2, width/2);
 		  exit.setBounds(width-400, height-400, exitBU.getIconWidth()*4, exitBU.getIconHeight()*4);
  		  firstframe.setVisible(true);
  		  startgame(panel2,flowerpanel,exit);
     
    	     
     }
     
     public static void startgame(JPanel panel2,JPanel flowerpanel,JButton exit){
    	
    	 Runnable run2=new Runnable(){
   		  public void run(){
    	 
    	 firstframe.setVisible(true);
    	 if(choice==0){//GAme1  Standard
    		
    		 switch(stages){
    		 case 1:{
    			
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel1);
    			 steps=10;
    			 targets=20;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			
    			 GAme1 game1=new GAme1(steps,targets,"begin");
    			 panel2.removeAll();
    			  Runnable newrun=new Runnable(){
    				  public void run(){
    			 returnmessage=game1.playGame1(panel2, step, score,exit);
    				  }
    			  };
    			  Thread athread=new Thread(newrun);
    			  athread.start();
    			  try{
    				  athread.join();
    			  }catch(InterruptedException e){
    				  e.printStackTrace();
    			  }
    			 if(returnmessage.equals("win")){
    				 stages++;
    			     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    			     
    				 toppanel.remove(mainpanel);
    				 //
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 //
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Pass1.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Pass1,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bcontinue=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bcontinue.setIcon(continuegameIcon);
    		    	 Bcontinue.setRolloverIcon(continuegamerollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bcontinue.setOpaque(false);  
    		  		 Bcontinue.setContentAreaFilled(false);  
    		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bcontinue.setFocusPainted(false);  
    		  		 Bcontinue.setBorderPainted(false);  
    		  		 Bcontinue.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bcontinue.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Pass1);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Pass1);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Pass1.setLayout(null);
    		    	 Pass1.add(Bcontinue);
    		    	 Pass1.add(Bexit);
    		    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    		    	
    		    	 
    				    			 }
    			 else if(returnmessage.equals("dead")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				 //
    				 toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Dead.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Dead);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Dead);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Dead.setLayout(null);
    		    	 Dead.add(Bagain);
    		    	 Dead.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    	 			 }
    			 else if(returnmessage.equals("lose")){
                     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Lose.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Lose);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Lose);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Lose.setLayout(null);
    		    	 Lose.add(Bagain);
    		    	 Lose.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    			 }
    			 else if(returnmessage.equals("exit")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    				firstframe.getLayeredPane().remove(backg);
    				 writeMode(String.valueOf(choice));
    	    		 writeStages(String.valueOf(stages));
    	    		 initial();
    			
    			 }
    			 
    			 break;
    		 }
    		 //////////////////////////////////////
    		 case 2:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel2);
    			 steps=9;
    			 targets=22;
    			 scores=0;
    			 score.removeAll();
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+scores);
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 GAme1 game1=new GAme1(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
   				  public void run(){
   			 returnmessage=game1.playGame1(panel2, step, score,exit);
   				  }
   			  };
   			  Thread athread=new Thread(newrun);
   			  athread.start();
   			  try{
   				  athread.join();
   			  }catch(InterruptedException e){
   				  e.printStackTrace();
   			  }
    			
   			 if(returnmessage.equals("win")){
				 stages++;
			     try{
		    		 Thread.sleep(800);
		    	 }catch(InterruptedException e){
		    		 e.printStackTrace();
		    	 }
			     
				 toppanel.remove(mainpanel);
				 //
		    	 firstframe.getLayeredPane().remove(backg);
		    	 //
		    	 firstframe.setBounds(40, 40, width, height);
		 		 Pass2.setBounds(0,0,width,height);
		    	 firstframe.getLayeredPane().add(Pass2,new Integer(Integer.MIN_VALUE));
		    	 firstframe.setVisible(true);
		    	 try{
		    		 Thread.sleep(800);
		    	 }catch(InterruptedException e){
		    		 e.printStackTrace();
		    	 }
		    	 JButton Bcontinue=new JButton();
		    	 JButton Bexit=new JButton();
		    	 Bcontinue.setIcon(continuegameIcon);
		    	 Bcontinue.setRolloverIcon(continuegamerollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
		    	 Bcontinue.setOpaque(false);  
		  		 Bcontinue.setContentAreaFilled(false);  
		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bcontinue.setFocusPainted(false);  
		  		 Bcontinue.setBorderPainted(false);  
		  		 Bcontinue.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
		    	 Bcontinue.addActionListener(
		    			 new ActionListener(){
		    				 public void actionPerformed(ActionEvent ex){
		    					  firstframe.getLayeredPane().remove(Pass2);
		     	    		     firstframe.setBounds(40, 40, width, height);
		         		 		 backg.setBounds(0,0,width,height);
		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
		        	    		 firstframe.setVisible(true);
		        	    		     //
		  	    		         toppanel.add(mainpanel);
		  	    		         panel2.removeAll();
		         				 startgame(panel2,flowerpanel,exit);
		    				 }
		    			 });
		    	 Bexit.addActionListener(
		    			 new ActionListener(){
		    				 public void actionPerformed(ActionEvent ex){
		    					//exit
		    					  /////////////////////////////////////////////////initial
		     	    		     firstframe.getLayeredPane().remove(Pass2);
		        	    		 writeMode(String.valueOf(choice));
		        	    		 writeStages(String.valueOf(stages));
		        	    		 initial();
		    				 }
		    			 });
		    	 Pass2.setLayout(null);
		    	 Pass2.add(Bcontinue);
		    	 Pass2.add(Bexit);
		    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
		    	 
				    			 }
			 else if(returnmessage.equals("dead")){
				 try{
		    		 Thread.sleep(800);
		    	 }catch(InterruptedException e){
		    		 e.printStackTrace();
		    	 }
				 //
				 toppanel.remove(mainpanel);
		    	 firstframe.getLayeredPane().remove(backg);
		    	 firstframe.setBounds(40, 40, width, height);
		 		 Dead.setBounds(0,0,width,height);
		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
		    	 firstframe.setVisible(true);
		    	 try{
		    		 Thread.sleep(800);
		    	 }catch(InterruptedException e){
		    		 e.printStackTrace();
		    	 }
		    	 JButton Bagain=new JButton();
		    	 JButton Bexit=new JButton();
		    	 Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
		    	 Bagain.addActionListener(
		    			 new ActionListener(){
		    				 public void actionPerformed(ActionEvent ex){
		    					  firstframe.getLayeredPane().remove(Dead);
		     	    		     firstframe.setBounds(40, 40, width, height);
		         		 		 backg.setBounds(0,0,width,height);
		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
		        	    		 firstframe.setVisible(true);
		        	    		     //
		  	    		         toppanel.add(mainpanel);
		  	    		         panel2.removeAll();
		         				 startgame(panel2,flowerpanel,exit);
		    				 }
		    			 });
		    	 Bexit.addActionListener(
		    			 new ActionListener(){
		    				 public void actionPerformed(ActionEvent ex){
		    					//exit
		    					  /////////////////////////////////////////////////initial
		     	    		     firstframe.getLayeredPane().remove(Dead);
		        	    		 writeMode(String.valueOf(choice));
		        	    		 writeStages(String.valueOf(stages));
		        	    		 initial();
		    				 }
		    			 });
		    	 Dead.setLayout(null);
		    	 Dead.add(Bagain);
		    	 Dead.add(Bexit);
		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
	 			 }
			 else if(returnmessage.equals("lose")){
                 try{
		    		 Thread.sleep(800);
		    	 }catch(InterruptedException e){
		    		 e.printStackTrace();
		    	 }
				toppanel.remove(mainpanel);
		    	 firstframe.getLayeredPane().remove(backg);
		    	 firstframe.setBounds(40, 40, width, height);
		 		 Lose.setBounds(0,0,width,height);
		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
		    	 firstframe.setVisible(true);
		    	 try{
		    		 Thread.sleep(800);
		    	 }catch(InterruptedException e){
		    		 e.printStackTrace();
		    	 }
		    	 JButton Bagain=new JButton();
		    	 JButton Bexit=new JButton();
		    	 Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
		    	 Bagain.addActionListener(
		    			 new ActionListener(){
		    				 public void actionPerformed(ActionEvent ex){
		    					  firstframe.getLayeredPane().remove(Lose);
		     	    		     firstframe.setBounds(40, 40, width, height);
		         		 		 backg.setBounds(0,0,width,height);
		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
		        	    		 firstframe.setVisible(true);
		        	    		     //
		  	    		         toppanel.add(mainpanel);
		  	    		         panel2.removeAll();
		         				 startgame(panel2,flowerpanel,exit);
		    				 }
		    			 });
		    	 Bexit.addActionListener(
		    			 new ActionListener(){
		    				 public void actionPerformed(ActionEvent ex){
		    					//exit
		    					  /////////////////////////////////////////////////initial
		     	    		     firstframe.getLayeredPane().remove(Lose);
		        	    		 writeMode(String.valueOf(choice));
		        	    		 writeStages(String.valueOf(stages));
		        	    		 initial();
		    				 }
		    			 });
		    	 Lose.setLayout(null);
		    	 Lose.add(Bagain);
		    	 Lose.add(Bexit);
		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
			 }
			 else if(returnmessage.equals("exit")){
				 try{
		    		 Thread.sleep(800);
		    	 }catch(InterruptedException e){
		    		 e.printStackTrace();
		    	 }
				toppanel.remove(mainpanel);
				firstframe.getLayeredPane().remove(backg);
				 writeMode(String.valueOf(choice));
	    		 writeStages(String.valueOf(stages));
	    		 initial();
			
			 }
			 
			 
			 break;
		 }
    		 case 3:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel3);
    			 steps=8;
    			 targets=24;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 GAme1 game1=new GAme1(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
      				  public void run(){
      			 returnmessage=game1.playGame1(panel2, step, score,exit);
      				  }
      			  };
      			  Thread athread=new Thread(newrun);
      			  athread.start();
      			  try{
      				  athread.join();
      			  }catch(InterruptedException e){
      				  e.printStackTrace();
      			  }
    			
      			 if(returnmessage.equals("win")){
    				 stages++;
    			     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    			     
    				 toppanel.remove(mainpanel);
    				 //
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 //
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Pass3.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Pass3,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bcontinue=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bcontinue.setIcon(continuegameIcon);
    		    	 Bcontinue.setRolloverIcon(continuegamerollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bcontinue.setOpaque(false);  
    		  		 Bcontinue.setContentAreaFilled(false);  
    		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bcontinue.setFocusPainted(false);  
    		  		 Bcontinue.setBorderPainted(false);  
    		  		 Bcontinue.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bcontinue.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Pass3);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Pass3);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Pass3.setLayout(null);
    		    	 Pass3.add(Bcontinue);
    		    	 Pass3.add(Bexit);
    		    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    		    	 
    				    			 }
    			 else if(returnmessage.equals("dead")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				 //
    				 toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Dead.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Dead);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Dead);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Dead.setLayout(null);
    		    	 Dead.add(Bagain);
    		    	 Dead.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    	 			 }
    			 else if(returnmessage.equals("lose")){
                     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Lose.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Lose);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Lose);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Lose.setLayout(null);
    		    	 Lose.add(Bagain);
    		    	 Lose.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    			 }
    			 else if(returnmessage.equals("exit")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    				firstframe.getLayeredPane().remove(backg);
    				 writeMode(String.valueOf(choice));
    	    		 writeStages(String.valueOf(stages));
    	    		 initial();
    			
    			 }
    			 
    			 break;
    		 }
    		 case 4:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel4);
    			 steps=7;
    			 targets=26;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 GAme1 game1=new GAme1(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
     				  public void run(){
     			 returnmessage=game1.playGame1(panel2, step, score,exit);
     				  }
     			  };
     			  Thread athread=new Thread(newrun);
     			  athread.start();
     			  try{
     				  athread.join();
     			  }catch(InterruptedException e){
     				  e.printStackTrace();
     			  }
     			 if(returnmessage.equals("win")){
    				 stages++;
    			     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    			     
    				 toppanel.remove(mainpanel);
    				 //
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 //
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Pass4.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Pass4,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bcontinue=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bcontinue.setIcon(continuegameIcon);
    		    	 Bcontinue.setRolloverIcon(continuegamerollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bcontinue.setOpaque(false);  
    		  		 Bcontinue.setContentAreaFilled(false);  
    		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bcontinue.setFocusPainted(false);  
    		  		 Bcontinue.setBorderPainted(false);  
    		  		 Bcontinue.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bcontinue.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Pass4);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Pass4);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Pass4.setLayout(null);
    		    	 Pass4.add(Bcontinue);
    		    	 Pass4.add(Bexit);
    		    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    		    	 
    				    			 }
    			 else if(returnmessage.equals("dead")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				 //
    				 toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Dead.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Dead);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Dead);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Dead.setLayout(null);
    		    	 Dead.add(Bagain);
    		    	 Dead.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    	 			 }
    			 else if(returnmessage.equals("lose")){
                     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Lose.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Lose);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Lose);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Lose.setLayout(null);
    		    	 Lose.add(Bagain);
    		    	 Lose.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    			 }
    			 else if(returnmessage.equals("exit")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    				firstframe.getLayeredPane().remove(backg);
    				 writeMode(String.valueOf(choice));
    	    		 writeStages(String.valueOf(stages));
    	    		 initial();
    			
    			 }
    			 
    			 break;
    		 }
    		 case 5:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel5);
    			 steps=6;
    			 targets=28;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 target.setText("scores:"+String.valueOf(targets));
    			 GAme1 game1=new GAme1(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
     				  public void run(){
     			 returnmessage=game1.playGame1(panel2, step, score,exit);
     				  }
     			  };
     			  Thread athread=new Thread(newrun);
     			  athread.start();
     			  try{
     				  athread.join();
     			  }catch(InterruptedException e){
     				  e.printStackTrace();
     			  }
     			 if(returnmessage.equals("win")){
    				 stages++;
    			     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    			     
    				 toppanel.remove(mainpanel);
    				 //
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 //
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Pass5.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Pass5,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bcontinue=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bcontinue.setIcon(continuegameIcon);
    		    	 Bcontinue.setRolloverIcon(continuegamerollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bcontinue.setOpaque(false);  
    		  		 Bcontinue.setContentAreaFilled(false);  
    		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bcontinue.setFocusPainted(false);  
    		  		 Bcontinue.setBorderPainted(false);  
    		  		 Bcontinue.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bcontinue.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Pass5);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Pass5);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Pass5.setLayout(null);
    		    	 Pass5.add(Bcontinue);
    		    	 Pass5.add(Bexit);
    		    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    		    	 
    				    			 }
    			 else if(returnmessage.equals("dead")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				 //
    				 toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Dead.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Dead);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Dead);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Dead.setLayout(null);
    		    	 Dead.add(Bagain);
    		    	 Dead.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    	 			 }
    			 else if(returnmessage.equals("lose")){
                     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Lose.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Lose);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Lose);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Lose.setLayout(null);
    		    	 Lose.add(Bagain);
    		    	 Lose.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    			 }
    			 else if(returnmessage.equals("exit")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    				firstframe.getLayeredPane().remove(backg);
    				 writeMode(String.valueOf(choice));
    	    		 writeStages(String.valueOf(stages));
    	    		 initial();
    			
    			 }
    			 
    			 
    			 break;
    		 }
    		 case 6:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel6);
    			 steps=5;
    			 targets=30;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 GAme1 game1=new GAme1(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
     				  public void run(){
     			 returnmessage=game1.playGame1(panel2, step, score,exit);
     				  }
     			  };
     			  Thread athread=new Thread(newrun);
     			  athread.start();
     			  try{
     				  athread.join();
     			  }catch(InterruptedException e){
     				  e.printStackTrace();
     			  }
     			 if(returnmessage.equals("win")){
    				 stages++;
    			     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    			     
    				 toppanel.remove(mainpanel);
    				 //
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 //
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Pass6.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Pass6,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bexit=new JButton();
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Pass6);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Pass6.setLayout(null);
    		    	 Pass6.add(Bexit);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    		    	 
    				    			 }
    			 else if(returnmessage.equals("dead")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				 //
    				 toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Dead.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Dead);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Dead);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Dead.setLayout(null);
    		    	 Dead.add(Bagain);
    		    	 Dead.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    	 			 }
    			 else if(returnmessage.equals("lose")){
                     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Lose.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Lose);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Lose);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Lose.setLayout(null);
    		    	 Lose.add(Bagain);
    		    	 Lose.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    			 }
    			 else if(returnmessage.equals("exit")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    				firstframe.getLayeredPane().remove(backg);
    				 writeMode(String.valueOf(choice));
    	    		 writeStages(String.valueOf(stages));
    	    		 initial();
    			
    			 }
    			 
    			 break;
    		 }
    		 }
    	 }//GAme1
    	 ///////////////////////////////////////////////////
    	 ////////////////////////////////////////////////
    	 /////////////////////////////////////////////////
    	 ////////////////////////////////////////////////
    	 else{//GAme2
    		 switch(stages){
    		 case 1:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel1);
    			 steps=10;
    			 targets=20;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 
    			 GAme2 game2=new GAme2(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
     				  public void run(){
     				
     			 returnmessage=game2.playGame2(panel2, step, score,exit);
     				  }
     			  };
     			  Thread athread=new Thread(newrun);
     			  athread.start();
     			  try{
     				  athread.join();
     			  }catch(InterruptedException e){
     				  e.printStackTrace();
     			  }
     			 if(returnmessage.equals("win")){
    				 stages++;
    			     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    			     
    				 toppanel.remove(mainpanel);
    				 //
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 //
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Pass1.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Pass1,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bcontinue=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bcontinue.setIcon(continuegameIcon);
    		    	 Bcontinue.setRolloverIcon(continuegamerollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bcontinue.setOpaque(false);  
    		  		 Bcontinue.setContentAreaFilled(false);  
    		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bcontinue.setFocusPainted(false);  
    		  		 Bcontinue.setBorderPainted(false);  
    		  		 Bcontinue.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bcontinue.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Pass1);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Pass1);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Pass1.setLayout(null);
    		    	 Pass1.add(Bcontinue);
    		    	 Pass1.add(Bexit);
    		    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    		    	 
    				    			 }
    			 else if(returnmessage.equals("dead")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				 //
    				 toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Dead.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Dead);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Dead);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Dead.setLayout(null);
    		    	 Dead.add(Bagain);
    		    	 Dead.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    	 			 }
    			 else if(returnmessage.equals("lose")){
                     try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    		    	 firstframe.getLayeredPane().remove(backg);
    		    	 firstframe.setBounds(40, 40, width, height);
    		 		 Lose.setBounds(0,0,width,height);
    		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
    		    	 firstframe.setVisible(true);
    		    	 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    		    	 JButton Bagain=new JButton();
    		    	 JButton Bexit=new JButton();
    		    	 Bagain.setIcon(againBU);
    		    	 Bagain.setRolloverIcon(againBUrollover);
    		    	 Bexit.setIcon(exitgameIcon);
    		    	 Bexit.setRolloverIcon(exitgamerollover);
    		    	 Bagain.setOpaque(false);  
    		  		 Bagain.setContentAreaFilled(false);  
    		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
    		  		 Bagain.setFocusPainted(false);  
    		  		 Bagain.setBorderPainted(false);  
    		  		 Bagain.setBorder(null);  
    		  		 Bexit.setOpaque(false);  
    		  		  Bexit.setContentAreaFilled(false);  
    		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
    		  		  Bexit.setFocusPainted(false);  
    		  		  Bexit.setBorderPainted(false);  
    		  		  Bexit.setBorder(null);  
    		    	 Bagain.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					  firstframe.getLayeredPane().remove(Lose);
    		     	    		     firstframe.setBounds(40, 40, width, height);
    		         		 		 backg.setBounds(0,0,width,height);
    		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    		        	    		 firstframe.setVisible(true);
    		        	    		     //
    		  	    		         toppanel.add(mainpanel);
    		  	    		         panel2.removeAll();
    		         				 startgame(panel2,flowerpanel,exit);
    		    				 }
    		    			 });
    		    	 Bexit.addActionListener(
    		    			 new ActionListener(){
    		    				 public void actionPerformed(ActionEvent ex){
    		    					//exit
    		    					  /////////////////////////////////////////////////initial
    		     	    		     firstframe.getLayeredPane().remove(Lose);
    		        	    		 writeMode(String.valueOf(choice));
    		        	    		 writeStages(String.valueOf(stages));
    		        	    		 initial();
    		    				 }
    		    			 });
    		    	 Lose.setLayout(null);
    		    	 Lose.add(Bagain);
    		    	 Lose.add(Bexit);
    		    	 Bagain.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    			 }
    			 else if(returnmessage.equals("exit")){
    				 try{
    		    		 Thread.sleep(800);
    		    	 }catch(InterruptedException e){
    		    		 e.printStackTrace();
    		    	 }
    				toppanel.remove(mainpanel);
    				firstframe.getLayeredPane().remove(backg);
    				 writeMode(String.valueOf(choice));
    	    		 writeStages(String.valueOf(stages));
    	    		 initial();
    			
    			 }
    			 
    			 break;
    		 }
    		 //////////////////////////////////////
    		 case 2:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel2);
    			 steps=9;
    			 targets=22;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 GAme2 game2=new GAme2(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
    				  public void run(){
    			 returnmessage=game2.playGame2(panel2, step, score,exit);
    				  }
    			  };
    			  Thread athread=new Thread(newrun);
    			  athread.start();
    			  try{
    				  athread.join();
    			  }catch(InterruptedException e){
    				  e.printStackTrace();
    			  }
    			  if(returnmessage.equals("win")){
    					 stages++;
    				     try{
    			    		 Thread.sleep(800);
    			    	 }catch(InterruptedException e){
    			    		 e.printStackTrace();
    			    	 }
    				     
    					 toppanel.remove(mainpanel);
    					 //
    			    	 firstframe.getLayeredPane().remove(backg);
    			    	 //
    			    	 firstframe.setBounds(40, 40, width, height);
    			 		 Pass2.setBounds(0,0,width,height);
    			    	 firstframe.getLayeredPane().add(Pass2,new Integer(Integer.MIN_VALUE));
    			    	 firstframe.setVisible(true);
    			    	 try{
    			    		 Thread.sleep(800);
    			    	 }catch(InterruptedException e){
    			    		 e.printStackTrace();
    			    	 }
    			    	 JButton Bcontinue=new JButton();
        		    	 JButton Bexit=new JButton();
        		    	 Bcontinue.setIcon(continuegameIcon);
        		    	 Bcontinue.setRolloverIcon(continuegamerollover);
        		    	 Bexit.setIcon(exitgameIcon);
        		    	 Bexit.setRolloverIcon(exitgamerollover);
        		    	 Bcontinue.setOpaque(false);  
        		  		 Bcontinue.setContentAreaFilled(false);  
        		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
        		  		 Bcontinue.setFocusPainted(false);  
        		  		 Bcontinue.setBorderPainted(false);  
        		  		 Bcontinue.setBorder(null);  
        		  		 Bexit.setOpaque(false);  
        		  		  Bexit.setContentAreaFilled(false);  
        		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
        		  		  Bexit.setFocusPainted(false);  
        		  		  Bexit.setBorderPainted(false);  
        		  		  Bexit.setBorder(null);  
    			    	 Bcontinue.addActionListener(
    			    			 new ActionListener(){
    			    				 public void actionPerformed(ActionEvent ex){
    			    					  firstframe.getLayeredPane().remove(Pass2);
    			     	    		     firstframe.setBounds(40, 40, width, height);
    			         		 		 backg.setBounds(0,0,width,height);
    			     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    			        	    		 firstframe.setVisible(true);
    			        	    		     //
    			  	    		         toppanel.add(mainpanel);
    			  	    		         panel2.removeAll();
    			         				 startgame(panel2,flowerpanel,exit);
    			    				 }
    			    			 });
    			    	 Bexit.addActionListener(
    			    			 new ActionListener(){
    			    				 public void actionPerformed(ActionEvent ex){
    			    					//exit
    			    					  /////////////////////////////////////////////////initial
    			     	    		     firstframe.getLayeredPane().remove(Pass2);
    			        	    		 writeMode(String.valueOf(choice));
    			        	    		 writeStages(String.valueOf(stages));
    			        	    		 initial();
    			    				 }
    			    			 });
    			    	 Pass2.setLayout(null);
    			    	 Pass2.add(Bcontinue);
    			    	 Pass2.add(Bexit);
    			    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
        		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    			    	 
    					    			 }
    				 else if(returnmessage.equals("dead")){
    					 try{
    			    		 Thread.sleep(800);
    			    	 }catch(InterruptedException e){
    			    		 e.printStackTrace();
    			    	 }
    					 //
    					 toppanel.remove(mainpanel);
    			    	 firstframe.getLayeredPane().remove(backg);
    			    	 firstframe.setBounds(40, 40, width, height);
    			 		 Dead.setBounds(0,0,width,height);
    			    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
    			    	 firstframe.setVisible(true);
    			    	 try{
    			    		 Thread.sleep(800);
    			    	 }catch(InterruptedException e){
    			    		 e.printStackTrace();
    			    	 }
    			    	 JButton Bagain=new JButton();
        		    	 JButton Bexit=new JButton();
        		    	 Bagain.setIcon(againBU);
        		    	 Bagain.setRolloverIcon(againBUrollover);
        		    	 Bexit.setIcon(exitgameIcon);
        		    	 Bexit.setRolloverIcon(exitgamerollover);
        		    	 Bagain.setOpaque(false);  
        		  		 Bagain.setContentAreaFilled(false);  
        		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
        		  		 Bagain.setFocusPainted(false);  
        		  		 Bagain.setBorderPainted(false);  
        		  		 Bagain.setBorder(null);  
        		  		 Bexit.setOpaque(false);  
        		  		  Bexit.setContentAreaFilled(false);  
        		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
        		  		  Bexit.setFocusPainted(false);  
        		  		  Bexit.setBorderPainted(false);  
        		  		  Bexit.setBorder(null);  
    			    	 Bagain.addActionListener(
    			    			 new ActionListener(){
    			    				 public void actionPerformed(ActionEvent ex){
    			    					  firstframe.getLayeredPane().remove(Dead);
    			     	    		     firstframe.setBounds(40, 40, width, height);
    			         		 		 backg.setBounds(0,0,width,height);
    			     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    			        	    		 firstframe.setVisible(true);
    			        	    		     //
    			  	    		         toppanel.add(mainpanel);
    			  	    		         panel2.removeAll();
    			         				 startgame(panel2,flowerpanel,exit);
    			    				 }
    			    			 });
    			    	 Bexit.addActionListener(
    			    			 new ActionListener(){
    			    				 public void actionPerformed(ActionEvent ex){
    			    					//exit
    			    					  /////////////////////////////////////////////////initial
    			     	    		     firstframe.getLayeredPane().remove(Dead);
    			        	    		 writeMode(String.valueOf(choice));
    			        	    		 writeStages(String.valueOf(stages));
    			        	    		 initial();
    			    				 }
    			    			 });
    			    	 Dead.setLayout(null);
    			    	 Dead.add(Bagain);
    			    	 Dead.add(Bexit);
    			    	 Bagain.setBounds(670, 400, width2+100, height2+50);
        		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    		 			 }
    				 else if(returnmessage.equals("lose")){
    	                 try{
    			    		 Thread.sleep(800);
    			    	 }catch(InterruptedException e){
    			    		 e.printStackTrace();
    			    	 }
    					toppanel.remove(mainpanel);
    			    	 firstframe.getLayeredPane().remove(backg);
    			    	 firstframe.setBounds(40, 40, width, height);
    			 		 Lose.setBounds(0,0,width,height);
    			    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
    			    	 firstframe.setVisible(true);
    			    	 try{
    			    		 Thread.sleep(800);
    			    	 }catch(InterruptedException e){
    			    		 e.printStackTrace();
    			    	 }
    			    	 JButton Bagain=new JButton();
        		    	 JButton Bexit=new JButton();
        		    	 Bagain.setIcon(againBU);
        		    	 Bagain.setRolloverIcon(againBUrollover);
        		    	 Bexit.setIcon(exitgameIcon);
        		    	 Bexit.setRolloverIcon(exitgamerollover);
        		    	 Bagain.setOpaque(false);  
        		  		 Bagain.setContentAreaFilled(false);  
        		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
        		  		 Bagain.setFocusPainted(false);  
        		  		 Bagain.setBorderPainted(false);  
        		  		 Bagain.setBorder(null);  
        		  		 Bexit.setOpaque(false);  
        		  		  Bexit.setContentAreaFilled(false);  
        		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
        		  		  Bexit.setFocusPainted(false);  
        		  		  Bexit.setBorderPainted(false);  
        		  		  Bexit.setBorder(null);  
    			    	 Bagain.addActionListener(
    			    			 new ActionListener(){
    			    				 public void actionPerformed(ActionEvent ex){
    			    					  firstframe.getLayeredPane().remove(Lose);
    			     	    		     firstframe.setBounds(40, 40, width, height);
    			         		 		 backg.setBounds(0,0,width,height);
    			     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    			        	    		 firstframe.setVisible(true);
    			        	    		     //
    			  	    		         toppanel.add(mainpanel);
    			  	    		         panel2.removeAll();
    			         				 startgame(panel2,flowerpanel,exit);
    			    				 }
    			    			 });
    			    	 Bexit.addActionListener(
    			    			 new ActionListener(){
    			    				 public void actionPerformed(ActionEvent ex){
    			    					//exit
    			    					  /////////////////////////////////////////////////initial
    			     	    		     firstframe.getLayeredPane().remove(Lose);
    			        	    		 writeMode(String.valueOf(choice));
    			        	    		 writeStages(String.valueOf(stages));
    			        	    		 initial();
    			    				 }
    			    			 });
    			    	 Lose.setLayout(null);
    			    	 Lose.add(Bagain);
    			    	 Lose.add(Bexit);
    			    	 Bagain.setBounds(670, 400, width2+100, height2+50);
        		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
    				 }
    				 else if(returnmessage.equals("exit")){
    					 try{
    			    		 Thread.sleep(800);
    			    	 }catch(InterruptedException e){
    			    		 e.printStackTrace();
    			    	 }
    					toppanel.remove(mainpanel);
    					firstframe.getLayeredPane().remove(backg);
    					 writeMode(String.valueOf(choice));
    		    		 writeStages(String.valueOf(stages));
    		    		 initial();
    				
    				 }
    				 
    			 break;
    		 }
    		 case 3:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel3);
    			 steps=8;
    			 targets=24;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 GAme2 game2=new GAme2(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
    				  public void run(){
    			 returnmessage=game2.playGame2(panel2, step, score,exit);
    				  }
    			  };
    			  Thread athread=new Thread(newrun);
    			  athread.start();
    			  try{
    				  athread.join();
    			  }catch(InterruptedException e){
    				  e.printStackTrace();
    			  }
    			  if(returnmessage.equals("win")){
     				 stages++;
     			     try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     			     
     				 toppanel.remove(mainpanel);
     				 //
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 //
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Pass3.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Pass3,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bcontinue=new JButton();
   		    	    JButton Bexit=new JButton();
   		    	 Bcontinue.setIcon(continuegameIcon);
		    	 Bcontinue.setRolloverIcon(continuegamerollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bcontinue.setOpaque(false);  
		  		 Bcontinue.setContentAreaFilled(false);  
		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bcontinue.setFocusPainted(false);  
		  		 Bcontinue.setBorderPainted(false);  
		  		 Bcontinue.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bcontinue.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Pass3);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Pass3);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Pass3.setLayout(null);
     		    	 Pass3.add(Bcontinue);
     		    	 Pass3.add(Bexit);
     		    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
     		    	 
     				    			 }
     			 else if(returnmessage.equals("dead")){
     				 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				 //
     				 toppanel.remove(mainpanel);
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Dead.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bagain=new JButton();
   		    	 JButton Bexit=new JButton();
   		    	 Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bagain.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Dead);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Dead);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Dead.setLayout(null);
     		    	 Dead.add(Bagain);
     		    	 Dead.add(Bexit);
     		    	Bagain.setBounds(670, 400, width2+100, height2+50);
   		    	    Bexit.setBounds(670, 600, width2+100, height2+50);
     	 			 }
     			 else if(returnmessage.equals("lose")){
                      try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				toppanel.remove(mainpanel);
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Lose.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bagain=new JButton();
   		    	    JButton Bexit=new JButton();
   		    	 Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bagain.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Lose);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Lose);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Lose.setLayout(null);
     		    	 Lose.add(Bagain);
     		    	 Lose.add(Bexit);
     		    	Bagain.setBounds(670, 400, width2+100, height2+50);
   		    	    Bexit.setBounds(670, 600, width2+100, height2+50);
     			 }
     			 else if(returnmessage.equals("exit")){
     				 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				toppanel.remove(mainpanel);
     				firstframe.getLayeredPane().remove(backg);
     				 writeMode(String.valueOf(choice));
     	    		 writeStages(String.valueOf(stages));
     	    		 initial();
     			
     			 }
     			 
    			 
    			 break;
    		 }
    		 case 4:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel4);
    			 steps=7;
    			 targets=26;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 GAme2 game2=new GAme2(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
    				  public void run(){
    			 returnmessage=game2.playGame2(panel2, step, score,exit);
    				  }
    			  };
    			  Thread athread=new Thread(newrun);
    			  athread.start();
    			  try{
    				  athread.join();
    			  }catch(InterruptedException e){
    				  e.printStackTrace();
    			  }
    			  if(returnmessage.equals("win")){
     				 stages++;
     			     try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     			     
     				 toppanel.remove(mainpanel);
     				 //
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 //
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Pass4.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Pass4,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bcontinue=new JButton();
   		    	    JButton Bexit=new JButton();
   		    	 Bcontinue.setIcon(continuegameIcon);
		    	 Bcontinue.setRolloverIcon(continuegamerollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bcontinue.setOpaque(false);  
		  		 Bcontinue.setContentAreaFilled(false);  
		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bcontinue.setFocusPainted(false);  
		  		 Bcontinue.setBorderPainted(false);  
		  		 Bcontinue.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bcontinue.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Pass4);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Pass4);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Pass4.setLayout(null);
     		    	 Pass4.add(Bcontinue);
     		    	 Pass4.add(Bexit);
     		    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
     		    	 
     				    			 }
     			 else if(returnmessage.equals("dead")){
     				 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				 //
     				 toppanel.remove(mainpanel);
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Dead.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bagain=new JButton();
   		    	 JButton Bexit=new JButton();
   		    	Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bagain.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Dead);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Dead);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Dead.setLayout(null);
     		    	 Dead.add(Bagain);
     		    	 Dead.add(Bexit);
     		    	Bagain.setBounds(670, 400, width2+100, height2+50);
   		    	    Bexit.setBounds(670, 600, width2+100, height2+50);
     	 			 }
     			 else if(returnmessage.equals("lose")){
                      try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				toppanel.remove(mainpanel);
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Lose.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bagain=new JButton();
   		    	    JButton Bexit=new JButton();
   		    	 Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bagain.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Lose);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Lose);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Lose.setLayout(null);
     		    	 Lose.add(Bagain);
     		    	 Lose.add(Bexit);
     		    	Bagain.setBounds(670, 400, width2+100, height2+50);
   		    	    Bexit.setBounds(670, 600, width2+100, height2+50);
     			 }
     			 else if(returnmessage.equals("exit")){
     				 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				toppanel.remove(mainpanel);
     				firstframe.getLayeredPane().remove(backg);
     				 writeMode(String.valueOf(choice));
     	    		 writeStages(String.valueOf(stages));
     	    		 initial();
     			
     			 }
    			 break;
    		 }
    		 case 5:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel5);
    			 steps=6;
    			 targets=28;
    			 scores=0;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 GAme2 game2=new GAme2(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
    				  public void run(){
    			 returnmessage=game2.playGame2(panel2, step, score,exit);
    				  }
    			  };
    			  Thread athread=new Thread(newrun);
    			  athread.start();
    			  try{
    				  athread.join();
    			  }catch(InterruptedException e){
    				  e.printStackTrace();
    			  }
    			  if(returnmessage.equals("win")){
     				 stages++;
     			     try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     			     
     				 toppanel.remove(mainpanel);
     				 //
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 //
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Pass5.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Pass5,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bcontinue=new JButton();
   		    	    JButton Bexit=new JButton();
   		    	 Bcontinue.setIcon(continuegameIcon);
		    	 Bcontinue.setRolloverIcon(continuegamerollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bcontinue.setOpaque(false);  
		  		 Bcontinue.setContentAreaFilled(false);  
		  		 Bcontinue.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bcontinue.setFocusPainted(false);  
		  		 Bcontinue.setBorderPainted(false);  
		  		 Bcontinue.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bcontinue.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Pass5);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Pass5);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Pass5.setLayout(null);
     		    	 Pass5.add(Bcontinue);
     		    	 Pass5.add(Bexit);
     		    	 Bcontinue.setBounds(670, 400, width2+100, height2+50);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
     		    	 
     				    			 }
     			 else if(returnmessage.equals("dead")){
     				 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				 //
     				 toppanel.remove(mainpanel);
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Dead.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bagain=new JButton();
   		    	 JButton Bexit=new JButton();
   		    	Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bagain.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Dead);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Dead);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Dead.setLayout(null);
     		    	 Dead.add(Bagain);
     		    	 Dead.add(Bexit);
     		    	Bagain.setBounds(670, 400, width2+100, height2+50);
   		    	    Bexit.setBounds(670, 600, width2+100, height2+50);
     	 			 }
     			 else if(returnmessage.equals("lose")){
                      try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				toppanel.remove(mainpanel);
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Lose.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bagain=new JButton();
   		    	    JButton Bexit=new JButton();
   		    	 Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bagain.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Lose);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Lose);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Lose.setLayout(null);
     		    	 Lose.add(Bagain);
     		    	 Lose.add(Bexit);
     		    	Bagain.setBounds(670, 400, width2+100, height2+50);
   		    	    Bexit.setBounds(670, 600, width2+100, height2+50);
     			 }
     			 else if(returnmessage.equals("exit")){
     				 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				toppanel.remove(mainpanel);
     				firstframe.getLayeredPane().remove(backg);
     				 writeMode(String.valueOf(choice));
     	    		 writeStages(String.valueOf(stages));
     	    		 initial();
     			
     			 }
     			 
    			 
    			 break;
    		 }
    		 case 6:{
    			 flowerpanel.removeAll();
    			 flowerpanel.add(flowerlabel6);
    			 steps=5;
    			 targets=30;
    			 stage.setText("Stages:"+String.valueOf(stages));
    			 score.setText("Scores:"+String.valueOf(scores));
    			 step.setText("Steps:"+String.valueOf(steps));
    			 target.setText("Targets:"+String.valueOf(targets));
    			 GAme2 game2=new GAme2(steps,targets,"begin");
    			 panel2.removeAll();
    			 Runnable newrun=new Runnable(){
    				  public void run(){
    			 returnmessage=game2.playGame2(panel2, step, score,exit);
    				  }
    			  };
    			  Thread athread=new Thread(newrun);
    			  athread.start();
    			  try{
    				  athread.join();
    			  }catch(InterruptedException e){
    				  e.printStackTrace();
    			  }
    			  if(returnmessage.equals("win")){
     				 stages++;
     			     try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     			     
     				 toppanel.remove(mainpanel);
     				 //
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 //
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Pass6.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Pass6,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	
   		    	    JButton Bexit=new JButton();
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
		  		  Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Pass6);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Pass6.setLayout(null);
     		    	 Pass6.add(Bexit);
    		    	 Bexit.setBounds(670, 600, width2+100, height2+50);
     		    	 
     				    			 }
     			 else if(returnmessage.equals("dead")){
     				 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				 //
     				 toppanel.remove(mainpanel);
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Dead.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Dead,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bagain=new JButton();
   		    	 JButton Bexit=new JButton();
   		    	 Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bagain.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Dead);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Dead);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Dead.setLayout(null);
     		    	 Dead.add(Bagain);
     		    	 Dead.add(Bexit);
     		    	Bagain.setBounds(670, 400, width2+100, height2+50);
   		    	    Bexit.setBounds(670, 600, width2+100, height2+50);
     	 			 }
     			 else if(returnmessage.equals("lose")){
                      try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				toppanel.remove(mainpanel);
     		    	 firstframe.getLayeredPane().remove(backg);
     		    	 firstframe.setBounds(40, 40, width, height);
     		 		 Lose.setBounds(0,0,width,height);
     		    	 firstframe.getLayeredPane().add(Lose,new Integer(Integer.MIN_VALUE));
     		    	 firstframe.setVisible(true);
     		    	 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     		    	JButton Bagain=new JButton();
   		    	 JButton Bexit=new JButton();
   		    	Bagain.setIcon(againBU);
		    	 Bagain.setRolloverIcon(againBUrollover);
		    	 Bexit.setIcon(exitgameIcon);
		    	 Bexit.setRolloverIcon(exitgamerollover);
   		    	 Bagain.setOpaque(false);  
		  		 Bagain.setContentAreaFilled(false);  
		  		 Bagain.setMargin(new Insets(0, 0, 0, 0));  
		  		 Bagain.setFocusPainted(false);  
		  		 Bagain.setBorderPainted(false);  
		  		 Bagain.setBorder(null);  
		  		 Bexit.setOpaque(false);  
		  		  Bexit.setContentAreaFilled(false);  
		  		  Bexit.setMargin(new Insets(0, 0, 0, 0));  
		  		  Bexit.setFocusPainted(false);  
		  		  Bexit.setBorderPainted(false);  
		  		  Bexit.setBorder(null);  
     		    	 Bagain.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					  firstframe.getLayeredPane().remove(Lose);
     		     	    		     firstframe.setBounds(40, 40, width, height);
     		         		 		 backg.setBounds(0,0,width,height);
     		     	    		     firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
     		        	    		 firstframe.setVisible(true);
     		        	    		     //
     		  	    		         toppanel.add(mainpanel);
     		  	    		         panel2.removeAll();
     		         				 startgame(panel2,flowerpanel,exit);
     		    				 }
     		    			 });
     		    	 Bexit.addActionListener(
     		    			 new ActionListener(){
     		    				 public void actionPerformed(ActionEvent ex){
     		    					//exit
     		    					  /////////////////////////////////////////////////initial
     		     	    		     firstframe.getLayeredPane().remove(Lose);
     		        	    		 writeMode(String.valueOf(choice));
     		        	    		 writeStages(String.valueOf(stages));
     		        	    		 initial();
     		    				 }
     		    			 });
     		    	 Lose.setLayout(null);
     		    	 Lose.add(Bagain);
     		    	 Lose.add(Bexit);
     		    	Bagain.setBounds(670, 400, width2+100, height2+50);
   		    	    Bexit.setBounds(670, 600, width2+100, height2+50);
     			 }
     			 else if(returnmessage.equals("exit")){
     				 try{
     		    		 Thread.sleep(800);
     		    	 }catch(InterruptedException e){
     		    		 e.printStackTrace();
     		    	 }
     				toppanel.remove(mainpanel);
     				firstframe.getLayeredPane().remove(backg);
     				 writeMode(String.valueOf(choice));
     	    		 writeStages(String.valueOf(stages));
     	    		 initial();
     			
     			 }
     			 
    			 break;
    		 }
    		 } 
    	 }//GAme2
   		  }
    	 };
    	  Thread athread2=new Thread(run2);
    	  athread2.start();
     }
}
