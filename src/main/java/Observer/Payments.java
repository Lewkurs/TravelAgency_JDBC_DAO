package Observer;


import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.logging.Logger;

@XmlRootElement(name = "Payments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payments implements Observer {
    private static final Logger logger = Logger.getLogger(Payments.class.getName());

    @XmlElement(name = "paymentsID")
    @JsonProperty("paymentsID")
    private int paymentsID;

    @XmlElement(name = "paymentMethod")
    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @XmlElement(name = "paymentAmount")
    @JsonProperty("paymentAmount")
    private double paymentAmount;

    // Implement the update method from Observer interface
    @Override
    public void update() {
        // Implementation when notified of a change, e.g. log the message
        logger.info("Payment with ID " + this.paymentsID + " has been notified.");
    }

    public int getPaymentsID() {
        return paymentsID;
    }

    public void setPaymentsID(int paymentsID) {
        this.paymentsID = paymentsID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Payments [paymentsID=" + paymentsID + ", paymentMethod=" + paymentMethod + ", paymentAmount=" + paymentAmount + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Payments))
            return false;
        if (obj == this)
            return true;
        return this.getPaymentsID() == ((Payments) obj).getPaymentsID();
    }

    @Override
    public int hashCode() {
        return this.getPaymentsID();
    }

}

