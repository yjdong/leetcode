package leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length<1)
        {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++)
        {
            int n=0;
            int number = nums[i];
            int number2 = number-1;
            while(set.contains(number))
            {
                n++;
                set.remove(number);
                number++;
            }
            while(set.contains(number2))
            {
                n++;
                set.remove(number2);
                number2--;
            }
            max = Math.max(n,max);
        }
        return max;
    }
}
