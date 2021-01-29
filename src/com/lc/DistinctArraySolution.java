package com.lc;

public class DistinctArraySolution {
	    public int getWinner(int[] arr, int k) {
	        int winner = arr[0];
	        if(k <= arr.length-1){
	            int win_count=0;
	            while(true){
	                if(arr[0] > arr[1]){
	                    if(winner != arr[0]){
	                        win_count = 0;
	                    }
	                    winner = arr[0];
	                    win_count++;
	                    arr = reorder(false, arr);
	                } else {
	                    if(winner != arr[1]){
	                        win_count = 0;
	                    }
	                    winner = arr[1];
	                    win_count++;
	                    arr = reorder(true, arr);
	                }
	                if(k==win_count){
	                    break;
	                }
	            }            
	        } else {            
	            for(int i=1;i<arr.length;i++){
	                if(winner < arr[i]){
	                    winner=arr[i];
	                }
	            }            
	        }    
	        return winner;
	    }
	    
	    public int[] reorder(boolean flag, int[] arr){
	        int temp[] = new int[arr.length];
	        if(flag){
	            temp[0]=arr[0];
	            temp[arr.length-1]=arr[1];    
	        }else{
	            temp[0]=arr[1];
	            temp[arr.length-1]=arr[0];    
	        }
	        for(int i=2; i<arr.length-1;i++){
	            temp[i-1]=arr[i];
	        }
	        return temp;
	    }
	}
