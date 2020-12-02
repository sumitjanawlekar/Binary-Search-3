// Time Complexity : O(n), Where n is the number of elements in the array
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. place 2 pointers one at the start and other at the end of the array (As the array is sorted)
//2. Keep iterating till low is less than equal to high. At each step if high is at a greater position move low and if low is at a 
        //smaller position move right, Till you find the range (That is the distance between low and high is k-1), then break
//3. Add all the elements from low to high index in the result and return the result

// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //result to be returned
        List<Integer> result = new ArrayList<>();
        //left and right pointers
        int left = 0;
        int right = arr.length -1;
        
        //while left and right dont cross each other
        while(left <= right){//you found the range ok closests elements
            if(right -left == k-1){
                break;
            }else if(Math.abs(arr[right]-x)  >= Math.abs(arr[left]-x)){//right is on the higher side
                right--;
            }else{//left is on the lower side
                left++;
            }
        }
        
        //add the numbers from left to right pointers to the result and return
        for(int i=left; i<= right; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}