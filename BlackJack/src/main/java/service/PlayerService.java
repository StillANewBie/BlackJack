package service;

import model.Card;
import model.GenericPlayer;
import model.Player;
import model.Rank;

public class PlayerService extends GenericPlayerService {

    public PlayerService(GenericPlayer player) {
        super(player);
    }

    public int getOrder() {
        return ((Player) getPlayer()).getOrder();
    }

    public void setOrder(int order) {
        ((Player) getPlayer()).setOrder(order);
    }

    public String getName() {
        return ((Player) getPlayer()).getName();
    }

    public void setName(String name) {
        ((Player) getPlayer()).setName(name);
    }


    public String hit(Card card) {

        String result = validateBeforeHit();
        if (result != null) return result;

        getCardsOnBoard().add(card);

        System.out.println(getName() + " hit ...");

        printCardsOnBoard();

        return validateAfterHit();
    }

    @Override
    public void printCardsOnBoard() {
        System.out.println( getName() + ":");
        super.printCardsOnBoard();
    }

    public static void main(String[] args) {
    }
}
