package champollion;
import java.lang.reflect.Array;
import java.util.*;

public class Enseignant extends Personne {

private ArrayList<ServicePrevu> lesServices = new ArrayList<>();
private LinkedList<Intervention> lesInte = new LinkedList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        //throw new UnsupportedOperationException("Pas encore implémenté");
        int equivalentTD = 0;
        for (ServicePrevu sp : lesServices){
            equivalentTD += 1.5*sp.getVolumeCM();
            equivalentTD += sp.getVolumeTD();
            equivalentTD += 0.75*sp.getVolumeTP();
        }

        return Math.round(equivalentTD);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        //throw new UnsupportedOperationException("Pas encore implémenté");
        int equivalentTD = 0;
        for (ServicePrevu spUe : lesServices){
            equivalentTD += 1.5*spUe.getVolumeCM();
            equivalentTD += spUe.getVolumeTD();
            equivalentTD += 0.75*spUe.getVolumeTP();
        }

        return Math.round(equivalentTD);

    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        //throw new UnsupportedOperationException("Pas encore implémenté");
        ServicePrevu sp = new ServicePrevu(volumeCM, volumeTD, volumeTP, this, ue);
        lesServices.add(sp);
    }

    public void ajouteIntervention(Salle s, UE ue, Enseignant e, TypeIntervention typeInte, Date debut, int duree){
        Intervention inte = new Intervention(s, ue, debut, duree, typeInte, this);
        lesInte.add(inte);
    }

    public boolean enSousService(){
       if (heuresPrevues()<192){
           return true;
       }
       else{
           return false;
       }
    }

    public int resteAPlanifier(UE ue, TypeIntervention typeInte){
        int heurePlan = 0;
        int heureUe = 0;
        for(ServicePrevu sp : lesServices){
            switch(typeInte){
                case CM:
                    heureUe += sp.getVolumeCM();
                    break;
                case TD:
                    heureUe += sp.getVolumeTD();
                    break;
                case TP:
                    heureUe += sp.getVolumeTP();
                    break;
            }
        }
        for (Intervention i : lesInte){
            if(i.getUe().equals(ue) && i.getTypeInte() == typeInte){
                heurePlan += i.getDuree();
            }
        }
        return heureUe - heurePlan;
    }

}
