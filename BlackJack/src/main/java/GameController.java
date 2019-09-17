import service.GameService;

public class GameController {

    private static GameService gs = null;

    public static GameService getGs() {
        if (gs == null) {
            gs = new GameService();
        }
        return gs;
    }

    public static void main(String[] args) {
        getGs().initPlayer("################");
        getGs().getDealer().printCardsOnBoard();
        getGs().getPlayers().get(0).printCardsOnBoard();
        System.out.println(getGs().getPlayers().get(0).getHiScore());
    }
}
