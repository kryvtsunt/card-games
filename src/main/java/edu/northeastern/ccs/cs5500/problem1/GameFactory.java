package edu.northeastern.ccs.cs5500.problem1;

/**
 * Game generator/factory.
 *
 * @author Tymoii Kryvtsun
 */
public class GameFactory extends AbstractFactory {

    @Override
    Deck getDeck(DeckType type) {
        return null;
    }

    @Override
    Deck getDeck(DeckType type, int numberOfDecks) {
        return null;
    }

    @Override
    public Game getGame(String deckType, int numberOfDecks, int numberOfPlayers) throws IllegalArgumentException {
        Game game = new SimpleGame();
        game.createDeck(deckType, numberOfDecks);
        game.setNumberOfHands(numberOfPlayers);
        game.deal();
        return game;
    }

    @Override
    public Game getGame(String deckType, int numberOfPlayers) {
        Game game = new SimpleGame();
        game.createDeck(deckType);
        game.setNumberOfHands(numberOfPlayers);
        game.deal();
        return game;
    }

}
