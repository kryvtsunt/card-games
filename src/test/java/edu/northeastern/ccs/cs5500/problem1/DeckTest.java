package edu.northeastern.ccs.cs5500.problem1;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;


/**
 * tests for the Deck implementations
 *
 * @author Tymofii Kryvtsun
 */
public class DeckTest {

    private AbstractFactory deckFactory;
    private Deck standardDeck;
    private Deck vegasDeckSix;
    private Deck vegasDeckEight;
    private Deck pinochleDeck;
    private Deck euchreDeck;
    private Deck standardDeck2;
    private Deck vegasDeckSix2;
    private Deck vegasDeckEight2;
    private Deck pinochleDeck2;
    private Deck euchreDeck2;

    /**
     * tests deck construction
     */
    @Before
    public void testConstruction() {

        assertNull(deckFactory);
        assertNull(standardDeck);
        assertNull(vegasDeckSix);
        assertNull(vegasDeckEight);
        assertNull(pinochleDeck);
        assertNull(euchreDeck);
        assertNull(standardDeck2);
        assertNull(vegasDeckSix2);
        assertNull(vegasDeckEight2);
        assertNull(pinochleDeck2);
        assertNull(euchreDeck2);

        deckFactory = FactoryProducer.getFactory(FactoryType.DECK);

        standardDeck = deckFactory.getDeck(DeckType.STANDARD);
        vegasDeckSix = deckFactory.getDeck(DeckType.VEGAS);
        vegasDeckEight = deckFactory.getDeck(DeckType.VEGAS, 8);
        pinochleDeck = deckFactory.getDeck(DeckType.PINOCHLE);
        euchreDeck = deckFactory.getDeck(DeckType.EUCHRE);

        standardDeck2 = new StandardDeck();
        vegasDeckSix2 = new VegasDeck();
        vegasDeckEight2 = new VegasDeck(8);
        pinochleDeck2 = new PinochleDeck();
        euchreDeck2 = new EuchreDeck();

        assertNotNull(deckFactory);
        assertNotNull(standardDeck);
        assertNotNull(vegasDeckSix);
        assertNotNull(vegasDeckEight);
        assertNotNull(pinochleDeck);
        assertNotNull(euchreDeck);
        assertNotNull(standardDeck2);
        assertNotNull(vegasDeckSix2);
        assertNotNull(vegasDeckEight2);
        assertNotNull(pinochleDeck2);
        assertNotNull(euchreDeck2);

    }

    /**
     * tests when construction inputs are invalid
     */
    @Test
    public void testMalformedConstruction() {
        Deck vegas = null;
        Deck vegas2 = null;
        Deck vegas3 = null;
        Deck vegas4 = null;
        try {
            vegas = new VegasDeck(0);
        } catch (IllegalArgumentException e) {
            assertNull(vegas);
            assertEquals("Vegas deck should be of 2-8 standard decks", e.getMessage());
        }
        try {
            vegas2 = new VegasDeck(13);
        } catch (IllegalArgumentException e) {
            assertNull(vegas2);
            assertEquals("Vegas deck should be of 2-8 standard decks", e.getMessage());
        }
        try {
            vegas3 = deckFactory.getDeck(DeckType.VEGAS, -5);
        } catch (IllegalArgumentException e) {
            assertNull(vegas3);
            assertEquals("Vegas deck should be of 2-8 standard decks", e.getMessage());
        }
        try {
            vegas4 = deckFactory.getDeck(DeckType.VEGAS, 1);
        } catch (IllegalArgumentException e) {
            assertNull(vegas4);
            assertEquals("Vegas deck should be of 2-8 standard decks", e.getMessage());
        }
    }

    /**
     * test when factory input is null
     */
    @Test
    public void testNullFactory() {
        AbstractFactory factory = FactoryProducer.getFactory(null);
        assertNull(factory);

        Deck deck = deckFactory.getDeck(null);
        assertNull(deck);
    }

    /**
     * tests deck equality
     */
    @Test
    public void testEquality() {
        assertEquals(standardDeck, standardDeck2);
        assertEquals(vegasDeckSix, vegasDeckSix2);
        assertEquals(pinochleDeck, pinochleDeck2);
        assertEquals(euchreDeck, euchreDeck2);

        assertNotEquals(standardDeck, pinochleDeck);
        assertNotEquals(standardDeck, vegasDeckSix);
        assertNotEquals(vegasDeckSix, vegasDeckEight);
        assertNotEquals(pinochleDeck, euchreDeck2);
    }

