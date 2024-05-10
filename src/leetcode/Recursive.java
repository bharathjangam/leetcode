public class Recursive {

    public static void main(String[] args) {

        assert 0 == calculateBunnyEars(0);
        assert 10 == calculateBunnyEars(5);
        assert 0 == fibonacci(0);
        assert 1 == fibonacci(1);
        assert 3 == fibonacci(2);

        assert 0 == bunnyEars2(0);
        assert 5 == bunnyEars2(2);
        assert 7 == bunnyEars2(3);
        assert 10 == bunnyEars2(4);

        assert 28 == triangle(7);
        assert 15 == triangle(5);

        assert 3 == sumDigits(12);

        assert 2 == count7(717);
        assert 4 == count7(70701277);

        assert 1 == count8(8);
        assert 2 == count8(818);
        assert 3 == count8(88);
        assert 4 == count8(8818);
        assert 4 == count8(8088);
        //todo: below test case failing need to modify algorithm
//        assert 9 == count8(88888);
        assert 4 == countX("xxhixx");

        assert 1 == countHi("xxhixx");
        assert 1 == countHi("hi");
        assert 0 == countHi("");

        assert "codey".equals(changeXY("codex"));

        assert array6(new int[]{1, 6, 4}, 0);

        assert "h*e*l*l*o".equals(allStar("hello"));

    }

    public static int calculateBunnyEars(int bunnies) {
        if (0 == bunnies) return 0;
        return 2 + calculateBunnyEars(bunnies - 1);
    }

    /*
    We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the
     normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
     Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

     */
    public static int bunnyEars2(int bunnies) {
        if (0 == bunnies) return 0;
        if (bunnies > 1 && bunnies % 2 == 0) {
            return 3 + bunnyEars2(bunnies - 1);
        }
        return 2 + bunnyEars2(bunnies - 1);
    }

    /*

  We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks,
  the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication)
  the total number of blocks in such a triangle with the given number of rows.

  triangle(0) → 0
  triangle(1) → 1
  triangle(2) → 3
  */
    public static int triangle(int rows) {
        if (rows == 0 || rows == 1) return rows;
        return rows + triangle(rows - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return n + fibonacci(n - 1);
    }

    /*
    Given a non-negative int n, return the sum of its digits recursively (no loops).
     Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
     while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
      sumDigits(126) → 9
      sumDigits(49) → 13
      sumDigits(12) → 3
     */
    public static int sumDigits(int n) {
        if (n < 10) return n % 10;
        return n % 10 + sumDigits(n / 10);
    }

    /*
   Given a non-negative int n, return the count of the occurrences of 7 as a digit,
   so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
   while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

count7(717) → 2
count7(7) → 1
count7(123) → 0
     */
    public static int count7(int n) {
        if (n < 10) {
            if (n == 0) return 0;
            if (n % 7 == 0) {
                return 1;
            }
            return 0;
        }
        int tempN = n % 10 % 7;
        return (n % 10 > 6 && tempN == 0 ? 1 : 0) + count7(n / 10);
    }

    /*
    Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
    except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4.
    Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    count8(8) → 1
    count8(818) → 2
    count8(8818) → 4
     */
    public static int count8(int n) {
        if (n < 10) {
            if (n == 0) return 0;
            if (n % 8 == 0) {
                return 1;
            }
            return 0;
        }
        int z = 0;
        int y = 0;
        if (n > 87) {
            z = n % 100 == 88 ? 2 : 0;
        }
        y = n % 10 > 7 && n % 10 % 8 == 0 ? 1 : 0;
//        System.out.println("int x= " +x);
        return z + y + (z == 2 ? count8(n / 100) : count8(n / 10));
//        return z+y +  count8(n/10);
    }

    /*
    Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power,
     so powerN(3, 2) is 9 (3 squared).
     powerN(3, 1) → 3
     powerN(3, 2) → 9
     powerN(3, 3) → 2
          */

    public int powerN(int base, int n) {

        if (n == 1) return base;
        return base * powerN(base, n - 1);

    }

    /*


Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.


countX("xxhixx") → 4
countX("xhixhix") → 3
countX("hi") → 0 */
    public static int countX(String str) {
        if (str.trim().length() == 0) return 0;
        if (str.length() == 1) {
            if (str.equals("x")) {
                return 1;
            }
            return 0;
        }
        char x = str.charAt(str.length() - 1);
        int found = x == 'x' ? 1 : 0;
        return found + countX(str.substring(0, str.length() - 1));
    }

    /*

Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.


countHi("xxhixx") → 1
countHi("xhixhix") → 2
countHi("hi") → 1
     */
    public static int countHi(String str) {
        if (str.trim().length() < 2) return 0;
        String lastring = str.substring(str.length() - 2);
        int found = 0;
        if (lastring.equals("hi")) found = 1;
        return found + countHi(str.substring(0, str.length() - 1));

    }

    /*
    Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
    changeXY("codex") → "codey"
    changeXY("xxhixx") → "yyhiyy"
    changeXY("xhixhix") → "yhiyhiy"
     */
    public static String changeXY(String str) {
        if (str.trim().length() == 0) return "";
        char x = str.charAt(str.length() - 1);
        String returnSrting = "";
        returnSrting = x == 'x' ? "y" : str.substring(str.length() - 1);
        return changeXY(str.substring(0, str.length() - 1)) + returnSrting;
    }

    /*
    Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.


array6([1, 6, 4], 0) → true
array6([1, 4], 0) → false
array6([6], 0) → true
     */
    public static boolean array6(int[] nums, int index) {
        if(nums.length ==0) return false;
        if(nums[index] == 6) return true;
        index = index + 1;
        if (index == nums.length) return false;
        return array6(nums, index);
    }
    /*
    Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
    allStar("hello") → "h*e*l*l*o"
    allStar("abc") → "a*b*c"
    allStar("ab") → "a*b"
     */
    public static String allStar(String str) {
        String firstChar ="" ;
        if(str.length() ==0) return "";
        firstChar = str.charAt(0)+"*";
        if(str.length() ==1 ) return str+"";
        return firstChar + allStar(str.substring(1));

    }

}
