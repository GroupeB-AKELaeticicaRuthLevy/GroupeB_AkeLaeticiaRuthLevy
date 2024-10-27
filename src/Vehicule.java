public  abstract class Vehicule {
    protected static int nombreVehicule=0;
    protected int idVehicule;
    protected String immatriculation;
    protected String marque;
    protected String modele;
    protected String statut;
    protected int anneeDeMiseEnService;
    protected double kilometrage;

    public Vehicule(String immatriculation, String marque,
                    String modele, int anneeDeMiseEnService, double Kilometrage){
        this.anneeDeMiseEnService=anneeDeMiseEnService;
        this.immatriculation=immatriculation;
        this.kilometrage=kilometrage;
        this.modele=modele;
        this.statut=ParcAutomobile.DISPONIBLE;
        this.marque=marque;
        nombreVehicule++;
        idVehicule=nombreVehicule;

    }
    public  abstract double calculerPrixLocation();

    public String toString(){
        return "la marque de la voiture est: "+marque+"\nle modele est: "+modele+"\nle Kilometrage est: "+kilometrage+"\nL'année de mise en service: "+anneeDeMiseEnService+"\nImmatriculation est: "+immatriculation+"\nStatut: "+statut;
    }

    public int getAnneeDeMiseEnService() {
        return anneeDeMiseEnService;
    }

    public void setAnneeDeMiseEnService(int anneeDeMiseEnService) {
        this.anneeDeMiseEnService = anneeDeMiseEnService;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;

    }
}
