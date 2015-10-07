package com.jp.year2015.mySolution.TravelInformationCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TestTIC {

	public static Map<Integer, LinkedHashSet<City>> adjMap = new HashMap<Integer, LinkedHashSet<City>>();
	public static List<City> listOfFestiveCities = new ArrayList<City>();
	

	public static void main(String[] args) {
		int totalCities = Integer.parseInt(args[0]);
		int totalQueries = Integer.parseInt(args[1]);
//		System.out.println("totalCities : " + totalCities);
//		System.out.println("totalQueries : " + totalQueries);

		System.out.println("cities : ");
		int i = 0;
		for (i = 2; i < totalCities*2; i+=2) {

			System.out.println(args[i]+" "+args[i+1]);
			
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

		System.out.println("queries : ");
		
		for (; i < args.length; i+=2) {
			System.out.println(args[i]+" "+args[i+1]);
			if (Integer.parseInt(args[i]) == 1) {
				System.out.println("Change city "+(args[i+1])+" to festive");
				makeCityFestive(Integer.parseInt(args[i+1]));
			} else if (Integer.parseInt(args[i]) == 2) {
//				System.out.println("find nearest festive city from city "+(args[i+1]));
				int minDistance = getNearestFestiveCityDistance(Integer.parseInt(args[i+1]));
				System.out.println("minDistance : " + minDistance);
				resetMap(Integer.parseInt(args[i+1]));
			}
		}
		
		System.out.println(adjMap);
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

	private static int getNearestFestiveCityDistance(int i) {
		Queue<City> queue = new LinkedList<City>();
		City city = new City(i);
		
		if(checkFestiveCity(city)){
			return city.getTotalDistance();
		}
		city.setVisited(true);
		queue.add(city);
		while (!queue.isEmpty()) {
			City c = queue.remove();
			if (c.isFestive()) {
				return c.getTotalDistance();
			}
			City child = null;
			while ((child = getUnvisitedChildNode(c)) != null) {
				child.setTotalDistance(c.getTotalDistance()+1);
				queue.add(child);
			}
		}
		return -1;
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