    /**
     * tests the conversion of decks to string
     */
    @Test
    public void testDeckToString() {
        String deck1 = "[2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦," +
                " 9♦, 10♦, J♦, Q♦, K♦, A♦, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥, 2♠, 3♠," +
                " 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠]";
        String deck2 = "[9♣, 10♣, J♣, Q♣, K♣, A♣, 9♦, 10♦, J♦, Q♦, K♦, A♦, 9♥, 10♥, J♥, Q♥, K♥, A♥, 9♠," +
                " 10♠, J♠, Q♠, K♠, A♠, 9♣, 10♣, J♣, Q♣, K♣, A♣, 9♦, 10♦, J♦, Q♦, K♦, A♦, 9♥, 10♥, J♥, Q♥," +
                " K♥, A♥, 9♠, 10♠, J♠, Q♠, K♠, A♠]";
        String deck3 = "[9♣, 10♣, J♣, Q♣, K♣, A♣, 9♦, 10♦, J♦, Q♦, K♦, A♦, 9♥, 10♥, J♥, Q♥, K♥, A♥, 9♠, 10♠, " +
                "J♠, Q♠, K♠, A♠]";
        String deck4 = "[2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦," +
                " 10♦, J♦, Q♦, K♦, A♦, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥, 2♠, 3♠, 4♠," +
                " 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠," +
                " 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦," +
                " 10♦, J♦, Q♦, K♦, A♦, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥, 2♠, 3♠, 4♠," +
                " 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠," +
                " 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦," +
                " 10♦, J♦, Q♦, K♦, A♦, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥, 2♠, 3♠," +
                " 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠," +
                " 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦," +
                " 9♦, 10♦, J♦, Q♦, K♦, A♦, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥, 2♠," +
                " 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠," +
                " 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦," +
                " 9♦, 10♦, J♦, Q♦, K♦, A♦, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥, 2♠," +
                " 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠," +
                " 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦," +
                " 9♦, 10♦, J♦, Q♦, K♦, A♦, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥, 2♠," +
                " 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠]";

        assertEquals(deck1, standardDeck.toString());
        assertEquals(deck2, pinochleDeck.toString());
        assertEquals(deck3, euchreDeck.toString());
        assertEquals(deck4, vegasDeckSix.toString());

    }

    /**
     * tests StandardDeck sorting in 4 different ways:
     * -by rank
     * -by suit
     * -by suit and rank
     * -by rank and suit
     */
    @Test
    public void testStandardDeckSorting() throws IllegalAccessException {
        String sortByRank = "[2♣, 2♦, 2♥, 2♠, 3♣, 3♦, 3♥, 3♠, 4♣, 4♦, 4♥, 4♠, 5♣, 5♦, 5♥, 5♠, 6♣," +
                " 6♦, 6♥, 6♠, 7♣, 7♦, 7♥, 7♠, 8♣, 8♦, 8♥, 8♠, 9♣, 9♦, 9♥, 9♠, 10♣, 10♦, 10♥, 10♠," +
                " J♣, J♦, J♥, J♠, Q♣, Q♦, Q♥, Q♠, K♣, K♦, K♥, K♠, A♣, A♦, A♥, A♠]";
        String sortBySuit = "[2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦," +
                " 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦, A♦, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥," +
                " K♥, A♥, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠]";
        String sortBoth = "[2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♣, 2♦, 3♦, 4♦, 5♦, 6♦," +
                " 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦, A♦, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥," +
                " 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠, A♠]";
        String sortBoth2 = "[2♣, 2♦, 2♥, 2♠, 3♣, 3♦, 3♥, 3♠, 4♣, 4♦, 4♥, 4♠, 5♣, 5♦, 5♥, 5♠, 6♣, 6♦," +
                " 6♥, 6♠, 7♣, 7♦, 7♥, 7♠, 8♣, 8♦, 8♥, 8♠, 9♣, 9♦, 9♥, 9♠, 10♣, 10♦, 10♥, 10♠, J♣, J♦," +
                " J♥, J♠, Q♣, Q♦, Q♥, Q♠, K♣, K♦, K♥, K♠, A♣, A♦, A♥, A♠]";

        standardDeck.sort("BYRANK");
        assertEquals(standardDeck.toString(), sortByRank);
        standardDeck.sort("BYSUIT");
        assertEquals(standardDeck.toString(), sortBySuit);

        standardDeck.shuffle();
        standardDeck.sort("BOTH");
        assertEquals(standardDeck.toString(), sortBoth);

        standardDeck.shuffle();
        standardDeck.sort("BOTH2");
        assertEquals(standardDeck.toString(), sortBoth2);
    }

    /**
     * tests EuchreDeck sorting in 4 different ways:
     * -by rank
     * -by suit
     * -by suit and rank
     * -by rank and suit
     */
    @Test
    public void testEuchreDeckSorting() throws IllegalAccessException {
        String sortByRank = "[9♣, 9♦, 9♥, 9♠, 10♣, 10♦, 10♥, 10♠, J♣, J♦, J♥, J♠, Q♣, Q♦, Q♥, Q♠," +
                " K♣, K♦, K♥, K♠, A♣, A♦, A♥, A♠]";
        String sortBySuit = "[9♣, 10♣, J♣, Q♣, K♣, A♣, 9♦, 10♦, J♦, Q♦, K♦, A♦, 9♥, 10♥, J♥, Q♥," +
                " K♥, A♥, 9♠, 10♠, J♠, Q♠, K♠, A♠]";
        String sortBoth = "[9♣, 10♣, J♣, Q♣, K♣, A♣, 9♦, 10♦, J♦, Q♦, K♦, A♦, 9♥, 10♥, J♥, Q♥, " +
                "K♥, A♥, 9♠, 10♠, J♠, Q♠, K♠, A♠]";
        String sortBoth2 = "[9♣, 9♦, 9♥, 9♠, 10♣, 10♦, 10♥, 10♠, J♣, J♦, J♥, J♠, Q♣, Q♦, Q♥, Q♠," +
                " K♣, K♦, K♥, K♠, A♣, A♦, A♥, A♠]";

        euchreDeck.sort("BYRANK");
        assertEquals(euchreDeck.toString(), sortByRank);
        euchreDeck.sort("BYSUIT");
        assertEquals(euchreDeck.toString(), sortBySuit);

        euchreDeck.shuffle();
        euchreDeck.sort("BOTH");
        assertEquals(euchreDeck.toString(), sortBoth);

        euchreDeck.shuffle();
        euchreDeck.sort("BOTH2");
        assertEquals(euchreDeck.toString(), sortBoth2);
    }

