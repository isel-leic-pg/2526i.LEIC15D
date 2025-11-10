
/*
Leap Year (with if expression)
 */
fun main() {

    print("Year? ")
    val year = readln().toInt()
    val days: Int = if ((year % 4==0 && year % 100 != 0) || (year % 400 == 0)) 366 else 365
    println("Year $year has $days days.")

}