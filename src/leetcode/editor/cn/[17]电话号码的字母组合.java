//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 843 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("234");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<String> letterCombinations(String digits) {
            List<String> answer = new ArrayList<>();
            if(digits==null ||digits.isEmpty()){
                return answer;
            }
            String[] first = getLetter(digits.charAt(0));
            for(String s:first){
                answer.add(s);
            }
            for (int i = 1; i < digits.length(); i++) {
                List<String> list = new ArrayList<>();
                String[] letters = getLetter(digits.charAt(i));
                for (String s:letters) {
                    for(String r:answer){
                        list.add(r+s);
                    }
                }
                answer = list;
            }

            return answer;
        }

        public String[] getLetter(char code){
            switch (code){
                case '2':
                    return new String[]{"a","b","c"};
                case '3':
                    return new String[]{"d","e","f"};
                case '4':
                    return new String[]{"g","h","i"};
                case '5':
                    return new String[]{"j","k","l"};
                case '6':
                    return new String[]{"m","n","o"};
                case '7':
                    return new String[]{"p","q","r","s"};
                case '8':
                    return new String[]{"t","u","v"};
                case '9':
                    return new String[]{"w","x","y","z"};
                default:
                    return null;

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}