package se331.lab.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Organizer {
    Long OrganizerID;
    String OrganizerName;
    String OrganizerAddress;
    Long OrganizerPhone;
    String OrganizerEmail;
}
