package SolutionsArrays;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

	//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M

	public void intToRoman(int num) {
		Map<Integer, String> mapOfRoman = new HashMap<>();

		mapOfRoman.put(1,"I");
		mapOfRoman.put(4,"IV");
		mapOfRoman.put(5,"V");
		mapOfRoman.put(9,"IX");
		mapOfRoman.put(10,"X");
		mapOfRoman.put(40,"XL");
		mapOfRoman.put(50,"L");
		mapOfRoman.put(90,"XC");
		mapOfRoman.put(100,"C");
		mapOfRoman.put(400,"CD");
		mapOfRoman.put(500,"D");
		mapOfRoman.put(900,"CM");
		mapOfRoman.put(1000,"M");

		StringBuilder romanNum = new StringBuilder();
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

		for(int value:values) {
			while(num>=value) {
				romanNum.append(mapOfRoman.get(value));
				num-=value;
			}
		}

		System.out.println(romanNum.toString());
	}

	public void romanToInt(String roman) {
		Map<String, Integer> mapOfRoman = new HashMap<>();

		mapOfRoman.put("I",1);
		mapOfRoman.put("IV",4);
		mapOfRoman.put("V",5);
		mapOfRoman.put("IX",9);
		mapOfRoman.put("X",10);
		mapOfRoman.put("XL",40);
		mapOfRoman.put("L",50);
		mapOfRoman.put("XC",90);
		mapOfRoman.put("C",100);
		mapOfRoman.put("CD",400);
		mapOfRoman.put("D",500);
		mapOfRoman.put("CM",900);
		mapOfRoman.put("M",1000);
		int n=0;
		
		for(int i=0; i<roman.length(); i++) {
			if(i<roman.length()-1 && mapOfRoman.containsKey(roman.substring(i, i+2))) {
				n+= mapOfRoman.get(roman.substring(i,i+2));
				i++;
			}else {
				n+= mapOfRoman.get(roman.substring(i, i+1));
			}
		}
		
		System.out.println(n);

	}

}