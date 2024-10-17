import java.util.Scanner;
import java.util.Random;

public class Craps {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean done = false;

        do {

            int diceRoll1 = rand.nextInt(1, 7);
            int diceRoll2 = rand.nextInt(1, 7);
            int diceRollTotal = diceRoll1 + diceRoll2;
            int point = 0;
            boolean wonOrLost = false;

            System.out.println("You rolled a " + diceRoll1 + " and a " + diceRoll2 +
                    " for a total of " + diceRollTotal);

            switch (diceRollTotal) {
                case 2, 3, 12:
                    System.out.println("You rolled a " + diceRollTotal + ", so you have lost!");
                    wonOrLost = true;
                    break;
                case 7, 11:
                    System.out.println("You rolled a " + diceRollTotal + ", so you have won!");
                    wonOrLost = true;
                    break;
            }
            if (wonOrLost == false) {
                point = diceRollTotal;
                System.out.println("The point is now " + point);
            }

            while (wonOrLost == false) {

                diceRoll1 = rand.nextInt(1, 7);
                diceRoll2 = rand.nextInt(1, 7);
                diceRollTotal = diceRoll1 + diceRoll2;

                System.out.println("You rolled a " + diceRoll1 + " and a " + diceRoll2 +
                        " for a total of " + diceRollTotal);

                if (diceRollTotal == point) {
                    System.out.println("Your roll, a " + diceRollTotal + ", is equal "
                            + "to the point, so you win!");
                    wonOrLost = true;

                } else if (diceRollTotal == 7) {
                    System.out.println("You rolled a 7, which means you lose!");
                    wonOrLost = true;

                }
            }

            done = SafeInputs.getYNConfirm(in, "Are you done playing Craps?");

        } while (!done);

    }
}