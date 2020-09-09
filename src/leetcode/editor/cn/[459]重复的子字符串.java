//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 
// 👍 339 👎 0

package leetcode.editor.cn;

class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //用s+s,然后去头尾，如果2s中包含s,说明s是由多个子串组成
        public boolean repeatedSubstringPattern(String s) {
            if(s==null || s.length()<2){
                return false;
            }
            String string = s+s;
            //这里要用length-1,因为substring 后面是闭括号，不包括该值
            return string.substring(1,string.length()-1).contains(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}