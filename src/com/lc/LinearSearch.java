package com.lc;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
LinearSearch obj = new LinearSearch();
System.out.println(obj.linearSrchOby2(new int[] {4,8,5,91,87,314,1,48,132,879458}, 48));
	}
	
	public int linearSrch(int[] arr, int x) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==x) {
				return i;
			}
		}
		return -1;
	}

	public int linearSrchOby2(int[] arr, int x) {
		int left = 0;
		int right = arr.length -1;
		while(left < right) {
			if(arr[left]==x) { return left;}
			if(arr[right]==x) {return right;}
			left++;
			right--;
		}
		return -1;
	}
	
}
