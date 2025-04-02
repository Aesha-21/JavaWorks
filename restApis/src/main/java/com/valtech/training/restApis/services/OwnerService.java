package com.valtech.training.restApis.services;

import java.util.List;

import com.valtech.training.restApis.vos.OwnerVO;

public interface OwnerService {
	
	List<OwnerVO> getOwners();
	OwnerVO getOwner(long id);
	OwnerVO createOwner(OwnerVO owner);
	OwnerVO updateOwner(long id, OwnerVO owner);
	OwnerVO addWatchesToOwner(long id, List<Long> watches);
	

}
