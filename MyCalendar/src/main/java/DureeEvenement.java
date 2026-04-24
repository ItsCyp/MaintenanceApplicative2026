import java.time.Duration;
import java.util.Optional;

public record DureeEvenement(Duration valeur) {

    public DureeEvenement {
        Optional.ofNullable(valeur)
                .filter(d -> d.compareTo(Duration.ZERO) > 0)
                .orElseThrow(() -> new IllegalArgumentException("La durée doit être strictement positive"));
    }
}
