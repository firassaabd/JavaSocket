AppInterface.java : Cette interface définit les méthodes distantes que les clients peuvent appeler sur l'objet distant. Dans votre cas, elle contient une méthode reverseString pour inverser une chaîne de caractères.

AppImpl.java : Cette classe implémente l'interface AppInterface. Elle contient la logique métier réelle pour inverser une chaîne de caractères. Lorsqu'un client invoque la méthode reverseString, c'est cette classe qui effectue l'inversion.

FabInterface.java : Cette interface définit une fabrique d'objets distants. Elle contient une méthode createApp qui renvoie une instance de l'interface AppInterface.

FabImpl.java : Cette classe implémente l'interface FabInterface. Elle fournit une implémentation concrète de la fabrique d'objets distants. Lorsqu'un client invoque la méthode createApp, cette classe crée et renvoie une instance de AppImpl.

ReverseServer.java : Cette classe contient le point d'entrée principal de votre serveur RMI. Elle crée et enregistre la fabrique d'objets distants dans l'annuaire rmiregistry.

ReverseClient.java : Cette classe contient le point d'entrée principal de votre client RMI. Elle récupère la fabrique d'objets distants depuis l'annuaire rmiregistry, crée une instance d'AppInterface et invoque la méthode reverseString pour inverser une chaîne de caractères.
