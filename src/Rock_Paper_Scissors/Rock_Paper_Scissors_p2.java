package Rock_Paper_Scissors;

import java.io.*;

public class Rock_Paper_Scissors_p2 {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader("src/Rock_Paper_Scissors/input.txt"));
        String currentLine;
        int score = 0;

        while (true){
            currentLine = reader.readLine();

            if (currentLine == null) {
                break;
            }

            //Sets the enemy shape and only the situation that is expected based on the strategy guide
            Move enemyShape = Move.typeOfMove(currentLine.charAt(0));
            Situation expectedSituation = Situation.whichSituation(currentLine.charAt(2));

            //goes through each possible move a player could make. If the outcome is as expected, add that moves value + the score of the outcome to the final result
            for (Move attemptedShape : Move.values()) {
                Situation testedSituation = Rock_Paper_Scissors.playGame(enemyShape, attemptedShape);

                if (testedSituation == expectedSituation){
                    score += (attemptedShape.getMoveValue() + testedSituation.getSituationScore());
                }
            }

        }

        System.out.print(score);
    }

}
