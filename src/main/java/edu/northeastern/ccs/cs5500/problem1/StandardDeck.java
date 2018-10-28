package edu.northeastern.ccs.cs5500.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * A Standard deck representation contains all possible playing cards (all combinations of Suit and Rank)
 * without any duplication (52 cards in total).
 *
 * @author Tymofii Kryvtsun
 */
public final class StandardDeck extends AbstractDeck {
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
    public StandardDeck() {
        this.deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new StandardCard(StandardSuit.values()[i], StandardRank.values()[j]));
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

    @Override
    protected void setDeck(List<Card> cards) {
        this.deck = cards;
    }

}
