 # description du programme de jeu tic tac toe en java


1 - Plan général:

Il existe de nombreuses façons d'implémenter un jeu de Tic-Tac-Toe en Java parmi lesquelles  la version textuelle de Tic-Tac-Toe. 
le programme Tic-Tac-Toe commencera par afficher le tableau puis en demandant au premier joueur de jouer qui précisera où placer sa marque sur le tableau.
 Après avoir placé la marque, nous affichons à nouveau l'état du tableau sur la sortie standard, puis demanderons à l'autre joueur de jouer. 
Ce processus se poursuivra jusqu'à ce qu'un joueur gagne ou que le tableau soit rempli (indiquant qu'une égalité s'est produite). 
L'entrée qui sera prise pour spécifier où placer une marque 'x' ou 'o' sera au format de deux entiers, qui spécifient la ligne et la colonne où la marque doit être placée.

 2 - Création du programme
 
  création du programme sous le nom tictactodemo avec deux classes java :
     -TicTacToe.java qui contient la logique du jeu
     - Main.java qui contient la méthode main() qui exécute et teste la classe TicTacToe.java
     
3 - Codage

     Création de l'objet TicTacToe qui représente un jeu de tic-tac-toe, 
     il doit contenir deux variables membres -two instance variables- qui devront être 
     placer dans la classe TicTacToe.java
    private char [][] tabJeu
   Cette variable est un tableau 2D de caractères qui sera représentatif du tableau trois par trois d'un jeu de Tic-Tac-Toe. Il conservera l'état du jeu à l'intérieur de l'objet TicTacToe à tout moment.
   
 private char markDeJeuCourant
 
   Cette variable contiendra un «x» ou un «o», représentant le jeu du joueur à un moment donné. 
  Les méthodes de la classe TicTacToe l'utiliseront lors du marquage du tableau pour déterminer quel type de marque sera placé.
    
   Ce qui suit est une configuration générale du programme. Vous trouverez ci-dessous tous les en-têtes de méthodes appartenant à la classe TacTocToe. Ces méthodes agiront sur les variables membres de la classe TacTocToe pour rendre le jeu mutable. Chacune a une brève description de ce que la méthode fera. Ces comportements sont nécessaires pour jouer à un jeu complet de Tic-Tac-Toe. 

public TicTacToe()

C'est le constructeur. Il sera chargé de s'assurer que le tableau est correctement initialisé et de définir qui sera le premier joueur.   
public void initialiseTableau()
Cette méthode initialisera le tableau de sorte que tous les emplacements soient vides '-'. 

public void afficherTableau()
affiche le tableau sur la sortie standard comme suit:

| - | - | - | 
-------------
| - | - | - | 
-------------
| - | - | - | 
-------------

private boolean isTabPlein()
Cette méthode vérifie si le tableau est plein ou non

private boolean verifierGain()
cette méthode vérifiera si un joueur a gagné, et si c'est le cas, elle retournera vrai.

private boolean verifierlignesDeGain()
Cette méthode vérifiera spécifiquement les lignes pour un gain.

private boolean verifierColsDeGain()
Cette méthode vérifiera spécifiquement les colonnes pour un gain.

private boolean verifierDiagonalsDeGain()
Cette méthode vérifiera spécifiquement les diagonales pour un gain.

private boolean verifierLigneCol(char c1, char c2, char c3)
Cette méthode vérifie les trois caractères spécifiés pris pour voir si tous les trois sont la même lettre «x» ou «o». Si tel est le cas, elle retournera vrai.
Recherche d'un gagnant

1ème étape

Il existe trois fonctions différentes pour vérifier une victoire: une pour les lignes, une pour les colonnes et une pour les diagonales. verifierGain() sera la principale méthode pour tester ces 3 fonctions pour chaque scénario affecté par l'entrée utilisateur
 Pour la méthode verifierGain() On a besoin d'une instruction return qui appelle les trois fonctions différentes. Si la vérification des lignes pour win ne retourne pas true, vérifiez les colonnes sinon les diagonales.
L'intérieur de l'instruction de return devrait ressembler à:
verifierlignesDeGain()|| verifierColsDeGain() || verifierDiagonalsDeGain() 

a)	Pour la méthode verifierlignesDeGain(): Nous parcourons les lignes pour voir s'il y a des gagnants. Cela nécessitera une boucle for avec une instruction if à l'intérieur. La boucle for sera incrémentée par l'entier i afin de vérifier chaque ligne. for (int i = 0; i <3; i ++) l'instruction if compare chaque espace de la ligne entre eux et donne une valeur «vraie» s'ils sont tous égaux. Par exemple, si la ligne contient trois 'x' ou 'o' consécutifs, la méthode renvoie true sinon false. 
 if (verifierLigneCol(tabJeu[i] [0], tabJeu [i] [1], tabJeu [i] [2]) == true)
 
   b) Pour la méthode verifierColsDeGain(): le contenu est le même que la méthode    verifierLignesDeGain(): Le seul changement sera à l'intérieur de l'instruction if. Au lieu d'incrémenter les lignes, nous incrémenterons les colonnes. Ainsi, pendant que dans verifierLignesDeGain() a une instruction if qui dit: if (verifierLigneCol(tabJeu [i] [0], tabJeu [i] [1], tabJeu [i] [2]) == true) 
