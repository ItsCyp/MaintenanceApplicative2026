public final class Mensuelle implements Frequence {

    @Override
    public DateEvenement prochaineApparition(DateEvenement depuis) {
        return new DateEvenement(depuis.valeur().plusMonths(1));
    }

    @Override
    public String description() {
        return "mensuelle";
    }
}
