class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -2);

        return solve(coins, amount, dp);
    }

    private int solve(int[] coins, int amount, int[] dp) {

        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != -2) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {

            if (coin <= amount) {

                int result = solve(coins, amount - coin, dp);

                if (result != -1) {
                    minCoins = Math.min(minCoins, result + 1);
                }
            }
        }

        if (minCoins == Integer.MAX_VALUE) {
            dp[amount] = -1;
        } else {
            dp[amount] = minCoins;
        }

        return dp[amount];
    }
}