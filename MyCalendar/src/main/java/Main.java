import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Calendrier calendrier = new Calendrier();

        Evenement rdv = new RendezVousPersonnel(
                EventId.nouveau(),
                new TitreEvenement("Dentiste"),
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(10, 0)),
                new DureeEvenement(Duration.ofMinutes(30))
        );

        Evenement reunion = new Reunion(
                EventId.nouveau(),
                new TitreEvenement("Sprint planning"),
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(14, 0)),
                new DureeEvenement(Duration.ofMinutes(60)),
                new Lieu("Salle Mozart"),
                List.of(new Participant("Pierre"), new Participant("Roger"))
        );

        Evenement standUp = new EvenementPeriodique(
                EventId.nouveau(),
                new TitreEvenement("Stand-up quotidien"),
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(9, 30)),
                new DureeEvenement(Duration.ofMinutes(15)),
                new Hebdomadaire()
        );

        calendrier.ajouter(rdv);
        calendrier.ajouter(reunion);
        calendrier.ajouter(standUp);

        System.out.println("=== Calendrier (" + calendrier.taille() + " événements) ===");
        Periode avril = new Periode(
                new DateEvenement(LocalDate.of(2026, 4, 1)),
                new DateEvenement(LocalDate.of(2026, 4, 30))
        );
        calendrier.evenementsDansPeriode(avril)
                .forEach(e -> System.out.println("  - " + e.description()));

        System.out.println();
        System.out.println("=== Test de conflit ===");
        Evenement chevauchant = new RendezVousPersonnel(
                EventId.nouveau(),
                new TitreEvenement("Café improvisé"),
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(14, 30)),
                new DureeEvenement(Duration.ofMinutes(30))
        );
        System.out.println("Conflit avec la réunion ? " + calendrier.conflit(chevauchant));

        System.out.println();
        System.out.println("=== Suppression du RDV dentiste ===");
        calendrier.supprimer(rdv.id());
        System.out.println("Taille après suppression : " + calendrier.taille());
    }
}
