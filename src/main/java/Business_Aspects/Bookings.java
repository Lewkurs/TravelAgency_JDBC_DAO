package Business_Aspects;

    public class Bookings {
        private int bookingID;
        private String bookingDate;
        private double totalCost;
        private Customers customerID;
        private Payments paymentID;
        private Flights flightID;
        private Hotels hotelID;

        public int getBookingID() {
            return bookingID;
        }

        public void setBookingID(int bookingID) {
            this.bookingID = bookingID;
        }

        public String getBookingDate() {
            return bookingDate;
        }

        public void setBookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(double totalCost) {
            this.totalCost = totalCost;
        }

        public Customers getCustomerID() {
            return customerID;
        }

        public void setCustomerID(Customers customerID) {
            this.customerID = customerID;
        }

        public Payments getPaymentID() {
            return paymentID;
        }

        public void setPaymentID(Payments paymentID) {
            this.paymentID = paymentID;
        }

        public Flights getFlightID() {
            return flightID;
        }

        public void setFlightID(Flights flightID) {
            this.flightID = flightID;
        }

        public Hotels getHotelID() {
            return hotelID;
        }

        public void setHotelID(Hotels hotelID) {
            this.hotelID = hotelID;
        }

        @Override
        public String toString() {
            return "Bookings [bookingID=" + bookingID + ", bookingDate=" + bookingDate + ", totalCost=" + totalCost
                    + ", customerID=" + customerID + ", paymentID=" + paymentID + ", flightID=" + flightID
                    + ", hotelID=" + hotelID + "]";
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof Bookings))
                return false;
            if (obj == this)
                return true;
            return this.getBookingID() == ((Bookings) obj).getBookingID();
        }

        @Override
        public int hashCode() {
            return this.getBookingID();
        }
    }
