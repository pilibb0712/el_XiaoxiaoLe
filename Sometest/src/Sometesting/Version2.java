package Sometesting;
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
		public class Version2 {
			private static int steps;
			private static int scores;
			private static int targets;
		
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
		
			
			public static int doublesame(Button[] buttons,String label,int place,int samenumber){
		    int number2=0;
		    //number2 presents how many the same neighbors of buttons[place]
		    Boolean markleft=false;
		      //if the left label is the same with this label then the markleft is true
		      Boolean markright=false;
		      Boolean markup=false;
		      Boolean markdown=false;
		      //save the label of buttons[place1] in case buttons[label].setLabel() make difference to the later operation 
		      if(noRight(place)==false){
		      if(label.equals(buttons[place+1].getLabel())){
		    	  samenumber++;
		    	  number2++;
		    	  markright=true;
		      }
		      }
		      if(noLeft(place)==false){
		    	  if(label.equals(buttons[place-1].getLabel())){
		    	  samenumber++;
		    	  number2++;
		    	  markleft=true;
		      }
		    	  }
		      if(noDown(place)==false){
		      if(label.equals(buttons[place+8].getLabel())){
		    	  samenumber++;
		    	  number2++;
		    	  markdown=true;
		      }
		      }
		      if(noUp(place)==false){
		      if(label.equals(buttons[place-8].getLabel())){
		    	  samenumber++;
		    	  number2++;
		    	  markup=true;
		      }
		      }
		      //if number2 is 1, we do nothing, it means none of the three neighbors of buttons[place] (except buttons[i])
		      //are the same with label
		      if(number2>=2){
		    	  if(markright){
			    	  buttons[place].setLabel(" ");
			    	  buttons[place+1].setLabel(" ");
			    	  //because we have use String 'label' to save/present the buttons[i].label
			    	  //this setlabel() will make no difference
			   	    	  }
		    	  if(markleft){
		    		  buttons[place].setLabel(" ");
			    	  buttons[place-1].setLabel(" ");
		  }
		    	  if(markup){
			    	  buttons[place].setLabel(" ");
			    	  buttons[place-8].setLabel(" ");
			   }  
		    	  if(markdown){
	  	    	  buttons[place].setLabel(" ");
		    	  buttons[place+8].setLabel(" ");
		    		  }
		      }
		      return (samenumber-1);
		      //because in the four neighbors of buttons[place], there must is a same neighbor that is buttons[i]
		      //because of this, we make a repetition(ÖØ¸´)
		}
	
		
			public static Boolean twiceclickdelete(Button[] buttons,JTextField score,int place1,int place2){
				//if there are three or more than three same labels that are connected then delete them by if nesting(Ç¶Ì×)
			    Boolean deleted=false;
				int[] places={place1,place2};
				int deletenumber=0;
				for(int i:places){
			      int samenumber=1;
			      //record the number of the same neighbors with label place1 (containing buttons[i])
			      Boolean markleft=false;
			      //if the left label is the same with this label then the markleft is true
			      Boolean markright=false;
			      Boolean markup=false;
			      Boolean markdown=false;
			      String label=buttons[i].getLabel();
			      //save the label of buttons[place1] in case buttons[label].setLabel() make difference to the later operation 
			      if(noRight(i)==false){
			      if(label.equals(buttons[i+1].getLabel())){
			    	  samenumber++;
			    	  markright=true;
			    	
			      }
			      }
			      if(noLeft(i)==false){
			      if(label.equals(buttons[i-1].getLabel())){
			    	  samenumber++;
			    	  markleft=true;
			      }
			      }
			      if(noDown(i)==false){
			      if(label.equals(buttons[i+8].getLabel())){
			    	  samenumber++;
			    	  markdown=true;
			      }
			      }
			      if(noUp(i)==false){
			      if(label.equals(buttons[i-8].getLabel())){
			    	  samenumber++;
			    	  markup=true;
			      }
			      }
			      if(samenumber>=3){
			    	  //if there have been three or more three same neighbors 
			    	  //we can delete them now in case there are no same labels in the next if(samenumber>=2)
			    	  //because we have save label, so this setlabel() will make no difference
			    	  if(markleft){
				    	  int left=i-1;
		    		      samenumber=doublesame(buttons,label,left,samenumber);
		    	    	  buttons[left].setLabel(" ");
		    	    	  buttons[i].setLabel(label);
		    	    	  //in the doublesame function, the buttons[i].label will be 
		    	    	  //set " " and this will affect the following doublesame()
		    	    	  //make the number2 in doublesame() can never be more than 1
		    	    	  //but when there are 5 same buttons and the button[i] is in the middle
		    	    	  //it will make mistake
		    	    	    	  }
			    	  if(markright){
				    	  int right=i+1;
		    		      samenumber=doublesame(buttons,label,right,samenumber);
		    		      buttons[right].setLabel(" ");
		    		      buttons[i].setLabel(label);
		    		 
		    		      }
			    	  if(markdown){
				    	  int down=i+8;
				    	  samenumber=doublesame(buttons,label,down,samenumber);
				    	  buttons[down].setLabel(" ");
				    	  buttons[i].setLabel(label);
				    	  }
			    	  if(markup){
				    	  int up=i-8;
				          samenumber=doublesame(buttons,label,up,samenumber);
				          buttons[up].setLabel(" ");
				          buttons[i].setLabel(label);
			    	  }
			    	
			      }
			   else if(samenumber>=2){
				    	if(markright){
			    		      int right2=i+1;
			    		      samenumber=doublesame(buttons,label,right2,samenumber);
			    	  }
			    	if(markleft){
			    		 int left2=i-1;
		    		      samenumber=doublesame(buttons,label,left2,samenumber);
		   		    	  }
			    	if(markdown){
			    		int down2=i+8;
			    		 samenumber=doublesame(buttons,label,down2,samenumber);
			    	}
			    	if(markup){
			    		int up2=i-8;
			    		 samenumber=doublesame(buttons,label,up2,samenumber);
			    	}
			   	   			      }//there is no next same neighbor 
			      //because we go through all the labels and delete the same three(or more) after every operation
			      //it is impossible to find the next same neighbor of (the neighbor of (the neighbor of buttons[i] 
			      //or this neighbor and the neighbor of (the neighbor of buttons[i] and the neighbor of buttons[i]
			      //will be three same labels which should be deleted when we go through all the labels
			    if(samenumber>=3){
			    	 buttons[i].setLabel(" ");
			  		 deleted=true;
			  	 }	
			  
				}//for(int i:places){
				 try{ Thread.sleep(1000);
				  }catch(InterruptedException e){
					  e.printStackTrace();
				  }//in this place, we need to stop for 0.8s, or the code runs too fast, you will not see
				  //the elimination(Ïû³ý) of the labels
				for(int index=0;index<=63;index++){
					if(buttons[index].getLabel().equals(" ")){
						 int randomnumber=(int)(Math.random()*5+1);
						 String Label=String.valueOf(randomnumber);
						 buttons[index].setLabel(Label);
						 deletenumber++;
													}
					//reset the labels which were deleted before
				}
				scores=scores+deletenumber;		
				score.setText("Scores:"+String.valueOf(scores));
				return deleted;
				}
		
			
			public static void main(String[] args){
			  steps=10;
			  scores=0;
			  targets=50;
			
			  JFrame firstframe=new JFrame();
			//In JFrame, we can close the window easily by click the "¡Á"
			//But in Frame, we need to use WindowListener and then clicking the "¡Á" can make difference
			  firstframe.setTitle("BeibeiÀÖ 2.0");
			  firstframe.setBackground(Color.blue);
			  firstframe.setBounds(200, 200, 800, 1000);
			  Box myfirstBox=new Box(BoxLayout.Y_AXIS);
			  myfirstBox.setSize(800, 1000);
			  firstframe.add(myfirstBox);
			  Font fon=new Font("ËÎÌå",1,30);
			  JTextField step=new JTextField();
			  step.setFont(fon);
			  step.setText("Steps:"+String.valueOf(steps));
			  step.setBackground(Color.green);
			  JTextField score=new JTextField();
			  score.setFont(fon);
			  score.setText("Scores:"+String.valueOf(scores));
			  score.setBackground(Color.green);
			  JTextArea target=new JTextArea();
			  target.setFont(fon);
			  target.setText("\r\n\r\n\r\n\r\n\r\nTarget scores:\r\n"+String.valueOf(targets));
			  target.setBackground(Color.green);
			  JPanel firstJpanel=new JPanel();
			  JPanel panel2=new JPanel();
			  panel2.setSize(800,200);
			  panel2.setLayout(new GridLayout(1,3));
			  panel2.add(target);
			  panel2.add(step);
			  panel2.add(score);
			  firstJpanel.setSize(800, 800);
			  firstJpanel.setLayout(new GridLayout(8,8));
			  myfirstBox.add(panel2);
			  myfirstBox.add(firstJpanel);
			  Button[] buttons=new Button[64];
			  ArrayList<String> label=new ArrayList<String>();
			  ArrayList<String> place=new ArrayList<String>();
			  for(int index=0;index<=63;index++){
				  String number=String.valueOf(index);
				  //number is equal to index, they are the index of the buttons[]
				  int randomnumber=(int)(Math.random()*5+1);
				  buttons[index]=new Button();
				  buttons[index].setBackground(Color.PINK);
				  buttons[index].setName(number);
				  buttons[index].setLabel(String.valueOf(randomnumber));
				  buttons[index].setFont(fon);
				  buttons[index].setSize(100,100);
				  String labels=buttons[index].getLabel(); //just change the labels of the button which shows outside
				  String places=buttons[index].getName();//never change the name of the button because it represents the button's place
				  firstJpanel.add(buttons[index]);
				  buttons[index].addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent ex){
						 place.add(places);//places will not changed because when we click, it represents the buttonName which will 
						 //never be changed 
						 //and also because the places has been initialized in line 66 and will not change in the Listener function
						 //I don't know why
						 //but because of this the button Name never changing will have no effects
						 //however, this means we need to change labels to synchronize it with the update one because we 
						 //set new labels in line79 and line80
		    			  if(place.size()>1){
		    				  Boolean neighbor=ifneighbor(Integer.parseInt(place.get(0)),Integer.parseInt(place.get(1)));
		    				  if(neighbor==true){
		    				  label.add(buttons[Integer.parseInt(place.get(1))].getLabel());
		    				  buttons[Integer.parseInt(place.get(0))].setLabel(label.get(1));
		    				  buttons[Integer.parseInt(place.get(1))].setLabel(label.get(0));
		    				  try{ Thread.sleep(1000);
		    				  }catch(InterruptedException e){
		    					  e.printStackTrace();
		    				  }//in this place, we need to stop for 0.8s, or the code runs too fast, you will not see
		    				  //the exchange of the two buttons
		    				  Boolean deleted=twiceclickdelete(buttons,score,Integer.parseInt(place.get(0)),Integer.parseInt(place.get(1)));
		    				  if(deleted==false){
		    					  buttons[Integer.parseInt(place.get(0))].setLabel(label.get(0));
			    				  buttons[Integer.parseInt(place.get(1))].setLabel(label.get(1));  
			    				  //do not go through all the labels and delete
		    				  }
		    				  else{
		    					  steps=steps-1;
		    					  step.setText("Steps:"+String.valueOf(steps));
		    					  try{ Thread.sleep(1000);
			    				  }catch(InterruptedException e){
			    					  e.printStackTrace();
			    				  }
		    					  if(steps!=0){
		    						  if(scores>=targets){
		  		    							  System.out.println("Win!");
		  		    							  System.exit(0);
		    						  }
		    						  //more scores will be recorded in the next round
		    						 
		    					  }
		    					  else{
		    						  if(scores>=targets){
		    							  System.out.println("Win!");
		    						  }
		    						  else{
		    							  System.out.println("Lose~");
		    						  }
		    						System.exit(0);
		    						//exit(0) means exit the procedures commonly
		    						//exit(1) means exit the procedures uncommonly
		    					  }  
		    					  				  
		    				  }
		 	   				  label.clear();
		    				  place.clear();}
		    				  else{
		    					  String middlename=place.get(1);
		    		       		  place.clear();
		    					  place.add(middlename);
		    					  String middlelabel=buttons[Integer.parseInt(place.get(0))].getLabel();
		    					  label.clear();
		    					  label.add(middlelabel);
			    				  //if click two buttons that are not neighbors, it makes no use
			    				  //until the user click two neighbors continuously, it can make the exchange 
		    				  }
		    				 	    			  }
		    			  else{ 
		    				  label.add(buttons[Integer.parseInt(place.get(0))].getLabel());
		    						    			  }
						
					  }
				  });
			  }
		
			  firstframe.setVisible(true);
			 
			   }
		  
		}
		  



