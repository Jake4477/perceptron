
package perceptron;

import static perceptron.PerceptronBrain.random;
import static perceptron.Problem.*;

/**
 * Jan 20, 2022
 * @author j.head
 * Teacher: Mr. Wachs
 * Description: The point holds the answer and generates a random x and y upon
 * getting invoked. Mainly used for location and supervised learning
 */
public class Point {
    double x; // x position
    double y; // y position
    int answer; //answer to problem (-1, 1)
    int guess; //holds a guess for problem class to display
    int order; // if applicable. Used by problem for creating a line function
    int bias;
    /**
     * constructor gives point random x and y value when invoked
     */
    public Point(){
        x = random(0, WIDTH); // random values for x and y
        y = random(0, HEIGHT);
        bias = (int) b; // bias = y int. Math stuff idk but it works
        // y = mx + b: linear seperation line for data
        // if y > mx+b
        double function = (slope * x) + b;
        if(y < function){
            answer = 1;
        }
        else{
            answer = -1;
        }
        
    }
    public Point(int order){
        this.order = order;
        this.x = random(0, WIDTH);
        this.y = random(0, HEIGHT);
        bias = (int) b; //bias = y int
    }
    /**
     * set the location of the point
     * @param x x pos
     * @param y y pos
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    /**
     * updates the function of the point
     */
    public void update() {
        double function = (slope * x) + b;
        if(y < function){
            answer = 1;
        }
        else{
            answer = -1;
        }
    }
    /**
     * holds a guess from the perceptron 
     * @param guess an int from perceptron activation function
     */
    public void guess(int guess){
        this.guess = guess;
    }
}
