import java.io.File;
import java.util.List;
import javax.xml.bind.*;
import Business_Aspects.Bookings;
import Business_Aspects.Customers;

public class XMLJAXBParse {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/java/agency.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Bookings.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Bookings bookings = (Bookings) jaxbUnmarshaller.unmarshal(xmlFile);

            List<Customers> customers = (List<Customers>) bookings.getCustomerID();
            for (Customers customer : customers) {
                System.out.println("Customer ID: " + customer.getCustomerID());
                System.out.println("Customer Last Name: " + customer.getName());
                System.out.println("Customer Email: " + customer.getEmail());
                System.out.println("Customer Phone Number: " + customer.getContactNumber());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
