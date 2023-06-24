package task2;

import task1.Stack;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Algorithm {
    public static Stack<Double> Values = new Stack<Double>();
    public static Stack<String> Operators = new Stack<String>();
    public static ArrayList<String> AllowdOperators = new ArrayList<String>();
    //Used static, to initialize the values to the array list
    static {
        AllowdOperators.add("+");
        AllowdOperators.add("-");
        AllowdOperators.add("*");
        AllowdOperators.add("/");
        AllowdOperators.add("%");
        AllowdOperators.add("^");
        AllowdOperators.add("√");
    }
    public static Double calculate(String s1) {


        //In order to simplify, string is split into array of single characters
        String[] splittedString = s1.split(" ");
        for(int i=0; i<splittedString.length;i++){
            //If the character is open parenthesis, it should skip it and proceed further on
            if(splittedString[i].equals("(")){
                continue;
            }
            else if(splittedString[i].equals(")")){

                //If parenthesis are closed, that indicates that it should do some calculations on previous two values in value stack that will be poped
                Double firstValue = null;
                Double secondValue = null; //initialize variables to be "empty" not zero, because if it was zero, the multiplication result would always be zero
                String Operator;

                //Load first variable with the value from value stack and the operator with operator from operators stack
                firstValue = Values.pop();
                Operator = Operators.pop();

                //since the square root operation takes only one value to perform the calculation, that means that if the operator is not sqrt, load the secondValue as well
                if(!Operator.equals("√")){

                    secondValue= Values.pop();
                }

                //Defining operators performed on value variables
                switch(Operator){
                    case "+":
                        Values.push(secondValue + firstValue);
                        break;
                    case "-":
                        Values.push(secondValue - firstValue);
                        break;
                    case "*":
                        Values.push(secondValue * firstValue);
                        break;
                    case "/":
                        Values.push(secondValue / firstValue);
                        break;
                    case "%":
                        Values.push(secondValue %  firstValue);
                        break;
                    case "^":
                        Values.push(Math.pow(secondValue, firstValue));
                        break;
                    case "√":
                        Values.push(Math.sqrt(firstValue));
                        break;
                }}

                //if the character is inside allowed operators array, push the character into operator stack
                else if (AllowdOperators.contains(splittedString[i])){
                    Operators.push(splittedString[i]);
                }
                // if it is not inside the allowed operators array, push it inside Values stack, but as double type value
                else{
                    Values.push(Double.parseDouble(splittedString[i]));
                }


            }
            //returning the last left value from value stack as result
            return Values.pop();
    }

    public static ArrayList<Double> calculateFromFile(String filePath) throws FileNotFoundException {
            ArrayList<Double> Results = new ArrayList<Double>();
            ArrayList<String> Expressions  = FileUtils.readFile(filePath);  //poziva read file metodu iz file utils klase

            for(String expression: Expressions) {      //Ovdje pravimo novu array listu koja ce nam storati rezultate od expressions
                Results.add(calculate(expression));    //S obzirom d aje svaka expression u novom redu, mora biti array list
            }                                          //pozove metodu calculate nad tom expression (koja je u calculate metodi denotana
                                                       //kao string, i stora je u result array
            return Results;
        }
    }

