import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MenuInterface {
    public static final String DISPONIBLE="disponible";
    public static final String LOUE="loue";
    private static List<Vehicule> vehicules = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int choix;
        boolean continuer=true;

        do {
            System.out.println("Menu");
            System.out.println("1.Ajouter un nouveau vehicule");
            System.out.println("2.Ajouter un nouveau client");
            System.out.println("3.Afficher la liste des clients ");
            System.out.println("4.Louer un Vehicule");
            System.out.println("5.Afficher la liste des vehicules");
            System.out.println("6.Retourner un véhicule");
            System.out.println("7.Afficher la liste des vehicules disponibles");
            System.out.println("8.Afficher la liste des vehicules loués");
            System.out.println("9.Quitter");
            System.out.println("Veuillez faire votre choix");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterNouveauVehicule();
                    break;

                case 2:
                    ajouterNouveauClient();
                    break;
                case 3 :
                    afficherClient();
                    break;
                case 4:
                    louerVehicule();
                    break;
                case 5 :
                    afficherListeDesVehicules();
                    break;

                case 6:
                    retournerUnVehicule();
                    break;

                case 7:
                   afficherVehiculeLouesOuDisponibles(DISPONIBLE);
                    break;

                case 8:
                    afficherVehiculeLouesOuDisponibles(LOUE);
                    break;
                case 9:
                    continuer=false;
                default:
                    System.out.println("Choix Invalide");
                    break;
            }

        }while(continuer);
    }

    private static void ajouterNouveauVehicule() {
        String marque;
        String modele;
        int anneeDeMiseEnService;
        String immatriculation;
        double kilometrage;
        scanner.nextLine();
    System.out.println("veuillez entrer la marque du vehicule:");
        marque= scanner.nextLine();
    System.out.println("veuillez entrer le modele du vehicule:");
         modele= scanner.nextLine();

    System.out.println("veuillez entrer l'année de mise en service du vehicule:");
         anneeDeMiseEnService=scanner.nextInt();
    scanner.nextLine();
    System.out.println("veuillez entrer l'immatriculation du vehicule");
         immatriculation=scanner.nextLine();

    System.out.println("veuillez entrer le kilometrage du vehicule");
         kilometrage= scanner.nextDouble();

     System.out.println("1.Camion ");
     System.out.println("2.Voiture");
     System.out.print("Voulez vous ajouter une voiture ou un camion ? : ");
     int decision= scanner.nextInt();
     switch(decision){
         case  1:
             double capaciteDeChargement;
             int nombreEssieux;
             System.out.print("Quel est la capacite de chargement");
             capaciteDeChargement=scanner.nextDouble();
             System.out.print("Quel est le nombre essieux ");
             nombreEssieux=scanner.nextInt();
            Camion camion=new Camion(immatriculation,marque,modele,anneeDeMiseEnService,kilometrage,capaciteDeChargement,nombreEssieux);
            vehicules.add(camion);
            break;

         case 2:
             int nombreDePlace;
             int typeDeCarburant;
             System.out.print("Quel est le nombre de place");
             nombreDePlace= scanner.nextInt();
             System.out.println("\n1.Electrique");
             System.out.println("\n2.Diezel");
             System.out.println("\n3.Essence");
             System.out.print("Quel est le type de carburant");
             typeDeCarburant= scanner.nextInt();
             Voiture voiture= new Voiture(immatriculation,marque,modele,anneeDeMiseEnService,kilometrage,typeDeCarburant,nombreDePlace);
             vehicules.add(voiture);
             break;

         default:
             System.out.print("Choix indisponible");
             break;
     }
        System.out.println("Vehicule ajouté avec succès");
    }

    private static void ajouterNouveauClient() {
        String nom;
        String prenom;
        int numeroDePermis;
        String numeroDeTelephone;
        scanner.nextLine();
        System.out.println("Veuillez entrer votre nom");
        nom= scanner.nextLine();
        System.out.println("Veuillez entrer votre prenom");
         prenom=scanner.nextLine();
        System.out.println("\n1.Permis C");
        System.out.println("\n2.Permis BC");
        System.out.println("\n3.Permis B");
        System.out.println("Veuillez saisir votre numero de permis");
         numeroDePermis= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Veuillez saisir votre numero de telephone");
        numeroDeTelephone= scanner.nextLine();
         new Client(nom,prenom,numeroDePermis,numeroDeTelephone);

    }
    private static void afficherClient(){
        for(Client client: Client.getListeClients()){
            System.out.println("\n"+client.toString());
        }
    }

    private static void louerVehicule() {
        int i = 0;
        int numClient;
        int numVehicule;
        Client client;
        Vehicule vehicule;
        afficherClient();
        System.out.print("\nQuel est le numéro du client qui veut effectuer la location ? : ");
        numClient = scanner.nextInt();
        while (i < Client.getListeClients().size() && i < numClient) {
            i++;
        }
        if (i == numClient) {
            client = Client.getListeClients().get(i-1);
            i = 0;
            afficherClient();
            System.out.print("\nQuel est le numéro du véhicule que vous souhaitez loué ? : ");
            numVehicule = scanner.nextInt();
            while (i < vehicules.size() && i < numVehicule) {
                i++;
            }
            if (i == numVehicule) {
                vehicule = vehicules.get(i-1);
                try {
                    client.louerVehicule(vehicule);
                } catch (ClientNonAutoriseExeption e) {
                    System.out.println("\n"+e.getMessage());
                }
            } else {
                System.out.println("\nCe numéro ne correspond à aucun véhicule de la liste...");
            }
        } else {
            System.out.println("\nCe numéro ne correspond à aucun client dans la liste...");
        }
    }
    public static void afficherListeDesVehicules() {
        for (Vehicule vehicule : vehicules) {
            System.out.println("\n" + vehicule.toString());
 }
}

    private static void retournerUnVehicule() {
        int i = 0;
        int numVehicule;
        Vehicule vehicule;
       afficherListeDesVehicules();
        System.out.print("\nQuel est le numéro du véhicule à retourner ? : ");
        numVehicule = scanner.nextInt();
        while (i < vehicules.size() && i < numVehicule) {
            i++;
        }
        if (i == numVehicule) {
            vehicule = vehicules.get(i-1);
            if (vehicule instanceof Camion camion) {
                camion.retourner();
            } else if (vehicule instanceof Voiture voiture) {
                voiture.retourner();
            }
            System.out.println("\nVéhicule retourné avec succès...");
        } else {
            System.out.println("\nCe numéro ne correspond à aucun véhicule de la liste...");
        }


    }

    private static void afficherVehiculeLouesOuDisponibles(String statut){
        for(Vehicule vehicule:vehicules){
            if(vehicule.getStatut().equals(statut)){
                if (vehicule instanceof Voiture){
                    System.out.println(((Voiture)vehicule).toString());
                } else if(vehicule instanceof Camion){
                    System.out.println(((Camion)vehicule).toString());
                }
            }
        }
    }
}

