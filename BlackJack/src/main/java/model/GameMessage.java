package model;

import java.util.List;

// for future use (replace string and prepare for restful)
public class GameMessage extends Message {

    private List<Card> cardList1;
    private List<Card> cardList2;

    public GameMessage(GameMessageType messageType) {
        super(messageType);
    }

    public GameMessage(GameMessageType messageType, List<Card> cardList1) {
        super(messageType);
        this.cardList1 = cardList1;
    }

    public GameMessage(GameMessageType messageType, List<Card> cardList1, List<Card> cardList2) {
        super(messageType);
        this.cardList1 = cardList1;
        this.cardList2 = cardList2;
    }

    public List<Card> getCardList1() {
        return cardList1;
    }

    public void setCardList1(List<Card> cardList1) {
        this.cardList1 = cardList1;
    }

    public List<Card> getCardList2() {
        return cardList2;
    }

    public void setCardList2(List<Card> cardList2) {
        this.cardList2 = cardList2;
    }
}
