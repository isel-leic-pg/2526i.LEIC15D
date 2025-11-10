

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OperationsTest {

    @Test
    fun sum() {
        val res = add(4, 6)
        assertEquals(res, 10)
    }

}