package Sometesting;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Refresh {
	public static int get(){
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		return 0;
	}
	public static void test(JButton[] buttons,ArrayList<Integer> places,ArrayList<Icon> images){
		Runnable runnable2=new Runnable(){
			 public void run(){
		System.out.println(Thread.currentThread().getName());
		  try {
				
				  Thread.sleep(1000);
				  } catch (InterruptedException e1) {
				  e1.printStackTrace();
				  }
		 SwingUtilities.invokeLater(new Runnable() {
			

			  @Override
			  public void run() {
				buttons[places.get(0)].setIcon(images.get(get()));
   		     	buttons[places.get(1)].setIcon(images.get(1));
			  }
			  });
		 

		 System.out.println("in this thread2");
	}
			 };
	  new Thread(runnable2).start();	
		}
	 static JFrame aframe=new JFrame();
     static int time=0;
	static int place;
	public static void main(String[] args){
         
          aframe.setBounds(0,0,400,400);
          JPanel apanel=new JPanel();
          aframe.add(apanel);
        
          JButton[] buttons=new JButton[2];
          ImageIcon image1=new ImageIcon("1.jpg");
          ImageIcon image2=new ImageIcon("2.jpg");
          ImageIcon[] image={image1,image2};
           ArrayList<Icon> images=new ArrayList<Icon>();
           ArrayList<Integer> places=new ArrayList<Integer>();
           for(int i=0;i<=1;i++){
        	   buttons[i]=new JButton();
        	   buttons[i].setBackground(Color.PINK);
               buttons[i].setIcon(image[i]);
               buttons[i].setActionCommand(String.valueOf(i));
               apanel.add(buttons[i]);
           
               buttons[i].addActionListener(new ActionListener(){
        	  public void actionPerformed(ActionEvent ex){
        		  place=Integer.parseInt(ex.getActionCommand());
        		  System.out.println(place);
        	      places.add(place);
           		  images.add(buttons[place].getIcon());
        		  if(places.size()>=2){
        			            
        			  Runnable runnable = new Runnable() {

        				 

        				  @Override
        				  public void run() {
        				   Thread.currentThread().setName("a");
        				  SwingUtilities.invokeLater(new Runnable() {

        				  @Override
        				  public void run() {
        						buttons[places.get(1)].setIcon(null);
		        		     	buttons[places.get(0)].setIcon(null);
        				  }
        				  });
        				 
        				  try {
              				
            				  Thread.sleep(1000);
            				  } catch (InterruptedException e1) {
            				  e1.printStackTrace();
            				  }
        				  SwingUtilities.invokeLater(new Runnable() {
        				  @Override
        				  public void run() {
      						buttons[places.get(1)].setIcon(images.get(get()));
		        		     	buttons[places.get(0)].setIcon(images.get(1));
      				  }
      				  });
        				

        				  test(buttons,places,images); 
      				  try {
            				
          				  Thread.sleep(1000);
          				  } catch (InterruptedException e1) {
          				  e1.printStackTrace();
          				  }
        				
        				  System.out.println("first");
        				  }
        				  
        				  };
        				  new Thread(runnable).start();
        				
            		
        		     System.out.println("ok");
        	  }
        		  
        	  }
        	  }
               
          );        	
         
  }
           aframe.setVisible(true);  
           }
	
               
           
	}


