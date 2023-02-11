package service;

import exception.BoardException;
import mode.Print;
import model.Board;
import model.Player;
import validations.GameValidator;

import java.util.List;

public class TicTacToeService {
    Board board;
    GameValidator gameValidator;
    List<Player> players;
    Print print;
    int gameCount;

    public TicTacToeService(Board board, GameValidator gameValidator, List<Player> players, Print print) {
        this.board = board;
        this.gameValidator = gameValidator;
        this.players = players;
        this.print = print;
        this.gameCount = 0;
    }

    public void input(int x, int y, Player player) {
        if(!gameValidator.validateCoordinates(x, y)) {
            throw new BoardException("Invalid coordinates!");
        }
        if(!gameValidator.isBoardPositionEmpty(x, y)) {
            throw new BoardException("Board position already filled!");
        }

        String symbol = player.getSymbol();
        board.setPosition(x, y, symbol);
        print.printBoard(board);

        if(checkBoard(x, y, symbol)) {
            System.out.println("Player: " + player.getPlayerName() + "Wins!");
            System.exit(0);
        }
        gameCount++;
        if(checkBoardFill()) {
            System.out.println("Game Draw");
            System.exit(0);
        }
    }

    private boolean checkBoard(int x, int y, String symbol) {
        boolean winRow = true, winCol = true, winDig = true, winReverseDig = true;
        int n = board.getBoard().length;
        for(int i=0; i<n; i++) {
            if(!board.getPosition(x, i).equals(symbol)) winRow = false;
            if(!board.getPosition(i, y).equals(symbol)) winCol = false;
            if(!board.getPosition(i, i).equals(symbol)) winDig = false;
            if(!board.getPosition(i,n-i-1).equals(symbol)) winReverseDig = false;
        }
        return winRow || winCol || winDig || winReverseDig;
    }
    private boolean checkBoardFill(){
        return gameCount == board.getBoard().length * board.getBoard()[0].length;
    }
}
