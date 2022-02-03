
package perceptron;

import design.Visuals;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import security.ErrorCheck;

/**
 * Jan 20, 2022
 * @author Jake
 * Teacher: Mr Wachs
 * Description: Creates the user interface that allows the user to edit 
 */
public class FunctionEditor extends JPanel implements Visuals{
    JLabel currentF;
    JButton add = new JButton("Change");
    JTextField slopeInput = new JTextField();
    JTextField b = new JTextField();
    int count = 0;
    
    //Constructor
    public FunctionEditor(){
        //nothing needed
    }
    /**
     * creates frame and interface
     */
    @Override
    public void createFrame(){
        currentF = new JLabel("y = " + Problem.slope + " * X + " + Problem.b);
        JFrame frame = new JFrame("Change Function");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setSize(400, 225);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(this);
        this.setLayout(null);
        add.setBounds(140, 10, 100, 25);
        JLabel explain = new JLabel("Current Function:");
        explain.setBounds(140, 45, 300, 20);
        currentF.setBounds(45, 50, 300, 40);
        JLabel start = new JLabel("y = ");
        start.setBounds(90, 100, 45, 25);
        JLabel middle = new JLabel(" * X + ");
        middle.setBounds(170, 100, 60, 25);
        slopeInput.setBounds(110, 100, 60, 25);
        
      
        b.setBounds(205, 100, 60, 25);
        this.add(b);
        if (count == 0){
            this.add(add);
            this.add(explain);
            this.add(currentF);
            this.add(start);
            this.add(middle);
            this.add(slopeInput);
            this.add(b);
            count++;
        }
        
        
        add.addActionListener(new ActionListener() {
            @Override
            //button for finalizing new function
            public void actionPerformed(ActionEvent e) {
                double newSlope = 0; 
                double newB = 0;
                //error checking
                newSlope = ErrorCheck.checkDouble(slopeInput.getText());
                newB = ErrorCheck.checkDouble(b.getText());
                if (newB != -1 && newSlope != -1) {
                    
                    Problem.slope = newSlope;
                    Problem.b = newB;
                    currentF.setText("y = " + Problem.slope + " * X + " + Problem.b);
                    Problem.editFunction = true;
                    slopeInput.setText(null);
                    b.setText(null);
                    frame.dispose();
                }
            }
        });
    }
}
