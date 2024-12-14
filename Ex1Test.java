package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }

        @Test
        void int2NumberTest() {
           // Test basic conversion to binary
        assertEquals("1011", Ex1.int2Number(11, 2)); // 11 in decimal -> "1011" in binary
        assertEquals("1010", Ex1.int2Number(10, 2)); // 10 in decimal -> "1010" in binary

        // Test conversion to base 16 (hexadecimal)
        assertEquals("A", Ex1.int2Number(10, 16)); // 10 in decimal -> "A" in hex
        assertEquals("F", Ex1.int2Number(15, 16)); // 15 in decimal -> "F" in hex

        // Test lower boundary (base 2)
        assertEquals("0", Ex1.int2Number(0, 2)); // 0 in decimal -> "0" in binary

        // Test upper boundary (base 16)
        assertEquals("A0", Ex1.int2Number(160, 16)); // 160 in decimal -> "A0" in hex

        // Test invalid base
        assertEquals("", Ex1.int2Number(10, 1)); // Invalid base
        assertEquals("", Ex1.int2Number(10, 17)); // Invalid base


        }

        @Test
        void maxIndexTest() {
             // Array of valid and invalid numbers
        String[] numbers = {
            "1011b2",  // 11 in decimal
            "123bA",   // 1*10 + 2*16 = 18 in decimal
            "EFb16",   // 14*16 + 15 = 239 in decimal
            "A0b16",   // 160 in decimal
            "notValidb2" // Invalid
        };

        // Testing maxIndex, ignoring invalid numbers
        int maxIndex = Ex1.maxIndex(numbers);
        assertEquals(2, maxIndex); // "EFb16" (239 in decimal) should be the largest value


        // Case where all inputs are invalid
        assertEquals(-1, Ex1.maxIndex(new String[] {"invalid1", "invalid2"})); // All invalid
    
        }

        // Add additional test functions - test as much as you can.

        @Test
        void equalsTest() {
            String num1 = "1011b2"; // 11 in decimal
            String num2 = "1011b2"; // 11 in decimal
            String num3 = "123bA";  // 18 in decimal
    
            assertTrue(Ex1.equals(num1, num2)); // Equal numbers
            assertFalse(Ex1.equals(num1, num3)); // Different numbers

            // Test null values
            assertFalse(Ex1.equals(null, "1011b2"));
            assertFalse(Ex1.equals("1011b2", ""));
        }

        // Test handling of special characters in inputs
    @Test
    void specialCharacterTest() {
        assertFalse(Ex1.isNumber("!@b2")); // Special characters
        assertFalse(Ex1.isNumber("123$bA")); // Special characters in valid string
    }

    

        // Edge test case for negative or invalid inputs
    @Test
    void negativeNumberTest() {
        assertEquals(-1, Ex1.number2Int("123b-2")); // Invalid base (-2)
        assertEquals(-1, Ex1.number2Int("123b17"));  // Invalid base (17)
    }

    }
