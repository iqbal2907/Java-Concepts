package com.jp.year2015.mySolution.TravelInformationCenter;

import java.util.List;

public class Island {
	private final List<City> cities;
	private final List<Highway> paths;

	public Island(List<City> vertexes, List<Highway> edges) {
		this.cities = vertexes;
		this.paths = edges;
	}

	public List<City> getCities() {
		return cities;
	}

	public List<Highway> getPaths() {
		return paths;
	}

}