package craps;

import craps.Player;

import java.util.Arrays;

/*
TODO: note til opgaveløsningen
Virker 100% efter hensigten med undtagelse for, at man af og til skal trykke to gange for at få første roll.
 */

public class CrapsGame {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        Player player = new Player();
        System.out.println("Playings crab");
        player.play();

        printResults(player);
        System.out.println();

        System.out.println("Thank you for playing crab.");
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of crab:");
        System.out.println("The player throws two dice: ");
        System.out.println("First roll of 7 or 11 = win. 2, 3 or 12 = loss.");
        System.out.println("Match your first roll = win.");
        System.out.println("Roll 7 after your first roll = loss.");
        System.out.println("=====================================================");
    }

    //Metode, som kalder "undermetoder" for et objekt
    public static void printResults(Player player) {
        System.out.println("Results");
        System.out.println("-------");
        System.out.println("Wins: " + player.getWins());
        System.out.println("Losses: " + player.getLosses());
    }
}