package edu.northeastern.ccs.cs5500.problem1;

/**
 * Represents a Card Game.
 *
 * @author Tymofii Kryvtsun
 */
public interface Game {
    /**
     * Creates a Deck of the given type.
     * Deck Type is one of:
     * <ul>
     * <li> Standard </li>
     * <li> Pinochle </li>
     * <li> Euchre </li>
     * <li> Vegas </li>
     * </ul>
     *
     * @param deckType the createed deck.
     * @throws IllegalArgumentException when the deckType is invalid
     */
    void createDeck(String deckType);

    /**
     * Creates a Deck of the given type, multiplying it by numberOfDecks times.
     * NumberOdDecks parameter is available only for Vegas type Decks, and it should be between 2 and 8 decks.
     * Deck Type is one of:
     * <ul>
     * <li> Standard </li>
     * <li> Pinochle </li>
     * <li> Euchre </li>
     * <li> Vegas </li>
     * </ul>
     *
     * @param deckType      type of the deck.
     * @param numberOfDecks defines number of decks of one type appended together (multiplier).
     * @throws IllegalArgumentException when the deckType or numberOfDecks is invalid
     */
    void createDeck(String deckType, int numberOfDecks);

    /**
     * Sets the number of players in the game.
     *
     * @param howManyHands number of Players in the Game.
     * @throws IllegalArgumentException when the number of hands is not in [2..24] range
     */
    void setNumberOfHands(int howManyHands);

    /**
     * Distributes all the Cards from the deck to all players equally.
     *
     * @throws IllegalArgumentException if the deck is not given
     */
    void deal();
}
