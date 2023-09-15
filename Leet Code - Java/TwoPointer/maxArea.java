package TwoPointer;

public class maxArea {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int max = 0;

        while(left < right){
            int h =  height[left] <= height[right] ? height[left] : height[right];
            int area = h * (right - left);

            if(area > max){
                max = area;
            }

            while (height[left] <= h && left < right) {
                left++;
            }
            while (height[right] <= h && left < right) {
                right--;
            }
        }

        return max;
    }
}
