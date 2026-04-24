import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeureDebutTest {

    @Test
    void une_heure_valide_conserve_sa_valeur() {
        LocalTime attendu = LocalTime.of(14, 30);

        HeureDebut heure = new HeureDebut(attendu);

        assertEquals(attendu, heure.valeur());
    }

    @Test
    void une_heure_null_est_refusee() {
        assertThrows(IllegalArgumentException.class, () -> new HeureDebut(null));
    }

    @Test
    void deux_heures_avec_meme_valeur_sont_egales() {
        HeureDebut heure1 = new HeureDebut(LocalTime.of(14, 30));
        HeureDebut heure2 = new HeureDebut(LocalTime.of(14, 30));

        assertEquals(heure1, heure2);
    }

    @Test
    void deux_heures_avec_meme_valeur_ont_meme_hashcode() {
        HeureDebut heure1 = new HeureDebut(LocalTime.of(14, 30));
        HeureDebut heure2 = new HeureDebut(LocalTime.of(14, 30));

        assertEquals(heure1.hashCode(), heure2.hashCode());
    }

    @Test
    void deux_heures_differentes_ne_sont_pas_egales() {
        HeureDebut heure1 = new HeureDebut(LocalTime.of(14, 30));
        HeureDebut heure2 = new HeureDebut(LocalTime.of(15, 0));

        assertNotEquals(heure1, heure2);
    }
}
