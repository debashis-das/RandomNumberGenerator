package com.assignment.randomNoGenerator;

import java.util.Arrays;
import java.util.Random;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomNumberGenerator extends TimerTask {

    Random random; 
    NumberStore numberStore;
    int size;
    Logger logger = LoggerFactory.getLogger(RandomNumberGenerator.class);

    public RandomNumberGenerator(NumberStore numberStore,int size) {
        super();
        this.size = size;
        this.random = new Random();
        this.numberStore = numberStore;
    }
    
    @Override
    public void run() {
        int[] numbersPerSecond = new int[size];
        for(int i=0;i<size;i++){
            numbersPerSecond[i] = getRandomNumber();
        }
        numberStore.addValue(numbersPerSecond);
        logger.info(Arrays.toString(numbersPerSecond));
    }

    private int getRandomNumber(){
        return random.nextInt(1000); 
    }

}