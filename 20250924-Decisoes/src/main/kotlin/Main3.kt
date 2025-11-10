/*
Digit or Number v3 (using "when")
 */
fun main() {

    print("Symbol? ")
    val symbol = readln().first()

    when(symbol){
        in '0'..'9' -> println("Digit")
        in 'a'..'z', in 'A' .. 'Z' -> println("Letter")
        else -> println("Other Symbol")
    }

}