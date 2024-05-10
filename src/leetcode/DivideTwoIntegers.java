package leetcode.easy;

/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    private static void test1() {
        int dividend = 10;
        int divisor = 3;
        assert 3 == divide(dividend, divisor);
    }

    private static void test2() {
        int dividend = 7;
        int divisor = -3;
        assert -2 == divide(dividend, divisor);
    }

    private static void test3() {
        int dividend = 1;
        int divisor = 1;
        divide(dividend, divisor);
    }

    private static void test4() {
        int dividend = 1;
        int divisor = -1;
        assert -1 == divide(dividend, divisor);
    }
    private static void test5() {
        int dividend = -1;
        int divisor = -1;
        assert 1 == divide(dividend, divisor);
    }
    private static void test6() {
        int dividend = -214748364;
        int divisor = -1;
        int result = divide(dividend, divisor);
        System.out.println(String.format("test6 result  %d",result) );
        assert 214748364 == result;
    }
    private static void test7() {
        int dividend = -214748364;
        int divisor = 1;
        assert -214748364 == divide(dividend, divisor);
    }
    private static void test8() {
        int dividend = 214748364;
        int divisor = -1;
        assert -214748364 == divide(dividend, divisor);
    }
    private static int convertToPositive(int input){
        if(input == -1) return 1;
        int result = input;
        while (true) {
            result = result + 1;
            System.out.println(String.format("while 1 input=%d, result=%d",input, result));
            if ((result + input) == 0) {
                return -result;
            }
        }

    }
    private static int convertToNegative(int input){
        int result = input;
        while (true) {
            result = result - 1;
            if ((result + input) == 0) {
                break;
            }
        }
          return result;
    }
    private static int returnQuotientForOnes(int dividend, int divisor ){
        if(dividend == 1 && divisor == 1 || dividend == -1 && divisor == -1){
            return 1;
        }
        if((dividend == -1  && divisor == 1) || (dividend ==1  && divisor == -1)){
            return -1;
        }
        return 0;
    }
    private static int returnQuoForEqualNumbers(int dividend, int divisor){
        if (dividend < 0 && divisor < 0) {
            return 1;
        }
        if (dividend < 0 || divisor < 0) {
            return -1;
        } else {
            return 1;
        }
    }
    private static int retQuoForOneOfThemEqToOne(int dividend, int divisor){

        if(dividend <0 && divisor == -1){
            return convertToPositive(dividend);
        }else if(dividend <0 && divisor == 1){
            return dividend;
        } else if (dividend >0 && divisor == -1) {
            return convertToNegative(dividend);
        }else{    return 0;}
    }
    public static int divide(int dividend, int divisor) {
        int positiveDividend= dividend;
        int positiveDivisor= divisor;

        if(dividend < 0 ) {
            positiveDividend = convertToPositive(dividend);
        }
        if(divisor <0){

            positiveDivisor = convertToPositive(divisor);
        }

        if (positiveDividend == positiveDivisor ) {
            if(positiveDividend == 1 && positiveDivisor ==1){
                return returnQuotientForOnes(dividend, divisor);
            }
            return returnQuoForEqualNumbers(dividend, divisor);

        }else{
           if(positiveDivisor ==1){
               return retQuoForOneOfThemEqToOne(dividend, divisor);
           }
            int reminder = positiveDivisor;
            int quotient = 0;
            for (int i = 1; i < positiveDividend; i++) {
                reminder = reminder + positiveDivisor;
                if (reminder >= positiveDividend) {
                    quotient = i;
                    break;
                }
            }

            if (dividend < 0 && divisor < 0) {
                return convertToPositive(quotient);
            }
            else if(dividend < 0 || divisor < 0){
                return convertToNegative(quotient);
            }
            return  quotient;
        }

    }
}
