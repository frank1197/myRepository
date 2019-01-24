package LeetCode.No1;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2018-07-16 15:04
 **/

/**
 * @Title: interviewTest
 * @Package LeetCode.No1
 * @Description: todo
 * @author yanfeng3
 * @date 2018/7/16 15:04
 * @version V1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        int[] result = twoSum(nums, 6);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[]{nums[0], 0};
        int f, s = 0;

        f = nums[0];

        for (int k = 0; k < nums.length; k++) {
            if (f > nums[k] && nums[k] != result[0]) {
                f = nums[k];
                result[0] = k;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (f + nums[i] == target) {
                result[1] = i;
            }
        }

         return result;

    }

}
