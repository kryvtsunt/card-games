package edu.northeastern.ccs.cs5500.problem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * tests for the Hand implementation
 *
 * @author Tymofii Kryvtsun
 */
public class HandTest {

    private Hand hand1;
    private Hand hand2;
    private Hand hand3;

    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;

    private Deck deck;


    /**
     * test hands construction
     */
    @Before
    public void testConstructor() {

        assertNull(hand1);
        assertNull(hand2);
        assertNull(hand3);

        hand1 = new StandardHand();
        hand2 = new StandardHand();
        hand3 = new StandardHand();

        assertNotNull(hand1);
        assertNotNull(hand2);
        assertNotNull(hand3);


        assertNull(card1);
        assertNull(card2);
        assertNull(card3);
        assertNull(card4);
        assertNull(card5);

        card1 = new StandardCard(StandardSuit.DIAMONDS, StandardRank.KING);
        card2 = new StandardCard(StandardSuit.DIAMONDS, StandardRank.TEN);
        card3 = new StandardCard(StandardSuit.DIAMONDS, StandardRank.KING);
        card4 = new StandardCard(StandardSuit.SPADES, StandardRank.THREE);
        card5 = new StandardCard(StandardSuit.CLUBS, StandardRank.ACE);

        assertNotNull(card1);
        assertNotNull(card2);
        assertNotNull(card3);
        assertNotNull(card4);
        assertNotNull(card5);

        assertNull(deck);
        deck = new StandardDeck();
        assertNotNull(deck);


    }

    /**
     * tests hands equality
     */
    @Test
    public void testEquality() {
        assertEquals(hand1, hand2);
        assertEquals(hand1, hand3);
        hand1.accept(card1);
        assertEquals(hand2, hand3);
        assertNotEquals(hand1, hand2);
        hand2.accept(card2);
        assertNotEquals(hand1, hand2);
        hand3.accept(card3);
        assertEquals(hand1, hand3);

    }

    /**
     * tests hands showCards
     */
    @Test
    public void testShowCards() {
        List<Card> list = new ArrayList<>();
        assertEquals(list, hand1.showCards());
        hand1.accept(card1);
        assertNotEquals(list, hand1.showCards());
        list.add(card3);
        assertEquals(list, hand1.showCards());
        list.add(card2);
        assertNotEquals(list, hand1.showCards());
    }


    /**
     * tests hands hasCard
     */
    @Test
    public void testHasCard() {
        assertFalse(hand1.hasCard(card1));
        assertEquals(hand1.hasCard(card1), hand1.showCards().contains(card1));
        hand1.accept(card1);
        assertEquals(hand1.hasCard(card1), hand1.showCards().contains(card1));
        assertTrue(hand1.hasCard(card1));

    }

    /**
     * tests hands accepting a card
     */
    @Test
    public void testAcceptCard() {
        assertTrue(hand1.showCards().isEmpty());
        assertTrue(hand2.showCards().isEmpty());

        assertFalse(hand1.hasCard(card1));
        assertFalse(hand1.hasCard(card2));
        hand1.accept(card1);
        assertTrue(hand1.hasCard(card1));
        assertFalse(hand1.hasCard(card2));
        hand1.accept(card2);
        assertTrue(hand1.hasCard(card1));
        assertTrue(hand1.hasCard(card2));

        assertFalse(hand1.showCards().isEmpty());
        assertTrue(hand2.showCards().isEmpty());
    }

    /**
     * tests  hands pullCard
     */
    @Test
    public void testPullCard() {
        hand2.accept(card1);
        hand2.accept(card2);
        assertTrue(hand2.hasCard(card1));
        assertTrue(hand2.hasCard(card2));
        hand2.pullCard();
        assertTrue(hand2.hasCard(card1));
        assertFalse(hand2.hasCard(card2));
        hand2.pullCard();
        assertFalse(hand2.hasCard(card1));
        assertFalse(hand2.hasCard(card2));
    }

    /**
     * tests  hands pullCard from the deck
     */
    @Test
    public void testPullCardDeck() throws IllegalAccessException {
        Card card = deck.pullCard();
        hand1.accept(card);
        assertFalse(deck.getCards().contains(card));
        assertFalse(hand2.hasCard(card));
        assertTrue(hand1.hasCard(card));
    }

    /**
     * tests hands pullCard when hand is empty
     */
    @Test
    public void testPullCardEmptyHand() {
        try {
            hand1.pullCard();
        } catch (NullPointerException e) {
            assertEquals("No cards", e.getMessage());
        }
    }

    /**
     * tests hands shuffle
     */
    @Test
    public void testShufleHand() throws IllegalAccessException {

        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());

        List<Card> before = hand1.showCards();
        hand1.shuffle();
        List<Card> after = hand1.showCards();
        assertNotEquals(before, after);
        assertEquals(before.size(), after.size());
        for (Card card : before) {
            assertTrue(after.contains(card));
        }
        int n = 0;
        for (int i = 0; i < after.size(); i++) {
            if (before.get(i).equals(after.get(i))) n++;
        }
        assertTrue(n < after.size() / 2);


    }

    /**
     * tests hands sort (
     */
    @Test
    public void testSortHand() throws IllegalAccessException {

        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());
        hand1.accept(deck.pullCard());

        String sortByRank = "[3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠]";
        String sortBySuit = "[3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠]";
        String sortBoth = "[3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠]";
        String sortBoth2 = "[3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠]";

        hand1.sort("BYRANK");
        assertEquals(hand1.toString(), sortByRank);
        hand1.sort("BYSUIT");
        assertEquals(hand1.toString(), sortBySuit);

        hand1.shuffle();
        hand1.sort("BOTH");
        assertEquals(hand1.toString(), sortBoth);

        hand1.shuffle();
        hand1.sort("BOTH2");
        assertEquals(hand1.toString(), sortBoth2);

    }
}
