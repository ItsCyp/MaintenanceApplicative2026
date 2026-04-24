import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HebdomadaireTest {

    @Test
    void la_prochaine_apparition_est_7_jours_plus_tard() {
        Frequence freq = new Hebdomadaire();
        DateEvenement depuis = new DateEvenement(LocalDate.of(2026, 4, 24));

        DateEvenement resultat = freq.prochaineApparition(depuis);

        assertEquals(new DateEvenement(LocalDate.of(2026, 5, 1)), resultat);
    }
}
