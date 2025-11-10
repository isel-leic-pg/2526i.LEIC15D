
/*
Digit or Number v1
 */
fun main() {

    print("Symbol? ")
    val symbol = readln().first()
    if (symbol >= '0' && symbol <= '9')
        println("Digit")
    else
        if (symbol >= 'a' && symbol <= 'z' || symbol > 'A' && symbol <= 'Z')
            println("Letter")
        else
            println("Other Symbol")

}