package craps;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private craps.Die die1;
    private craps.Die die2;
    private int sum;
    private int newSum;

    public Player() {
        this.die1 = new craps.Die();
        this.die2 = new craps.Die();
    }

    public void throwDie() {
        die1.roll();
        die2.roll();
        playerRollSum(); //Sum af de to terninger
        //Funktion til, hvordan spillet finder en vinder
    }

    //Metode til at finde værdi af to terninger
    public int playerRollSum() {
        sum = die1.getFaceValue() + die2.getFaceValue();
        return sum;
    }

    public int playerNewSum() {
        die1.roll();
        die2.roll();
        newSum = die1.getFaceValue() + die2.getFaceValue();
        return newSum;
    }

    public int getSum() {
        return sum;
    }

    public int getNewSum() {
        return newSum;
    }

    }
    //Metode til at holde newSum og Sum


    //Metode til at starte og afslutte spil
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll?");
        scanner.nextLine();
        boolean finished = false;
        while (!finished) {

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You loose the game");
                finished = true;

            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win");
                finished = true;
            } else {
                System.out.println("Point is set to " + sum);
                System.out.println("Roll again...");
                throwDie();
                //input.nextline
                System.out.printf("Rolling... %d %d\n", die1.getFaceValue(), die2.getFaceValue());
                System.out.println("Roll again? (Y/n)");
                String again = scanner.nextLine();
                if (newSum == sum) {
                    System.out.println("You rolled the point! You win");
                    finished = true
                } else if (newSum == 7) {
                    System.out.println("Craps! You loose");
                    finished = true;
                }
            }
    }
}
