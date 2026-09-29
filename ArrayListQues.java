import java.util.*;

public class ArrayListQues{

    public static boolean isMonotonic(ArrayList<Integer> nums){
        boolean increasing = true;
        boolean decreasing = true;
        
        for(int i = 0; i < nums.size()-1; i++){
            if(nums.get(i) > nums.get(i+1)){
                increasing = false;
            }

            if(nums.get(i) < nums.get(i+1)){
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String args[]){
        // System.out.println("Hello");
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(4);
        nums.add(4);
        nums.add(3);
        System.out.println(nums);

        System.out.print(isMonotonic(nums));
    }
}