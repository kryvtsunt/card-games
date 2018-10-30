package edu.northeastern.ccs.cs5500.problem1;

/**
 * An AbstractFactory is an abstraction of a Factory (Games and Decks generator).
 *
 * @author Tymofii Kryvtsun
 */
public abstract class AbstractFactory {
    /**
     * Generates a Deck by input Deck Type (look up DeckType Enum).
     *
     * @param type type of the Deck to generate.
     * @return generated Deck.
     */
    public abstract Deck getDeck(DeckType type);

    /**
     * Generates a Deck by input Deck Type (look up DeckType Enum) and number of decks to combine together.
     *
     * @param type          type of the Deck to generate.
     * @param numberOfDecks number of decks to combined together.
     * @return generated Deck.
     */
    public abstract Deck getDeck(DeckType type, int numberOfDecks);

    /**
     * Generates a Game by inputs.
     *
     * @param deckType        type of the Deck.
     * @param numberOfDecks   number of decks to combine together.
     * @param numberOfPlayers number of players in the game.
     * @return generated Game.
     */
    public abstract Game getGame(String deckType, int numberOfDecks, int numberOfPlayers);

    /**
     * /**
     * Generates a Game by inputs.
     *
     * @param deckType        type of the Deck.
     * @param numberOfPlayers number of players in the game.
     * @return generated Game.
     */
    public abstract Game getGame(String deckType, int numberOfPlayers);

}
