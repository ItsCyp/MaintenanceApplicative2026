import java.util.ArrayList;
import java.util.List;

public final class Calendrier {

    private final List<Evenement> evenements = new ArrayList<>();

    public int taille() {
        return evenements.size();
    }

    public void ajouter(Evenement evenement) {
        evenements.add(evenement);
    }

    public List<Evenement> evenementsDansPeriode(Periode periode) {
        return evenements.stream()
                .filter(e -> periode.contient(e.creneau().date()))
                .toList();
    }

    public boolean conflit(Evenement candidat) {
        return evenements.stream()
                .anyMatch(existant -> existant.creneau().chevauche(candidat.creneau()));
    }
}
