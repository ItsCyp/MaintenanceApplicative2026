import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RendezVousPersonnelTest {

    @Test
    void un_rdv_personnel_a_une_description_formatee() {
        Evenement rdv = new RendezVousPersonnel(
                EventId.nouveau(),
                new TitreEvenement("Dentiste"),
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(14, 30)),
                new DureeEvenement(Duration.ofMinutes(30))
        );

        assertEquals("RDV : Dentiste le 24/04/2026 à 14:30", rdv.description());
    }
}
