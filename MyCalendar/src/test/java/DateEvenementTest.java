import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateEvenementTest {

    @Test
    void une_date_valide_conserve_sa_valeur() {
        LocalDate attendu = LocalDate.of(2026, 4, 24);

        DateEvenement date = new DateEvenement(attendu);

        assertEquals(attendu, date.valeur());
    }

    @Test
    void une_date_null_est_refusee() {
        assertThrows(IllegalArgumentException.class, () -> new DateEvenement(null));
    }

    @Test
    void deux_dates_avec_meme_valeur_sont_egales() {
        DateEvenement date1 = new DateEvenement(LocalDate.of(2026, 4, 24));
        DateEvenement date2 = new DateEvenement(LocalDate.of(2026, 4, 24));

        assertEquals(date1, date2);
    }

    @Test
    void deux_dates_avec_meme_valeur_ont_meme_hashcode() {
        DateEvenement date1 = new DateEvenement(LocalDate.of(2026, 4, 24));
        DateEvenement date2 = new DateEvenement(LocalDate.of(2026, 4, 24));

        assertEquals(date1.hashCode(), date2.hashCode());
    }

    @Test
    void deux_dates_differentes_ne_sont_pas_egales() {
        DateEvenement date1 = new DateEvenement(LocalDate.of(2026, 4, 24));
        DateEvenement date2 = new DateEvenement(LocalDate.of(2026, 4, 25));

        assertNotEquals(date1, date2);
    }
}
