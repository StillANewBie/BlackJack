package service;

import model.Card;
import model.Dealer;
import model.Player;

import java.util.ArrayList;
import java.util.List;

import static factory.ConstantsFactory.NUM_DECK;

public class GameService {

    private List<Card> cards;
    private DealerService dealer;
    private List<PlayerService> players;

    // for single player only
    public GameService() {
        this.dealer = new DealerService(new Dealer());
        this.players = new ArrayList<>();
        this.players.add(new PlayerService(new Player(0, "Player 1")));
        this.cards = DeckService.initDeck(NUM_DECK);

        initGame();
    }

//    public void initDecks(int num) {
//        this.cards = DeckService.initDeck(num);
//    }

    // for single player only.
    public void initPlayer(String name) {
        this.players.get(0).setName(name);
    }

//    // for multiple players
//    public GameService(int numDeck, List<String> name) {
//
//    }

    public Card serveCard() {
        return getCards().remove(0);
    }

    public void initGame() {
        getDealer().newGame();
        getPlayers().get(0).newGame();
        dealer.setCardHidden(serveCard());
        players.get(0).hit(serveCard());
        dealer.hit(serveCard());
        players.get(0).hit(serveCard());
        dealer.printCardsOnBoard();
        players.get(0).printCardsOnBoard();
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
