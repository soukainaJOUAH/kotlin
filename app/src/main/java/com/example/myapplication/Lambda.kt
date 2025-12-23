fun main() {
    println("Filtrage des noms palindromes:")

    val Stagiaires = listOf("anna", "Soukaina", "kayak", "AYA", "amine")
    println("Noms des stagiaires: $Stagiaires")

    val Palindromes = Stagiaires.filter { it == it.reversed() }
    println("Noms palindromes: $Palindromes")

    println(" \nTest des nombres pairs et impairs:")

    val estPair: (Int) -> Boolean = { nombre -> nombre % 2 == 0 }
    val estImpair: (Int) -> Boolean = { nombre -> nombre % 2 != 0 }

    val nombres = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("Nombres pairs: ${nombres.filter(estPair)}")
    println("Nombres impairs: ${nombres.filter(estImpair)}")

    println("\nTests individuels:")
    val n = 12
    println("$n est pair: ${estPair(n)}")
    println("$n est impair: ${estImpair(n)}")

    //créer une fonction lamda qui prend en parametre une chaine de caractere et qui returne le derner charactere

    val dernierCaractere: (String) -> Char = { it[it.length - 1] }
    println("le dernier charactere est :")
    println(dernierCaractere("Kotlin") )// ➜ n


}


