import java.util.Optional;

public record Lieu(String valeur) {

    public Lieu {
        Optional.ofNullable(valeur)
                .orElseThrow(() -> new IllegalArgumentException("Le lieu ne peut pas être null"));
    }
}
