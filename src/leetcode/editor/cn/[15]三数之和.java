//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2502 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>>answer = solution.threeSum(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //暴力解法，有问题，去重不够
        public List<List<Integer>> threeSum(int[] nums) {
            int length = nums.length;
            HashMap<Integer,LinkNode> map = new HashMap<>();
            for (int i = 0; i < length-1; i++) {
                for (int j = i+1; j < length; j++) {
                    int plus = 0-(nums[i]+nums[j]);
                    if(map.containsKey(plus)){
                        LinkNode table =  map.get(plus);
                        int[] answer = {i,j};
                        LinkNode next = new LinkNode(answer);
                        table.next = next;
                    }else {
                        int[] table = {i,j};
                        LinkNode node = new LinkNode(table);
                        map.put(plus,node);
                    }
                }
            }
            List<List<Integer>> an = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                if(map.containsKey(nums[i])){
                    LinkNode node = map.get(nums[i]);
                    while (node!=null){
                        int[] table = node.answer;
                        boolean isAnswer = true;
                        for (int aTable : table) {
                            if (i >= aTable) {
                                isAnswer = false;
                                break;
                            }
                        }
                        if(isAnswer){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[table[0]]);
                            list.add(nums[table[1]]);
                            an.add(list);
                        }
                        node = node.next;
                    }
                }
            }
            return an;
        }

        class LinkNode{
            int[] answer;
            LinkNode next;
            LinkNode(int[] val){
                answer = val;
            }

        }


        public List<List<Integer>> threeSum2(int[] nums){
            Arrays.sort(nums);
            int length = nums.length;
            List<List<Integer>> an = new ArrayList<>();
            if(nums==null || length<3) return an;
            for (int i = 0; i < length; i++) {
                //去重
                if(i>0 && nums[i]==nums[i-1]){
                    continue;
                }
                if(nums[i]>0) break;
                int third = length-1;
                int second = i+1;
                while (second<third){
                    int sum = nums[third]+nums[second]+nums[i];
                    if(sum>0){
                        third--;
                    }else if(sum<0){
                        second++;
                    }else {
                        an.add(Arrays.asList(nums[i],nums[second],nums[third]));
                        //去重
                        while (second<third && nums[second]==nums[second+1]) second++;
                        while (second<third && nums[third] == nums[third-1]) third--;
                        third--;
                        second++;
                    }
                }
            }
            return an;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}