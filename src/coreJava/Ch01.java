package coreJava;

import java.math.BigInteger;
import java.lang.Short;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

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

    // Answer to question 6:
    public BigInteger bigFactorial (int n) {
        if (n == 1)
            return BigInteger.ONE;
        else
            return bigFactorial(n - 1).multiply(new BigInteger(new Integer(n).toString()));
    }

    // Answer to question 7
    public void shorts(int intFirst, int intSecond) {
        short first = (short) (intFirst);
        short second = (short) (intSecond);
        System.out.printf("Sum: %6d\n",  (first  >= 0 ? first  : (first  - Short.MIN_VALUE) + Short.MAX_VALUE + 1) +
                                         (second >= 0 ? second : (second - Short.MIN_VALUE) + Short.MAX_VALUE + 1));
        System.out.printf("Diff: %6d\n", (first  >= 0 ? first  : (first  - Short.MIN_VALUE) + Short.MAX_VALUE + 1) -
                                         (second >= 0 ? second : (second - Short.MIN_VALUE) + Short.MAX_VALUE + 1));
        System.out.printf("Prod: %6d\n", (first  >= 0 ? first  : (first  - Short.MIN_VALUE) + Short.MAX_VALUE + 1) *
                                         (second >= 0 ? second : (second - Short.MIN_VALUE) + Short.MAX_VALUE + 1));
        System.out.printf("quot: %6d\n", (first  >= 0 ? first  : (first  - Short.MIN_VALUE) + Short.MAX_VALUE + 1) /
                                         (second >= 0 ? second : (second - Short.MIN_VALUE) + Short.MAX_VALUE + 1));
        System.out.printf("rem:  %6d\n", (first  >= 0 ? first  : (first  - Short.MIN_VALUE) + Short.MAX_VALUE + 1) %
                                         (second >= 0 ? second : (second - Short.MIN_VALUE) + Short.MAX_VALUE + 1));
    }

    // Answer to question 8
    public void printStrings(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = i; j < inputString.length(); j++) {
                System.out.println(inputString.substring(i, j + 1));
            }
        }
    }

    // Answer to question 9
    public void checkEquals(Integer intOne, Integer intTwo) {
        System.out.println(intOne == intTwo);
        System.out.println(intOne.equals(intTwo));
    }

    // Answer to question 10
    public void randString(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int firstNum = (int) '0';
        int firstLetter = (int) 'A';
        for (int i = 0; i < length; i++) {
            long c = rand.nextLong();
            c = Math.abs(c % 36);
            c = c < 10 ? c + firstNum : c + firstLetter - 10;
            sb.append((char) c);
        }
        System.out.println(sb);
    }

    // Answer to question 11
    public void nonAscii(String str) {
        //StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            int val = (int)str.charAt(i);
            if (val > 127)
                System.out.print(str.charAt(i));
        }
    }

    // Answer to question 13
    public void lotteryPic() {
        int[] arr = new int[49];
        int[] pics = new int[6];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println();
        for (int i = 0; i < pics.length; i++) {
            while (pics[i] == 0) {
                int randIndex = rand.nextInt(50);
                pics[i] = arr[randIndex];
                arr[randIndex] = 0;
            }
            System.out.print(pics[i] + ", ");
        }
    }
    // answer to question 14
    // Note: the book provides an incorrect example,
    // this is a correct example of a magic square:
    //     16   3   2  13
    //      5  10  11   8
    //      9   6   7  12
    //      4  15  14   1
    public void isMagicSquare() {
        System.out.println("\nEnter a square:\n");
        Scanner in = new Scanner(System.in);
        int sqSize = 0;
        int[][] square  = null;
        int row = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals(""))
                break;
            String[] numbers = line.split("\\s");
            if (square == null) {
                sqSize = numbers.length;
                square = new int[sqSize][sqSize];
            }
            for (int col = 0; col < sqSize; col++) {
                if (row < sqSize)
                    square[row][col] = Integer.parseInt(numbers[col]);
            }
            row++;
        }
        int magic = 0;
        int rowSum;
        int colSum;
        int diagSum = 0;
        for (row = 0; row < sqSize; row++) {
            rowSum = 0;
            colSum = 0;
            for (int col = 0; col < sqSize; col++) {
                rowSum += square[row][col];
                colSum += square[col][row];
                if (row == col)
                    diagSum += square[row][col];
            }
            if (row == 0)
                magic = rowSum;
            if (rowSum != magic || colSum != magic) {
                System.out.println("This is not a magic square");
                return;
            }
        }
        if (diagSum != magic) {
            System.out.println("This is not a magic square");
            return;
        }
        else {
            System.out.println("This is a magic square!");
            return;
        }
    }

    // Answer to question 15
    public void pascalsTri(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    level.add(1);
                else {
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    level.add(j, val);
                }
            }
            triangle.add(level);
        }
        System.out.println();
        Iterator<ArrayList<Integer>> listIter = triangle.iterator();
        while (listIter.hasNext()){
            Iterator<Integer> levelIter = listIter.next().iterator();
            while(levelIter.hasNext()) {
                System.out.printf("%4d", levelIter.next());
            }
            System.out.println();
        }
    }
}
