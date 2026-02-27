import java.util.*;
import java.text.*;

public class Task7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat.setLenient(false);

        Date alarmDate = null;

        while (alarmDate == null) {
            try {
                System.out.print("Enter alarm time (HH:MM:SS): ");
                alarmDate = timeFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid time format! Try again.");
            }
        }

        Calendar now = Calendar.getInstance();
        Calendar alarmCal = Calendar.getInstance();
        alarmCal.setTime(alarmDate);

        alarmCal.set(Calendar.YEAR, now.get(Calendar.YEAR));
        alarmCal.set(Calendar.MONTH, now.get(Calendar.MONTH));
        alarmCal.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH));

        if (alarmCal.before(now)) {
            alarmCal.add(Calendar.DAY_OF_MONTH, 1);
            System.out.println("Alarm set for TOMORROW.");
        } else {
            System.out.println("Alarm set for TODAY.");
        }

        new Thread(new AlarmClock(alarmCal, scanner)).start();
    }
}

class AlarmClock implements Runnable {

    private Calendar alarmTime;
    private Scanner scanner;

    public AlarmClock(Calendar alarmTime, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.scanner = scanner;
    }

    public void run() {

        SimpleDateFormat clockFormat = new SimpleDateFormat("HH:mm:ss");

        while (Calendar.getInstance().before(alarmTime)) {
            try {
                Thread.sleep(1000);
                System.out.print("\rCurrent Time: " + clockFormat.format(new Date()));
            } catch (InterruptedException e) {
                return;
            }
        }

        System.out.println("\n⏰ ALARM TIME!");

        // Alarm loop (no sound, just text)
        System.out.println("Press ENTER to stop the alarm.");
        while (!scanner.hasNextLine()) {
            System.out.println("ALARM!!! ALARM!!! ALARM!!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }

        scanner.nextLine(); // consume enter
        System.out.println("Alarm stopped.");
        scanner.close();
    }
}
