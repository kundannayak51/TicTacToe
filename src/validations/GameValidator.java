package validations;

import model.Board;
import model.Player;

import java.util.HashMap;

public class GameValidator {
    Board board;
    HashMap<Integer, Boolean> playerCheck;

    public GameValidator(Board board, HashMap<Integer, Boolean> playerCheck) {
        this.board = board;
        this.playerCheck = playerCheck;
    }

    public Boolean validateCoordinates(int x, int y) {
        int n = board.getBoard().length;
        if(x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }

    public Boolean isBoardPositionEmpty(int x, int y) {
        return board.getPosition(x, y).equals("_");
    }
}
