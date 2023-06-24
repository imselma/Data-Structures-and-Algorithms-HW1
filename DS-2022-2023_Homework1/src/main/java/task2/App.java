package task2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter E if you want to enter expression!");
        System.out.println("Enter R if you want to read expressions from file!");
        String input = reader.nextLine();

        if(input.equals("E")) {
            System.out.print("Enter an expression: ");
            String expression = reader.nextLine();

            System.out.print("Result: ");
            System.out.println(Algorithm.calculate(expression)); //Pisi razmake
        }
        else if (input.equals("R")) {
            ArrayList<Double> results = new ArrayList<Double>();
            System.out.print("Enter file name: ");
            String fileName = reader.nextLine();

            results = Algorithm.calculateFromFile(fileName);

            for(Double result: results) {
                System.out.println(result);
            }
        }
        reader.close();
    }
}

