import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {

        // 输入一个字符串，然后对每个字符进行奇校验
        // 最后输出校验后的二进制数(如 '3’，输出：10110011)。

        // 输入描述:
        // 输入包括一个字符串，字符串长度不超过 100。
        // 输出描述:
        // 可能有多组测试数据，对于每组数据，
        // 对于字符串中的每一个字符，输出按题目进行奇偶校验后的数，每个字符校验的结果占一行。

        // 示例:
        // 输入
        // 3
        // 3a
        // 输出
        // 10110011
        // 10110011
        // 01100001

        // 奇校验：如果以二进制数据中1的个数是奇数为依据，则是奇校验, 校验位为 0.
        // 偶校验：如果以二进制数据中1的个数是偶数为依据，则是偶校验, 校验位为 1.

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 这一题里面将数字和字母统一看成是 char 类型的
            // 所以数字 3 实际存储时为 ASCII 码中的 ‘3’，其十进制表示是 51，
            // 转化为二进制表示就是 0110011，取最高位为奇校验位，校验位为 1，
            // 所以校验后的二进制数为10110011
            // 字母同理

            String str = in.next();
            char[] chars = str.toCharArray();
            for (char c : chars) {
                // 将 ASCII 码转换为二进制数
                String s = Integer.toBinaryString(c);
                // toBinaryString(int i): 在基数2中返回整数参数的字符串表示形式为无符号整数
                String strs = String.format("%07d", Integer.parseInt(s));
                // 首位是校验位, 因此二进制转化结果为 7 位.
                // String.format(String format, Object args): 使用指定的格式字符串和参数返回格式化的字符串
                // Integer.parseInt(String s): 将字符串参数解析为带符号的十进制整数

                // 奇校验
                int count = 0;
                for (int i = 0; i < 7; i++) {
                    if (strs.charAt(i) == '1') {
                        count++;
                    }
                }
                System.out.println((count % 2 == 0) ? "1" + strs : "0" + strs);
                // 校验位为首位
            }
        }
    }
}

class Test {
    public static void main(String[] args) {

        // 大整数排序
        // 对 N 个长度最长可达到 1000 的数进行排序。

        // 输入描述:
        // 输入第一行为一个整数 N，(1 <= N <= 100)。
        // 接下来的 N 行每行有一个数，数的长度范围为 1 <= len <= 1000。
        // 每个数都是一个正数，并且保证不包含前缀零。

        // 输出描述:
        // 可能有多组测试数据，对于每组数据，将给出的 N 个数从小到大进行排序，输出排序后的结果，每个数占一行。

        //示例:
        //输入
        //3
        //11111111111111111111111111111
        //2222222222222222222222222222222222
        //33333333
        //输出
        //33333333
        //11111111111111111111111111111
        //2222222222222222222222222222222222

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.next();
            }
            for (int j = 0; j < n; j++) {
                for (int i = j; i < n; i++) {
                    // 比较两数长度, 更长的数字更大
                    if (arr[j].length() > arr[i].length()) {
                        String tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;
                    } else if (arr[j].length() == arr[i].length()) {
                        // 如果两数长度相等, 则按字典序比较大小
                        if (arr[j].compareTo(arr[i]) > 0) {
                            // Strig.compareTo(String anotherString):
                            // 按字典顺序比较两个字符串
                            String tmp = arr[j];
                            arr[j] = arr[i];
                            arr[i] = tmp;
                        }
                    }
                }
            }
            for (String a : arr){
                System.out.println(a);
            }
        }
    }
}