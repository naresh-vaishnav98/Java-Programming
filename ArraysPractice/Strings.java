import java.util.*;
import java.util.Arrays;

public class Strings{
    public static int lowercaseVowels(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                count++;
            }
        }
        return count;
    }

    public static void anagrams(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length() == str2.length()){
            char [] str1CharArray = str1.toCharArray();
            char [] str2CharArray = str2.toCharArray();

            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            if(Arrays.equals(str1CharArray,str2CharArray)){
                System.out.print(str1 + " and " + str2 + " are anagrams of each other");
            }else{
                System.out.print(str1 + " and " + str2 + " are not anagrams of each other");
            }
        }else{
            System.out.print(str1 + " and " + str2 + " are not anagrams of each other");
        }
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        // String str = sc.nextLine();
        // System.out.print(lowercaseVowels(str));

        anagrams("Care", "Case");
    }
}