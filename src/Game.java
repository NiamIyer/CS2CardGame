import java.util.Scanner;

public class Game {
        // Creates instance variables
        private Deck myDeck;
        private Player myPlayer;
        private Player dealer;
        Scanner input = new Scanner(System.in);
        private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        private int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        private String[] ranks = {"2" ,"3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        // Creates deck, dealer and player
        public Game()
        {
            System.out.println("Please Enter Your Name: ");
            myPlayer = new Player(input.nextLine());
            dealer = new Player("Dealer");
            myDeck = new Deck(ranks, suits, values);

        }
        // Makes instances of game class to run functions
        public static void main(String[] args) {
            Game bJack = new Game();
            bJack.printInstructions();
            bJack.playGame();

        }

        public static void printInstructions() {
            System.out.println
                    ("""
                           This is blackjack.
                           You are supposed to get as close to 21 as possible without going over.
                           Each card is worth their number value, face cards are worth ten.
                           Aces are worth either one or eleven.
                           When you get your cards there are two options:
                           A) Hit, type in h and you will get another card.
                           B) Stand, type in s and you won't draw any cards and you will end your turn.
                           If you have over 21, you lose.
                           If the dealer is closer to 21 than you without being over, you also lose.
                           If you hit 21 exactly, you automatically win.
                           If you bust or choose to leave, you "lose" and leave the game.
                           The game goes on for as long as you want and counts your wins.
                            """);
        }
        public void playGame()
        {
            // Initializes most instance variables inside while loop so they reset after each round
            boolean gameOver = false;
            while (gameOver == false) {
                int dealerSum = 0;
                int sum = 0;
                boolean blackJack = false;
                boolean isFinished = false;
                myDeck.shuffle();
                // Empties player's hand and draws two cards
                myPlayer.emptyHand();
                myPlayer.addCard(myDeck.deal());
                myPlayer.addCard(myDeck.deal());
                // Finds sum by combining the value of the 0th and 1st indexes of the hand which are the dealt cards
                // This is because the hand is cleared.
                System.out.println("Your hand is: " + myPlayer.getHand());
                sum = myPlayer.getHand().get(0).getValue() + myPlayer.getHand().get(1).getValue();
                System.out.println("These cards are worth a combined " + sum);
                // While the player's turn isn't done
                while (isFinished == false) {
                    // Initially checks if the player has a blackjack so they can't draw at 21
                    if (sum == 21)
                    {
                        System.out.println("You got a blackjack!");
                        myPlayer.addPoints(1);
                        System.out.println("You have " + myPlayer.getPoints() + " wins");
                        isFinished = true;
                        blackJack = true;
                        continue;
                    }
                    System.out.println("Would you like to hit or stand (h or s)? ");
                    // Accounts for 'H' and 'h'
                    String decision = input.nextLine().toLowerCase();
                    if (decision.equals("h")) {
                        // Gives the player another card and recalculates the sum
                        // Uses size - 1 for sum because there could be more than 1 hit
                        myPlayer.addCard(myDeck.deal());
                        System.out.println("Your hand is: " + myPlayer.getHand());
                        sum += myPlayer.getHand().get(myPlayer.getHand().size() - 1).getValue();
                        System.out.println("These cards are worth a combined " + sum);
                        // Checks if player busted, if so kicks them out of inner loop and sets gameOver to true
                        if (sum > 21) {
                            System.out.println("You got over 21 and lost!");
                            isFinished = true;
                            gameOver = true;
                            break;
                        }
                        // Checks if they get a blackjack later on
                        else if (sum == 21) {
                            System.out.println("You got a blackjack!");
                            myPlayer.addPoints(1);
                            System.out.println("You have " + myPlayer.getPoints() + " wins");
                            isFinished = true;
                            blackJack = true;
                            continue;
                        }
                    }
                    // Breaks instead of setting isFinished to true to avoid an extra check
                    else if (decision.equals("s")){
                        System.out.println("You chose to Stand. ");
                        break;
                    }
                    else {
                        System.out.println("Please enter h or s. ");
                    }
                }
                // Rechecks gameOver because the first break couldn't get out of the outer loop
                if (gameOver == true)
                {
                    break;
                }
                // If there is not a blackJack, deal the cards to the dealer
                if (blackJack == false) {
                    dealer.emptyHand();
                    dealer.addCard(myDeck.deal());
                    dealer.addCard(myDeck.deal());
                    // Calculates the dealerSum the same way it calculates the player's
                    dealerSum = dealer.getHand().get(0).getValue() + dealer.getHand().get(1).getValue();
                    // Always hits under 17, even if the player stands before 17
                    while (dealerSum < 17){
                        dealer.addCard(myDeck.deal());
                        dealerSum += dealer.getHand().get(dealer.getHand().size() - 1).getValue();
                    }
                    // Doesn't show the dealers cards to avoid card counting if one were so inclined
                    if (dealerSum > 21) {
                        System.out.println("Dealer Busted! ");
                        myPlayer.addPoints(1);
                        System.out.println("You have " + myPlayer.getPoints() + " wins");
                    }
                    // Ends the game if the dealer wins
                    else if (dealerSum > sum) {
                        System.out.println("The dealer got " + dealerSum + ", while you got " + sum + ". ");
                        gameOver = true;
                        break;
                    }
                    else {
                        System.out.println("Dealer has " + dealerSum);
                        System.out.println("You won! ");
                        myPlayer.addPoints(1);
                        System.out.println("You have " + myPlayer.getPoints() + " wins");

                    }
                    // Only accounts for no so that there is 1 less check
                    System.out.println("Do you want to play again (y/n)");
                    if (input.nextLine().equals("n")){
                        gameOver = true;
                        break;
                    }
                    // Empties hand again, probably redundant
                    myPlayer.emptyHand();
                    dealer.emptyHand();


                }



            }
            // Prints win count after loss
            System.out.println("You have " + myPlayer.getPoints() + " wins");
        }
}
