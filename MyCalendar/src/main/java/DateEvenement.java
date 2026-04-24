import java.time.LocalDate;
import java.util.Optional;

public record DateEvenement(LocalDate valeur) {

    public DateEvenement {
        Optional.ofNullable(valeur)
                .orElseThrow(() -> new IllegalArgumentException("La date ne peut pas être null"));
    }
}
