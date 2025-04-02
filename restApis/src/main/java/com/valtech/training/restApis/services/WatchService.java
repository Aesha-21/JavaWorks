package com.valtech.training.restApis.services;

import java.util.List;


import com.valtech.training.restApis.entites.Watch;

import com.valtech.training.restApis.vos.WatchVO;

public interface WatchService {

	

	List<WatchVO> getWatches();

	WatchVO getWatch(long id);

	WatchVO updateWatch(long id, WatchVO watch);

	WatchVO createWatch(WatchVO watch);

	List<WatchVO> getWatchesByBrand(String brand);

	

}