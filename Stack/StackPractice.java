import java.util.*;

public class StackPractice{
    
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        String res = "";
        while(!s.isEmpty()){
            char ch = s.pop();
            res = res + ch;
        }
        return res;
    }

    public static void main(String args[]){
        // System.out.println("Hello");
        
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // pushAtBottom(s,4);

        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }

        
        System.out.println(reverseString("Naresh"));
    }
}