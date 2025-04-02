package com.valtech.project.CustOrder.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.project.CustOrder.model.LineOrderItem;

@Repository
public interface LineOrderItemRepo extends JpaRepository<LineOrderItem, Long>{

}
