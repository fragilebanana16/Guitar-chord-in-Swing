/**  

* <p>Title: Chordify 

* <p>Description: A songs chord recorder using swing

* @author Hurton  

* @date 2020/03/12 ~ 2020/?/?  

* @version 1.0  

*/  

import javax.swing.*;
import java.awt.*;
class singleSong{
	
	int capo;
	int count;
	String chord;
	String name;
	String addition;
	
  public singleSong(String name, int capo, int count, String chord, String addition){
  	
  	this.name = name;
  	this.capo = capo;
  	this.chord = chord;
  	this.addition = addition;
  	this.count = count;
  }
  public void getInfo(){
  	System.out.println("song name:" + this.name);
  	System.out.println("capo on " + this.capo + " fret");
  	System.out.println(this.count + " chords used.");
  	System.out.println("chords are :" + this.chord);
  	System.out.println("PS:" + this.addition);
  	
  
  }
}
public class Main {

    public static void main(String[] args) {
    
      // fill the songs data
      singleSong[] songs = new singleSong[]{
      	// name capo chordCount detail addition
      	new singleSong("We Are Stars", 4, 4,"G Cadd9 Em7 Cadd9", "Nope"),
      	new singleSong("Better Than A Hallelujah", 0, 6,"G Em C C2 D Asus4", "Nope"),
      	new singleSong("Rains in LA", 5, 4,"Em7 Am7 D G", "Nope"),
      	new singleSong("Payphone", 0, 2,"Cadd7 G", "single:4th string and 2fret D(no 1th string 2fret)"),
      	new singleSong("Havana", 3, 2,"Em C", "2fret:1 3 5string 1fret::4string"),
      	new singleSong("Just the way you are", 3, 3,"D Bm G", "Nope"),
      	new singleSong("Sooner", 0, 4,"G Cadd9 Em7 Cadd9", "CADD9食指不按"),
      	new singleSong("Pink Champagne", 0, 3,"G Bm C", "3rd fret p 5rd fret (play four strings ) "),
      	new singleSong("You Don't Know Me", 7, 4,"C Em Am F(C-1)", "Nope"),
      	new singleSong("He said", 3, 3,"G EM7 D", "Nope"),
      	new singleSong("Settle for less", 0, 4,"B Abm E F#", "Nope"),
      	new singleSong("Need you now", 4, 7,"F AM F AM F C EM", "Nope"),
      	new singleSong("Hey soul sister", 4, 4,"C2 G2 AM2 F2", "Nope"),
      	new singleSong("Don wanna know", 0, 3,"G D EM", "EM(2thstring,1thfret)"),
      	new singleSong("Closer", 1, 4,"Cadd9 D Em7 D", "Nope"),
      	new singleSong("Galway girl", 2, 4,"Em G D Cadd9", "Nope"),
      	new singleSong("One call away", 1, 6,"C G AM F C G", "Nope"),
      	new singleSong("Whiskey  and morphine", 0, 4,"C B7 Em G", "Nope"),
      	new singleSong("Pass me by", 1, 4,"D A Bm G", "Nope"),
      	new singleSong("Eenie Meenie", 1, 4,"Am F C G", "Nope"),
      	new singleSong("Numb", 2, 4,"Em C G D", "or F0 F#m D A E"),
      	new singleSong("Good time", 1, 4,"G D A Bm7", "Nope"),
      	new singleSong("Tik Tok", 3, 3,"G A Bm7", "Nope"),
      	new singleSong("Shape of you", 2, 4,"Bm7 Em G A", "Nope"),
      	new singleSong("Song For You", 0, 4,"E B C#m A", "Nope"),
      	new singleSong("Hung up", 2, 7,"D A Bm Bm G A D", "Nope"),
      	new singleSong("Strawberries & Cigarettes", 0, 4,"A E F#m D", "3string:-7-9-11-"),
      	new singleSong("Slow it down", 3, 2,"Am7 F ", "Am7(2 string up)"),
      	new singleSong("B-e-a-utiful", 0, 4,"F C G Am", "Nope"),
      	new singleSong("No brainer", 0, 4,"Asus littleFF Am G", "Nope"),
      	new singleSong("Give love", 1, 4,"C Am F C", "Nope"),  
      	new singleSong("Left Right Left", 0, 6,"D E G D Em D", "Nope"),
      	new singleSong("Somebody told me", 0, 3,"A B C#m", "Nope"),
      	new singleSong("All Falls Down", 1, 4,"F G C Am", "Nope"),
      	new singleSong("In the dark", 0, 5,"G Em Bm A D", "Nope"),
      	new singleSong("10000 hours", 3, 4,"G Em7 Cadd9 G", "Nope"),
      	
      	

      
      }; 
      
 
    	
    	// init
    	JFrame jf = new JFrame("Chordify @Hurton written in 2020/03/12");
      jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      GridBagLayout gridBag = new GridBagLayout();    // layout manager
      GridBagConstraints c = null;                    // constraints
      JPanel panel = new JPanel(gridBag);
      // add songs to panel
      for(singleSong i:songs){
      	panel = paintButtons(i, panel, c, gridBag);
      }
      
     
      
      // set visual
      jf.setContentPane(panel);
      jf.pack();
      jf.setLocationRelativeTo(null);
      jf.setVisible(true);
    }
    
    public static JPanel paintButtons(singleSong a, JPanel panel, GridBagConstraints c, GridBagLayout gridBag){

      // song name btn
      JButton nameBtn = new JButton(a.name);
      // capo on which fret
      JButton capoBtn = new JButton("Capo:" + a.capo);
      // PS:
      JButton additonBtn = new JButton("PS:" + a.addition);
      // add component to layout
      // song name
      c = new GridBagConstraints();
      c.fill = GridBagConstraints.BOTH;
      gridBag.addLayoutComponent(nameBtn, c);
      panel.add(nameBtn);
      // capo 
      c = new GridBagConstraints();
      gridBag.addLayoutComponent(capoBtn, c);  
      panel.add(capoBtn);    
      // chords
      for(int i=0;i<a.count;i++){
      	JButton singleChordBtn = new JButton(a.chord.split(" ")[i]);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(singleChordBtn, c); 
        panel.add(singleChordBtn);     	
      
      }
      // addition PS
      c = new GridBagConstraints();
      c.gridwidth = GridBagConstraints.REMAINDER;
      c.fill = GridBagConstraints.BOTH;
      gridBag.addLayoutComponent(additonBtn, c);
      panel.add(additonBtn);
      // panel returned for next painting
      return panel;
    }
    

}
