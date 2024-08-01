package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {

    public Character[][] matrix;

    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    public Boolean isInFavorOfX() {
        Boolean horizontalWinner = checkHorizontal('X');
        Boolean verticalWinner = checkVertical('X');
        Boolean diagForwards = checkDiagonalForwards('X');
        Boolean diagBackwards = checkDiagonalBackwards('X');

        if (horizontalWinner || verticalWinner || diagForwards || diagBackwards){
            return true;
        }
        return false;
    }

    public Boolean isInFavorOfO() {
        Boolean horizontalWinner = checkHorizontal('O');
        Boolean verticalWinner = checkVertical('O');
        Boolean diagForwards = checkDiagonalForwards('O');
        Boolean diagBackwards = checkDiagonalBackwards('O');

        if (horizontalWinner || verticalWinner || diagForwards || diagBackwards){
            return true;
        }
        return false;
    }

    public Boolean isTie() {
        if (isInFavorOfO() == isInFavorOfX()) {
            return true;
        }
        return false;
    }

    public String getWinner() {
        if (isTie()){
            return "";
        } else if (!isTie() && !isInFavorOfO() && isInFavorOfX()){
            return "X";
        } else if (!isTie() && !isInFavorOfX() && isInFavorOfO()){
            return "O";
        } else{
            return null;
        }
    }

    public Boolean checkHorizontal(char player){
        int comboCounter =0;
        for (int i = 0; i< matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (matrix[i][j] == player){
                    comboCounter++;
                } else {
                    comboCounter = 0;
                }
            }
            if (comboCounter == 3){
                return true;
            }
        }
        return false;
    }


    public Boolean checkVertical(char player){
        int comboCounter =0;
        for (int i = 0; i< matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (matrix[j][i] == player){
                    comboCounter++;
                } else {
                    comboCounter = 0;
                }
            }
            if (comboCounter == 3){
                return true;
            }
        }
        return false;
    }

    public Boolean checkDiagonalForwards (char player){
        int comboCounter =0;
        int i = 0;
        for (int j = 0; j < matrix.length; j++){
            if (matrix[j][i] == player){
                comboCounter++;
                i++;
            } else {
                comboCounter = 0;
                i++;
            }
        }
        if (comboCounter == 3){
            return true;
        }
        return false;
    }

    public Boolean checkDiagonalBackwards (char player){
        int comboCounter =0;
        int i = 0;
        for (int j = 2; j >= 0; j--){
            if (matrix[i][j] == player){
                comboCounter++;
                i++;
            } else {
                comboCounter = 0;
                i++;
            }
        }
        if (comboCounter == 3){
            return true;
        }
        return false;
    }
}
