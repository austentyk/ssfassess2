package vttp.ssf.assessment.eventmanagement.services;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;





import vttp.ssf.assessment.eventmanagement.models.Event;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    public final String fileName = "/Users/ttq/Desktop/NUS/ssf/ssfassess/vttp2023-batch4-ssf-assessment/events.json";

    public static List<Event> eventList = new ArrayList<>();

    public static List<Event> readFile(String fileName) throws FileNotFoundException{

        FileReader fr = new FileReader(fileName);
        JSONParser parser = new JSONParser();

        try { JSONArray array = (JSONArray) parser.parse(fr);
            for (Object o : array ) {
                JSONObject event = (JSONObject) o;
                Integer jid = (Integer) event.get("eventId");
                String jname = event.get("eventName").toString();
                Integer jsize = (Integer) event.get("eventSize");
                Long jdate = (Long) event.get("eventDate");
                Integer jparticipants = (Integer) event.get("participants");


                eventList.add(new Event(jid,jname,jsize,jdate,jparticipants));

            }



        } catch (Exception e) {

            System.out.println("File not found");

        }
        
    
        
    


        return eventList;
    }




    
}
