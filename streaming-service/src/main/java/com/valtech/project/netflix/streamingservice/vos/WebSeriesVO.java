package com.valtech.project.netflix.streamingservice.vos;

import com.valtech.project.netflix.streamingservice.entities.WebSeries;

public record WebSeriesVO(long id,String name,String genre,String language,long costPerView,int episodeCount,long episodeDuration) {

	public static WebSeriesVO from(WebSeries ws) {
		return new WebSeriesVO(ws.getId(), ws.getName(), ws.getGenre(), ws.getLanguage(), ws.getCostPerView(), ws.getEpisodeCount(), ws.getEpisodeDuration());
	}
	
	public WebSeries to() {
		return new WebSeries(episodeCount, costPerView);
	}
}
