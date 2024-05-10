package leetcode.easy;

import java.util.List;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(2,5,5,11);
        int[] nums = numberList.stream().mapToInt(Integer::intValue).toArray();
        int target = 10;
        int[] sums = twoSum(nums, target);
        System.out.println("SUMS-->["+ sums[0] + "," + sums[1]+"]");

    }
    public static int[] twoSum(int[] nums, int target) {
     int[] indexes = new int[2];
     int temp1;
     boolean found = false;
     for(int i=0;i<nums.length;i++){
        temp1 = nums[i];
         for(int j=1;j<nums.length;j++){
             if(found) break;
             int sum = temp1 + nums[j];
             if( i != j && sum == target) {
                 indexes[0] = i;
                 indexes[1] = j;
                 found = true;
                 break;
             }

         }
     }
     return indexes;
    }
}
