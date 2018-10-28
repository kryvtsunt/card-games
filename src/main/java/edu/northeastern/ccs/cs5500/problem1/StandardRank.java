package edu.northeastern.ccs.cs5500.problem1;

/**
 * StandardRank is an implementation of the Rank.
 * StandardRank is one of:
 * - TWO
 * - THREE
 * - FOUR
 * - FIVE
 * - SIX
 * - SEVEN
 * - EIGHT
 * - NINE
 * - TEN
 * - JACK
 * - QUEEN
 * - KING
 * - ACE
 *
 * @author Tymofii Kryvtsun
 */
public enum StandardRank implements Rank {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 0),
    QUEEN("Q", 0),
    KING("K", 0),
    ACE("A", 0);

    /**
     * symbol[String] field is a String representation of a certain Rank.
     */
    private final String symbol;
    /**
     * pip[int] field is a number of pips for certain Rank.
     */
    private final int pip;

    /**
     * Constructor.
     *
     * @param symbol string representation of the Rank
     * @param pip    number of pips
     */
    StandardRank(String symbol, int pip) {
        this.symbol = symbol;
        this.pip = pip;
    }

    @Override
    public String getName() {
        return this.symbol;
    }

    @Override
    public int getPips() {
        return this.pip;
    }
}