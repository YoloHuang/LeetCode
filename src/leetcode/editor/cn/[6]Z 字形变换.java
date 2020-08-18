//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 793 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        String s = "PAYPALISHIRING";
        String answer = solution.convert(s, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (s == null || s.length() < 1) {
                return "";
            }
            if(numRows == 1){
                return s;
            }
            int num = 1, flag = -1;
            List<StringBuilder> sum = new ArrayList<StringBuilder>();
            for (int i = 1; i <= numRows; i++) {
                sum.add(new StringBuilder());
            }
            for (char j : s.toCharArray()) {
                sum.get(num).append(j);
                if (num == 1 || num == numRows) {
                    flag = -flag;
                }
                num = num + flag;
            }
            StringBuilder answer = new StringBuilder();
            for (StringBuilder stringBuilder : sum) {
                answer.append(stringBuilder);
            }


            return answer.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}