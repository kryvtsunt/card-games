package edu.northeastern.ccs.cs5500.problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * tests for a GameFactory (more convenient way to create Games)
 *
 * @author Tymofii KRyvtsun
 */
public class GameFactoryTest {
    private AbstractFactory gameFactory;
    private Game game1;
    private Game game2;
    private Game game3;
    private Game game4;
    private Game game5;

    /**
     * tests games construction using factory
     */
    @Before
    public void testConstruction() {
        assertNull(gameFactory);
        gameFactory = FactoryProducer.getFactory(FactoryType.GAME);
        assertNotNull(gameFactory);

        assertNull(game1);
        assertNull(game2);
        assertNull(game3);
        assertNull(game4);
        assertNull(game5);

        game1 = gameFactory.getGame("STANDARD", 4);
        game2 = gameFactory.getGame("PINOCHLE", 2);
        game3 = gameFactory.getGame("EUCHRE", 6);
        game4 = gameFactory.getGame("VEGAS", 8);
        game5 = gameFactory.getGame("VEGAS", 3, 5);

        assertNotNull(game1);
        assertNotNull(game2);
        assertNotNull(game3);
        assertNotNull(game4);
        assertNotNull(game5);

    }

    /**
     * tests invalid games construction using factories
     */
    @Test
    public void testInvalidConstruction() {
        try {
            gameFactory.getGame("STANDARD", 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of hands", e.getMessage());
        }
        try {
            gameFactory.getGame("PINOCHLE", 44);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of hands", e.getMessage());
        }
        try {
            gameFactory.getGame("BESTGAME", 2);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid deck type", e.getMessage());
        }
        try {
            gameFactory.getGame("VEGAS", 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of hands", e.getMessage());
        }
        try {
            gameFactory.getGame("VEGAS", 1, 2);
        } catch (IllegalArgumentException e) {
            assertEquals("Vegas deck should be of 2-8 standard decks", e.getMessage());
        }
        try {
            gameFactory.getGame("EUCHRE", 12, 4);
        } catch (IllegalArgumentException e) {
            assertEquals("Only Vegas type has arbitrary number of decks", e.getMessage());
        }
    }

    /**
     * tests that all cards are distributed between hands
     */
    @Test
    public void testDeal() {
        String deck, table;
        deck = game1.toString().split("Player1")[0];
        table = game1.toString().split("Player1")[1];
        Deck standardDeck = new StandardDeck();
        for (Card card : standardDeck.getCards()) {
            assertFalse(deck.contains(card.toString()));
            assertTrue(table.contains(card.toString()));
        }
    }

}
