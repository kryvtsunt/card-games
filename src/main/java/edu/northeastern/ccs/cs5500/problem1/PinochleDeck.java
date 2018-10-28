package edu.northeastern.ccs.cs5500.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * A pinochle deck, which is composed 9, 10, J, Q, K, and A of the four suits, but there are two copies
 * of each suit. There are 48 cards in total.
 *
 * @author Tymofii Kryvtsun
 */
public class PinochleDeck extends AbstractDeck {

    /**
     * The list of Cards (actual deck).
     */
    private List<Card> deck;
    /**
     * The official size of the Deck of given type.
     */
    private final int size;

    /**
     * Constructor.
     */
    public PinochleDeck() {
        this.deck = new ArrayList<>();
        for (int n = 0; n < 2; n++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 7; j < 13; j++) {
                    deck.add(new StandardCard(StandardSuit.values()[i], StandardRank.values()[j]));
                }
            }
        }
        this.size = deck.size();

    }

    @Override
    protected List<Card> getDeck() {
        return this.deck;
    }

    @Override
    protected int getSize() {
        return this.size;
    }
}
