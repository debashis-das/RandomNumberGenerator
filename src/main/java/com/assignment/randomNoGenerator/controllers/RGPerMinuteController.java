package com.assignment.randomNoGenerator.controllers;

import com.assignment.randomNoGenerator.NumberStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a Random Generator per Inteval Controller
 */
@RestController
public class RGPerMinuteController {

	Logger logger = LoggerFactory.getLogger(RGPerMinuteController.class);

	@Autowired
	NumberStore numberStore;

    @RequestMapping("/randomNumber/{id}")
	public int[][] getPerMinute(@PathVariable(value = "id") int intervalInMin) {	
		return numberStore.sendValues(intervalInMin);
	}

}