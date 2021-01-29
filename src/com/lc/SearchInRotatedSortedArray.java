package com.lc;

public class SearchInRotatedSortedArray {
public static void main(String[] args) {
	SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
	System.out.println(obj.search(new int[] {1}, 1));
}
public int search(int[] nums, int target) {
    for(int i=0;i<nums.length-1;i++){
    	System.out.println("nums[i]: "+nums[i]+" target "+target );
        if(nums[i]==target){
            return i;
        }
    }
    return -1;
}
}
