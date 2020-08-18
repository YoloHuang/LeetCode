//请你来实现一个 atoi 函数，使其能将字符串转换成整数。 
//
// 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下： 
//
// 
// 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。 
// 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。 
// 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。 
// 
//
// 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。 
//
// 在任何情况下，若函数不能进行有效的转换时，请返回 0 。 
//
// 提示： 
//
// 
// 本题中的空白字符只包括空格字符 ' ' 。 
// 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，请返回 INT_MAX (231
// − 1) 或 INT_MIN (−231) 。 
// 
//
// 
//
// 示例 1: 
//
// 输入: "42"
//输出: 42
// 
//
// 示例 2: 
//
// 输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
// 
//
// 示例 3: 
//
// 输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
// 
//
// 示例 4: 
//
// 输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。 
//
// 示例 5: 
//
// 输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
//     因此返回 INT_MIN (−231) 。
// 
// Related Topics 数学 字符串 
// 👍 796 👎 0

package leetcode.editor.cn;

class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        String s = "-2147483649";
        int answer = solution.myAtoI2(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String str) {
            int i = 0,j=0;
            boolean nagetive = false;
            for (i=0;i<str.length();i++){
                char aj = str.charAt(i);
                if ( str.charAt(i)>='0' && str.charAt(i)<='9'){
                    break;
                }else if(str.charAt(i)=='-' || str.charAt(i) == '+'){
                    nagetive = str.charAt(i) == '-';
                    i++;
                    break;
                }else if(str.charAt(i)!= ' '){
                    return 0;
                }
            }

            for (j=i;j<str.length();j++){
                if (str.charAt(j)>'9' || str.charAt(j)<'0'){
                    break;
                }
            }

            int outNum = 0;
            String num = str.substring(i,j);

            for (int k = 0;k<num.length();k++){
                int cur = num.charAt(k) - '0';
                if (nagetive){
                    if (outNum<Integer.MIN_VALUE/10 || outNum == Integer.MIN_VALUE/10 && cur > 8){
                        return Integer.MIN_VALUE;
                    }
                    outNum = outNum*10 -cur;
                }else {
                    if (outNum>Integer.MAX_VALUE/10 || outNum == Integer.MAX_VALUE/10 && cur > 7){
                        return Integer.MAX_VALUE;
                    }
                    outNum = outNum *10 + cur;
                }
            }

            return outNum;
        }

        public int myAtoI2(String s){
            /**
             * 使用有限状态机，0 ：start，1：sign(正负)，2：number，3：end
             * 根据前一个状态和当前char是什么,来确认当前状态。
             */

            int[][] table = {{0,1,2,3},{3,3,2,3},{3,3,2,3},{3,3,2,3}};
            boolean sign = true;
            int answer = 0,state =0;
            for(char c:s.toCharArray()){
                state = table[state][getStatus(c)];
                if(state ==3) return answer;
                if(state ==1 && c=='-') sign = false;
                if(state ==2){
                    int value = c-'0';
                    //这里value 没有符号属性
                    if(answer>Integer.MAX_VALUE/10 || answer==Integer.MAX_VALUE/10 && value>7) return Integer.MAX_VALUE;
                    if(answer<Integer.MIN_VALUE/10 || answer == Integer.MIN_VALUE/10 && value>8) return Integer.MIN_VALUE;
                    if(sign){
                        answer = answer*10+value;
                    }else {
                        answer = answer*10-value;
                    }
                }
            }
            return answer;
        }

        //当前char是什么
        public int getStatus(char c){
            if(c == ' ') return 0;
            if(c == '-' || c == '+') return 1;
            if(Character.isDigit(c)) return 2;
            return 3;
        }

        /**
         * 使用正则表达式
         * @param str
         * @return
         */
        public int myAtoI3(String str){
            //TODO
            return 0;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


}