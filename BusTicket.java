
import java.util.Scanner;

public class BusTicketBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSeats = 40;
        int bookedSeats = 0;
        String choice;

        System.out.println("Welcome to the Bus Ticket Booking System!");

        // Loop until all seats booked or user stops
        while (bookedSeats < totalSeats) {
            System.out.println("\nSeats available: " + (totalSeats - bookedSeats));
            System.out.print("Do you want to book a seat? (yes/no): ");
            choice = scanner.next().toLowerCase();

            if (choice.equals("yes")) {
                bookedSeats++;
                System.out.println("✅ Seat booked successfully! Total booked: " + bookedSeats);
            } else if (choice.equals("no")) {
                System.out.println("Booking stopped by user.");
                break;
            } else {
                System.out.println("❌ Invalid choice! Please enter 'yes' or 'no'.");
            }
        }

        if (bookedSeats == totalSeats) {
            System.out.println("\n🚍 All seats are booked! No more bookings possible.");
        }

        System.out.println("Thank you for using the booking system!");
        scanner.close();
    }
}
