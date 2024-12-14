package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            // Step 1: Input the first number
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals(quit)) {
                break;
            }

            // Handle plain numbers as base-10 by default
            String originalNum1 = num1; // Keep the original input for display purposes
            if (!num1.contains("b")) {
                num1 += "b10"; // Assume base 10 if no base is provided
            }

            // Validate if num1 is a valid number
            boolean isNum1Valid = Ex1.isNumber(num1);
            int value1 = Ex1.number2Int(num1); // Convert to integer
            if (!isNum1Valid || value1 == -1) {
                System.out.println("num1= " + originalNum1 + " is number: false , value: -1");
                System.out.println("ERR: num1 is in the wrong format! (" + originalNum1 + ")");
                continue;
            }
            System.out.println("num1= " + originalNum1 + " is number: true , value: " + value1);

            // Step 2: Input the second number
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals(quit)) {
                break;
            }

            // Handle plain numbers as base-10 by default
            String originalNum2 = num2; // Keep the original input for display purposes
            if (!num2.contains("b")) {
                num2 += "b10"; // Assume base 10 if no base is provided
            }

            // Validate if num2 is a valid number
            boolean isNum2Valid = Ex1.isNumber(num2);
            int value2 = Ex1.number2Int(num2); // Convert to integer
            if (!isNum2Valid || value2 == -1) {
                System.out.println("num2= " + originalNum2 + " is number: false , value: -1");
                System.out.println("ERR: num2 is in the wrong format! (" + originalNum2 + ")");
                continue;
            }
            System.out.println("num2= " + originalNum2 + " is number: true , value: " + value2);

            // Step 3: Input the base for output
            System.out.println("Enter a base for output: (a number [2,16]): ");
            int baseOut = sc.nextInt();
            if (baseOut < 2 || baseOut > 16) {
                System.out.println("ERR: Base " + baseOut + " is not in the range [2,16]");
                continue;
            }

            // Perform addition and multiplication
            int sum = value1 + value2;
            int product = value1 * value2;

            // Convert results to the specified base
            String sumStr = Ex1.int2Number(sum, baseOut) + "b" + baseOut;
            String productStr = Ex1.int2Number(product, baseOut) + "b" + baseOut;

            // Display results
            System.out.println(originalNum1 + " + " + originalNum2 + " = " + sumStr);
            System.out.println(originalNum1 + " * " + originalNum2 + " = " + productStr);

            // Find the maximum number
            String[] numbers = {originalNum1 + "b10", originalNum2 + "b10", sumStr, productStr};
            int maxIndex = Ex1.maxIndex(numbers);
            System.out.println("Max number over [" + String.join(",", numbers) + "] is: " + numbers[maxIndex]);
        }

        System.out.println("quiting now...");
        sc.close();
    }
    
}


