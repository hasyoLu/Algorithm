package com.haa.逻辑运算;

public class 汉明距离 {
    /*
    两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
    给出两个整数 x 和 y，计算它们之间的汉明距离。
    注意：
    0 ≤ x, y < 231.
    示例:
        输入: x = 1, y = 4
        输出: 2
        解释:
        1   (0 0 0 1)
        4   (0 1 0 0)
               ↑   ↑
        上面的箭头指出了对应二进制位不同的位置。
     */
    /*
    分析：主要考察异或运算，两个二进制数做异或运算，对应位置相同为0，不同为1，
        我们只要找到异或后二进制数中1的个数即可

     时间复杂度O(1)
     */
    public int hammingDistance(int x, int y) {
        int c = x^y;
        x = 0;
        while(c!=0){
            if(c%2!=0){
                x++;
            }
            c = c>>1;
        }
        return x;
    }
    /*
    还有一种更快的方法，布赖恩·克尼根算法，基于上面方法的基础上，可以简化寻找二进制中1的个数

    当我们在 c 和 c-1 上做 AND 位运算时，原数字 c 的最右边等于 1 的比特会被移除。

     */
    public int hammingDistance1(int x, int y) {
        int c = x^y;
        x = 0;
        while(c!=0){
            x++;
            c = c&(c-1);
        }
        return x;
    }
}
