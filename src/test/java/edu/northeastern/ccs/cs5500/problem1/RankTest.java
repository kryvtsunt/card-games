package edu.northeastern.ccs.cs5500.problem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotEquals;


/**
 * tests for the Rank implementation
 *
 * @author Tymofii Kryvtsun
 */
public class RankTest {
    private Rank rank1;
    private Rank rank2;
    private Rank rank3;
    private Rank rank4;
    private Rank rank5;
    private List<Rank> ranks;

    /**
     * tests simple ranks constructions
     */
    @Before
    public void testSimpleSuitConstruction() {
        assertNull(rank1);
        assertNull(rank2);
        assertNull(rank3);
        assertNull(rank4);
        assertNull(rank5);
        assertNull(ranks);

        rank1 = StandardRank.ACE;
        rank2 = StandardRank.KING;
        rank3 = StandardRank.QUEEN;
        rank4 = StandardRank.SEVEN;
        rank5 = StandardRank.ACE;
        ranks = new ArrayList<Rank>();

        assertNotNull(rank1);
        assertNotNull(rank2);
        assertNotNull(rank3);
        assertNotNull(rank4);
        assertNotNull(rank5);
        assertNotNull(ranks);
        assertEquals(0, ranks.size());

    }

    /**
     * tests that after construction of all ranks there are 13 unique ranks
     */
    @Test
    public void testConstruction() {
        ranks.addAll(Arrays.asList(StandardRank.values()));
        assertEquals(13, ranks.size());
        assertEquals(ranks.size(), new HashSet<>(ranks).size());
    }

    /**
     * tests ranks equality
     */
    @Test
    public void testRankEquality() {
        assertEquals(rank1, StandardRank.ACE);
        assertEquals(rank2, StandardRank.KING);
        assertEquals(rank3, StandardRank.QUEEN);
        assertEquals(rank4, StandardRank.SEVEN);
        assertEquals(rank1, rank5);
        assertNotEquals(rank1, rank2);
        assertNotEquals(rank2, rank3);
        assertNotEquals(rank4, rank1);
        assertNotEquals(rank1, rank3);
        assertNotEquals(rank2, rank4);
        assertNotEquals(rank3, rank1);
    }

    /**
     * tests getName method of ranks
     */
    @Test
    public void testGetName() {
        assertEquals("A", rank1.getName());
        assertEquals("K", rank2.getName());
        assertEquals("Q", rank3.getName());
        assertEquals("7", rank4.getName());
        assertEquals(rank1.getName(), rank5.getName());
        assertNotEquals(rank1.getName(), rank2.getName());


    }

    /**
     * tests getPips method of ranks
     */
    @Test
    public void testGetPips() {
        assertEquals(0, rank1.getPips());
        assertEquals(0, rank2.getPips());
        assertEquals(0, rank3.getPips());
        assertEquals(7, rank4.getPips());
        assertEquals(rank1.getPips(), rank2.getPips());
        assertEquals(rank1.getPips(), rank5.getPips());
        assertNotEquals(rank2.getPips(), rank4.getPips());
    }


}
