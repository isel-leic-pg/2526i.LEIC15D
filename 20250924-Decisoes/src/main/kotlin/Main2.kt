
/*
Digit or Number v2 (using intervals)
 */
fun main() {

    print("Symbol? ")
    val symbol = readln().first()
    if (symbol in '0'..'9')
        println("Digit")
    else
        if (symbol in 'a'..'z' || symbol in 'A' .. 'Z')
            println("Letter")
        else
            println("Other Symbol")

}