package craps;

import craps.Player;

public class CrapsGame {
    public static void main(String[] args) {
        printRules();
        craps.Player player = new craps.Player();
        player.play();
        printResults(player);
    }

    //TODO Lav om til crabs game
    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDice:");
        System.out.println("The player throws two dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

    //Metode, som kalder "undermetoder" for et objekt
    public static void printResults(Player player) {
        System.out.println("Results");
        System.out.println("-------");
        System.out.println("Player's first roll was: " + player.targetRoll());
        System.out.println("Player's total wins: " + player.getWins());
        System.out.println("Player's total losses: " + player.getLosses());
        System.out.println("You played a total of " + player.getRollCount() + " rounds.");
    }
}

