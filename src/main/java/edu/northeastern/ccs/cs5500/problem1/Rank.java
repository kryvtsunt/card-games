package edu.northeastern.ccs.cs5500.problem1;

/**
 * Represents a rank of the Card.
 *
 * @author Tymofii Kryvtsun
 */
public interface Rank {
    /**
     * Gets Card's name
     *
     * @return the name of the Card
     */
    String getName();

    /**
     * Gets the number of Card's pips
     *
     * @return the number of the pips on the Card
     */
    int getPips();
}
