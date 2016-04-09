package leetcode;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    
    public int find(int[] nums, int left, int right)
    {
        if(left == right)
        {
            return nums[left];
        }
        if(nums[left]<nums[right])
        {
            return nums[left];
        }
        if(nums[left] == nums[right])
        {
            return find(nums, left+1, right);
        }
        else
        {
            int mid = (left+right)/2;
            if(mid>0 && nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
            if(nums[left]<=nums[mid])
            {
                return find(nums, mid+1, right);
            }
            else
            {
                return find(nums, left, mid-1);
            }
        }
    }
}