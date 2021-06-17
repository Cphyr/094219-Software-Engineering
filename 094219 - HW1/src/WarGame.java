public class WarGame {
    /**
     * Defines a war game
     * player1:
     *      type - Player
     *
     * player2:
     *      type - Player
     * current1:
     *      type- Deck
     * current2:
     *      type- Deck
     */

     Player player1;
    Player player2;
    Deck current1;
    Deck current2;
    public WarGame(String name1, String name2){
        /**
         * @param   name1   (String) name of a player.
         *
         * @param   name2   (String) name of different player.
         *
         * @since 1.0
         */
        if(name1.compareTo(name2)>0){
            // If name1 is bigger than name 2
            // player1's name is name2
            this.player2=new Player(name1);
            this.player1=new Player(name2);
        }
        else{
            // If name1 is bigger than name 2
            // player1's name is name2
            this.player1=new Player(name1);
            this.player2=new Player(name2);
        }

        current1=new Deck(false);
        current2=new Deck(false);
    }
    public void  initializeGame(){
        /**
         * Initiates the game
         *
         * @since 1.0
         */
        System.out.println("Initializing the game...");
        // Initiates the deck
        Deck startingDeck= new Deck(true);
        startingDeck.shuffle();
        for(int i=0; i<26;i++){
            // Deals the deck to the players
            player1.addToPlaying(startingDeck.removeTopCard());
            player2.addToPlaying(startingDeck.removeTopCard());
        }
    }
    public void addToPlayer(int dif){
        /**
         * Adds cards used to a player
         * @param:  dif  (int) if dif=1, player1 won.
         *                     if -1,player2 won
         *
         *
         * @since 1.0
         */
        Player player;
        if(dif==-1){
            player=this.player2;
        }
        else if(dif==1){
            player=this.player1;
        }
        else{
            return;
        }
        int size=current1.getDeck().size();
        for(int i=0; i<size; i++){
            // Loops through the cards played and adds them the the winning player
            player.addToWinning(this.current2.removeTopCard());
            player.addToWinning(this.current1.removeTopCard());
        }
    }
    public int War(){
        /**
         * since 1.0
         */
        System.out.println("Starting a war...");
        // Initializes the game
        Card c1=new Card(1,Shape.Diamonds);
        Card c2=new Card(1,Shape.Diamonds);
        for(int i=0; i<3; i++){
            // Check if the player ran out of cards
            if(player2.outOfCards()){
                return 2;
            }
            if(player1.outOfCards()){
                return 1;
            }

            c1=player1.drawCard(i!=2);
            c2=player2.drawCard(i!=2);
            current1.addCard(c1);
            current2.addCard(c2);
        }
        // Checks who drew the higher card.
        // If tie, begins another war
        int dif=c1.compare(c2);
        if(dif==1){
            addToPlayer(dif);
            System.out.println(player1.toString()+" won the war");
            return 0;
        }
        if(dif==-1){
            addToPlayer(dif);
            System.out.println(player2.toString()+" won the war");
            return 0;
        }
        return War();
    }

    public String start(){
        /**
         * starts the game
         *
         * @return: who won the game
         * @since 1.0
         */
        int n=1;
        while (!player2.outOfCards() && !player1.outOfCards()){
            // Loop while every player has cards
            System.out.println("------------------------- Round number "+n+" -------------------------");
            n++;
            // Draws cards
            Card card1=player1.drawCard(false);
            Card card2=player2.drawCard(false);
            // Compares them
            this.current1.addCard(card1);
            this.current2.addCard(card2);
            int dif= card1.compare(card2);
            // If one is higher, print who won
            if(dif!=0){
                addToPlayer(dif);
                if(dif==1){
                    System.out.println(player1.toString()+" won");
                }
                else{
                    System.out.println(player2.toString()+" won");
                }
                continue;
            }
            // If tie, go to war
            int empty=War();
            // Check if a player lost because he ran out of cards.
            //if not, print who won
            if(empty==1){
                return player2.toString();
            }
            if(empty==2){
                return player1.toString();
            }
        }
        // Return who lost
        if(player2.outOfCards()){
            return player1.toString();
        }
        return player2.toString();
    }

}
