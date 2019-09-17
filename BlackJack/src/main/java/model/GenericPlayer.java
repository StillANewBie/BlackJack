package model;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericPlayer {

    private int score;
    private int cumulativeScore;
    private int numOfAce;
    private List<Card> cardsOnBoard;

    public GenericPlayer() {
        this.cardsOnBoard = new ArrayList<Card>();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public List<Card> getCardsOnBoard() {
        return cardsOnBoard;
    }

    public void setCardsOnBoard(List<Card> cardsOnBoard) {
        this.cardsOnBoard = cardsOnBoard;
    }
}
