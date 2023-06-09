import Business_Aspects.Activities;
import Business_Aspects.DestinationBookings;
import Business_Aspects.Destinations;
import Business_Aspects.Flights;
import DAO.*;
import Service_Layer.DestinationsService;
import Service_Layer.FlightsService;
import DAO.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import static DAO.ConnectionPool.getConnection;

public class Main {

    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();

        // Get a connection from the pool
        Connection connection = connectionPool.getConnection();

        // Create an instance of the DestinationsDAO
        AbstractDAO<Destinations> destinationDAO = new DestinationsDAOImpl(connection);

        // Create an instance of the DestinationsService
        DestinationsService destinationsService = new DestinationsService(destinationDAO);

        // Retrieve all destinations
        List<Destinations> destinations = destinationDAO.findAll();
        System.out.println("All Destinations:");
        for (Destinations destination : destinations) {
            System.out.println(destination);
        }

        // Get a specific destination by ID
        int destinationId = 2;
        Destinations destination = destinationDAO.findById(destinationId);
        if (destination != null) {
            System.out.println("\nDestination with ID " + destinationId + ":");
            System.out.println(destination);
        } else {
            System.out.println("\nDestination with ID " + destinationId + " not found.");
        }

        // Create a new destination
        Destinations newDestination = new Destinations();
        newDestination.setDestinationsID(5);
        newDestination.setName("New Destination");
        newDestination.setDescription("A new destination");
        newDestination.setPrice(100.0);
        destinationDAO.save(newDestination);
        System.out.println("\nNew Destination created:");
        System.out.println(newDestination);

        // Update an existing destination
        Destinations existingDestination = destinationDAO.findById(3);
        if (existingDestination != null) {
            existingDestination.setDescription("Updated description");
            existingDestination.setPrice(150.0);
            destinationDAO.update(existingDestination);
            System.out.println("\nDestination updated:");
            System.out.println(existingDestination);
        } else {
            System.out.println("\nDestination with ID 3 not found.");
        }

        // Delete a destination
        Destinations deleteDestination = destinationDAO.findById(4);
        if (deleteDestination != null) {
            destinationDAO.delete(deleteDestination);
            System.out.println("\nDestination deleted:");
            System.out.println(deleteDestination);
        } else {
            System.out.println("\nDestination with ID 4 not found.");
        }

        // Close the connection
        // Add code to close the connection

        System.out.println("\nDone.");
    }

}


