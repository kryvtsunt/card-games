package edu.northeastern.ccs.cs5500.problem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


/**
 * tests for the Game implementations
 *
 * @author Tymofii Kryvtsun
 */
public class GameTest {
    private Game game1;
    private Game game2;
    private Game game3;
    private Game game4;
    private Game game5;
    private Game game6;


    /**
     * tests games construction
     */
    @Before
    public void testConstructGames() {

        assertNull(game1);
        assertNull(game2);
        assertNull(game3);
        assertNull(game4);
        assertNull(game5);
        assertNull(game6);

        game1 = new SimpleGame();
        game2 = new SimpleGame();
        game3 = new SimpleGame();
        game4 = new SimpleGame();
        game5 = new SimpleGame();
        game6 = new SimpleGame();

        assertNotNull(game1);
        assertNotNull(game2);
        assertNotNull(game3);
        assertNotNull(game4);
        assertNotNull(game5);
        assertNotNull(game6);
    }

    /**
     * tests creating decks for games
     */
    @Test
    public void testCreateDecks() {
        game1.createDeck("STANDARD");
        game2.createDeck("VEGAS");
        game3.createDeck("VEGAS", 4);
        game4.createDeck("PINOCHLE");
        game5.createDeck("EUCHRE");
        game6.createDeck("EUCHRE");

        assertNotEquals(game1, game2);
        assertNotEquals(game1, game3);
        assertNotEquals(game3, game4);
        assertNotEquals(game4, game5);

        assertEquals(game5, game6);

    }

    /**
     * tests invalid deck creating
     */
    @Test
    public void testCreateInvalidDecks() {
        try {
            game1.createDeck("foo");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid deck type", e.getMessage());
        }
        try {
            game1.createDeck("");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid deck type", e.getMessage());
        }
        game1.createDeck(null);
        assertEquals(game1, game2);
    }

    /**
     * tests games setNumberOfHands
     */
    @Test
    public void testSettingHands() {
        assertFalse(game1.toString().contains("Player1"));
        assertFalse(game2.toString().contains("Player1"));
        game1.createDeck("STANDARD");
        game1.setNumberOfHands(4);
        game2.createDeck("STANDARD");
        game3.setNumberOfHands(4);

        assertNotEquals(game1, game2);
        assertNotEquals(game1, game3);
        game2.setNumberOfHands(2);
        game3.createDeck("STANDARD");
        assertNotEquals(game1, game2);
        assertEquals(game1, game3);

        assertTrue(game1.toString().contains("Player1"));
        assertTrue(game1.toString().contains("Player2"));
        assertTrue(game1.toString().contains("Player3"));
        assertTrue(game1.toString().contains("Player4"));
        assertFalse(game1.toString().contains("Player5"));

        assertTrue(game2.toString().contains("Player1"));
        assertTrue(game2.toString().contains("Player2"));
        assertFalse(game2.toString().contains("Player3"));
    }

    /**
     * tests invalid number of hands/players
     */
    @Test
    public void testInvalidSettingHands() {
        try {
            game1.setNumberOfHands(0);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of hands", e.getMessage());
        }
        try {
            game1.setNumberOfHands(100);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of hands", e.getMessage());
        }
    }

    /**
     * tests games deal cards from deck to hands
     */
    @Test
    public void testDealing() {
        String deck, table;
        game1.createDeck("STANDARD");
        game1.setNumberOfHands(3);
        deck = game1.toString().split("Player1")[0];
        table = game1.toString().split("Player1")[1];
        Deck standardDeck = new StandardDeck();
        for (Card card : standardDeck.getCards()) {
            assertTrue(deck.contains(card.toString()));
            assertFalse(table.contains(card.toString()));
        }
        game1.deal();
        deck = game1.toString().split("Player1")[0];
        table = game1.toString().split("Player1")[1];
        for (Card card : standardDeck.getCards()) {
            assertFalse(deck.contains(card.toString()));
            assertTrue(table.contains(card.toString()));
        }
    }
}
