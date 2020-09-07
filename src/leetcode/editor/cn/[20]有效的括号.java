//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1836 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if(s==null ||s.length()%2==1){
                return false;
            }
            Map<Character,Character> map = new HashMap<>();
            map.put(')','(');
            map.put(']','[');
            map.put('}','{');
            Stack<Character> stack = new Stack<>();
            for(char ch:s.toCharArray()){
                if(ch=='(' || ch=='[' || ch=='{'){
                    stack.push(ch);
                }else if(stack.isEmpty() || stack.pop()!=map.get(ch)){
                    return false;
                }
            }
            return stack.isEmpty();
        }

        public boolean isValid2(String s){
            if(s==null ||s.length()%2==1){
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for(char ch:s.toCharArray()){
                if(ch=='(' ) stack.push(')');
                else if(ch=='{') stack.push('}');
                else if(ch =='[') stack.push(']');
                else if(stack.isEmpty() || ch!=stack.pop()) return false;
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}