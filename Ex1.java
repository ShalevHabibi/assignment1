package assignments.ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            // add your code here
            if (num == null || !isNumber(num)){
                return -1;
            }
            // Split the input into <number> and <base>
            String[] parts = num.split("b");
            String numberPart = parts[0];
            int base = Integer.parseInt(parts[1]);

            int value = 0;
            int basePower = 1; //start with base^0 =1

            //traverse the number part from right to left
            for (int i = numberPart.length()-1; i>=0; i--){
                char c = numberPart.charAt(i);
                int digitValue;

                if (c>='0' && c<= '9'){
                    digitValue = c -'0';
                } else if (c >= 'A' && c<= 'G') { //handle letters A-G for base>10
                    digitValue = 10 + (c-'A');
                }else {
                    return -1; // invalid character for the base
                }
                if (digitValue >= base){
                    return -1; // digit is invalid for the given base
                }
                value += digitValue*basePower;
                basePower *= base; // move to the next power of the base
            }
            return value;


        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            // add your code here
            if (a == null || !a.contains("b")) {
                return false; // Must contain 'b' separator
            }
            String[] parts = a.split("b");
            if (parts.length != 2) {
                return false; // Should split into exactly two parts
            }

            String numberPart = parts[0];
            String basePart = parts[1];

            // Validate base
            try {
                int base = Integer.parseInt(basePart);
                if (base < 2 || base > 16) {
                    return false; // Base must be between 2 and 16
                }
            } catch (NumberFormatException e) {
                return false; // Base is not a valid integer
            }

            // Validate number part
            for (char c : numberPart.toCharArray()) {
                if (!(c >= '0' && c <= '9') && !(c >= 'A' && c <= 'G')) {
                    return false; // Invalid character in the number part
                }
            }
            return true;

        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            if (num < 0 || base < 2 || base > 16) {
                return ""; // Invalid input
            }

            // Special case for zero
            if (num == 0) {
                return "0";  // For 0, just return "0"
            }

            StringBuilder result = new StringBuilder();
            
            // Convert number to the given base
            while (num > 0) {
                int remainder = num % base;
                
                if (remainder < 10) {
                    result.append((char) ('0' + remainder)); // For values 0-9, append digits
                } else {
                    result.append((char) ('A' + (remainder - 10))); // For values 10-15, append letters A-F
                }
                
                num /= base;
            }

            // Reverse the result because we've built the number backwards
            return result.reverse().toString();
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {

            int value1 = number2Int(n1);
            int value2 = number2Int(n2);

            return value1 != -1 && value1 == value2; // Both numbers must be valid and equal
          
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int maxIdx = -1;
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                int value = number2Int(arr[i]);
                if (value > maxValue) {
                    maxValue = value;
                    maxIdx = i;
                }
            }
            return maxIdx;
        
        }

}
