import model.Result;
import service.GameService;

import java.util.Scanner;

public class GameController {

    private static GameService gs = null;

    public static GameService getGs() {
        if (gs == null) {
            gs = new GameService();
        }
        return gs;
    }

    public static void init() {
        // TODO
        startGame();
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String messageDealer = gs.dealerHit();
        String messagePlayer = null;
        String responsePlayer = "y";
        while (messageDealer == null && messagePlayer == null) {
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
                if (messageDealer.equals("BUSTED")) {
                    if (gs.getPlayers().get(0).getCardsOnBoard().size() == 2) {
                        gs.setCumulativeScores(Result.PLAYERWIN2);
                    } else {
                        gs.setCumulativeScores(Result.PLAYERWIN1);
                    }
                } else if (messagePlayer.equals("BUSTED")) {
                    if (gs.getDealer().getCardsOnBoard().size() == 1) {
                        gs.setCumulativeScores(Result.DEALERWIN2);
                    } else {
                        gs.setCumulativeScores(Result.DEALERWIN1);
                    }
                }

                System.out.println(gs.getPlayers().get(0).getName() + ": " + gs.getPlayers().get(0).getCumulativeScore());
                System.out.println("Dealer: " + gs.getDealer().getCumulativeScore());
                System.out.println("Game over");
                System.out.println("Enter 'exit' to exit, otherwise the game will start.");
            }
        }
    }

    public static void main(String[] args) {
        getGs().initPlayer("################");
        init();
    }
}
