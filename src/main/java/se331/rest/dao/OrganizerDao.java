package se331.rest.dao;

import org.springframework.data.domain.Page;
import se331.rest.entity.Organizer;

public interface OrganizerDao {
    Integer getOrganizerSize () ;
//    List<Event> getEvents (Integer pageSize, Integer page);
    Page<Organizer> getOrganizers (Integer pageSize, Integer page);
    Organizer getOrganizer (Long id) ;
    Organizer save(Organizer organizer) ;
}