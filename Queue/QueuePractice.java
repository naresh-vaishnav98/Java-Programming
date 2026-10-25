import java.util.*;

public class QueuePractice{
    public static void firstNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }else{
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void interLeave2Halves(Queue<Integer> que){
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        int size = que.size();

        for(int i = 0; i < size/2; i++){
            first.add(que.remove());
        }

        for(int i = 0; i < size/2; i++){
            res.add(first.remove());
            res.add(que.remove());
        }

        while(!res.isEmpty()){
            System.out.println(res.remove());
        }
    }

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }

    public static void main(String args[]){
        //first Non Repeating
        // String str = "aabccxb";
        // firstNonRepeating(str);

        //InterLeves
        // Queue<Integer> que = new LinkedList<>();
        // que.add(1);
        // que.add(2);
        // que.add(3);
        // que.add(4);
        // que.add(5);
        // que.add(6);
        // que.add(7);
        // que.add(8);
        // que.add(9);
        // que.add(10);
        // interLeave2Halves(que);


        //Reverse queue
        // Queue<Integer> que = new LinkedList<>();
        // que.add(1);
        // que.add(2);
        // que.add(3);
        // que.add(4);
        // que.add(5);

        // reverse(que);

        //Deque
        Deque<Integer> q = new LinkedList<>();
        q.addFirst(1);
        q.addFirst(2);
        q.addLast(3);
        q.addLast(4);
        System.out.println(q);
        q.removeFirst();
        q.removeLast();
        System.out.println(q);
    }
}