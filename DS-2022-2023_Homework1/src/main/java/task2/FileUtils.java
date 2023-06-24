package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileUtils {

    public static ArrayList<String> readFile(String filePath) throws FileNotFoundException {

        //Expressions from file will be stored in Expressions array
        ArrayList<String> Expressions = new ArrayList<String>();

        Scanner reader = new Scanner(System.in);  //used to read the file

        try {
            File file = new File(filePath);
            reader = new Scanner(file);

            while(reader.hasNextLine()) {
                Expressions.add(reader.nextLine());
            }

            reader.close();
        } catch(FileNotFoundException error) {
            System.out.println("File:" + filePath + "not found!");
        }

        return Expressions;
    }
}
