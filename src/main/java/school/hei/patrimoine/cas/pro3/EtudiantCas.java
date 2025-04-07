package school.hei.patrimoine.cas.pro3;

import school.hei.patrimoine.cas.Cas;
import school.hei.patrimoine.modele.Argent;
import school.hei.patrimoine.modele.Devise;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.Compte;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Possession;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import static java.util.Calendar.APRIL;
import static school.hei.patrimoine.modele.Argent.euro;
import static school.hei.patrimoine.modele.Devise.MGA;

public class EtudiantCas extends Cas {
    public EtudiantCas(LocalDate ajd, LocalDate finSimulation, Map<Personne, Double> possesseurs) {
        super(ajd, finSimulation, possesseurs);
    }

    @Override
    protected Devise devise() {
        return MGA;
    }

    @Override
    protected String nom() {
        return "Cas etudiant PRO3";
    }

    @Override
    protected void init() {

    }

    @Override
    protected void suivi() {

    }

    @Override
    public Set<Possession> possessions() {
        var bmoi= new Compte("BMOI", LocalDate.of(2025, APRIL, 4), new Argent(0, MGA));

        var DebutEpargne= LocalDate.of(2025, APRIL, 30);
        new FluxArgent("Epargne mensuel", bmoi, DebutEpargne, DebutEpargne.plusYears(1), 26, euro(500));

        return Set.of(bmoi);
    }
}
