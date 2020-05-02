<<<<<<< HEAD
# JobIg

Jobig est une application android qui permettra aux étudiants de l'Esiea de trouver un stage ou une alternance lors de leurs formations.
Cette application affiche les offres d'emplois en utilisant une API de github disponible via le lien suivant :
=======
# Application JobIg

Jobig est une application android qui permettra aux étudiants de l'Esiea de trouver un stage ou une alternance lors de leurs formations.
Cette application affiche les offres d'emplois en utilisant une API de github disponible sur le lien suivant :
>>>>>>> 6c235c5738a7c41b8f2ab5a1e9ff1f4d0dcc1dba

```
https://jobs.github.com/
```

## Membres de l'équipe (3A-31)

* Nde Signe Igor berenger

<<<<<<< HEAD
## Prérequis
=======
### Prérequis
>>>>>>> 6c235c5738a7c41b8f2ab5a1e9ff1f4d0dcc1dba

* Installation d'android Studio 

```
https://developer.android.com/studio/
```

* Récupération de la branche master

```
https://github.com/PDybala10/JobIg.git
```

<<<<<<< HEAD
## Installation
=======
### Installation
>>>>>>> 6c235c5738a7c41b8f2ab5a1e9ff1f4d0dcc1dba

Il suffit de faire un pull sur la branche master de notre github ci-dessus et après lancer l'application.

## Consignes respectées:

* Ecran avec une liste d’éléments.
* Ecran avec le détail d’un élément.
* Appel WebService à une API Rest.
* Stockage de données en cache.

## Les pus:

* Gitflow
* Design
* Notifications Push ( Firebase ) 
* possibilité de crée un Cv et génération d'un fichier PDF avec un modèle plutôt pas mal.
* About us permettant de présenter la version de l'application et de contacter les programmeurs.
* Utilisation des cards view et possibilité de faire des scrolls horizontaux et verticaux.
* Catégorisation (algorithme de classification des offres par catégories).
<<<<<<< HEAD
* Nettoyage des données brute récupéré via l'api Rest pour une meilleure présentation.
* Récupération des logos d'entreprise pour chaque offre via un lien donnée par l'API.

## Fonctionnalités : 

#### Premier écran
* Splash affichant le logo de l'application (logo crée)
=======
* nettoyage des données brute récupéré via l'api Rest pour une meilleure présentation.

### Fonctionnalités : 

#### Premier écran
* splash affichant le logo de l'application (logo crée)
>>>>>>> 6c235c5738a7c41b8f2ab5a1e9ff1f4d0dcc1dba

<p align="start">
  <img src="https://github.com/PDybala10/JobIg/blob/develop/images/splash.png" width="250" height="500" title="splash">
</p>

#### Ecran Home
<<<<<<< HEAD
* Affiche la liste d'offre d'emploi par catégorie et possibilité de faire des scrolls horizontaux et verticaux.

<p align="start">
  <img src="https://github.com/PDybala10/JobIg/blob/develop/images/aceuil.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/acceuil2.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/acceuil3.png" width="250" height="500" title="splash">
</p>

#### Ecran Offre
* Affiche le détail sur une offre et donne la possibilité à l'utilisateur de la partagée de visiter le site web de l'entreprise ou encore de postuler directement.

<p align="start">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/offre.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/offre2.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/share.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/site.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/apply.png" width="250" height="500" title="splash">
</p>

#### Home Nav Bar
* Affiche la liste de fonctionnalités supplémentaires.

<p align="start"> 
  <img src="https://github.com/PDybala10/JobIg/blob/develop/images/nav_bar.png" width="250" height="500" title="splash">
</p>

#### Creation d'un Cv
* Cette fonctionnalité est disponible sois à travers l'option créer un Cv du nav_bar sois sur le bouton plus sur la page home.

<p align="start"> 
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/1.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/2.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/3.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/4.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/41.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/5.png" width="250" height="500" title="splash">
   <img src="https://github.com/PDybala10/JobIg/blob/develop/images/7.png" width="250" height="500" title="splash">
</p>

* Les boutons plus (+) visibles sur chaque fragment permettent d'ajouter le nombre de compétences par exemple et la petite étiquette maron de retirer.

<p align="start"> 
  <img src="https://github.com/PDybala10/JobIg/blob/develop/images/4.png" width="250" height="500" title="splash">
  <img src="https://github.com/PDybala10/JobIg/blob/develop/images/41.png" width="250" height="500" title="splash">
</p>

* Le boutons (imprimé) disponible sur le dernier fragment permettent d'imprimer le Cv celui-ci sera sauvegardé dans le répertoire Jobig/doc dans les fichiers de votre téléphone sous le non myCv.pdf .

<p align="start"> 
  <img src="https://github.com/PDybala10/JobIg/blob/develop/images/cv.png" width="250" height="500" title="splash">
</p>

#### About us
* C'est une vue qui permet de présenter l'application et de nous contacter.

<p align="start"> 
  <img src="https://github.com/PDybala10/JobIg/blob/develop/images/aboutUs.png" width="250" height="500" title="splash">
</p>

#### Notification 
* C'est une notification envoyée depuis Firebase

<p align="start"> 
  <img src="https://github.com/PDybala10/JobIg/blob/develop/images/notification.png" width="250" height="500" title="splash">
</p>

## Auteur

* **Nde Signe Igor berenger** - *Initial work* - [Igor Nde](https://github.com/PDybala10)


## Remerciements

* Je me suis inspiré de ma situation de recherche de stage et d'alternance pour cette application qui permettra peut-être d'aider d'autres personnes.

* Merci Mr Vincent Étienne pour votre accompagnement tout le long de ce projet.
=======
* affiche la liste d'offre d'emploie par catégorie

<p align="start">
  <img src="https://github.com/PDybala10/JobIg/blob/develop/images/splash.png" width="250" height="500" title="splash">
</p>





```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
>>>>>>> 6c235c5738a7c41b8f2ab5a1e9ff1f4d0dcc1dba
