package PCVersion;


	import java.applet.Applet;
import java.applet.AudioClip;

//2017.05.07 BeibeiZhang 
	//the other way of the game base on the NewCheck.java


	import java.awt.Color;
	import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

	public class GAme2 {
	 static int steps;
	 static int scores=0;
	 static int targets;
	 static String returnmessage; 
	 static ImageIcon[] icons=new ImageIcon[5];
	 static ImageIcon[] rollover=new ImageIcon[5];
	    public GAme2(int mainsteps,int maintargets,String begin){
	    	steps=mainsteps;
	    	targets=maintargets;
	    	returnmessage=begin;
	  
	    } 
	    static void playButtonsound(){
			 try{
					File backMusic=new File("buttonsound.wav");
					URI musicURI=backMusic.toURI();
					URL musicURL=musicURI.toURL();
				
					AudioClip backMusicPlayer=Applet.newAudioClip(musicURL);
					backMusicPlayer.play();
					 
				
				}catch(Exception ex){
					ex.printStackTrace();
				}
		 }
	    
		static Boolean isRightBound(int place){
			//use this func to judge the button is not at the four edges of the panel
			//or there will be no buttons[place+1] and the system will show the mistake 
			Boolean isright=false;
			int[] right={7,15,23,31,39,47,55,63};
			for(int Right:right){
				if(place==Right){
					isright=true;
				}
			}
			return isright;
		}
		
		
		 static Boolean isLeftBound(int place){
			Boolean isleft=false;
			int[] left={0,8,16,24,32,40,48,56};
			for(int Left:left){
				if(place==Left){
					isleft=true;
				}
			}
			return isleft;
		}
		
		
		 static Boolean isUpBound(int place){
			Boolean isup=false;
			int[] up={0,1,2,3,4,5,6,7};
			for(int Up:up){
				if(place==Up){
					isup=true;
				}
			}
			return isup;
		}
		
		
		static Boolean isDownBound(int place){
			Boolean isdown=false;
			int[] down={56,57,58,59,60,61,62,63};
			for(int Down:down){
				if(place==Down){
					isdown=true;
				}
			}
			return isdown;
		}
		 static void Findsamearound(int place,JButton[] buttons,ArrayList<Integer> places){
			 if(places.isEmpty()){
				 places.add(place);
				
			 }
			 else{
				 Boolean existed0=false;
	             for(int i=0;i<=(places.size()-1);i++){
	           
	              if(places.get(i)==(place)){
	            	  existed0=true;
	            	  
	            	  break;
	              }
		  }
	             if(existed0==false){
	            	 places.add(place);  
	            
	             }
	             else{
	            	 
	             } 
			 }
				        if(isRightBound(place)==false){
			                        if(buttons[place].getIcon().equals(buttons[place+1].getIcon())){
			                         Boolean existed=false;
			                         for(int i=0;i<=(places.size()-1);i++){
			        	              if(places.get(i).equals(place+1)){
			        	            	  existed=true;
			        	            	  break;
			        	              }
			           	  }
			                         if(existed==false){
			                        	 places.add(place+1);
				        	             Findsamearound(place+1,buttons,places);
			                         }
			                         else{
			                        	 
			                         }
			                         }
			              }
			       	   if(isLeftBound(place)==false){
					                if(buttons[place].getIcon().equals(buttons[place-1].getIcon())){
					                	   Boolean existed=false;
					                         for(int i=0;i<=(places.size()-1);i++){
					        	              if(places.get(i).equals(place-1)){
					        	            	  existed=true;
					        	            	  break;
					        	              }
					           	  }
					                         if(existed==false){
					                        	 places.add(place-1);
						        	             Findsamearound(place-1,buttons,places);
					                         }
					                         else{
					                        	 
					                         }
					                         }
					              }
			           if(isUpBound(place)==false){
					                 if(buttons[place].getIcon().equals(buttons[place-8].getIcon())){
					                	   Boolean existed=false;
					                         for(int i=0;i<=(places.size()-1);i++){
					        	              if(places.get(i).equals(place-8)){
					        	            	  existed=true;
					        	            	  break;
					        	              }
					           	  }
					                         if(existed==false){
					                        	 places.add(place-8);
						        	             Findsamearound(place-8,buttons,places);
					                         }
					                         else{
					                        	 
					                         }
					                         }
					             }
				       if(isDownBound(place)==false){
					                if(buttons[place].getIcon().equals(buttons[place+8].getIcon())){
					                	   Boolean existed=false;
					                         for(int i=0;i<=(places.size()-1);i++){
					        	              if(places.get(i).equals(place+8)){
					        	            	  existed=true;
					        	            	  break;
					        	              }
					           	  }
					                         if(existed==false){
					                        	 places.add(place+8);
						        	             Findsamearound(place+8,buttons,places);
					                         }
					                         else{
					                        	 
					                         }
					                         }
					            }
			            	 
				 }
		//use recursion function to constantly find the next same button
		//GOOD AND SIMPLE
		//it is the best way
		
		 
	     public static void GAME2(JPanel panel2,JTextField step,JTextField score,JButton exit,Object current){
	    	 icons[0]=new ImageIcon("icon1.jpg");
			  icons[1]=new ImageIcon("icon2.jpg");
			  icons[2]=new ImageIcon("icon3.jpg");
			  icons[3]=new ImageIcon("icon4.jpg");
			  icons[4]=new ImageIcon("icon5.jpg");
			  rollover[0]=new ImageIcon("icon1rollover.jpg");
			  rollover[1]=new ImageIcon("icon2rollover.jpg");
			  rollover[2]=new ImageIcon("icon3rollover.jpg");
			  rollover[3]=new ImageIcon("icon4rollover.jpg");
			  rollover[4]=new ImageIcon("icon5rollover.jpg");
	    	 
	   	     panel2.removeAll();
		  
	    	 scores=0;
			 score.setText("Scores:"+scores);
			
	    	 
	    	 panel2.setLayout(new GridLayout(8,8));
	    	 JButton[] buttons=new JButton[64];
	    	 for(int i=0;i<=63;i++){
	    		 int randomnumber=(int)(Math.random()*5+1);
	    		  buttons[i]=new JButton();
	    		  buttons[i].setActionCommand(String.valueOf(i));
	    		  buttons[i].setIcon(icons[randomnumber-1]);
	    		  buttons[i].setRolloverIcon(rollover[randomnumber-1]);
	    		  buttons[i].setOpaque(false);  
				  buttons[i].setContentAreaFilled(false);  
				  buttons[i].setMargin(new Insets(0, 0, 0, 0));  
				  buttons[i].setFocusPainted(false);  
				  buttons[i].setBorderPainted(false);  
				  buttons[i].setBorder(null);  
	    		  panel2.add(buttons[i]);
	    		
	    		  buttons[i].addActionListener(
	    				  new ActionListener(){
	    					  public void actionPerformed(ActionEvent ex){
	    						  Runnable buttonrun=new Runnable(){
	    							public void run(){  
	    						  
	    						 int place=Integer.parseInt(ex.getActionCommand());
	    						 Icon icon=buttons[place].getIcon();
	    						 ArrayList<Integer> sameLabelPlace=new ArrayList<Integer>();
	    						 sameLabelPlace.clear();
	    						 if(buttons[place].getIcon()==null){
	    							 
	    						 }
	    				      		else{
	    				      		  Findsamearound(place,buttons,sameLabelPlace);	
	    				      			}
	    				      		int length=sameLabelPlace.size();
	    				      		
	    				      		
	    				      		if(length>=3){
	    				      			playButtonsound();
	    				      		  SwingUtilities.invokeLater(new Runnable() {
	    		        				  @Override
	    		        				  public void run() {
	    				      			for(int n=0;n<=length-1;n++){
	    				      				
	    				      				buttons[sameLabelPlace.get(n)].setIcon(null);
	    				  	    		    buttons[sameLabelPlace.get(n)].setRolloverIcon(null);
	    				      			
	    				      			}
	    		        				  }
	    				      		  });
	    				      		   try{
   				      			    	Thread.sleep(800);
   				      			    }catch(InterruptedException exx){
   				      			    	exx.printStackTrace();
   				      			    }
	    				      		  SwingUtilities.invokeLater(new Runnable() {
	    		        				  @Override
	    		        				  public void run() {
	    				      		 for(int n=0;n<=length-1;n++){
	    				      				 int randomnumber=(int)(Math.random()*5+1);
	    				      				buttons[sameLabelPlace.get(n)].setIcon(icons[randomnumber-1]);
	    				  	    		    buttons[sameLabelPlace.get(n)].setRolloverIcon(rollover[randomnumber-1]);
	    				      			
	    				      			}
	    		        				  }
	    				      		  });
	    				      			scores=scores+length;
	    				      			steps=steps-1;
	    				      			score.setText("Scores:"+String.valueOf(scores));
	    				      			step.setText("Steps:"+String.valueOf(steps));
	    				      		}
	    				      		else{
	    				            		}
	    				      		if(steps!=0){
	    				      			if(scores>=targets){
	    				      				returnmessage="win";
	    				      			  synchronized(current) {
		    		   		      			  
		    		 		      				current.notify();
		    		 		      				
		    		 		      				
		    		 		      				}
	    				      			}
	    				      			else{
	    				      				if(Mycheck2(buttons)){
	   				      		    		
	   				      		    	 }
	   				      		    	    else{
	   				      		    		returnmessage="dead";
	   				      		    	  synchronized(current) {
		    		   		      			  
		    		 		      				current.notify();
		    		 		      				
		    		 		      				
		    		 		      				}
	   				      		    	 }  
	    				      			}
	    				      		}
	    				      		else{
	    				      			if(scores>=targets){
	    				      				returnmessage="win";
	    				      			  synchronized(current) {
		    		   		      			  
		    		 		      				current.notify();
		    		 		      				
		    		 		      				
		    		 		      				}
	    				      			}
	    				      			else{
	    				      				returnmessage="lose";
	    				      			  synchronized(current) {
		    		   		      			  
		    		 		      				current.notify();
		    		 		      				
		    		 		      				
		    		 		      				}
	    				      			}
	    				      		}
	    				      		
	    							}
	    						  };
	    						  new Thread(buttonrun).start();
	    					  }
	    				  }
	    				  );
	    		  
	    				  
	    	 }
	    		panel2.updateUI();
	    	 if(returnmessage.equals("begin")){
	    		
	    	 if(Mycheck2(buttons)){
	    		  
	    		  JOptionPane.showMessageDialog(panel2,"We can go on~"); 
	    	 }
	    	 else{
	    		returnmessage="dead";
	    		
	    		  synchronized(current) {
		      			  
	      				current.notify();
	      				
	      				
	      				}
	    	 }
	    	 }
	    
	     }
	     ////////////////////////////////////////////////////////////////////
	     //check if game2 is dead
	     //////////////////////////////////////////////////////////////////////
	
	 public  static Boolean Mycheck2(JButton[] buttons){
	    	  Boolean candelete=false;
	      	  int index=0;
	      	  ArrayList<Integer> sameLabelPlace=new ArrayList<Integer>();
	      	  sameLabelPlace.clear();
	      	  for(index=0;index<=63;index++){
	      		sameLabelPlace.clear();
	      		if((buttons[index].getIcon()==null)){
	      			//use "==" not ".equals()"
	      		continue;	
	      		}
	      		else{
	      		  Findsamearound(index,buttons,sameLabelPlace);	
	      			}
	      		int length=sameLabelPlace.size();
	      		if(length>=3){
	      			 candelete=true;
	      		
	      			 return candelete;
	      		}
	      		else{
	            		}
	      	  }
	      	return candelete;
	      	
	     } 
	 ///////////////////////////////////////////////////////////////
	 //play game2
     ///////////////////////////////////////////////////////////////	
	 public static String playGame2(JPanel panel2,JTextField step,JTextField score,JButton exit){
	
		 Object current=new Object();
		 if(returnmessage.equals("begin")){
			 exit.addActionListener(
					 new ActionListener(){
						 public void actionPerformed(ActionEvent ex){
							 returnmessage="exit";
							 synchronized(current) {
	      		      			  
	    		      				current.notify();
	    		      				
	    		      				
	    		      				}
							 
							 
						 }
					 }
					 );
			 GAME2(panel2,step,score,exit,current);
		 }
		  synchronized(current) {
			  
			  try{
					 while(returnmessage.equals("begin")){
						 current.wait();
					 }
				  }catch(InterruptedException ex){
					  ex.printStackTrace();
				  }
					
					
					}
		 return returnmessage;
	 }
	 
	}


