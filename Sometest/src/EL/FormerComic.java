//2017.04.30 BeibeiZhang
//the former comic of the game 
package EL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormerComic {
         public static void comic(JFrame frame0){
        	 ImageIcon image1=new ImageIcon("c1.jpg"); 
        	 ImageIcon image2=new ImageIcon("c2.jpg");
        	 ImageIcon image3=new ImageIcon("c3.jpg"); 
        	 ImageIcon image4=new ImageIcon("c4.jpg");
        	 ImageIcon image5=new ImageIcon("c5.jpg"); 
         	 frame0.setBounds(40, 40,image1.getIconWidth(),image1.getIconHeight());
        	 int height=frame0.getHeight();
        	 int width=frame0.getWidth();
           	 JLabel label1=new JLabel(image1);
           	 JLabel label2=new JLabel(image2);
           	 JLabel label3=new JLabel(image3);
          	 JLabel label4=new JLabel(image4);
          	 JLabel label5=new JLabel(image5);
        	 //It is strange that we use "/" rather than "\" to tell the path
        	 label1.setBounds(0, 0,width,height);
        	 label2.setBounds(0, 0,width,height);
        	 label3.setBounds(0, 0,width,height);
        	 label4.setBounds(0, 0,width,height);
        	 label5.setBounds(0, 0,width,height);
        	 JPanel panel0=(JPanel)frame0.getContentPane();
             panel0.setOpaque(false);
        	 //if you want to put something on the content pane(the top panel/surface)
        	 frame0.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        	 frame0.setVisible(true);
        	 try{
        		 Thread.sleep(3000);
        	 }catch(InterruptedException e){
        		 e.printStackTrace();
        	 }
        	 
        	 frame0.getLayeredPane().remove(label1);
       
        	 frame0.getLayeredPane().add(label2,new Integer(Integer.MIN_VALUE));
        	 frame0.setVisible(true);
        	 try{
        		 Thread.sleep(3000);
        	 }catch(InterruptedException e){
        		 e.printStackTrace();
        	 }
        	
        	 frame0.getLayeredPane().remove(label2);
        	 frame0.getLayeredPane().add(label3,new Integer(Integer.MIN_VALUE));
        	 frame0.setVisible(true);
        	 try{
        		 Thread.sleep(3000);
        	 }catch(InterruptedException e){
        		 e.printStackTrace();
        	 }
        	
        	 frame0.getLayeredPane().remove(label3);
        	 frame0.getLayeredPane().add(label4,new Integer(Integer.MIN_VALUE));
        	 frame0.setVisible(true);
        	 try{
        		 Thread.sleep(3000);
        	 }catch(InterruptedException e){
        		 e.printStackTrace();
        	 }
        	
        	 frame0.getLayeredPane().remove(label4);
        	 frame0.getLayeredPane().add(label5,new Integer(Integer.MIN_VALUE));
        	 frame0.setVisible(true);
        	 try{
        		 Thread.sleep(3000);
        	 }catch(InterruptedException e){
        		 e.printStackTrace();
        	 }
        	 
        	 frame0.getLayeredPane().remove(label5);
        	
         }
}
