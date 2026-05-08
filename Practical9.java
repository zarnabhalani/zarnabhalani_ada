import java.util.Scanner;
class MakeChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, amount;
        System.out.print("Enter number of coins: ");
        n = sc.nextInt();
        int[] coins = new int[n];
        int[] dp = new int[1000];
        System.out.println("Enter coin values:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter amount: ");
        amount = sc.nextInt();
        for (int i = 1; i <= amount; i++) {
            dp[i] = 9999;
        }
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        System.out.println("Minimum coins required = " + dp[amount]);
    }
}
