import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TitreEvenementTest {

    @Test
    void un_titre_valide_conserve_sa_valeur() {
        TitreEvenement titre = new TitreEvenement("Réunion équipe");

        assertEquals("Réunion équipe", titre.valeur());
    }

    @Test
    void un_titre_vide_est_refuse() {
        assertThrows(IllegalArgumentException.class, () -> new TitreEvenement(""));
    }

    @Test
    void un_titre_null_est_refuse() {
        assertThrows(IllegalArgumentException.class, () -> new TitreEvenement(null));
    }

    @Test
    void un_titre_ne_contenant_que_des_espaces_est_refuse() {
        assertThrows(IllegalArgumentException.class, () -> new TitreEvenement("   "));
    }

    @Test
    void deux_titres_avec_meme_valeur_sont_egaux() {
        TitreEvenement titre1 = new TitreEvenement("Réunion équipe");
        TitreEvenement titre2 = new TitreEvenement("Réunion équipe");

        assertEquals(titre1, titre2);
    }

    @Test
    void deux_titres_avec_meme_valeur_ont_meme_hashcode() {
        TitreEvenement titre1 = new TitreEvenement("Réunion équipe");
        TitreEvenement titre2 = new TitreEvenement("Réunion équipe");

        assertEquals(titre1.hashCode(), titre2.hashCode());
    }

    @Test
    void deux_titres_avec_valeurs_differentes_ne_sont_pas_egaux() {
        TitreEvenement titre1 = new TitreEvenement("Réunion équipe");
        TitreEvenement titre2 = new TitreEvenement("Déjeuner");

        assertNotEquals(titre1, titre2);
    }
}
