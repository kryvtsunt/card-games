package edu.northeastern.ccs.cs5500.problem1;

import java.util.List;

/**
 * Represents a Player of the Card Game
 *
 * @author Tymofii Kryvtsun
 */
public interface Hand {
    /**
     * Player shows his cards.
     *
     * @return a copy of the Cards at Hand.
     */
    List<Card> showCards();

    /**
     * Player takes a card (usually from the deck), and puts it to his Hand.
     *
     * @param card the Card user should accept.
     */
    void accept(Card card);

    /**
     * Player removes the first (top) card from his hand.
     *
     * @return the top Card of the Hand.
     * @throws NullPointerException when the Hand is empty (Player has no Cards).
     */
    Card pullCard();

    /**
     * Checkes whether player has a particular Card.
     *
     * @param cardToFind Card to look for in player's hand.
     * @return true if the card is present, false if user does not have the card.
     */
    Boolean hasCard(Card cardToFind);

    /**
     * Sort Cards in player's Hand. There are 4 self-explaining ways to sort cards:
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
     * Shuffles Cards in player's Hand.
     */
    void shuffle();

    void removeCard(Card card);
}
