public final class Annuelle implements Frequence {

    @Override
    public DateEvenement prochaineApparition(DateEvenement depuis) {
        return new DateEvenement(depuis.valeur().plusYears(1));
    }
}
