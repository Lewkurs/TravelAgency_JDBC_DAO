package Parsers;


import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.*;

public class DOMParser {

    private static final Logger logger = Logger.getLogger(DOMParser.class.getName());

    public static void main(String[] args) {
        try {
            // Configure logger
            FileHandler fileHandler = new FileHandler("parser.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);

            // Load the XML file
            File file = new File("Transportation.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // Get the root element
            Element root = document.getDocumentElement();

            // Display menu
            displayMenu(root);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during XML parsing", e);
        }
    }

    private static void displayMenu(Element root) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("1. Parse transportation elements");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parseTransportationElements(root);
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
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

            // Log the parsed data
            logger.info("Transportation ID: " + transportationID);
            logger.info("Transportation Type: " + transportationType);
            logger.info("Description: " + description);
            logger.info("Price per Hour: " + pricePerHour);
            logger.info("Destination ID: " + destinationID);
            logger.info("--------------------------------------");
        }
    }
}


