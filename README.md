# Où Grimper
Un site web communautaire autour de l'escalade.

Avant de lancer le programme, il faut savoir qu'il est conçu pour fonctionner sous __JAVA 8__, __PostgreSQL 9__ et __Tomcat 9__.

Pour la base de données, vous trouverez ce qu'il vous faut dans le dossier __script__:

* D'abord lancer le script __create_user.sql__ pour créer le propriétaire de la bdd.
* Ensuite lancer le script __create_db_ougrimper.sql__ pour créer la bdd.
* Enfin lancer le restore avec __db_ougrimper.backup__ pour insérer les données.

Si vous passez par pgAdmin, il faut :

* créer un nouveau rôle, le nommer "__adm_ougrimper__", mettre en password "__postgres__", et lui donner tous les privilèges.
* créer une nouvelle database, la nommer "__db_ougrimper__" et mettre "__adm_ougrimper__" en tant que propriétaire.
* faire un *restore* avec le fichier __db_ougrimper.backup__.

Il se peut qu'il y ai un soucis lors de la phase de "restore", c'est parce que le fichier a été créé sous __PostgreSQL 9.6.10__.  
Il faut juste mettre à jour PostgreSQL sous la version 9.6.10 ou supérieure.

Dans le dossier __script__, vous trouverez aussi le fichier __ougrimper-webapp.war__. Il faut copier/coller ce fichier dans le dossier webapps du server Tomcat.

Pour vos tests, le compte administrateur du projet est :

Email: drissrais@gmail.com  
Password: qwerty


