package pig;

import java.util.Scanner;

/*
TODO: note til opgaveløsningen
Spillet virker så det kan tælle point sammen for hver runde.

Turen går videre til anden spiller, hvis man slår 1, eller hvis man når maxPoints (antal point man spiller til)

Dog kan vi ikke få programmet til at afslutte spillet, når maxPoints er nået, og derefter printe resultat osv.
Den sidder fast i at give turen videre til anden spiller.
Vi har prøvet forskellige while loops og break; , men vi lykkedes ikke med det.

Derfor er spillet ikke 100% færdigt.
 */

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

    public static void printRules() {
        System.out.println();
        System.out.println("---------RULES---------");
        System.out.println();
        System.out.println("Roll 1 - no points, lose round points.");
        System.out.println("Roll anything but 1, roll added to points.");
        System.out.println("Roll again? Yes - chance to add more points or lose all. No - keep current points.");
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
    /*

     */
    public static void main(String[] args) {
        printRules();
        System.out.println();

        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Playing pig");
        int maxPoints = howManyTurns(); //maxPoints er resultatet af denne funktion
        setMaxPoints(maxPoints); //Set maxPoints til ovenstående

        //Denne skulle gerne stoppe spillet, når enten player1 eller player2 har opnået maxPoint
        boolean gameEnd = false;

        while (!gameEnd) {
            if (player1.getPlayerScore() >= maxPoints) {
                gameEnd = true;
            }
            System.out.println();
            System.out.println("Player 1 turn.");
            player1.play();

            if (player2.getPlayerScore() >= maxPoints) {
                gameEnd = true;
            }

            System.out.println();
            System.out.println("Player 2 turn.");
            player2.play();


        }
        System.out.println("Max point reached!");
        printResults(player1, player2);
        System.out.println("Thank you for playing pig.");
    }
}

