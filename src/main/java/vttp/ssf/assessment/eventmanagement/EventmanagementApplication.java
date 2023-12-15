package vttp.ssf.assessment.eventmanagement;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RepoHandler;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements Runnable{

	public static void main(String[] args) throws Exception{
		SpringApplication.run(EventmanagementApplication.class, args);

	

	}

	@Override
	public void run() {
		
		try {
		final List<Event> eventList = DatabaseService.readFile("/Users/ttq/Desktop/NUS/ssf/ssfassess/vttp2023-batch4-ssf-assessment/events.json");


		} catch (Exception e) {}



	}
	
	

}
