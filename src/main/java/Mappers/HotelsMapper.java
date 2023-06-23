package Mappers;

import Business_Aspects.Hotels;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface HotelsMapper {

    @Insert("INSERT INTO hotels(hotel_name, address, destinations_id) " +
            "VALUES (#{hotelName}, #{address}, #{hotelsID})")
    @Options(useGeneratedKeys = true, keyProperty = "hotelsID")
    void create(Hotels hotel);

    @Select("SELECT * FROM hotels WHERE hotel_id = #{hotelsID}")
    @ResultMap("hotelResultMap")
    Hotels getById(int hotelsID);

    @Select("SELECT * FROM hotels")
    @ResultMap("hotelResultMap")
    List<Hotels> getAll();

    @Update("UPDATE hotels SET hotel_name = #{hotelName}, address = #{address} " +
            "WHERE hotel_id = #{hotelsID}")
    void update(Hotels hotel);

    @Delete("DELETE FROM hotels WHERE hotel_id = #{hotelsID}")
    void delete(Hotels hotel);
}
