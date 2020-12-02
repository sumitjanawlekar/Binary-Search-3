// Time Complexity : O(log (n-k)), where n is the number of elements in the array and k is the number of elemets to be found
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. place 2 pointers one at the start and other at the end-k of the array (As the array is sorted)
//2. Keep iterating till left is less than equal to right. For each Iteration calculate the first(mid) and then accordingly the last
//3. Keep checking if difference of x with first-1 and last OR difference of x with first and last+1 is giving you smaller difference
        //and keep moving on that side till both the above case fail meaning your first and last are at the correct position
        //Return the result

// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //result to be returned
        List<Integer> result = new ArrayList<>();
        //left and right pointers
        int left = 0;
        int right = arr.length -k;
        int first = 0;
        int last = 0;
        //while left and right dont cross each other
        while(left <= right){//you found the range ok closests elements
            first = left + (right-left)/2;
            last = first + k-1;
            //Move towards left if left side is giving you a smaller difference
            if(first > 0 && x-arr[first-1] <= arr[last]-x){
                right = first-1;
            }else if(last < arr.length-1 && x-arr[first] > arr[last+1]-x){//Move towards right if right side is giving you a smaller difference
                left = first+1;
            }else{ //break if first and last are at the correct position
                break;
            }
        }
        
        //add the numbers from first to last pointers to the result and return
        for(int i=first; i<= last; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}