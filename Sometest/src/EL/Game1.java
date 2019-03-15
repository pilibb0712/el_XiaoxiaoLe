package EL;
//2017.04.09 2017.04.11 2017.04.12 2017.04.13  2017.04.24 2017.04.25
//BeibeiZhang
//version1.KetyCalculation:demo of 4*4 and delete three labels
//version2. 8*8 formal version
//to prove:1 delete all the connected labels (at most 5)
//2 limit the exchange:only in the case that two continuous clicked buttons are neighbors that can do the exchange
//3 remove the part that if when there are 3 or more than 3 labels are the same, users can delete them by one click
//4 add txt window that record the foots and the target scores 
//6 change the layout by box 
//7 set the size of the txt and labels bt setfont()
//8 when we get the goal, then exit the procedure

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;

	import java.util.ArrayList;

		import javax.swing.*;
		public class Game1 {
			private static int steps;
			private static int scores;
			private static int targets;
			public static ImageIcon[] icons=new ImageIcon[5];
			private static int inDex;
		
			//private variables can be used in the whole class 
			//so we can use them in listener
			//but local variable can only be used in the function
			//and if we want to use them in main 
			//they need to be static
			public static Boolean noRight(int place){
				//use this func to judge the button is not at the four edges of the panel
				//or there will be no buttons[place+1] and the system will show the mistake 
				Boolean noright=false;
				int[] right={7,15,23,31,39,47,55,63};
				for(int Right:right){
					if(place==Right){
						noright=true;
					}
				}
				return noright;
			}
			
			
			public static Boolean noLeft(int place){
				Boolean noleft=false;
				int[] left={0,8,16,24,32,40,48,56};
				for(int Left:left){
					if(place==Left){
						noleft=true;
					}
				}
				return noleft;
			}
			
			
			public static Boolean noUp(int place){
				Boolean noup=false;
				int[] up={0,1,2,3,4,5,6,7};
				for(int Up:up){
					if(place==Up){
						noup=true;
					}
				}
				return noup;
			}
			
			
			public static Boolean noDown(int place){
				Boolean nodown=false;
				int[] down={56,57,58,59,60,61,62,63};
				for(int Down:down){
					if(place==Down){
						nodown=true;
					}
				}
				return nodown;
			}
			
			
			public static Boolean ifneighbor(int place1,int place2){
				Boolean neighbor=false;
				if((place1==place2-1)||(place1==place2+1)||(place1==place2-8)||(place1==place2+8)){
					neighbor=true;
				}
				return neighbor;
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
					        if(noRight(place)==false){
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
				       	   if(noLeft(place)==false){
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
				           if(noUp(place)==false){
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
					       if(noDown(place)==false){
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
	
		
			public static Boolean twiceclickdelete(JButton[] buttons,JTextField score,int place1,int place2){
				//if there are three or more than three same labels that are connected then delete them by if nesting(Ç¶Ì×)
			    Boolean deleted=false;
				int[] places={place1,place2};
								for(int i:places){
					
	     			 ArrayList<Integer> sameLabelPlace=new ArrayList<Integer>();
					 sameLabelPlace.clear();
                     Findsamearound(i,buttons,sameLabelPlace);	
                     int length=sameLabelPlace.size();
                     if(length>=3){
			      			for(int n=0;n<=length-1;n++){
			      				buttons[sameLabelPlace.get(n)].setIcon(null);
			      			
			      			}
			      			deleted=true;
			      		}
			      		else{
			            		}
			   
			  
				}//for(int i:places){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException ecx){
					ecx.printStackTrace();
				}
	             //in this place, we need to stop for 0.8s, or the code runs too fast, you will not see
				  //the elimination(Ïû³ý) of the labels
				int deletenumber=0;
				for(int index2=0;index2<=63;index2++){
					if(buttons[index2].getIcon()==null){
						 int randomnumber=(int)(Math.random()*5+1);
						 Icon Label=icons[randomnumber-1];
					     buttons[index2].setIcon(Label);	
         					 deletenumber++;
													}
					//reset the labels which were deleted before
				}

				try{
					Thread.sleep(1000);
				}catch(InterruptedException ecx){
					ecx.printStackTrace();
				}
				scores=scores+deletenumber;	
				SwingUtilities.invokeLater(new Runnable(){
					@Override
					public void run(){
						score.setText("Scores:"+String.valueOf(scores));
					}
				});
			
				return deleted;
				}
				
		
			
			public static void main(String[] args){
				  ImageIcon background=new ImageIcon("10.jpg");
		    	  JLabel backg=new JLabel(background);
		    	  int width=background.getIconWidth();
		    	  int height=background.getIconHeight();
		    	  JFrame firstframe=new JFrame();
				  firstframe.setTitle("BeibeiÀÖ 2.0");
		    	  firstframe.setBounds(0,0,width,height);
		    	
		    	  backg.setBounds(0,0,width,height);
				
				FormerComic formercom=new FormerComic();
			  formercom.comic(firstframe);
			  Pass passed=new Pass();
			  steps=10;
			  scores=0;
			  targets=20;
			  icons[0]=new ImageIcon("1.jpg");
			  icons[1]=new ImageIcon("2.jpg");
			  icons[2]=new ImageIcon("3.jpg");
			  icons[3]=new ImageIcon("4.jpg");
			  icons[4]=new ImageIcon("5.jpg");
		
	    	  firstframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
	    	  JPanel toppanel=(JPanel)(firstframe.getContentPane());
	    	  JPanel mainpanel=new JPanel();
	    	  mainpanel.setLayout(new GridLayout(2,1));  	  
	    	  toppanel.setOpaque(false);
	    	  mainpanel.setOpaque(false);
	    	  toppanel.add(mainpanel);
	    	  JPanel panel1=new JPanel();
	    	  JPanel panel2=new JPanel();
	    	  panel1.setLayout(new GridLayout(1,3));
			  panel2.setLayout(new GridLayout(8,8));
			  NewCheck myche=new NewCheck();
			  Death judgeDeath=new Death();
			
			//In JFrame, we can close the window easily by click the "¡Á"
			//But in Frame, we need to use WindowListener and then clicking the "¡Á" can make difference

			  Font fon=new Font("ËÎÌå",1,30);
			  JTextField step=new JTextField();
			  step.setFont(fon);
			  step.setText("Steps:"+String.valueOf(steps));
			  step.setOpaque(false);
			  JTextField score=new JTextField();
			  score.setFont(fon);
			  score.setText("Scores:"+String.valueOf(scores));
			  score.setOpaque(false);
			  JTextArea target=new JTextArea();
			  target.setFont(fon);
			  target.setText("\n\n\n\n\n\n\nTarget\nscores:"+String.valueOf(targets));
			  target.setOpaque(false);
			  panel1.add(target);
			  panel1.add(step);
			  panel1.add(score);
			  panel1.setOpaque(false);
			  panel2.setOpaque(false);
			  mainpanel.add(panel1);
			  mainpanel.add(panel2);
			  firstframe.setVisible(true);
			  JButton[] buttons=new JButton[64];
			  ArrayList<Icon> label=new ArrayList<Icon>();
			  ArrayList<Integer> place=new ArrayList<Integer>();
			  for(int index=0;index<=63;index++){
				  int randomnumber=(int)(Math.random()*5+1);
				  buttons[index]=new JButton();
				  buttons[index].setActionCommand(String.valueOf(index));
				  buttons[index].setBackground(Color.orange);
				  buttons[index].setIcon(icons[randomnumber-1]);
				  panel2.add(buttons[index]);
				  buttons[index].addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent ex){
						  Runnable runnable = new Runnable() {
							 
	        				  @Override
	        				  public void run() {
	        					  inDex=Integer.parseInt(ex.getActionCommand());
									 place.add(inDex);
					    			  if(place.size()>1){
					    				  Boolean neighbor=ifneighbor(place.get(0),place.get(1));
					    				  if(neighbor==true){
					    				  label.add(buttons[place.get(1)].getIcon());
			        			
	        				  SwingUtilities.invokeLater(new Runnable() {

	        				  @Override
	        				  public void run() {
	        					  buttons[place.get(0)].setIcon(label.get(1));
			    				  buttons[place.get(1)].setIcon(label.get(0));
			    	
	        				  }
	        				  });
	        				  //if the things we do is about GUI, then we should put these things 
	        				  //on the GUI thread
	        				  //and do other things on the other thread
	        				  try {
	              				
	            				  Thread.sleep(800);
	            				  } catch (InterruptedException e1) {
	            				  e1.printStackTrace();
	            				  }
	        				  //in this place, we need to stop for 0.8s, or the code runs too fast, you will not see
		    				  //the exchange of the two buttons
	        				  Boolean deleted=twiceclickdelete(buttons,score,place.get(0),place.get(1));
		    				    if(deleted==false){
		    					
			    				  //do not go through all the labels and delete
	        				  SwingUtilities.invokeLater(new Runnable() {
	        				  @Override
	        				  public void run() {
	        					   System.out.println(Thread.currentThread().getName()); 
	        					  buttons[place.get(0)].setIcon(label.get(0));
			    				  buttons[place.get(1)].setIcon(label.get(1)); 
			    				  label.clear();
			    				  place.clear();

	      				  }
	      				  });
		    					  }
		    				    else{
			    					  steps=steps-1;
			    					  SwingUtilities.invokeLater(new Runnable() {

			            				  @Override
			            				  public void run() {
			            					  step.setText("Steps:"+String.valueOf(steps));	
			            				  }
			            				  });
			    					  if(steps!=0){
			    						  if(scores>=targets){
			    							        
			    							  SwingUtilities.invokeLater(new Runnable() {

			    	            				  @Override
			    	            				  public void run() {
			    	            					  mainpanel.setVisible(false);
			    							         
			  		    							
			    	            				  }
			    	            				  });  
			    							 
			    						  }
			    						  //more scores will be recorded in the next round
			    						  else{
			    							  myche.myCheck(buttons,icons); 
					    					  //go through all the labels and delete	
					    					  if(judgeDeath.notDie(buttons)){
					    						 // JOptionPane.showMessageDialog(firstframe,"We can go on~"); 
					    					  }
					    					  else{
					    						  JOptionPane.showMessageDialog(firstframe,"Because of your personality, the game is dead."); 
					    							
					    					  }
					    					  label.clear();
						    				  place.clear();

					    					//check if the game has dead and the player can not go on 
			    						  }
			    						 
			    					  }
			    					  else{
			    						  if(scores>=targets){
			    							  SwingUtilities.invokeLater(new Runnable() {

			    	            				  @Override
			    	            				  public void run() {
			    	            					 mainpanel.setVisible(false);
					    							 
					    							
			    	            				  }
			    	            				  });
			    							////////////////////////////////////////////
			    						  }
			    						  else{
			    							  JOptionPane.showMessageDialog(firstframe,"Lose~"); 
			    						  }
			    						
			    						//exit(0) means exit the procedures commonly
			    						//exit(1) means exit the procedures uncommonly
			    					  }
			    					 		  
			    				  }//if(deleted==true)
                            }//if(neighbor==true)
			    				  else{
			    					  int middle=place.get(1);
			    		       		  place.clear();
			    					  place.add(middle);
			    					  Icon middleicon=buttons[place.get(0)].getIcon();
			    					  label.clear();
			    					  label.add(middleicon);
				    				  //if click two buttons that are not neighbors, it makes no use
				    				  //until the user click two neighbors continuously, it can make the exchange 
			    				  }
			    				 	    			  }//if(neighbor==false)
			    			  else{ 
			    				  label.add(buttons[place.get(0)].getIcon());
			    						    			  }//if(place.size()<=1)
	      			
	        				
	        				  
	        				  }
	        				  
	        				  };
	        				  new Thread(runnable).start();
	  				  }
				  });
			  }
			  myche.myCheck(buttons,icons);
			  if(scores==3){
				  System.exit(0);
			  }
			  if(judgeDeath.notDie(buttons)){
				  JOptionPane.showMessageDialog(firstframe,"We can go on~"); 
				
			  }
			  else{
				
				  JOptionPane.showMessageDialog(firstframe,"Because of your personality, the game is dead."); 
				  System.exit(0);
			  }
			//check if the game has dead and the player can not go on 
			
		
			   }
		  
		}
		  



