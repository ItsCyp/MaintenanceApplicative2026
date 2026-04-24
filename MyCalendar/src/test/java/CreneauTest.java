import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

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
}
