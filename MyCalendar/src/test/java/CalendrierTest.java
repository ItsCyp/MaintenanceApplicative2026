import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;

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

    @Test
    void evenements_dans_periode_ne_retourne_que_les_evenements_de_cette_periode() {
        Calendrier calendrier = new Calendrier();
        Evenement enAvril = rdv("Avril", LocalDate.of(2026, 4, 15), LocalTime.of(10, 0), 30);
        Evenement enMars = rdv("Mars", LocalDate.of(2026, 3, 15), LocalTime.of(10, 0), 30);
        Evenement enMai = rdv("Mai", LocalDate.of(2026, 5, 15), LocalTime.of(10, 0), 30);
        calendrier.ajouter(enAvril);
        calendrier.ajouter(enMars);
        calendrier.ajouter(enMai);

        Periode avril = new Periode(
                new DateEvenement(LocalDate.of(2026, 4, 1)),
                new DateEvenement(LocalDate.of(2026, 4, 30))
        );

        List<Evenement> resultats = calendrier.evenementsDansPeriode(avril);

        assertEquals(List.of(enAvril), resultats);
    }
}
