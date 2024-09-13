package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab.dao.OrganizerDao;
import se331.lab.entity.Organizer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {
    final OrganizerDao OrganizerDao;

        @Override
        public Integer getOrganizerSize() {
            return OrganizerDao.getOrganizerSize();
        }

        @Override
        public List<Organizer> getOrganizers (Integer pageSize, Integer page) {
            return OrganizerDao.getOrganizers(pageSize, page);
        }

        @Override
        public Organizer getOrganizer (Long id) {
            return OrganizerDao.getOrganizer(id);
        }
}
