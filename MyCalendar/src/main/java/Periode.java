public record Periode(DateEvenement debut, DateEvenement fin) {

    public boolean contient(DateEvenement date) {
        return !date.valeur().isBefore(debut.valeur())
                && !date.valeur().isAfter(fin.valeur());
    }
}
