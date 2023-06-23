package Parsers;

import Business_Aspects.Customers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JAXBParser {
    private static final Logger logger = Logger.getLogger(JAXBParser.class.getName());

    private static void parseXMLFile() {
        try {
            // Create JAXBContext and unmarshaller
            JAXBContext context = JAXBContext.newInstance(Customers.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal the XML file
            File file = new File("RegXMLFiles/Customers.xml");
            Customers customers = (Customers) unmarshaller.unmarshal(file);

            // Display the parsed customers data
            logger.log(Level.INFO, customers.toString());
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "Failed to parse the XML file.", e);
        }
    }
}
