package org.example.poker.domain.impl;

import org.example.poker.domain.Card;
import org.example.poker.domain.CardSuit;
import org.example.poker.domain.CardValue;

import java.util.Collection;
import java.util.List;

public class TestUtility {

    static final Collection<Card> HIGH_CARD_LOW = List.of(new CardImpl(CardSuit.C, CardValue.EIGHT),
                                                          new CardImpl(CardSuit.D, CardValue.TWO),
                                                          new CardImpl(CardSuit.H, CardValue.SIX),
                                                          new CardImpl(CardSuit.S, CardValue.FOUR),
                                                          new CardImpl(CardSuit.C, CardValue.NINE));
    static final Collection<Card> HIGH_CARD_HIGH = List.of(new CardImpl(CardSuit.C, CardValue.NINE),
                                                           new CardImpl(CardSuit.D, CardValue.THREE),
                                                           new CardImpl(CardSuit.H, CardValue.SEVEN),
                                                           new CardImpl(CardSuit.S, CardValue.KING),
                                                           new CardImpl(CardSuit.C, CardValue.EIGHT));
    static final Collection<Card> PAIR_LOW = List.of(new CardImpl(CardSuit.S, CardValue.JACK),
                                                     new CardImpl(CardSuit.D, CardValue.ACE),
                                                     new CardImpl(CardSuit.C, CardValue.FIVE),
                                                     new CardImpl(CardSuit.C, CardValue.TWO),
                                                     new CardImpl(CardSuit.H, CardValue.JACK));
    static final Collection<Card> PAIR_HIGH = List.of(new CardImpl(CardSuit.H, CardValue.QUEEN),
                                                      new CardImpl(CardSuit.D, CardValue.TEN),
                                                      new CardImpl(CardSuit.C, CardValue.FIVE),
                                                      new CardImpl(CardSuit.S, CardValue.QUEEN),
                                                      new CardImpl(CardSuit.C, CardValue.TWO));
    static final Collection<Card> TWO_PAIR_LOW = List.of(new CardImpl(CardSuit.H, CardValue.QUEEN),
                                                         new CardImpl(CardSuit.S, CardValue.QUEEN),
                                                         new CardImpl(CardSuit.D, CardValue.NINE),
                                                         new CardImpl(CardSuit.C, CardValue.KING),
                                                         new CardImpl(CardSuit.C, CardValue.NINE));
    static final Collection<Card> TWO_PAIR_HIGH = List.of(new CardImpl(CardSuit.H, CardValue.QUEEN),
                                                          new CardImpl(CardSuit.D, CardValue.TEN),
                                                          new CardImpl(CardSuit.S, CardValue.QUEEN),
                                                          new CardImpl(CardSuit.C, CardValue.TEN),
                                                          new CardImpl(CardSuit.C, CardValue.TWO));
    static final Collection<Card> SAME_PAIR_LOW = List.of(new CardImpl(CardSuit.S, CardValue.JACK),
                                                          new CardImpl(CardSuit.D, CardValue.KING),
                                                          new CardImpl(CardSuit.C, CardValue.FIVE),
                                                          new CardImpl(CardSuit.C, CardValue.TWO),
                                                          new CardImpl(CardSuit.H, CardValue.JACK));
    static final Collection<Card> SAME_PAIR_HIGH = List.of(new CardImpl(CardSuit.S, CardValue.JACK),
                                                           new CardImpl(CardSuit.D, CardValue.ACE),
                                                           new CardImpl(CardSuit.H, CardValue.JACK),
                                                           new CardImpl(CardSuit.C, CardValue.FIVE),
                                                           new CardImpl(CardSuit.C, CardValue.TWO));
    static final Collection<Card> SAME_TWO_PAIR_LOW = List.of(new CardImpl(CardSuit.H, CardValue.QUEEN),
                                                              new CardImpl(CardSuit.D, CardValue.NINE),
                                                              new CardImpl(CardSuit.C, CardValue.THREE),
                                                              new CardImpl(CardSuit.C, CardValue.NINE),
                                                              new CardImpl(CardSuit.S, CardValue.QUEEN));
    static final Collection<Card> SAME_TWO_PAIR_HIGH = List.of(new CardImpl(CardSuit.H, CardValue.QUEEN),
                                                               new CardImpl(CardSuit.S, CardValue.QUEEN),
                                                               new CardImpl(CardSuit.D, CardValue.NINE),
                                                               new CardImpl(CardSuit.C, CardValue.KING),
                                                               new CardImpl(CardSuit.C, CardValue.NINE));
    static final Collection<Card> THREE_OF_A_KIND_LOW = List.of(new CardImpl(CardSuit.H, CardValue.FOUR),
                                                                new CardImpl(CardSuit.S, CardValue.FOUR),
                                                                new CardImpl(CardSuit.D, CardValue.FOUR),
                                                                new CardImpl(CardSuit.C, CardValue.FIVE),
                                                                new CardImpl(CardSuit.C, CardValue.ACE));
    static final Collection<Card> THREE_OF_A_KIND_HIGH = List.of(new CardImpl(CardSuit.H, CardValue.JACK),
                                                                 new CardImpl(CardSuit.S, CardValue.JACK),
                                                                 new CardImpl(CardSuit.D, CardValue.JACK),
                                                                 new CardImpl(CardSuit.C, CardValue.FIVE),
                                                                 new CardImpl(CardSuit.C, CardValue.TWO));
    static final Collection<Card> STRAIGHT_LOW = List.of(new CardImpl(CardSuit.H, CardValue.TEN),
                                                         new CardImpl(CardSuit.D, CardValue.EIGHT),
                                                         new CardImpl(CardSuit.S, CardValue.NINE),
                                                         new CardImpl(CardSuit.C, CardValue.SEVEN),
                                                         new CardImpl(CardSuit.C, CardValue.SIX));
    static final Collection<Card> STRAIGHT_HIGH = List.of(new CardImpl(CardSuit.H, CardValue.QUEEN),
                                                          new CardImpl(CardSuit.C, CardValue.NINE),
                                                          new CardImpl(CardSuit.S, CardValue.JACK),
                                                          new CardImpl(CardSuit.D, CardValue.TEN),
                                                          new CardImpl(CardSuit.C, CardValue.EIGHT));
    static final Collection<Card> FLUSH_LOW = List.of(new CardImpl(CardSuit.H, CardValue.ACE),
                                                      new CardImpl(CardSuit.H, CardValue.QUEEN),
                                                      new CardImpl(CardSuit.H, CardValue.JACK),
                                                      new CardImpl(CardSuit.H, CardValue.TEN),
                                                      new CardImpl(CardSuit.H, CardValue.TWO));
    static final Collection<Card> FLUSH_HIGH = List.of(new CardImpl(CardSuit.S, CardValue.ACE),
                                                       new CardImpl(CardSuit.S, CardValue.KING),
                                                       new CardImpl(CardSuit.S, CardValue.JACK),
                                                       new CardImpl(CardSuit.S, CardValue.TEN),
                                                       new CardImpl(CardSuit.S, CardValue.TWO));
    static final Collection<Card> FULL_HOUSE_LOW = List.of(new CardImpl(CardSuit.H, CardValue.JACK),
                                                           new CardImpl(CardSuit.S, CardValue.JACK),
                                                           new CardImpl(CardSuit.D, CardValue.JACK),
                                                           new CardImpl(CardSuit.C, CardValue.TEN),
                                                           new CardImpl(CardSuit.C, CardValue.TEN));
    static final Collection<Card> FULL_HOUSE_HIGH = List.of(new CardImpl(CardSuit.H, CardValue.QUEEN),
                                                            new CardImpl(CardSuit.S, CardValue.QUEEN),
                                                            new CardImpl(CardSuit.D, CardValue.QUEEN),
                                                            new CardImpl(CardSuit.C, CardValue.TEN),
                                                            new CardImpl(CardSuit.C, CardValue.TEN));

