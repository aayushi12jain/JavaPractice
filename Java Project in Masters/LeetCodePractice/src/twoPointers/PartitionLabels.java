package twoPointers;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public void partitionLabels() {
		String s = "qiejxqfnqceocmy";
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		while(i<s.length()) {
			int j=i;
			int p = s.lastIndexOf(s.charAt(i));
			while(j<=p) {
				int n = s.lastIndexOf(s.charAt(j));
				if(n>p) {
					p=n;
				}
				j++;
			}
			result.add(j-i);
			i=p+1;
		}
		System.out.println("Result : "+ result.toString());
	}

	/*public void partitionLabels() {
		String s = "qiejxqfnqceocmy";
		int i=0;
		int a;
		int j;

		List<Integer>  result = new ArrayList<Integer>();
		
		while(i<s.length()) {
			a=s.lastIndexOf(s.charAt(i));
			j=a+1;
			String s1=s.substring(i,j);
			while(j<s.length()) {
				if(s1.matches(".*"+ s.charAt(j)+ ".*")) {
					a = j;
				}
				j++;
			}
			System.out.println(a + "  " + i); 
			result.add(a-i+1);
			i=a+1; 
			
		}
		System.out.println("Result : "+ result.toString());

	}
	*/
	
	
}












