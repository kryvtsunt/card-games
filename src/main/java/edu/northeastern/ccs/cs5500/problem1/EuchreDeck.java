package edu.northeastern.ccs.cs5500.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * A Euchre deck, which is composed of 9, 10, J, Q, K, and A of the four suits  24 cards in total.
 *
 * @author Tymofii Kryvtsun
 */
public final class EuchreDeck extends AbstractDeck {
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
    public EuchreDeck() {
        this.deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 7; j < 13; j++) {
                deck.add(new StandardCard(StandardSuit.values()[i], StandardRank.values()[j]));
            }
        }
        this.size = this.deck.size();
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
