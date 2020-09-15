//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 660 👎 0

package leetcode.editor.cn;

class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 3,6,5,4,3,2,1  需要先从尾部找到不是升序排列的第一个数字，
        // 将这个数字与后面与它最接近的数字（比他大）交换，然后再对后面的数组，进行一一交换位置，这样就找到了比他稍微大一点的数字。
        public void nextPermutation(int[] nums) {
            int length = nums.length;
            if(length<2){
                return;
            }
            for (int i = length-1; i >0; i--) {
                if(nums[i]>nums[i-1]){
                    int min = nums[i-1];
                    int j = i;
                    while (j<length && nums[j]>min){
                        j++;
                    }
                    nums[i-1] = nums[j-1];
                    nums[j-1] = min;
                    int n = length-1;
                    while (i<n){
                        int num  = nums[i];
                        nums[i] = nums[n];
                        nums[n] = num;
                        i++;
                        n--;
                    }
                    return;
                }
            }
            int j =0,n = length-1;
            while (j<n){
                int num  = nums[j];
                nums[j] = nums[n];
                nums[n] = num;
                j++;
                n--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}