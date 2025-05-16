//Problem : https://leetcode.com/problems/longest-consecutive-sequence/
//Approach : Sorting 
//Time Complexity : O(n log n) 
//Space Complexity : O(1)

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2}; //sample input  
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        Arrays.sort(nums);
        int expected = nums[0] + 1;
        int orderCount = 0;
        int h_orderCount = 0;

        for (int i = 1; i<nums.length; ++i) {
            if (expected == nums[i])
                ++orderCount; //increase streak
            else if (nums[i] == nums[i-1]) //in case there are identical elements, keep moving forward
                continue;
            else {
                if (h_orderCount < orderCount)
                    h_orderCount = orderCount;  //reassign highest streak
                orderCount = 0; //reset streak
            }
            expected = nums[i] + 1;
        }

        int t_count = Math.max(orderCount, h_orderCount);

        ++t_count;

        return t_count;
    }
}

