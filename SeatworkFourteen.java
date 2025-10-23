import java.util.Scanner;

class Motorcycle {
    String make;
    String color;
    boolean engineState = false;

    void showAtts() {
        System.out.println("This motorcycle is a " + color + " " + make);
        if (engineState) {
            System.out.println("The engine is on.");
        } else {
            System.out.println("The engine is off.");
        }
    }

    void startEngine(boolean turnOn) {
        if (turnOn) {
            if (engineState) {
                System.out.println("The engine is already on.");
            } else {
                engineState = true;
                System.out.println("The engine is now on.");
            }
        } else {
            if (!engineState) {
                System.out.println("The engine is already off.");
            } else {
                engineState = false;
                System.out.println("The engine is now off.");
            }
        }
    }
}

public class MotorcycleTest {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Motorcycle m = new Motorcycle();
        m.make = "Yamaha RZ350";
        m.color = "yellow";

        System.out.println("Calling showAtts...");
        m.showAtts();
        System.out.println("-----------");

        System.out.println("Starting engine...");
        System.out.print("Turn engine on? (yes/no): ");
        String input1 = scanner.nextLine();
        m.startEngine(input1.equalsIgnoreCase("yes"));
        System.out.println("-----------");

        System.out.println("Calling showAtts...");
        m.showAtts();
        System.out.println("-----------");

        System.out.println("Starting engine...");
        System.out.print("Turn engine on? (yes/no): ");
        String input2 = scanner.nextLine();
        m.startEngine(input2.equalsIgnoreCase("yes"));

        scanner.close();
    }
}
