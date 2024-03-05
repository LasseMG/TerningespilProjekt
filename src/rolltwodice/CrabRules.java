package rolltwodice;

import java.util.Random;
import java.util.Scanner;

public class CrabRules {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Craps game!");

        while (true) {
            System.out.print("Press Enter to roll the dice!");
            input.nextLine();

            int firstDie = rollDie(random);
            int secondDie = rollDie(random);
            int sum = firstDie + secondDie;

            System.out.println("You rolled " + firstDie + " + " + secondDie + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You loose the game");
                break;

            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win");
                break;
            } else {
                System.out.println("Point is set to " + sum);
                System.out.println("Roll again...");

                while (true) {
                    System.out.println("Press enter to roll the dice!");
                    input.nextLine();

                    int newFirstDie = rollDie(random);
                    int newSecondDie = rollDie(random);
                    int newSum = newFirstDie + newSecondDie;

                    System.out.println("You rolled " + newFirstDie + " + " + newSecondDie + " = " + newSum);

                    if (newSum == sum) {
                        System.out.println("You rolled the point! You win");
                    } else if (newSum == 7) {
                        System.out.println("Craps! You loose");
                        break;
                    }
                }
                break;
            }
        }
    }

    private static int rollDie(Random random) {
        return random.nextInt(6) + 1;
    }
}
