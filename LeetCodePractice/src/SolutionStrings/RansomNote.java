package SolutionStrings;

import java.util.*;
import java.util.Map.Entry;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		char[] mArr = magazine.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		for(char c:mArr) {
			if(map.containsKey(c)) 
				map.put(c, map.get(c)+1);
			else
				map.put(c,1);
		}

		System.out.println(map.keySet());
		char[] rArr = ransomNote.toCharArray();
		for(char c:rArr) {
			if(map.containsKey(c)) {
				if(map.get(c)==1) {
					map.remove(c);
				}
				else {
					map.put(c,map.get(c)-1 );
				}
			}
			else {
				return false;
			}
		}

		System.out.println(map.keySet());

		return true;
	}

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Character, Character> mapST = new HashMap<>();
		Map<Character, Character> mapTS = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (mapST.containsKey(c1)) {
				if (mapST.get(c1) != c2)
					return false;
			} else {
				if (mapTS.containsKey(c2))
					return false; // c2 is already mapped to some other character
				mapST.put(c1, c2);
				mapTS.put(c2, c1);
			}
		}

		return true;
	}

	public boolean wordPattern(String pattern, String s) {
		
		String[] str = s.split(" ");
		char[] arr= pattern.toCharArray();
		if(str.length != arr.length) {
			return false;
		}
			
		Map<Character,String> mapSP = new HashMap<>();
		
		for(int i=0;i<str.length;i++) {
			if(mapSP.containsKey(arr[i])) {
				if(mapSP.get(arr[i]).equals(str[i])) {
					return false;
				}
			}else
			{
				mapSP.put(arr[i], str[i]);
			}
		}
		
		return true;
	}

}
