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


    public static ArrayList<Integer> lonelyNumber(ArrayList<Integer> nums, ArrayList<Integer> ans){
        for(int i = 0; i < nums.size(); i++){
            int currNum = nums.get(i);
            int numStatus = 1;
            for(int j = 0; j < nums.size(); j++){
                if(i != j && currNum == nums.get(j)){
                    numStatus = 0;
                }
            }
            for(int k = 0; k < nums.size(); k++){
                if(nums.get(k) == currNum+1 || nums.get(k) == currNum-1){
                    numStatus = 0;
                }
            }
            if(numStatus == 1){
                ans.add(currNum);
            }
        }
        return ans;
    }

    public static void numbFollowingKey(ArrayList<Integer> nums,int key){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.size()-1; i++){
            if(nums.get(i) == key){
                map.put(nums.get(i+1),map.getOrDefault(nums.get(i+1),0)+1);
            }
        }
        int maxCount = 0;
        int ans = -1;
        for(HashMap.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                ans = entry.getKey();
            }
        }
        System.out.print(ans);
    }

    public static ArrayList<Integer> beautifulArray(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        while(ans.size() < n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int num:ans){
                if(2*num-1 <= n){
                    temp.add(2*num-1);
                }
            }

            for(int num:ans){
                if(2*num <= n){
                    temp.add(2*num);
                }
            }

            ans = temp;
        }
        return ans;
    }

    public static void main(String args[]){
        // System.out.println("Hello");
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(100);
        nums.add(200);
        nums.add(1);
        nums.add(100);
        // System.out.println(nums);

        // System.out.print(isMonotonic(nums));
        // ArrayList<Integer> ans = new ArrayList<>();
        // System.out.print(lonelyNumber(nums,ans));

        // numbFollowingKey(nums,1);

        System.out.print(beautifulArray(5));
    }
}