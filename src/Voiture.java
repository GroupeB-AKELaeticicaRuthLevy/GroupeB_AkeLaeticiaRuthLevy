
public  class Voiture extends Vehicule implements Louable {// classe Voiture qui herite de la classe mère Vehicule
    private int nombreDePlace;
    private String typeDeCarburant;//essence,diezel,electrique

    public Voiture(String immatriculation, String marque, String modele,
                   int anneeDeMiseEnService, double Kilometrage,int typeDeCarburant,int nombreDePlace) {
        super(immatriculation, marque, modele, anneeDeMiseEnService, Kilometrage);
        // Recuperer les differentes valeurs de ces attributs dans la classe Vehicule
        setNombreDePlace(nombreDePlace);
        setTypeDeCarburant(typeDeCarburant);
    }

    @Override
    public double calculerPrixLocation() {
        if(nombreDePlace>5){
            return 250000;
        }else if(nombreDePlace==5){
            return 150000;
        }else{
            return 350000;
        }

    }
    public void louer()throws VehiculeIndisponibleExeption {
        if (statut.equals(ParcAutomobile.DISPONIBLE)){
            this.statut = ParcAutomobile.LOUE;
            System.out.println("la voiture est loué maintenant");
        } else {
            throw new VehiculeIndisponibleExeption("deja loué");
        }
    }
    public void retourner () { // Lorsque la voirure est retourner alors elle est enregistrer comme disponible
           this.statut=ParcAutomobile.DISPONIBLE;
        }

    public String toString(){
        return this.idVehicule+"Voiture:{\n"+super.toString()+"\nNombre de place: "+nombreDePlace+"\nType Carburant: "+typeDeCarburant+"\n }";
    }


    public int getNombreDePlace() {
        return nombreDePlace;
    }

    public void setNombreDePlace(int nombreDePlace) {
        if(nombreDePlace>0){
            this.nombreDePlace=nombreDePlace;
        }else {
            this.nombreDePlace=5;
        }
    }

    public String getTypeDeCarburant() {
        return typeDeCarburant;
    }

    public void setTypeDeCarburant(int typeDeCarburant) {
       switch(typeDeCarburant){
           case 1:
               this.typeDeCarburant="Electrique";
           break;
           case 2:
               this.typeDeCarburant="Dieziel";
            break;

           default:
               this.typeDeCarburant="Essence";
               break; // on ne peut que enregistrer ces types de carburants
        }
    }
}