package com.valtech.project.netflix.streamingservice.entities;

import jakarta.persistence.Entity;

@Entity
public class WebSeries extends Content {

	private int episodeCount;
	private long episodeDuration;

	public WebSeries() {
	}

	public WebSeries(int episodeCount, long durationOfEpisode) {
		super();
		this.episodeCount = episodeCount;
		this.episodeDuration = durationOfEpisode;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public long getEpisodeDuration() {
		return episodeDuration;
	}

	public void setEpisodeDuration(long durationOfEpisode) {
		this.episodeDuration = durationOfEpisode;
	}

}
