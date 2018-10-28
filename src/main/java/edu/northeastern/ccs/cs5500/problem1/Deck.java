package edu.northeastern.ccs.cs5500.problem1;

import java.util.List;

/**
 * Represents a Deck of Cards (stack) in the Card Game.
 *
 * @author Tymofii Kryvtsun
 */
public interface Deck {
    /**
     * Gets a copy of the list of Cards that the deck contains.
     *
     * @return list of cards (all cards that deck has).
     */
    List<Card> getCards();

    /**
     * Shuffles all cards in the deck.
     */
    void shuffle();

    /**
     * Sort all Cards in Deck. There are 4 self-explaining ways to sort cards:
     * <ul>
     * <li>byRank</li>
     * <li>bySuit</li>
     * <li>both (by suit and rank (suit is prioritized)</li>
     * <li>both2 (by rank and suit (rank is prioritized)</li>
     * </ul>
     *
     * @param guidance defines a way of sorting.
     */
    void sort(String guidance);

    /**
     * A point in the deck is selected and 1st half of the deck {card1. . .
     * cardselected-1} is placed at the end of the deck in order. That is, the 1rst card in the deck is now cardselected;
     * the 1rst card after the original end card is now card1. Card2 follows card1 and so forth up to cardselected-1.
     *
     * @param cutPoint defines the cut point (new top Card of the deck) .
     * @throws IllegalAccessException when the cut point (chosen Card) is out of bounds.
     */
    void cut(int cutPoint) throws IllegalAccessException;

    /**
     * Removes the top card from the deck.
     *
     * @return top (first) card of the deck.
     * @throws IllegalAccessException when the deck is empty.
     */
    Card pullCard() throws IllegalAccessException;

    /**
     * Checks whether deck is empty (no cards left).
     *
     * @return true if deck is empty; false if deck is not empty.
     */
    Boolean emptyDeck();

    /**
     * Provides an official size of the Deck (th initial size of the deck before any card was pulled).
     *
     * @return the size of the deck.
     */
    int officialSize();
}
