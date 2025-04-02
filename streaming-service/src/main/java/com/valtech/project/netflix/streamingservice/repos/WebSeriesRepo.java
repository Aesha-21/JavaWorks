package com.valtech.project.netflix.streamingservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.project.netflix.streamingservice.entities.WebSeries;

@Repository
public interface WebSeriesRepo extends JpaRepository<WebSeries, Long>{

	List<WebSeries> findAllByEpisodeCount(int episodecount);
	List<WebSeries> findAllByEpisodeDuration(long episodeDuration);
}