verifierColsDeGain(): aura une instruction qui dit: 
if (verifierLigneCol (tabJeu [0] [i], TabJeu [1] [i], tabJeu [2] [i]) == true) 

   c)  Pour la méthode verifierDiagonalsDeGain (): effectue deux contrôles.
 Le premier contrôle est sur la diagonale du coin supérieur gauche au coin inférieur droit. Pour ce faire, nous vérifions tous les espaces qui seraient inclus dans cette section par l'instruction verifierLigneCol (tabJeu [0] [0], tabJeu [1] [1], tabJeu [2] [2]) == true) si cette instruction produit un false un deuxième contrôle sera effectue du coin supérieur droit au coin inférieur gauche verifierLigneCol(tabJeu [0] [2], tabJeu [1] [1], tabJeu [2] [0]) == true, les deux instructions sont séparées par un OR: '||'
L'instruction se présente comme suit dans le corps de la méthode verifierDiagonalsDeGain ():  
if( verifierLigneCol (tabJeu [0] [0], tabJeu [1] [1], tabJeu [2] [2]) == true) ||
 verifierLigneCol (tabJeu[0] [2], tabJeu [1] [1], tabJeu [2] [0]) == true).

2ème étape

  Maintenant, nous devons nous assurer que si un joueur obtient trois lettres identiques et consécutives, il gagne,  verifierLigneCol() sera une fonction qui comparera les trois lettres les unes aux autres, et si elles correspondent, alors retournera true.
Pour la méthode verifierLigneCol(): Cette méthode est utilisée par les autres méthodes pour envoyer trois valeurs. Nous vérifions d’abord que la première valeur n’est pas une valeur vide telle que «-». Ensuite, nous comparons la première valeur à la deuxième, et la deuxième à la troisième, et si et seulement si les trois valeurs sont identiques ET ce ne sont pas des valeurs égales à '-', alors cette méthode retournera true.

Changement entre les joueurs (x et O)

public void changeJoueur() 
La méthode changeJoueur() permutera la variable markDeJeuCourant entre x et o. Pour ce faire, elle verifie simplement ce que la variable contient actuellement. Si la variable contient un «x», changez-le en «o». Sinon, changez-le en «x».
public boolean placeMark(int row, int col) 
La méthode placeMark (int row, int col) placera la lettre correcte sur la ligne et colonne spécifiées dans la variable tabJeu. Elle retournera vrai s'il s'agissait d'un emplacement valide. Sinon, aucune modification de la variable du tableau ne sera faite, et le joueur devra essayer de placer sa lettre à un endroit différent, car un emplacement invalide a été sélectionné ou un endroit où un joueur a déjà placé sa lettre a été sélectionné.
 Pour accomplir ce comportement, quelques éléments doivent être vérifiés. Tout d'abord, on s'assure  (en utilisant une instruction if) que l'argument row est compris entre 0 et 2. Ensuite, vérifiez que l'argument col est compris entre 0 et 2. Enfin, on s'assure que l'emplacement en question contient actuellement un '- ', ce qui signifie qu'aucun joueur n'a encore marqué cet endroit. Si ces trois conditions sont vérifiées, placez une marque (dont le type est spécifié par la variable markDeJeuCourant ) à l'emplacement spécifié par row et col, puis renvoyez true. Si l'une des trois conditions n'est pas remplie, rien ne se produit et la valeur false doit être renvoyée.
 
                                                      L’exécution du programme

Maintenant que la classe TicTacToe et toutes ses méthodes sont implementées, la méthode main() qui exécute un jeu entier de Tic-Tac-Toe en utilisant un objet TicTacToe doit être créée .
Pour cela on crée un objet Scanner pour les entrées standard de System.in. En outre, on instancie un objet TicTacToe et on initialise le tableau du jeu en appelant sa méthode afficherTableau().

Une fois ces étapes terminées, le jeu réel doit être pris en compte. Pour cela, une boucle
 do -while est nécessaire. La boucle devrait être arrêter lorsque le jeu se termine, c'est-à-dire chaque fois que le tableau est plein ou il y a un gagnant. À l'intérieur de la boucle, l'état actuel du tableau doit être afficher avant chaque choix afin de montrer au joueur quels espaces sont disponibles et quels espaces sont pris. Ensuite, deux indices doivent être choisi pour indiquer la ligne et la colonne pour placer une marque . Une fois cette entrée prise, la marque doit être placée à l'aide de la méthode placeMark(row, col) et le joueur doit également être modifié à l'aide de la méthode changeJoueur().
A la suite de la boucle while qui gère tous les choix jusqu'à la fin de la partie, il sera nécessaire de déclarer qui est le vainqueur de la partie (ou si la partie est à égalité). Pour ce faire, on vérifie d'abord si le jeu est une égalité, en vérifiant si le tableau est plein et qu'il n'y a pas de gagnant. Et c'est si le cas, on affiche que le jeu est une égalité sinon on affiche qui a gagné par l'affichage du contraire de l'état actuel de la variable markDuJeuCourant . Cela peut être accompli en appelant d'abord la méthode changeJoueur (), puis en utilisant la méthode getMarkDeJeuCourant() pour obtenir l'état de la variable markDeJeuCourant. 
Il peut également intéressant d'afficher à nouveau le tableau pour montrer son état final.

Remarque :
   demo tic tac toe game position, helpful indices 
   
  [1][1], [1][2], [1][3]
  
  [2][1], [2][2], [2][3]
  
  [3][1], [3][2], [3][3]
 
 To play enter two indices from table above without brackets in standard input for example: 1 1 there must be a space between two indices.




      



