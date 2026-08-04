package com.ecommerce.ecommerce_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleMathTest {

    @Test
    public void additionShouldReturnCorrectSum() {
        int result = 2 + 3;
        assertEquals(5, result);
        System.out.println("The sum is " + result);
    }
}