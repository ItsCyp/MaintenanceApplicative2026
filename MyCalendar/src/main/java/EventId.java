import java.util.Optional;
import java.util.UUID;

public record EventId(UUID valeur) {

    public EventId {
        Optional.ofNullable(valeur)
                .orElseThrow(() -> new IllegalArgumentException("L'identifiant ne peut pas être null"));
    }

    public static EventId nouveau() {
        return new EventId(UUID.randomUUID());
    }
}
