//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1223 👎 0

package leetcode.editor.cn;

class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length==0){
                return "";
            }
            int length = strs[0].length();
            if(length==0){
                return "";
            }
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < strs.length; j++) {
                    if(strs[j].length()<=i){
                        return answer.toString();
                    }
                    if(strs[0].charAt(i) != strs[j].charAt(i)){
                        return answer.toString();
                    }
                }
                answer.append(strs[0].charAt(i));

            }
            return answer.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}