package com.haa.动态规划.java;

public class 不同路径_62 {
    /*
    一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？
     */
    /*
    分析：最先想到的就是dfs，但是用dfs，由于时间复杂度太高，会超出时间限制
        使用动态规划的思想来做
         第 1 步： 定义状态
            dp[i][j]表示机器人从起始位置（1，1）到（i，j）的不同路径
         第 2 步： 思考状态转移方程
            走到(i，j)位置只有两种可能，
                1.从(i-1,j)位置向右走一步
                2.从(i,j-1)位置向下走一步
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
            细节注意：因为每一步的计算需要用到左边和上面的数据。所以要注意填表顺序
         第 3 步: 考虑初始化
            dp[1][1]显然为1
         第四步: 考虑输出
            dp[n][m]

         时间复杂度O(N*M)
         空间复杂度O(N*M)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n+1][m+1];
        //初始化
        dp[1][1] = 1;

        for(int j = 1; j <= m; j++){
            for(int i = 1; i <= n; i++){
                if(i==1 && j==1 ){
                    continue;
                }
                //这里如果在i = 0 || j==0本来需要加以判断，这里选择定义int[n+1][m+1]个数组，因为dp[i][0] = dp[0][j] == 0，依次来减少判断条件
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n][m];
    }
    /*
    空间优化：
        我们可以只用一个一维数组dp[i]来保存每一行的数据
        此时的转移方程变为 dp[i] = dp[i-1]+dp[i](一般情况)
        特殊情况：
            1.在第一行(对应j = 1的情况) dp[i] = dp[i-1]
            2.在第一列(对应i = 0的情况),此时的dp[i]永远等于dp[1],所以可以直接跳过循环
        空间复杂度O(N)
     */
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n+1];
        //初始化
        dp[1] = 1;
        for(int j = 1; j <= m; j++){
            for(int i = 2; i <= n; i++){

                if(j == 1){
                    dp[i] = dp[i-1];
                }else{
                    dp[i] = dp[i-1]+dp[i];
                }
            }
        }
        return dp[n];
    }
}
