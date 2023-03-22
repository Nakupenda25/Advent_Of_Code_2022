package Rock_Paper_Scissors;

public enum Situation {
    Loss(0),
    Draw(3),
    Win(6);

    private int score;

    //sets the score of each defined situation
    Situation(int score) {
        this.score = score;
    }

    int getSituationScore(){
        return this.score;
    }

    //sets a situation based on the character input
    static Situation whichSituation(char letter){
        switch (letter){
            case 'X':
                return Loss;
            case 'Y':
                return Draw;
            case 'Z':
                return Win;
            default:
                throw new IllegalArgumentException();
        }
    }

}
