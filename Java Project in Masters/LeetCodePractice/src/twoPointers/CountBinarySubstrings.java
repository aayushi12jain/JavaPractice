package twoPointers;

public class CountBinarySubstrings {

	public void countBinarySubstrings() {
		String s = "00100";
		
		int prevRun = 0;
		int curRun = 1;
		int count = 0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==s.charAt(i-1)) {
				curRun++;
			}else {
				count += Math.min(prevRun, curRun);
				prevRun = curRun;
				curRun = 1;
			}
		}
		count += Math.min(prevRun, curRun);
		System.out.println(count);
		
	}
}
