package com.assignment.randomNoGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.stream.Collectors;

import com.assignment.randomNoGenerator.NumberStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

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
		timer.schedule(randomNumberGenerator, 0, 1000);
	}

}
