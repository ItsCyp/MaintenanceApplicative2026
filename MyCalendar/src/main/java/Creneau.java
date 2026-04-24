import java.time.LocalDateTime;

public record Creneau(DateEvenement date, HeureDebut debut, DureeEvenement duree) {

    public boolean chevauche(Creneau autre) {
        return this.debutInstant().isBefore(autre.finInstant())
                && autre.debutInstant().isBefore(this.finInstant());
    }

    private LocalDateTime debutInstant() {
        return LocalDateTime.of(date.valeur(), debut.valeur());
    }

    private LocalDateTime finInstant() {
        return debutInstant().plus(duree.valeur());
    }
}
