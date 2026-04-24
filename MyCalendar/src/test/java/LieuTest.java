import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LieuTest {

    @Test
    void un_lieu_valide_conserve_sa_valeur() {
        Lieu lieu = new Lieu("Salle Mozart");

        assertEquals("Salle Mozart", lieu.valeur());
    }

    @Test
    void un_lieu_vide_est_accepte() {
        Lieu lieu = new Lieu("");

        assertEquals("", lieu.valeur());
    }

    @Test
    void un_lieu_null_est_refuse() {
        assertThrows(IllegalArgumentException.class, () -> new Lieu(null));
    }

    @Test
    void deux_lieux_avec_meme_valeur_sont_egaux() {
        Lieu lieu1 = new Lieu("Salle Mozart");
        Lieu lieu2 = new Lieu("Salle Mozart");

        assertEquals(lieu1, lieu2);
    }

    @Test
    void deux_lieux_avec_meme_valeur_ont_meme_hashcode() {
        Lieu lieu1 = new Lieu("Salle Mozart");
        Lieu lieu2 = new Lieu("Salle Mozart");

        assertEquals(lieu1.hashCode(), lieu2.hashCode());
    }

    @Test
    void deux_lieux_differents_ne_sont_pas_egaux() {
        Lieu lieu1 = new Lieu("Salle Mozart");
        Lieu lieu2 = new Lieu("Salle Beethoven");

        assertNotEquals(lieu1, lieu2);
    }
}
