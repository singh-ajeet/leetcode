import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class TwoElementsSum {

    public static List<Integer> find(int[] input, int sum) {
        if(input == null || input.length == 0)
            return Collections.emptyList();

        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int num : input){
            if(cache.containsKey(num)) {
                return Arrays.asList(cache.get(num), num);
            } else {
                cache.put(sum-num, num);
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        int[] nums = {5,7,1,2,8,4,3};
        System.out.println(find(nums,10));
    }
}
