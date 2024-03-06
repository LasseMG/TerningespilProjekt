package pig;

import java.util.Scanner;

public class PigGame {

    static Scanner scanner = new Scanner(System.in);
    public void printRules() {

    }

    public static int howManyTurns() {
        int maxPoints;
        System.out.println("How many points to win the game?");
        maxPoints = scanner.nextInt();
        return maxPoints;
    }


    public static void printResults(Player player1, Player player2) {
        System.out.println("Player 1 points: " + player1.getPlayerScore());
        System.out.println("Player 2 points: " + player2.getPlayerScore());
        System.out.println("Player 1 average rolls per turn: ");
        System.out.println("Player 2 average rolls per turn: ");
    }

    public static void main(String[] args) {
        //printRules();
        System.out.println();

        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Playing pig");

        System.out.println("Player 1 turn.");
        player1.play();

        System.out.println("Player 2 turn.");
        player2.play();

        /*
        If-statement
         */
        printResults(player1, player2);
        System.out.println("Thank you for playing pig.");
    }
}
