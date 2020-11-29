// Time Complexity : O(n), n is number of children
// Space Complexity : O(n), to create and maintain candies[]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// distribute 1 to all children, proceed from left to right, check if right child rating > left child rating if yes extra candy to child on right
// process from end to check if left child has higher rating, update candies
// sum overall candies

class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        
        Arrays.fill(candies, 1);
        
        for(int i=1; i<ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        int sum = candies[candies.length-1];
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            
            sum += candies[i];
        }
    
        return sum;
    }
}