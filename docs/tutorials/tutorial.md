# Tutoriel – Calculer la mensualité d’un prêt

Ce projet permet de calculer deux choses:

1) La mensualité d’un prêt à partir de trois valeurs :
- le montant emprunté,
- le taux annuel,
- la durée en années.

2) La valeur future d’un investissement à partir de trois valeurs:
- le montant que tu verses chaque mois
- le taux annuel
- le nombre d'années
Ce tutoriel explique simplement comment utiliser cette fonctionnalité.

---

## 1. Compiler le projet

Depuis la racine du projet, exécutez :

mvn clean package


Cette commande compile le programme et génère un fichier JAR exécutable dans le dossier `target/`.

---

## 2. Lancer l’application

Toujours depuis la racine du projet, lancez :


java -jar target/financial-calculator-0.1.0.jar


Un menu s’affiche :

Tapez **1** pour calculer une mensualité de prêt, ou **2** pour calculer la valeur future d’un investissement.

L’application vous demandera ensuite les valeurs nécessaires (montant, taux annuel, durée), puis affichera le résultat.

---

Fin du tutoriel.


