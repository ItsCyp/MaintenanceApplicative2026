import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReunionTest {

    @Test
    void une_reunion_a_une_description_avec_lieu_et_participants() {
        Evenement reunion = new Reunion(
                EventId.nouveau(),
                new TitreEvenement("Sprint planning"),
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(9, 0)),
                new DureeEvenement(Duration.ofMinutes(60)),
                new Lieu("Salle Mozart"),
                List.of(new Participant("Pierre"), new Participant("Roger"))
        );

        assertEquals(
                "Réunion : Sprint planning le 24/04/2026 à 09:00, Salle Mozart avec Pierre, Roger",
                reunion.description()
        );
    }
}
