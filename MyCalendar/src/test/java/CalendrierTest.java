import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalendrierTest {

    private Evenement rdv(String titre, LocalDate date, LocalTime heure, int dureeMinutes) {
        return new RendezVousPersonnel(
                EventId.nouveau(),
                new TitreEvenement(titre),
                new DateEvenement(date),
                new HeureDebut(heure),
                new DureeEvenement(Duration.ofMinutes(dureeMinutes))
        );
    }

    @Test
    void un_calendrier_neuf_est_vide() {
        Calendrier calendrier = new Calendrier();

        assertEquals(0, calendrier.taille());
    }

    @Test
    void ajouter_un_evenement_incremente_la_taille() {
        Calendrier calendrier = new Calendrier();

        calendrier.ajouter(rdv("Dentiste", LocalDate.of(2026, 4, 24), LocalTime.of(10, 0), 30));

        assertEquals(1, calendrier.taille());
    }
}
