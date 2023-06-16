package Business_Aspects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payments {
    @JsonProperty ("paymentsID")
    private int paymentsID;
    @JsonProperty ("paymentMethod")
    private String paymentMethod;
    @JsonProperty ("paymentAmount")
    private double paymentAmount;

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
