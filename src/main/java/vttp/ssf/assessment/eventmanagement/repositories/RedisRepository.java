package vttp.ssf.assessment.eventmanagement.repositories;


import vttp.ssf.assessment.eventmanagement.models.Event;


public interface RedisRepository {

	boolean saveRecord(Event event);

	String getNumberOfEvents();

	Event getEvent(Integer index);

	int addParticipant(Integer index);
	
}
