
package userinterface;

import design.Visuals;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Jan 20, 2022
 * @author Jake
 * Teacher: Mr. Wachs
 * Description: Creates Instructions UI
 */
public class Instructions implements Visuals {
    //constructor 
    public Instructions(){
        //nothing needed 
    }
    /**
     * creates frame that holds instructions
     */
    @Override
    public void createFrame() {
       JPanel panel = new JPanel();
       panel.setLayout(null);
       JFrame instruc = new JFrame("Instructions");
       instruc.setSize(500, 500);
       instruc.setLocationRelativeTo(null);
       instruc.setVisible(true);
       //disposes the frame when exited
       instruc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       // instruc.setLayout(null);
       JLabel title = new JLabel("<html><h2><b>Instructions:<b></h2></html>");
       title.setBounds(175, -65, 200, 200);
       
       JLabel instructions = new JLabel(""
               + "<html>- After Pressing Run On The Main Page "
               + "You Will Be Taken"
               + " To The Visual Part Of The Perceptron. <br>"
               + "<br>"
               + "-Pressing Any Key On The Keyboard will Run Through Every "
               + "Point And Train The Perceptron  <br><br>"
               + "-To Edit The Linear Function Live "
               + "Press <b>'N'</b> for New. There"
               + " You Can Change The Function To Anything. Just Make Sure"
               + "To Press 'Change'<br><br><br><br> "
               + "<h2>You Can Now Safetly Close This Window</h2></html>");
       instructions.setBounds(20, 20, 400, 300);
       panel.add(instructions);
       panel.add(title);
       instruc.add(panel);
    }
    
}
