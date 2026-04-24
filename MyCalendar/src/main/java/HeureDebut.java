import java.time.LocalTime;
import java.util.Optional;

public record HeureDebut(LocalTime valeur) {

    public HeureDebut {
        Optional.ofNullable(valeur)
                .orElseThrow(() -> new IllegalArgumentException("L'heure de début ne peut pas être null"));
    }
}
