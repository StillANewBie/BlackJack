package model;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericPlayer {

    private int hiScore;
    private int lowScore;
    private int scoreWithoutA;
    private int cumulativeScore;
    private int numOfAce;
    private List<Card> cardsOnBoard;

    public GenericPlayer() {
        this.cardsOnBoard = new ArrayList<Card>();
    }

    public int getCumulativeScore() {
        return cumulativeScore;
    }

    public void setCumulativeScore(int cumulativeScore) {
        this.cumulativeScore = cumulativeScore;
    }

    public int getNumOfAce() {
        return numOfAce;
    }

    public void setNumOfAce(int numOfAce) {
        this.numOfAce = numOfAce;
    }

    public int getHiScore() {
        return hiScore;
    }

    public void setHiScore(int hiScore) {
        this.hiScore = hiScore;
    }

    public int getLowScore() {
        return lowScore;
    }

    public void setLowScore(int lowScore) {
        this.lowScore = lowScore;
    }

    public int getScoreWithoutA() {
        return scoreWithoutA;
    }

    public void setScoreWithoutA(int scoreWithoutA) {
        this.scoreWithoutA = scoreWithoutA;
    }

    public List<Card> getCardsOnBoard() {
        return cardsOnBoard;
    }

    public void setCardsOnBoard(List<Card> cardsOnBoard) {
        this.cardsOnBoard = cardsOnBoard;
    }
}
