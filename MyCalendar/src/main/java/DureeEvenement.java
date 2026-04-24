import java.time.Duration;
import java.util.Optional;

public record DureeEvenement(Duration valeur) {

    public DureeEvenement {
        Optional.ofNullable(valeur)
                .orElseThrow(() -> new IllegalArgumentException("La durée ne peut pas être null"));
    }
}
