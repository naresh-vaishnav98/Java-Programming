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

    //Valid Parentheses

    public static boolean validParentheses(char arr[]){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(' || arr[i] == '{' || arr[i] == '['){
                s.push(arr[i]);
            }else if(arr[i] == ')' || arr[i] == '}' || arr[i] == ']'){
                if(s.isEmpty()){
                    return false;
                }

                if(arr[i] == ')' && s.peek() == '('){
                    s.pop();
                }else if(arr[i] == '}' && s.peek() == '{'){
                    s.pop();
                }else if(arr[i] == ']' && s.peek() == '['){
                    s.pop();
                }else{
                    return false;
                }
            }
        }

        return s.isEmpty();
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }

                if(count < 1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }

        return false;
    }


    // Max Rectangular Area in Histogram
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next smaller left
        s = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //Current Area
        for(int i = 0; i < arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea,maxArea);
        }

        System.out.println(maxArea);
    }

    //Palindrome Linked List

    public static boolean palindromeCheck(LinkedList<Character> ll){
        Stack<Character> s = new Stack<>();
        LinkedList<Character> list = new LinkedList<>();

        ListIterator<Character> iterator = ll.listIterator();
        while (iterator.hasNext()) {
            // System.out.println(iterator.next());
            s.push(iterator.next());
        }

        while(!s.isEmpty()){
            list.addLast(s.pop());
        }
        return ll.equals(list);
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

        // int arr[] = {6,8,0,1,3};
        // int nxtGreat[] = nextGreater(arr);
        // for(int i = 0; i < nxtGreat.length; i++){
        //     System.out.print(nxtGreat[i]+", ");
        // }

        // char arr[] = {'(','(',')','[',']','{','}',')'};
        // char arr[] = {'{','}','(','[',')'};
        // System.out.println(validParentheses(arr));

        // String str = "((a+b))";
        // System.out.println(isDuplicate(str));

        //Max Rectangular Area in Histogram
        // int arr[] = {2, 1, 5, 6, 2, 3};
        // maxArea(arr);


        LinkedList<Character> ll = new LinkedList<>();
        ll.addLast('A');
        ll.addLast('B');
        ll.addLast('C');
        ll.addLast('B');
        ll.addLast('A');

        System.out.println(palindromeCheck(ll));
    }
}