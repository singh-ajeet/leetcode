public class ValidMountainArray {

    public static boolean validMountainArray(int[] arr) {
        if(arr == null || arr.length == 0) {
            return false;
        }

        int start = 0;
        while(start < arr.length-1){
            if(arr[start] >= arr[start+1]){
                break;
            }
            start++;
        }

        if(start == 0 || start == arr.length-1){
            return false;
        }

        while(start < arr.length-1){
            if(arr[start] <= arr[start+1]){
                return false;
            }

            start++;
        }

        return start == arr.length-1;
    }

    public static void main(String[] args) {
        int[] input = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(validMountainArray(input));
    }
}
