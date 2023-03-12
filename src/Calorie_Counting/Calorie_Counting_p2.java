package Calorie_Counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Calorie_Counting_p2 {

    //Method that converts an inputfile into a list
    public static ArrayList<String> readerToList(BufferedReader inputReader) throws IOException {
        String currentLine;
        ArrayList<String> calorieList = new ArrayList<>();

        while (true){
            currentLine = inputReader.readLine();

            if (currentLine == null) {
                break;
            }
            calorieList.add(currentLine);
        }

        return calorieList;
    }

    //MAIN
    public static void main(String[] args) throws IOException {
        int topThreeAmount = 0;
        ArrayList<String> elvesCalories = new ArrayList<>();
        ArrayList<Integer> listOfSums = new ArrayList<>();

        //write all lines from the input file into a list
        elvesCalories = readerToList(new BufferedReader(new FileReader("src/Calorie_Counting/input.txt")));
        listOfSums = Calorie_Counting.makeSumList(elvesCalories);

        //sort and reverse the list, so it is in descending order
        Collections.sort(listOfSums);
        Collections.reverse(listOfSums);

        for (int counter = 0; counter < 3; counter++){
            topThreeAmount += listOfSums.get(counter);
        }

        System.out.println(topThreeAmount);
    }
}
