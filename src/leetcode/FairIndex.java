package leetcode.easy;

import java.util.stream.IntStream;
/*
given two integer arrays, split each array into two array, if the sum of individual array is equal, then it is fair index.
calculate how many fair arrays totally.
for example:
  A = [0, 4, -1, 0, 3];
  B =  [0, -2, 5, 0, 3];
 split each  array after first element-->
 A1=[0], A2 = [4,-1,0,3]
 B1 = [0], B2 = [-2,5,0,3]
 SUM_OF_A1 = 0,
 SUM_OF_A2 = 4+(-1)+0+3 = 6
 SUB_OF_B1 = 0
 SUM_OF_B2 = -2+5+0+3 = 6
 here, SUM_OF_A1 != SUM_OF_A2 !=SUB_OF_B1 != SUM_OF_B2
 so fair for the fairIndex is 0

  split each  array after second element-->
 A1=[0,4], A2 = [-1,0,3]
 B1 = [0,-2], B2 = [5,0,3]
 SUM_OF_A1 = 0+(-2) = -2,
 SUM_OF_A2 = 4+(-1)+0+3 = 6
 SUB_OF_B1 = 0
 SUM_OF_B2 = -2+5+0+3 = 6
 here, SUM_OF_A1 != SUM_OF_A2 !=SUB_OF_B1 != SUM_OF_B2
 so fair for the fairIndex is 0


 */
public class FairIndex {
    public static void main(String[] args) {
        System.out.println("");

        test1();
    }

    public static void test1() {
        int[] A = new int[]{0, 4, -1, 0, 3};
        int[] B = new int[]{0, -2, 5, 0, 3};
        solution(A, B);
    }

    public static int solution(int[] A, int[] B) {
        // Implement your solution here
        int fair = 0;
        int idx = A.length;
        boolean prevFair = false;
        for (int i = 1; i < idx; i++) {
              // todo: need fix below condition to improve performance
 /*            if(A[i] == 0 && B[i] == 0 && prevFair ){
                 prevFair = false;
                 fair = fair +1;
                 System.out.println(String.format("0 element condition so skipping this element %d, %d", A[i], B[i]));
                 continue;
             }*/
            IntStream.of(A).limit(i).forEach(System.out::println);
            System.out.println(String.format("i=%d, A[i]=%d, B[i]=%d)",i,A[i],B[i]));
            int aFirstSliceSum = IntStream.of(A).limit(i).sum();
            int aSecondSliceSum = IntStream.of(A).skip(i).sum();
            int bFirstSliceSum = IntStream.of(B).limit(i).sum();
            int bSecondSliceSum = IntStream.of(B).skip(i).sum();
            // skip if both array's  element is zero)
            if (aFirstSliceSum == aSecondSliceSum
                    && aFirstSliceSum == bFirstSliceSum
                    && aFirstSliceSum == bSecondSliceSum
            ) {
                System.out.println("incrementing fair");
                fair = fair + 1;
                prevFair = true;
            }
            else {
                prevFair = false;
            }
        }

        System.out.println("FAIR-->" + fair);
        return fair;
    }
}
