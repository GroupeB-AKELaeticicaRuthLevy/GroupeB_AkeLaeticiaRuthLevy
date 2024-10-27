public class Camion extends Vehicule implements Louable{
    private double capaciteDeChargement;
    private  int nombreEssieux;

    public Camion(String immatriculation, String marque, String modele,
                  int anneeDeMiseEnService, double Kilometrage,double capaciteDeChargement,int nombreEssieux) {
        super(immatriculation, marque, modele, anneeDeMiseEnService, Kilometrage);
        setCapaciteDeChargement(capaciteDeChargement);
        setNombreEssieux(nombreEssieux);
    }
    @Override
    public double calculerPrixLocation() {
        if(capaciteDeChargement>5){
            return 125000;
        }else{
            return 100000;
        }
       }
    public void louer() throws VehiculeIndisponibleExeption {
        if (statut.equals(ParcAutomobile.DISPONIBLE)){
            this.statut =ParcAutomobile.LOUE;
            System.out.println("le camion est loué");
        } else {
           throw new VehiculeIndisponibleExeption("Desolé le camion est déja loué");
        }
    }
    public void retourner () {
        this.statut=ParcAutomobile.DISPONIBLE;
    }
    public String toString(){
        return this.idVehicule+"Camion:{\n"+super.toString()+"\nLe nombre Essieux est: "+nombreEssieux+"\n Capacite de chargement: "+capaciteDeChargement+"}";
    }

    public double getCapaciteDeChargement() {
        return capaciteDeChargement;
    }

    public void setCapaciteDeChargement(double capaciteDeChargement) {
        if(capaciteDeChargement>0){
            this.capaciteDeChargement=capaciteDeChargement;
        }else{
            this.capaciteDeChargement=0;
        }
    }

    public int getNombreEssieux() {
        return nombreEssieux;
    }

    public void setNombreEssieux(int nombreEssieux) {
        if(nombreEssieux>0){
        this.nombreEssieux = nombreEssieux;
    }else{
            this.nombreEssieux=0;
        }
}}
