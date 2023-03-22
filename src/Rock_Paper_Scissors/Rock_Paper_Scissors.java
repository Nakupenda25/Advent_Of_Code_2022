package Rock_Paper_Scissors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rock_Paper_Scissors {

    //plays a game of rock paper scissors and returns the result based on the inputs given
    public static Situation playGame(Move opponent, Move you){
        Situation situation = null;

        if ((you == Move.Rock && opponent == Move.Scissors) || (you == Move.Paper && opponent == Move.Rock) || (you == Move.Scissors && opponent == Move.Paper)){
            situation = Situation.Win;
        } else if (you == opponent) {
            situation = Situation.Draw;
        }else
            situation = Situation.Loss;

        return situation;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> guideList = new ArrayList<>();
        int score = 0;

        BufferedReader reader = new BufferedReader(new FileReader("src/Rock_Paper_Scissors/input.txt"));

        //Goes through each line of the input and calculates the score for all of them
        while (true){
            String currentLine = reader.readLine();

            if (currentLine == null){
                break;
            }

            Move enemyMove = Move.typeOfMove(currentLine.charAt(0));
            Move yourMove = Move.typeOfMove(currentLine.charAt(2));

            //the score is the "value" of your move + the value of the result of the game
            score += (yourMove.getMoveValue() + playGame(enemyMove, yourMove).getSituationScore());

        }

        System.out.println(score);

    }
}
