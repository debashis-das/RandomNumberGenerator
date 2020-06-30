package com.assignment.randomNoGenerator;

import java.util.Arrays;
import java.util.Set;

public class NumberStore {

    int[][] values;
    int headIndex;
    int sizePerSecond;
    int noOfSeconds;
    Set<Integer> intervals;
    boolean filled;

    public NumberStore(int sizePerSecond,int noOfSeconds,Set<Integer> intervals) {
        this.values = new int[noOfSeconds][sizePerSecond];
        this.headIndex = -1;
        this.sizePerSecond = sizePerSecond;
        this.noOfSeconds = noOfSeconds;
        this.intervals = intervals;
        this.filled = false;
    }

    public void addValue(int[] nosPerSecond){
        ++headIndex;
        if(headIndex == noOfSeconds){
            headIndex = 0;
            filled = true;
        }
        values[headIndex] = nosPerSecond;
    }

    public int[][] sendValues(int intervalInSeconds){
        if(intervals.contains(intervalInSeconds)){
            int[][] result;
            result = new int[intervalInSeconds][sizePerSecond];
            if(filled){
                if(headIndex+1>=intervalInSeconds){
                    result = Arrays.copyOfRange(values,headIndex-intervalInSeconds+1,headIndex+1);
                }else{
                    int diff = intervalInSeconds-(headIndex+1);
                    int[][] result1 = Arrays.copyOfRange(values,noOfSeconds-diff,noOfSeconds);
                    int[][] result2 = Arrays.copyOfRange(values,0,headIndex+1);
                    System.arraycopy(result1, 0, result, 0, result1.length);
                    System.arraycopy(result2, 0, result, result1.length, result2.length);
                }
            }else{
                if(headIndex+1>=intervalInSeconds){
                    result = Arrays.copyOfRange(values,headIndex-intervalInSeconds+1,headIndex+1);
                }else{
                    result = Arrays.copyOfRange(values,0,headIndex+1);
                }
            }
            return result;
        }
        return new int[][]{};
    }
    
}