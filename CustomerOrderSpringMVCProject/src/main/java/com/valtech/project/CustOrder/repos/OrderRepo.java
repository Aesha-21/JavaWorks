package com.valtech.project.CustOrder.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.project.CustOrder.model.OrderTable;
import com.valtech.project.CustOrder.vos.AddToCartVO;

@Repository
public interface OrderRepo extends JpaRepository<OrderTable, Long>{

	void save(AddToCartVO orderVO);

}
