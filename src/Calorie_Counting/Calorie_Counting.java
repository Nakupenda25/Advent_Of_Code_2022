package Calorie_Counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Calorie_Counting {

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

    //returns an ArrayList containing the sums of each individual elves calories
    public static ArrayList<Integer> makeSumList(ArrayList<String> listOfCalories){
        int currentCalories = 0;
        ArrayList<Integer> listOfSums= new ArrayList<>();

        //adds each indivual calorie on the given list to a total, and then adds that total to a list
        for (String element : listOfCalories) {

            if (element.isBlank()){
                listOfSums.add(currentCalories);
                currentCalories = 0;
            }else {
                currentCalories += Integer.parseInt(element);
            }

        }

        return listOfSums;
    }


    public static void main(String[] args) throws IOException {

        ArrayList<String> calorieList = new ArrayList<>();
        ArrayList<Integer> listOfSums = new ArrayList<>();

        //write all lines from the input file into a list
       calorieList = readerToList(new BufferedReader(new FileReader("src/Calorie_Counting/input.txt")));
       listOfSums = makeSumList(calorieList);

       //sort and reverse the list, so it is in descending order
        Collections.sort(listOfSums);
        Collections.reverse(listOfSums);

        System.out.println(listOfSums.get(0));
    }
}
