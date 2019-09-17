package model;

public class Dealer {

    private Card cardHidden;

    public Dealer() {
        super();
        this.cardHidden = null;
    }

    public Card getCardHidden() {
        return cardHidden;
    }

    public void setCardHidden(Card cardHidden) {
        this.cardHidden = cardHidden;
    }
}
