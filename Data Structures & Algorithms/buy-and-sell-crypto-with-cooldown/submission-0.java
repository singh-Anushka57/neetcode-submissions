class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int hold=-prices[0];//buying on day 1 gives a profit of -price
        int sold=0;//max profit when you sell the stock today
        int cooldown=0;//maximum profit when you dont own a stock and are resting
        for(int i=1;i<n;i++){
            int prevHold=hold;
            int prevSold=sold;
            int prevCooldown=cooldown;
            hold=Math.max(prevHold,prevCooldown-prices[i]);
            //choose between continue holding a stock or buy a stock using the profit of the resting state
            sold=prevHold+prices[i];
            cooldown=Math.max(prevCooldown,prevSold);//continue resting or rest today after selling yestarday
        }
        return Math.max(sold,cooldown);
    }
}
