package com.cpown.springcloud.dao;

import com.cpown.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    Payment selectByPrimaryKey(Long id);

    List<Payment> selectAll();

    int updateByPrimaryKey(Payment record);

    List<Payment> selectDepartmentByName(@Param("serial") String serial);

}