    /**
     * tests PinochleDeck sorting in 4 different ways:
     * -by rank
     * -by suit
     * -by suit and rank
     * -by rank and suit
     */
    @Test
    public void testPinochleDeckSorting() throws IllegalAccessException {
        String sortByRank = "[9♣, 9♦, 9♥, 9♠, 9♣, 9♦, 9♥, 9♠, 10♣, 10♦, 10♥, 10♠, 10♣, 10♦, 10♥, 10♠," +
                " J♣, J♦, J♥, J♠, J♣, J♦, J♥, J♠, Q♣, Q♦, Q♥, Q♠, Q♣, Q♦, Q♥, Q♠," +
                " K♣, K♦, K♥, K♠, K♣, K♦, K♥, K♠, A♣, A♦, A♥, A♠, A♣, A♦, A♥, A♠]";
        String sortBySuit = "[9♣, 9♣, 10♣, 10♣, J♣, J♣, Q♣, Q♣, K♣, K♣, A♣, A♣, 9♦, 9♦, 10♦, 10♦," +
                " J♦, J♦, Q♦, Q♦, K♦, K♦, A♦, A♦, 9♥, 9♥, 10♥, 10♥, J♥, J♥, Q♥, Q♥, K♥, K♥," +
                " A♥, A♥, 9♠, 9♠, 10♠, 10♠, J♠, J♠, Q♠, Q♠, K♠, K♠, A♠, A♠]";
        String sortBoth = "[9♣, 9♣, 10♣, 10♣, J♣, J♣, Q♣, Q♣, K♣, K♣, A♣, A♣, 9♦, 9♦, 10♦, 10♦," +
                " J♦, J♦, Q♦, Q♦, K♦, K♦, A♦, A♦, 9♥, 9♥, 10♥, 10♥, J♥, J♥, Q♥, Q♥, K♥, K♥," +
                " A♥, A♥, 9♠, 9♠, 10♠, 10♠, J♠, J♠, Q♠, Q♠, K♠, K♠, A♠, A♠]";
        String sortBoth2 = "[9♣, 9♣, 9♦, 9♦, 9♥, 9♥, 9♠, 9♠, 10♣, 10♣, 10♦, 10♦, 10♥, 10♥, 10♠, 10♠," +
                " J♣, J♣, J♦, J♦, J♥, J♥, J♠, J♠, Q♣, Q♣, Q♦, Q♦, Q♥, Q♥, Q♠, Q♠," +
                " K♣, K♣, K♦, K♦, K♥, K♥, K♠, K♠, A♣, A♣, A♦, A♦, A♥, A♥, A♠, A♠]";

        pinochleDeck.sort("BYRANK");
        assertEquals(pinochleDeck.toString(), sortByRank);
        pinochleDeck.sort("BYSUIT");
        assertEquals(pinochleDeck.toString(), sortBySuit);

        pinochleDeck.shuffle();
        pinochleDeck.sort("BOTH");
        assertEquals(pinochleDeck.toString(), sortBoth);

        pinochleDeck.shuffle();
        pinochleDeck.sort("BOTH2");
        assertEquals(pinochleDeck.toString(), sortBoth2);
    }

