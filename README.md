<<<<<<< HEAD
=======
<<<<<<< HEAD
# ProdConsJava-Project
=======
>>>>>>> 73647d9 (Clean up IDE files and add .gitignore)
# Projet PC : Java Producteurs/Consommateurs 
###### KIRLOS Youssef 

# Introduction

Ce projet a pour objectif de mettre en œuvre différentes versions d’un buffer producteurs-consommateurs en Java, en respectant les propriétés de synchronisation vues en cours :

- respect strict de l’ordre FIFO,
- synchronisation entre threads producteurs et consommateurs,
- gestion correcte de la concurrence en MPMC.

Le buffer est implanté avec un tableau de taille bornée (`bufSz`).

---

# Structure des versions

- __prodcons.v1__ : Solution directe 
- __prodcons.v2__ : Solution directe + terminaison 
- __prodcons.v3__ : Solution basée sur sémaphores 
- __prodcons.v4__ (optionnel) : Solution basée sur Locks & Conditions 
- __prodcons.v5__ : Multi-consommation (get(k messages consécutifs))
- __prodcons.v6__ : Multi-exemplaires (put(m, n copies) 
- __prodcons.v7__ (optionnel) : Exécution de tâches

---

# EXECUTION

Pour exécuter et visualiser l’exécution :

1. On ajuste les paramètres dans le fichier `options.xml`
   *(des paramètres supplémentaires sont ajoutés pour les objectifs 5 et 6)*.

2. On exécute la classe **TestProdCons**  *(**TestTaskExecutor** pour l’objectif 7)*.

---

# TESTS

Pour tester notre travail, nous avons utilisé plusieurs méthodes :

### 1 – Exécution avec ordre fixe et avec *shuffle* des producteurs/consommateurs
Cela permet de visualiser clairement les blocages des producteurs et des consommateurs, selon l’état du buffer (plein / vide).

### 2 – Affichage de l’ordre et du temps
Fonctionne bien pour des petits nombres de producteurs et consommateurs.
Cependant, les opérations d’affichage **ne sont pas atomiques** : plusieurs threads peuvent passer au milieu, ce qui perturbe l’ordre d’exécution et le timing observé.

### 3 – Utilisation du débogueur
Exécution pas à pas pour visualiser le contenu du buffer en temps réel.
Méthode la plus fiable pour vérifier strictement que l’ordre **FIFO** est respecté.

### 4 – Variation des paramètres
Nous avons modifié `nProd`, `nCons`, `k` (objectif 5) et `n` (objectif 6) afin de générer plusieurs simulations et observer le comportement dans des configurations différentes.


<<<<<<< HEAD
=======
>>>>>>> cafe3f3 (Initial commit)
>>>>>>> 73647d9 (Clean up IDE files and add .gitignore)
