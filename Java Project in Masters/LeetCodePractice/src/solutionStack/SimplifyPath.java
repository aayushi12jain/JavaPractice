package solutionStack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPathCode(String path) {
        Stack<String> st = new Stack();
        String[] s = path.split("/");
        for(String str : s){
            if(!st.isEmpty() && s.equals("..")){
                st.pop();
            }else{
                st.push(str);
            }
        }
        
        String  result = String.join("/", st);
        StringBuilder ab = new StringBuilder();
        ab.append("/");
        ab.append(result);
        if(result.equals("root")){
            ab.append("/");
        }
        return ab.toString();
    }
}
