# Fonctionnement du Code

## 1. Conception des classes

### Véhicule
La classe `Véhicule` est la classe mère des sous-classes `Voiture` et `Camion`. Les attributs `immatriculation`, `marque`, `modele`, `statut`, `anneeDeMiseEnService` et `kilometrage` sont définis en `protected` afin de pouvoir être utilisés dans les sous-classes. Le constructeur `Véhicule` initialise ces attributs, avec le `statut` par défaut à `disponible`. La méthode abstraite `calculerPrixLocation` est définie pour être implémentée dans les sous-classes.

### Voiture
La classe `Voiture` hérite de `Véhicule` et a pour attributs spécifiques `nombreDePlace` et `typeDeCarburant`. Elle contient les méthodes `louer`, `retourner` et `calculerPrixLocation`. La méthode `louer` vérifie si le statut de la voiture est `disponible` avant de la louer, sinon elle lève une exception. La méthode `retourner` change le statut de la voiture à `disponible`. La méthode `calculerPrixLocation` définit le prix en fonction du nombre de places. La méthode `toString` affiche les informations de `Véhicule` suivies de celles de `Voiture`.

### Camion
La classe `Camion` hérite de `Véhicule` et a pour attributs spécifiques `capaciteDeChargement` et `nombreEssieux`. Elle contient les méthodes `louer`, `retourner`, `calculerPrixLocation` et `toString`. La méthode `louer` vérifie si le statut du camion est `disponible` avant de le louer, sinon elle lève une exception. La méthode `retourner` change le statut du camion à `disponible`. La méthode `calculerPrixLocation` définit le prix en fonction de la capacité de chargement. La méthode `toString` affiche les informations de `Véhicule` suivies de celles de `Camion`.

## 2. Gestion des clients
La classe `Client` permet à l'utilisateur de louer et de retourner un véhicule. La méthode `louerVehicule` ajoute le véhicule à la liste des locations du client si le véhicule est disponible, sinon elle lève une exception `VehiculeIndisponibleException`. Si le véhicule est un camion, elle vérifie que le client a un permis de type `B`, sinon elle lève une exception `ClientNonAutoriseException`. La méthode `retournerVehicule` retire la location du client. La méthode `toString` retourne les informations du client. Le setter `setNumeroDePermis` vérifie que le numéro de permis est valide.

## 3. Interface et polymorphisme
L'interface et le polymorphisme sont utilisés pour permettre aux différentes classes de véhicules de partager des méthodes communes tout en ayant des implémentations spécifiques.

## 4. Gestion des exceptions
Deux exceptions sont définies :
- `VehiculeIndisponibleException` : Signale que le véhicule est déjà loué.
- `ClientNonAutoriseException` : Signale que le client n'a pas le permis requis.

## 5. Menu interactif
Le menu interactif permet de :
1. Ajouter un nouveau véhicule : Demande les informations du véhicule et permet de choisir entre ajouter une voiture ou un camion.
2. Ajouter un nouveau client : Enregistre les informations du client.
3. Afficher les clients : Parcourt et affiche la liste des clients.
4. Louer un véhicule : Associe un véhicule à un client si disponible.
5. Afficher la liste des véhicules : Affiche tous les véhicules.
6. Retourner un véhicule : Change le statut du véhicule à `disponible`.
7. Afficher la liste des véhicules disponibles et loués : Affiche les véhicules selon leur statut.
