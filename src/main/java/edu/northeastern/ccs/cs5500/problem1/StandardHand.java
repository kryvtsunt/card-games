package edu.northeastern.ccs.cs5500.problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A simple implementation of the Hand that follow all basic instructions of the interface.
 *
 * @author Tymofii Kryvtsun
 */
public class StandardHand implements Hand {

    /**
     * List of Cards in Players disposal.
     */
    private List<Card> cards;

    /**
     * Constructor.
     */
    public StandardHand() {
        this.cards = new ArrayList<>();
    }

    @Override
    public List<Card> showCards() {
        return new ArrayList<>(this.cards);
    }

    @Override
    public void accept(Card card) {
        this.cards.add(card);
    }

    @Override
    public Card pullCard() throws NullPointerException {
        if (this.cards.size() > 0) {
            return this.cards.remove(cards.size() - 1);
        } else {
            throw new NullPointerException("No cards");
        }
    }

    @Override
    public Boolean hasCard(Card cardToFind) {
        return this.cards.contains(cardToFind);
    }

    @Override
    public void sort(String str) {
        this.cards = CardUtils.sort(str, this.cards);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    @Override
    public void removeCard(Card card) {
        cards.remove(card);
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Hand)) {
            return false;
        }
        Hand h = (Hand) o;
        return (CardUtils.sort("BOTH", this.showCards()).equals(CardUtils.sort("BOTH", h.showCards())));

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cards);
    }
}
