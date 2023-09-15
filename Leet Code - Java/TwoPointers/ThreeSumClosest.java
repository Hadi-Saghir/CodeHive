package TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * Here we don't need to think of the complexity of data structures
     * as we only store the closest sum.
     * */
    public int threeSumClosest(int[] nums, int target) {

        int closest = 0;

        if (nums.length < 3) {
            return 0;
        }

        // Merge sort
        Arrays.sort(nums);

        // TwoSum
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate numbers
            }

            int l = i + 1;
            int r = nums.length - 1;
            int sum = nums[i] + nums[l] + nums[r];

            if(i == 0){
                closest = sum;
            }

            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];


                if(Math.abs(target - sum) < Math.abs(target - closest)){
                    closest = sum;
                }

                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    l++;
                    r--;
                }
            }
        }

        return closest;
    }
}
