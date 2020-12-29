import java.util.Arrays;

public class MaximumSubArray {

    public static int sum(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int finalSum = nums[0];
        int tmpSum = nums[0];
        for(int i = 1; i< nums.length; i++){
            int sum = tmpSum + nums[i];
            tmpSum = Math.max(sum, nums[i]);
            finalSum = Math.max(tmpSum, finalSum);
        }

        return finalSum;
    }

    public static void main(String[] args) {
        int[] input1 = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(sum(input1));

        int[] input2 = {-2,-3,4,-1,-2,-3};
        System.out.println(sum(input2));

        int[] input3 = {2,3,4,1,2,1};
        System.out.println(sum(input3));

        int[] input4 = {-9, -1, -2, -8};
        System.out.println(sum(input4));
    }
}
