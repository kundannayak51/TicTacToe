import mode.ConsolePrint;
import model.Board;
import model.Player;
import service.TicTacToeService;
import validations.GameValidator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board =  new Board(3);

        Player player1 = new Player(1,"Player1","O");
        Player player2 = new Player(2,"Player2","X");
        List<Player> players = Arrays.asList(player1, player2);
        HashMap<Integer,Boolean> playerCheck = new HashMap<>();
        playerCheck.put(player1.getId(), true);
        playerCheck.put(player2.getId(), true);
        GameValidator gameValidator = new GameValidator(board, playerCheck);
        TicTacToeService ticTacToeService = new TicTacToeService(board, gameValidator, players, new ConsolePrint());

        while (true) {
            System.out.println("Choose Input 1: play 2: Exit");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Please Enter Your ID");
                    Player player = players.get(scanner.nextInt()-1);
                    System.out.println("Enter Your Move X and Y");
                    ticTacToeService.input(scanner.nextInt(),scanner.nextInt(),player);
                    break;
                case 2: System.exit(0);
                    break;
                default:
                    System.out.println("Choose 1");
                    break;
            }

        }


    }
}
