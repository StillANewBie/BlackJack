package service;

import model.Card;
import model.GenericPlayer;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericPlayerService {
    private GenericPlayer player;

    public GenericPlayerService(GenericPlayer player) {
        this.player = player;
        initPlayer();
    }

    public void initPlayer() {
        newGame();
        clearScore();
        clearNumOfAce();
        clearCumulativeScore();
    }

    public void newGame() {
        getPlayer().setCardsOnBoard(new ArrayList<Card>());
    }

    public GenericPlayer getPlayer() {
        return player;
    }

    public void setPlayer(GenericPlayer player) {
        this.player = player;
    }

    public int getCumulativeScore() {
        return this.player.getCumulativeScore();
    }

    public void setCumulativeScore(int value) {
        this.player.setCumulativeScore(getCumulativeScore() + value);
    }

    public int getScore() {
        return this.player.getScore();
    }

    public void setScore(int score) {
        this.player.setScore(score);
    }

    public int getNumOfAce() {
        return this.player.getNumOfAce();
    }

    public void setNumOfAce(int value) {
        this.player.setNumOfAce(value);
    }

    public List<Card> getCardsOnBoard() {
        return this.player.getCardsOnBoard();
    }

    public void setCardsOnBoard(List<Card> cards) {
        this.player.setCardsOnBoard(cards);
    }

    public void clearCumulativeScore() {
        setCumulativeScore(0);
    }

    public void clearNumOfAce() {
        setNumOfAce(0);
    }

    public void clearScore() {
        setScore(0);
    }

    public String hit(Card card) {


        return null;
    }

    String validateBeforeHit() {

        return null;
    }

    String validateAfterHit() {

        return null;
    }

    public void printCardsOnBoard(String name) {
        System.out.println(name + ": ");
        DeckService.printExistingCards(getCardsOnBoard());
    }
}
