package TwoPointers;

import java.util.*;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums == null || nums.length < 4) return new LinkedList<>();;

        Arrays.sort(nums);

        Set<List<Integer>> resultSet = new HashSet<>();
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 3; i++) {

            if (nums[i] > target && target > 0) {
                break; // impossible 4sum
            }

            if (nums[i] > 0 && target < 0) {
                break; // impossible 4sum
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate numbers
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // Skip duplicate numbers
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        if (!resultSet.contains(quadruplet)) {
                            resultSet.add(quadruplet);
                            result.add(quadruplet);
                        }
                        left++;
                        right--;
                    }
                }
            }
        }

        return result;
}
