package com.haa.algorithm.简单;
import  java.util.Scanner;
public class 最佳观光组合 {
    /*
    给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。

    一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

    返回一对观光景点能取得的最高分。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/best-sightseeing-pair
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    暴力很简单，关键是优化
     */
    public static void main(String[] args){
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n];
        for(int j = 0; j < n; j++){
            arr[j] = in.nextInt();
        }
        int max = maxScoreSightseeingPair(arr);
        System.out.println(max);
    }
    public  static int maxScoreSightseeingPair(int[] A) {
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }
}
