package com.lc;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BinarySearch obj = new BinarySearch();
System.out.println(obj.binarySearch(new int[] {2,5,8,12,16,23,38,56,72,91,123},20));
System.out.println(obj.iterativeBinarySearch(new int[] {2,5,8,12,16,23,38,56,72,91,123},123));
	}
	
	public int binarySearch(int[] nums, int target) {
		int lIndex = 0;
		int uIndex = nums.length-1;
		int mIndex = (uIndex-lIndex)/2;
		System.out.println(lIndex+":"+mIndex+":"+uIndex);
		return recursiveBinarysearch(lIndex,mIndex,uIndex,nums,target);
	}
	
	public int recursiveBinarysearch(int lIndex, int mIndex, int uIndex, int[]nums, int target) {
		if(mIndex<=0) {
			return -1;
		}
		if(nums[uIndex]==target) {
			return uIndex;
		}else if(nums[lIndex]==target) {
			return lIndex;
		}else if(nums[mIndex]==target) {
			return mIndex;
		}else if(nums[mIndex]>target){
			return recursiveBinarysearch(lIndex,(mIndex-lIndex-1)/2,mIndex-1,nums,target);
		} else if (nums[mIndex]<target) {
			return recursiveBinarysearch(mIndex+1,(uIndex-mIndex-1)/2,uIndex,nums,target);
		}
		
		return -1;
	}
	
	public int iterativeBinarySearch(int[] nums, int target) {
		int lIndex =0;
		int uIndex=nums.length-1;
		int mIndex = (uIndex-lIndex)/2;
		if(target>nums[uIndex]) {return -1;}
		while(uIndex >= lIndex) {
			if(nums[uIndex]==target) {
				return uIndex;
			}else if(nums[lIndex]==target) {
				return lIndex;
			}else if(nums[mIndex]==target) {
				return mIndex;
			}else if(nums[mIndex]<target) {
				lIndex = mIndex + 1;
				mIndex = mIndex + (uIndex-lIndex)/2;
			}else if (nums[mIndex]>target) {
				uIndex = mIndex -1;
				mIndex = lIndex + (uIndex-lIndex)/2;
			}
		}
		return -1;
	}

}
