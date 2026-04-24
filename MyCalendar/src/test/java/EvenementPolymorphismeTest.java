import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenementPolymorphismeTest {

    @Test
    void chaque_type_devenement_produit_sa_propre_description_sans_conditionnel() {
        DateEvenement date = new DateEvenement(LocalDate.of(2026, 4, 24));
        HeureDebut heure = new HeureDebut(LocalTime.of(10, 0));
        DureeEvenement duree = new DureeEvenement(Duration.ofMinutes(30));

        List<Evenement> evenements = List.of(
                new RendezVousPersonnel(EventId.nouveau(), new TitreEvenement("Dentiste"), date, heure, duree),
                new Reunion(EventId.nouveau(), new TitreEvenement("Sprint"), date, heure, duree,
                        new Lieu("Mozart"), List.of(new Participant("Pierre"))),
                new EvenementPeriodique(EventId.nouveau(), new TitreEvenement("Stand-up"), date, heure, duree,
                        new Mensuelle())
        );

        List<String> descriptions = evenements.stream()
                .map(Evenement::description)
                .toList();

        assertEquals("RDV : Dentiste le 24/04/2026 à 10:00", descriptions.get(0));
        assertEquals("Réunion : Sprint le 24/04/2026 à 10:00, Mozart avec Pierre", descriptions.get(1));
        assertEquals("Événement périodique : Stand-up à partir du 24/04/2026 à 10:00, répétition mensuelle",
                descriptions.get(2));
    }
}
