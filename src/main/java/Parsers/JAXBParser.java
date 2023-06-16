package Parsers;

import Business_Aspects.Customers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class JAXBParser {
    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("1. Parse Customers.xml file");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parseXMLFile();
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

    private static void parseXMLFile() {
        try {
            // Create JAXBContext and unmarshaller
            JAXBContext context = JAXBContext.newInstance(Customers.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal the XML file
            File file = new File("Customers.xml");
            Customers customers = (Customers) unmarshaller.unmarshal(file);

            // Display the parsed customers data
            System.out.println(customers);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
