package se331.rest.dao;


import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add (Organizer.builder ()
                .id(123L)
                .category ("animal welfare")
                .title ("Cat Adoption Day")
                .description ("Find your new feline friend at this event.")
                .location ("Meow Town")
                .date ("January 28, 2022")
                .time ("12:00")
                .petAllowed (true)
                .organizer ("Kat Laydee")
                .build());
        organizerList.add (Organizer.builder ()
                .id(333L)
                .category ("welfare")
                .title ("C Adoption Day")
                .description ("Ffriend at this event.")
                .location ("Meow Town")
                .date ("January 28, 2022")
                .time ("12:00")
                .petAllowed (true)
                .organizer ("Kat Laydee")
                .build());
        organizerList.add (Organizer.builder ()
                .id(444L)
                .category ("animal")
                .title ("Cat Adoption")
                .description ("Find your new feline friend at this event.")
                .location ("Meow Town")
                .date ("January 28, 2022")
                .time ("12:00")
                .petAllowed (true)
                .organizer ("Kat Laydee")
                .build());
        organizerList.add (Organizer.builder ()
                .id(555L)
                .category ("animal welfare")
                .title ("Cat Adoption Day")
                .description ("Find your new feline friend at this event.")
                .location ("Meow Town")
                .date ("January 28, 2022")
                .time ("12:00")
                .petAllowed (true)
                .organizer ("Kat Laydee")
                .build());
        organizerList.add (Organizer.builder ()
                .id(990L)
                .category ("animal welfare")
                .title ("Cat Adoption Day")
                .description ("Find your new feline friend at this event.")
                .location ("Meow Town")
                .date ("January 28, 2022")
                .time ("12:00")
                .petAllowed (true)
                .organizer ("Kat Laydee")
                .build());

    }

    @Override
    public Integer getOrganizerSize () {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers (Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page-1)*pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex+pageSize), PageRequest.of(page,pageSize),organizerList.size());
    }

    @Override
    public Organizer getOrganizer (Long id) {
        return organizerList.stream().filter (organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }
}
