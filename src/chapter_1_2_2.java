import java.util.Arrays;


//参考 https://labuladong.gitee.io/algo/3/23/71/
public class chapter_1_2_2 {

    public static void main(String args[]) {

        int[] coins = new int[3];
        coins[0] = 1;
        coins[1] = 2;
        coins[2] = 5;
        int ans = coinChangeIterate(coins,11);

        System.out.println("ans = " + ans);
    }

    private static int coinChangeRecurse(int[] coins,int amount) {
        if (coins == null || amount <= 0) {
            return 0;
        }
//        return dp(coins, amount);


        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dpMemo(coins, amount, memo);
    }

    private static int dp(int[] coins,int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount <0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subProblem = dp(coins,amount-coins[i]);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1+subProblem);
        }
        return res == Integer.MAX_VALUE ? -1:res;
    }

    //带备忘录的
    private static int dpMemo(int[] coins,int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount <0) {
            return -1;
        }
        if (memo[amount] != -666) {
            System.out.println(" use memo ,key = " + amount + ", vaule = " + memo[amount]);
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subProblem = dpMemo(coins, amount - coins[i], memo);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        System.out.println(" --- update memo ,key = " + amount + ", vaule = " + res);
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }


    /**
     *  由于递归解法在递归深度足够大时，存在堆栈溢出 StackOverflow的问题，所以最佳的解法，都是将递归转为迭代
     *  也就是将递归调用改为一个for循环，模拟函数调用栈的方式
     *  此处将dp函数转换为dp数组 dp[i]表示目标金额为i时，需要的最少硬币数
     *  这里递归调用的是dp[amount] amount 从1开始一直到参数值（18），所以改动后的for循环就是这个amount的数值循环
     */

    private static int coinChangeIterate(int[] coins,int amount) {
        if (coins == null || amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);

            }
        }
        return dp[amount]==amount + 1?-1:dp[amount];
    }

}
