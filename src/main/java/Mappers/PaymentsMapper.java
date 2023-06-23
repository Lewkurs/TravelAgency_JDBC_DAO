package Mappers;

import Business_Aspects.Payments;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PaymentsMapper {

    @Insert("INSERT INTO payments(payment_method, payment_amount) " +
            "VALUES (#{paymentMethod}, #{paymentAmount})")
    @Options(useGeneratedKeys = true, keyProperty = "paymentsID")
    void create(Payments payment);

    @Select("SELECT * FROM payments WHERE payment_id = #{paymentsID}")
    @ResultMap("paymentResultMap")
    Payments getById(int paymentsID);

    @Select("SELECT * FROM payments")
    @ResultMap("paymentResultMap")
    List<Payments> getAll();

    @Update("UPDATE payments SET payment_method = #{paymentMethod}, payment_amount = #{paymentAmount} " +
            "WHERE payment_id = #{paymentsID}")
    void update(Payments payment);

    @Delete("DELETE FROM payments WHERE payment_id = #{paymentsID}")
    void delete(Payments payment);
}

