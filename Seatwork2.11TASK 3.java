import java.util.Random;

public class Task3 {
    public static void main(String[] args) {

        Random random = new Random();

        int number;
        boolean isHeads;

        // Generates number from 1 to 6
        number = random.nextInt(6) + 1;

        // Coin toss
        isHeads = random.nextBoolean();

        System.out.println("Number: " + number);

        if (isHeads) {
            System.out.println("HEADS");
        } else {
            System.out.println("TAILS");
        }
    }
}
