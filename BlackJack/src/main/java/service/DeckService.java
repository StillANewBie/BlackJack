package service;

import factory.ConstantsFactory;
import model.Card;
import model.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckService {

    public static List<Card> initDeck(int numDeck) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < numDeck; i++) {
            Deck deck = new Deck();
            cards.addAll(deck.getCards());
        }

        shuffle(cards);

        return cards;
    }

    public static void shuffle(List<Card> cards) {
        Random rand = new Random();
        for (int i = 0; i < ConstantsFactory.SHUFFLE_TIMES; i++) {
            for (int j = 0; j < cards.size(); j++) {
                int tmpIndex = rand.nextInt(cards.size());
                cards.add(tmpIndex, cards.remove(i));
            }
        }
    }

    public static void printExistingCards(List<Card> cards) {
        cards.forEach(el -> System.out.print(el.toString() + "\t"));
        System.out.println();
    }

    public static void main(String[] args) {
        printExistingCards(initDeck(1));
    }
}
