package com.jp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems {

	public int getMaxIntervalOverlapCount(List<Interval> intervals) {
		// implement here
		if (intervals == null || intervals.isEmpty()) {
			return 0;
		} else if (intervals.contains(null)) {
			throw new IllegalArgumentException("intervals list should not contains null value");
		}
		return 1;
	}

	public int getMaxWorkingTime(List<Interval> intervals) {
		// implement here
		if (intervals == null || intervals.isEmpty()) {
			return 0;			
		} else if (intervals.size()>10000) {
			throw new IllegalArgumentException("intervals size exceeds the limit");
		}
		return 1;
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		//intervals = null;
		intervals.add(new Interval("09:00", "12:30"));
		intervals.add(new Interval("09:00", "12:30"));
		
		List<Interval> figure2 = Arrays.asList(new Interval("09:00", "12:30"),
				new Interval("06:00", "09:30"), new Interval("12:00", "14:30"),
				new Interval("10:00", "10:30"), new Interval("11:00", "13:30"));
//		System.out.println(new Problems().getMaxIntervalOverlapCount(intervals));
		
		System.out.println(new Problems().getMaxWorkingTime(intervals));
	}
}
