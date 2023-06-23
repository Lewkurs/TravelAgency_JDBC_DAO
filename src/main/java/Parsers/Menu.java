package Parsers;

import Business_Aspects.Customers;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Handler;
import java.util.logging.LogManager;

public class Menu {
    private static final Logger logger = Logger.getLogger(Menu.class.getName());
    private static final int OPTION_EXIT = 0;
    private static final int OPTION_MAIN_PROGRAM = 1;
    private static final int OPTION_PARSER_MENU = 2;
    private static final int OPTION_DOM_PARSER = 3;
    private static final int OPTION_JAXB_PARSER = 4;
    private static final int OPTION_JSON_PARSER = 5;
    private static Scanner scanner;

    public static void main(String[] args) {
        configureLogger();

        scanner = new Scanner(System.in);

        int option = -1;
        while (option != OPTION_EXIT) {
            printMainMenu();
            option = getUserChoice();

            switch (option) {
                case OPTION_MAIN_PROGRAM:
                    runMainProgram();
                    break;
                case OPTION_PARSER_MENU:
                    runParserMenu();
                    break;
                case OPTION_EXIT:
                    logger.info("Exiting the program. Goodbye!");
                    break;
                default:
                    logger.warning("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void configureLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        consoleHandler.setFormatter(new SimpleFormatter());

        logger.addHandler(consoleHandler);
    }

    private static void printMainMenu() {
        logger.info("\n---- Main Menu ----");
        logger.info("1. Run Main Program");
        logger.info("2. Choose Parser");
        logger.info("0. Exit");
        logger.info("Select an option: ");
    }

    private static void runMainProgram() {
        logger.info("Welcome to the Travel Agency System!");

        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();
            logger.info("");

            switch (choice) {
                case 1:
                    logger.info("Selected: Plan a Trip");
                    // Logic for planning a trip
                    break;
                case 2:
                    logger.info("Selected: Update Trip Details");
                    // Logic for updating trip details
                    break;
                case 3:
                    logger.info("Selected: Cancel Trip");
                    // Logic for canceling a trip
                    break;
                case 4:
                    logger.info("Selected: View Trip Details");
                    // Logic for viewing trip details
                    break;
                case 5:
                    logger.info("Selected: Exit");
                    exit = true;
                    break;
                default:
                    logger.warning("Invalid choice. Please try again.");
            }

            logger.info("");
        }

        logger.info("Thank you for using the Travel Agency System. Goodbye!");
    }

    private static void displayMenu() {
        logger.info("Please select an option:");
        logger.info("1. Plan a Trip");
        logger.info("2. Update Trip Details");
        logger.info("3. Cancel Trip");
        logger.info("4. View Trip Details");
        logger.info("5. Exit");
    }

    private static int getUserChoice() {
        int choice = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                logger.info("Enter your choice (1-5): ");
                choice = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                logger.warning("Invalid input. Please enter a number.");
            }
        }

        return choice;
    }

    private static void runParserMenu() {
        int option = -1;
        while (option != OPTION_EXIT) {
            printParserMenu();
            option = getUserChoice();

            switch (option) {
                case OPTION_DOM_PARSER:
                    runDOMParser();
                    break;
                case OPTION_JAXB_PARSER:
                    runJAXBParser();
                    break;
                case OPTION_JSON_PARSER:
                    runJSONParser();
                    break;
                case OPTION_EXIT:
                    logger.info("Returning to the main menu.");
                    break;
                default:
                    logger.warning("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void printParserMenu() {
        logger.info("\n---- Parser Menu ----");
        logger.info("3. DOM Parser");
        logger.info("4. JAXB Parser");
        logger.info("5. JSON.json Parser");
        logger.info("0. Back to Main Menu");
        logger.info("Select an option: ");
    }

    private static void runDOMParser() {
        logger.info("Running the DOM parser...");

        try {
            // Load the XML file
            File file = new File("RegXMLFiles/Transportation.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // Get the root element
            Element root = document.getDocumentElement();

            // Parse the transportation elements
            parseTransportationElements(root);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during XML parsing", e);
        }
    }

    private static void parseTransportationElements(Element root) {
        // Parse the transportation elements
        NodeList transportList = root.getElementsByTagName("Transport");
        for (int i = 0; i < transportList.getLength(); i++) {
            Element transportElement = (Element) transportList.item(i);
            String transportationID = transportElement.getElementsByTagName("TransportationID").item(0).getTextContent();
            String transportationType = transportElement.getElementsByTagName("TransportationType").item(0).getTextContent();
            String description = transportElement.getElementsByTagName("Description").item(0).getTextContent();
            String pricePerHour = transportElement.getElementsByTagName("PricePerHour").item(0).getTextContent();
            String destinationID = transportElement.getElementsByTagName("DestinationID").item(0).getTextContent();

            // Perform your desired operations with the parsed data
            // For example, you can create Transportation objects, store them in a list, etc.

            // Log the parsed data
            logger.info("Transportation ID: " + transportationID);
            logger.info("Transportation Type: " + transportationType);
            logger.info("Description: " + description);
            logger.info("Price per Hour: " + pricePerHour);
            logger.info("Destination ID: " + destinationID);
            logger.info("--------------------------------------");
        }
    }


    private static void runJAXBParser() {
        logger.info("Running the JAXB parser...");

        try {
            // Create JAXBContext and unmarshaller
            JAXBContext context = JAXBContext.newInstance(Customers.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal the XML file
            File file = new File("RegXMLFiles/Customers.xml");
            Customers customer = (Customers) unmarshaller.unmarshal(file);

            // Perform your desired operations with the parsed data
            logger.info("Customer ID: " + customer.getCustomerID());
            logger.info("Customer Name: " + customer.getName());
            logger.info("Customer Email: " + customer.getEmail());
            logger.info("Customer Contact Number: " + customer.getContactNumber());
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "Failed to parse the XML file.", e);
        }
    }




    private static void runJSONParser() {
        logger.info("Running the JSON.json parser...");

        try {
            // Read the JSON.json file
            File file = new File("src/main/java/resources/JSON.json");
            ObjectMapper objectMapper = new ObjectMapper();
            Customers customers = objectMapper.readValue(file, Customers.class);

            // Perform your desired operations with the parsed data
            logger.info("Customer ID: " + customers.getCustomerID());
            logger.info("Customer Name: " + customers.getName());
            logger.info("Customer Email: " + customers.getEmail());
            logger.info("Customer Contact Number: " + customers.getContactNumber());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to parse the JSON.json file.", e);
        }
    }

}
