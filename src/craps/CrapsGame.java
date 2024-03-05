package craps;

import craps.Player;

public class CrapsGame {
    public static void main(String[] args) {
        printRules();
        craps.Player player = new craps.Player();
        printResults(player);
        player.play();

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
        System.out.println("Player rolled a total sum of: " + player.playerRollSum());
    }
}

