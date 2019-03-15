package Sometesting;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Test {
	 static   JFrame aframe=new JFrame();
	  static JPanel toppanel=(JPanel)(aframe.getContentPane());
	  static JPanel mainpanel=new JPanel();
	  static JPanel flowerpanel=new JPanel();
	  
	 
	  static JTextField stage=new JTextField();
		static JTextField step=new JTextField();
		static JTextField score=new JTextField();
		static JTextField target=new JTextField();
		
		static JButton exit=new JButton("Exit");
		
		 static ImageIcon background=new ImageIcon("10.jpg");
	 static ImageIcon main=new ImageIcon("main.jpg");
	 static ImageIcon flower1=new ImageIcon("f02.gif");
	 
	  static JLabel mainlabel=new JLabel(main);
	  static JLabel backg=new JLabel(background);
	  static JLabel flowerlabel1=new JLabel(flower1);
	 
	  static  int width=main.getIconWidth();
	  static int height=main.getIconHeight();
	  static int stages=1;
		static int steps;
		static int targets;
		static int scores;
		static int choice;
		
		static String returnme;
	
		public static void main(String[] args){
			 aframe.setBounds(40,40,width,height);
			 mainlabel.setBounds(0,0,width,height);
			 C();
		}
		public static void  C(){
			
			toppanel.setOpaque(false);
			 aframe.getLayeredPane().add(mainlabel,new Integer(Integer.MIN_VALUE));
			  mainlabel.setVisible(true);
			  aframe.setVisible(true);
			  JButton button=new JButton();
			  mainlabel.add(button);
			  button.setBounds(40, 40, 50, 50);
			  button.addActionListener(
					  new ActionListener(){
						  public void actionPerformed(ActionEvent ex){
							  B();
						  }
					  }
					  );
			
		
		}
		public static void B(){
			  mainlabel.removeAll();
			  aframe.getLayeredPane().remove(mainlabel);
			  JPanel panel0=(JPanel)aframe.getContentPane();
		       panel0.setOpaque(false);
			  stages=1;
			  ////////////////////////////////////the first boundar
			  aframe.getLayeredPane().add(mainlabel,new Integer(Integer.MIN_VALUE));
			  mainlabel.setVisible(true);
			  aframe.setVisible(true);
			  try{
				  Thread.sleep(500);
			  }catch(InterruptedException e){
				  e.printStackTrace();
			  }
			  String[] choices={"Standard","Classic"};
			   choice=JOptionPane.showOptionDialog(mainlabel, "Which version do you want to choose?", "Version Choosing", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
			  //choice==0 means "Classic"   choice==1 means "Standard"
			
			 A();
		} 
		
  public static void A(){
	 
	 
	   mainlabel.removeAll();
		  mainlabel.setVisible(false);
		  aframe.getLayeredPane().remove(mainlabel);
	 
		 
 	  mainpanel.setLayout(null);  	  
 	  toppanel.setOpaque(false);
 	  mainpanel.setOpaque(false);
 	  toppanel.add(mainpanel);
 	  //we will add other components on the mainpanel
    	  backg.setBounds(0,0,width,height);
    	  aframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    	  
    	  mainpanel.setLayout(null);
    	  
 	 
 	  flowerpanel.setOpaque(false);
    
    	  
    	  JPanel panel1=new JPanel();
    	  panel1.setLayout(new GridLayout(4,1));
       
       Font fon=new Font("ËÎÌו",1,30);
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
		  target.setText("Target:"+String.valueOf(targets));
		  target.setOpaque(false);
		  target.setBorder(null);
		  panel1.add(stage);
		  panel1.add(target);
		  panel1.add(step);
		  panel1.add(score);
		  panel1.setOpaque(false);
		
		  JPanel panel2=new JPanel();
		  panel2.setOpaque(false);
		  
		 
		
		  exit.setBackground(Color.orange);
		 
		  mainpanel.add(panel1);
		  mainpanel.add(panel2);
		  mainpanel.add(flowerpanel);
		  mainpanel.add(exit);
		  panel1.setBounds(60+width/2, 100+height/2, width/2, height/3);
		  flowerpanel.setBounds(0,100+height/2,width/2,height/2);
		  panel2.setBounds(0, 0, width, height/2);
		  exit.setBounds(width-150, height-150, 100, 60);
		  aframe.setVisible(true);
   	      D(panel2);
  }
  public static void D(JPanel panel2){
	  Runnable run2=new Runnable(){
		  public void run(){
	  if(choice==0){
		 switch(stages){
		 case 1:{
			 flowerpanel.removeAll();
			  flowerpanel.add(flowerlabel1);
		  targets=10;
		  steps=10;
		  target.setText("Targets:"+String.valueOf(targets));
		  step.setText("steps:"+String.valueOf(steps));
		  TestGame test1=new TestGame(steps,targets,"begin");
		  System.out.println(Thread.currentThread().getName());
		  Runnable newrun=new Runnable(){
			  public void run(){
		  returnme=test1.playGame1(panel2, step, score, exit);
		  if(returnme.equals("exit")){
			  System.out.println("ok");
		  }
		 
		 			  }
		  };
		  Thread athread=new Thread(newrun);
		  athread.start();
		  try{
			  athread.join();
		  }catch(InterruptedException e){
			  e.printStackTrace();
		  }
		  break;
		 }
		
		 }
		 System.out.println("skjv");
		 }
		  }
  };
  Thread athread2=new Thread(run2);
  athread2.start();
 
  }
  }
