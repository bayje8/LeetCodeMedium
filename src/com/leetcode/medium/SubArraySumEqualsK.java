package com.leetcode.medium;

public class SubArraySumEqualsK {
    int max = 0;
    int count = 0;
    int[][] memo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
SubArraySumEqualsK obj = new SubArraySumEqualsK();
System.out.println(obj.subarraySum(new int[] {2,1,8,0,5,3,2,2,4},8));
	}

    public int subarraySum(int[] nums, int k) {
        memo = new int[nums.length][nums.length];
        for(int i=0;i<=nums.length-1;i++){
            for(int j=0;j<=nums.length-1-i;j++){
                if(sum(nums,j,j+i) == k){
                    count=1;
                    rightSum(nums,j+i+1,nums.length-1,k);
                    leftSum(nums,0,j-1,k);
                    if(count>max){
                        max=count;
                    }
                }
            }            
        }
        return max;
    }
    
    public int sum(int[] nums, int startIdx, int endIdx){        
        if(memo[startIdx][endIdx]!=0){
            return memo[startIdx][endIdx];
        }
        int sum = 0;
        int i = startIdx;
        while(i<=endIdx){
            sum=sum+nums[i];
            i++;
        }
        memo[startIdx][endIdx] = sum;
        return sum;
    }
    
    public void rightSum(int[] nums, int startIdx, int endIdx,int k){
        int i=0;
        while(startIdx+i<=endIdx){
            if(sum(nums,startIdx,startIdx+i)==k){
                count++;
                if(startIdx+i+1<=endIdx){
                    rightSum(nums,startIdx+i+1,endIdx,k);
                }
            }
            i++;
        }
    }
    
    public void leftSum(int[] nums, int startIdx, int endIdx,int k){
        int i = 0;
        while(endIdx-i>=startIdx){
            if(sum(nums,endIdx-i,endIdx)==k){
                count++;
                if(endIdx-i-1>=startIdx){
                    leftSum(nums, startIdx, endIdx-i-1, k);
                }
            }
            i++;
        }
    }
}
