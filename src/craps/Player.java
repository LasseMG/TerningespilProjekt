package craps;
import java.util.Scanner;

public class Player {

    //Feltvariable
    private craps.Die die1;
    private craps.Die die2;
    private int firstRoll; //Det første roll, som gerne skal slås igen
    private int nextRoll; //De næste slag, som sammenholdes med targetRoll
    private int rollCount; //Antal runder spillet før et loss, sættes til 0 efter win eller loss, så der kan findes ny firstRoll.
    private int wins; //Antal runder vundet
    private int losses; //Antal runder tabt


    public Player() {
        this.die1 = new craps.Die();
        this.die2 = new craps.Die();
    }

    //Get metode rollCount
    public int getRollCount() {
        return rollCount;
    }

    //Get metode losses
    public int getLosses() {
        return losses;
    }

    //Get metode wins
    public int getWins() {
        return wins;
    }

    // + 1
    public void updateWins() {
        wins++;
    }

    // + 1
    public void updateLosses() {
        losses++;
    }


    public void throwDie() {
        die1.roll();
        die2.roll();
        setFirstRoll();
        rollCount++;
    }

    public void setFirstRoll() {
        if (rollCount == 0) {
            firstRoll = die1.getFaceValue() + die2.getFaceValue();
        } else {
            nextRoll = die1.getFaceValue() + die2.getFaceValue();
        }
    }

    //First roll win eller loss
    public void firstRollOutcome() {
        if (firstRoll == 7 || firstRoll == 11) {
            System.out.println("7 or 11. WIN");
            updateWins();
            rollCount = 0;
        } else if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
            System.out.println("First roll, bad roll. LOSS");
            updateLosses();
            rollCount = 0;
        } else {
            boolean stopGame = false;
            while (!stopGame) {
                if (nextRoll == firstRoll) {
                    System.out.println("Same as first roll. WIN");
                    updateWins();
                    rollCount = 0;
                    stopGame = true;
                } else if (nextRoll == 7) {
                    System.out.println("Bad roll. LOSS");
                    updateLosses();
                    rollCount = 0;
                    stopGame = true;
                } else {
                    stopGame = true;
                }
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you ready to play?");
        scanner.nextLine();
        boolean finished = false;
        while (!finished) {

            throwDie();

            System.out.printf("Rolling... %d, %d\n", die1.getFaceValue(), die2.getFaceValue());
            System.out.println("Current roll: " + nextRoll);
            System.out.println("First roll: " + firstRoll);

            firstRollOutcome();

            System.out.println("Roll again? (Y/n)");
            String again = scanner.nextLine();

            if (again.toLowerCase().equals("n")) {
                finished = true;
            }
        }
        scanner.close();
    }
}
/*
PROGRAMMET SKAL KUNNE GØRE FØLGENDE:
 - Tælle antal runder, hvor mange rolls
 - Tælle wins og losses X
 - Rulle 7 eller 11 først = win X
 - Reset firstRoll efter win eller loss X
 - firstRoll = nextRoll = win X
 - Opdater (glemte hvad jeg skulle skrive)
 - Rul 7 efter 1. runde = loss X
 */

/*
TODO:
Hvorfor skal jeg trykke 2 gange, før der så kommer 2 rolls?
 - 1 tryk, ingen output
 - sker kun i nogen tilfælde
 */
