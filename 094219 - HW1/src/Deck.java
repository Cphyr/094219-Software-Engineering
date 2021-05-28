import java.util.LinkedList;

public class Deck {
    /**
     * A deck of cards
     *
     * @param   deck    (LinkedList) last item is the top of the deck
     */

    private LinkedList<Card> deck;

    public Deck(boolean toInit) {
        /**
         * @param   toInit  (boolean) if true, the deck will be init to full in order:
         *                  Club1, ..., Club13,
         *                  Diamond1, ..., Diamond13,
         *                  Spade1, ..., Spade13,
         *                  Heart1, ..., Heart13.
         *
         *                  else, init deck as empty.
         * @since   1.0
         */
        if(toInit) {
            deck = new LinkedList<Card>();

            for (Shape shape : Shape.values()) {
                for (int num = 1; num <= 13; ++num){
                    deck.addLast(new Card(num, shape));
                }
            }

        }

        else deck = new LinkedList<Card>();
    }

    public void addCard(Card card) {
        /**
         * @since   1.0
         */
        deck.addLast(card);
    }

    public Card removeTopCard() {
        /**
         * @since   1.0
         */
        return deck.removeLast();
    }

    public boolean isEmpty() {
        /**
         * @since   1.0
         */
        return deck.isEmpty();
    }

    public void shuffle() {
        /**
         * shuffle the deck
         * do 50 times:
         *      switch 2 random cards
         *
         * @since   1.0
         */
        for (int i = 0; i < 50; ++i) {

            // Generate 2 random indices in range of the size of the deck.
            int ind1 = Main.rnd.nextInt(deck.size());
            int ind2 = Main.rnd.nextInt(deck.size());

            // Swap the cards
            Card temp = deck.get(ind2);
            deck.set(ind2, deck.get(ind1));
            deck.set(ind1, temp);


        }
    }
}
