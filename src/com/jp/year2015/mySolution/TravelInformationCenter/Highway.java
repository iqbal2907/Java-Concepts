package com.jp.year2015.mySolution.TravelInformationCenter;

public class Highway {
	private final String id;
	private final City source;
	private final City destination;
	private final int weight;

	public Highway(String id, City source, City destination) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = 1;
	}

	public String getId() {
		return id;
	}
	public City getDestination() {
		return destination;
	}

	public City getSource() {
		return source;
	}
	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return source + " " + destination;
	}

}