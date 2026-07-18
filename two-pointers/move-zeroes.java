class Solution {
    public void moveZeroes(int[] nums){
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(j<n){
            if(nums[j] !=0){
                nums[i++] = nums[j];

            }
            j++;
        }
        for(int k = i; k<n;k++){
            nums[k]=0;

        }
    }

}