package leetcode.easy;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
//    test1();
    test2();
//    test3();
    }
    public static void test1() {
        int[] nums = {1,3,5,6};
        int target = 5;
        int result = searchInsert(nums,target);
    }
    public static void test2() {
        int[] nums = {1,3,5,6};
        int target = 2;
        int result = searchInsert(nums,target);
    }
    public static void test3() {
        int[] nums = {1,3,5,6,7,8,9,11};
        int target = 10;
        int result = searchInsert(nums,target);
    }
    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        int high =nums.length-1;
        int low = 0;
        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (nums[mid] < target) {
                low = mid + 1;
                if(low == high) {
                    index = low+1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) {
                index = mid;
                break;
            }

        }
        return index;
    }
}
