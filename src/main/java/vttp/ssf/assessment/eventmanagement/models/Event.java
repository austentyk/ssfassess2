package vttp.ssf.assessment.eventmanagement.models;


public class Event {
    
    public Integer eventId;
    public String eventName;
    public Integer eventSize;
    public Long eventDate;
    public Integer participants;


    public Event(Integer eventId, String eventName, Integer eventSize, Long eventDate, Integer participants) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventSize = eventSize;
        this.eventDate = eventDate;
        this.participants = participants;
    }
    public void setEventDate(Long eventDate) {
        this.eventDate = eventDate;
    }
    public Integer getEventId() {
        return eventId;
    }
    public String getEventName() {
        return eventName;
    }
    public Integer getEventSize() {
        return eventSize;
    }
    public Long getEventDate() {
        return eventDate;
    }
    public Integer getParticipants() {
        return participants;
    }
    
}
