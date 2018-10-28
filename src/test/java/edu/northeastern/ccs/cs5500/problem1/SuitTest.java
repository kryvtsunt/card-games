package edu.northeastern.ccs.cs5500.problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static junit.framework.TestCase.*;

/**
 * tests for the Suit implementation
 *
 * @author Tymofii Kryvtsun
 */
public class SuitTest {
    private Suit suit1;
    private Suit suit2;
    private Suit suit3;
    private Suit suit4;
    private Suit suit5;

    /**
     * tests simple suit construction
     */
    @Before
    public void testSimpleSuitConstruction() {
        assertNull(suit1);
        assertNull(suit2);
        assertNull(suit3);
        assertNull(suit4);
        assertNull(suit5);

        suit1 = StandardSuit.CLUBS;
        suit2 = StandardSuit.DIAMONDS;
        suit3 = StandardSuit.HEARTS;
        suit4 = StandardSuit.SPADES;
        suit5 = StandardSuit.CLUBS;

        assertNotNull(suit1);
        assertNotNull(suit2);
        assertNotNull(suit3);
        assertNotNull(suit4);
        assertNotNull(suit5);

    }

    /**
     * tests suits equality
     */
    @Test
    public void testSuitEquality() {
        assertEquals(suit1, StandardSuit.CLUBS);
        assertEquals(suit2, StandardSuit.DIAMONDS);
        assertEquals(suit3, StandardSuit.HEARTS);
        assertEquals(suit4, StandardSuit.SPADES);
        assertEquals(suit1, suit5);
        assertNotEquals(suit1, suit2);
        assertNotEquals(suit2, suit3);
        assertNotEquals(suit4, suit1);
        assertNotEquals(suit1, suit3);
        assertNotEquals(suit2, suit4);
        assertNotEquals(suit3, suit1);
    }

    /**
     * tests suits getName method
     */
    @Test
    public void testGetName() {
        assertEquals("CLUBS", suit1.getName());
        assertEquals("DIAMONDS", suit2.getName());
        assertEquals("HEARTS", suit3.getName());
        assertEquals("SPADES", suit4.getName());
        assertEquals(suit1.getName(), suit5.getName());
        assertNotEquals(suit1.getName(), suit2.getName());
    }

    /**
     * tests suits getSymbol method
     */
    @Test
    public void testGetSymbol() {
        assertEquals('♣', suit1.getSymbol());
        assertEquals('♦', suit2.getSymbol());
        assertEquals('♥', suit3.getSymbol());
        assertEquals('♠', suit4.getSymbol());
        assertEquals(suit1.getSymbol(), suit5.getSymbol());
        assertNotEquals(suit1.getSymbol(), suit2.getSymbol());

    }
}
