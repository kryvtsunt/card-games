package edu.northeastern.ccs.cs5500.problem1;

import java.util.Objects;

/**
 * StandardCard is simple Card implementation. It onsists of StandardSuit and StandardRank
 *
 * @author Tymofii Krytsun
 */
public class StandardCard implements Card {

    /**
     * the field standardSuit[StandardSuit] represents a card suit
     * the field value[StandardRank] represents a card rank/value
     */
    private final StandardSuit suit;
    private final StandardRank rank;

    /**
     * Constructor for the StandardCard.
     *
     * @param standardSuit - card suit
     * @param standardRank - card rank
     */
    public StandardCard(StandardSuit standardSuit, StandardRank standardRank) {
        this.suit = standardSuit;
        this.rank = standardRank;
    }

    @Override
    public String toString() {
        return this.rank.getName() + this.suit.getSymbol();
    }


    /**
     * Method CardRank() gets the value of the StandardCard.
     *
     * @return [StandardRank] value of the card
     */
    @Override
    public StandardRank getRank() {
        return this.rank;
    }

    /**
     * Method getType() gets the type of the StandardSuit.
     *
     * @return [StandardSuit] standardSuit of the card
     */
    @Override
    public StandardSuit getSuit() {
        return this.suit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StandardCard)) {
            return false;
        }
        Card sc = (Card) o;
        return (sc.getRank().equals(this.getRank()) && sc.getSuit().equals(this.getSuit()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getRank(), this.getSuit());
    }


}
