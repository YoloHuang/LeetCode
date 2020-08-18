//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2112 👎 0

package leetcode.editor.cn;

class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {


            int answer = 0;
            while (x!=0){
                int value = x%10;

                if(answer>Integer.MAX_VALUE/10 || (answer == Integer.MAX_VALUE/10 && value>7)) return 0;
                if(answer<Integer.MIN_VALUE/10 || (answer == Integer.MIN_VALUE/10 && value<-8)) return 0;
                answer = answer*10+value;
                x = x/10;
            }

            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}