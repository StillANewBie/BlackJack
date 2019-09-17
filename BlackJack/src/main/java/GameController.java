import service.GameService;

public class GameController {

    private static GameService gs = null;

    public static GameService getGs() {
        if (gs == null) {
            gs = new GameService();
        }
        return gs;
    }


}
