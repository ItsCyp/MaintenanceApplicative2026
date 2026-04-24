import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnnuelleTest {

    @Test
    void la_prochaine_apparition_est_un_an_plus_tard() {
        Frequence freq = new Annuelle();
        DateEvenement depuis = new DateEvenement(LocalDate.of(2026, 4, 24));

        DateEvenement resultat = freq.prochaineApparition(depuis);

        assertEquals(new DateEvenement(LocalDate.of(2027, 4, 24)), resultat);
    }
}
