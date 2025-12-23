sealed class Forme{
    abstract fun aire():Double
}
data class Rectangle(val langueur:Double, val largeur:Double):Forme(){

    override fun aire()=langueur*largeur

}
data class Carre(val cote:Double):Forme(){

    override fun aire()=cote*cote

}
data class Cercle(val Rayon:Double):Forme(){

    override fun aire()=Math.PI *Rayon*Rayon


}
fun afficheraire(forme:Forme){
    when (forme){
        is Rectangle -> println("l'aire de Rectangle est : ${forme.aire()}")
        is Carre -> println("l'aire de Carre est : ${forme.aire()}")
        is Cercle -> println("l'aire de Cercle est : ${forme.aire()}")
    }

}
//pour run
fun main (){
    val f1=Rectangle(5.0,5.0)
    val f2=Carre(3.0)
    val f3=Cercle(5.0)

    afficheraire(f1)
    afficheraire(f2)
    afficheraire(f3)



}