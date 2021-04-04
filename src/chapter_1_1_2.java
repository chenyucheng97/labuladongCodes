public class chapter_1_1_2 {

    public static void main(String args[]) {


        System.out.println("fib(1) = " + getFibNumber1(1));
        System.out.println("fib(2) = " + getFibNumber1(2));
        System.out.println("fib(3) = " + getFibNumber1(3));
        System.out.println("fib(10) = " + getFibNumber1(10));

        System.out.println("--- ---");

        System.out.println("fib(1) = " + getFibNumber2(1));
        System.out.println("fib(2) = " + getFibNumber2(2));
        System.out.println("fib(3) = " + getFibNumber2(3));
        System.out.println("fib(10) = " + getFibNumber2(10));
    }

    private static int getFibNumber1(int n) {
        if (n <= 0) return -1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int getFibNumber2(int n) {
        if (n <= 0) return -1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

}
