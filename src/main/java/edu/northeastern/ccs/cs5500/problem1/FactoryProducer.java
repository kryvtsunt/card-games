package edu.northeastern.ccs.cs5500.problem1;

/**
 * FactoryProducer creates different types of Factories depending on the request (one of FactoryType)
 *
 * @author Tymofii Kryvtsun
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(FactoryType type) {
        if (type == null) {
            return null;
        }
        if (type.equals(FactoryType.DECK)) {
            return new DeckFactory();
        } else if (type.equals(FactoryType.GAME)) {
            return new GameFactory();
        } else return null;
    }
}
