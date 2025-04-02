package com.valtech.training.restApis.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restApis.entites.Owner;
import com.valtech.training.restApis.repos.OwnerRepo;
import com.valtech.training.restApis.repos.WatchRepo;
import com.valtech.training.restApis.vos.OwnerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	private OwnerRepo ownerRepo;
	@Autowired private WatchRepo watchRepo;
	
	
	@Override
	public OwnerVO createOwner(OwnerVO ownerVO) {
		Owner owner = ownerVO.toOwner();
		owner = ownerRepo.save(owner);
		return OwnerVO.from(owner);
				//		return OwnerVO.from(ownerRepo.save(owner.toOwner()));
	}

	@Override
	public OwnerVO updateOwner(long id, OwnerVO owner) {
		Owner own1 = ownerRepo.getReferenceById(id);
		owner.updateOwnerFromVO(own1);
		return OwnerVO.from(ownerRepo.save(own1));
	}
	
	@Override
	public List<OwnerVO> getOwners() {
		List<Owner> owners = ownerRepo.findAll();
		return owners.stream().map(o -> OwnerVO.from(o)).collect(Collectors.toList());
//		return OwnerVO.toOwnerVo(ownerRepo.findAll());
	}

	@Override
	public OwnerVO getOwner(long id) {
		Owner owner = ownerRepo.getReferenceById(id);
		return OwnerVO.from(owner);
//		return OwnerVO.from(ownerRepo.getReferenceById(id));
	}

	@Override
	public OwnerVO addWatchesToOwner(long id, List<Long> watches) {
		final Owner owner = ownerRepo.getReferenceById(id);
		watches.stream().forEach(wid -> owner.addWatch(watchRepo.getReferenceById(wid)));
		Owner owner1 = ownerRepo.save(owner);
		
		return OwnerVO.from(owner1);
	}

}
