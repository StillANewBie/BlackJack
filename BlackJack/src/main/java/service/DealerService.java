package service;

import model.Card;
import model.Dealer;
import model.GenericPlayer;

public class DealerService extends GenericPlayerService {

    public DealerService(GenericPlayer player) {
        super(player);
    }

    public Card getCardHidden() {
        return ((Dealer) getPlayer()).getCardHidden();
    }

    public void setCardHidden(Card card) {
        ((Dealer) getPlayer()).setCardHidden(card);
    }

    @Override
    public void printCardsOnBoard() {
        System.out.println("Dealer:");
        super.printCardsOnBoard();
    }
}
