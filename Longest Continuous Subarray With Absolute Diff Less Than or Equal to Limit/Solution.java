import java.lang.Math.*;
import java.util.*;
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int s = 0, c = 0;
        Deque<Integer> inc = new ArrayDeque<Integer>(); 
        Deque<Integer> dec = new ArrayDeque<Integer>();
        for(int i = 0; i < nums.length; i++) {
            while(inc.peekLast() != null && nums[inc.peekLast()] > nums[i]) {
                inc.removeLast();
            }
            inc.addLast(i);
            while(dec.peekLast() != null && nums[dec.peekLast()] < nums[i]) {
                dec.removeLast();
            }
            dec.addLast(i);
            int min = nums[inc.peekFirst()];
            int max = nums[dec.peekFirst()];
            if(max - min <= limit) {
                c++;
            } else {
                dec.remove(s);
                inc.remove(s);
                s++;
            }
        }
        return c;
    }
}
