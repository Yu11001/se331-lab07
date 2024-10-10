package se331.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.Event;
import se331.rest.entity.Organizer;
import se331.rest.entity.Participant;
import se331.rest.repository.EventRepository;
import se331.rest.repository.OrganizerRepository;
import se331.rest.repository.ParticipantRepository;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;

    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("Chiang Mai").build());

        Participant par1, par2, par3, par4, par5;
        par1 = participantRepository.save(Participant.builder().name("Ruth Yu").telNo("101-019-9999").build());
        par2 = participantRepository.save(Participant.builder().name("Hello World").telNo("101-019-8888").build());
        par3 = participantRepository.save(Participant.builder().name("Lucky Doggy").telNo("101-019-7777").build());
        par4 = participantRepository.save(Participant.builder().name("Yamako Hey").telNo("101-019-6666").build());
        par5 = participantRepository.save(Participant.builder().name("Ching Ching").telNo("101-019-5555").build());

        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category ( "Academic")
                .title ("Midterm Exam")
                .description ("A time for taking the exam")
                .location ("CAMT Building")
                .date ("3rd Sept")
                .time ("3.00-4.00 pm.")
                .petAllowed (false)
                .build());
        tempEvent.setOrganizer(org1);
        tempEvent.setParticipants(Arrays.asList(par1, par2, par3));
        org1.getOwnEvents().add(tempEvent);
        par1.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category ( "Academic")
                .title ("Commencement Day")
                .description ("A time for celebration")
                .location ("CMU Convention hall")
                .date ("21st Jan")
                .time ("8.00am-4.00 pm.")
                .petAllowed (false)
                .build());
        tempEvent.setOrganizer (org1);
        tempEvent.setParticipants(Arrays.asList(par1, par3, par5));
        org1.getOwnEvents().add(tempEvent);
        par1.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        par5.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category ("Cultural")
                .title ("Loy Krathong")
                .description ("A time for Krathong")
                .location ("Ping River")
                .date ("21th Nov")
                .time ("8.00-10.00 pm.")
                .petAllowed (false)
                .build ());
        tempEvent.setOrganizer(org2);
        tempEvent.setParticipants(Arrays.asList(par2, par3, par4));
        org2.getOwnEvents().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        par4.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category ( "Cultural")
                .title ("Songkran")
                .description ("Let's Play Water")
                .location ("Chiang Mai Moat")
                .date ("13th April")
                .time ("10.00am - 6.00 pm.")
                .petAllowed (true)
                .build());
        tempEvent.setOrganizer(org3);
        tempEvent.setParticipants(Arrays.asList(par1, par3, par4));
        org3.getOwnEvents().add(tempEvent);
        par1.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        par4.getEventHistory().add(tempEvent);
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}