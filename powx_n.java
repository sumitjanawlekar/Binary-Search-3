// Time Complexity : O(log n), where n is the power (at each step of recursion we divide the n into half)
// Space Complexity :O(log n ), where n is the power (space for the recursive stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner explanation of your code in plain English
//1. Create a recursive function that takes x and n. Keep recursively calling this recursive function with value x and n/2 till n becomes 0
//2. Once n becomes 0, return 1 (any number raised to 0 is 1), and start calculating pow(x, n) for odd and even cases till all the
        //calls inside the recursive stack are finished
//3. In the end, if n was negative return reciprocal of the result, else for positive n just return the result

// Your code here along with comments explaining your approach

class Solution {
    double temp;
    public double myPow(double x, int n) {
        temp = 0.0;
        double result =  helper(x, n);
        //if n is negative, return the reciprocal of the result;
        if(n<0) return 1/result;
        return result;
    }
    
    public double helper(double x, int n){
        //base 
        if(n == 0) return 1;
        
        //logic
         temp = helper(x , n/2);
        if(n%2 != 0){//odd case
            return temp * temp * x;
        }else{//even case
            return temp * temp;
        }
    }
}