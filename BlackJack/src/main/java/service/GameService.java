package service;

import model.Card;
import model.Dealer;
import model.Player;
import model.Result;

import java.util.ArrayList;
import java.util.List;

import static factory.ConstantsFactory.*;

public class GameService {

    private List<Card> cards;
    private DealerService dealer;
    private List<PlayerService> players;

    // for single player only
    public GameService(String name) throws InterruptedException {
        this.dealer = new DealerService(new Dealer());
        this.players = new ArrayList<>();
        this.players.add(new PlayerService(new Player(0, name)));
        this.cards = DeckService.initDeck(NUM_DECK);

        initGame();
    }

//    public void initDecks(int num) {
//        this.cards = DeckService.initDeck(num);
//    }

//    // for multiple players
//    public GameService(int numDeck, List<String> name) {
//
//    }

    public Card serveCard() {
        return getCards().remove(0);
    }

    public void initGame() throws InterruptedException {
        getDealer().newGame();
        getPlayers().get(0).newGame();
        dealer.setCardHidden(serveCard());
        players.get(0).hit(serveCard());

        Thread.sleep(500);

        dealer.hit(serveCard());

        Thread.sleep(500);

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

    public String dealerHit() throws InterruptedException {
        String message = null;

        // from dealer rules
        if (getDealer().getHiScore() < DEALER_LOW_HIT
                || getDealer().getHiScore() < players.get(0).getHiScore()
                || (getDealer().getNumOfAce() > 0 && getDealer().getHiScore() > getDealer().getLowScore()
                && getDealer().getHiScore() < DEALER_HIGH_ACE_HIT)) {
            message = getDealer().hit(serveCard());
            if (message != null) {
                if (message.equals(BUSTED)) {
                    System.out.println("Dealer busted. You win.");

                    Thread.sleep(500);

                    System.out.println("Start next game ...");
                } else if (message.equals(GOAL)) {
                    System.out.println("Dealer reaches GOAL.");
                }
            }

            return message;
        }

        return HOLD;
    }

    public String playerHit() throws InterruptedException {
        String message = getPlayers().get(0).hit(serveCard());
        if (message != null) {
            if (message.equals(BUSTED)) {
                System.out.println(getPlayers().get(0).getName() + " busted.");

                Thread.sleep(500);

                System.out.println("Start next game ...");
            } else if (message.equals(GOAL)) {
                System.out.println("Dealer reaches GOAL.");
            }
        }

        return message;
    }

    public void setCumulativeScores(Result res) {
        switch (res) {
            case PLAYERWIN1:
                getPlayers().get(0).setCumulativeScore(1);
                System.out.println(getPlayers().get(0).getName() + "wins");
                break;
            case DEALERWIN1:
                getDealer().setCumulativeScore(1);
                System.out.println("Dealer wins");
                break;
            case PLAYERWIN2:
                getPlayers().get(0).setCumulativeScore(2);
                System.out.println(getPlayers().get(0).getName() + "wins");
                break;
            case DEALERWIN2:
                getDealer().setCumulativeScore(2);
                System.out.println("Dealer wins");
                break;
            case DRAW:
                getDealer().setCumulativeScore(1);
                getPlayers().get(0).setCumulativeScore(1);
                System.out.println("Draw");
        }

        System.out.println("Dealer: " + getDealer().getCumulativeScore());
        System.out.println(getPlayers().get(0).getName() + ": " + getPlayers().get(0).getCumulativeScore());
    }

    public static void main(String[] args) {
    }
}
