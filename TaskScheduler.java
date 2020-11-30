// Time Complexity : O(n log n), sorting the freqs
// Space Complexity : O(1), if we consider O(26) constant space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed from class

// Your code here along with comments explaining your approach
// schedule max freq task first, spead by min idle time, schedule all other tasks within these intervals
// if some task feq==max freq, can schedule it at the end
// calculate time as idleTime+task.length

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];
        
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        
        Arrays.sort(freq);
        int idleTime = (freq[25]-1) * n;
        
        for(int i=freq.length-2; i>=0 && idleTime>0; i--){
            idleTime -= Math.min(freq[i], freq[25]-1);
        }
        
        idleTime = Math.max(0, idleTime);
        
        return idleTime + tasks.length;
    }
}