import java.util.Optional;

public record Participant(String nom) {

    public Participant {
        Optional.ofNullable(nom)
                .filter(n -> !n.isBlank())
                .orElseThrow(() -> new IllegalArgumentException("Le nom du participant ne peut pas être vide"));
    }
}
