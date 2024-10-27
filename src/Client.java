import java.util.ArrayList;
public class Client {
    private static int nombreClients=0;
    private final int idClient;
    private final String nom;
    private final String prenom;
    private String numeroDePermis;
    private final String numeroDeTelephone;
    private ArrayList<Vehicule> locationsClient=new ArrayList<>();
    private static ArrayList<Client> listeClients = new ArrayList<>();

    public Client(String nom,String prenom, int numeroDePermis,String numeroDeTelephone){
       this.nom=nom;
       setNumeroDePermis(numeroDePermis);
       this.prenom=prenom;
       this.numeroDeTelephone=numeroDeTelephone;
       this.locationsClient = new ArrayList<>();
       nombreClients++;
       idClient=nombreClients;
       listeClients.add(this);
   }
    public void louerVehicule(Vehicule vehicule) throws ClientNonAutoriseExeption {
        if(vehicule instanceof Camion camion){
            if(this.numeroDePermis.equals("B")){
                throw new ClientNonAutoriseExeption("Vous n'êtes pas autorisé à louer ce véhicule");
            }else{
                try{
                    camion.louer();
                    this.locationsClient.add(camion);
                    System.out.println("\nVéhicule loué avec succès...");
                    System.out.println("Le prix de location est de : "+ camion.calculerPrixLocation());
                }catch(VehiculeIndisponibleExeption e){
                    System.out.println("\n"+e.getMessage());
                }
            }
        } else if (vehicule instanceof Voiture voiture) {
            try{
                voiture.louer();
                this.locationsClient.add(voiture);
                System.out.println("\nVéhicule loué avec succès...");
                System.out.println("Le prix de location est de : "+ voiture.calculerPrixLocation());
            }catch(VehiculeIndisponibleExeption e){
                System.out.println("\n"+e.getMessage());
         }
    }

    }

    public void retourClient(Vehicule vehicule){
        locationsClient.remove(vehicule);
    }
    public String toString() {
        return this.idClient + " - {\n" +
                "\nNom: " + nom +
                "\nPrenoms: " + prenom +
                "\nPermis de conduire: " + numeroDePermis +
                "\nNumero de telephone: " + numeroDeTelephone + " }";
    }


    //Getters

    public static ArrayList<Client> getListeClients() {
        return listeClients;
    }

    public ArrayList<Vehicule> getLocationsClient() {
        return locationsClient;
    }

    public String getNom() {
        return nom;
    }

    public String getNumeroDePermis() {
        return numeroDePermis;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public String getPrenom() {
        return prenom;
    }

    //Setters

    public void setNumeroDePermis(int numeroDePermis) {
    switch (numeroDePermis){
        case 1:
            this.numeroDePermis="C";
            break;
        case 2:
            this.numeroDePermis="BC";
            break;
        default:
            this.numeroDePermis="B";
    }
    }
}
