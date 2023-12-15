package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import jakarta.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Repository
public class RepoHandler implements RedisRepository{

    @Autowired
    private RedisTemplate<String, Event> redisTemplate;

    private static final String key = "EVENT";

    List<Event> eventList = DatabaseService.eventList;

    @Override
    public boolean saveRecord(Event event) {
       for (Event e : eventList) try {
            redisTemplate.opsForHash().put(key, e.getEventId().toString(), e);
            return true;
        } catch (Exception ex) {
    
                return false;
        }
        return true;
    }

    @Override
    public String getNumberOfEvents() {
            Long eventsize = redisTemplate.opsForList().size(key);
            return eventsize.toString();


        
        
    }

    @Override
    public Event getEvent(Integer index) {
       return redisTemplate.opsForList().index("EVENT", index);
        
    }

    @Override
    public int addParticipant(Integer index) {
        redisTemplate.opsForHash().increment("EVENT", "participants", 1);
        return 1;
    }
    
}
