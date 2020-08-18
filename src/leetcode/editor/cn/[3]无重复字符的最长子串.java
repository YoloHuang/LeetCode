//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4151 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int answer = 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for(int start = 0,end =0;end<s.length();end++){
                if(map.containsKey(s.charAt(end))){
                    start = Math.max(map.get(s.charAt(end)),start);
                }
                answer = Math.max(answer,end-start+1);

                //这里之所以用end+1，是为了当start向前移的时候，可以直接跳过重复的char
                //如果直接用end,会导致，前面answer的计算，等于0，或者当start一直为0时，是比真实的answer小一个的
                map.put(s.charAt(end),end+1);
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}