package service;

import model.Card;
import model.Dealer;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private List<Card> cards;
    private DealerService dealer;
    private List<PlayerService> players;

    public GameService() {
        this.dealer = new DealerService(new Dealer());
        this.players = new ArrayList<>();

        initGame();
    }

    public void initDecks(int num) {
        this.cards = DeckService.initDeck(num);
    }

    // for one player only.
    public void initPlayer(String name) {
        this.players.add(new PlayerService(new Player(0, name)));
    }

//    // for multiple players
//    public GameService(int numDeck, List<String> name) {
//
//    }

    public void initGame() {
        // TODO
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public DealerService getDealer() {
        return dealer;
    }

    public void setDealer(DealerService dealer) {
        this.dealer = dealer;
    }

    public List<PlayerService> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerService> players) {
        this.players = players;
    }

    public String dealerHit() {

        // TODO
        return null;
    }

    public String playerHit() {
        //TODO
        return null;
    }

    public void setCumulativeScores() {
        // TODO
    }

    public static void main(String[] args) {

    }
}
