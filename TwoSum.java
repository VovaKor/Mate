/**
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
* 
* Example:
* Given nums = [2, 7, 11, 15], target = 9,
* Because nums[0] + nums[1] = 2 + 7 = 9,
* return [0, 1].
* 
*/


class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        boolean[] binmap = new boolean[100000];
 
        for (int i = 0; i < nums.length; i++)
        {
            int temp = target - nums[i];
 
            if (temp + 50000 >= 0 && binmap[temp + 50000])
            {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == temp) {
                        return new int[] {j, i};
                    }
                
                }
            }
            binmap[nums[i] + 50000] = true;
        }
        return null;
    }
}
