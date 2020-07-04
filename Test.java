import java.util.Scanner;

public class Test {
    public static void main1(String[] args) {

        // 给定一个有 n 个正整数的数组 A 和一个整数 sum, 求选择数组 A 中部分数字和为 sum 的方案数。
        // 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。

        // 输入描述:
        // 输入为两行:
        // 第一行为两个正整数 n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
        // 第二行为 n 个正整数 A[i](32位整数)，以空格隔开。
        // 输出描述:
        // 输出所求的方案数

        // 示例:
        // 输入
        // 5 15 5 5 10 2 3
        // 输出
        // 4

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = in.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }
            long[] count = new long[sum + 1];
            count[0] = 1;
            for (int i = 0; i < n; i++) {
                if (A[i] <= sum){
                    for (int j = sum; j >= 0; j--){
                        if ((j + A[i]) <= sum){
                            count[j + A[i]] += count[j];
                        }
                    }
                }
            }
            System.out.println(count[sum]);
        }
    }

    public static void main(String[] args) {

        // 今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
        // 1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
        // 2. 待所有字条加入完毕，每人从箱中取一个字条；
        // 3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
        // 现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？

        // 输入描述:
        // 输入包含多组数据，每组数据包含一个正整数 n（2 ≤ n ≤ 20）。
        // 输出描述:
        // 对应每一组数据，以 “xx.xx%” 的格式输出发生无人获奖的概率。

        // 示例:
        // 输入
        // 2
        // 输出
        // 50.00%
        
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            // 先求出总共有多少种抽奖可能(分母)
            // 相当于n 个人不放回排序, 总共有 n * (n - 1) *...
            // 即 n! 种方法.
            float num = 1;
            for (float i = n; i > 0; i--) {
                num *= i;
            }
            // 再求出无人获奖的可能
            // 无人获奖, 即所有人拿到的都不是自己的名字
            // 则 每个人抽到的可能性为 (n - 1);
            // 其中, 有两种情况:
            // 如果 a 和 b 两个人互相抽到, 则其他人抽到的可能性为 f(n - 2)(a, b 两人已被抽走);
            // 如果 a, b 没有互相拿到, 则可能性为 f(n - 1);
            // 所以最终得出递归公式 n 个人都不获奖的概率为:
            // h(n) = (n - 1) * (f(n - 1) + f(n - 2)) / (n!)
            // n = 1 时, 分子 = 0(一定抽到自己);
            // n = 2 时, 分子 = 1(50% 的可能);
            float ret = (probability(n) / num) * 100;
            System.out.println(String.format("%.2f", ret) + "%");
        }
    }
    private static float probability(int n) {
        // 错排法得到分子
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return (n - 1) * (probability(n -1) + probability(n - 2));
    }
}
