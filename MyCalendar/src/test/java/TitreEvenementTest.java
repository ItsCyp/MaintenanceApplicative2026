import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
