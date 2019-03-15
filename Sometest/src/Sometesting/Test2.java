package Sometesting;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test2 {
public static void playMusic(){ 
		
/*		try { 
		File f= new File("backmusic.wav");
		URI uri = f.toURI(); 
	    URL music=uri.toURL();
		AudioClip aau;
		aau = Applet.newAudioClip(music);
		aau.loop(); 
		} catch (Exception e){ 
		e.printStackTrace();
		 }
	*/
	try{
		File backMusic=new File("backmusic.wav");
		URI musicURI=backMusic.toURI();
		URL musicURL=musicURI.toURL();
	
		AudioClip backMusicPlayer=Applet.newAudioClip(musicURL);
		backMusicPlayer.play();
		backMusicPlayer.loop();  
	
	}catch(Exception ex){
		ex.printStackTrace();
	}
		 }
public static void main(String[] args){
        	 playMusic();
         }
}
