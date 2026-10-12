import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q1 = new PriorityQueue<>();
        q1.offer(8);
        q1.offer(7);
        q1.offer(5);
        q1.offer(10);
        
        
        
        // System.out.println(q1.remove());
        // System.out.println(q1.peek());
        
        Queue<String> q2 = new PriorityQueue<>(10, (s1, s2) -> s2.compareTo(s1));
        q2.offer("Java");
        q2.offer("Python");
        q2.offer("Javascript");
        q2.offer("C++");
        
        
        
        // System.out.println(q2.poll());
        // System.out.println(q2.peek());
        System.out.println(q1);
        System.out.println(q2);
    }
}