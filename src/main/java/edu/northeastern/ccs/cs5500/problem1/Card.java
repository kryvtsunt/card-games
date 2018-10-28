package edu.northeastern.ccs.cs5500.problem1;

/**
 * Represents a playing card with a Suit and a Rank.
 *
 * @author Tymofii Kryvtsun
 */
public interface Card {
    /**
     * Gets the Card's Rank.
     *
     * @return Card's Rank.
     */
    Rank getRank();

    /**
     * Gets the Card's Suit.
     *
     * @return Card's Suit.
     */
    Suit getSuit();
}

