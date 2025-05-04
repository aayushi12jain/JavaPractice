package SolutionStrings;

public class ZigzagConversion {
	public void convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder();
		int strLen = s.length();
		int c=0;
		for(int i=0;i<numRows;i++) {
			while(c<strLen) {
				sb.append(s.charAt(c));
				c+=4;
			}
		}
		System.out.println(sb.toString());
	}
}
