//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 550 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] example = {0,0,0,0};
        solution.fourSum(example,0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            List<List<Integer>> answer = new ArrayList<>();
            int length = nums.length;
            if(length<4) return answer;
            Arrays.sort(nums);
            if((nums[length-4]+nums[length-1]+nums[length-2]+nums[length-3])<target) return answer;
            for (int i = 0; i < length-3; i++) {
                if(i>0 && nums[i]==nums[i-1]){
                    continue;
                }
                int min = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
                if(min>target){
                    return answer;
                }
                int max = nums[i]+nums[length-1]+nums[length-2]+nums[length-3];
                if(max<target){
                    continue;
                }
                for (int j = i+1; j < length-2; j++) {
                    if(j>i+1 && nums[j]==nums[j-1]){
                        continue;
                    }
                    int k = j+1;
                    int l = length-1;
                    min = nums[i]+nums[j]+nums[k]+nums[k+1];
                    if(min>target){
                        continue;
                    }
                    max = nums[i]+nums[j]+nums[l-1]+nums[l];
                    if(max<target){
                        continue;
                    }
                    while (k<l){
                        int sum = nums[i]+nums[j]+nums[k]+nums[l];
                        if(sum == target){
                            answer.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            k++;
                            while (k<l && nums[k]==nums[k-1]){
                                k++;
                            }
                            l--;
                            while (k<l && nums[l]==nums[l+1]){
                                l--;
                            }
                        }else if(sum>target){
                            l--;
                        }else{
                            k++;
                        }
                    }

                }
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}