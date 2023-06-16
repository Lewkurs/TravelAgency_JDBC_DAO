import Business_Aspects.Activities;
import Business_Aspects.DestinationBookings;
import Business_Aspects.Destinations;
import Business_Aspects.Flights;
import DAO.*;
import Parsers.DOMParser;
import Parsers.JAXBParser;
import Parsers.JSONParser;
import Service_Layer.DestinationsService;
import Service_Layer.FlightsService;
import DAO.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import static DAO.ConnectionPool.getConnection;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.HotelsDAO;
import DAO.FlightsDAO;
import DAOImplementations.HotelsDAOImpl;
import DAOImplementations.FlightsDAOImpl;
import Business_Aspects.Hotels;
import Business_Aspects.Flights;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try (Connection connection = ConnectionPool.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                logger.info("===== Travel Agency Menu =====");
                logger.info("1. Organize a Trip");
                logger.info("2. Set Preferences");
                logger.info("0. Exit");

                logger.info("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        organizeTripMenu(scanner, connection);
                        break;
                    case 2:
                        setPreferencesMenu(scanner);
                        break;
                    case 0:
                        logger.info("Exiting...");
                        return;
                    default:
                        logger.warning("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to establish database connection", e);
        }
    }

    private static void organizeTripMenu(Scanner scanner, Connection connection) {
        while (true) {
            logger.info("===== Organize a Trip Menu =====");
            logger.info("1. Book a Hotel");
            logger.info("2. Book a Flight");
            logger.info("0. Go Back");

            logger.info("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    bookHotel(scanner, connection);
                    break;
                case 2:
                    bookFlight(scanner);
                    break;
                case 0:
                    return; // Go back to the main menu
                default:
                    logger.warning("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookHotel(Scanner scanner, Connection connection) {
        logger.info("=== Hotel Booking ===");
        // Gather necessary hotel booking information from the user
        // Example:
        logger.info("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        logger.info("Enter address: ");
        String address = scanner.nextLine();
        // ... gather other hotel booking details

        // Create a new Hotels object
        Hotels hotel = new Hotels();
        hotel.setHotelName(hotelName);
        hotel.setAddress(address);
        // ... set other hotel properties based on user input

        // Create an instance of HotelsDAOImpl with the database connection
        HotelsDAOImpl hotelsDAO = new HotelsDAOImpl(connection);

        // Perform hotel booking by calling the create method from the DAO
        Hotels createdHotel = hotelsDAO.create(hotel);
        if (createdHotel != null) {
            logger.info("Hotel booked successfully!");
            logger.info(createdHotel.toString());
        } else {
            logger.warning("Hotel booking failed. Please try again.");
        }
    }

    private static void bookFlight(Scanner scanner) {
        logger.info("=== Flight Booking ===");
        // Gather necessary flight booking information from the user
        // Example:
        logger.info("Enter airline: ");
        String airline = scanner.nextLine();
        logger.info("Enter departure city: ");
        String departureCity = scanner.nextLine();
        // ... gather other flight booking details

        // Create a new Flights object
        Flights flight = new Flights();
        flight.setAirline(airline);
        flight.setDepartureCity(departureCity);
        // ... set other flight properties based on user input

        // Create an instance of FlightsDAOImpl with the database connection
        Connection connection = ConnectionPool.getConnection();
        FlightsDAOImpl flightsDAO = new FlightsDAOImpl(connection);

        // Perform flight booking by calling the create method on the FlightsDAOImpl instance
        Flights createdFlight = flightsDAO.create(flight);
        if (createdFlight != null) {
            logger.info("Flight booked successfully!");
            logger.info(createdFlight.toString());
        } else {
            logger.warning("Flight booking failed. Please try again.");
        }

        // Close the database connection
        ConnectionPool.closeConnection(connection);
    }


    private static void setPreferencesMenu(Scanner scanner) {
        // ... existing implementation for setting preferences
    }
}




