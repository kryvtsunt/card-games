package edu.northeastern.ccs.cs5500.problem1;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * This is a helper/utill class to deal with different card operations.
 *
 * @author Tymofii Kryvtsun
 */
public final class CardUtils {

    /**
     * Actual sorting implementation for Deck and Hand.
     *
     * @param str   sorting type (look up in Deck/Hand description).
     * @param cards list of Cards to sort.
     * @return sorted list of Cards.
     */
    public static List<Card> sort(String str, List<Card> cards) {
        if ((cards == null) || (str == null)) {
            throw new IllegalArgumentException("NULL argument");
        } else {
            if (str.equalsIgnoreCase("BYSUIT")) {
                Collections.sort(cards, new SortbySuit());

            } else if (str.equalsIgnoreCase("BYRANK")) {
                Collections.sort(cards, new SortbyRank());

            } else if (str.equalsIgnoreCase("BOTH")) {
                Collections.sort(cards, new SortBothSuit());

            } else if (str.equalsIgnoreCase("BOTH2")) {
                Collections.sort(cards, new SortBothRank());
            } else {
                throw new IllegalArgumentException("Sorting option is incorrect");
            }

        }
        return cards;
    }

    /**
     * Card Comparator (compare by rank).
     */
    private static class SortbyRank implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            StandardRank rank1 = (StandardRank) card1.getRank();
            StandardRank rank2 = (StandardRank) card2.getRank();
            return rank1.compareTo(rank2);
        }
    }

    /**
     * Card Comparator (compare by suit).
     */
    private static class SortbySuit implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            StandardSuit suit1 = (StandardSuit) card1.getSuit();
            StandardSuit suit2 = (StandardSuit) card2.getSuit();
            return suit1.compareTo(suit2);
        }
    }

    /**
     * Card Comparator (compare by suit and rank).
     */
    private static class SortBothSuit implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            StandardRank rank1 = (StandardRank) card1.getRank();
            StandardRank rank2 = (StandardRank) card2.getRank();
            StandardSuit suit1 = (StandardSuit) card1.getSuit();
            StandardSuit suit2 = (StandardSuit) card2.getSuit();
            if (suit1.compareTo(suit2) == 0) {
                return rank1.compareTo(rank2);
            } else {
                return suit1.compareTo(suit2);

            }
        }
    }

    /**
     * Card Comparator (compare by rank and suit).
     */
    private static class SortBothRank implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            StandardRank rank1 = (StandardRank) card1.getRank();
            StandardRank rank2 = (StandardRank) card2.getRank();
            StandardSuit suit1 = (StandardSuit) card1.getSuit();
            StandardSuit suit2 = (StandardSuit) card2.getSuit();
            if (rank1.compareTo(rank2) == 0) {
                return suit1.compareTo(suit2);
            } else {
                return rank1.compareTo(rank2);

            }
        }
    }
}
