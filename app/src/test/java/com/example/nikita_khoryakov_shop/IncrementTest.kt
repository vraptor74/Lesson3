package com.example.nikita_khoryakov_shop

import org.junit.Assert.assertEquals
import org.junit.Test

class IncrementTest {

    @Test
    fun incrementTest() {
        var i = 1
        i += 1

        assertEquals(2, i)
    }
}