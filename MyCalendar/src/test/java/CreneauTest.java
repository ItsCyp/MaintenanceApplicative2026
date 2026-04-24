import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreneauTest {

    @Test
    void deux_creneaux_qui_se_chevauchent_sont_detectes() {
        Creneau c1 = new Creneau(
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(10, 0)),
                new DureeEvenement(Duration.ofMinutes(60))
        );
        Creneau c2 = new Creneau(
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(10, 30)),
                new DureeEvenement(Duration.ofMinutes(60))
        );

        assertTrue(c1.chevauche(c2));
    }

    @Test
    void deux_creneaux_sequentiels_ne_se_chevauchent_pas() {
        Creneau c1 = new Creneau(
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(10, 0)),
                new DureeEvenement(Duration.ofMinutes(60))
        );
        Creneau c2 = new Creneau(
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(11, 0)),
                new DureeEvenement(Duration.ofMinutes(60))
        );

        assertFalse(c1.chevauche(c2));
    }

    @Test
    void deux_creneaux_a_des_dates_differentes_ne_se_chevauchent_pas() {
        Creneau c1 = new Creneau(
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(10, 0)),
                new DureeEvenement(Duration.ofMinutes(60))
        );
        Creneau c2 = new Creneau(
                new DateEvenement(LocalDate.of(2026, 4, 25)),
                new HeureDebut(LocalTime.of(10, 0)),
                new DureeEvenement(Duration.ofMinutes(60))
        );

        assertFalse(c1.chevauche(c2));
    }

    @Test
    void un_creneau_entierement_contenu_dans_un_autre_est_detecte() {
        Creneau grand = new Creneau(
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(9, 0)),
                new DureeEvenement(Duration.ofMinutes(180))
        );
        Creneau petit = new Creneau(
                new DateEvenement(LocalDate.of(2026, 4, 24)),
                new HeureDebut(LocalTime.of(10, 0)),
                new DureeEvenement(Duration.ofMinutes(30))
        );

        assertTrue(grand.chevauche(petit));
        assertTrue(petit.chevauche(grand));
    }
}
