package edu.northeastern.ccs.cs5500.problem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * tests for the Card implementation
 *
 * @author Tymofii Kryvtsun
 */
public class CardTest {

    private List<Card> cards;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private Card card6;
    private Card card7;

    /**
     * tests card construction
     * (all possible cards are constructed successfully)
     */
    @Before
    public void testConstruction() {

        assertNull(card1);
        assertNull(card2);
        assertNull(card3);
        assertNull(card4);
        assertNull(card5);
        assertNull(card6);
        assertNull(card7);

        card1 = new StandardCard(StandardSuit.DIAMONDS, StandardRank.JACK);
        card2 = new StandardCard(StandardSuit.DIAMONDS, StandardRank.FOUR);
        card3 = new StandardCard(StandardSuit.HEARTS, StandardRank.JACK);
        card4 = new StandardCard(StandardSuit.SPADES, StandardRank.ACE);
        card5 = new StandardCard(StandardSuit.CLUBS, StandardRank.KING);
        card6 = new StandardCard(StandardSuit.CLUBS, StandardRank.EIGHT);
        card7 = new StandardCard(StandardSuit.CLUBS, StandardRank.EIGHT);

        assertNotNull(card1);
        assertNotNull(card2);
        assertNotNull(card3);
        assertNotNull(card4);
        assertNotNull(card5);
        assertNotNull(card6);
        assertNotNull(card7);

        assertNull(cards);

        cards = new ArrayList<>();
        for (StandardSuit suit : StandardSuit.values()) {
            for (StandardRank rank : StandardRank.values()) {
                cards.add(new StandardCard(suit, rank));
            }
        }

        assertNotNull(cards);
    }


    /**
     * tests that after constructing all possible cards
     * there are 52 cards in a list
     */
    @Test
    public void testAllCardsConstructed() {
        assertEquals(52, cards.size());
    }

    /**
     * tests that after contructing all possible cards
     * all of them are unique
     */
    @Test
    public void testAllCardsUnique() {
        Set<Card> set = new HashSet<>(cards);
        assertEquals(cards.size(), set.size());
    }

    /**
     * tests cards equality
     * cards of the same suit and rank should be equal
     */
    @Test
    public void testCardEquality() {
        // same rank and suit
        assertEquals(card6, card7);
        // same suit, different rank
        assertNotEquals(card1, card2);
        assertNotEquals(card5, card6);
        // same rank, different suit
        assertNotEquals(card1, card3);
        //rank and suit are different
        assertNotEquals(card1, card4);
        assertNotEquals(card2, card5);
    }

    /**
     * tests cards getSuit method
     */
    @Test
    public void testCardGetSuit() {
        assertEquals(StandardSuit.DIAMONDS, card1.getSuit());
        assertEquals(StandardSuit.DIAMONDS, card2.getSuit());
        assertEquals(StandardSuit.HEARTS, card3.getSuit());
        assertEquals(StandardSuit.SPADES, card4.getSuit());
        assertEquals(StandardSuit.CLUBS, card5.getSuit());
    }

    /**
     * tests cards getRank method
     */
    @Test
    public void testCardGetRank() {
        assertEquals(StandardRank.JACK, card1.getRank());
        assertEquals(StandardRank.FOUR, card2.getRank());
        assertEquals(StandardRank.JACK, card3.getRank());
        assertEquals(StandardRank.ACE, card4.getRank());
        assertEquals(StandardRank.KING, card5.getRank());
    }

    /**
     * tests that there are only valid ranks and suits
     * when getRank ot getSuit
     */
    @Test
    public void containsAllSuitsAndRanks() {
        Set<Suit> suits = new HashSet<>();
        Set<Rank> ranks = new HashSet<>();
        for (Card card : cards) {
            suits.add(card.getSuit());
            ranks.add(card.getRank());
        }
        assertEquals(StandardSuit.values().length, suits.size());
        assertEquals(StandardRank.values().length, ranks.size());
        for (Suit suit : StandardSuit.values()) {
            assertTrue(suits.contains(suit));
        }
        for (Rank rank : StandardRank.values()) {
            assertTrue(ranks.contains(rank));
        }
    }

    /**
     * test conversion of card to sting
     */
    @Test
    public void testToString() {
        assertEquals("J♦", card1.toString());
        assertEquals("4♦", card2.toString());
        assertEquals("J♥", card3.toString());
        assertEquals("A♠", card4.toString());
        assertEquals("K♣", card5.toString());
    }

    /**
     * tests new functionality
     */
    @Test
    public void testIterator(){
        newHand hand = new StandardNewHand();
        hand.accept(card1);
        hand.accept(card2);
        assertTrue(hand.hasCard(card1));
        assertFalse(hand.hasCard(card3));
        assertEquals(1, hand.occurrencesInHand(card1));
        assertEquals(1, hand.occurrencesInHand(StandardRank.JACK));
        assertEquals(0, hand.occurrencesInHand(StandardRank.FIVE));


    }

}