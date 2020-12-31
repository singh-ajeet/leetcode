import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingNumbers {

    public  static List<Integer> find(int[] nums) {
        if(nums == null || nums.length == 0){
            Collections.emptyList();
        }

        for(int i=0; i< nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0){
                nums[index] =  nums[index] * -1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {4,5,3,4,5};
        System.out.println(find(input));
    }
}
