package pig;

import java.util.Scanner;

public class PigGame {

    private static int maxPoints;


    //Hvor mange point spilles der til
    public static int howManyTurns() {
        int maxPoints;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many points to win the game?");
        maxPoints = scanner.nextInt();
        return maxPoints;
    }

    //Get maxPoints
    public static int getMaxPoints() {
        return maxPoints;
    }

    //Set max points
    public static void setMaxPoints(int maxPoints) {
        PigGame.maxPoints = maxPoints;
    }

    public void printRules() {

    }

    //Print resultat efter spillet
    public static void printResults(Player player1, Player player2) {
        System.out.println("Max score of " + maxPoints + " reached!");
        System.out.println("Player 1 points: " + player1.getPlayerScore());
        System.out.println("Player 2 points: " + player2.getPlayerScore());
        System.out.println("Player 1 average rolls per turn: ");
        System.out.println("Player 2 average rolls per turn: ");
    }

    //Main metoden
    public static void main(String[] args) {
        //printRules();
        System.out.println();

        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Playing pig");
        int maxPoints = howManyTurns(); //maxPoints er resultatet af denne funktion
        setMaxPoints(maxPoints); //Set maxPoints til ovenstående

        if (player1.getPlayerScore() < maxPoints) {
            System.out.println("Player 1 turn.");
            player1.play();
        }

        if (player2.getPlayerScore() < maxPoints) {
            System.out.println("Player 2 turn.");
            player2.play();
        }

        printResults(player1, player2);
        System.out.println("Thank you for playing pig.");
    }
}
