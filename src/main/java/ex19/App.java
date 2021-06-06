/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Mauricio Rios
 */
package ex19;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        double weight = myApp.getWeight();
        double height = myApp.getHeight();
        double BMI = myApp.getBMI(weight, height);
        String verdict = myApp.getVerdict(BMI);
        myApp.printOutput(verdict);
    }

    public double getWeight() {
        int weight = 0;
        boolean isNumber;
        do {
            System.out.print("What is your weight, in pounds? ");
            if (in.hasNextDouble()) {
                weight = in.nextInt();
                isNumber = true;
            } else {
                System.out.println("ERROR: Please only enter numbers - Try again");
                isNumber = false;
                in.next();
            }
        } while(!(isNumber));
        return weight;
    }

    public double getHeight() {
        int height = 0;
        boolean isNumber;
        do {
            System.out.print("Enter your height in inches: ");
            if (in.hasNextDouble()) {
                height = in.nextInt();
                isNumber = true;
            } else {
                System.out.println("ERROR: Please only enter numbers - Try again");
                isNumber = false;
                in.next();
            }
        } while(!(isNumber));
        return height;
    }

    public double getBMI(double weight, double height) {
        double BMI = (weight/(height * height)) * 703;
        return Math.round(BMI*10d)/10d;
    }

    public String getVerdict(double BMI){
        if(BMI > 18.5 && BMI <25)
            return "Your BMI is "+BMI+".\nYou are within the ideal weight range.";
        else if(BMI<18.5)
            return "Your BMI is "+BMI+".\nYou are underweight. You should see your doctor.";
        else
            return "Your BMI is "+BMI+".\nYou are overweight. You should see your doctor.";
    }

    public void printOutput(String verdict) {
        System.out.print(verdict);
    }
}