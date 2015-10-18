package Exam2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static Map<Integer, LinkedHashSet<City>> adjMap = new HashMap<Integer, LinkedHashSet<City>>();
	public static List<City> listOfFestiveCities = new ArrayList<City>();
	public static List<City> listOfVisitedCities = new ArrayList<City>();

	public static void main(String[] args) {

		int totalCities = Integer.parseInt(args[0]);
		int i = 0;

		for (i = 2; i < totalCities * 2; i += 2) {

			if (adjMap.get(Integer.parseInt(args[i])) == null) {
				LinkedHashSet<City> cityList = new LinkedHashSet<City>();
				cityList.add(new City(Integer.parseInt(args[i + 1])));
				adjMap.put(Integer.parseInt(args[i]), cityList);

				if (adjMap.get(Integer.parseInt(args[i + 1])) == null) {
					LinkedHashSet<City> cityLst = new LinkedHashSet<City>();
					cityLst.add(new City(Integer.parseInt(args[i])));
					adjMap.put(Integer.parseInt(args[i + 1]), cityLst);
				} else {
					adjMap.get(Integer.parseInt(args[i + 1])).add(new City(Integer.parseInt(args[i])));
				}
			} else {
				adjMap.get(Integer.parseInt(args[i])).add(new City(Integer.parseInt(args[i + 1])));
				if (adjMap.get(Integer.parseInt(args[i + 1])) == null) {
					LinkedHashSet<City> cityLst = new LinkedHashSet<City>();
					cityLst.add(new City(Integer.parseInt(args[i])));
					adjMap.put(Integer.parseInt(args[i + 1]), cityLst);
				} else {
					adjMap.get(Integer.parseInt(args[i + 1])).add(new City(Integer.parseInt(args[i])));
				}
			}
		}
		makeCityFestive(1);

		for (; i < args.length; i += 2) {
			if (Integer.parseInt(args[i]) == 1) {
				makeCityFestive(Integer.parseInt(args[i + 1]));
			} else if (Integer.parseInt(args[i]) == 2) {
				int minDistance = getNearestFestiveCityDistance(Integer.parseInt(args[i + 1]));
				System.out.println(minDistance);
			//	printPath(Integer.parseInt(args[i + 1]));
				System.out.println(adjMap);
				listOfVisitedCities.clear();
				resetMap(Integer.parseInt(args[i + 1]));
			}
		}
	}

	private static void printPath(int i) {
		List<Integer> path = new ArrayList<Integer>();
		path.add(i);
		City c = new City(i);
		while (!c.isFestive()) {
			LinkedHashSet<City> adjCitySet = adjMap.get(i);
			Iterator<City> iterator = adjCitySet.iterator();
			while (iterator.hasNext()) {
				City cty = (City) iterator.next();
				if (cty.getParentId() == c.getId()) {
					c = cty;
					path.add(cty.getParentId());
					break;
				}
			}
			System.out.println(path);
		}
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

	private static int getNearestFestiveCityDistance(int i) {
		Queue<City> queue = new LinkedList<City>();
		City city = new City(i);

		if (checkFestiveCity(city)) {
			return city.getTotalDistance();
		}
		queue.add(city);
		while (!queue.isEmpty()) {
			City c = queue.remove();
			if (c.isFestive()) {
				return c.getTotalDistance();
			}
			c.setVisited(true);
			listOfVisitedCities.add(city);
			System.out.println("Parent : " + c);
			City child = null;
			while ((child = getUnvisitedChildNode(c)) != null) {
				child.setParentId(c.getId());
				child.setTotalDistance(c.getTotalDistance() + 1);
				System.out.println("Child : " + child);
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
				if (node.isVisited() == false && !listOfVisitedCities.contains(node)) {
					node.setVisited(true);
					listOfVisitedCities.add(node);
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
		return "(" + this.id + "," + this.isFestive + "," + this.parentId + "," + this.isVisited + ","
				+ this.totalDistance + ")";
	}

	public static void main(String[] args) {
		City c1 = new City(1);
		c1.isFestive = true;
		c1.totalDistance = 10;
		City c2 = new City(2);
		City c3 = new City(1);

		System.out.println(c1.equals(c3));
		System.out.println(c1.equals(c2));

	}
}