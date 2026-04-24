import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DureeEvenementTest {

    @Test
    void une_duree_valide_conserve_sa_valeur() {
        Duration attendu = Duration.ofMinutes(60);

        DureeEvenement duree = new DureeEvenement(attendu);

        assertEquals(attendu, duree.valeur());
    }

    @Test
    void une_duree_null_est_refusee() {
        assertThrows(IllegalArgumentException.class, () -> new DureeEvenement(null));
    }

    @Test
    void deux_durees_avec_meme_valeur_sont_egales() {
        DureeEvenement duree1 = new DureeEvenement(Duration.ofMinutes(60));
        DureeEvenement duree2 = new DureeEvenement(Duration.ofMinutes(60));

        assertEquals(duree1, duree2);
    }

    @Test
    void deux_durees_avec_meme_valeur_ont_meme_hashcode() {
        DureeEvenement duree1 = new DureeEvenement(Duration.ofMinutes(60));
        DureeEvenement duree2 = new DureeEvenement(Duration.ofMinutes(60));

        assertEquals(duree1.hashCode(), duree2.hashCode());
    }

    @Test
    void deux_durees_differentes_ne_sont_pas_egales() {
        DureeEvenement duree1 = new DureeEvenement(Duration.ofMinutes(60));
        DureeEvenement duree2 = new DureeEvenement(Duration.ofMinutes(90));

        assertNotEquals(duree1, duree2);
    }

    @Test
    void une_duree_negative_est_refusee() {
        assertThrows(IllegalArgumentException.class, () -> new DureeEvenement(Duration.ofMinutes(-15)));
    }

    @Test
    void une_duree_nulle_est_refusee() {
        assertThrows(IllegalArgumentException.class, () -> new DureeEvenement(Duration.ZERO));
    }
}
