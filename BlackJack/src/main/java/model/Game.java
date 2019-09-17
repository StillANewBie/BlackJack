package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Card> cards;
    private List<Player> players;
    private Dealer dealer;
    private int numDeck;

    public Game(int numDeck, Player player, Dealer dealer) {
        this.players = new ArrayList<>();
        this.players.add(player);
        this.dealer = dealer;
        this.numDeck = numDeck;
        this.cards = new ArrayList<>();
    }

    public Game(int numDeck, List<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        this.numDeck = numDeck;
        this.cards = new ArrayList<>();
    }

    public int getNumDeck() {
        return numDeck;
    }

    public void setNumDeck(int numDeck) {
        this.numDeck = numDeck;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}
