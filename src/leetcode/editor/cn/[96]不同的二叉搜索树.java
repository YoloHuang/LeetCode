//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 810 👎 0

package leetcode.editor.cn;

class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 这里需要理解其中的数学公式。
         * 我们要求数字为n时，1--n的所有二叉搜索树的可能数量。假设这个为G(N)
         * 由 95题我们可以知道，我们可以将x作为根节点，然后1--（X-1）为左边分支，（X+1--N为右边分支。
         * 那么当根节点为N时，一共可能有的情况有：f(x) = G(X-1)*G(N-X)
         * 这是因为，可能情况的种数，跟大小无关，只跟长度有关。
         * 由上面的推导我们可以知道，G(N) = (1..N) f(x)   求和
         * 所以有了下面的算法
         */
        public int numTrees(int n) {
            int[] answer =new int[n+1];
            answer[0] = 1;
            answer[1] =1;
            for (int i = 2; i <=n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    answer[i] += answer[j-1]*answer[i-j];
                }
            }
            return answer[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}