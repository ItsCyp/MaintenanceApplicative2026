import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {

    @Test
    void un_participant_valide_conserve_son_nom() {
        Participant p = new Participant("Pierre");

        assertEquals("Pierre", p.nom());
    }

    @Test
    void un_participant_null_est_refuse() {
        assertThrows(IllegalArgumentException.class, () -> new Participant(null));
    }

    @Test
    void un_participant_vide_est_refuse() {
        assertThrows(IllegalArgumentException.class, () -> new Participant(""));
    }

    @Test
    void un_participant_ne_contenant_que_des_espaces_est_refuse() {
        assertThrows(IllegalArgumentException.class, () -> new Participant("   "));
    }

    @Test
    void deux_participants_avec_meme_nom_sont_egaux() {
        Participant p1 = new Participant("Pierre");
        Participant p2 = new Participant("Pierre");

        assertEquals(p1, p2);
    }

    @Test
    void deux_participants_avec_meme_nom_ont_meme_hashcode() {
        Participant p1 = new Participant("Pierre");
        Participant p2 = new Participant("Pierre");

        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void deux_participants_differents_ne_sont_pas_egaux() {
        Participant p1 = new Participant("Pierre");
        Participant p2 = new Participant("Roger");

        assertNotEquals(p1, p2);
    }
}
