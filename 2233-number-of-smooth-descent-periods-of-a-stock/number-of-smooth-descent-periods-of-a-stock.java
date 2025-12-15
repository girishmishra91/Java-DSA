class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 1;
        long streak = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                streak++;
            } else {
                streak = 1;
            }
            result += streak;
        }
        return result;
    }
}