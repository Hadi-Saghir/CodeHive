package Array;

import java.util.HashMap;
import java.util.Map;

//URL: https://leetcode.com/problems/two-sum
//Level: Easy
public class TwoSum {

    /**
     * In terms of time complexity, this code has an efficient time complexity of O(n), where 'n' is
     * the length of the input array. The for loop iterates through the array once, performing constant-time
     * operations within the loop. The HashMap allows for constant-time retrieval and insertion operations on average
     * , which enhances the efficiency of the algorithm.
     *
     * However, in terms of size complexity, this code has a larger space requirement due to the HashMap.
     * The space complexity is O(n), where 'n' is the length of the input array. This is because, in the worst-case scenario,
     * all elements of the array need to be stored in the HashMap.*/
    public int[] twoSumOne(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(map.containsKey(target - curr)){
                return new int[]{map.get(target - curr), i};
            }
            map.put(curr, i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * higher time complexity compared to the previous code snippet.
     * This is because it utilizes nested loops, resulting in a time complexity of O(n^2),
     * where 'n' is the length of the input array 'nums.' */
    public int[] twoSumTwo(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
