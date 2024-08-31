import java.util.Scanner;

public class reservationSystem {

    private static boolean[] seatAvailability = new boolean[10];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            // display menu
            System.out.println("\nPlease choose an option:");
            System.out.println("1. View Seating Arrangement");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");
            System.out.println("------------------------------");

            // get user input
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    displaySeatingArrangement();
                    break;

                case 2:
                    bookSeat();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
                    System.out.println("------------------------------");
            }
        }
    }

    private static void displaySeatingArrangement() {
        System.out.println("\nCurrent Seating Arrangement:");
        for (int i = 0; i < seatAvailability.length; i++) {
            if (seatAvailability[i]) {
                System.out.print("X ");
            } else {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
        System.out.println("------------------------------");
    }

    private static void bookSeat() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = input.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
            System.out.println("------------------------------");
        } else if (seatAvailability[seatNumber - 1]) {
            System.out.println("Seat already booked!");
            System.out.println("------------------------------");
        } else {
            seatAvailability[seatNumber - 1] = true;
            System.out.println("Seat booked successfully!");
            System.out.println("------------------------------");
        }
    }

    private static void cancelBooking() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = input.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
            System.out.println("------------------------------");
        } else if (!seatAvailability[seatNumber - 1]) {
            System.out.println("Seat not booked yet!");
            System.out.println("------------------------------");
        } else {
            seatAvailability[seatNumber - 1] = false;
            System.out.println("Booking canceled Successfully!");
            System.out.println("------------------------------");
        }
    }
}
