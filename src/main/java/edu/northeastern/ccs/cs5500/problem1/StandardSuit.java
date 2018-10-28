package edu.northeastern.ccs.cs5500.problem1;

/**
 * StandardSuit is an implementation of the Suit.
 * StandardSuit is one of:
 * - CLUBS
 * - DIAMONDS
 * - HEARTS
 * - SPADES.
 *
 * @author Tymofii Kryvtsun
 */

public enum StandardSuit implements Suit {
    CLUBS('♣'),
    DIAMONDS('♦'),
    HEARTS('♥'),
    SPADES('♠');

    /**
     * suit[char] a field is a char representation of a certain Suit.
     */
    private final char suit;

    /**
     * Constructor
     *
     * @param suit character to represent a sut
     */
    StandardSuit(char suit) {
        this.suit = suit;
    }

    @Override
    public char getSymbol() {
        return suit;
    }

    @Override
    public String getName() {
        return this.name();
    }


}
