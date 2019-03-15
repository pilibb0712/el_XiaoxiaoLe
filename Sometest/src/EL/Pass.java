//2017.05.02 BeibeiZhang
//the comic appears when the player pass 
package EL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pass {
         public static void passgame(JFrame aframe){
        	 ImageIcon pass1=new ImageIcon("p1.jpg");
        	 int width=pass1.getIconWidth();
        	 int height=pass1.getIconHeight();
        	 aframe.setBounds(0,0,width,height);
        	 JLabel p1=new JLabel(pass1);
        	 p1.setBounds(0, 0, width, height);
        	 JPanel top=(JPanel)(aframe.getContentPane());
        	 top.setOpaque(false);
        	 aframe.getLayeredPane().add(p1,new Integer(Integer.MIN_VALUE));
        	 aframe.setVisible(true);
        	 try{ Thread.sleep(1000);
			  }catch(InterruptedException e){
				  e.printStackTrace();
			  }
         }
}
