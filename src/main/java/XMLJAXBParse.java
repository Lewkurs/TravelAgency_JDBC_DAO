import java.io.File;
import java.util.List;
import java.xml.bind.*;
import Business_Aspects.Customers;

public class XMLJAXBParse {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/java/agency.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Agency.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Agency agency = (Agency) jaxbUnmarshaller.unmarshal(xmlFile);

            List<Customers> customers = agency.getCustomerID();
            for (Customers customer : customers) {
                System.out.println("Customer ID: " + customer.getCustomerID());
                System.out.println("Customer Last Name: " + customer.getLastName());
                System.out.println("Customer First Name: " + customer.getFirstName());
                System.out.println("Customer Email: " + customer.getEmail());
                System.out.println("Customer Phone Number: " + customer.getPhoneNumber());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}
