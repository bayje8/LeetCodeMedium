package com.lc;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PartitionEqualSubSum {
	int[][] memo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
PartitionEqualSubSum obj = new PartitionEqualSubSum();
System.out.println(obj.canPartitionRecursion(new int[] {9,6,7,6}));
//obj.sums(new int[] {1,2,3,4});
	}
	
    public boolean canPartition(int[] nums) {
    	memo = new int[2^nums.length][];
        Arrays.sort(nums);
        System.out.println(nums);
        for(int i=1;i<=nums.length-1;i++){
        	int sum1 = IntStream.range(0,i).map(x->nums[x]).sum();
        	int sum2 = IntStream.range(i,nums.length).map(x->nums[x]).sum();
        	System.out.println("i: "+i+"sum1: "+sum1+"sum2:"+sum2);
            if(IntStream.range(0,i).map(x->nums[x]).sum() == IntStream.range(i,nums.length).map(x->nums[x]).sum())
                return true;
        }
        return false;
    }
    
    public boolean canPartitionRecursion(int[] nums)
    {    	    	    
    	int sum=0,max=0;
    	for(int num:nums) {
    		sum=sum+num;
    		if(num>max) {
    			max=num;
    		}
    	}
    	if(sum%2 !=0) { return false;}
    	if(max > sum/2) { return false;}    	
    	
    	// recursive(sum/2,nums.length-1,nums);
    	 return recurSum(0,nums,nums.length-1,sum/2);
    }
    
    public boolean recursive(int subSetSum, int n, int[] nums) {
    	if(subSetSum == 0) {
    		return true;
    	} else if (subSetSum < 0) {
    		return false;
    	}
    	if(n<=0) {
    		return false;
    	}    	
    	return recursive(subSetSum-nums[n], n-1, nums) || recursive(subSetSum, n-1, nums); 
    }    

	public boolean recurSum(int sum, int[] nums, int n, int target) {
		if (n == -1) {
			System.out.print(sum + " ");
			if (target == sum) {
				return true;
			} else {
				return false;
			}
		}
		return recurSum(sum + nums[n], nums, n - 1, target) ||	recurSum(sum, nums, n - 1, target);
	}

}
