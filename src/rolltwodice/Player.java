package rolltwodice;

import java.util.Scanner;

public class Player {
    /*
    Ændringer fra RollOneDie:
    - Opgave 1.1: tilføjet endnu en terning, som skal holde faceValue værdi, altså slagets værdi (linje 11)
    - Opgave 1.3. tilføjet variabel til at holde antal slag, der har været ens (linje 15)
     */
    private rolltwodice.Die die1;
    private rolltwodice.Die die2;
    private int rollCount;
    private int rollTotalSum;
    private int sameValueRoll;
    private int hugeRoll;
    private double averageRoll;

    /*
    Ændringer fra RollOneDie:
    - Opgave 1.1: lavet et objekt mere i Player constructor, så Player nu "består" af 2 terninger (linje 20)
     */
    public Player() {
        this.die1 = new rolltwodice.Die();
        this.die2 = new rolltwodice.Die();
    }

    public int getRollCount() {
        return rollCount;
    }

    /*
    Ændringer fra RollOneDie:
    - Opgave 1.1: kør ligeledes funktionen for anden terning (linje 33)
    - Opgave 1.2: tilføj del i metoden, som lægger slag sammen og opdaterer værdien for hvert slag.
    - Opgave 1.3: tilføjet sameDiceValue metode.
     */
    public void throwDie() {
        die1.roll();
        die2.roll();
        rollCount++;
        rollTotalSum += die1.getFaceValue() + die2.getFaceValue();
        sameDiceValue();
        biggestRoll();
        setEachResultCount();
        calculateAverageRoll();
    }

    /*
    Opgave 1.2: Tilføjet get-metode til summen af alle slag
     */
    public int getRollTotalSum() {
        return rollTotalSum;
    }

    public int getSameValueRoll() {
        return sameValueRoll;
    }

    public int getHugeRoll() {
        return hugeRoll;
    }

    //Opgave 1.3: Slag med samme antal øjne
    /*
    - sammenholder de to terningers værdi. Er de ens, tilføj 1 til sameValueRoll.
    */
    public int sameDiceValue() {
        if (die1.getFaceValue() == die2.getFaceValue()) {
            sameValueRoll += 1;
        }
        return sameValueRoll;
    }

    //Opgave 1.3: Find det største slag.
    /*
    To variable: previousNumber og number.
    Number er de sidste slag, er det større end previousNumber, bliver det til den nye værdi af hugeRoll.
    previousRoll bliver opdateret til at være sidste slag.
    Sammenholder igen variable, tilskriver ny værdi hvis større.
    */
    private int previousNumber = 0;

    public int biggestRoll() {
        int number = die1.getFaceValue() + die2.getFaceValue();

        if (number > previousNumber) {
            hugeRoll = number;
            previousNumber = number;
        }
        return hugeRoll;
    }

    //Opgave 1.3: Fordeling af slagene
    /*
    - array med en størrelse på 6, 0 i hver plads.
    - tilføj 1 på hver plads 0-5 for hvert slag 1-6. Et slag på 1 giver fx +1 til element på [0]
    - tager slagets værdi til indeksering, og tilføjer 1. Frem for at have et giga if-statement.
     */
    Integer[] eachResultCount = {0, 0, 0, 0, 0, 0};
    public Integer[] setEachResultCount() {
        int faceValueDie1 = die1.getFaceValue();
        int faceValueDie2 = die2.getFaceValue();

        eachResultCount[faceValueDie1 - 1]++;
        eachResultCount[faceValueDie2 - 1]++;

        return eachResultCount;
    }

    //Opgave 1.3: Fordeling af slagene
    /*
    - tager result-strengen og tilføjer hvert element fra array gennem et for loop, hvor den også formaterer teksten.
     */
    public String printEachResultCount() {
        String result = "Roll result distribution: ";

        for (int i = 0; i < eachResultCount.length; i++) {
            result += (i + 1) + "'s: " + eachResultCount[i] + " - ";
        }
        return result;
    }

    //Opgave 1.3: Gennemsnit af alle slag.
    /*
    Benytter de feltvariable, vi allerede har, og skaber en ny ud af disse.
     */
    public double calculateAverageRoll() {
        averageRoll = (double) rollTotalSum / rollCount;
        return averageRoll;
    }

    /*
    Get-metode til ovenstående.
     */
    public double getAverageRoll() {
        return averageRoll;
    }

    //Standard play-metode, ingen ændringer
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll?");
        scanner.nextLine();
        boolean finished = false;
        while (!finished) {
            throwDie();
            System.out.printf("Rolling... %d %d\n", die1.getFaceValue(), die2.getFaceValue());
            System.out.println("Roll again? (Y/n)");
            String again = scanner.nextLine();
            if (again.toLowerCase().equals("n")) {
                finished = true;
            }
        }
    }
}
