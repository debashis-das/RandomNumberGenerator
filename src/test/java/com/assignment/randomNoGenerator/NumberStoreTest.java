package com.assignment.randomNoGenerator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberStoreTest {

    NumberStore numberStore;

    @BeforeEach
    public void init(){
        int[] intervals = {10,30,60};
        Set<Integer> set = Arrays.stream(intervals).boxed().collect(Collectors.toSet());
        numberStore = new NumberStore(1, 60, set);
    }

    @Test
    public void numberStoreNotFilledSecGreaterThanIndex(){
        for(int i=0;i<30;i++){
            int[] val = {i+1};
            numberStore.addValue(val);
        }
        int[][] result = numberStore.sendValues(10);
        assertEquals(10, result.length);
        assertEquals(false, numberStore.filled);
        int index=0;
        for(int i=21;i<30;i++,index++){
            int[] temp = {i};
            assertArrayEquals(temp, result[index]);
        }
    }

    @Test
    public void numberStoreNotFilledSecLessThanIndex(){
        for(int i=0;i<10;i++){
            int[] val = {i+1};
            numberStore.addValue(val);
        }
        int[][] result = numberStore.sendValues(30);
        assertEquals(10, result.length);
        assertEquals(false, numberStore.filled);
        for(int i=0;i<10;i++){
            int[] temp = {i+1};
            assertArrayEquals(temp, result[i]);
        }
    }

    @Test
    public void numberStoreFilledSecLessThanIndex(){
        for(int i=0;i<100;i++){
            int[] val = {i+1};
            numberStore.addValue(val);
        }
        int[][] result = numberStore.sendValues(30);
        assertEquals(60, numberStore.values.length);
        assertEquals(30, result.length);
        assertEquals(true, numberStore.filled);
        int index=0;
        for(int i=71;index<30;i++,index++){
            int[] temp = {i};
            assertArrayEquals(temp, result[index]);
        }
    }
    
}