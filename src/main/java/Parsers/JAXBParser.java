package Parsers;

import Business_Aspects.Customers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParser {

    public static void main(String[] args) {
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
