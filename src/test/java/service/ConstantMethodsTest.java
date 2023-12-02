package service;

import org.example.constant.ConstantMethods;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ConstantMethodsTest {
    @Test
    public void testGetCardValue() {
        String test1 = "A";
        int expectedTest1 = 14;
        int result = ConstantMethods.getCardValue(test1);
        assertEquals(expectedTest1, result);
    }

    @Test
    public void testGetCardSuit() {
        assertEquals("CLUBS", ConstantMethods.getCardSuit("C"));
        assertThrows(NumberFormatException.class, () -> {
            ConstantMethods.getCardSuit("X");
        });
    }
}
