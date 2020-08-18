//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2576 👎 0

package leetcode.editor.cn;
class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String longestPalindrome(String s) {
            if(s==null || s.length()<1){
                return "";
            }
            int start= 0,end = 0,LEN =0 ;
            for(int i =0;i<s.length();i++){
                int len = getStringFromEnter(s,i,i);
                int len1 = getStringFromEnter(s,i,i+1);
                LEN = Math.max(len,len1);
                if(LEN>(end-start+1)){
                    start = i-(LEN-1)/2;
                    end = i+LEN/2;
                }
            }
            //subString是一个[start,end)函数，所以这里要+1，不然会少一位。
            return s.substring(start,end+1);
        }

        private int getStringFromEnter(String string,int i, int j) {
            int start = i,end = j;
            while (start>=0 && end<string.length() && string.charAt(start)==string.charAt(end)){
                start--;
                end++;
            }
            //这里取-1而不是+1是因为start和end最后被--和++了一次
            return end-start-1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

  
}