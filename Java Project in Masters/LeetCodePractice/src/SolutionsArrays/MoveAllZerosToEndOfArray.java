package SolutionsArrays;

import java.util.Arrays;

public class MoveAllZerosToEndOfArray {

	public void MoveAllZeros(int[] arr) {
		System.out.println("Original Arr : " + Arrays.toString(arr));
		int i=0;
		int j=arr.length-1;
		while(i<arr.length && j>=0 && i<j) {
			if(arr[i]==0) {
				if(arr[j]!=0) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j]=temp;
					i++;
				}else {
					j--;
				}
			}else {
				i++;
			}
		}
		System.out.println("Shifted Arr : " + Arrays.toString(arr));
	}
}