    /**
     * tests VegasDeck sorting in 4 different ways:
     * -by rank
     * -by suit
     * -by suit and rank
     * -by rank and suit
     */
    @Test
    public void testVegasDeckSorting() throws IllegalAccessException {
        String sortByRank = "[2♣, 2♦, 2♥, 2♠, 2♣, 2♦, 2♥, 2♠, 2♣, 2♦, 2♥, 2♠, 2♣, 2♦, 2♥," +
                " 2♠, 2♣, 2♦, 2♥, 2♠, 2♣, 2♦, 2♥, 2♠, 3♣, 3♦, 3♥, 3♠, 3♣, 3♦, 3♥, 3♠, 3♣," +
                " 3♦, 3♥, 3♠, 3♣, 3♦, 3♥, 3♠, 3♣, 3♦, 3♥, 3♠, 3♣, 3♦, 3♥, 3♠, 4♣, 4♦, 4♥," +
                " 4♠, 4♣, 4♦, 4♥, 4♠, 4♣, 4♦, 4♥, 4♠, 4♣, 4♦, 4♥, 4♠, 4♣, 4♦, 4♥, 4♠, 4♣," +
                " 4♦, 4♥, 4♠, 5♣, 5♦, 5♥, 5♠, 5♣, 5♦, 5♥, 5♠, 5♣, 5♦, 5♥, 5♠, 5♣, 5♦, 5♥," +
                " 5♠, 5♣, 5♦, 5♥, 5♠, 5♣, 5♦, 5♥, 5♠, 6♣, 6♦, 6♥, 6♠, 6♣, 6♦, 6♥, 6♠, 6♣, 6♦," +
                " 6♥, 6♠, 6♣, 6♦, 6♥, 6♠, 6♣, 6♦, 6♥, 6♠, 6♣, 6♦, 6♥, 6♠, 7♣, 7♦, 7♥, 7♠, 7♣," +
                " 7♦, 7♥, 7♠, 7♣, 7♦, 7♥, 7♠, 7♣, 7♦, 7♥, 7♠, 7♣, 7♦, 7♥, 7♠, 7♣, 7♦, 7♥, 7♠," +
                " 8♣, 8♦, 8♥, 8♠, 8♣, 8♦, 8♥, 8♠, 8♣, 8♦, 8♥, 8♠, 8♣, 8♦, 8♥, 8♠, 8♣, 8♦, 8♥," +
                " 8♠, 8♣, 8♦, 8♥, 8♠, 9♣, 9♦, 9♥, 9♠, 9♣, 9♦, 9♥, 9♠, 9♣, 9♦, 9♥, 9♠, 9♣, 9♦, 9♥," +
                " 9♠, 9♣, 9♦, 9♥, 9♠, 9♣, 9♦, 9♥, 9♠, 10♣, 10♦, 10♥, 10♠, 10♣, 10♦, 10♥, 10♠, 10♣," +
                " 10♦, 10♥, 10♠, 10♣, 10♦, 10♥, 10♠, 10♣, 10♦, 10♥, 10♠, 10♣, 10♦, 10♥, 10♠, J♣, J♦," +
                " J♥, J♠, J♣, J♦, J♥, J♠, J♣, J♦, J♥, J♠, J♣, J♦, J♥, J♠, J♣, J♦, J♥, J♠, J♣, J♦," +
                " J♥, J♠, Q♣, Q♦, Q♥, Q♠, Q♣, Q♦, Q♥, Q♠, Q♣, Q♦, Q♥, Q♠, Q♣, Q♦, Q♥, Q♠, Q♣, Q♦," +
                " Q♥, Q♠, Q♣, Q♦, Q♥, Q♠, K♣, K♦, K♥, K♠, K♣, K♦, K♥, K♠, K♣, K♦, K♥, K♠, K♣, K♦," +
                " K♥, K♠, K♣, K♦, K♥, K♠, K♣, K♦, K♥, K♠, A♣, A♦, A♥, A♠, A♣, A♦, A♥, A♠, A♣, A♦," +
                " A♥, A♠, A♣, A♦, A♥, A♠, A♣, A♦, A♥, A♠, A♣, A♦, A♥, A♠]";
        String sortBySuit = "[2♣, 2♣, 2♣, 2♣, 2♣, 2♣, 3♣, 3♣, 3♣, 3♣, 3♣, 3♣, 4♣, 4♣, 4♣, 4♣, 4♣," +
                " 4♣, 5♣, 5♣, 5♣, 5♣, 5♣, 5♣, 6♣, 6♣, 6♣, 6♣, 6♣, 6♣, 7♣, 7♣, 7♣, 7♣, 7♣, 7♣, 8♣," +
                " 8♣, 8♣, 8♣, 8♣, 8♣, 9♣, 9♣, 9♣, 9♣, 9♣, 9♣, 10♣, 10♣, 10♣, 10♣, 10♣, 10♣, J♣, J♣," +
                " J♣, J♣, J♣, J♣, Q♣, Q♣, Q♣, Q♣, Q♣, Q♣, K♣, K♣, K♣, K♣, K♣, K♣, A♣, A♣, A♣, A♣," +
                " A♣, A♣, 2♦, 2♦, 2♦, 2♦, 2♦, 2♦, 3♦, 3♦, 3♦, 3♦, 3♦, 3♦, 4♦, 4♦, 4♦, 4♦, 4♦, 4♦," +
                " 5♦, 5♦, 5♦, 5♦, 5♦, 5♦, 6♦, 6♦, 6♦, 6♦, 6♦, 6♦, 7♦, 7♦, 7♦, 7♦, 7♦, 7♦, 8♦, 8♦," +
                " 8♦, 8♦, 8♦, 8♦, 9♦, 9♦, 9♦, 9♦, 9♦, 9♦, 10♦, 10♦, 10♦, 10♦, 10♦, 10♦, J♦, J♦," +
                " J♦, J♦, J♦, J♦, Q♦, Q♦, Q♦, Q♦, Q♦, Q♦, K♦, K♦, K♦, K♦, K♦, K♦, A♦, A♦, A♦, A♦," +
                " A♦, A♦, 2♥, 2♥, 2♥, 2♥, 2♥, 2♥, 3♥, 3♥, 3♥, 3♥, 3♥, 3♥, 4♥, 4♥, 4♥, 4♥, 4♥, 4♥," +
                " 5♥, 5♥, 5♥, 5♥, 5♥, 5♥, 6♥, 6♥, 6♥, 6♥, 6♥, 6♥, 7♥, 7♥, 7♥, 7♥, 7♥, 7♥, 8♥, 8♥, " +
                "8♥, 8♥, 8♥, 8♥, 9♥, 9♥, 9♥, 9♥, 9♥, 9♥, 10♥, 10♥, 10♥, 10♥, 10♥, 10♥, J♥, J♥, J♥," +
                " J♥, J♥, J♥, Q♥, Q♥, Q♥, Q♥, Q♥, Q♥, K♥, K♥, K♥, K♥, K♥, K♥, A♥, A♥, A♥, A♥, A♥," +
                " A♥, 2♠, 2♠, 2♠, 2♠, 2♠, 2♠, 3♠, 3♠, 3♠, 3♠, 3♠, 3♠, 4♠, 4♠, 4♠, 4♠, 4♠, 4♠, 5♠," +
                " 5♠, 5♠, 5♠, 5♠, 5♠, 6♠, 6♠, 6♠, 6♠, 6♠, 6♠, 7♠, 7♠, 7♠, 7♠, 7♠, 7♠, 8♠, 8♠, 8♠," +
                " 8♠, 8♠, 8♠, 9♠, 9♠, 9♠, 9♠, 9♠, 9♠, 10♠, 10♠, 10♠, 10♠, 10♠, 10♠, J♠, J♠, J♠, J♠," +
                " J♠, J♠, Q♠, Q♠, Q♠, Q♠, Q♠, Q♠, K♠, K♠, K♠, K♠, K♠, K♠, A♠, A♠, A♠, A♠, A♠, A♠]";
        String sortBoth = "[2♣, 2♣, 2♣, 2♣, 2♣, 2♣, 3♣, 3♣, 3♣, 3♣, 3♣, 3♣, 4♣, 4♣, 4♣, 4♣, 4♣, 4♣," +
                " 5♣, 5♣, 5♣, 5♣, 5♣, 5♣, 6♣, 6♣, 6♣, 6♣, 6♣, 6♣, 7♣, 7♣, 7♣, 7♣, 7♣, 7♣, 8♣, 8♣, " +
                "8♣, 8♣, 8♣, 8♣, 9♣, 9♣, 9♣, 9♣, 9♣, 9♣, 10♣, 10♣, 10♣, 10♣, 10♣, 10♣, J♣, J♣, J♣," +
                " J♣, J♣, J♣, Q♣, Q♣, Q♣, Q♣, Q♣, Q♣, K♣, K♣, K♣, K♣, K♣, K♣, A♣, A♣, A♣, A♣, A♣," +
                " A♣, 2♦, 2♦, 2♦, 2♦, 2♦, 2♦, 3♦, 3♦, 3♦, 3♦, 3♦, 3♦, 4♦, 4♦, 4♦, 4♦, 4♦, 4♦, 5♦," +
                " 5♦, 5♦, 5♦, 5♦, 5♦, 6♦, 6♦, 6♦, 6♦, 6♦, 6♦, 7♦, 7♦, 7♦, 7♦, 7♦, 7♦, 8♦, 8♦, 8♦," +
                " 8♦, 8♦, 8♦, 9♦, 9♦, 9♦, 9♦, 9♦, 9♦, 10♦, 10♦, 10♦, 10♦, 10♦, 10♦, J♦, J♦, J♦, J♦," +
                " J♦, J♦, Q♦, Q♦, Q♦, Q♦, Q♦, Q♦, K♦, K♦, K♦, K♦, K♦, K♦, A♦, A♦, A♦, A♦, A♦, A♦, " +
                "2♥, 2♥, 2♥, 2♥, 2♥, 2♥, 3♥, 3♥, 3♥, 3♥, 3♥, 3♥, 4♥, 4♥, 4♥, 4♥, 4♥, 4♥, 5♥, 5♥," +
                " 5♥, 5♥, 5♥, 5♥, 6♥, 6♥, 6♥, 6♥, 6♥, 6♥, 7♥, 7♥, 7♥, 7♥, 7♥, 7♥, 8♥, 8♥, 8♥, 8♥, " +
                "8♥, 8♥, 9♥, 9♥, 9♥, 9♥, 9♥, 9♥, 10♥, 10♥, 10♥, 10♥, 10♥, 10♥, J♥, J♥, J♥, J♥, J♥," +
                " J♥, Q♥, Q♥, Q♥, Q♥, Q♥, Q♥, K♥, K♥, K♥, K♥, K♥, K♥, A♥, A♥, A♥, A♥, A♥, A♥, 2♠," +
                " 2♠, 2♠, 2♠, 2♠, 2♠, 3♠, 3♠, 3♠, 3♠, 3♠, 3♠, 4♠, 4♠, 4♠, 4♠, 4♠, 4♠, 5♠, 5♠, 5♠," +
                " 5♠, 5♠, 5♠, 6♠, 6♠, 6♠, 6♠, 6♠, 6♠, 7♠, 7♠, 7♠, 7♠, 7♠, 7♠, 8♠, 8♠, 8♠, 8♠, 8♠," +
                " 8♠, 9♠, 9♠, 9♠, 9♠, 9♠, 9♠, 10♠, 10♠, 10♠, 10♠, 10♠, 10♠, J♠, J♠, J♠, J♠, J♠, J♠," +
                " Q♠, Q♠, Q♠, Q♠, Q♠, Q♠, K♠, K♠, K♠, K♠, K♠, K♠, A♠, A♠, A♠, A♠, A♠, A♠]";
        String sortBoth2 = "[2♣, 2♣, 2♣, 2♣, 2♣, 2♣, 2♦, 2♦, 2♦, 2♦, 2♦, 2♦, 2♥, 2♥, 2♥, 2♥, 2♥, " +
                "2♥, 2♠, 2♠, 2♠, 2♠, 2♠, 2♠, 3♣, 3♣, 3♣, 3♣, 3♣, 3♣, 3♦, 3♦, 3♦, 3♦, 3♦, 3♦, 3♥, 3♥," +
                " 3♥, 3♥, 3♥, 3♥, 3♠, 3♠, 3♠, 3♠, 3♠, 3♠, 4♣, 4♣, 4♣, 4♣, 4♣, 4♣, 4♦, 4♦, 4♦, 4♦, 4♦," +
                " 4♦, 4♥, 4♥, 4♥, 4♥, 4♥, 4♥, 4♠, 4♠, 4♠, 4♠, 4♠, 4♠, 5♣, 5♣, 5♣, 5♣, 5♣, 5♣, 5♦," +
                " 5♦, 5♦, 5♦, 5♦, 5♦, 5♥, 5♥, 5♥, 5♥, 5♥, 5♥, 5♠, 5♠, 5♠, 5♠, 5♠, 5♠, 6♣, 6♣, 6♣," +
                " 6♣, 6♣, 6♣, 6♦, 6♦, 6♦, 6♦, 6♦, 6♦, 6♥, 6♥, 6♥, 6♥, 6♥, 6♥, 6♠, 6♠, 6♠, 6♠, 6♠," +
                " 6♠, 7♣, 7♣, 7♣, 7♣, 7♣, 7♣, 7♦, 7♦, 7♦, 7♦, 7♦, 7♦, 7♥, 7♥, 7♥, 7♥, 7♥, 7♥, 7♠," +
                " 7♠, 7♠, 7♠, 7♠, 7♠, 8♣, 8♣, 8♣, 8♣, 8♣, 8♣, 8♦, 8♦, 8♦, 8♦, 8♦, 8♦, 8♥, 8♥, 8♥," +
                " 8♥, 8♥, 8♥, 8♠, 8♠, 8♠, 8♠, 8♠, 8♠, 9♣, 9♣, 9♣, 9♣, 9♣, 9♣, 9♦, 9♦, 9♦, 9♦, 9♦," +
                " 9♦, 9♥, 9♥, 9♥, 9♥, 9♥, 9♥, 9♠, 9♠, 9♠, 9♠, 9♠, 9♠, 10♣, 10♣, 10♣, 10♣, 10♣, 10♣," +
                " 10♦, 10♦, 10♦, 10♦, 10♦, 10♦, 10♥, 10♥, 10♥, 10♥, 10♥, 10♥, 10♠, 10♠, 10♠, 10♠," +
                " 10♠, 10♠, J♣, J♣, J♣, J♣, J♣, J♣, J♦, J♦, J♦, J♦, J♦, J♦, J♥, J♥, J♥, J♥, J♥, J♥," +
                " J♠, J♠, J♠, J♠, J♠, J♠, Q♣, Q♣, Q♣, Q♣, Q♣, Q♣, Q♦, Q♦, Q♦, Q♦, Q♦, Q♦, Q♥, Q♥," +
                " Q♥, Q♥, Q♥, Q♥, Q♠, Q♠, Q♠, Q♠, Q♠, Q♠, K♣, K♣, K♣, K♣, K♣, K♣, K♦, K♦, K♦, K♦," +
                " K♦, K♦, K♥, K♥, K♥, K♥, K♥, K♥, K♠, K♠, K♠, K♠, K♠, K♠, A♣, A♣, A♣, A♣, A♣, A♣," +
                " A♦, A♦, A♦, A♦, A♦, A♦, A♥, A♥, A♥, A♥, A♥, A♥, A♠, A♠, A♠, A♠, A♠, A♠]";

        vegasDeckSix.sort("BYRANK");
        assertEquals(vegasDeckSix.toString(), sortByRank);
        vegasDeckSix.sort("BYSUIT");
        assertEquals(vegasDeckSix.toString(), sortBySuit);

        vegasDeckSix.shuffle();
        vegasDeckSix.sort("BOTH");
        assertEquals(vegasDeckSix.toString(), sortBoth);

        vegasDeckSix.shuffle();
        vegasDeckSix.sort("BOTH2");
        assertEquals(vegasDeckSix.toString(), sortBoth2);
    }

