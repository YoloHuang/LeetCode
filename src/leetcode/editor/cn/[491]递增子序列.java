//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 201 👎 0

package leetcode.editor.cn;

import com.sun.javafx.tools.packager.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new IncreasingSubsequences().new Solution();
        solution.findSubsequences(new int[]{10,1,3,3,7,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        private List<List<Integer>> res = new ArrayList<List<Integer>>();
        private List<Integer> temp = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            if (nums == null) {
                return null;
            }
            dfs(0, Integer.MIN_VALUE, nums);
            return res;
        }

        private void dfs(int curIndex, int preValue, int[] nums) {
            if (curIndex >= nums.length) {  // 遍历结束
                if (temp.size() >= 2) {
                    res.add(new ArrayList<>(temp));
                }
                return;
            }

            if (nums[curIndex] >= preValue) {   // 将当前元素加入，并向后遍历
                temp.add(nums[curIndex]);
                dfs(curIndex + 1, nums[curIndex], nums);
                temp.remove(temp.size() - 1);
            }
            //这里去重的地方有点难理解，
            // 以 1 3 3 4  为例，输出顺序为： 1 3 3 4，1 3 3，1 3 4，1 3，1 4。。。。
            // 这里的1 3 4 里面的3是第二个3。
            // 因为当我们移除第二个3的时候，这里preValue与nums[curIndex]相等。不继续递归，这时候继续移除第一个3，然后再将第二个3放进去。
            if (nums[curIndex] != preValue) {   // 不遍历 重复元素
                dfs(curIndex + 1, preValue, nums);  // 将下一个元素加入，并向后遍历
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}