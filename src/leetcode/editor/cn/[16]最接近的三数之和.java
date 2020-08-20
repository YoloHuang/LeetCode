//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 548 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int length = nums.length;
            if(nums==null || length<3) return 0;
            Arrays.sort(nums);
            int max = nums[length-3]+nums[length-2]+nums[length-1];
            int min = nums[0]+nums[1]+nums[2];
            if(max<=target) return max;
            if(min>=target) return min;
            for (int i = 0; i < length; i++) {
                int second = i+1;
                int third = length-1;
                if (i>0 && nums[i]==nums[i-1]) continue;
                while (second<third){
                    int sum = nums[i]+nums[second]+nums[third];
                    if(sum-target>0){
                        max = Math.min(sum,max);
                        while (second<third && nums[third]==nums[third-1]) third--;
                        third--;
                    }else if(sum-target<0){
                        min = Math.max(min,sum);
                        while (second<third && nums[second]==nums[second+1]) second++;
                        second++;
                    }else {
                        return sum;
                    }
                }
            }
            if(max-target>target-min){
                return min;
            }else {
                return max;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}