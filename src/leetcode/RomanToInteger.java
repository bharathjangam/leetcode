package leetcode.easy;

import java.util.Map;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

 */
public class RomanToInteger {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    private static void test1(){
        String s = "III";
        romanToInt(s);
    }
    private static void test2(){
        String s = "IV";
        romanToInt(s);
    }
    private static void test3(){
        String s = "LVIII";
        romanToInt(s);
    }
    public static int romanToInt(String s) {
        Map<String, Integer> romanNums =
                Map.of("I", 1,
                        "V", 5,
                        "X", 10,
                        "L", 50,
                        "C", 100,
                        "D", 500,
                        "M", 1000
                );
        System.out.println("Input-->"+ s);
        String[] array = s.split("");
        int sum = 0;
        int eval =0;
        boolean skipAdding = false;
        for (int i=0; i< array.length;i++) {
            eval = 0;
            if(array.length > (i+1) && romanNums.get(array[i]) < romanNums.get(array[i+1])) {
                eval = romanNums.get(array[i+1]) - romanNums.get(array[i]);
                skipAdding = true;
            }else{
                if(!skipAdding) {
                    eval = romanNums.get(array[i]);
                }
                skipAdding = false;

            }

            sum = sum + eval;
        }
//        System.out.println(Stream.of(s).map(i->romanNums.get(i)).collect(Collectors.toList()));
        System.out.println(sum);
        return sum;
    }
}
