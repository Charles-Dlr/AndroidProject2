# EasyMemes

Ce projet est une application simple qui fait appel à l'API RESTful de imgflip : https://imgflip.com/api
Il affiche une liste de templates de memes via une recyclerview et permet l'affichage de l'image après un clic sur un élément.

Les données sont stockées en cache et les appels API ainsi que la gestion du cache se font via un Singleton.

Ci-dessous quelques images tirées de l'application : 

https://prnt.sc/13gaf7v

Le menu avec la liste de templates

https://prnt.sc/13gaglv

L'affichage du détail d'un template avec son titre et son image


Ajouts possibles & axes d'amélioration :

- Utilisation de safe-args pour le passage de données d'un fragment à un autre
- Requête POST pour réaliser des memes directement dans l'application
- Meilleur design + vignette de chaque template sur le premier fragment
- Notification PUSH lorsque de nouveaux templates sont disponibles
