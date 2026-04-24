import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencePolymorphismeTest {

    @Test
    void chaque_frequence_calcule_sa_propre_prochaine_apparition_sans_conditionnel() {
        DateEvenement depuis = new DateEvenement(LocalDate.of(2026, 4, 24));

        List<Frequence> frequences = List.of(new Hebdomadaire(), new Mensuelle(), new Annuelle());
        List<DateEvenement> attendues = List.of(
                new DateEvenement(LocalDate.of(2026, 5, 1)),
                new DateEvenement(LocalDate.of(2026, 5, 24)),
                new DateEvenement(LocalDate.of(2027, 4, 24))
        );

        List<DateEvenement> resultats = frequences.stream()
                .map(f -> f.prochaineApparition(depuis))
                .toList();

        assertEquals(attendues, resultats);
    }
}
