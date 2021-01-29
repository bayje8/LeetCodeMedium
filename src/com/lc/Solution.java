package com.lc;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.diffWaysToCompute("1*2+8-8*4-3*4*2"));
		

	}
    public List<Integer> diffWaysToCompute(String input) {    	
        return recur(input);
    }
    private List<Integer> recur(String in){
        List<Integer> res=new ArrayList();
        for(int k=0;k<in.length()-1;k++){
            if(in.charAt(k)>='0' && in.charAt(k)<='9') continue;
            List<Integer> left=recur(in.substring(0,k));
            List<Integer> right=recur(in.substring(k+1));
            for(int l : left)
                for(int r : right)
                    res.add(evaluate(l,r,in.charAt(k)));
        }
        if(res.size()==0) res.add(Integer.parseInt(in));
        System.out.println(res.size());
        return res;
    }
    private int evaluate(int v1,int v2,char o){
        if(o=='+') return v1+v2;
        else if(o=='-') return v1-v2;
        else return v1*v2;
    }
}
