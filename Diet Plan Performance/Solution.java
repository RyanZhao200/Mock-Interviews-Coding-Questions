class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if (calories == null || calories.length == 0) {
        return 0;
    }

    int rollingSum = 0;
    int performance = 0;

    for (int i = 0; i < calories.length; i++) {
        // always adding element to the sliding window on the right
        rollingSum += calories[i];
        // initial value
        if (i < k - 1) {
            continue;
        }

        // when to pop out element on the left
        if (i >= k) {
            rollingSum -= calories[i - k];
        }
        if (rollingSum > upper) {
            performance++;
        }
        if (rollingSum < lower) {
            performance--;
        }
    }

    return performance;
}
        
    }
