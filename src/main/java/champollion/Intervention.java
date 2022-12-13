package champollion;

import java.util.Date;

public class Intervention {

    private Date debut;
    private int duree;
    private boolean annulee = false;
    private Salle s;
    private UE ue;
    private Enseignant e;
    private TypeIntervention typeInte;

    public Intervention(Date debut, int duree, Salle s, UE ue, Enseignant e, TypeIntervention typeInte) {
        this.debut = debut;
        this.duree = duree;
        this.s = s;
        this.ue = ue;
        this.e = e;
        this.typeInte = typeInte;
    }

    public Intervention(Salle s, UE ue, Date debut, int duree, TypeIntervention typeInte, Enseignant e) {

        this.s = s;
        this.ue = ue;
        this.e = e;
        this.debut = debut;
        this.duree = duree;
        this.typeInte = typeInte;
    }

    public Intervention(Date date, int i, int i1, Salle salle, TypeIntervention cm, Enseignant untel, UE uml) {
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public Salle getS() {
        return s;
    }

    public UE getUe() {
        return ue;
    }

    public Enseignant getE() {
        return e;
    }

    public TypeIntervention getTypeInte() {
        return typeInte;
    }
}
