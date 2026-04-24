import java.time.Duration;
import java.util.Optional;

public record DureeEvenement(Duration valeur) {

    public DureeEvenement {
        Optional.ofNullable(valeur)
                .filter(d -> !d.isNegative())
                .orElseThrow(() -> new IllegalArgumentException("La durée ne peut pas être null ni négative"));
    }
}
