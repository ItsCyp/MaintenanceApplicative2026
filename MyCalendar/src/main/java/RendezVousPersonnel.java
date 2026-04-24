import java.time.format.DateTimeFormatter;

public record RendezVousPersonnel(
        EventId id,
        TitreEvenement titre,
        DateEvenement date,
        HeureDebut heure,
        DureeEvenement duree
) implements Evenement {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter HEURE_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String description() {
        return "RDV : " + titre.valeur()
                + " le " + date.valeur().format(DATE_FORMAT)
                + " à " + heure.valeur().format(HEURE_FORMAT);
    }
}
