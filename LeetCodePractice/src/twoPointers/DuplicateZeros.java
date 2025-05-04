package twoPointers;


/*
 * Input: arr = [1,0,0,2,0,4,5,0]//2	3
Output: [1,0,0,2,3,0,0,4]
 */
public class DuplicateZeros {

	public void doubleZeros() {
		int[] arr= {1,2,3};//2
		int len = arr.length;
		int i =0;
		while(i<len) {
			if(arr[i]==0) {
				int j=len-1;
				while(j>i) {
					arr[j]=arr[j-1];
					j--;
				}
				i=i+2;
			}else {
				i++;
			}
		}
		for(int a:arr) {
			System.out.print(a + "  ");
		}
	}
}










