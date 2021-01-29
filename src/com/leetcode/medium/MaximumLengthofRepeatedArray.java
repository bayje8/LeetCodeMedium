package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaximumLengthofRepeatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int findLength_BruteForce(int[] A, int[] B) {
        int len = A.length < B.length ? A.length: B.length;
         int startIdxA,endIdxA,startIdxB,endIdxB;
         for(;len>=0;len--){
             startIdxA=0;
             endIdxA=startIdxA+len-1;
             
             while(endIdxA<A.length&&startIdxA<A.length){
             
                 startIdxB=0;
                 endIdxB=startIdxB+len-1; 
                 
                 while(endIdxB<B.length && startIdxB<B.length){
                     if(A[startIdxA]==B[startIdxB]){
                         if(A[endIdxA]==B[endIdxB])
                         if(checkMatch(A, B, startIdxA, endIdxA, startIdxB, endIdxB)){
                             return len;
                         }
                     }
                     startIdxB++;
                     endIdxB=startIdxB+len-1;
                 }
                 startIdxA++;
                 endIdxA=startIdxA+len-1;
             }
             
         }
         return len<0?0:len;
     }
     
     public boolean checkMatch(int[] A, int[] B, int startIdxA, int endIdxA, int startIdxB, int endIdxB){       
         for(int i=0;i<=endIdxA-startIdxA;i++){
             if(A[startIdxA+i]!=B[startIdxB+i]){
                 return false;
             }
         }
         return true;
     }
     
     public int findLength_Greedy(int[] A, int[] B) {
         int max = 0;
         int count =0;
         for(int i=0;i<A.length;i++){
             for(int j=0;j<B.length;j++){
                 if(A[i]==B[j]){
                    count = checkMatch(A,B,i,j);
                     if(count>max){
                         max=count;
                     }
                     if(max==A.length || max==B.length){
                         return max;
                     }
                 }
             }
         }
         return max;
     }
     
     public int checkMatch(int[] A, int[] B, int idxA, int idxB){       
         int i = idxA;
         int j = idxB;
         while(i<A.length && j<B.length){
             if(A[i]==B[j]){
                 i++;
                 j++;
             } else {
                 return i-idxA;
             }
         }
         return i-idxA;
     }
     
     public int findLength_HashMap(int[] A, int[] B) {
    	 HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    	 for(int i=0;i<B.length;i++) {
    		 map.computeIfAbsent(B[i],x->new ArrayList<Integer>()).add(i);
    	 }
    	 int max=0;
    	 for(int j=0;j<A.length;j++) {
    		 if(map.containsKey(A[j])) {
    			 for(int i:map.get(A[j])) {
    				 int k = 0;
    				 while(j+k < A.length && i+k < B.length && A[j+k]==B[i+k]) {
    					 k++;
    				 }
    				 max=Math.max(max, k);
    			 }
    		 }
    	 }
    	 Arrays.copyOfRange(A, 0, max);
    	 return max;
     }
     
     
}
