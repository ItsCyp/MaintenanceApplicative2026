import java.util.ArrayList;
import java.util.List;

public final class Calendrier {

    private final List<Evenement> evenements = new ArrayList<>();

    public int taille() {
        return evenements.size();
    }
}
