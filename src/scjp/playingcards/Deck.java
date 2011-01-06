/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scjp.playingcards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angus
 */
public class Deck {

    final List<Card> theCards = new ArrayList();

    public Deck() {
        for (Suit theSuit : Suit.values()) {
            for (Rank theRank : Rank.values()) {
                theCards.add(new Card(theSuit, theRank));
            }
        }
    }

    public List<Card> getTheCards() {
        return theCards;
    }

    public static void main(String[] args) {

        Deck theDeck = new Deck();
        List<Card> cards = theDeck.getTheCards();
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
