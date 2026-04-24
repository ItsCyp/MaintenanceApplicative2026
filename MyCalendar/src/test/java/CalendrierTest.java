import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalendrierTest {

    @Test
    void un_calendrier_neuf_est_vide() {
        Calendrier calendrier = new Calendrier();

        assertEquals(0, calendrier.taille());
    }
}
