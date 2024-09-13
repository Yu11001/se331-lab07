package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add (Organizer.builder ()
                .OrganizerID(101L)
                .OrganizerName ("Haha")
                .OrganizerAddress ("Chiang Mai, Thailand")
                .OrganizerPhone (100110011001L)
                .OrganizerEmail ("haha101@gmail.com")
                .build());
        organizerList.add (Organizer.builder ()
                .OrganizerID(202L)
                .OrganizerName ("Kuku")
                .OrganizerAddress ("Bangkok, Thailand")
                .OrganizerPhone (200220022002L)
                .OrganizerEmail ("Kuku2022@gmail.com")
                .build());
        organizerList.add (Organizer.builder ()
                .OrganizerID(303L)
                .OrganizerName ("Tres Uno")
                .OrganizerAddress ("Paris, France")
                .OrganizerPhone (300330033003L)
                .OrganizerEmail ("tres303@gmail.com")
                .build());
        organizerList.add (Organizer.builder ()
                .OrganizerID(404L)
                .OrganizerName ("Four Card")
                .OrganizerAddress ("London, England")
                .OrganizerPhone (400440044004L)
                .OrganizerEmail ("four44@gmail.com")
                .build());
        organizerList.add (Organizer.builder ()
                .OrganizerID(505L)
                .OrganizerName ("Five Wu")
                .OrganizerAddress ("Beijing, China")
                .OrganizerPhone (500550055005L)
                .OrganizerEmail ("five505@gmail.com")
                .build());
        organizerList.add (Organizer.builder ()
                .OrganizerID(600L)
                .OrganizerName ("Six Seven")
                .OrganizerAddress ("New York, USA")
                .OrganizerPhone (60000000001L)
                .OrganizerEmail ("SixSeven@gmail.com")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers (Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page-1)*pageSize;
        return organizerList.subList(firstIndex,firstIndex+pageSize);
    }

    @Override
    public Organizer getOrganizer (Long id) {
        return organizerList.stream().filter (organizer -> organizer.getOrganizerID().equals(id)).findFirst().orElse(null);
    }
}
