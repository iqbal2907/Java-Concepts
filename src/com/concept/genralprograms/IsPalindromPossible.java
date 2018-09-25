package com.concept.genralprograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;

public class IsPalindromPossible
{
	public static void main(String ap[])
	{
		ArrayList<String> palindromList = new ArrayList<>();
		palindromList.add("Anna");
		palindromList.add("Civic");
		palindromList.add("Kayak");
		palindromList.add("Level");
		palindromList.add("Madam");
		palindromList.add("Mom");
		palindromList.add("Noon");
		palindromList.add("Racecar");
		palindromList.add("Radar");
		palindromList.add("Refer");
		palindromList.add("Repaper");
		palindromList.add("Rotator");
		palindromList.add("Rotor");
		palindromList.add("Sagas");
		palindromList.add("Solos");
		palindromList.add("Stats");
		palindromList.add("Tenet");
		palindromList.add("Wow");
		
		for (String string : palindromList) {
			System.out.println("IS PALINDROME POSSIBLE WITH THE STRING :"+string+"\n RESULT : "+isPalindromPossible(string));	
		}
		
	}
	
	public static boolean isPalindromPossible(String str){
		boolean result=true;
		HashMap<Character, Integer> charMap = new HashMap<>();
		Character c;
		int oddOccuranceCount=0;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			c= c.toUpperCase(c);
			if (charMap.containsKey(c)) {
				int value = charMap.get(c);
				value++;
				charMap.put(c, value);
			} else {
				charMap.put(c, 1);
			}
 		}
		for (Entry<Character, Integer> entry : charMap.entrySet()) {
//			System.out.println("Entry : ("+entry.getKey()+","+entry.getValue()+")");
			if (entry.getValue()%2!=0) {
				oddOccuranceCount++;
				if (oddOccuranceCount>1) {
					return false;
				}
			}
		}
		return result;
	}
}

