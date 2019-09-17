package service;

import model.Card;
import model.GenericPlayer;
import model.Rank;

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
        int sum = this.player.getCardsOnBoard()
                .stream().filter(el -> !el.getRank().getDisplayValue().equals(Rank.ACE))
                .mapToInt(el -> el.getRank().getValue()).sum();

        return sum;
    }

    public int getHiScore() {
        if (getNumOfAce() < 1) {
            return getScoreWithoutA();
        }
        int max = getScoreWithoutA() + ACE_HIGH_VALUE + getNumOfAce() - 1;
        int value = max > 21 ? getScoreWithoutA() + getNumOfAce() : max;

        return value;
    }

    public int getLowScore() {
        return getNumOfAce() + getScoreWithoutA();
    }

    public void setHiScore(int num) {
        this.player.setHiScore(num);
    }

    public void setLowScore(int num) {
        this.player.setLowScore(num);
    }

    public int getNumOfAce() {
        return getCardsOnBoard().stream().filter(el -> el.getRank().getDisplayValue().equals(Rank.ACE)).toArray().length;
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

    public void printCardsOnBoard() {
        DeckService.printExistingCards(getCardsOnBoard());
    }
}
