import java.util.Optional;

public final class TitreEvenement {

    private final String valeur;

    public TitreEvenement(String valeur) {
        this.valeur = Optional.ofNullable(valeur)
                .filter(v -> !v.isBlank())
                .orElseThrow(() -> new IllegalArgumentException("Le titre ne peut pas être vide"));
    }

    public String valeur() {
        return valeur;
    }
}
