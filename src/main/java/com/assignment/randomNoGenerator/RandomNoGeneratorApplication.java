package com.assignment.randomNoGenerator;

import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RandomNoGeneratorApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(RandomNoGeneratorApplication.class);

	@Autowired
	RandomNumberGenerator randomNumberGenerator;

	@Autowired
	NumberStore numberStore;

	public static void main(final String[] args) {
		SpringApplication.run(RandomNoGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Timer timer = new Timer();
		timer.schedule(randomNumberGenerator, 0, Constants.numberLimit);
	}

}