    /**
     * tests malformed arguments for sorting
     */
    @Test
    public void testMalformedSortingImput() {
        try {
            standardDeck.sort("");
        } catch (IllegalArgumentException e) {
            assertEquals("Sorting option is incorrect", e.getMessage());
        }
        try {
            standardDeck.sort(null);
        } catch (IllegalArgumentException e) {
            assertEquals("NULL argument", e.getMessage());
        }
        try {
            pinochleDeck.sort("blah");
        } catch (IllegalArgumentException e) {
            assertEquals("Sorting option is incorrect", e.getMessage());
        }
        try {
            pinochleDeck.sort(null);
        } catch (IllegalArgumentException e) {
            assertEquals("NULL argument", e.getMessage());
        }
        try {
            euchreDeck.sort("foo2foo2");
        } catch (IllegalArgumentException e) {
            assertEquals("Sorting option is incorrect", e.getMessage());
        }
        try {
            euchreDeck.sort(null);
        } catch (IllegalArgumentException e) {
            assertEquals("NULL argument", e.getMessage());
        }
        try {
            vegasDeckSix.sort("empty string 404");
        } catch (IllegalArgumentException e) {
            assertEquals("Sorting option is incorrect", e.getMessage());
        }
        try {
            vegasDeckSix.sort(null);
        } catch (IllegalArgumentException e) {
            assertEquals("NULL argument", e.getMessage());
        }
    }

