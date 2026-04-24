import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TitreEvenementTest {

    @Test
    void un_titre_valide_conserve_sa_valeur() {
        TitreEvenement titre = new TitreEvenement("Réunion équipe");

        assertEquals("Réunion équipe", titre.valeur());
    }
}
