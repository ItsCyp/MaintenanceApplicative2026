import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
}