    /**
     * tests officialSize of all types of decks
     */
    @Test
    public void testOfficialSize() {
        assertEquals(52, standardDeck.officialSize());
        assertEquals(48, pinochleDeck.officialSize());
        assertEquals(24, euchreDeck.officialSize());
        assertEquals(312, vegasDeckSix.officialSize());
        assertEquals(416, vegasDeckEight.officialSize());
    }

    /**
     * tests pulling cards until deck is empty
     */
    @Test
    public void testPullCardsUntilDeckEmpty() throws IllegalAccessException {
        List<Card> list1, list2, list3, list4;
        assertFalse(standardDeck.emptyDeck());
        assertFalse(euchreDeck.emptyDeck());
        assertFalse(pinochleDeck.emptyDeck());
        assertFalse(euchreDeck.emptyDeck());

        list1 = standardDeck.getCards();
        list2 = pinochleDeck.getCards();
        list3 = euchreDeck.getCards();
        list4 = vegasDeckSix.getCards();
        assertTrue(list1.size() > 0);
        assertTrue(list2.size() > 0);
        assertTrue(list3.size() > 0);
        assertTrue(list4.size() > 0);


        for (int i = 0; i < standardDeck.officialSize(); i++) {
            standardDeck.pullCard();
        }
        for (int i = 0; i < euchreDeck.officialSize(); i++) {
            euchreDeck.pullCard();
        }
        for (int i = 0; i < pinochleDeck.officialSize(); i++) {
            pinochleDeck.pullCard();
        }
        for (int i = 0; i < vegasDeckSix.officialSize(); i++) {
            vegasDeckSix.pullCard();
        }

        list1 = standardDeck.getCards();
        list2 = pinochleDeck.getCards();
        list3 = euchreDeck.getCards();
        list4 = vegasDeckSix.getCards();
        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(0, list3.size());
        assertEquals(0, list4.size());

        assertTrue(standardDeck.emptyDeck());
        assertTrue(euchreDeck.emptyDeck());
        assertTrue(pinochleDeck.emptyDeck());
        assertTrue(euchreDeck.emptyDeck());
    }

