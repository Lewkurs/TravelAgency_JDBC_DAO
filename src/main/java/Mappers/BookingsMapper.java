package Mappers;

import Business_Aspects.Bookings;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookingsMapper {

    @Insert("INSERT INTO bookings(booking_date, total_cost, customer_id, payment_id, flight_id, hotel_id) " +
            "VALUES (#{bookingDate}, #{totalCost}, #{customerID.customerID}, #{paymentID.paymentsID}, #{flightID.flightsID}, #{hotelID.hotelsID})")
    @Options(useGeneratedKeys = true, keyProperty = "bookingID")
    void create(Bookings booking);

    @Select("SELECT * FROM bookings WHERE booking_id = #{bookingID}")
    @ResultMap("bookingResultMap")
    Bookings getById(int bookingID);

    @Select("SELECT * FROM bookings")
    @ResultMap("bookingResultMap")
    List<Bookings> getAll();

    @Update("UPDATE bookings SET booking_date = #{bookingDate}, total_cost = #{totalCost}, " +
            "customer_id = #{customerID.customerID}, payment_id = #{paymentID.paymentsID}, " +
            "flight_id = #{flightID.flightsID}, hotel_id = #{hotelID.hotelsID} WHERE booking_id = #{bookingID}")
    void update(Bookings booking);

    @Delete("DELETE FROM bookings WHERE booking_id = #{bookingID}")
    void delete(Bookings booking);
}

