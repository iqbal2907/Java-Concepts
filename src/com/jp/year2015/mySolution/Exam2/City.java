package com.jp.year2015.mySolution.Exam2;

public class City {
	final private int id;
	private boolean isFestive;
	private boolean isVisited;
	private int totalDistance;

	public City(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public boolean isFestive() {
		return isFestive;
	}
	
	public void setFestive(boolean isFestive) {
		this.isFestive = isFestive;
	}
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public int getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(int totalDistance) {
		this.totalDistance = totalDistance;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City city = (City) obj;
		if (this.id == city.id) {
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "("+this.id+","+this.isFestive+","+this.isVisited+","+this.totalDistance+")";
	}

}