/**
 * Represents units of length measurement.
 *
 * Each enum constant stores its equivalent value in millimeters.
 */
enum class Measure(val mm: Int) {

    /** One millimeter (1 mm). */
    MILLIMETER(1),

    /** One decimeter (10 mm). */
    DECIMETER(10),

    /** One centimeter (100 mm). */
    CENTIMETER(100),

    /** One meter (1000 mm). */
    METER(1000)
}

/**
 * Entry point of the program.
 *
 * Demonstrates how to iterate over enum entries and how ordinal-based
 * comparison works in Kotlin enums.
 */
fun main() {

    /**
     * Iterate through all constants of the Measure enum and print
     * their ordinal, name, and millimeter value.
     */
    for (entry in Measure.entries) {
        println("Ordinal= ${entry.ordinal} -> Name= ${entry.name} -> mm = ${entry.mm}")
    }

    /**
     * Demonstrates enum comparison based on ordinal values.
     * This prints `true` because METER appears after DECIMETER in the enum declaration.
     */
    println(Measure.METER > Measure.DECIMETER)

    /**
     * Another ordinal comparison example.
     * This prints `false` because MILLIMETER appears before DECIMETER.
     */
    println(Measure.MILLIMETER > Measure.DECIMETER)
}
