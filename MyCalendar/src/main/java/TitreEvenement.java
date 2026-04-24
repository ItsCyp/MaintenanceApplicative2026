import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        return (o instanceof TitreEvenement autre) && valeur.equals(autre.valeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valeur);
    }
}
