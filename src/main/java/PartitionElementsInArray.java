
public class PartitionElementsInArray {

    public static void partition(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return;

        int n = nums.length;
        int left = 0;
        int right = n-1;

    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
