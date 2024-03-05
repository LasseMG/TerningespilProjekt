package craps;
import java.util.Scanner;

public class Player {

    //Feltvariable
    private craps.Die die1;
    private craps.Die die2;
    private int targetRoll; //Det første roll, som gerne skal slås igen
    private int nextRollSum; //De næste slag, som sammenholdes med targetRoll
    private int rollCount; //Antal runder spillet
    private int wins; //Antal runder vundet
    private int losses; //Antal runder tabt


    //Player Constructor
    public Player() {
        this.die1 = new craps.Die();
        this.die2 = new craps.Die();
    }

    public int getRollCount() {
        return rollCount;
    }

    //Throw dice metode, kalder alle "undermetoder"
    public void throwDie() {
        die1.roll();
        die2.roll();
        targetRoll();
        nextRoll();
        crabGameLogic();
        rollCount++;
    }

    //Metode til at finde sum af første slag
    /*
    Det første slag lagres for at sammenholde det med de næste slag.
    Derfor hvis rollCount == 0, dvs. første runde, så kan vi sætte "målslaget".
     */
    public int targetRoll() {
        if (rollCount == 0) {
            targetRoll = die1.getFaceValue() + die2.getFaceValue();
        }
        return targetRoll;
    }

    //Metode til at finde sum af de næste slag, som skal sammenholdes med første slag
    public int nextRoll() {
        die1.roll();
        die2.roll();
        nextRollSum = die1.getFaceValue() + die2.getFaceValue();
        return nextRollSum;
    }

    //Get metode targetRoll
    public int getTargetRoll() {
        return targetRoll;
    }

    //Get metode til nextRollSum
    public int getNextRollSum() {
        return nextRollSum;
    }

    //Get metode til wins
    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
    //Metode til spillogik
    /*
    I dette spil skal det stoppe når enten:
        - Spiller slår samlet 7 eller 11 som det første --> Vinder (TODO counter == 0)
        - Spiller slår samlet 2, 3, eller 12 som det første --> Taber
        - Spiller på andet slag får den samme sum som i første salg --> Vinder
        - Kaster 7 senere i spillet --> Taber TODO counter over 1...
     */
    String result;
    public String crabGameLogic() {
        if ((targetRoll == 7 || targetRoll == 11) && rollCount == 0) {
            result = "Your first roll was " + targetRoll + "! You win.";
            wins++;
        } else if ((targetRoll == 2 || targetRoll == 3 || targetRoll == 12) && rollCount == 0) {
            result = "Your first roll was " + targetRoll + "! You lose.";
            losses++;
        } else if (nextRollSum == targetRoll) {
            result = "You rolled the same as your first roll of " + targetRoll + ". You win.";
            wins++;
        }
        return result;
    }


    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll?");
        scanner.nextLine();
        boolean finished = false;
        while (!finished) {

            throwDie();
            targetRoll = nextRollSum;

            System.out.printf("Rolling... %d and %d = %d\n", die1.getFaceValue(), die2.getFaceValue(), nextRollSum);
            System.out.println("First role: " + targetRoll);
            System.out.println(result);
            System.out.println("Roll again? (Y/n)");

            String again = scanner.nextLine();
            if (again.toLowerCase().equals("n")) {
                finished = true;
            }
        }
    }
}