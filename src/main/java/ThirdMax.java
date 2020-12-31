import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThirdMax {
    public static int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
            if(set.size() > 3){
                set.remove(Collections.min(set));
            }
        }

        if(set.size() == 3){
            return Collections.min(set);
        }
        return Collections.max(set);
    }

    public static void main(String[] args) {
        int[] input = {1,2,8,3,19, 9, 8};
        System.out.println(thirdMax(input));
    }
}
