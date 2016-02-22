package coreJava;

import java.math.BigInteger;

/**
 * Created by ory on 2/21/16.
 */
public class Ch01 {

    // Answer to question 1:
    public void radixPrint(int number) {
        System.out.printf("%13s: %20s\n", "Binary: ",      Integer.toString(number,  2));
        System.out.printf("%13s: %20s\n", "Octal: ",       Integer.toString(number,  8));
        System.out.printf("%13s: %20s\n", "Hexadecimal: ", Integer.toString(number, 16));
    }

    // Answer to question 2:
    public void angleNorm(int number) {
        int position = ((number % 360) + 360) % 360;
        System.out.printf("mod:     angle %d is at position %d\n", number, position);
        position = Math.floorMod(number, 360);
        System.out.printf("floorMod: angle %d is at position %d\n", number, position);
    }

    // Answer to question 3:
    public void maxOfThree(int first, int second, int third) {
        int max = first > second ? first : second;
        max = third > max ? third : max;
        System.out.printf("Conditional: %d\n", max);
        max = Math.max(first, second);
        max = Math.max(max, third);
        System.out.printf("Math.max:    %d\n", max);
    }

    //Answer to question 4:
    public void smallLargePositive() {
        System.out.printf("smallest: %f\n", Math.nextUp(0.000000));
        System.out.printf("largest:  %f\n", Double.MAX_VALUE);
    }

    // Answer to question 5:
    public void doubleToInt(){
        int intVal = Integer.MAX_VALUE;
        double doubleVal = (double)intVal;
        doubleVal++;
        System.out.printf("Double Value: %f\n", doubleVal);
        int castInt = (int) doubleVal;
        System.out.printf("Int Value:    %d\n", castInt);
    }

    public BigInteger bigFactorial (int n) {
        if (n == 1)
            return BigInteger.ONE;
        else
            return bigFactorial(n - 1).multiply(new BigInteger(new Integer(n).toString()));
    }
}
