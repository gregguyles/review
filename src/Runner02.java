/**
 * Created by ory on 2/21/16.
 */

import coreJava.Ch01;

import java.math.BigInteger;

public class Runner02 {

    public static void main(String[] args) {

        Ch01 chOne = new Ch01();
        chOne.radixPrint(20);

        chOne.angleNorm(-370);

        chOne.maxOfThree(25, 10, 20);

        chOne.smallLargePositive();

        chOne.doubleToInt();

        int fac = 1000;
        BigInteger result = chOne.bigFactorial(fac);
        System.out.printf("%d factorial: %s", fac, result.toString());
        System.out.println();

        chOne.shorts(65533, 3);

        chOne.printStrings("abc");

        chOne.checkEquals(new Integer(5), new Integer(5));
        chOne.checkEquals(5, 5);

        chOne.randString(100);

        chOne.nonAscii("a\u2202x\u2234*");

        chOne.lotteryPic();

        //chOne.isMagicSquare();

        chOne.pascalsTri(5);
    }
}
