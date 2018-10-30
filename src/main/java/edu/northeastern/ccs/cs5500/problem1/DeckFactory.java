package edu.northeastern.ccs.cs5500.problem1;

/**
 * Deck generator/facory.
 *
 * @author Tymofii Kryvtsun
 */
public class DeckFactory extends AbstractFactory {
    @Override
    public Deck getDeck(DeckType type) {
        if (type == null) {
            return null;
        }
        if (type.equals(DeckType.STANDARD)) {
            return new StandardDeck();
        } else if (type.equals(DeckType.PINOCHLE)) {
            return new PinochleDeck();
        } else if (type.equals(DeckType.VEGAS)) {
            return new VegasDeck(6);
        } else if (type.equals(DeckType.EUCHRE)) {
            return new EuchreDeck();
        } else throw new IllegalArgumentException("Invalid deck type");
    }

    @Override
    public Deck getDeck(DeckType type, int numberOfDecks) {
        if (type == null) {
            return null;
        }
        if (type.equals(DeckType.VEGAS)) {
            return new VegasDeck(numberOfDecks);
        } else throw new IllegalArgumentException("Only Vegas type has arbitrary number of decks");
    }

    @Override
    Game getGame(String deckType, int numberOfDecks, int numberOfPlayers) {
        return null;
    }

    @Override
    Game getGame(String deckType, int numberOfPlayers) {
        return null;
    }

}