    static final Collection<Card> FOUR_OF_A_KIND_LOW = List.of(new CardImpl(CardSuit.H, CardValue.THREE),
                                                               new CardImpl(CardSuit.S, CardValue.THREE),
                                                               new CardImpl(CardSuit.D, CardValue.THREE),
                                                               new CardImpl(CardSuit.C, CardValue.THREE),
                                                               new CardImpl(CardSuit.C, CardValue.JACK));
    static final Collection<Card> FOUR_OF_A_KIND_HIGH = List.of(new CardImpl(CardSuit.H, CardValue.SEVEN),
                                                                new CardImpl(CardSuit.S, CardValue.SEVEN),
                                                                new CardImpl(CardSuit.D, CardValue.SEVEN),
                                                                new CardImpl(CardSuit.C, CardValue.SEVEN),
                                                                new CardImpl(CardSuit.C, CardValue.TWO));
    static final Collection<Card> STRAIGHT_FLUSH_LOW = List.of(new CardImpl(CardSuit.S, CardValue.EIGHT),
                                                               new CardImpl(CardSuit.S, CardValue.TEN),
                                                               new CardImpl(CardSuit.S, CardValue.SEVEN),
                                                               new CardImpl(CardSuit.S, CardValue.NINE),
                                                               new CardImpl(CardSuit.S, CardValue.SIX));
    static final Collection<Card> STRAIGHT_FLUSH_HIGH = List.of(new CardImpl(CardSuit.H, CardValue.QUEEN),
                                                                new CardImpl(CardSuit.H, CardValue.EIGHT),
                                                                new CardImpl(CardSuit.H, CardValue.TEN),
                                                                new CardImpl(CardSuit.H, CardValue.JACK),
                                                                new CardImpl(CardSuit.H, CardValue.NINE));
}
