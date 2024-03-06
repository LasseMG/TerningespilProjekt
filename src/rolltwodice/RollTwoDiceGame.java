package rolltwodice;

/*
TODO noter til opgaveløsningen:
Skulle gerne virke 100%
 */
public class RollTwoDiceGame {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        rolltwodice.Player player = new rolltwodice.Player(); //Lav ny player-objekt
        System.out.println("Playing RollTwoDice.");
        player.play(); //Kør metoder for player-objekt

        printResults(player); //Print resultater for vores player
        System.out.println();

        System.out.println("Thank you for playing RollTwoDice.");
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDice:");
        System.out.println("The player throws two dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

    public static void printResults(Player player) {
        System.out.println("Results");
        System.out.println("-------");
        System.out.println("Roll count: "+ player.getRollCount()); //Antal gange terninger er rullet
        System.out.println("Total sum of all rolls: " + player.getRollTotalSum()); //Opgave 1.2: Totale sum af alle terningekast
        System.out.println("Number of same-value rolls: " + player.getSameValueRoll()); //Opgave 1.3: Antal slag med to ens resultater
        System.out.println("The biggest value of a single roll was: " + player.getHugeRoll()); //Opgave 1.3: Største slag
        System.out.println("Roll distribution: " + player.printEachResultCount()); //Opgave 1.3: Antal af slag, 1-6
        System.out.println("Average value of dice rolls: " + player.getAverageRoll()); //Opgave 1.3: Gennemsnit af alle kast
    }
}