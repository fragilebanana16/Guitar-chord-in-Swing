import util.music.MP3Player;
import util.music.MusicThread;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Demo extends JFrame{
	// allow once click
	static int buttonClickTimes = 0;
	// only one thread used4
	static MusicThread thread;
	static MP3Player mp3;
	static String [] songNames = new String[]{"In the Dark", "Into you", "others1", "others2"};
	static String [] songChords = new String[]{"C G A Am", "G Gadd9 C E", "AAAA", "BBBB"};
	static String [] albumNames = new String[]{"album1", "album2", "album3", "album4"};
	public static void wow(MP3Player nowPlaying) {
			

	    mp3 = nowPlaying;
      JFrame jf = new JFrame("Chordify@Hurton");
      jf.setSize(700, 500);
      jf.setLocationRelativeTo(null);
      jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      //jf.setResizable(false);
      
      // layout manager
      SpringLayout layout = new SpringLayout();
      // panel to fill
      JPanel panel = new JPanel(layout);
      
      // ================================================ new components ================================================
      // album image
      JLabel label = new JLabel();
      label.setIcon(new ImageIcon("res/album1.jpg"));
      
      // descriptions
      JTextField textField = new JTextField();
      textField.setHorizontalAlignment(JTextField.CENTER);
      textField.setFont(new Font("ËÎÌו",Font.PLAIN, 70));
      // songs list
      JList<String> list = new JList<String>();
      
      // play button
      JButton btnPlay = new JButton();
      btnPlay.setIcon(new ImageIcon("res/play1.png"));
      btnPlay.setBackground(Color.white);
      
      // when clicked, play music in new thread
      btnPlay.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			    buttonClickTimes += 1;
			    // no sync here, just once
			    if (buttonClickTimes<2){
				    thread = new MusicThread(mp3);
				    thread.start();
			    }
			    else{
				    // some log here
				    System.out.println("Got repeat clicks");
			    }
		    }
	    });  
	    
	    // stop button
      JButton btnStop = new JButton();
      btnStop.setIcon(new ImageIcon("res/stop2.png"));
      btnStop.setBackground(Color.white);
      
    	// this is a giant part like play button listener
	    btnStop.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			    System.out.println("interrupted");
			    // wow u can click again
			    buttonClickTimes = 0;
			    // attention here, the interrupt should be after close(),somehow i found if interrupt is ahead of close(),say set 1,then close will set 0
			    mp3.close(); 
			    // set 1, pause the playing thread, in run function, we throw the exception to stop the thread
			    thread.interrupt(); 
		    }
	    });
	
      
      
      // ================================================ components settings ================================================
      // label and list size
      label.setPreferredSize(new Dimension(144,144));
      list.setPreferredSize(new Dimension(230,200));
      
      // play single song each time, right?
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // feed songs to list
      list.setListData(songNames);
      // list border:title
      list.setBorder(BorderFactory.createTitledBorder("Songs"));
      // list changed, what to do
      list.addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
              // one
              int indice = list.getSelectedIndex();
              // songs 
              ListModel<String> listModel = list.getModel();
			        // wow u can click again
			        buttonClickTimes = 0;
			        // attention here, the interrupt should be after close(),somehow i found if interrupt is ahead of close(),say set 1,then close will set 0
			        mp3.close(); 

			        textField.setText(songChords[indice]);
			        label.setIcon(new ImageIcon("res/"+albumNames[indice]+".jpg"));
			        
			        
              mp3 = new MP3Player("res/"+listModel.getElementAt(indice)+".mp3");
              // out put logging
              System.out.println("Choosen: " + " = " + listModel.getElementAt(indice)); 
          }
      });
      
      // set default chosen
      list.setSelectedIndex(0);
      // // ================================================ add components to panel ================================================
      panel.add(label);
      panel.add(list);
      panel.add(btnPlay);
      panel.add(btnStop);
      panel.add(textField);


      // ================================================ constraints to the spring layout ================================================

      // set left top
      SpringLayout.Constraints labelCons = layout.getConstraints(label);  
      labelCons.setX(Spring.constant(5));
      labelCons.setY(Spring.constant(5));

      // set left top
      SpringLayout.Constraints listCons = layout.getConstraints(list);
      listCons.setX(Spring.constant(5));
      listCons.setY(Spring.constant(150));

      SpringLayout.Constraints textFieldCons = layout.getConstraints(textField);
      textFieldCons.setX(
              Spring.sum(
                      listCons.getConstraint(SpringLayout.EAST),
                      Spring.constant(5)
              )
      );
      textFieldCons.setY(Spring.constant(5));

      SpringLayout.Constraints panelCons = layout.getConstraints(panel); 

      panelCons.setConstraint(
              SpringLayout.EAST,
              Spring.sum(
                      textFieldCons.getConstraint(SpringLayout.EAST),
                      Spring.constant(5)
              )
      );

      Spring maxHeightSpring = Spring.max(
              listCons.getConstraint(SpringLayout.SOUTH),
              textFieldCons.getConstraint(SpringLayout.SOUTH)
      );

      panelCons.setConstraint(
              SpringLayout.SOUTH,
              Spring.sum(
                      maxHeightSpring,
                      Spring.constant(5)
              )
      );

      SpringLayout.Constraints btnPlayCons = layout.getConstraints(btnPlay);
      btnPlayCons.setX(Spring.constant(158));
      btnPlayCons.setY(Spring.constant(8));

      SpringLayout.Constraints btnStopCons = layout.getConstraints(btnStop);
      btnStopCons.setX(Spring.constant(158));
      btnStopCons.setY(Spring.constant(55));      

      jf.setContentPane(panel);
      jf.setVisible(true);	  
}


}
public class Main {

    public static void main(String[] args) {
    // task queue
      SwingUtilities.invokeLater(
              new Runnable() {
                  @Override
                  public void run() {
                      // create gui here
                      createGUI();
                  }
              }
      );
    }
    public static void createGUI() {
  	  
		  Demo.wow(new MP3Player("res/In the Dark.mp3"));
    }
}
