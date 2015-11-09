package com.jp.year2015.Exam2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Main {

	public static Map<Integer, LinkedHashSet<City>> adjMap = new HashMap<Integer, LinkedHashSet<City>>();
	public static List<City> listOfFestiveCities = new ArrayList<City>();
	public static Set<City> parents = new LinkedHashSet<City>();
	

	public static void main(String[] args) {

		int totalCities = Integer.parseInt(args[0]);
		int i = 0;
		
		for (i = 2; i < totalCities*2; i+=2) {

			if (adjMap.get(Integer.parseInt(args[i])) == null) {
				LinkedHashSet<City> cityList = new LinkedHashSet<City>();
				cityList.add(new City(Integer.parseInt(args[i+1])));
				adjMap.put(Integer.parseInt(args[i]), cityList);
				
				if (adjMap.get(Integer.parseInt(args[i+1])) == null) {
					LinkedHashSet<City> cityLst = new LinkedHashSet<City>();
					cityLst.add(new City(Integer.parseInt(args[i])));
					adjMap.put(Integer.parseInt(args[i+1]), cityLst);
				} else {
					adjMap.get(Integer.parseInt(args[i+1])).add(new City(Integer.parseInt(args[i])));
				}
			} else {
				adjMap.get(Integer.parseInt(args[i])).add(new City(Integer.parseInt(args[i+1])));
				if (adjMap.get(Integer.parseInt(args[i+1])) == null) {
					LinkedHashSet<City> cityLst = new LinkedHashSet<City>();
					cityLst.add(new City(Integer.parseInt(args[i])));
					adjMap.put(Integer.parseInt(args[i+1]), cityLst);
				} else {
					adjMap.get(Integer.parseInt(args[i+1])).add(new City(Integer.parseInt(args[i])));
				}
			}
		}
		makeCityFestive(1);

		for (; i < args.length; i+=2) {
			if (Integer.parseInt(args[i]) == 1) {
				makeCityFestive(Integer.parseInt(args[i+1]));
			} else if (Integer.parseInt(args[i]) == 2) {
				City city = getNearestFestiveCityDistance(Integer.parseInt(args[i+1]));
				System.out.println("TotalDistance : "+city.getTotalDistance());
				System.out.print("Path : ");
				if (city.getParentId() != 0) {
					System.out.println(printPath(city));
				}
				System.out.println();
				resetMap(Integer.parseInt(args[i+1]));
				parents.clear();
			}
		}
	}

	private static ArrayList<Integer> printPath(City city) {
		Iterator<City> itr = parents.iterator();
		Map<Integer, City> pathMap = new HashMap<Integer, City>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		while (itr.hasNext()) {
			City c = (City) itr.next();
			pathMap.put(c.getId(), c);
		}
		
		Boolean flag = true;
		int id = city.getId();
		while (flag) {
			City c = pathMap.get(id);
			path.add(id);
			if (c.getParentId() == 0) {
				flag = false;
			} else {
				id = c.getParentId();
			}
		}
		Collections.reverse(path);
		return path;
	}

	private static void makeCityFestive(int i) {
		LinkedHashSet<City> citySet = adjMap.get(i);
		for (City city : citySet) {
			LinkedHashSet<City> adjCitySet = adjMap.get(city.getId());
			Iterator<City> iterator = adjCitySet.iterator();
			while (iterator.hasNext()) {
				City cty = (City) iterator.next();
				if (cty.getId() == i) {
					cty.setFestive(true);
					listOfFestiveCities.add(cty);
				}
			}
		}
	}

	// To reset the already visited node status
	private static void resetMap(int i) {
		City city = new City(i);
		Stack<City> s = new Stack<City>();
		s.push(city);
		city.setVisited(false);
		while (!s.isEmpty()) {
			City n = s.peek();
			City child = getVisitedChildNode(n);
			if (child != null) {
				city.setVisited(true);
				city.setParentId(0);
				s.push(child);
			} else {
				s.pop();
			}
		}
	
	}

	private static City getVisitedChildNode(City n) {
		LinkedHashSet<City> list = (LinkedHashSet<City>) adjMap.get(n.getId());
		if (list != null) {
			Iterator<City> itr = list.iterator();
			while (itr.hasNext()) {
				City node = itr.next();
				if (node.isVisited()) {
					node.setVisited(false);
					node.setTotalDistance(0);
					return node;
				}
			}
		}
		return null;
	}

	private static City getNearestFestiveCityDistance(int i) {
		Queue<City> queue = new LinkedList<City>();
		City city = new City(i);
		
		if(checkFestiveCity(city)){
			return city;
		}
		city.setVisited(true);
		queue.add(city);
		while (!queue.isEmpty()) {
			City c = queue.remove();
			parents.add(c);
			if (c.isFestive()) {
				return c;
			}
			City child = null;
			while ((child = getUnvisitedChildNode(c)) != null) {
				child.setParentId(c.getId());
				child.setTotalDistance(c.getTotalDistance()+1);
				queue.add(child);
			}
		}
		return null;
	}

	private static boolean checkFestiveCity(City city) {
		if (listOfFestiveCities.contains(city)) {
			return true;
		}
		return false;
	}

	private static City getUnvisitedChildNode(City n) {
		LinkedHashSet<City> list = (LinkedHashSet<City>) adjMap.get(n.getId());
		if (list != null) {
			Iterator<City> itr = list.iterator();
			while (itr.hasNext()) {
				City node = itr.next();
				if (!node.isVisited()) {
					node.setVisited(true);
					return node;
				}
			}
		}
		return null;
	}

}

class City {
	final private int id;
	private int parentId;
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
	
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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
		return "("+this.id+","+this.isFestive+","+this.parentId+","+this.isVisited+","+this.totalDistance+")";
	}

}