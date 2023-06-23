import Business_Aspects.*;
import DAOImplementations.BookingsDAOImpl;
import Service_Layer.BookingsService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class MyBatisRunner {

    private static final Logger LOGGER = Logger.getLogger(MyBatisRunner.class.getName());
    private static Scanner scanner = new Scanner(System.in);
    private static BookingsService bookingsService;

    private static SqlSessionFactory createSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        String resource = "mybatis-config.xml";
        try (Reader reader = Resources.getResourceAsReader(resource)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            LOGGER.severe("Error creating SqlSessionFactory: " + e.getMessage());
        }
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookingsDAOImpl bookingsDAO = new BookingsDAOImpl(sqlSession);
        bookingsService = new BookingsService(bookingsDAO);

        // Start the menu loop
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    createBooking();
                    break;
                case 2:
                    getBookingById();
                    break;
                case 3:
                    getAllBookings();
                    break;
                case 4:
                    updateBooking();
                    break;
                case 5:
                    deleteBooking();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    LOGGER.warning("Invalid choice. Please try again.");
                    break;
            }
        }

        LOGGER.info("Goodbye!");
        sqlSession.close();
    }

    private static void displayMenu() {
        LOGGER.info("===== Menu =====");
        LOGGER.info("1. Create Booking");
        LOGGER.info("2. Get Booking by ID");
        LOGGER.info("3. Get All Bookings");
        LOGGER.info("4. Update Booking");
        LOGGER.info("5. Delete Booking");
        LOGGER.info("6. Exit");
        LOGGER.info("================");
    }

    private static int getUserChoice() {
        LOGGER.info("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void createBooking() {
        // Prompt the user for booking details
        LOGGER.info("Enter booking details:");
        scanner.nextLine(); // Consume the newline character
        LOGGER.info("Booking Date: ");
        String bookingDate = scanner.nextLine();
        LOGGER.info("Total Cost: ");
        double totalCost = Double.parseDouble(scanner.nextLine());
        LOGGER.info("Customer ID: ");
        int customerID = Integer.parseInt(scanner.nextLine());
        LOGGER.info("Payment ID: ");
        int paymentID = Integer.parseInt(scanner.nextLine());
        LOGGER.info("Flight ID: ");
        int flightID = Integer.parseInt(scanner.nextLine());
        LOGGER.info("Hotel ID: ");
        int hotelID = Integer.parseInt(scanner.nextLine());

        // Create a new Bookings object with the input values
        Bookings booking = new Bookings();
        booking.setBookingDate(bookingDate);
        booking.setTotalCost(totalCost);
        Customers customer = new Customers();
        customer.setCustomerID(customerID);
        booking.setCustomerID(customer);
        Payments payment = new Payments();
        payment.setPaymentsID(paymentID);
        booking.setPaymentID(payment);
        Flights flight = new Flights();
        flight.setFlightsID(flightID);
        booking.setFlightID(flight);
        Hotels hotel = new Hotels();
        hotel.setHotelsID(hotelID);
        booking.setHotelID(hotel);

        // Call the BookingsService to create the booking
        bookingsService.create(booking);

        LOGGER.info("Booking created successfully!");
    }

    private static void getBookingById() {
        // Prompt the user for the booking ID
        LOGGER.info("Enter booking ID: ");
        int bookingID = scanner.nextInt();

        // Call the BookingsService to get the booking by ID
        Bookings booking = bookingsService.getById(bookingID);

        if (booking != null) {
            LOGGER.info("Booking details:");
            LOGGER.info("Booking ID: " + booking.getBookingID());
            LOGGER.info("Booking Date: " + booking.getBookingDate());
            LOGGER.info("Total Cost: " + booking.getTotalCost());
            // Print other booking details as needed
        } else {
            LOGGER.info("Booking with ID " + bookingID + " not found.");
        }
    }

    private static void getAllBookings() {
        // Call the BookingsService to get all bookings
        List<Bookings> bookingsList = bookingsService.getAll();

        if (!bookingsList.isEmpty()) {
            LOGGER.info("All Bookings:");
            for (Bookings booking : bookingsList) {
                LOGGER.info("Booking ID: " + booking.getBookingID());
                LOGGER.info("Booking Date: " + booking.getBookingDate());
                LOGGER.info("Total Cost: " + booking.getTotalCost());
            }
        } else {
            LOGGER.info("No bookings found.");
        }
    }

    private static void updateBooking() {
        LOGGER.info("Update Booking chosen.");

        // Prompt the user to enter the booking ID
        LOGGER.info("Enter the Booking ID: ");
        int bookingID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Prompt the user to enter the updated booking details
        LOGGER.info("Enter the new Booking Date: ");
        String bookingDate = scanner.nextLine();

        LOGGER.info("Enter the new Total Cost: ");
        double totalCost = scanner.nextDouble();

        // Create a new Bookings object with the updated details
        Bookings updatedBooking = new Bookings();
        updatedBooking.setBookingID(bookingID);
        updatedBooking.setBookingDate(bookingDate);
        updatedBooking.setTotalCost(totalCost);

        // Call the BookingsService to update the booking
        Bookings updatedBookingResult = bookingsService.update(updatedBooking);

        if (updatedBookingResult != null) {
            LOGGER.info("Booking updated successfully:");
            LOGGER.info("Booking ID: " + updatedBookingResult.getBookingID());
            LOGGER.info("Booking Date: " + updatedBookingResult.getBookingDate());
            LOGGER.info("Total Cost: " + updatedBookingResult.getTotalCost());
            // Print other updated booking details as needed
        } else {
            LOGGER.info("Failed to update booking.");
        }
    }

    private static void deleteBooking() {
        LOGGER.info("Delete Booking chosen.");

        // Prompt the user to enter the booking ID
        LOGGER.info("Enter the Booking ID to delete: ");
        int bookingID = scanner.nextInt();

        // Call the BookingsService to get the booking by ID
        Bookings bookingToDelete = bookingsService.getById(bookingID);

        if (bookingToDelete != null) {
            // Call the BookingsService to delete the booking
            Bookings deletedBooking = bookingsService.delete(bookingID);

            if (deletedBooking != null) {
                LOGGER.info("Booking deleted successfully:");
                LOGGER.info("Booking ID: " + deletedBooking.getBookingID());
                LOGGER.info("Booking Date: " + deletedBooking.getBookingDate());
                LOGGER.info("Total Cost: " + deletedBooking.getTotalCost());
                // Print other details of the deleted booking as needed
            } else {
                LOGGER.info("Failed to delete booking.");
            }
        } else {
            LOGGER.info("Booking with ID " + bookingID + " not found.");
        }
    }
}
