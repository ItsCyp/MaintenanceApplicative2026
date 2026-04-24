import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MensuelleTest {

    @Test
    void la_prochaine_apparition_est_un_mois_plus_tard() {
        Frequence freq = new Mensuelle();
        DateEvenement depuis = new DateEvenement(LocalDate.of(2026, 4, 24));

        DateEvenement resultat = freq.prochaineApparition(depuis);

        assertEquals(new DateEvenement(LocalDate.of(2026, 5, 24)), resultat);
    }
}