    /**
     * tests pulling cards when deck is empty
     */
    @Test
    public void testPullCardFromEmptyDeck() throws IllegalAccessException {

        try {
            for (int i = 0; i <= standardDeck.officialSize(); i++) {
                standardDeck.pullCard();
            }
        } catch (NullPointerException e) {
            assertEquals("Deck is empty", e.getMessage());
        }
        try {
            for (int i = 0; i <= euchreDeck.officialSize(); i++) {
                euchreDeck.pullCard();
            }
        } catch (NullPointerException e) {
            assertEquals("Deck is empty", e.getMessage());
        }
        try {
            for (int i = 0; i <= pinochleDeck.officialSize(); i++) {
                pinochleDeck.pullCard();
            }
        } catch (NullPointerException e) {
            assertEquals("Deck is empty", e.getMessage());
        }
        try {
            for (int i = 0; i <= vegasDeckSix.officialSize(); i++) {
                vegasDeckSix.pullCard();
            }
        } catch (NullPointerException e) {
            assertEquals("Deck is empty", e.getMessage());
        }
    }

    /**
     * tests shuffle StandardDeck
     */
    @Test
    public void testSuffleStandard() {
        List<Card> before = standardDeck.getCards();
        standardDeck.shuffle();
        List<Card> after = standardDeck.getCards();
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
     * tests shuffle EuchreDeck
     */
    @Test
    public void testshuffleEuchre() {
        List<Card> before = euchreDeck.getCards();
        euchreDeck.shuffle();
        List<Card> after = euchreDeck.getCards();
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
     * tests shuffle PinochleDeck
     */
    @Test
    public void testshufflePnochle() {
        List<Card> before = pinochleDeck.getCards();
        pinochleDeck.shuffle();
        List<Card> after = pinochleDeck.getCards();
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
     * tests shuffle VegasDeck
     */
    @Test
    public void testshuffleVegas() {
        List<Card> before = vegasDeckSix.getCards();
        vegasDeckSix.shuffle();
        List<Card> after = vegasDeckSix.getCards();
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
     * tests cut Decks with wrong (out of bound) arguments
     */
    @Test
    public void testMalformedCut() {
        try {
            standardDeck.cut(-1);
        } catch (IllegalAccessException e) {
            assertEquals("Out of bounds", e.getMessage());
        }
        try {
            standardDeck.cut(standardDeck.officialSize());
        } catch (IllegalAccessException e) {
            assertEquals("Out of bounds", e.getMessage());
        }
        try {
            euchreDeck.cut(-1);
        } catch (IllegalAccessException e) {
            assertEquals("Out of bounds", e.getMessage());
        }
        try {
            euchreDeck.cut(standardDeck.officialSize());
        } catch (IllegalAccessException e) {
            assertEquals("Out of bounds", e.getMessage());
        }
        try {
            pinochleDeck.cut(-1);
        } catch (IllegalAccessException e) {
            assertEquals("Out of bounds", e.getMessage());
        }
        try {
            pinochleDeck.cut(standardDeck.officialSize());
        } catch (IllegalAccessException e) {
            assertEquals("Out of bounds", e.getMessage());
        }
        try {
            vegasDeckSix.cut(-1);
        } catch (IllegalAccessException e) {
            assertEquals("Out of bounds", e.getMessage());
        }
        try {
            vegasDeckSix.cut(standardDeck.officialSize());
        } catch (IllegalAccessException e) {
            assertEquals("Out of bounds", e.getMessage());
        }
    }

    /**
     * tests cutting StadardDeck
     */
    @Test
    public void testCutStandard() throws IllegalAccessException {
        Random rand = new Random();
        int randomIndex = rand.nextInt(standardDeck.officialSize());
        List<Card> before = standardDeck.getCards();
        standardDeck.cut(randomIndex);
        List<Card> after = standardDeck.getCards();
        int beforesize = before.size();
        int aftersize = after.size();
        assertNotEquals(before, after);
        assertEquals(beforesize, aftersize);
        for (Card card : before) {
            assertTrue(after.contains(card));
        }
        assertEquals(before.get(randomIndex), after.get(0));
        for (int i = 0; i < randomIndex; i++) {
            assertNotEquals(before.get(i), after.get(i));
            assertEquals(before.get(i), after.get(aftersize - (randomIndex - i)));
        }
        for (int i = randomIndex; i < beforesize - randomIndex; i++) {
            assertEquals(before.get(i + randomIndex), after.get(i));
        }
    }

    /**
     * tests cutting PinochleDeck
     */
    @Test
    public void testCutPinochle() throws IllegalAccessException {
        Random rand = new Random();
        int randomIndex = rand.nextInt(pinochleDeck.officialSize());
        List<Card> before = pinochleDeck.getCards();
        pinochleDeck.cut(randomIndex);
        List<Card> after = pinochleDeck.getCards();
        int beforesize = before.size();
        int aftersize = after.size();
        assertNotEquals(before, after);
        assertEquals(beforesize, aftersize);
        for (Card card : before) {
            assertTrue(after.contains(card));
        }
        assertEquals(before.get(randomIndex), after.get(0));
        for (int i = 0; i < randomIndex; i++) {
            assertNotEquals(before.get(i), after.get(i));
            assertEquals(before.get(i), after.get(aftersize - (randomIndex - i)));
        }
        for (int i = randomIndex; i < beforesize - randomIndex; i++) {
            assertEquals(before.get(i + randomIndex), after.get(i));
        }
    }

    /**
     * tests cutting EuchreDeck
     */
    @Test
    public void testCutEuchre() throws IllegalAccessException {
        Random rand = new Random();
        int randomIndex = rand.nextInt(euchreDeck.officialSize());
        List<Card> before = euchreDeck.getCards();
        euchreDeck.cut(randomIndex);
        List<Card> after = euchreDeck.getCards();
        int beforesize = before.size();
        int aftersize = after.size();
        assertNotEquals(before, after);
        assertEquals(beforesize, aftersize);
        for (Card card : before) {
            assertTrue(after.contains(card));
        }
        assertEquals(before.get(randomIndex), after.get(0));
        for (int i = 0; i < randomIndex; i++) {
            assertNotEquals(before.get(i), after.get(i));
            assertEquals(before.get(i), after.get(aftersize - (randomIndex - i)));
        }
        for (int i = randomIndex; i < beforesize - randomIndex; i++) {
            assertEquals(before.get(i + randomIndex), after.get(i));
        }
    }

    /**
     * tests cutting VegasDeck
     */
    @Test
    public void testCutVegas() throws IllegalAccessException {
        Random rand = new Random();
        int randomIndex = rand.nextInt(vegasDeckSix.officialSize());
        List<Card> before = vegasDeckSix.getCards();
        vegasDeckSix.cut(randomIndex);
        List<Card> after = vegasDeckSix.getCards();
        int beforesize = before.size();
        int aftersize = after.size();
        assertNotEquals(before, after);
        assertEquals(beforesize, aftersize);
        for (Card card : before) {
            assertTrue(after.contains(card));
        }
        assertEquals(before.get(randomIndex), after.get(0));
        for (int i = 0; i < randomIndex; i++) {
            assertNotEquals(before.get(i), after.get(i));
            assertEquals(before.get(i), after.get(aftersize - (randomIndex - i)));
        }
        for (int i = randomIndex; i < beforesize - randomIndex; i++) {
            assertEquals(before.get(i + randomIndex), after.get(i));
        }
    }

}
