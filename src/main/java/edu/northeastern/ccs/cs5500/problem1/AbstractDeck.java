package edu.northeastern.ccs.cs5500.problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Deck Abstraction. Implements all same features of all decks.
 *
 * @author Tymofii Kryvtsun
 */
abstract class AbstractDeck implements Deck {

    /**
     * Get the List of cards from the actual Deck.
     *
     * @return list of cards (actual deck)
     */
    protected List<Card> getDeck() {
        return null;
    }

    /**
     * Set the list of cards for the actual Deck.
     *
     * @param cards list of cards for a deck
     */
    protected void setDeck(List<Card> cards) {
    }

    /**
     * Get the official size of the actual Deck.
     *
     * @return size of the actual Deck.
     */
    protected int getSize() {
        return -1;
    }


    @Override
    public List<Card> getCards() {
        return new ArrayList<Card>(this.getDeck());
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.getDeck());
    }

    @Override
    public void sort(String str) {
        this.setDeck(CardUtils.sort(str, getDeck()));
    }

    @Override
    public void cut(int index) throws IllegalAccessException {
        List<Card> deck = getDeck();
        if (deck == null) {
            throw new IllegalArgumentException("NULL argument");
        } else {
            if (index >= 0 && index < deck.size()) {
                for (int i = 0; i < index; i++) {
                    Card c = deck.remove(0);
                    deck.add(c);
                }
            } else throw new IllegalAccessException("Out of bounds");
        }
    }

    @Override
    public Card pullCard() throws NullPointerException {
        List<Card> deck = getDeck();
        if (deck == null) {
            throw new IllegalArgumentException("NULL argument");
        } else {
            if (deck.size() > 0) {
                return deck.remove(deck.size() - 1);
            } else throw new NullPointerException("Deck is empty");
        }
    }

    @Override
    public Boolean emptyDeck() {
        List<Card> deck = getDeck();
        if (deck == null) {
            throw new IllegalArgumentException("NULL argument");
        } else {
            return (deck.size() == 0);
        }
    }

    @Override
    public int officialSize() {
        return this.getSize();
    }

    @Override
    public String toString() {
        return this.getDeck().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deck)) {
            return false;
        }
        Deck d = (Deck) o;
        return (CardUtils.sort("BOTH", this.getCards()).equals(CardUtils.sort("BOTH", d.getCards())) &&
                d.officialSize() == this.officialSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCards(), this.officialSize());
    }

}
