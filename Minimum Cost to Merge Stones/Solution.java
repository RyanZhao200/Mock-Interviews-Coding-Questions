class Solution {
    public int mergeStones(int[] stones, int K) {
 int n = stones.length;
 if (n % (K - 1) != 1 && K != 2) return -1;
 int[][] dp = new int[n][n];  // definition : dp[i][j] = min cost to merge [i, j]
 int[] prefixSum = new int[n + 1];
 for (int i = 1; i < n + 1; i++) { // sum[i, j] = prefixSum[j + 1] - prefixSum[i];
  prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
 }
 for (int len = K; len <= n; len++) {
  for (int i = 0; i + len - 1 < n; i++) {
   int j = i + len - 1;
   dp[i][j] = Integer.MAX_VALUE;
   int s = len % (K - 1) == 1 || K == 2 ? len - (K - 1) : len; // base case
   for (int k = i + 1; k <= j; k++) {
    if ((k - i - 1) / (K - 1) + (j - k) / (K - 1) == (s - 1) / (K - 1)) { // check module
     int curCost = 0;
     if (i <= k - 1) curCost += dp[i][k-1];
     if (k <= j) curCost += dp[k][j];
     dp[i][j] = Math.min(dp[i][j], curCost);
    }
   }
   if (len % (K - 1) == 1 || K == 2) dp[i][j] += prefixSum[j + 1] - prefixSum[i];
  }
 }
 return dp[0][n - 1];
}
}
