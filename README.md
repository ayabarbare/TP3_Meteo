Lien Github: https://github.com/ayabarbare/TP3_Meteo

TP3

Etape 5 

Description des dépendances

Spring Web :

Permet de gérer le développement d'applications web, prenant en compte les requêtes HTTP.

Spring Data JPA :

Permet de simplifier les accès aux BDD grâce aux annotations (en définissant les entités).

H2 Database :

BDD utilisée pendant les phases de développement et de tests.

Spring Boot DevTools :

Fournit plusieurs outils de développement, comme la recompilation* automatique du code à chaque modification.

Thymeleaf :

Moteur de template basé sur HTML

Etape 13 
Controller
1. Nous avons paramétré l'URL d'appel /greeting grâce à l'annotation @GetMapping("/greeting")
2. Nous avons choisi le fichier HTML à afficher avec la ligne  return "greeting";
3. Nous envoyons cette information à l'aide de la méthode addAttribute(), qui associe à un attribut "nomTemplate",
la valeur name précisée dans l'URL.

Etape 17
1. On remarque une nouvelle t    ble correspondant à l'entité 'adress'.
Etape 18
1. La nouvelle table a été générée automatiquement en raison de l'utilisation de l'annotation @Entity sur la classe 'Address'. 
Cette annotation indique à Hibernate (le fournisseur JPA utilisé par Spring Boot) de créer une table correspondant à cette entité.
Hibernate analyse les entités au démarrage de l'application et génère automatiquement le schéma de base de données en fonction des annotations présentes.

Etape 20
1. Aprés pouvoir executer un requete SELECT sur la table Adress cela nous montre les entrées que nous avez ajoutées dans le fichier 'data.sql'.
Etape 22
1. @Autowired Cette annotation permet à Spring de rechercher un bean correspondant.

TP4

Etape 6

1. Oui, il faut utiliser une clef API pour utiliser MeteoConcept, celle-ci est appelée Token.
2. L'URL à appeler est : https://api.meteo-concept.com/api/forecast/nextHours?token=ddadd31d5bc898550890165ccd2560cb63ab5653d8e183e4e72dac372deb27d3
3. une méthode GET.
4. il faut rajouter "&latlng=" puis le couple de valeurs, séparées par une virgule.
5. La température se trouve dans le tableau forecast, et correspond à la clef "temp2m".
6. Les prévisions météo se trouvent dans le tableau forecast, et correspondent à la clef "weather".


