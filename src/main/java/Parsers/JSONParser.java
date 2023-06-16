package Parsers;

import Business_Aspects.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.Main;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class JSONParser {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            logger.info("1. Parse JSON file");
            logger.info("2. Exit");
            logger.info("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parseJSONFile();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void parseJSONFile() {
        try {
            // Read the JSON file
            String json = "src/main/java/resources/JSON";

            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse the JSON and map it to the appropriate classes

            // Customers
            List<Customers> customers = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Customers.class));
            logger.info("Customers:");
            for (Customers customer : customers) {
                logger.info(customer.getName());
            }

            // Flights
            List<Flights> flights = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Flights.class));
            logger.info("\nFlights:");
            for (Flights flight : flights) {
                logger.info("Flight ID: " + flight.getFlightsID());
                logger.info("Airline: " + flight.getAirline());
                // Access other flight properties
                logger.info("");
            }

            // Hotels
            List<Hotels> hotels = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Hotels.class));
            logger.info("\nHotels:");
            for (Hotels hotel : hotels) {
                logger.info("Hotel ID: " + hotel.getHotelsID());
                logger.info("Hotel Name: " + hotel.getHotelName());
                // Access other hotel properties
                logger.info("");
            }

            // Payments
            List<Payments> payments = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Payments.class));
            logger.info("\nPayments:");
            for (Payments payment : payments) {
                logger.info("Payment ID: " + payment.getPaymentsID());
                logger.info("Payment Method: " + payment.getPaymentMethod());
                // Access other payment properties
                logger.info("");
            }

            // Bookings
            List<Bookings> bookings = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Bookings.class));
            logger.info("\nBookings:");
            for (Bookings booking : bookings) {
                logger.info("Booking ID: " + booking.getBookingID());
                logger.info("Booking Date: " + booking.getBookingDate());
                // Access other booking properties
                logger.info("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
