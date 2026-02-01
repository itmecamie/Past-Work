// Name: Camellia Yi
// Date: 11/7/2025
// Class: CS&141 3130
// Assignment: Lab 4 - Random Number Generator
// Purpose:  Create a random number generator game using Java  
// Citation: This program references chapter 5 of Deitel/Deitel - 11th edition
// For extra credit, I did this ....., See the following line numbers.
// I got all this working, but I couldn't get this to work.

import java.util.*;

public class Guess {

    public static final int MAX_NUMBER = 10;
    private static int totalGames = 0;
    private static int totalGuesses = 0;
    private static int bestGame = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        printAsciiTitle();
        introduction();

        boolean playAgain = true;
        while (playAgain) {
            int guessesThisGame = playGame(console);
            totalGames++;
            totalGuesses += guessesThisGame;

            if (guessesThisGame < bestGame) {
                bestGame = guessesThisGame;
            }

            System.out.print("Do you want play again, hehe? ");
            String response = console.next();
            char firstLetter = response.charAt(0);
            if (firstLetter == 'y' || firstLetter == 'Y') {
                playAgain = true;
                System.out.println();
            } else {
                playAgain = false;
            }
        }

        reportResults();
        console.close();
    }

    public static void introduction() {
        System.out.println("Welcome to my guessing game...\n\n");
        System.out.println("Here are the rules: \n\nI will think of a number between 1 and " + MAX_NUMBER + " and will allow you");
        System.out.println("to guess until you get it. \n\nFor each guess, I will tell you whether the");
        System.out.println("right answer is higher or lower than your guess.\n");
    }

    public static int playGame(Scanner console) {
        Random rand = new Random();
        int secretNumber = rand.nextInt(MAX_NUMBER) + 1;

        System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER + "...\n");
        int guessCount = 0;
        int guess = 0;

        while (guess != secretNumber) {
            System.out.print("What number am I thinking of, hm? ");
            guess = console.nextInt();
            guessCount++;

            if (guess < secretNumber) {
                System.out.println("Almost there... higher.");
            } else if (guess > secretNumber) {
                System.out.println("Mm, no. It's lower...");
            } else {
                if (guessCount == 1) {
                    System.out.println("You got it right in 1 guess, you might be psychic!");
                } else {
                    System.out.println("You got it right in " + guessCount + " guesses, nice try...");
                }
            }
        }

        return guessCount;
    }

        public static void reportResults() {
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("    total games   = " + totalGames);
        System.out.println("    total guesses = " + totalGuesses);
        double average = (double) totalGuesses / totalGames;
        System.out.printf("    guesses/game  = %.1f%n", average);
        System.out.println("    best game     = " + bestGame);
    }

    public static void printAsciiTitle() {
        System.out.println("==============================================================");
        System.out.println("   ██████╗ █████╗ ███╗   ███╗██╗███████╗ ███████╗");
        System.out.println("  ██╔════╝██╔══██╗████╗ ████║██║██╔════╝ ██╔════╝");
        System.out.println("  ██║     ███████║██╔████╔██║██║███████  ███████╗");
        System.out.println("  ██║     ██╔══██║██║╚██╔╝██║██║██╚════╗ ╚════██║");
        System.out.println("  ╚██████╗██║  ██║██║ ╚═╝ ██║██║███████║ ███████║");
        System.out.println("   ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝╚══════╝ ╚══════╝");
        System.out.println("  ██████╗ ██╗   ██╗███████╗███████╗███████╗██╗███╗   ██╗ ██████╗ ");
        System.out.println(" ██╔════╝ ██║   ██║██╔════╝██╔════╝██╔════╝██║████╗  ██║██╔════╝ ");
        System.out.println(" ██║  ███╗██║   ██║███████ ███████╗███████╗██║██╔██╗ ██║██║  ███╗");
        System.out.println(" ██║   ██║██║   ██║██╚════╗╚════██║╚════██║██║██║╚██╗██║██║   ██║");
        System.out.println(" ╚██████╔╝╚██████╔╝███████║███████║███████║██║██║ ╚████║ ╚█████╔╝");
        System.out.println("  ╚═════╝  ╚═════╝ ╚══════╝╚══════╝╚══════╝╚═╝╚═╝  ╚═══╝   ╚═══╝ ");
        System.out.println("     ██████╗   █████╗  ███╗   ███╗███████╗");
        System.out.println("    ██╔════╝  ██╔══██╗ ████╗ ████║██╔════╝");
        System.out.println("    ██║  ███╗ ███████║ ██╔████╔██║█████╗  ");
        System.out.println("    ██║   ██║ ██╔══██║ ██║╚██╔╝██║██╔══╝  ");
        System.out.println("    ╚██████╔╝ ██║  ██║ ██║ ╚═╝ ██║███████╗");
        System.out.println("     ╚═════╝  ╚═╝  ╚═╝ ╚═╝     ╚═╝╚══════╝");
        System.out.println("==============================================================\n");
    }
}
