//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1283 👎 0

package leetcode.editor.cn;

import java.util.*;

class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //该方法无法判断(())(())的情况，也就是当N为3时，列表中没有())(()这个非法括号。所以该方法不全
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            if (n <= 0) {
                list.add("");
                return list;
            }
            Set<String> answer = new HashSet<>();
            answer.add("()");
            for (int i = n - 1; i > 0; i--) {
                Set<String> next = new HashSet<>();
                for (String s : answer) {
                    next.add(s + "()");
                    next.add("(" + s + ")");
                    next.add("()" + s);
                }
                answer.clear();
                answer = next;
            }
            for (String s : answer) {
                list.add(s);
            }

            return list;
        }

        //回溯算法

        public List<String> generateParenthesis2(int n) {
            List<String> answer = new ArrayList<>();
            back(n,n,"",answer);
            return answer;
        }

        public void back(int left,int right,String path,List<String> answer){
            if(left==0 && right ==0){
                answer.add(path);
            }

            if(left>right){
                return;
            }
            if(left>0){
                back(left-1,right,path+'(',answer);
            }
            if(right>0){
                back(left,right-1,path+')',answer);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}