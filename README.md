Le code est disponible sur GitHub: https://github.com/PierrickMonchoix/memory.git

# Lancer le projet:

## Adresse IP du serveur:

Ce jeu ce joue en local, il faut d'abord lancer le serveur puis les clients.
Mais tout d'abord, il faut rentrer dans le code l'adresse IP du serveur,
c'est à dire modifier la variable 'ipServer' dans 'memoryclient.websocket.websocketClient.MyWebsocketClient'.

## Lancer le seveur:

Se placer dans 'memoryserver' et lancer:
```bash
mvn exec:java -Dexec.mainClass=com.pierrickmonchoix.memoryserver.ServerApp
```

## Lancer le client JavaFX:

Se placer dans 'memoryclient' et lancer:
```bash
mvn clean javafx:run
```

## Lancer le client Android:

Utiliser AndroidStudio pour lancer le projet dans 'memory_android_client'.

# Remarques préliminaires: 

Grâce au pattern MVP uilisé pour les clients, il a été plutôt rapide 
de créer le client Android à partir du client JavaFX (les deux utilisant le langage Java).
En effet, il n'y avait que les vues à changer, et pas les présentations ni les modèles.

Le code est mieux commenté sur le client JavaFX que sur le client Android.

# Communications entre présentations parents/enfants (clients)

Un élément (vue ou présentation) "enfant" ne peux envoyer une information qu'à un unique composant: Sa présentation mère OU son modèle.
Par exemple, si on veut lancer une partie (appel serveur) en appuyant sur un bouton,
l'information doit remonter la chaîne hierarchique (de présentations filles en présentation mères)
pour remonter jusqu'au modèle qui envera l'info au serveur.

Pour modifier un composant graphique, l'informtion doit descendre le chaîne hierarchique (de présentations mères en présentation filles) pour dessendre jusqu'à la vue du composant de base (package basicComponant).
Dans une présentation, une fonction modifie sa vue si et seulement si il y a 'Up' dans le nom de la fonction.
Exemple: pour la classe 'PresentationImage', 'setUpPath' est une fonction qui modifie sa vue.



# Les classes spéciales Helper/Factory/Manager (serveur et clients)

Il y a dans le code des classes 'helper' et 'manager' et 'Factory'.
Ce sont toutes des classes singleton.

## Les Helpers

But: Faire COMMUNIQUER la couche business avec la couche traitement.
Par exemple, on utilise 'WebsocketClientHelper' pour permettre au client 
de recevoir/envoyer des messages au serveur.

## Les Factory

But: Permet au business d'ECRIRE/LIRE des données.
Par exemple, on utilise 'FactoryDao' pour permettre au serveur
d'ecrire/lire la base de données des personnes.

## Les Manager

But: Permet de gerer des antitées.
Par exemple, le 'RootManager' qui gére tous les composants graphiques 'root'.
Ou encore, 'GameManager' qui gére toutes les parties.






