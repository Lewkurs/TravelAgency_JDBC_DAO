package Mappers;

import Business_Aspects.Customers;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomersMapper {

    @Insert("INSERT INTO customers(name, email, contact_number) " +
            "VALUES (#{name}, #{email}, #{contactNumber})")
    @Options(useGeneratedKeys = true, keyProperty = "customerID")
    void create(Customers customer);

    @Select("SELECT * FROM customers WHERE customer_id = #{customerID}")
    @ResultMap("customerResultMap")
    Customers getById(int customerID);

    @Select("SELECT * FROM customers")
    @ResultMap("customerResultMap")
    List<Customers> getAll();

    @Update("UPDATE customers SET name = #{name}, email = #{email}, contact_number = #{contactNumber} " +
            "WHERE customer_id = #{customerID}")
    void update(Customers customer);

    @Delete("DELETE FROM customers WHERE customer_id = #{customerID}")
    void delete(Customers customer);
}
