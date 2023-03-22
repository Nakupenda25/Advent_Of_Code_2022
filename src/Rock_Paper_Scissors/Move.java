package Rock_Paper_Scissors;

public enum Move {
    Rock(1),
    Paper(2),
    Scissors(3);

    private int value;

    //sets the "value" of the different moves
    Move(int value) {
        this.value = value;
    }

    int getMoveValue(){
        return this.value;
    }

    static Move typeOfMove(char input) {
        switch (input) {
            case 'A', 'X':
                return Rock;
            case 'B', 'Y':
                return Paper;
            case 'C', 'Z':
                return Scissors;
            default:
                throw new IllegalArgumentException("What is that symbol dude");
        }
    }
}
