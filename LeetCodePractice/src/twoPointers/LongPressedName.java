package twoPointers;

public class LongPressedName {

	public boolean isLongPressedName() {
		String name = "alex";
		String typed = "aaleelx";
		if (name.length() > typed.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        if (name.charAt(i)!=typed.charAt(j)) {
            return false;
        }else {
        	i++;
        	j++;
        }
        while (i < name.length() && j < typed.length()) {
            char current = name.charAt(i);
            char prev = name.charAt(i-1);
            char b = typed.charAt(j);
            if(b != current && b !=prev) {
            	return false;
            }else if(b == current) {
            	j++;
            	i++;
            }else {
            	j++;
            }
        }
        
        while(j<typed.length()) {
        	char c = name.charAt(name.length()-1);
        	if(typed.charAt(j)!=c) {
        		return false;
        	}
        	j++;
        }
        return i==name.length();
    }
}
