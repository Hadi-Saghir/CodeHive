package TwoPointers;

import java.util.*;

public class ThreeSum {


    /**
     * Don't code the sorting algorithm, instead use Arrays.sort()
     * to show understanding of libraries. Best is to ask the interviewer because mostly likely
     * an interviewer wants someone who knows how to build a car and not reinvent the wheel
     *
     * Remember these are just proxies to demonstrate knowledge of not only
     * coding but, rather, it's about leveraging the power of libraries and frameworks,
     * adapting to different development environments, and effectively deploying your solutions.
     *
     * p.s. i employs Arrays.sort() in ThreeSumClosest, I had to learn the hard way
     * */

    /**
     * Hashset is more efficient as it doesn't allow duplicates
     * but maximum performance can only be achieved by creating a data structure
     * yourself. An example is provided below, but I would have never though of it myself
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new LinkedList<>();
        }

        List<List<Integer>> result = new LinkedList<>();
        HashSet<List<Integer>> resultSet = new HashSet<>();

        // Merge sort
        sort(nums, 0, nums.length - 1);

        // TwoSum
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate numbers
            }

            if (nums[i] > 0) {
                break; // No need to continue, remaining numbers are positive
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    List<Integer> triplet = new LinkedList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);

                    if (!resultSet.contains(triplet)) {
                        resultSet.add(triplet);
                        result.add(triplet);
                    }

                    l++;
                    r--;
                }
            }
        }

        return result;
    }

    public void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }


    /**
     * Descreased runtime from 45ms to 7ms
     * Advantages: customization, optimization
     * Disadvantage: Maintenance, bugs and might perform worse with heavier workloads
     * */
    private List<List<Integer>> res;
    public List<List<Integer>> threeSumDS(int[] nums) {
        int target = 0;
        return new AbstractList<List<Integer>>() {
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }
            public int size() {
                init();
                return res.size();
            }
            private void init() {
                if (res != null) return;
                Arrays.sort(nums);
                int l, r;
                int sum;
                Set<List<Integer>> tempRes = new HashSet<>();
                for (int i = 0; i < nums.length - 2; ++i) {
                    l = i + 1;
                    r = nums.length - 1;
                    while (l < r) {
                        sum = nums[i] + nums[l] + nums[r];
                        if (sum == target) {
                            List<Integer> t = new ArrayList<>();
                            t.add(nums[i]);
                            t.add(nums[l]);
                            t.add(nums[r]);
                            tempRes.add(t);
                        }
                        if (sum < target) ++l;
                        else --r;
                    }
                }
                res = new ArrayList<List<Integer>>(tempRes);
            }
        };
    }
}
