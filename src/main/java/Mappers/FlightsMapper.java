package Mappers;

import Business_Aspects.Flights;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FlightsMapper {

    @Insert("INSERT INTO flights(airline, departure_city, arrival_city, departure_time, arrival_time) " +
            "VALUES (#{airline}, #{departureCity}, #{arrivalCity}, #{departureTime}, #{arrivalTime})")
    @Options(useGeneratedKeys = true, keyProperty = "flightsID")
    void create(Flights flight);

    @Select("SELECT * FROM flights WHERE flight_id = #{flightsID}")
    @ResultMap("flightResultMap")
    Flights getById(int flightsID);

    @Select("SELECT * FROM flights")
    @ResultMap("flightResultMap")
    List<Flights> getAll();

    @Update("UPDATE flights SET airline = #{airline}, departure_city = #{departureCity}, " +
            "arrival_city = #{arrivalCity}, departure_time = #{departureTime}, " +
            "arrival_time = #{arrivalTime} WHERE flight_id = #{flightsID}")
    void update(Flights flight);

    @Delete("DELETE FROM flights WHERE flight_id = #{flightsID}")
    void delete(Flights flight);
}

