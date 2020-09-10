//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 562 👎 0

package leetcode.editor.cn;

class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        int answer =  solution.strStr2("abababababc","ababc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //暴力解法，这里参考了部分indexOf的写法，但是还是达不到indexOf的时间
        public int strStr(String haystack, String needle) {
            int L = haystack.length(), n = needle.length();
            if (L < n) {
                return -1;
            }
            if (n == 0) {
                return 0;
            }
            char first = needle.charAt(0);
            int max = L-n;
            for (int i = 0; i <= max; i++) {
                if(haystack.charAt(i)!=first){
                    while (++i <=max && haystack.charAt(i)!=first);
                }

                if(i<= max){
                    int j;
                    for (j = 1; j < n; j++) {
                        if (haystack.charAt(i + j) != needle.charAt(j)) {
                            break;
                        }
                    }

                    if (j == n) {
                        return i;
                    }
                }


            }

            return -1;
        }




        //KMP解法，重点在创建KMP数组，在测试中，这个方法消耗时间很长
        public int strStr2(String haystack, String needle) {
            int L = haystack.length(), n = needle.length();
            if (L < n) {
                return -1;
            }
            if (n == 0) {
                return 0;
            }
            int[][] kmp = getKMP(needle);
            int j = 0;
            for (int i = 0; i < L; i++) {
                j = kmp[j][haystack.charAt(i)];
                if (j == n) {
                    return i - j + 1;
                }
            }
            return -1;
        }

        //KMP算法，本质是，减少回退，根据needle的状态，以当前char计算，后面一个char该从哪个位置从头开始计算。
        
        public int[][] getKMP(String needle) {
            int length = needle.length();
            int[][] kmp = new int[length][256];
            int x = 0;
            kmp[0][needle.charAt(0)] = 1;
            for (int i = 1; i <length; i++) {
                for (int j = 0; j < 256; j++) {
                    kmp[i][j] = kmp[x][j];
                }
                kmp[i][needle.charAt(i)] = i+1;
                x = kmp[x][needle.charAt(i)];
            }
            return kmp;
        }


        public int strStr3(String haystack, String needle) {
            return haystack.indexOf(needle);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}