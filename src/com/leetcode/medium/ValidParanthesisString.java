package com.leetcode.medium;

public class ValidParanthesisString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//System.out.println(checkValidString("(*()"));
		ValidParanthesisString obj = new ValidParanthesisString();
		obj.test();
	}
	
	
	public void test() {
		
	}
	class Test{
		int k;

		public int getK() {
			return k;
		}

		public void setK(int k) {
			this.k = k;
		}
		
	}
    public static boolean checkValidString(String s) {
        while(s.contains("()")||s.contains("(\\*)")){
            s=s.replaceAll("\\(\\)","");
        }
        System.out.println(s+":"+s.substring(0,1));
        while(
            (s.startsWith("(")   && s.substring(s.length()-1).equals(")"))||
            (s.startsWith("*") && s.substring(s.length()-1).equals(")"))||
            (s.startsWith("(")   && s.substring(s.length()-1).equals("*"))
            )
        {
            s=s.substring(1,s.length()-1);
        }
        return s.equals("\\*") || s.equals("");
    }
    
	/*
	 * BRUTE FORCE APPROACH:
	 * 
	 This solution finds all combinations when '*' is replaced with '(' or ')' or empty string.
	 
	 Approach: Method recursion (string is repeated for 3 combinations each time to recur
	 
	 Time complexity: O(na^3) -- na-> number of asterisks
	 
	 */
    public boolean checkValidString_BruteForce(String s) {    
        return checkAndReplaceFirstAsterisk(s);
    }
    
    public boolean checkAndReplaceFirstAsterisk(String s){
        int pos = s.indexOf("*");
        if(pos>-1){
            return checkAndReplaceFirstAsterisk(s.replaceFirst("\\*","")) || checkAndReplaceFirstAsterisk(s.replaceFirst("\\*","(")) || checkAndReplaceFirstAsterisk(s.replaceFirst("\\*",")"));
        }else{
            while(s.contains("()")){
                s=s.replaceAll("\\(\\)","");
            }
            return s.equals("");
        }
    }

}
