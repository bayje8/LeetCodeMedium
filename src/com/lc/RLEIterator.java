package com.lc;

public class RLEIterator {
    int[] A;
    long f = 0;
    public RLEIterator(int[] A) {
        this.A = A;
    }
    
    public int next(int in) {
        long n = (long)in + f;
        long q = 0;
        for (int i = 0;i < A.length;i=i+2){
            q = q + A[i];
            if(n<=q){
                f = n;
                return A[i+1];
            }
        }
        f=n;
        return -1;
    }
}
