import java.util.Optional;

public record Periode(DateEvenement debut, DateEvenement fin) {

    public Periode {
        Optional.of(fin)
                .filter(f -> !f.valeur().isBefore(debut.valeur()))
                .orElseThrow(() -> new IllegalArgumentException("La fin ne peut pas être antérieure au début"));
    }

    public boolean contient(DateEvenement date) {
        return !date.valeur().isBefore(debut.valeur())
                && !date.valeur().isAfter(fin.valeur());
    }
}
