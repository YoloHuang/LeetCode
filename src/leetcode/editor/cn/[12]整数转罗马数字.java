//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: 3
//输出: "III" 
//
// 示例 2: 
//
// 输入: 4
//输出: "IV" 
//
// 示例 3: 
//
// 输入: 9
//输出: "IX" 
//
// 示例 4: 
//
// 输入: 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串 
// 👍 389 👎 0

package leetcode.editor.cn;

class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //暴力解法
        public String intToRoman(int num) {
            String answer = "";
            if (num > 3999 || num < 1) {
                return answer;
            }
            if (num > 999) {
                int th = num / 1000;
                for (int i = 0; i < th; i++) {
                    answer = answer + "M";
                }
                num = num % 1000;
            }
            if (num > 99) {
                int han = num / 100;
                if (han == 9) {
                    answer = answer + "CM";
                    han = 0;
                } else if (han == 4) {
                    answer = answer + "CD";
                    han = 0;
                } else if (han > 4) {
                    answer = answer + "D";
                    num = num - 500;
                    han = han - 5;
                }
                for (int i = 0; i < han; i++) {
                    answer = answer + "C";
                }
                num = num % 100;
            }
            if (num > 9) {
                int l = num / 10;
                if (l == 9) {
                    answer = answer + "XC";
                    l = 0;
                } else if (l == 4) {
                    answer = answer + "XL";
                    l = 0;
                } else if (l > 4) {
                    answer = answer + "L";
                    num = num - 50;
                    l = l - 5;
                }
                for (int i = 0; i < l; i++) {
                    answer = answer + "X";
                }
                num = num % 10;
            }
            if (num == 9) {
                answer = answer + "IX";
                num = 0;
            } else if (num == 4) {
                answer = answer + "IV";
                num = 0;
            } else if (num > 4) {
                answer = answer + "V";
                num = num - 5;
            }
            for (int i = 0; i < num; i++) {
                answer = answer + "I";
            }
            return answer;

        }

        //贪心算法

        public String intToRoman2(int num) {
            int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder builder = new StringBuilder();
            int index = 0;
            while (index < 13) {
                while (num > nums[index]) {
                    builder.append(romans[index]);
                    num = num - nums[index];
                }
                index++;
            }

            return builder.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}