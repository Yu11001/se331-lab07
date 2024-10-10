package se331.rest.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Event;

public interface EventDao {
    Integer getEventSize();
//    List<Event> getEvents (Integer pageSize, Integer page);
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);
    Event save(Event event);
    Page<Event> getEvents(String name, Pageable page);
}