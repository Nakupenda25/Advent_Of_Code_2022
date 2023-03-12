package Rock_Paper_Scissors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rock_Paper_Scissors {

    public static int getScore(char enemy, char you){
        int score = 0;

        //switch-case for every possible combination (please tell me if theres a better way to do this haha)
        switch (enemy) {
            case 'A':
                switch (you) {
                    case 'X':
                        score = 4;
                        break;
                    case 'Y':
                        score = 8;
                        break;
                    case 'Z':
                        score = 3;
                        break;
                }
                break;
            case 'B':
                switch (you){
                    case 'X':
                        score = 1;
                        break;
                    case 'Y':
                        score = 5;
                        break;
                    case 'Z':
                        score = 9;
                        break;
                }
                break;

            case 'C':
                switch (you){
                    case 'X':
                        score = 7;
                        break;
                    case 'Y':
                        score = 2;
                        break;
                    case 'Z':
                        score = 6;
                        break;

                }
                break;
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> guideList = new ArrayList<>();
        int score = 0;

        BufferedReader reader = new BufferedReader(new FileReader("src/Rock_Paper_Scissors/input.txt"));

        //creates a new list where all values are saved for easy reading
        while (true){
            String currentLine = reader.readLine();

            if (currentLine == null){
                break;
            }
            guideList.add(currentLine);

        }

        char[][] strategyGuide = new char[guideList.size()][2];

        //sets the values of the multidimensional array
        for (int counter = 0; counter < guideList.size(); counter++){
            strategyGuide[counter][0] = guideList.get(counter).charAt(0);
            strategyGuide[counter][1] = guideList.get(counter).charAt(2);
        }

        //compares every single element of the list
        for (char[] element : strategyGuide) {
            score += getScore(element[0], element[1]);
        }

        System.out.println(score);

    }
}
