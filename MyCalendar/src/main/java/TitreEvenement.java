import java.util.Optional;

public record TitreEvenement(String valeur) {

    public TitreEvenement {
        Optional.ofNullable(valeur)
                .filter(v -> !v.isBlank())
                .orElseThrow(() -> new IllegalArgumentException("Le titre ne peut pas être vide"));
    }
}
