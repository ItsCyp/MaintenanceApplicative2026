import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenementPeriodiqueTest {

    @Test
    void un_evenement_periodique_hebdomadaire_a_une_description_formatee() {
        Evenement periodique = new EvenementPeriodique(
                EventId.nouveau(),
                new TitreEvenement("Stand-up"),
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(9, 30)),
                new DureeEvenement(Duration.ofMinutes(15)),
                new Hebdomadaire()
        );

        assertEquals(
                "Événement périodique : Stand-up à partir du 24/04/2026 à 09:30, répétition hebdomadaire",
                periodique.description()
        );
    }
}
