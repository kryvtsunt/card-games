package edu.northeastern.ccs.cs5500.problem1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A Simple implementation of the Game, that can take any type of deck and distribute all its cards between all hands.
 *
 * @author Tymofii Kryvtsun
 */
public class SimpleGame implements Game {

    /**
     * List of Hands (all game players).
     */
    private ArrayList<Hand> players;
    /**
     * Deck of Card for the Game.
     */
    private Deck deck;

    /**
     * Constructor.
     */
    public SimpleGame() { }

    @Override
    public void createDeck(String str) throws IllegalArgumentException {
        if (str == null) {
            return;
        }
        AbstractFactory deckFactory = FactoryProducer.getFactory(FactoryType.DECK);
        for (DeckType type : DeckType.values()) {
            if (str.equalsIgnoreCase(type.toString())) {
                this.deck = deckFactory.getDeck(type);
                return;
            }
        }
        throw new IllegalArgumentException("Invalid deck type");
    }

    @Override
    public void createDeck(String str, int i) throws IllegalArgumentException {
        if (str == null) {
            return;
        }
        AbstractFactory deckFactory = FactoryProducer.getFactory(FactoryType.DECK);
        for (DeckType type : DeckType.values()) {
            if (str.equalsIgnoreCase(type.toString())) {
                this.deck = deckFactory.getDeck(type, i);
                return;
            }
        }
        throw new IllegalArgumentException("Invalid deck type");

    }

    @Override
    public void setNumberOfHands(int n) throws IllegalArgumentException {
        if (n < 2 || n > 24) {
            throw new IllegalArgumentException("Invalid number of hands");
        }
        this.players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(new StandardHand());
        }
    }

    @Override
    public void deal() throws IllegalArgumentException {
        if (this.deck == null) {
            throw new IllegalArgumentException("NULL argument");
        }
        while (true) {
            for (Hand player : players) {
                if (!this.deck.emptyDeck()) {
                    try {
                        player.accept(this.deck.pullCard());
                    } catch (IllegalAccessException e) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.deck != null) {
            sb.append("Deck:").append(this.deck.toString()).append("\n");
        }
        if (!this.players.isEmpty()) {
            for (int i = 0; i < this.players.size(); i++) {
                sb.append("Player").append(i + 1).append(" :").append(this.players.get(i).showCards()).append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Game)) {
            return false;
        }
        Game g = (Game) o;
        return (this.toString().equals(g.toString()));


    }

    @Override
    public int hashCode() {
        return Objects.hash(this.deck, this.players);
    }

}
