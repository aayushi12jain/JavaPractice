package Solutions;

public class MainClass {

	public static void main(String[] args) {

		IntegerToRoman integerToRoman = new IntegerToRoman();
		integerToRoman.intToRoman(12);
		integerToRoman.intToRoman(239);
		integerToRoman.intToRoman(35);
		integerToRoman.intToRoman(46);
		integerToRoman.intToRoman(209);
		integerToRoman.intToRoman(1800);
		
		String[] r = {"XII", "CCXXXIX", "XXXV","XLVI", "CCIX","MDCCC"};
		for(String arg:r) {
			System.out.println(arg);
			integerToRoman.romanToInt(arg);
		}
		
		MergeSortedArray mergeSortedArray = new MergeSortedArray();
		int[] num1 = {1,2,3,0,0,0};
		int m=3;
		int[] num2 = {2,5,6};
		int n=3;
		mergeSortedArray.merge(num1, m, num2, n);
	}

}
