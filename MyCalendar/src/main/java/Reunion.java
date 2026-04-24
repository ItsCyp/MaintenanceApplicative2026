import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public record Reunion(
        EventId id,
        TitreEvenement titre,
        DateEvenement date,
        HeureDebut heure,
        DureeEvenement duree,
        Lieu lieu,
        List<Participant> participants
) implements Evenement {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter HEURE_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String description() {
        String listeParticipants = participants.stream()
                .map(Participant::nom)
                .collect(Collectors.joining(", "));

        return "Réunion : " + titre.valeur()
                + " le " + date.valeur().format(DATE_FORMAT)
                + " à " + heure.valeur().format(HEURE_FORMAT)
                + ", " + lieu.valeur()
                + " avec " + listeParticipants;
    }
}
