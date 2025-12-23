import kotlinx.coroutines.*

fun afficher(){
    println("hello")
}

suspend fun produit(): List<String> {
    delay(10000)
    return listOf("Stylo", "Cahier", "Marqueur")
}

fun main() = runBlocking {
    afficher()

    val job = launch {
        // this is a background coroutine
        val Pr = produit()
        println("Result from produit(): $Pr")
    }

    println("Doing other work while produit() runs…")

   // wait for background coroutine to finish (optional)
    println("Done.")
}
