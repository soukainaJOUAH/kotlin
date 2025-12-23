package com.example.myapplication

// ----------------------------------------------------------------------
// 1) Création de l’énumération Attraction : ce sont les attractions fixes
// ----------------------------------------------------------------------
enum class Attraction {
    MEDINA, KASBAH, SAHARA, MONTAGNE
}


// ----------------------------------------------------------------------
// 2) Classe Ville : représente une ville avec un nom + une liste d’attractions
// ----------------------------------------------------------------------
class Ville(val nom: String) {

    // liste dynamique des attractions de la ville
    val attractions: MutableList<Attraction> = mutableListOf()

    // Méthode pour ajouter une attraction si elle n'existe pas déjà
    fun ajouterAttraction(a: Attraction) {
        if (!attractions.contains(a)) attractions.add(a)
    }

    // Permet d’afficher une ville sous forme de texte
    override fun toString(): String {
        return "Ville(nom='$nom', attractions=${attractions.joinToString()})"
    }
}


// ----------------------------------------------------------------------
// 3) Exception personnalisée : déclenchée si on ajoute une ville en double
// ----------------------------------------------------------------------
class VilleExisteException(message: String) : Exception(message)


// ----------------------------------------------------------------------
// 4) Classe Circuit : représente un circuit composé de plusieurs villes
//    + numéro + description + prix
// ----------------------------------------------------------------------
class Circuit(
    val numero: Int,
    val description: String,
    var prix: Double
) {

    // Liste interne des villes du circuit
    private val villes: MutableList<Ville> = mutableListOf()

    // Retourne le nombre total de villes du circuit
    fun getNbr(): Int = villes.size

    // Ajoute une ville — vérifie si elle existe déjà (sinon erreur)
    fun ajouterVille(v: Ville) {
        if (villes.any { it.nom.equals(v.nom, ignoreCase = true) }) {
            throw VilleExisteException("La ville '${v.nom}' existe déjà dans le circuit.")
        }
        villes.add(v)
    }

    // Affiche toutes les informations du circuit : nom, prix, villes + attractions
    fun afficherCircuit() {
        println("----- Circuit #$numero -----")
        println("Description: $description")
        println("Prix: $prix")

        if (villes.isEmpty()) {
            println("Aucune ville dans ce circuit.")
        } else {
            println("Villes du circuit :")
            for ((index, ville) in villes.withIndex()) {
                val atts = if (ville.attractions.isEmpty())
                    "Aucune attraction"
                else
                    ville.attractions.joinToString()

                println("  ${index + 1}. ${ville.nom} -> $atts")
            }
        }
        println("---------------------------")
    }
}


// ----------------------------------------------------------------------
// 5) Classe IstCircuits : gère une collection de circuits (liste globale)
// ----------------------------------------------------------------------
class IstCircuits {

    // Liste qui stocke tous les circuits
    private val circuits: MutableList<Circuit> = mutableListOf()

    // Ajout d'un circuit et d'une ville directement (option du sujet)
    fun ajouterCircuitAvecVille(circuit: Circuit, ville: Ville) {
        // On vérifie que la ville ne génère pas d’erreur
        circuit.ajouterVille(ville)
        circuits.add(circuit)
    }

    // Trouve le circuit le plus cher et affiche son prix
    fun afficherPrixCircuitLePlusCher() {
        if (circuits.isEmpty()) {
            println("Aucun circuit disponible.")
            return
        }
        val plusCher = circuits.maxByOrNull { it.prix }!!
        println("Circuit le plus cher : #${plusCher.numero} prix = ${plusCher.prix}")
    }

    // Affiche tous les circuits dont le prix dépasse un seuil (ex : 8000 dh)
    fun afficherCircuitsPrixSuperieur(seuil: Double) {
        val filtres = circuits.filter { it.prix > seuil }

        if (filtres.isEmpty()) {
            println("Aucun circuit avec prix > $seuil.")
            return
        }

        println("Circuits avec prix supérieur à $seuil :")
        // On réutilise la méthode afficherCircuit() (comme demandé par le sujet)
        filtres.forEach { it.afficherCircuit() }
    }

    // Méthode utilitaire pour ajouter un circuit simple
    fun ajouterCircuit(c: Circuit) {
        circuits.add(c)
    }

    // Affiche tous les circuits stockés
    fun afficherTousLesCircuits() {
        if (circuits.isEmpty()) {
            println("Aucun circuit enregistré.")
        } else {
            circuits.forEach { it.afficherCircuit() }
        }
    }
}


// ----------------------------------------------------------------------
// 6) Fonctions de test (main) — pour vérifier que tout fonctionne
// ----------------------------------------------------------------------
fun main() {

    // Création de quelques villes + attractions
    val rabat = Ville("Rabat")
    rabat.ajouterAttraction(Attraction.MEDINA)

    val marrakech = Ville("Marrakech")
    marrakech.ajouterAttraction(Attraction.KASBAH)
    marrakech.ajouterAttraction(Attraction.MEDINA)

    val desert = Ville("Erg Chebbi")
    desert.ajouterAttraction(Attraction.SAHARA)

    // Création des circuits
    val circuit1 = Circuit(1, "Circuit culturel + désert", 9500.0)
    val circuit2 = Circuit(2, "Circuit repos et montagne", 6500.0)
    val circuit3 = Circuit(3, "Circuit simple", 3000.0)

    // Collection des circuits
    val collection = IstCircuits()

    // Ajout des villes
    circuit1.ajouterVille(rabat)
    circuit1.ajouterVille(desert)

    circuit2.ajouterVille(marrakech)

    circuit3.ajouterVille(rabat)

    // Ajout des circuits à la collection
    collection.ajouterCircuit(circuit1)
    collection.ajouterCircuit(circuit2)
    collection.ajouterCircuit(circuit3)

    // Tests demandés dans l’énoncé
    collection.afficherTousLesCircuits()
    collection.afficherPrixCircuitLePlusCher()
    collection.afficherCircuitsPrixSuperieur(8000.0)
}
