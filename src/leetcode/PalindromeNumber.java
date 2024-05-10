package leetcode.easy;

import java.util.stream.IntStream;

/*
Given an integer x, return true if x is a
palindrome
, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        test1();
        test2();
    }
    private static void test1(){
        int x  =121;
        isPalindrome(x);
    }
    private static void test2(){
        int x  =1213;
        isPalindrome(x);
    }
    public static boolean isPalindrome(int x) {
        String temp = Integer.toString(x);
        int[] array = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            array[i] = temp.charAt(i) - '0';
        }

        boolean isPalindrome = true;
        for (int i = 0; i < array.length; i++) {

            if (i == 0 && array[0] != array[array.length - 1]) {
                System.out.println("if1" + x);
                isPalindrome = false;
                break;
            } else if (array[i] != array[array.length - (i + 1)]) {
                System.out.println("if2" + x);
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
