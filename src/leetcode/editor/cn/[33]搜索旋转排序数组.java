//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 938 👎 0

package leetcode.editor.cn;

class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        solution.search(nums,0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //强调时间复杂度为logN，很容易想到用二分法。
        public int search(int[] nums, int target) {

            int left = 0,right = nums.length-1;
            while (left<=right){
                int mid = (right+left)/2;
                if(target==nums[mid]){
                    return mid;
                }
                if(nums[mid]<nums[right]){
                    if(nums[mid]<target && target<=nums[right]){
                        left = mid+1;
                    }else {
                        right = mid-1;
                    }
                }else {
                    if(nums[left]<=target && target<nums[mid]){
                        right = mid-1;
                    }else {
                        left = mid+1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}