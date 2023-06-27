package Observer;

public class Main {
    public static void main(String[] args) {
        // Create instances of the necessary objects
        Customer customer = new Customer();
        Payments payment = new Payments();
        Hotels hotel = new Hotels();
        Flights flight = new Flights();

        // Create a booking and attach observers
        Bookings bookings = new Bookings();
        bookings.attach(customer);
        bookings.attach(payment);
        bookings.attach(hotel);
        bookings.attach(flight);

        // Confirm the booking
        bookings.confirmBooking(customer, payment, hotel, flight);
    }
}
