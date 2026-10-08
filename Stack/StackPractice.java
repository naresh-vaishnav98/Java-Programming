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

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int data = s.pop();
        reverseStack(s);
        // s.push(data);
        pushAtBottom(s,data);
    }

    public static void stockSpan(int stock[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i < stock.length; i++){
            int currPrice = stock[i];
            while(!s.isEmpty() && currPrice > stock[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i] = i+1;
            } else {
                int preHigh = s.peek();
                span[i] = i - preHigh;
            }

            s.push(i);
        }
    }

    public static int[] nextGreater(int arr[]){
        int nxtGreat[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){
            while(!s.isEmpty() && arr[i] >= s.peek()){
                s.pop();
            }

            if(s.isEmpty()){
                nxtGreat[i] = -1;
            }else{
                nxtGreat[i] = s.peek();
            }

            s.push(arr[i]);
        }

        return nxtGreat;
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

        
        // System.out.println(reverseString("Naresh"));

        // reverseStack(s);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }


        //Stock Span
        // int stock[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stock.length];

        // stockSpan(stock,span);
        // for(int i = 0; i < span.length; i++){
        //     System.out.println(span[i]);
        // }


        //Next Greater Element

        int arr[] = {6,8,0,1,3};
        int nxtGreat[] = nextGreater(arr);
        for(int i = 0; i < nxtGreat.length; i++){
            System.out.print(nxtGreat[i]+", ");
        }
    }
}