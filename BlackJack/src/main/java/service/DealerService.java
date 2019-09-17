package service;

import model.Card;
import model.Dealer;
import model.GenericPlayer;
import model.Rank;

import static factory.ConstantsFactory.GAME_GOAL;

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

    public String hit(Card card) {

        String result = validateBeforeHit();
        if (result != null) return result;

        getCardsOnBoard().add(card);

        System.out.println("Dealer hit ...");

        printCardsOnBoard();

        return validateAfterHit();
    }

    @Override
    public int getHiScore() {
        return super.getHiScore() + getCardHidden().getRank().getValue();
    }

    @Override
    public int getLowScore() {
        return super.getLowScore() + getCardHidden().getRank().getValue();
    }

    @Override
    public void printCardsOnBoard() {
        System.out.println("Dealer: ");

        // hidden card
        System.out.print("Card *******\t");
        super.printCardsOnBoard();
    }
}
