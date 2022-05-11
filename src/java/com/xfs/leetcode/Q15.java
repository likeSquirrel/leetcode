package com.xfs.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fansong
 * @Date : 2022/5/10 17:34
 */
public class Q15 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, -2, -1};
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {-2, 0, 1, 1, 2};
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> lists = threeSumV2(nums);
        System.out.println(JSON.toJSONString(lists));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        //先排序
        Arrays.sort(nums);

        //定义指针
        List<List<Integer>> result = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        Integer leftValue = null;
        Integer rightValue = null;

        while (left < right) {
            if (leftValue != null && leftValue == nums[left] && rightValue == nums[right]) {
                left++;
                right--;
                continue;
            }
            int remain = -(nums[left] + nums[right]);
            if (remain > nums[right] || remain < nums[left]) {
                break;
            }
            // 第三个指针不建议使用mid，mid移动会死循环,引入flag
            int mid = (right - left) / 2 + left;
            if (mid <= 0) {
                break;
            }
            int flag = 0;
            while (mid < right && mid > left) {
                if (nums[mid] < remain) {
                    if (flag < 0) {
                        break;
                    } else {
                        mid++;
                        flag = 1;
                    }
                } else if (nums[mid] > remain) {
                    if (flag > 0) {
                        break;
                    } else {
                        mid--;
                        flag = -1;
                    }
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[mid]);
                    temp.add(nums[right]);
                    result.add(temp);
                    break;
                }
            }

            leftValue = nums[left];
            rightValue = nums[right];

            if (flag >= 0) {
                left++;
            } else {
                right--;
            }

        }

        return result;
    }


    public static List<List<Integer>> threeSumV2(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2){
            return ans;
        }

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) {
                break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去掉重复情况
            }
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }

}
