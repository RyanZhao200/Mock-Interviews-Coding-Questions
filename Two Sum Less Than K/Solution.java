class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        
        // Put pointers at begin/end and shrink
        int l = 0, r = A.length - 1;
        int ans = -1;
        while(l < r) {
            if(A[l] + A[r] < K) {
                ans = Math.max(ans, A[l] + A[r]);
                l++;
            } else {
                r--;
            }
        }
        
        return ans;
        
    }
}
