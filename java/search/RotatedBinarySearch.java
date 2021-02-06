public class RotatedBinarySearch{
    /*
    You are given an integer array nums sorted in ascending order (with distinct 
    values), and an integer target.
    
    Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., 
    [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
    
    If target is found in the array return its index, otherwise, return -1.
    */
    public int iterativeRotatedBinarySearch(int[] nums, int target) {
        int start = 0;
        int mid = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            
            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            
            // nums[end] > nums[mid]
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    public int recursiveRotatedBinarySearch(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            
            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    return recursiveRotatedBinarySearch(nums, target, start, mid - 1);
                } else {
                    return recursiveRotatedBinarySearch(nums, target, mid + 1, end);
                }
            }
            
            // nums[end] > nums[mid]
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    return recursiveRotatedBinarySearch(nums, target, mid + 1, end);
                } else {
                    return recursiveRotatedBinarySearch(nums, target, start, mid - 1);
                }
            }
        }
        
        return -1;
    }
}
