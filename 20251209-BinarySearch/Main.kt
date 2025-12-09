/**
 * Performs a binary search on a sorted list of integers.
 *
 * @param l       The sorted list of integers to search.
 * @param elem    The element being searched for.
 * @param idxMin  The lower bound (inclusive) of the current search interval.
 * @param idxMax  The upper bound (inclusive) of the current search interval.
 *
 * @return The index of the element if found, or null if the element is not present.
 */
fun findBinary(l: List<Int>, elem: Int, idxMin: Int, idxMax: Int): Int? {

    // If the search interval becomes invalid, the element is not in the list
    if (idxMin > idxMax) return null

    // Compute the midpoint of the current interval
    val mid = (idxMin + idxMax) / 2

    // Check if the middle element is the one we are searching for
    if (l[mid] == elem) return mid

    // If the target element is smaller, search in the left half
    return if (elem < l[mid]) {
        findBinary(l, elem, idxMin, mid - 1)
    } 
    // Otherwise, search in the right half
    else {
        findBinary(l, elem, mid + 1, idxMax)
    }
}

/**
 * Main execution function.
 * Demonstrates the creation of a sorted list and a binary search invocation.
 */
fun main() {

    // Create a list of 16 integers where each element is twice its index:
    // [0, 2, 4, 6, ..., 30]
    val list = List(16) { it * 2 }

    // Perform a binary search for the value 4 within index range 0 to 15
    val resIdx = findBinary(list, 4, 0, 15)

    // Output the result (the index of the element, or null if not found)
    println(resIdx)
}
