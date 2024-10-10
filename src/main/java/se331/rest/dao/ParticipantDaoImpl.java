package se331.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Participant;
import se331.rest.repository.ParticipantRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ParticipantDaoImpl implements ParticipantDao {
    final ParticipantRepository participantRepository;

    @Override
    public Page<Participant> getParticipants(Pageable pageRequest) {
        return participantRepository.findAll(pageRequest);
    }
}
