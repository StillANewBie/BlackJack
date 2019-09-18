import model.Result;
import service.GameService;

import java.util.Scanner;

import static factory.ConstantsFactory.*;

public class GameController {

    private GameService gs;

    public static void main(String[] args) throws InterruptedException {
        GameController gc = new GameController();
        gc.init();
    }

    public void init() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        gs = new GameService(name);
        startGame();

        while (!scanner.nextLine().equals("exit")) {
            gs = new GameService(name);
            startGame();
        }
    }

    public void startGame() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String messageDealer = gs.dealerHit();
        String messagePlayer = null;
        String responsePlayer = "y";
        while (messagePlayer == null && responsePlayer.equals("y")) {
            System.out.println("Do you still want to hit a card? press 'y' to hit.");
            if (responsePlayer.equals("y")) {
                responsePlayer = scanner.nextLine().toLowerCase();
                if (responsePlayer.equals("y")) {
                    messagePlayer = gs.playerHit();
                } else {
                    System.out.println(gs.getPlayers().get(0).getName() + " holds");
                }
            }
            messageDealer = gs.dealerHit();

            if (messageDealer != null && !responsePlayer.toLowerCase().equals("y")) {
                if (!responsePlayer.equals("y") && messageDealer.equals(HOLD)) {
                    int comp = gs.getDealer().getHiScore() - gs.getPlayers().get(0).getHiScore();
                    if (comp < 0) {
                        gs.setCumulativeScores(Result.PLAYERWIN1);
                    } else {
                        // dealer wins if both have the same points which are not equal to 21
                        gs.setCumulativeScores(Result.DEALERWIN1);
                    }
                } else if (messageDealer.equals(BUSTED)) {
                    if (gs.getPlayers().get(0).getCardsOnBoard().size() == 2) {
                        gs.setCumulativeScores(Result.PLAYERWIN2);
                    } else {
                        gs.setCumulativeScores(Result.PLAYERWIN1);
                    }
                } else if (messagePlayer.equals(BUSTED)) {
                    if (gs.getDealer().getCardsOnBoard().size() == 1) {
                        gs.setCumulativeScores(Result.DEALERWIN2);
                    } else {
                        gs.setCumulativeScores(Result.DEALERWIN1);
                    }
                } else if (messageDealer.equals(GOAL) && messagePlayer.equals(GOAL)) {
                    gs.setCumulativeScores(Result.DRAW);
                } else if (messagePlayer.equals(GOAL)) {
                    gs.setCumulativeScores(Result.PLAYERWIN1);
                } else if (messageDealer.equals(GOAL)) {
                    gs.setCumulativeScores(Result.DEALERWIN1);
                }

                System.out.println("Game over");
                System.out.println("Enter 'exit' to exit, otherwise the game will start.");
                break;
            }
        }
    }
}
