On fera référence a notre client par Hero
et aux autre joueurs (adversaires) par Vilain





Protocole de lancement:

1)
memory/memoryserver$ mvn exec:java -Dexec.mainClass=com.pierrickmonchoix.memoryserver.TestServerWebSocketTyrus

2)
memory/memoryclient$ mvn clean javafx:run

--------------------

(1) Lance un serveur WebSocket
(2) Lance un client JavaFx qui communique avec le serveur quand on appuie sur le bouton







EXEMPLE DE TASK.JSON POUR LE LANCEMENT:

{
    // See https://go.microsoft.com/fwlink/?LinkId=733558
    // for the documentation about the tasks.json format
    "version": "2.0.0",
    "tasks": [
        {
            "label": "run fx client",   // nom de la commande (toto work)
            "type": "shell",   // exectuter cette command edans le shell
            "command": "mvn clean javafx:run",   // la commande a  a executer
            "options": {
                "cwd": "memoryclient"  // change directory (racine = workspace folder)
            },
            "group": "build",  // permet de lancer la commande avec "build task" (ctrl t pour moi)
            "problemMatcher": []  // lance direct le task.json
        },
        {
            "label": "run rest server",
            "type": "shell",
            "command": "mvn exec:java -Dexec.mainClass=com.pierrickmonchoix.memoryserver.rest.RestLauncher",
            "options": {
                "cwd": "memoryserver"
            },
            "group": "build",
            "problemMatcher": []
        },
        {
            "label": "run rest client",
            "type": "shell",
            "command": "mvn exec:java -Dexec.mainClass=com.pierrickmonchoix.memoryclient.App",
            "options": {
                "cwd": "memoryclient"
            },
            "group": "build",
            "problemMatcher": []
        }
    ]
}