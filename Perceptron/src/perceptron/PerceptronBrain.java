
package perceptron;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Jan 20, 2022
 * @author j.head
 * Teacher: Mr. Wachs
 * Description: This is the brain of the perceptron. It is responsible for
 * wights and trains them. Turns inputs into output using weighted sum and 
 * activation function
 */
public class PerceptronBrain {
    double weights[];
    double lr = 0.1; // learning rate
    
    //constructor. gives weights random values from (-1, 1)
    public PerceptronBrain(int n){
        weights = new double[n];
        //initialize weights randomly
        for (int i = 0; i < weights.length; i++) {
            weights[i] = random(-1, 1);
            System.out.println(weights[i]);
        }
    }
    /**
     * weighted sum of inputs and weights. returns guess from 
     * activation function
     * @param inputs 
     * @return 
     */
    public int guess(double inputs[]){
        double sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i]; // weighted sum
        }
        int output = sign(sum); // activation function
        
        return output;
    }
    /**
     * changed the weights to change outcome when incorrect
     * @param inputs the input array (x and y) of current point
     * @param target the correct answer in current point. Required
     * for supervised learning
     * @return guess for problem to use 
     */
    public int train(double inputs[], int target){
        int guess = guess(inputs);
        int error = target - guess;
        //tune all the weights
        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * inputs[i] * lr;
        }
        return guess;
    }
    
    //activation function
    public int sign(double n){
        if(n>=0){
            return 1;
        }
        else{
            return -1;
        }
    }
    
    /**
     * Returns double between low and high
     * @param low low number
     * @param high high number
     * @return random number between low and high
     */
    public static double random(int low, int high){
        return ThreadLocalRandom.current().nextDouble(low, high);
    }
    
}
