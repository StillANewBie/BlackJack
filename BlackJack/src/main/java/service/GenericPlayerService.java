package service;

import model.Card;
import model.GenericPlayer;

import java.util.ArrayList;
import java.util.List;

import static factory.ConstantsFactory.ACE_HIGH_VALUE;

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

    public int getScoreWithoutA() {
        return this.player.getScoreWithoutA();
    }

    public void setScoreWithoutA(int value) {
        this.player.setScoreWithoutA(value);
    }

    public int getHiScore() {
        return this.player.getHiScore();
    }

    public int getLowScore() {
        return this.player.getLowScore();
    }

    public void setHiScore(int num) {
        this.player.setHiScore(num);
    }

    public void setLowScore(int num) {
        this.player.setLowScore(num);
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
        setHiScore(0);
        setLowScore(0);
        setScoreWithoutA(0);
    }

    public String hit(Card card) {
        // TODO
        return null;
    }

    String validateBeforeHit() {
        // TODO
        return null;
    }

    String validateAfterHit() {
        // TODO
        return null;
    }

    public void calcLowScore() {
        setLowScore(getNumOfAce() + getScoreWithoutA());
    }

    public void calcHighScore() {
        //TODO
    }

    public void printCardsOnBoard() {
        DeckService.printExistingCards(getCardsOnBoard());
    }
}
