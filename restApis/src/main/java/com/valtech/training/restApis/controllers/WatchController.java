package com.valtech.training.restApis.controllers;

import com.valtech.training.restApis.services.*;
import com.valtech.training.restApis.vos.WatchVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/watches")
public class WatchController {
	
	@Autowired
	private WatchService watchService;
	
//	@GetMapping("/watches/{brand}")
//	public List<WatchVO> getWatchesByBrand(@PathVariable("brand") String brand){
//		
//		watchService.getWatchesByBrand(brand);
//		return null;
//	}
	
	@GetMapping("/")
	public List<WatchVO> getWatches(@RequestParam(name="brand",required = false)String brand){
		if(brand==null)
			return watchService.getWatches();
		else
			return watchService.getWatchesByBrand(brand);
	}
	
	@GetMapping("/{id}")
	public WatchVO getWatch(@PathVariable("id") long id) {
		return watchService.getWatch(id);
		
	}

	@PostMapping("/")
	public WatchVO createWatch(@RequestBody WatchVO watch) {
	
		return watchService.createWatch(watch);
	}
	@PutMapping("/{id}")
	public WatchVO updateWatch(@PathVariable("id")long id,@RequestBody WatchVO watch) {
		return watchService.updateWatch(id, watch);
	}

}
