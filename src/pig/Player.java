package pig;


import java.util.Scanner;

import static pig.PigGame.getMaxPoints;

public class Player {
    Scanner scanner = new Scanner(System.in);
    private pig.Die die;
    private int playerScore;
    private double averageRolls;
    private int rollCounter;


    //Constructor spiller 1
    public Player() {
        this.die = new pig.Die(); //1 terning pr spiller
        this.playerScore = 0;
        //this.averageRolls;
    }



    //Get metoder
    public double getAverageRolls() {
        return averageRolls;
    }

    public void throwDie() {
        die.roll();
    }

    public int getRollCounter() {
        return rollCounter;
    }

    //Get playerScore efter den er regnet sammen
    public int getPlayerScore() {
        return playerScore;
    }

    /*
    Logikken for spillet er sat sammen med play().
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        int turnPoints = 0;
        boolean turnOver = false;

        //Turnover sker, når nogen enten kommer over maxPoint, eller slår en 1'er
        while (!turnOver) {
            if (getPlayerScore() >= getMaxPoints()) {
                System.out.println("Max point reached!");
                break;
            } else {

                //Spørg om man vil roll igen
                System.out.println("Roll?");
                String again = scanner.nextLine();
                if (again.toLowerCase().equals("n")) {
                    turnOver = true; //Turen slutter hvis nej
                } else { //Alt koden kører hvis ja
                    //rollCounter; //rollCounter mhp. at tælle gennemsnit af rolls pr. runde. Nåede ikke i mål.
                    throwDie();

                    int rollResult = die.getFaceValue();

                    System.out.println("You rolled: " + rollResult);


                    if (rollResult == 1) { //Slag på 1 resetter rundens point
                        System.out.println("Rolled 1. Lost points.");
                        turnPoints = 0;
                        System.out.println("Current score: " + playerScore);
                        turnOver = true;
                    } else { // Andre slag end 1 lægges oveni rundens point
                        turnPoints += rollResult;
                        System.out.println(rollResult + " added to total points."); //Vis nyeste slag
                        System.out.println("Current score: " + (playerScore + turnPoints)); // Rundens point lægges til sidst i playerScore

                        if (playerScore + turnPoints >= getMaxPoints()) {
                            System.out.println("Max point reached!");
                            turnOver = true;
                        }
                    }
                }
            }
        }
    }
}