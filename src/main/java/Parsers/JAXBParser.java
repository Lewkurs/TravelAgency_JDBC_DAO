package Parsers;

import Business_Aspects.Customers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JAXBParser {
    private static final Logger logger = Logger.getLogger(JAXBParser.class.getName());

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            logger.info("1. Parse Customers.xml file");
            logger.info("2. Exit");
            logger.info("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parseXMLFile();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    logger.log(Level.WARNING, "Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void parseXMLFile() {
        try {
            // Create JAXBContext and unmarshaller
            JAXBContext context = JAXBContext.newInstance(Customers.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal the XML file
            File file = new File("Customers.xml");
            Customers customers = (Customers) unmarshaller.unmarshal(file);

            // Display the parsed customers data
            logger.log(Level.INFO, customers.toString());
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "Failed to parse the XML file.", e);
        }
    }
}
