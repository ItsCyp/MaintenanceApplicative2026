import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeriodeTest {

    @Test
    void une_date_a_linterieur_est_contenue() {
        Periode p = new Periode(
                new DateEvenement(LocalDate.of(2026, 4, 1)),
                new DateEvenement(LocalDate.of(2026, 4, 30))
        );

        assertTrue(p.contient(new DateEvenement(LocalDate.of(2026, 4, 15))));
    }

    @Test
    void une_date_avant_le_debut_nest_pas_contenue() {
        Periode p = new Periode(
                new DateEvenement(LocalDate.of(2026, 4, 1)),
                new DateEvenement(LocalDate.of(2026, 4, 30))
        );

        assertFalse(p.contient(new DateEvenement(LocalDate.of(2026, 3, 31))));
    }

    @Test
    void une_date_apres_la_fin_nest_pas_contenue() {
        Periode p = new Periode(
                new DateEvenement(LocalDate.of(2026, 4, 1)),
                new DateEvenement(LocalDate.of(2026, 4, 30))
        );

        assertFalse(p.contient(new DateEvenement(LocalDate.of(2026, 5, 1))));
    }

    @Test
    void les_bornes_sont_incluses() {
        Periode p = new Periode(
                new DateEvenement(LocalDate.of(2026, 4, 1)),
                new DateEvenement(LocalDate.of(2026, 4, 30))
        );

        assertTrue(p.contient(new DateEvenement(LocalDate.of(2026, 4, 1))));
        assertTrue(p.contient(new DateEvenement(LocalDate.of(2026, 4, 30))));
    }

    @Test
    void une_periode_avec_fin_avant_debut_est_refusee() {
        DateEvenement debut = new DateEvenement(LocalDate.of(2026, 4, 30));
        DateEvenement fin = new DateEvenement(LocalDate.of(2026, 4, 1));

        assertThrows(IllegalArgumentException.class, () -> new Periode(debut, fin));
    }
}
