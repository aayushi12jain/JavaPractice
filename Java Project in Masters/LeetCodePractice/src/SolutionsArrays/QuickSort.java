package SolutionsArrays;

public class QuickSort {

	public void quickSort( int[] arr, int low, int high){
		//{4,6,2,5,1,8,3};
		int pivot = arr[high];
		int left = low;
		int right = high-1;

		while(left<right){

			while(arr[left]<pivot && left<right){
				left++;
			}
			System.out.println("left = " + left);
			while(arr[right]>pivot && left<right){
				right--;
			}
			System.out.println("right = " + right);
			swap(arr, left, right);
		}

		swap(arr, left, high);
		if(low < left-1) 
			quickSort(arr, low, left-1);

		if(left+1 < high)
			quickSort(arr, left+1, high);

	}
	public void swap(int[] arr, int l, int r){
		int t= arr[l];
		arr[l] = arr[r];
		arr[r] = t;
	}
}
