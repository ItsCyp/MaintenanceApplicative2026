import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EventIdTest {

    @Test
    void un_event_id_valide_conserve_sa_valeur() {
        UUID attendu = UUID.randomUUID();

        EventId id = new EventId(attendu);

        assertEquals(attendu, id.valeur());
    }

    @Test
    void un_event_id_null_est_refuse() {
        assertThrows(IllegalArgumentException.class, () -> new EventId(null));
    }

    @Test
    void deux_event_ids_avec_meme_valeur_sont_egaux() {
        UUID memeUuid = UUID.randomUUID();
        EventId id1 = new EventId(memeUuid);
        EventId id2 = new EventId(memeUuid);

        assertEquals(id1, id2);
    }

    @Test
    void deux_event_ids_avec_meme_valeur_ont_meme_hashcode() {
        UUID memeUuid = UUID.randomUUID();
        EventId id1 = new EventId(memeUuid);
        EventId id2 = new EventId(memeUuid);

        assertEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void deux_event_ids_differents_ne_sont_pas_egaux() {
        EventId id1 = new EventId(UUID.randomUUID());
        EventId id2 = new EventId(UUID.randomUUID());

        assertNotEquals(id1, id2);
    }
}
