package pig;


import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    private pig.Die die;
    private int playerScore;
    private double averageRolls;


    //Constructor spiller 1
    public Player() {
        this.die = new pig.Die(); //1 terning pr spiller
        this.playerScore = 0;
    }


    //Get metoder
    public double getAverageRolls() {
        return averageRolls;
    }

    public void throwDie() {
        die.roll();
        turn();
    }



    public int turn() {
        int roll = die.getFaceValue();
        //TODO stop runden, hvis maxScore er opnået af en player

        System.out.println("You rolled " + roll); //Vis, hvad jeg slog

        int turnPoints = 0; //Tæller til rundens point

            if (roll == 1) {
                turnPoints = 0;
                return playerScore += turnPoints;

            } else {
                turnPoints += roll;
                return playerScore += turnPoints;
                //TODO
                //spørg om de vil rulle igen, hvis ja rul videre
                //hvis ikke de vil rulle videre, tag point opnået og smid i playerScore
            }
    }

    //Get playerScore efter den er regnet sammen
    public int getPlayerScore() {
        return playerScore;
    }

    public void play() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll?");
        scanner.nextLine();

        boolean finished = false;
        while (!finished) {
            throwDie();
            System.out.println("Roll again? (Y/n)");
            System.out.println(playerScore);
            String again = scanner.nextLine();
            if (again.toLowerCase().equals("n")) {
                finished = true;
            }
        }
    }
}

