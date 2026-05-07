package org.example;

import java.util.Scanner;
import java.util.Random;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Scoreboard scoreboard = new Scoreboard();
    Random random = new Random();
    String[] insults = {
            "I am some badly written code, and even I can tell that is a bad move!",
            "Wow, you take longer than it took for me to be coded.",
            "This is tic tac toe, not chess.",
            "I also played that move when I first started out.",
            "It is 3am, and I am wondering why I am doing this.",
            "Chess had the right idea if it is boring, just had horses!.",
            "No, don't do that, stop no, please, I want to win.",
            "Did you know the DARE program did the opposite of what it claimed to? Kids who had the DARE program were more likely to do drugs.",
            "Hey, you! Yes, you are the person looking over this and testing the code for our Java class. Have you thought about the last time you jumped? If you play video games, you notice it right away if you can't jump, but we never jump irl.",
            "Why does the tooth fairy need so many teeth???.",
            "OK, but no, for real, why do we teach kids about the tooth fairy??? Like we learn very early on, we should just be ok with the fae stealing our teeth??.",
            "When is the last time you ate a mango? As mangoes are really good. Dude fruit is really good, but some fruit is evil.",
            "Hello, today's code sponsored by Raid Shadow Legends!!! Do you want to play a mid-game that has SO SO MANY microtransactions? Play Raid Shadow Legends today! .",
            "ha lame move.",
            "I bet you don't even know what the color green smells like.",
            "You know the chance of someone just not seeing any of this is kind of funny but also like I have to deal with my thoughts at 2am, someone else should as well.",
            "Yes, I did in fact look up how to add this into my code, fully knowing I did not have to and it would be so much more work.",
            "Did you know that fish are not in fact real? You can trust me, I lie.",
            "Did you know that it takes more fish than you would think to screw in a lightbulb?",
            "Did you know that no matter how hard you try, you can not teach a rock French? Some dreams just are impossible.",
            "Did you know that if you have a problem, it can be solved by just getting better?.",
            "Hey, you, yes you. You are amazing, and I hope your finals go amazingly :) You deserve the best and the best summer.",
            "HEY! NO! BAD! PUT THE ENERGY DRINK DOWN. YOU NEED WATER.",
            "Hey, you, yes you. You are amazing, and I hope your finals go amazingly :) You deserve the best and the best summer.",
            "Hey, you, yes you. You are amazing, and I hope your finals go amazingly :) You deserve the best and the best summer.",
            "Hey, you, yes you. You are amazing, and I hope your finals go amazingly :) You deserve the best and the best summer.",
            "Hey, you, yes you. You are amazing, and I hope your finals go amazingly :) You deserve the best and the best summer.",
            "Hey, you, yes you. You are amazing, and I hope your finals go amazingly :) You deserve the best and the best summer.",
            "Hello, I am the Lorax, and I speak for the trees. The trees are telling me that was a bad move.",
            "Did you know that it takes 1 ant 276 hours to do the work of 276 ants for 1 hour.",
            "Hey, no matter what your future holds, we both know you are not going pro in tic tac toe.",
            "Did you know 99.9% of gamblers quit before they are about to lose even more money?",
            "Hey, if you read this post, your favorite random thought for the discussion board. (also easy points to show you tested it)",
            "Have you ever considered how lonely it is to be a program only used to play this game? For the small moments I exist to play this game, you insult me by playing that move.."

    };
//So all the text above are random things the bot can say to you when playing. Makes it feel more alive and random also makes it so testing my program is less boring
    //I hope you do amazing on your finals this term and if you end up failing a class don't give up!! As like if you do they win! who is they? no idea but they win!
    boolean playAgain = true;
    char nextStarter = 'X';

    System.out.println("Welcome to Tic-Tac-Toe!");

    while (playAgain) {
      System.out.println("\nWhat kind of game would you like to play?");
      System.out.println("1. Human vs. Human");
      System.out.println("2. Human vs. Computer");
      System.out.println("3. Computer vs. Human");
      System.out.print("\nWhat is your selection? ");

      String mode = scanner.nextLine().trim();
      char aiChar = ' ';
      if (mode.equals("2")) aiChar = 'O';
      else if (mode.equals("3")) aiChar = 'X';

      TicTacToe game = new TicTacToe(nextStarter);

      while (!game.isGameOver()) {
        game.printBoard();
        char current = game.getCurrentPlayer();

        if (current == aiChar) {
          String aiMove = game.getComputerMove();
          game.makeMove(aiMove);
          System.out.println("\nComputer chose " + aiMove);
          System.out.println("Computer says: \"" + insults[random.nextInt(insults.length)] + "\"");
        } else {
          System.out.print("\nPlayer " + current + ", please select your move: ");
          String input = scanner.nextLine().trim();
          if (!game.makeMove(input)) {
            System.out.println("\nThat is not a valid move! Please try again.");
          }
        }
      }

      game.printBoard();
      char winner = game.getWinner();
      if (winner != 'D') {
        System.out.println("\nPlayer " + winner + " wins!");
        nextStarter = (winner == 'X') ? 'O' : 'X';
      } else {
        System.out.println("\nIt's a draw!");
      }

      scoreboard.recordWin(winner);
      scoreboard.displayStats();

      System.out.print("\nWould you like to play again (yes/no)? ");
      playAgain = scanner.nextLine().trim().toLowerCase().equals("yes");
    }

    scoreboard.saveToFile();
    System.out.println("\nGoodbye!");
  }
}