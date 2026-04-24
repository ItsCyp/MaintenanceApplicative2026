public final class Hebdomadaire implements Frequence {

    @Override
    public DateEvenement prochaineApparition(DateEvenement depuis) {
        return new DateEvenement(depuis.valeur().plusWeeks(1));
    }
}
