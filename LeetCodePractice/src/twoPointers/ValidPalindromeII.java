package twoPointers;

public class ValidPalindromeII {	
	public void validPalindrome() {
			String s = "aabaa";
			int i=0, j=s.length()-1;
			while(i<j) {
				if(s.charAt(i)!=s.charAt(j)) {
					boolean result = isPallindrome(i, j-1, s) || isPallindrome(i+1, j, s);
					System.out.println(result);
					break;
				}
			}
		
	}
	
	public boolean isPallindrome(int i, int j , String s) {
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
