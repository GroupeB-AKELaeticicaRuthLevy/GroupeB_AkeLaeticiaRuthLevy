import java.util.List;
import java.util.ArrayList;
public class ParcAutomobile {
    public static final String DISPONIBLE="disponible";
    public static final String LOUE="loue";
    private Vehicule vehicule;
    private List<Vehicule> vehicules;// la liste vehicules va stockée les attributs de type Vehicule

    public ParcAutomobile(){
        this.vehicules=new ArrayList<>();//étant donné qu'on n'a pas un nombre fixe pour la taille on va utiliser un ArrayList pour
                                                     // stocker un vehicule
    }
    public void ajouterVehicule(Vehicule vehicule){//ajouter un vehicule
        vehicules.add(vehicule);

    }

    public List<Vehicule> getVehiculesDisponibles() {
        List<Vehicule> vehiculedisponible= new ArrayList<>();// pour stockées les vehicules disponibles
        for(Vehicule v:vehicules){ //la boucle for va parcourir tous les elements de type Vehicule  de la liste vehicules
            if(v.getStatut().equals("disponible")){
                vehiculedisponible.add(v);
            }
        }
        return vehiculedisponible;
    }
    public List<Vehicule> getVehiculesLoues(){
        List<Vehicule> vehiculeloues= new ArrayList<>();//pour stocker les vehicules loués
        for(Vehicule v:vehicules){
            if(v.getStatut().equals("loue")){
                vehiculeloues.add(v);
            }
        }
        return vehiculeloues;
    }
}
