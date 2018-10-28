package edu.northeastern.ccs.cs5500.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * A Vegas blackjack deck. It's composed of two or more standard decks. Typically it's six to eight
 * decks.
 *
 * @author Tymofii Kryvtsun
 */
public class VegasDeck extends AbstractDeck {

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
     *
     * @param numberOfDecks number of standard deck added together.
     */
    public VegasDeck(int numberOfDecks) {
        if (numberOfDecks <= 1 || numberOfDecks > 8) {
            throw new IllegalArgumentException("Vegas deck should be of 2-8 standard decks");
        }
        this.deck = new ArrayList<>();
        for (int n = 0; n < numberOfDecks; n++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
                    deck.add(new StandardCard(StandardSuit.values()[i], StandardRank.values()[j]));
                }
            }
        }
        this.size = deck.size();

    }

    /**
     * Constructor.
     */
    public VegasDeck() {
        this.deck = new ArrayList<>();
        for (int n = 0; n < 6; n++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
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
