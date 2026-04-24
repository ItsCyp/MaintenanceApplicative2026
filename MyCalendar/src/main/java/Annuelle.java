public final class Annuelle implements Frequence {

    @Override
    public DateEvenement prochaineApparition(DateEvenement depuis) {
        return new DateEvenement(depuis.valeur().plusYears(1));
    }

    @Override
    public String description() {
        return "annuelle";
    }
}
