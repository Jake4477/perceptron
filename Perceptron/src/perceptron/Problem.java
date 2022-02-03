
package perceptron;

import design.Visuals;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Jan 20, 2022
 * @author j.head
 * Teacher: Mr. Wachs
 * description: The main problem class. The problem being organization of 
 * points. This class holds main visuals and controls perceptron inputs
 */
public class Problem extends JPanel implements KeyListener, Visuals {
    public static boolean editFunction = false;
    Graphics g;
    PerceptronBrain p;
    Point p1;  // points used for generating a function
    Point p2;
    Point yInt;
    Point right;
    final int AMOUNT = 400; // amount of points to generate
    public static double slope; // slope and b used in point for functon
    public static double b;
    public static final int WIDTH = 700; // width of frame
    public static final int HEIGHT = 700; // height of frame
    LinkedList<Point> points = new LinkedList<>(); // holds points
    //Point[] points = new Point[400];
    FunctionEditor fe;
    //y = mx + b function for linear line
    
    
    /**
     * Constructor. Instantiates Perceptron and makes guess
     */
    public Problem(){
        //create function. generate two points
        createFunction();
        fe = new FunctionEditor();
        
        p = new PerceptronBrain(3);
        for (int i = 0; i < AMOUNT; i++) {
            points.add(new Point());//instantiates all points
        }
        createFrame(); // makes visuals
    }
    private void createFunction(){
        /**
         * create two points on screen to get slope and create function
         */
         p1 = new Point(1); // first point for function
         p2 = new Point(2); // Second point for function
        double rise;
        rise = p1.y - p2.y;
        double run = p1.x - p2.x;
        System.out.println("Rise: " + rise);
        System.out.println("run: " + run);
        slope = rise / run;
        System.out.println("Slope: " + slope);
        yInt = new Point(p1.x, p1.y); // set point to go back
        while(yInt.x > 0){
            yInt.x --; // goes back by one
            yInt.y -= slope;
        }
        //after having the point that gets the y int I need a point to do the
        //opposite. So I can draw a line through two points for visuals
        right = new Point(p1.x, p1.y);
        while(right.x < WIDTH){
            right.x++;
            right.y += slope;
        }
        b = yInt.y;
        
        System.out.println("Y Intercept: " + yInt.y);
    }
    

    ////////////////////////////////////////////////////////////

    /**
     * paints graphics
     * @param g graphics
     */
     public void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);
        if(editFunction){
            yInt.y = b;
            right.y = (slope * WIDTH) + b;
            for (Point point : points) {
                point.update();
            }
        }
        
        //main point loop
        for (Point pt : points) {
            double inputs[] = {pt.x, pt.y, (double) pt.bias}; // gets x and y from current point
            int guess = p.train(inputs, pt.answer); //trains with values 
            if (guess == 1) {
                g.setColor(Color.red);//changes colors depending on guess
            } else {
                g.setColor(Color.blue);
            }
            g.fillOval((int) pt.x, (int) pt.y, 10, 10); // draws point
        }
        g.setColor(Color.BLACK);
        //draw function line
        g.drawLine((int)yInt.x, (int) yInt.y, (int) right.x, (int) right.y);
    }

//////////////////////////////////////////////////////////////////////////////    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * key listener. Waits for 'n' to be pressed and opens FunctionEditor.
     * Repaint runs through points and trains them. 
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        repaint(); // runs trianing
        if(e.getKeyChar() == 'n'){ // press n for editor
            fe.createFrame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * creates JFrame and adds KeyListener
     */
    @Override
    public void createFrame() {
        JFrame frame = new JFrame("Perceptron");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(this);
        frame.addKeyListener(this);
    }
    
    
}
