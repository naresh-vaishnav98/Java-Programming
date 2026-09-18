import java.util.*;

public class RecursionPractice{

    public static void allOccurences(int arr[], int key, int i){
        if(i == arr.length){
            return;
        }
        
        if(arr[i] == key){
            System.out.print(i+" ");
        }
        allOccurences(arr,key,i+1);
    }

    public static void convertNumToString(int n, String str[]){
        if(n == 0){
            return;
        }
        int ld = n%10;
        n = n/10;
        convertNumToString(n, str);
        System.out.print(str[ld] + " ");
    }

    public static int stringLength(String str,int i){
        int count = 0;
        if(i == str.length()){
            return count++;
        }
        count = stringLength(str,i+1);
        count++;
        return count;
    }

    public static int countSubStrings(String str, int i, int j, int len){
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return 1;
        }
        int l_to_r_Side = countSubStrings(str, i+1,j,len-1);
        int r_to_l_Side = countSubStrings(str, i,j-1,len-1);
        int totCount = l_to_r_Side + r_to_l_Side - countSubStrings(str,i+1,j-1,len-2);

        if(str.charAt(i) == str.charAt(j)){
            totCount++;
        }
        return totCount;
    }

    public static void main(String args[]){
        // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // allOccurences(arr,2,0);

        // String str[] = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        // convertNumToString(1947,str);

        // System.out.print(stringLength("naresh",0));

        String str = "abcab";
        int len = str.length();
        System.out.print(countSubStrings(str,0,len-1,len));
    }
}