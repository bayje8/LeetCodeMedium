package com.lc;

public class InterpolationSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(interpolationSrch(new int[] {3,7,11,15,19,23}, 15));
	}
	
	public static int interpolationSrch(int[] arr, int x) {
		System.out.println(">>>");
		if (arr.length == 0)
			return -1;
		if (arr.length == 1) {
			if (arr[0] == x) {
				return 0;
			} else {
				return -1;
			}
		}
		if ((x - arr[0]) % (arr[1] - arr[0]) != 0) {
			return -1;
		} else {
			return (x - arr[0]) / (arr[1] - arr[0]);
		}
	}

}
