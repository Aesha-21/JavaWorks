package com.valtech.training.restApis.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.restApis.entites.Watch;
import com.valtech.training.restApis.vos.WatchVO;

@Repository
public interface WatchRepo extends JpaRepository<Watch, Long>{

	List<Watch> findByBrand(String brand);

}
