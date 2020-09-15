//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 411 👎 0

package leetcode.editor.cn;

class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * 转为负数，处理，就可以简单避免越界问题。只需要在结束时判断是否越界。
         * 思路是：用移位的方式，减去2^n个divisor，这个N取最大可能的值。这样比一个个的减更快。
         * 第一个while 带上等于号，是可以直接让结果-1；
         * ^ 是异或运算 ，两者相同为false，相异为true
         */
        public int divide(int dividend, int divisor) {
            if (divisor == 0 || dividend == 0) {
                return 0;
            }
            int answer = 0;
            boolean sign = (dividend > 0) ^ (divisor > 0);
            if (dividend > 0) {
                dividend = -dividend;
            }
            if (divisor > 0) {
                divisor = -divisor;
            }

            while (dividend <= divisor) {
                int temp_result = -1;
                int temp_divisor = divisor;
                while (dividend <= (temp_divisor << 1)) {
                    if (temp_divisor <= Integer.MIN_VALUE >> 1) break;
                    temp_divisor = temp_divisor << 1;
                    temp_result = temp_result << 1;
                }
                dividend = dividend - temp_divisor;
                answer += temp_result;
            }

            if (!sign) {
                if (answer <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
                answer = -answer;
            }

            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}