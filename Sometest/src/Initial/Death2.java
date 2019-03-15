//2017.04.30 BeibeiZhang
//a procedure to check if the game cannot go on
//It can use the functions in xiaoxiaole 
package Initial;

import java.awt.Button;

import javax.swing.JTextField;

public class Death2 {
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
	
	
	public static Boolean notDie(Button[] buttons){
		Button[] newbuttons=new Button[64];
		for(int j=0;j<=63;j++){
			newbuttons[j]=new Button();
			newbuttons[j].setLabel(buttons[j].getLabel());
		}
		Boolean ifdelete=false;
		for(int k=0;k<=63;k++){
			String center=newbuttons[k].getLabel();
			if(isRightBound(k)==false){
				String right=newbuttons[k+1].getLabel();
				newbuttons[k].setLabel(right);
				newbuttons[k+1].setLabel(center);
				ifdelete=exchangeDelete(newbuttons,k,k+1);
				if(ifdelete){
					return ifdelete;
				}
				else{
					newbuttons[k].setLabel(center);
					newbuttons[k+1].setLabel(right);
				}
			}
            if(isLeftBound(k)==false){
            	String left=newbuttons[k-1].getLabel();
				newbuttons[k].setLabel(left);
				newbuttons[k-1].setLabel(center);
				ifdelete=exchangeDelete(newbuttons,k,k-1);
				if(ifdelete){
					return ifdelete;
				}
				else{
					newbuttons[k].setLabel(center);
					newbuttons[k-1].setLabel(left);
				}
				
			}
            if(isDownBound(k)==false){
            	String down=newbuttons[k+8].getLabel();
				newbuttons[k].setLabel(down);
				newbuttons[k+8].setLabel(center);
				ifdelete=exchangeDelete(newbuttons,k,k+8);
				if(ifdelete){
					return ifdelete;
				}
				else{
					newbuttons[k].setLabel(center);
					newbuttons[k+8].setLabel(down);
				}
	
            }
            if(isUpBound(k)==false){
            	String up=newbuttons[k-8].getLabel();
				newbuttons[k].setLabel(up);
				newbuttons[k-8].setLabel(center);
				ifdelete=exchangeDelete(newbuttons,k,k-8);
				if(ifdelete){
					return ifdelete;
				}
				else{
					newbuttons[k].setLabel(center);
					newbuttons[k-8].setLabel(up);
				}
	
            }
		}
		return ifdelete;
	} 
	public static int DoubleSame(Button[] buttons,String label,int place,int samenumber){
	    int number2=0;
	    //number2 presents how many the same neighbors of buttons[place]
	    Boolean markleft=false;
	      //if the left label is the same with this label then the markleft is true
	      Boolean markright=false;
	      Boolean markup=false;
	      Boolean markdown=false;
	      //save the label of buttons[place1] in case buttons[label].setLabel() make difference to the later operation 
	      if(isRightBound(place)==false){
	      if(label.equals(buttons[place+1].getLabel())){
	    	  samenumber++;
	    	  number2++;
	    	  markright=true;
	      }
	      }
	      if(isLeftBound(place)==false){
	    	  if(label.equals(buttons[place-1].getLabel())){
	    	  samenumber++;
	    	  number2++;
	    	  markleft=true;
	      }
	    	  }
	      if(isDownBound(place)==false){
	      if(label.equals(buttons[place+8].getLabel())){
	    	  samenumber++;
	    	  number2++;
	    	  markdown=true;
	      }
	      }
	      if(isUpBound(place)==false){
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

	
		public static Boolean exchangeDelete(Button[] buttons,int place1,int place2){
			//if there are three or more than three same labels that are connected then delete them by if nesting(Ç¶Ì×)
		    Boolean deleted=false;
			int[] places={place1,place2};
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
		      if(isRightBound(i)==false){
		      if(label.equals(buttons[i+1].getLabel())){
		    	  samenumber++;
		    	  markright=true;
		    	
		      }
		      }
		      if(isLeftBound(i)==false){
		      if(label.equals(buttons[i-1].getLabel())){
		    	  samenumber++;
		    	  markleft=true;
		      }
		      }
		      if(isDownBound(i)==false){
		      if(label.equals(buttons[i+8].getLabel())){
		    	  samenumber++;
		    	  markdown=true;
		      }
		      }
		      if(isUpBound(i)==false){
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
	    		      samenumber=DoubleSame(buttons,label,left,samenumber);
	    	    	  buttons[left].setLabel(" ");
	    	    	  buttons[i].setLabel(label);
	    	    	  //in the DoubleSame function, the buttons[i].label will be 
	    	    	  //set " " and this will affect the following DoubleSame()
	    	    	  //make the number2 in DoubleSame() can never be more than 1
	    	    	  //but when there are 5 same buttons and the button[i] is in the middle
	    	    	  //it will make mistake
	    	    	    	  }
		    	  if(markright){
			    	  int right=i+1;
	    		      samenumber=DoubleSame(buttons,label,right,samenumber);
	    		      buttons[right].setLabel(" ");
	    		      buttons[i].setLabel(label);
	    		 
	    		      }
		    	  if(markdown){
			    	  int down=i+8;
			    	  samenumber=DoubleSame(buttons,label,down,samenumber);
			    	  buttons[down].setLabel(" ");
			    	  buttons[i].setLabel(label);
			    	  }
		    	  if(markup){
			    	  int up=i-8;
			          samenumber=DoubleSame(buttons,label,up,samenumber);
			          buttons[up].setLabel(" ");
			          buttons[i].setLabel(label);
		    	  }
		    	
		      }
		   else if(samenumber>=2){
			    	if(markright){
		    		      int right2=i+1;
		    		      samenumber=DoubleSame(buttons,label,right2,samenumber);
		    	  }
		    	if(markleft){
		    		 int left2=i-1;
	    		      samenumber=DoubleSame(buttons,label,left2,samenumber);
	   		    	  }
		    	if(markdown){
		    		int down2=i+8;
		    		 samenumber=DoubleSame(buttons,label,down2,samenumber);
		    	}
		    	if(markup){
		    		int up2=i-8;
		    		 samenumber=DoubleSame(buttons,label,up2,samenumber);
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
			
			return deleted;
			}
   
}
