
package userinterface;

import design.Visuals;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import perceptron.Problem;

/**
 * Jan 20, 2022
 * @author Jake
 * Teacher: Mr. Wachs
 * Description: 
 */
public final class UI extends JPanel implements Visuals{

    private int width = 500;
    private int height = 600;
    JLabel introduction;
    JFrame ui;
    Instructions manual;
    /**
     * constructor. Invokes the creation of the user interface. Also sets up 
     * a manual and information association
     */
    public UI(){
        //create frame
        //add buttons
        //cretae Instructions
        this.setLayout(null);
        createFrame();
        createVisual();
        buttons();
        
        //associations 
        manual = new Instructions(); 
        
        
        ui.add(this);  //adds components to frame
    }
    /**
     * creates frame
     */
    @Override
    public void createFrame() {
        ui = new JFrame("Welcome");
        ui.setSize(width, height);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
    }
    /**
     * creates visuals for the User Interface
     */
    private void createVisual() {
        //uses html for formatting
        String title = "<html><h2>Welcome To My Perceptron!</h2>"; // title 
        String opening = 
                "<html>This Percepton Will "
                + "Organize Points Given A Function!</html>"; // intro text
        JLabel intro = new JLabel(opening);
        intro.setBounds(85, 50, 400, 100);
        this.add(intro);
        introduction = new JLabel();
        introduction.setSize(300, 400);
        introduction.setLocation(115, -160);
        introduction.setText(title);
        this.add(introduction);        
    }
    /**
     * creates two buttons for Instructions and Run
     */
    private void buttons(){
        //For Instructions
        JButton intructions = new JButton("Instructions");
        intructions.setBounds(175, 150, 125, 25);
        this.add(intructions);
        intructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manual.createFrame();
            }
        
        });
        ///////////////////Main Run Button/////////////////
        JButton run = new JButton("RUN");
        run.setBounds(145, 300, 200, 100);
        this.add(run);
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Problem p = new Problem(); // moves onto the main program
                ui.dispose();
            }
        
        });
    }
 
}
