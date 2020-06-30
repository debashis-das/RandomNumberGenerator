package com.assignment.randomNoGenerator;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import com.assignment.randomNoGenerator.NumberStore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class Config {

    int valuesPerSecond;
    int maxSeconds;
    NumberStore numberStore;
    RandomNumberGenerator randomNumberGenerator;

    public Config() {
        this.valuesPerSecond = Constants.valuesPerSecond;
        this.maxSeconds = Constants.maxSeconds;
        Set<Integer> intervals = Arrays.stream(Constants.intervals).boxed().collect(Collectors.toSet());
        this.numberStore =  new NumberStore(valuesPerSecond, maxSeconds,intervals);
        this.randomNumberGenerator = new RandomNumberGenerator(numberStore,valuesPerSecond);
    }
    
    @Bean
    public NumberStore numberStore(){
        return this.numberStore;
    }

    @Bean
    public RandomNumberGenerator randomNumberGenerator(){
        return this.randomNumberGenerator;
    }

    
}